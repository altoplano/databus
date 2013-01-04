/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.linkedin.events.member2.profile;

@SuppressWarnings("all")
/** Auto-generated Avro schema for SY$MEMBER_PROFILE. Generated at Jun 28, 2011 01:02:41 PM PDT */
public class MemberProfile extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = org.apache.avro.Schema.parse("{\"type\":\"record\",\"name\":\"MemberProfile\",\"namespace\":\"com.linkedin.events.member2.profile\",\"fields\":[{\"name\":\"txn\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=TXN;dbFieldPosition=0;\"},{\"name\":\"key\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=KEY;dbFieldPosition=1;\"},{\"name\":\"memberId\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=MEMBER_ID;dbFieldPosition=2;\"},{\"name\":\"createdDate\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=CREATED_DATE;dbFieldPosition=3;\"},{\"name\":\"modifiedDate\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=MODIFIED_DATE;dbFieldPosition=4;\"},{\"name\":\"xmlSchemaVersion\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=XML_SCHEMA_VERSION;dbFieldPosition=5;\"},{\"name\":\"updateVersion\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=UPDATE_VERSION;dbFieldPosition=6;\"},{\"name\":\"profileAuthKey\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=PROFILE_AUTH_KEY;dbFieldPosition=7;\"},{\"name\":\"xmlContentClob\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=XML_CONTENT_CLOB;dbFieldPosition=8;\"},{\"name\":\"profPositions\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"databusProfPosT\",\"fields\":[{\"name\":\"profilePositionId\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=PROFILE_POSITION_ID;dbFieldPosition=0;\"},{\"name\":\"memberId\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=MEMBER_ID;dbFieldPosition=1;\"},{\"name\":\"createdDate\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=CREATED_DATE;dbFieldPosition=2;\"},{\"name\":\"modifiedDate\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=MODIFIED_DATE;dbFieldPosition=3;\"},{\"name\":\"xmlSchemaVersion\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=XML_SCHEMA_VERSION;dbFieldPosition=4;\"},{\"name\":\"startMonthyear\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=START_MONTHYEAR;dbFieldPosition=5;\"},{\"name\":\"endMonthyear\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=END_MONTHYEAR;dbFieldPosition=6;\"},{\"name\":\"companyType\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=COMPANY_TYPE;dbFieldPosition=7;\"},{\"name\":\"memberSelectedCompanyId\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=MEMBER_SELECTED_COMPANY_ID;dbFieldPosition=8;\"},{\"name\":\"suggestedCompanyId\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=SUGGESTED_COMPANY_ID;dbFieldPosition=9;\"},{\"name\":\"industryId\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=INDUSTRY_ID;dbFieldPosition=10;\"},{\"name\":\"companySize\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=COMPANY_SIZE;dbFieldPosition=11;\"},{\"name\":\"stockTickerSymbol\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=STOCK_TICKER_SYMBOL;dbFieldPosition=12;\"},{\"name\":\"stockExchange\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=STOCK_EXCHANGE;dbFieldPosition=13;\"},{\"name\":\"xmlContent\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=XML_CONTENT;dbFieldPosition=14;\"}],\"meta\":\"dbFieldName=PROF_POSITIONS;dbFieldPosition=9;\"}}},{\"name\":\"profEducations\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"databusProfEduT\",\"fields\":[{\"name\":\"profileEducationId\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=PROFILE_EDUCATION_ID;dbFieldPosition=0;\"},{\"name\":\"memberId\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=MEMBER_ID;dbFieldPosition=1;\"},{\"name\":\"createdDate\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=CREATED_DATE;dbFieldPosition=2;\"},{\"name\":\"modifiedDate\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=MODIFIED_DATE;dbFieldPosition=3;\"},{\"name\":\"xmlSchemaVersion\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=XML_SCHEMA_VERSION;dbFieldPosition=4;\"},{\"name\":\"startMonthyear\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=START_MONTHYEAR;dbFieldPosition=5;\"},{\"name\":\"endMonthyear\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=END_MONTHYEAR;dbFieldPosition=6;\"},{\"name\":\"schoolId\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=SCHOOL_ID;dbFieldPosition=7;\"},{\"name\":\"countryCode\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=COUNTRY_CODE;dbFieldPosition=8;\"},{\"name\":\"provinceCode\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=PROVINCE_CODE;dbFieldPosition=9;\"},{\"name\":\"xmlContent\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=XML_CONTENT;dbFieldPosition=10;\"}],\"meta\":\"dbFieldName=PROF_EDUCATIONS;dbFieldPosition=10;\"}}},{\"name\":\"profElements\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"databusProfElemT\",\"fields\":[{\"name\":\"profileElementId\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=PROFILE_ELEMENT_ID;dbFieldPosition=0;\"},{\"name\":\"memberId\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=MEMBER_ID;dbFieldPosition=1;\"},{\"name\":\"elementNum\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=ELEMENT_NUM;dbFieldPosition=2;\"},{\"name\":\"elementType\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ELEMENT_TYPE;dbFieldPosition=3;\"},{\"name\":\"createdDate\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=CREATED_DATE;dbFieldPosition=4;\"},{\"name\":\"modifiedDate\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=MODIFIED_DATE;dbFieldPosition=5;\"},{\"name\":\"xmlSchemaVersion\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=XML_SCHEMA_VERSION;dbFieldPosition=6;\"},{\"name\":\"attribute01\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ATTRIBUTE01;dbFieldPosition=7;\"},{\"name\":\"attribute02\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ATTRIBUTE02;dbFieldPosition=8;\"},{\"name\":\"attribute03\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ATTRIBUTE03;dbFieldPosition=9;\"},{\"name\":\"attribute04\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ATTRIBUTE04;dbFieldPosition=10;\"},{\"name\":\"attribute05\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ATTRIBUTE05;dbFieldPosition=11;\"},{\"name\":\"attribute06\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ATTRIBUTE06;dbFieldPosition=12;\"},{\"name\":\"attribute07\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ATTRIBUTE07;dbFieldPosition=13;\"},{\"name\":\"attribute08\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ATTRIBUTE08;dbFieldPosition=14;\"},{\"name\":\"attribute09\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ATTRIBUTE09;dbFieldPosition=15;\"},{\"name\":\"attribute10\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ATTRIBUTE10;dbFieldPosition=16;\"},{\"name\":\"xmlContent\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=XML_CONTENT;dbFieldPosition=17;\"}],\"meta\":\"dbFieldName=PROF_ELEMENTS;dbFieldPosition=11;\"}}}],\"meta\":\"dbFieldName=SY$MEMBER_PROFILE;\"}");
  public java.lang.Integer txn;
  public java.lang.Integer key;
  public java.lang.Integer memberId;
  public java.lang.Long createdDate;
  public java.lang.Long modifiedDate;
  public java.lang.Long xmlSchemaVersion;
  public java.lang.Integer updateVersion;
  public java.lang.CharSequence profileAuthKey;
  public java.lang.CharSequence xmlContentClob;
  public java.util.List<com.linkedin.events.member2.profile.databusProfPosT> profPositions;
  public java.util.List<com.linkedin.events.member2.profile.databusProfEduT> profEducations;
  public java.util.List<com.linkedin.events.member2.profile.databusProfElemT> profElements;
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return txn;
    case 1: return key;
    case 2: return memberId;
    case 3: return createdDate;
    case 4: return modifiedDate;
    case 5: return xmlSchemaVersion;
    case 6: return updateVersion;
    case 7: return profileAuthKey;
    case 8: return xmlContentClob;
    case 9: return profPositions;
    case 10: return profEducations;
    case 11: return profElements;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: txn = (java.lang.Integer)value$; break;
    case 1: key = (java.lang.Integer)value$; break;
    case 2: memberId = (java.lang.Integer)value$; break;
    case 3: createdDate = (java.lang.Long)value$; break;
    case 4: modifiedDate = (java.lang.Long)value$; break;
    case 5: xmlSchemaVersion = (java.lang.Long)value$; break;
    case 6: updateVersion = (java.lang.Integer)value$; break;
    case 7: profileAuthKey = (java.lang.CharSequence)value$; break;
    case 8: xmlContentClob = (java.lang.CharSequence)value$; break;
    case 9: profPositions = (java.util.List<com.linkedin.events.member2.profile.databusProfPosT>)value$; break;
    case 10: profEducations = (java.util.List<com.linkedin.events.member2.profile.databusProfEduT>)value$; break;
    case 11: profElements = (java.util.List<com.linkedin.events.member2.profile.databusProfElemT>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
}
