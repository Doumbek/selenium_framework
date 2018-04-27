package com.gmail.zdeprecated.bo_creator;

import static com.gmail.properties.FrameworkProperties.TEST_DATA_USERS_PATH;

import java.util.Map;

import com.gmail.exceptions.NoXmlFileException;
import com.gmail.zdeprecated.parsers.UsersSAXParser;
import com.gmail.zdeprecated.readers.Reader;
import com.gmail.zdeprecated.readers.xml.XmlFileReader;

public class DataLoader {

    private static final String USER_DIR = TEST_DATA_USERS_PATH.readProperty();

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
