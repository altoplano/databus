/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.linkedin.events.liar;
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


@SuppressWarnings("all")
/** Auto-generated Avro schema for sy$liar_news_relay. Generated at Nov 26, 2012 12:08:54 PM PST */
public class LiarNewsRelay_V1 extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = org.apache.avro.Schema.parse("{\"type\":\"record\",\"name\":\"LiarNewsRelay_V1\",\"namespace\":\"com.linkedin.events.liar\",\"fields\":[{\"name\":\"txn\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=TXN;dbFieldPosition=0;\"},{\"name\":\"key\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=KEY;dbFieldPosition=1;\"},{\"name\":\"eventId\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=EVENT_ID;dbFieldPosition=2;\"},{\"name\":\"isDelete\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=IS_DELETE;dbFieldPosition=3;\"}],\"meta\":\"dbFieldName=sy$liar_news_relay;\"}");
  public java.lang.Long txn;
  public java.lang.Long key;
  public java.lang.Long eventId;
  public java.lang.CharSequence isDelete;
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return txn;
    case 1: return key;
    case 2: return eventId;
    case 3: return isDelete;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: txn = (java.lang.Long)value$; break;
    case 1: key = (java.lang.Long)value$; break;
    case 2: eventId = (java.lang.Long)value$; break;
    case 3: isDelete = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
}
