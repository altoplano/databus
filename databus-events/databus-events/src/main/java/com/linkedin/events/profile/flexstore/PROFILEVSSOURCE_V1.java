/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.linkedin.events.profile.flexstore;

@SuppressWarnings("all")
/** Auto-generated Avro schema for sy$PROFILE_VS_SOURCE. Generated at Aug 15, 2012 03:23:00 PM PDT */
public class PROFILEVSSOURCE_V1 extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = org.apache.avro.Schema.parse("{\"type\":\"record\",\"name\":\"PROFILEVSSOURCE_V1\",\"namespace\":\"com.linkedin.events.profile.flexstore\",\"fields\":[{\"name\":\"txn\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=TXN;dbFieldPosition=0;\"},{\"name\":\"key\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=KEY;dbFieldPosition=1;\"},{\"name\":\"id\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=ID;dbFieldPosition=2;\"},{\"name\":\"data\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=DATA;dbFieldPosition=3;\"},{\"name\":\"lastModified\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=LAST_MODIFIED;dbFieldPosition=4;\"},{\"name\":\"createdDate\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=CREATED_DATE;dbFieldPosition=5;\"}],\"meta\":\"dbFieldName=sy$PROFILE_VS_SOURCE;\"}");
  public java.lang.Long txn;
  public java.lang.Long key;
  public java.lang.Long id;
  public java.lang.CharSequence data;
  public java.lang.Long lastModified;
  public java.lang.Long createdDate;
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return txn;
    case 1: return key;
    case 2: return id;
    case 3: return data;
    case 4: return lastModified;
    case 5: return createdDate;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: txn = (java.lang.Long)value$; break;
    case 1: key = (java.lang.Long)value$; break;
    case 2: id = (java.lang.Long)value$; break;
    case 3: data = (java.lang.CharSequence)value$; break;
    case 4: lastModified = (java.lang.Long)value$; break;
    case 5: createdDate = (java.lang.Long)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
}
