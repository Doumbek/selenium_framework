package com.gmail.utils;

import java.util.Properties;

public class Config {

    private static Config config;
    private String config_dir = System.getProperty("config.properties.path");

    Properties properties;

    private Config() {
        properties = PropertiesManager.loadProperties(config_dir, "baseConfig.properties");
    }

    public static Config getInstance() {
        if (config == null) {
            config = new Config();
        }
        return config;
    }

    public String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public String getHubUrl() {
        return properties.getProperty("hub.url");
    }
}
