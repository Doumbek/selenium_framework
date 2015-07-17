package com.gmail.utils;

import java.util.Properties;

/**
 * Описывает обьект конфигурации теста
 */
public class Config {

	private static Config config;
	private String config_dir = System.getProperty("config.properties.path");

	private String baseUrl;

	private Config() {
		Properties properties = PropertiesManager.loadProperties(config_dir, "baseConfig.properties");
		this.baseUrl = properties.getProperty("base.url");

	}

	public static Config getInstance() {
		if(config == null) {
			config = new Config();
		}
		return config;
	}

	public String getBaseUrl() {
		return baseUrl;
	}
}
