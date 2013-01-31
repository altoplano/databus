/*
 * $Id: PartitionFunction.java 153291 2010-12-02 20:40:47Z jwesterm $
 */
package com.linkedin.databus2.producers;
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


import com.linkedin.databus.core.DbusEventKey;
import com.linkedin.databus.core.UnsupportedKeyException;

/**
 * Interface to return the partition for a given key.
 *
 * @author Jemiah Westerman<jwesterman@linkedin.com>
 * @version $Revision: 153291 $
 */
public interface PartitionFunction
{
  /**
   * Return the partition for the given key.
   * @param key
   * @return the partition for the given key
   * @throws UnsupportedKeyException if key is an unsupported key type
   */
  public short getPartition(DbusEventKey key)
  throws UnsupportedKeyException;
}
