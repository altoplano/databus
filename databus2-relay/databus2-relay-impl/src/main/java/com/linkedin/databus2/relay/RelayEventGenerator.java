package com.linkedin.databus2.relay;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.Encoder;
import org.apache.log4j.Logger;
import org.xeril.util.TimeOutException;

import com.linkedin.databus.client.generic.DatabusGenericClient;
import com.linkedin.databus.core.DbusEventBuffer;
import com.linkedin.databus.core.DbusEventBufferAppendable;
import com.linkedin.databus.core.DbusEventKey;
import com.linkedin.databus.core.UnsupportedKeyException;
import com.linkedin.databus.core.monitoring.mbean.DbusEventsStatisticsCollector;
import com.linkedin.databus.core.util.InvalidConfigException;
import com.linkedin.databus.core.util.RngUtils;
import com.linkedin.databus.eventgenerator.DataGenerator;
import com.linkedin.databus.eventgenerator.UnknownTypeException;
import com.linkedin.databus2.core.DatabusException;
import com.linkedin.databus2.core.seq.MaxSCNReaderWriter;
import com.linkedin.databus2.producers.EventProducer;
import com.linkedin.databus2.relay.config.LogicalSourceStaticConfig;
import com.linkedin.databus2.relay.config.PhysicalSourceStaticConfig;
import com.linkedin.databus2.schemas.NoSuchSchemaException;
import com.linkedin.databus2.schemas.SchemaRegistryService;
import com.linkedin.databus2.schemas.utils.SchemaHelper;

/**
 * 
 * @author snagaraj Mock generator of events given a physical source schema
 */

public class RelayEventGenerator implements EventProducer
{

	public enum State
	{
		INIT, PAUSED, RUNNING, SHUTDOWN
	};

	public final static String MODULE = RelayEventGenerator.class.getName();
	public final static Logger LOG = Logger.getLogger(MODULE);

	private final SchemaRegistryService _schemaRegistryService;
	private final DbusEventBufferAppendable _buffer;
	private final PhysicalSourceStaticConfig _pConfig;
	private final DbusEventsStatisticsCollector _statsCollector;
	private final MaxSCNReaderWriter _scnReaderWriter;
	private final long _eventRatePerSec;
	private final HashMap<String, DataGenerator> _dataGenerators;
	private final HashMap<String, byte[]> _schemaIds;
	private final HashMap<String, String> _schemaKeys;
	private long _scn = RngUtils.randomPositiveLong(2, 50000);
	private State _state = State.INIT;
	boolean _shutdownRequested = false;
	boolean _pauseRequested = false;
	Thread _worker;
	private final Lock _pauseLock = new ReentrantLock();
	private final Condition _pausedCondition = _pauseLock.newCondition();

	public RelayEventGenerator(PhysicalSourceStaticConfig pConfig,
			SchemaRegistryService schemaRegistryService,
			DbusEventBufferAppendable dbusEventBuffer,
			DbusEventsStatisticsCollector statsCollector,
			MaxSCNReaderWriter scnReaderWriter)
	{
		_pConfig = pConfig;
		_schemaRegistryService = schemaRegistryService;
		_buffer = dbusEventBuffer;
		_statsCollector = statsCollector;
		_eventRatePerSec = pConfig.getEventRatePerSec();
		_dataGenerators = new HashMap<String, DataGenerator>(5);
		_schemaIds = new HashMap<String, byte[]>(5);
		_schemaKeys = new HashMap<String, String>(5);
		_scnReaderWriter = scnReaderWriter;
		for (LogicalSourceStaticConfig lconf : pConfig.getSources())
		{
			try
			{
				String schema = _schemaRegistryService
						.fetchLatestSchemaByType(lconf.getName());
				_dataGenerators.put(lconf.getName(), new DataGenerator(schema));
				_schemaIds.put(lconf.getName(),
						SchemaHelper.getSchemaId(schema));
				Schema eventSchema = Schema.parse(schema);
				String keyColumnName = "key";
				String keyNameOverride = SchemaHelper.getMetaField(eventSchema,
						"pk");
				if (null != keyNameOverride)
				{
					keyColumnName = keyNameOverride;
				}
				_schemaKeys.put(lconf.getName(), keyColumnName);
			}
			catch (NoSuchSchemaException e)
			{
				LOG.error("Cannot find schema for " + lconf.getName() + " " + e);
			}
			catch (DatabusException e)
			{
				LOG.error("Databus exception while attempting to find schema for "
						+ lconf.getName() + " " + e);
			}
		}

	}

	@Override
	public synchronized void shutdown()
	{
		_shutdownRequested = true;
		if (_worker != null)
			_worker.interrupt();
		LOG.warn("Shut down request sent to thread");
	}

	@Override
	public synchronized void waitForShutdown() throws InterruptedException,
			IllegalStateException
	{
		if (_state != State.SHUTDOWN)
		{
			if (_worker != null)
				_worker.join();
		}
	}

	@Override
	public synchronized void waitForShutdown(long timeout)
			throws InterruptedException, IllegalStateException,
			TimeOutException
	{
		if (_state != State.SHUTDOWN)
		{
			if (_worker != null)
				_worker.join(timeout);
		}
	}

	@Override
	public String getName()
	{
		return _pConfig.getName() + ".mock";
	}

	@Override
	public long getSCN()
	{
		return _scn;
	}

