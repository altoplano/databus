package com.linkedin.databus.relay.bizfollow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.Encoder;
import org.apache.log4j.Logger;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBufferOutputStream;
import org.jboss.netty.buffer.ChannelBuffers;

import com.linkedin.databus.core.DbusEventBufferAppendable;
import com.linkedin.databus.core.DbusEventBufferMult;
import com.linkedin.databus.core.DbusEventKey;
import com.linkedin.databus.core.KeyTypeNotImplementedException;
import com.linkedin.databus.core.monitoring.mbean.DbusEventsStatisticsCollector;
import com.linkedin.databus.core.util.DatabusEventRandomProducer;
import com.linkedin.databus.core.util.IdNamePair;
import com.linkedin.databus.core.util.RngUtils;
import com.linkedin.databus2.core.DatabusException;
import com.linkedin.databus2.schemas.NoSuchSchemaException;
import com.linkedin.databus2.schemas.SchemaRegistryService;
import com.linkedin.databus2.schemas.utils.Utils;


public class DatabusEventBizFollowRandomProducer extends DatabusEventRandomProducer {

  public static final String MODULE = DatabusEventBizFollowRandomProducer.class.getName();
  public static final Logger LOG = Logger.getLogger(MODULE);
  private static final String FULLY_QUALIFIED_BIZFOLLOW_EVENT_NAME = "com.linkedin.events.bizfollow.bizfollow.BizFollow";
  private static final int BIZFOLLOW_SRC_ID = 40;
  private final SchemaRegistryService schemaRegistryService;
  private Map<Short,Map<Long,Long>> _srcKeyScnMaps = null;
  private long _sumKey = 0;
  private long _sumScn = 0;
  private boolean _equalSumScnAndKeyDistribution;

  public DatabusEventBizFollowRandomProducer(DbusEventBufferMult  dbuf,
		                                   int              eventsPerSecond,
		                                   long             durationInMilliseconds,
		                                   List<IdNamePair> sources,
		                                   SchemaRegistryService schemaRegistryService) {
	  this(dbuf,eventsPerSecond,durationInMilliseconds,sources,schemaRegistryService,null);
  }

  public DatabusEventBizFollowRandomProducer(DbusEventBufferMult dbuf,
                                           int eventsPerSecond,
                                           long durationInMilliseconds,
                                           List<IdNamePair> sources,
                                           SchemaRegistryService schemaRegistryService,
                                           DatabusEventRandomProducer.StaticConfig config) {

      //TODO (Medium) (DDSDBUS-65) : Fix start scn as a input?
      super(dbuf, 2, eventsPerSecond, durationInMilliseconds, sources, config);

      this.schemaRegistryService = schemaRegistryService;

      _equalSumScnAndKeyDistribution = false;
      LOG.info("_generationPattern = " + _generationPattern);
      if (_generationPattern. compareTo("EqualSumScnAndKey") == 0)
      {
        _equalSumScnAndKeyDistribution = true;
        // set up key set
        _srcKeyScnMaps = new HashMap<Short,Map<Long,Long>>();
        for (int i=0; i< sources.size(); i++)
        {
          HashMap<Long,Long> srcKeyScnMap= new HashMap<Long,Long>();
          Short srcId = sources.get(i).getId().shortValue();
          _srcKeyScnMaps.put(srcId, srcKeyScnMap);
        }
        LOG.info("_generation" +
        		"Pattern = use EuqalSumeScnAndKey Distribution");
      }
      LOG.info("_generationPattern = " + _generationPattern);
	}

