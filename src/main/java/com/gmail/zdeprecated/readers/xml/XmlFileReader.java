package com.gmail.zdeprecated.readers.xml;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.gmail.exceptions.NoXmlFileException;
import com.gmail.zdeprecated.parsers.Parser;
import com.gmail.zdeprecated.readers.Reader;

public class XmlFileReader implements Reader {

    private Parser parser;

    public XmlFileReader(Parser parser) {
        this.parser = parser;
    }

    @Override
    public Map<String, Map<String, String>> read(final String dir, final String fileName) throws NoXmlFileException {
        Map<String, Map<String, String>> entriesMap = new HashMap<String, Map<String, String>>();
        if (!fileName.contains(".xml")) {
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
