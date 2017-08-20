package com.gmail.test_objects.messages;

import java.util.Properties;

import com.gmail.utils.PropertiesManager;

public class TestMessage {

    private String messages_dir = System.getProperty("messages.properties.path");

    private String to;
    private String subject;
    private String body;

    public TestMessage(final String messageFileName) {
        Properties message = PropertiesManager.loadProperties(messages_dir, messageFileName);
        this.to = message.getProperty("to");
        this.subject = message.getProperty("subject");
        this.body = message.getProperty("body");
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

}
