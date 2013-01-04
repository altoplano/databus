/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.linkedin.events.anet;

@SuppressWarnings("all")
/** Auto-generated Avro schema for anet.sy$restricted_mail_domain_1. Generated at Feb 10, 2012 05:42:04 PM PST */
public class RestrictedMailDomain_V2 extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = org.apache.avro.Schema.parse("{\"type\":\"record\",\"name\":\"RestrictedMailDomain_V2\",\"namespace\":\"com.linkedin.events.anet\",\"fields\":[{\"name\":\"txn\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=TXN;dbFieldPosition=0;\"},{\"name\":\"id\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=ID;dbFieldPosition=1;\"},{\"name\":\"active\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ACTIVE;dbFieldPosition=2;\"},{\"name\":\"mailDomain\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=MAIL_DOMAIN;dbFieldPosition=3;\"}],\"meta\":\"dbFieldName=anet.sy$restricted_mail_domain_1;pk=id;\"}");
  public java.lang.Long txn;
  public java.lang.Long id;
  public java.lang.CharSequence active;
  public java.lang.CharSequence mailDomain;
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return txn;
    case 1: return id;
    case 2: return active;
    case 3: return mailDomain;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: txn = (java.lang.Long)value$; break;
    case 1: id = (java.lang.Long)value$; break;
    case 2: active = (java.lang.CharSequence)value$; break;
    case 3: mailDomain = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
}
