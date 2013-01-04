/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.linkedin.events.sdr;

@SuppressWarnings("all")
public class databusSdrEmailsMbrT extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = org.apache.avro.Schema.parse("{\"type\":\"record\",\"name\":\"databusSdrEmailsMbrT\",\"namespace\":\"com.linkedin.events.sdr\",\"fields\":[{\"name\":\"emailId\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=EMAIL_ID;dbFieldPosition=0;\"},{\"name\":\"isPrimary\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=IS_PRIMARY;dbFieldPosition=1;\"},{\"name\":\"isConfirmed\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=IS_CONFIRMED;dbFieldPosition=2;\"},{\"name\":\"email\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=EMAIL;dbFieldPosition=3;\"}],\"meta\":\"dbFieldName=MEMBER_EMAILS;dbFieldPosition=47;\"}");
  public java.lang.Integer emailId;
  public java.lang.Integer isPrimary;
  public java.lang.CharSequence isConfirmed;
  public java.lang.CharSequence email;
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return emailId;
    case 1: return isPrimary;
    case 2: return isConfirmed;
    case 3: return email;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: emailId = (java.lang.Integer)value$; break;
    case 1: isPrimary = (java.lang.Integer)value$; break;
    case 2: isConfirmed = (java.lang.CharSequence)value$; break;
    case 3: email = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
}