	@Override
	public synchronized void start(long sinceSCN)
	{
		if (_state != State.RUNNING)
		{
			if (sinceSCN > 0)
			{
				_scn = sinceSCN;
			}
			else
			{
				if (_scnReaderWriter != null)
				{
					try
					{
						long scn = _scnReaderWriter.getMaxScn();
						if (scn > 0)
						{
							_scn =scn;
						}
					}
					catch (DatabusException e)
					{
						LOG.warn("Could not read saved maxScn: Defaulting to random startSCN="
								+ _scn);
					}
				}
			}
			LOG.info("Starting with scn=" + _scn);
			_worker = new WorkerThread();
			_worker.setDaemon(true);
			_worker.start();
		}
		else
		{
			LOG.error("Thread already running! ");
		}
	}

	@Override
	public synchronized boolean isRunning()
	{
		return _state == State.RUNNING;
	}

	@Override
	public synchronized boolean isPaused()
	{
		return _state == State.PAUSED;
	}

	@Override
	public synchronized void unpause()
	{
		_pauseLock.lock();
		_pauseRequested = false;
		_pausedCondition.signalAll();
		_pauseLock.unlock();
	}

	@Override
	public synchronized void pause()
	{
		_pauseLock.lock();
		_pauseRequested = true;
		_pauseLock.unlock();
	}

	

	int populateEvents(String source, short id, GenericRecord record,
			DbusEventKey key, byte[] schemaId,
			DbusEventsStatisticsCollector statsCollector,
			DbusEventBufferAppendable buffer)
	{
		if (record != null && key != null)
		{
			try
			{
				// Serialize the row
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				Encoder encoder = new BinaryEncoder(bos);
				GenericDatumWriter<GenericRecord> writer = new GenericDatumWriter<GenericRecord>(
						record.getSchema());
				writer.write(record, encoder);
				byte[] serializedValue = bos.toByteArray();

				short pPartitionId = RngUtils.randomPositiveShort();
				short lPartitionId = RngUtils.randomPositiveShort();

				long timeStamp = System.currentTimeMillis() * 1000000;
				buffer.appendEvent(key, pPartitionId, lPartitionId, timeStamp,
						id, schemaId, serializedValue, false, statsCollector);
				return 1;
			}
			catch (IOException io)
			{
				LOG.error("Cannot create byte stream payload: " + source);
			}
		}
		return 0;
	}

	private class WorkerThread extends Thread
	{

		// only one such method can exist as start() is synchronized
		@Override
		public void run()
		{

			_state = RelayEventGenerator.State.RUNNING;
			_buffer.start(_scn-1);
			while (!_shutdownRequested)
			{
				_pauseLock.lock();
				if (_pauseRequested
						&& _state != RelayEventGenerator.State.PAUSED)
				{
					_state = RelayEventGenerator.State.PAUSED;
					LOG.warn("Pausing event generator");
					while (_state == RelayEventGenerator.State.PAUSED
							&& !_shutdownRequested
							&& _pauseRequested)
					{
						try
						{
							_pausedCondition.await();
						}
						catch (InterruptedException e)
						{
							LOG.warn("Paused thread interrupted! Shutdown requested="
									+ _shutdownRequested);
						}
					}
				}
				_pauseLock.unlock();
				if (!_shutdownRequested)
				{
					_state = RelayEventGenerator.State.RUNNING;
				}
				if (_state == RelayEventGenerator.State.RUNNING)
				{
					_buffer.startEvents();
					// generate events
					long cycleDurationMs = _pConfig.getRetries().getInitSleep();
					long numEventsToGenerate = (long) (_eventRatePerSec
							* cycleDurationMs / 1000.0);
					long startTime = System.currentTimeMillis();
					long totalEvents = 0;
					for (LogicalSourceStaticConfig lconf : _pConfig
							.getSources())
					{
						for (long i = 0; i < numEventsToGenerate; ++i)
						{
							DataGenerator d = _dataGenerators.get(lconf
									.getName());
							GenericRecord record = null;
							try
							{
								record = d.generateRandomRecord();
							}
							catch (UnknownTypeException e)
							{
								LOG.error("Could not generate record for source: "
										+ lconf.getName());
								continue;
							}
							DbusEventKey eventKey = null;
							try
							{
								Object key = record.get(_schemaKeys.get(lconf
										.getName()));
								eventKey = new DbusEventKey(key);
							}
							catch (UnsupportedKeyException e)
							{
								LOG.error("Unable to get key for "
										+ lconf.getName());
							}
							totalEvents += populateEvents(lconf.getName(),
									lconf.getId(), record, eventKey,
									_schemaIds.get(lconf.getName()),
									_statsCollector, _buffer);
						}
					}
					_buffer.endEvents(_scn, _statsCollector);
					long timeTaken = System.currentTimeMillis() - startTime;
					LOG.debug("Time taken to populate " + totalEvents + " = "
							+ timeTaken);
					long timeLeft = cycleDurationMs - timeTaken;
					if (timeLeft > 0)
					{
						try
						{

							Thread.sleep(timeLeft);
						}
						catch (InterruptedException e)
						{
							LOG.error("Thread interrupted from sleep: state="
									+ _state);
						}
					}
					if (_scnReaderWriter != null)
					{
						try
						{
							_scnReaderWriter.saveMaxScn(_scn);
						}
						catch (DatabusException e)
						{
							LOG.error("Cannot save scn!");
						}
					}
					_scn += RngUtils.randomPositiveLong(1, 100000);
				}
			}// end of while
			_state = RelayEventGenerator.State.SHUTDOWN;
		} // end of run()
	}// end of thread class
}
