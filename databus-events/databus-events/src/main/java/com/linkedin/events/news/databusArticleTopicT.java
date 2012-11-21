/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.linkedin.events.news;

@SuppressWarnings("all")
public class databusArticleTopicT extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = org.apache.avro.Schema.parse("{\"type\":\"record\",\"name\":\"databusArticleTopicT\",\"namespace\":\"com.linkedin.events.news\",\"fields\":[{\"name\":\"topicId\",\"type\":[\"int\",\"null\"],\"meta\":\"dbFieldName=TOPIC_ID;dbFieldPosition=0;\"},{\"name\":\"rank\",\"type\":[\"float\",\"null\"],\"meta\":\"dbFieldName=RANK;dbFieldPosition=1;\"}],\"meta\":\"dbFieldName=ARTICLE_TOPICS;dbFieldPosition=0;\"}");
  public java.lang.Integer topicId;
  public java.lang.Float rank;
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return topicId;
    case 1: return rank;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: topicId = (java.lang.Integer)value$; break;
    case 1: rank = (java.lang.Float)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
}
