/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.linkedin.events.leo;

@SuppressWarnings("all")
/** Auto-generated Avro schema for leo2.sy$questions_4. Generated at Sep 15, 2011 09:52:51 AM PDT */
public class Questions_V4 extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = org.apache.avro.Schema.parse("{\"type\":\"record\",\"name\":\"Questions_V4\",\"namespace\":\"com.linkedin.events.leo\",\"fields\":[{\"name\":\"txn\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=TXN;dbFieldPosition=0;\"},{\"name\":\"key\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=KEY;dbFieldPosition=1;\"},{\"name\":\"questionId\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=QUESTION_ID;dbFieldPosition=2;\"},{\"name\":\"askerId\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=ASKER_ID;dbFieldPosition=3;\"},{\"name\":\"type\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=TYPE;dbFieldPosition=4;\"},{\"name\":\"title\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=TITLE;dbFieldPosition=5;\"},{\"name\":\"open\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=OPEN;dbFieldPosition=6;\"},{\"name\":\"hiddenByAsker\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=HIDDEN_BY_ASKER;dbFieldPosition=7;\"},{\"name\":\"hiddenByCs\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=HIDDEN_BY_CS;dbFieldPosition=8;\"},{\"name\":\"askerAccountClosed\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=ASKER_ACCOUNT_CLOSED;dbFieldPosition=9;\"},{\"name\":\"abuseLevel\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=ABUSE_LEVEL;dbFieldPosition=10;\"},{\"name\":\"hiddenByUsers\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=HIDDEN_BY_USERS;dbFieldPosition=11;\"},{\"name\":\"celebrityOnly\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=CELEBRITY_ONLY;dbFieldPosition=12;\"},{\"name\":\"cat1\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=CAT1;dbFieldPosition=13;\"},{\"name\":\"cat2\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=CAT2;dbFieldPosition=14;\"},{\"name\":\"celebrityType\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=CELEBRITY_TYPE;dbFieldPosition=15;\"},{\"name\":\"createDate\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=CREATE_DATE;dbFieldPosition=16;\"},{\"name\":\"expirationDate\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=EXPIRATION_DATE;dbFieldPosition=17;\"},{\"name\":\"modifiedDate\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=MODIFIED_DATE;dbFieldPosition=18;\"},{\"name\":\"lastOpenDate\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=LAST_OPEN_DATE;dbFieldPosition=19;\"},{\"name\":\"lastClosedDate\",\"type\":[\"long\",\"null\"],\"meta\":\"dbFieldName=LAST_CLOSED_DATE;dbFieldPosition=20;\"},{\"name\":\"xmlVersion\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=XML_VERSION;dbFieldPosition=21;\"},{\"name\":\"details\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=DETAILS;dbFieldPosition=22;\"},{\"name\":\"geo\",\"type\":{\"type\":\"record\",\"name\":\"DATABUS_GEO_T\",\"fields\":[{\"name\":\"country\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=COUNTRY;dbFieldPosition=0;\"},{\"name\":\"postalCode\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=POSTAL_CODE;dbFieldPosition=1;\"},{\"name\":\"geoPostalCode\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=GEO_POSTAL_CODE;dbFieldPosition=2;\"},{\"name\":\"regionCode\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=REGION_CODE;dbFieldPosition=3;\"},{\"name\":\"geoPlaceCode\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=GEO_PLACE_CODE;dbFieldPosition=4;\"},{\"name\":\"geoPlaceMaskCode\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=GEO_PLACE_MASK_CODE;dbFieldPosition=5;\"},{\"name\":\"latitudeDeg\",\"type\":[\"float\",\"null\"],\"meta\":\"dbFieldName=LATITUDE_DEG;dbFieldPosition=6;\"},{\"name\":\"longitudeDeg\",\"type\":[\"float\",\"null\"],\"meta\":\"dbFieldName=LONGITUDE_DEG;dbFieldPosition=7;\"}]},\"meta\":\"dbFieldName=GEO;dbFieldPosition=23;\"},{\"name\":\"locale\",\"type\":[\"string\",\"null\"],\"meta\":\"dbFieldName=LOCALE;dbFieldPosition=24;\"}],\"meta\":\"dbFieldName=leo2.sy$questions_4;\"}");
  public java.lang.Integer txn;
  public java.lang.CharSequence key;
  public java.lang.Integer questionId;
  public java.lang.Integer askerId;
  public java.lang.CharSequence type;
  public java.lang.CharSequence title;
  public java.lang.CharSequence open;
  public java.lang.CharSequence hiddenByAsker;
  public java.lang.CharSequence hiddenByCs;
  public java.lang.CharSequence askerAccountClosed;
  public java.lang.Integer abuseLevel;
  public java.lang.CharSequence hiddenByUsers;
  public java.lang.CharSequence celebrityOnly;
  public java.lang.CharSequence cat1;
  public java.lang.CharSequence cat2;
  public java.lang.CharSequence celebrityType;
  public java.lang.Long createDate;
  public java.lang.Long expirationDate;
  public java.lang.Long modifiedDate;
  public java.lang.Long lastOpenDate;
  public java.lang.Long lastClosedDate;
  public java.lang.Integer xmlVersion;
  public java.lang.CharSequence details;
  public com.linkedin.events.leo.DATABUS_GEO_T geo;
  public java.lang.CharSequence locale;
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return txn;
    case 1: return key;
    case 2: return questionId;
    case 3: return askerId;
    case 4: return type;
    case 5: return title;
    case 6: return open;
    case 7: return hiddenByAsker;
    case 8: return hiddenByCs;
    case 9: return askerAccountClosed;
    case 10: return abuseLevel;
    case 11: return hiddenByUsers;
    case 12: return celebrityOnly;
    case 13: return cat1;
    case 14: return cat2;
    case 15: return celebrityType;
    case 16: return createDate;
    case 17: return expirationDate;
    case 18: return modifiedDate;
    case 19: return lastOpenDate;
    case 20: return lastClosedDate;
    case 21: return xmlVersion;
    case 22: return details;
    case 23: return geo;
    case 24: return locale;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: txn = (java.lang.Integer)value$; break;
    case 1: key = (java.lang.CharSequence)value$; break;
    case 2: questionId = (java.lang.Integer)value$; break;
    case 3: askerId = (java.lang.Integer)value$; break;
    case 4: type = (java.lang.CharSequence)value$; break;
    case 5: title = (java.lang.CharSequence)value$; break;
    case 6: open = (java.lang.CharSequence)value$; break;
    case 7: hiddenByAsker = (java.lang.CharSequence)value$; break;
    case 8: hiddenByCs = (java.lang.CharSequence)value$; break;
    case 9: askerAccountClosed = (java.lang.CharSequence)value$; break;
    case 10: abuseLevel = (java.lang.Integer)value$; break;
    case 11: hiddenByUsers = (java.lang.CharSequence)value$; break;
    case 12: celebrityOnly = (java.lang.CharSequence)value$; break;
    case 13: cat1 = (java.lang.CharSequence)value$; break;
    case 14: cat2 = (java.lang.CharSequence)value$; break;
    case 15: celebrityType = (java.lang.CharSequence)value$; break;
    case 16: createDate = (java.lang.Long)value$; break;
    case 17: expirationDate = (java.lang.Long)value$; break;
    case 18: modifiedDate = (java.lang.Long)value$; break;
    case 19: lastOpenDate = (java.lang.Long)value$; break;
    case 20: lastClosedDate = (java.lang.Long)value$; break;
    case 21: xmlVersion = (java.lang.Integer)value$; break;
    case 22: details = (java.lang.CharSequence)value$; break;
    case 23: geo = (com.linkedin.events.leo.DATABUS_GEO_T)value$; break;
    case 24: locale = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
}
