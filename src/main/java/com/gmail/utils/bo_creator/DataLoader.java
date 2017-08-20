package com.gmail.utils.bo_creator;

import java.util.Map;

import com.gmail.utils.exceptions.NoXmlFileException;
import com.gmail.utils.parsers.UsersSAXParser;
import com.gmail.utils.readers.Reader;
import com.gmail.utils.readers.xml.XmlFileReader;

public class DataLoader {

    private static final String USER_DIR = System.getProperty("users.file.path");

    public static Map<String, String> loadXmlUsersSAX(final String fileName, final String name) {
        Reader reader = new XmlFileReader(new UsersSAXParser());
        try {
            Map<String, Map<String, String>> entriesMap = reader.read(USER_DIR, fileName);
            return entriesMap.get(name);
        } catch (NoXmlFileException e) {
            throw new IllegalArgumentException(String.format("File %s is not exist!", fileName), e);
        }
    }

}
