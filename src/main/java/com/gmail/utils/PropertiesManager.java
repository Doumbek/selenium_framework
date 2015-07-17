package com.gmail.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Управляет работой с properties
 */
public class PropertiesManager {

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

			e.printStackTrace();

		} finally {

			if (reader != null) {

				try {
					reader.close();

				} catch (IOException e) {

					e.printStackTrace();

				}

			}

		}

		return properties;

	}


}
