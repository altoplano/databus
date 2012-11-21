/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.linkedin.events.member2.searchprofile;

@SuppressWarnings("all")
public class databusProfElemT extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = org.apache.avro.Schema.parse("{\"type\":\"record\",\"name\":\"databusProfElemT\",\"namespace\":\"com.linkedin.events.member2.searchprofile\",\"fields\":[{\"name\":\"profileElementId\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=PROFILE_ELEMENT_ID;dbFieldPosition=0;\"},{\"name\":\"memberId\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=MEMBER_ID;dbFieldPosition=1;\"},{\"name\":\"elementNum\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=ELEMENT_NUM;dbFieldPosition=2;\"},{\"name\":\"elementType\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ELEMENT_TYPE;dbFieldPosition=3;\"},{\"name\":\"createdDate\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=CREATED_DATE;dbFieldPosition=4;\"},{\"name\":\"modifiedDate\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=MODIFIED_DATE;dbFieldPosition=5;\"},{\"name\":\"xmlSchemaVersion\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=XML_SCHEMA_VERSION;dbFieldPosition=6;\"},{\"name\":\"attribute01\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ATTRIBUTE01;dbFieldPosition=7;\"},{\"name\":\"attribute02\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ATTRIBUTE02;dbFieldPosition=8;\"},{\"name\":\"attribute03\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ATTRIBUTE03;dbFieldPosition=9;\"},{\"name\":\"attribute04\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ATTRIBUTE04;dbFieldPosition=10;\"},{\"name\":\"attribute05\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ATTRIBUTE05;dbFieldPosition=11;\"},{\"name\":\"attribute06\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ATTRIBUTE06;dbFieldPosition=12;\"},{\"name\":\"attribute07\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ATTRIBUTE07;dbFieldPosition=13;\"},{\"name\":\"attribute08\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ATTRIBUTE08;dbFieldPosition=14;\"},{\"name\":\"attribute09\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ATTRIBUTE09;dbFieldPosition=15;\"},{\"name\":\"attribute10\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ATTRIBUTE10;dbFieldPosition=16;\"},{\"name\":\"xmlContent\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=XML_CONTENT;dbFieldPosition=17;\"}],\"meta\":\"dbFieldName=PROF_ELEMENTS;dbFieldPosition=18;\"}");
  public java.lang.Long profileElementId;
  public java.lang.Long memberId;
  public java.lang.Long elementNum;
  public java.lang.CharSequence elementType;
  public java.lang.Long createdDate;
  public java.lang.Long modifiedDate;
  public java.lang.Long xmlSchemaVersion;
  public java.lang.CharSequence attribute01;
  public java.lang.CharSequence attribute02;
  public java.lang.CharSequence attribute03;
  public java.lang.CharSequence attribute04;
  public java.lang.CharSequence attribute05;
  public java.lang.CharSequence attribute06;
  public java.lang.CharSequence attribute07;
  public java.lang.CharSequence attribute08;
  public java.lang.CharSequence attribute09;
  public java.lang.CharSequence attribute10;
  public java.lang.CharSequence xmlContent;
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return profileElementId;
    case 1: return memberId;
    case 2: return elementNum;
    case 3: return elementType;
    case 4: return createdDate;
    case 5: return modifiedDate;
    case 6: return xmlSchemaVersion;
    case 7: return attribute01;
    case 8: return attribute02;
    case 9: return attribute03;
    case 10: return attribute04;
    case 11: return attribute05;
    case 12: return attribute06;
    case 13: return attribute07;
    case 14: return attribute08;
    case 15: return attribute09;
    case 16: return attribute10;
    case 17: return xmlContent;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: profileElementId = (java.lang.Long)value$; break;
    case 1: memberId = (java.lang.Long)value$; break;
    case 2: elementNum = (java.lang.Long)value$; break;
    case 3: elementType = (java.lang.CharSequence)value$; break;
    case 4: createdDate = (java.lang.Long)value$; break;
    case 5: modifiedDate = (java.lang.Long)value$; break;
    case 6: xmlSchemaVersion = (java.lang.Long)value$; break;
    case 7: attribute01 = (java.lang.CharSequence)value$; break;
    case 8: attribute02 = (java.lang.CharSequence)value$; break;
    case 9: attribute03 = (java.lang.CharSequence)value$; break;
    case 10: attribute04 = (java.lang.CharSequence)value$; break;
    case 11: attribute05 = (java.lang.CharSequence)value$; break;
    case 12: attribute06 = (java.lang.CharSequence)value$; break;
    case 13: attribute07 = (java.lang.CharSequence)value$; break;
    case 14: attribute08 = (java.lang.CharSequence)value$; break;
    case 15: attribute09 = (java.lang.CharSequence)value$; break;
    case 16: attribute10 = (java.lang.CharSequence)value$; break;
    case 17: xmlContent = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
}