    public static byte[] produceOneBizFollowEvent(Schema s, int minLength, int maxLength)
    {
      //TODO (Medium) (DDSDBUS-66) : reduce "new"s
      ChannelBuffer cb = ChannelBuffers.dynamicBuffer(300);
      ChannelBufferOutputStream cbos = new ChannelBufferOutputStream(cb);

      int rnd = RngUtils.randomPositiveShort();
      int length = minLength + rnd % (maxLength - minLength);

      GenericDatumWriter<GenericRecord> w = new GenericDatumWriter<GenericRecord>(s);

  //      BinaryEncoder e = new BinaryEncoder(cbos);
          GenericRecord r = new GenericData.Record(s);

          r.put("id", RngUtils.randomPositiveInt());
          r.put("memberId", RngUtils.randomPositiveInt());
          r.put("companyId", RngUtils.randomPositiveInt());
          r.put("notifyOptions", new org.apache.avro.util.Utf8(RngUtils.randomString(length)));
          r.put("notifyNus", RngUtils.randomPositiveInt());
          r.put("source", RngUtils.randomPositiveInt());
          r.put("status", new org.apache.avro.util.Utf8(RngUtils.randomString(10)));
          r.put("createdOn", RngUtils.randomPositiveLong());
          r.put("lastModified", RngUtils.randomPositiveLong());
          r.put("txn", RngUtils.randomPositiveInt());
          //r.put("creatorName", new org.apache.avro.util.Utf8(RngUtils.randomString(4)));

          try {
            //TODO (DDSDBUS-67): make encoding parameterized
              Encoder e = new BinaryEncoder(cbos);
//                Encoder e = new JsonEncoder(s, cbos);
              w.write(r, e);
              e.flush();
          } catch (IOException e2) {
    		  LOG.error("Got exception while encoding !!", e2);
          }

      return cbos.buffer().array();
    }
    @Override
    public long produceNRandomEvents(long startScn, long currentTime, int numberOfEvents, List<IdNamePair> sources, long keyMin, long keyMax, int minLength, int maxLength, List<Schema> schemas) throws KeyTypeNotImplementedException
    {
      Schema s = schemas.get(0);
      short srcId = BIZFOLLOW_SRC_ID;
      long maxScn = 0;
      try
      {
        maxScn = produceNBizFollowEvents(startScn, currentTime, numberOfEvents, keyMin, keyMax, srcId, s);
      }
      catch (IOException e)
      {
		  LOG.error("Got exception while producing N events!!", e);
      }
      return maxScn;
    }

    public ArrayList<Long> calculateKeysInAWindow(long endScn,
                                             int numberOfEvents,
                                             long keyMin,
                                             long keyMax,
                                             short srcId)
    {
      ArrayList <Long> keysInWindow = new ArrayList<Long>(numberOfEvents);
      Map<Long,Long> srcKeyScnMap = _srcKeyScnMaps.get(srcId);
      boolean done = false;
      long sumKey = 0;

      while (!done)
      {
        keysInWindow.clear();
        long sumKeyDiff = 0;
        sumKey = 0;
        long keyDiff;
        long key;
        int i;
        for (i = 0; i < numberOfEvents; ++i)
        {
          if (i%2 == 0)
          {
            keyDiff = RngUtils.randomPositiveLong(1, endScn) - endScn;
          }
          else
          {
            keyDiff = RngUtils.randomPositiveLong(endScn, endScn * 2) - endScn;
          }
          if (i == numberOfEvents-1)
          {
            keyDiff =  -sumKeyDiff;   // make the sum 0
            key = keyDiff + endScn;
            if (key < 0)
            {
//              LOG.info("Calculate Key: Minus key: endScn = " + endScn + ", recalculate key = " + key);
              break;   // do it again
            }
          }
          key = keyDiff + endScn;
//          LOG.info("Calculate Key: endScn = " + endScn + ", i = " + i + ", key = " + key + ", sumkey = " + sumKey + ", sumKeyDiff = " + sumKeyDiff);
          if (srcKeyScnMap.containsKey(key) || keysInWindow.indexOf(key) !=-1 )  // has the key
          {
//            LOG.info("Calculate Key: endScn = " + endScn + ", duplicate key = " + key);
            if (i == numberOfEvents-1)
            {
//              LOG.info("Calculate Key: endScn = " + endScn + ", recalculate key = " + key);
              break;   // do it again
            }
            if (keysInWindow.indexOf(key) != -1)
            {
//              sumKeyDiff -= endScn;  // We will have one key less
              sumKeyDiff -= 0;  // We will have one key less
            }
            else
            {
              sumKeyDiff -= (endScn - srcKeyScnMap.get(key));  // this key will replace the previous key->scn
            }
          }
          else   // new key do the sum
          {
            sumKeyDiff += keyDiff;
            sumKey += key;
          }
          keysInWindow.add(key);
        }
        if (i == numberOfEvents)   // get out of the inner loop ok
        {
          done = true;
        }
      }
//      LOG.info("Calculate Key: endScn = " + endScn + ", sumKey = " + sumKey + ", endScn * numberOfEvents =" + endScn * numberOfEvents);
//      assert(sumKey == (endScn * numberOfEvents));     // should be the same
      for (Long key: keysInWindow)
      {
        long oldScn = 0;
        if (srcKeyScnMap.containsKey(key))
        {
          oldScn = srcKeyScnMap.get(key);
        }
        else
        {
          _sumKey += key;    // add the key
        }
        _sumScn += (endScn - oldScn);
        srcKeyScnMap.put(key, endScn);
      }
      LOG.info("==EventPattern: scn = " + endScn + ", _sumScn = " + _sumScn + ", _sumKey = " + _sumKey);
      assert(_sumKey == _sumScn);     // should be the same
      return keysInWindow;
    }

