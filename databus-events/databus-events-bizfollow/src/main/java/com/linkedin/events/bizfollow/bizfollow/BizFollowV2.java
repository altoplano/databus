/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.linkedin.events.bizfollow.bizfollow;
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
/** Auto-generated Avro schema for SY$BIZ_FOLLOW. Generated at Apr 19, 2011 06:22:31 PM PDT */
public class BizFollowV2 extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = org.apache.avro.Schema.parse("{\"type\":\"record\",\"name\":\"BizFollowV2\",\"namespace\":\"com.linkedin.events.bizfollow.bizfollow\",\"fields\":[{\"name\":\"txn\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=TXN;dbFieldPosition=0;\"},{\"name\":\"id\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=ID;dbFieldPosition=1;\"},{\"name\":\"memberId\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=MEMBER_ID;dbFieldPosition=2;\"},{\"name\":\"companyId\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=COMPANY_ID;dbFieldPosition=3;\"},{\"name\":\"notifyOptions\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=NOTIFY_OPTIONS;dbFieldPosition=4;\"},{\"name\":\"notifyNus\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=NOTIFY_NUS;dbFieldPosition=5;\"},{\"name\":\"source\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=SOURCE;dbFieldPosition=6;\"},{\"name\":\"status\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=STATUS;dbFieldPosition=7;\"},{\"name\":\"createdOn\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=CREATED_ON;dbFieldPosition=8;\"},{\"name\":\"lastModified\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=LAST_MODIFIED;dbFieldPosition=9;\"},{\"name\":\"creatorName\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=CREATOR_NAME;dbFieldPosition=10;\"}],\"meta\":\"dbFieldName=SY$BIZ_FOLLOW;\"}");
  public java.lang.Integer txn;
  public java.lang.Integer id;
  public java.lang.Integer memberId;
  public java.lang.Integer companyId;
  public java.lang.CharSequence notifyOptions;
  public java.lang.Integer notifyNus;
  public java.lang.Integer source;
  public java.lang.CharSequence status;
  public java.lang.Long createdOn;
  public java.lang.Long lastModified;
  public java.lang.CharSequence creatorName;
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return txn;
    case 1: return id;
    case 2: return memberId;
    case 3: return companyId;
    case 4: return notifyOptions;
    case 5: return notifyNus;
    case 6: return source;
    case 7: return status;
    case 8: return createdOn;
    case 9: return lastModified;
    case 10: return creatorName;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: txn = (java.lang.Integer)value$; break;
    case 1: id = (java.lang.Integer)value$; break;
    case 2: memberId = (java.lang.Integer)value$; break;
    case 3: companyId = (java.lang.Integer)value$; break;
    case 4: notifyOptions = (java.lang.CharSequence)value$; break;
    case 5: notifyNus = (java.lang.Integer)value$; break;
    case 6: source = (java.lang.Integer)value$; break;
    case 7: status = (java.lang.CharSequence)value$; break;
    case 8: createdOn = (java.lang.Long)value$; break;
    case 9: lastModified = (java.lang.Long)value$; break;
    case 10: creatorName = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
}
