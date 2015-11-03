package com.gmail.utils.readers;

import com.gmail.utils.exceptions.NoXmlFileException;

import java.util.Map;

public interface Reader {

	public Map<String, Map<String, String>> read(String dir, String fileName) throws NoXmlFileException;

}
