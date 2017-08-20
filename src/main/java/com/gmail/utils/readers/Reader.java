package com.gmail.utils.readers;

import java.util.Map;

import com.gmail.utils.exceptions.NoXmlFileException;

public interface Reader {

    public Map<String, Map<String, String>> read(String dir, String fileName) throws NoXmlFileException;

}
