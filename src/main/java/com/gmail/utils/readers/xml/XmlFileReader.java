package com.gmail.utils.readers.xml;

import com.gmail.utils.exceptions.NoXmlFileException;
import com.gmail.utils.parsers.Parser;
import com.gmail.utils.readers.Reader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class XmlFileReader implements Reader {

	private Parser parser;

	public XmlFileReader(Parser parser) {

		this.parser = parser;

	}

	@Override
	public Map<String, Map<String, String>> read(String dir, String fileName) throws NoXmlFileException {

		Map<String, Map<String, String>> entriesMap = new HashMap<String, Map<String, String>>();

		if(!fileName.contains(".xml")) {

			throw new NoXmlFileException("\nFile is not .xml format!");

		}

		SAXParserFactory factory = SAXParserFactory.newInstance();

		try {

			factory.newSAXParser().parse(dir + fileName, parser);

			entriesMap = parser.getEntriesMap();

		} catch (ParserConfigurationException | SAXException | IOException e) {

			System.out.println("Parsing fails: " + e.getMessage());

		}

		return entriesMap;

	}

}
