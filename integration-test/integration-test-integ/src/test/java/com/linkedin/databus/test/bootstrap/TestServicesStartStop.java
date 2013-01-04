package com.linkedin.databus.test.bootstrap;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.linkedin.databus.test.DatabusBaseIntegTest;
import com.linkedin.databus.test.ExternalCommand;


@Test(singleThreaded=true)
public class TestServicesStartStop extends DatabusBaseIntegTest
{
  @Override
  @BeforeMethod
  public void setUp() throws Exception
  {
    setTestName("TestServicesStartStop");
    setupLogger();
    loadSystemProperties();
    LOG.info("Setup Complete" + getTestName());
  }

  @Override
  @AfterMethod
  public void tearDown() throws Exception
  {
    LOG.info("Test Complete" + getTestName());
  }

  @Test
  public void testRelayService() throws IOException, InterruptedException, TimeoutException
  {
    ExternalCommand cmd = null;

    // START
    cmd = ExternalCommand.executeWithTimeout(_scriptDir,
                                             DRIVER_SCRIPT_NAME,
                                             EXEC_TIMEOUT,
                                             COMPONENT_OPTION_STR,
                                             RELAY_SERVICE_COMPONENT,
                                             SERVICE_OPERATION_OPTION_STR,
                                             SERVICE_OPERATION_START,
                                             RELAY_PROPERTY_OPTION_STR,
                                             RELAY_PROPERTY_NAME);
    if (0 != cmd.exitValue())
    {
      fail(cmd.getStringOutput());
    }

    // START another one, it shall fail.
    cmd = ExternalCommand.executeWithTimeout(_scriptDir,
                                             DRIVER_SCRIPT_NAME,
                                             EXEC_TIMEOUT,
                                             COMPONENT_OPTION_STR,
                                             RELAY_SERVICE_COMPONENT,
                                             SERVICE_OPERATION_OPTION_STR,
                                             SERVICE_OPERATION_START,
                                             RELAY_PROPERTY_OPTION_STR,
                                             RELAY_PROPERTY_NAME);
 //   System.out.println(cmd.getStringOutput());
    Assert.assertFalse((0 == cmd.exitValue()), RELAY_SERVICE_COMPONENT + " started twice.");

    // STOP
    cmd = ExternalCommand.executeWithTimeout(_scriptDir,
                                             DRIVER_SCRIPT_NAME,
                                             EXEC_TIMEOUT,
                                             COMPONENT_OPTION_STR,
                                             RELAY_SERVICE_COMPONENT,
                                             SERVICE_OPERATION_OPTION_STR,
                                             SERVICE_OPERATION_STOP,
                                             RELAY_PROPERTY_OPTION_STR,
                                             RELAY_PROPERTY_NAME);
    if (0 != cmd.exitValue())
    {
      fail(cmd.getStringOutput());
    }
  }

  @Test
  public void testBootstrapService() throws IOException, InterruptedException, TimeoutException
  {
    ExternalCommand cmd = null;

    // START
    cmd = ExternalCommand.executeWithTimeout(_scriptDir,
                                             DRIVER_SCRIPT_NAME,
                                             EXEC_TIMEOUT,
                                             COMPONENT_OPTION_STR,
                                             BOOTSTRAP_SERVICE_COMPONENT,
                                             SERVICE_OPERATION_OPTION_STR,
                                             SERVICE_OPERATION_START,
                                             BOOTSTRAP_PROPERTY_OPTION_STR,
                                             _bootstrapServiceConfigFile);
    if (0 != cmd.exitValue())
    {
      fail(cmd.getStringOutput());
    }

    // START another one, it shall fail.
    cmd = ExternalCommand.executeWithTimeout(_scriptDir,
                                             DRIVER_SCRIPT_NAME,
                                             EXEC_TIMEOUT,
                                             COMPONENT_OPTION_STR,
                                             BOOTSTRAP_SERVICE_COMPONENT,
                                             SERVICE_OPERATION_OPTION_STR,
                                             SERVICE_OPERATION_START,
                                             RELAY_PROPERTY_OPTION_STR,
                                             RELAY_PROPERTY_NAME);
    Assert.assertFalse((0 == cmd.exitValue()), BOOTSTRAP_SERVICE_COMPONENT + " started twice.");

    // STOP
    cmd = ExternalCommand.executeWithTimeout(_scriptDir,
                                             DRIVER_SCRIPT_NAME,
                                             EXEC_TIMEOUT,
                                             COMPONENT_OPTION_STR,
                                             BOOTSTRAP_SERVICE_COMPONENT,
                                             SERVICE_OPERATION_OPTION_STR,
                                             SERVICE_OPERATION_STOP,
                                             BOOTSTRAP_PROPERTY_OPTION_STR,
                                             _bootstrapServiceConfigFile);
    if (0 != cmd.exitValue())
    {
      fail(cmd.getStringOutput());
    }
  }
}
