package com.gmail.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Управляет работой с properties
 */
public class PropertiesManager {

	private static final Logger logger = LogManager.getLogger(PropertiesManager.class);

	/**
	 * Загружает properties
	 * @param propertiesDir директория в которой ожидается загружаемый файл
	 * @param propertyFileName загружаемый файл
	 * @return properties
	 */
	public static Properties loadProperties(String propertiesDir, String propertyFileName) {

		String absPathToPropertiesFile = propertiesDir + propertyFileName;

		FileReader reader = null;

		Properties properties = new Properties();

		try{

			reader = new FileReader(absPathToPropertiesFile);

			properties.load(reader);

		} catch (IOException e) {

			logger.error("Have problems with loading properties!");

			e.printStackTrace();

		} finally {

			if (reader != null) {

				try {

					reader.close();

				} catch (IOException e) {

					logger.error("Have problems with closing properties reader!");

					e.printStackTrace();

				}

			}

		}

		return properties;

	}


}