	public long produceNBizFollowEvents(long startScn,
	                                  long currentTime,
	                                  int numberOfEvents,
	                                  long keyMin,
	                                  long keyMax,
	                                  short srcId,
	                                  Schema schema) throws IOException {
	  long endScn;
	  if (_equalSumScnAndKeyDistribution)
	  {
	    endScn = startScn + numberOfEvents - 1; // end scn should be the same with max scn
	  }
	  else
	  {
	    endScn = startScn + 1 + (RngUtils.randomPositiveLong() % 100L); // random number between startScn and startScn + 100;
	  }
	  // get the right buffer by srcId
	  LOG.info("getting DbusEventBuffer for source: " + srcId);
	  short pPartitionId = _dbusEventBuffer.getPhysicalPartition(srcId).getId().shortValue();
	  DbusEventBufferAppendable buf = _dbusEventBuffer.getDbusEventBufferAppendable(srcId);
	    long scnDiff = endScn - startScn;
	    long maxScn = startScn;
		buf.startEvents();
		assert(endScn > startScn);
		if (scnDiff < 0) {
		  LOG.info("endScn = " + endScn + " startScn = " + startScn);
		}

		byte[] schemaId = Utils.md5(schema.toString().getBytes());

		ArrayList <Long> keysInWindow = null;
		if (_equalSumScnAndKeyDistribution)
		{
		  keysInWindow = calculateKeysInAWindow(endScn, numberOfEvents, keyMin, keyMax, srcId);
		}
		long key;
		long scn;
		for (int i = 0; i < numberOfEvents; ++i) {
		  if (_equalSumScnAndKeyDistribution)
		  {
		    key = keysInWindow.get(i);
		    scn = startScn + i;
		  }
		  else
		  {
		    key = RngUtils.randomPositiveLong(keyMin, keyMax);
		    scn = startScn + (RngUtils.randomPositiveLong() % scnDiff);
		   }
		  byte[] value = produceOneBizFollowEvent(schema, _minLength, _maxLength); // ~60 + (max-min) of row data
		  short lPartitionId = (short) (key % Short.MAX_VALUE);
		  boolean enableTracing = (RngUtils.randomPositiveShort()%100 <=1);  // sample 1% of events for tracing
//		  boolean enableTracing = false;
		  assert(buf.appendEvent(new DbusEventKey(key), pPartitionId, lPartitionId, currentTime,
		                             srcId, schemaId, value,  enableTracing, _statsCollector));
		  maxScn = Math.max(scn, maxScn);
		  LOG.info("Produce: endScn = "+endScn + ", key=" + key);
		}
		if (_equalSumScnAndKeyDistribution)
		{
		  assert(endScn == maxScn);     // should be the same
		}
		buf.endEvents(maxScn,_statsCollector);
		LOG.info("Produce:window:" + maxScn);
		assert(maxScn >= startScn);
		return maxScn;
	}

	private void getSchemas()
	{
	  short srcId=0;

	  String schema;
	  Schema s = null;
	  try
	  {
	    schema = schemaRegistryService.fetchLatestSchemaByType(FULLY_QUALIFIED_BIZFOLLOW_EVENT_NAME);
	    s = Schema.parse(schema);
	  }
	  catch (NoSuchSchemaException e2)
	  {
		  LOG.error("Got exception while fetching latest Schema !!", e2);
	  }
	  catch (DatabusException e2)
	  {
		  LOG.error("Got exception while fetching latest Schema !!", e2);
	  }
	  if (_schemas == null)
	  {
	    _schemas = new ArrayList<Schema>();
	  }
	  _schemas.add(s);

	  for (IdNamePair namePair: _sources)
	  {
	    if (namePair.getName().equals(FULLY_QUALIFIED_BIZFOLLOW_EVENT_NAME)) {
	      srcId = namePair.getId().shortValue();
	    }
	  }

	  if ( (null == s) || ( srcId <= 0) )
	  {
	    // Error
	    LOG.error(" Schema is NULL or srcId is not positive. Stopping Gen");
	    return;
	  }
	}

	@Override

	public boolean startGeneration(long startScn,
	                               int eventsPerSecond,
	                               long durationInMilliseconds,
	                               long numEventToGenerate,
	                               int percentOfBufferToGenerate,
	                               long keyMin,
	                               long keyMax,
	                               List<IdNamePair> sources,
	                               DbusEventsStatisticsCollector statsCollector) {
        getSchemas();   // get the schema
        return super.startGeneration(startScn, eventsPerSecond, durationInMilliseconds,
                                     numEventToGenerate, percentOfBufferToGenerate,
                                     keyMin, keyMax,
                                     sources, statsCollector);
	}

}
