package com.gmail.zdeprecated.readers;

import java.util.Map;

import com.gmail.exceptions.NoXmlFileException;

public interface Reader {

    public Map<String, Map<String, String>> read(String dir, String fileName) throws NoXmlFileException;

}
