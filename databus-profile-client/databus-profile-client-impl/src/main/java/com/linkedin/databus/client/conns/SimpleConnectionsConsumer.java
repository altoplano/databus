package com.linkedin.databus.client.conns;
/*
 *
 * Copyright 2013 LinkedIn Corp. All rights reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
*/


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.linkedin.databus.client.generic.DatabusFileLoggingConsumer;
import com.linkedin.databus.client.generic.SimpleFileLoggingConsumer;

public class SimpleConnectionsConsumer extends SimpleFileLoggingConsumer {

  public static final String MODULE = SimpleConnectionsConsumer.class.getName();
  public static final Logger LOG = Logger.getLogger(MODULE);

  public static final String CONNECTIONS_SOURCE_NAME = "com.linkedin.events.conns.Connections";

  @Override
  protected String[] addSources()
  {
	String[] sources =  new String[] {CONNECTIONS_SOURCE_NAME};
    return sources;
  }

  @Override
  protected DatabusFileLoggingConsumer createTypedConsumer(String valueDumpFile) throws IOException
  {
    return new DatabusConnectionsConsumer(valueDumpFile);
  }
  public static void main(String args[]) throws Exception
  {
    SimpleConnectionsConsumer simpleProfileConsumer = new SimpleConnectionsConsumer();
    simpleProfileConsumer.mainFunction(args);
  }

}
