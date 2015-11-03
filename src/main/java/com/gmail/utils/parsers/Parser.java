package com.gmail.utils.parsers;

import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;

public abstract class Parser extends DefaultHandler {

	protected Map<String, Map<String, String>> entriesMap = new HashMap<String, Map<String, String>>();

	abstract public Map<String, Map<String, String>> getEntriesMap();

}
