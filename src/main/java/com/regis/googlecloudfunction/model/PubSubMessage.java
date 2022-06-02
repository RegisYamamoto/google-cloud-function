package com.regis.googlecloudfunction.model;

import java.util.Map;

public class PubSubMessage {

    private String data;
    private Map<String, String> attributes;
    private String messageId;
    private String publicTime;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(String publicTime) {
        this.publicTime = publicTime;
    }

    @Override
    public String toString() {
        return "PubSubMessage{" +
                "data='" + data + '\'' +
                ", attributes=" + attributes +
                ", messageId='" + messageId + '\'' +
                ", publicTime='" + publicTime + '\'' +
                '}';
    }

}
