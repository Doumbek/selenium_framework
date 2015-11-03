package com.gmail.utils.parsers;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.HashMap;
import java.util.Map;

public class UsersSAXParser extends Parser {

	private StringBuilder elementValue;
	private String currentUser;
	private Map<String, String> userValuesMap;

	@Override
	public void startDocument() throws SAXException {
	}


	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		elementValue = new StringBuilder();

		if (qName.equals("user")) {

			currentUser = attributes.getValue("name");

			userValuesMap = new HashMap<String, String>();

		}

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		elementValue.append(ch, start, length);

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if(qName.equals("user")) {

			entriesMap.put(currentUser, userValuesMap);

		} else {

			userValuesMap.put(qName, elementValue.toString());

		}

	}

	@Override
	public void endDocument() throws SAXException {
	}

	public Map<String, Map<String, String>> getEntriesMap() {

		return entriesMap;

	}




}