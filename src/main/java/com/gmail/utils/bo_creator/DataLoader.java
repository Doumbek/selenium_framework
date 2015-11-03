package com.gmail.utils.bo_creator;

import com.gmail.utils.exceptions.NoXmlFileException;
import com.gmail.utils.parsers.UsersSAXParser;
import com.gmail.utils.readers.Reader;
import com.gmail.utils.readers.xml.XmlFileReader;

import java.util.Map;

public class DataLoader {

	private static final String USER_DIR = System.getProperty("users.file.path");
	private static Map<String, Map<String, String>> entriesMap;

	public static Map<String, String> loadXmlUsersSAX(String fileName, String name) {

		Reader reader = new XmlFileReader(new UsersSAXParser());

		try {

			entriesMap = reader.read(USER_DIR, fileName);

		} catch (NoXmlFileException e) {

			e.printStackTrace();

		}

		return entriesMap.get(name);

	}




}
