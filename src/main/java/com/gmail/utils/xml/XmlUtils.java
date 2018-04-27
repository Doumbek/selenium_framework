package com.gmail.utils.xml;

import static java.lang.String.format;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.lang3.StringUtils;

public class XmlUtils {

    private XmlUtils() {
    }

    public static <T> T unmarshall(final String file, final Class<T> returnType) {
        try {
            final Unmarshaller unmarshaller = JAXBContext.newInstance(returnType).createUnmarshaller();
            final JAXBElement<T> root = unmarshaller.unmarshal(new StreamSource(new FileReader(new File(file))),
                returnType);
            return root.getValue();
        } catch (final FileNotFoundException | JAXBException e) {
            throw new IllegalArgumentException(
                format("Failed to unmarshall XML file [%s] into object [%s]!", file, returnType.getName()),
                e);
        }
    }

    public static <T> List<T> unmarshall(final Predicate<XMLStreamReader> context, final String file,
            final Class<T> returnType) {
        final List<T> result = new ArrayList<>();
        try {
            final XMLStreamReader xmlStreamReader = XMLInputFactory.newFactory()
                .createXMLStreamReader(new StreamSource(new FileReader(new File(file))));
            final Unmarshaller unmarshaller = JAXBContext.newInstance(returnType).createUnmarshaller();
            while (xmlStreamReader.hasNext()) {
                if (context.test(xmlStreamReader)) {
                    JAXBElement<T> root = unmarshaller.unmarshal(xmlStreamReader, returnType);
                    result.add(root.getValue());
                    continue;
                }
                xmlStreamReader.next();
            }
            xmlStreamReader.close();
            return result;
        } catch (final FileNotFoundException | JAXBException | XMLStreamException e) {
            throw new IllegalArgumentException(
                format("Failed to unmarshall XML file [%s] into object [%s]!", file, returnType.getName()), e);
        }
    }

    public static Predicate<XMLStreamReader> byTag(final String tagName) {
        return xmlStreamReader -> xmlStreamReader.isStartElement()
                && StringUtils.equals(xmlStreamReader.getLocalName(), tagName);
    }

    public static Predicate<XMLStreamReader> byAttribute(final String attrName, final String attrValue) {
        return xmlStreamReader -> xmlStreamReader.isStartElement()
                && StringUtils.equals(xmlStreamReader.getAttributeValue(null, attrName), attrValue);
    }
}
