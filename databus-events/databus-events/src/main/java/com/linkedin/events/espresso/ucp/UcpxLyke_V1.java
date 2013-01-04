/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.linkedin.events.espresso.ucp;

@SuppressWarnings("all")
/** Auto-generated Avro schema for sy$UCPX_LYKE. Generated at May 29, 2012 05:28:41 PM PDT */
public class UcpxLyke_V1 extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = org.apache.avro.Schema.parse("{\"type\":\"record\",\"name\":\"UcpxLyke_V1\",\"namespace\":\"com.linkedin.events.espresso.ucp\",\"fields\":[{\"name\":\"txn\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=TXN;dbFieldPosition=0;\"},{\"name\":\"objectidmd5\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=OBJECTIDMD5;dbFieldPosition=1;\"},{\"name\":\"actoridmd5\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ACTORIDMD5;dbFieldPosition=2;\"},{\"name\":\"timestamp\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=TIMESTAMP;dbFieldPosition=3;\"},{\"name\":\"etag\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ETAG;dbFieldPosition=4;\"},{\"name\":\"flags\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=FLAGS;dbFieldPosition=5;\"},{\"name\":\"rstate\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=RSTATE;dbFieldPosition=6;\"},{\"name\":\"expires\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=EXPIRES;dbFieldPosition=7;\"},{\"name\":\"schemaVersion\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=SCHEMA_VERSION;dbFieldPosition=8;\"},{\"name\":\"val\",\"type\":[\"bytes\",\"null\"],\"meta\":\"dbFieldName=VAL;dbFieldPosition=9;\"}],\"meta\":\"dbFieldName=sy$UCPX_LYKE;\"}");
  public java.lang.Long txn;
  public java.lang.CharSequence objectidmd5;
  public java.lang.CharSequence actoridmd5;
  public java.lang.Long timestamp;
  public java.lang.CharSequence etag;
  public java.lang.Long flags;
  public java.lang.CharSequence rstate;
  public java.lang.Long expires;
  public java.lang.Integer schemaVersion;
  public java.nio.ByteBuffer val;
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return txn;
    case 1: return objectidmd5;
    case 2: return actoridmd5;
    case 3: return timestamp;
    case 4: return etag;
    case 5: return flags;
    case 6: return rstate;
    case 7: return expires;
    case 8: return schemaVersion;
    case 9: return val;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: txn = (java.lang.Long)value$; break;
    case 1: objectidmd5 = (java.lang.CharSequence)value$; break;
    case 2: actoridmd5 = (java.lang.CharSequence)value$; break;
    case 3: timestamp = (java.lang.Long)value$; break;
    case 4: etag = (java.lang.CharSequence)value$; break;
    case 5: flags = (java.lang.Long)value$; break;
    case 6: rstate = (java.lang.CharSequence)value$; break;
    case 7: expires = (java.lang.Long)value$; break;
    case 8: schemaVersion = (java.lang.Integer)value$; break;
    case 9: val = (java.nio.ByteBuffer)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
}
