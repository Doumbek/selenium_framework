package com.gmail.dataloaders;

import static com.gmail.utils.xml.XmlUtils.unmarshall;
import static java.lang.String.valueOf;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import javax.xml.stream.XMLStreamReader;

import org.apache.commons.lang3.StringUtils;

public class XmlDataLoader<T> {

    private Class<T> type;
    private List<T> loadedData = new ArrayList<>();
    private Function<T, ?> getter;

    private XmlDataLoader(final Class<T> type) {
        this.type = type;
    }

    public static <T> XmlDataLoader<T> getInstance(final Class<T> type) {
        return new XmlDataLoader<>(type);
    }

    public XmlDataLoader<T> load(final Predicate<XMLStreamReader> context, final String source) {
        loadedData = unmarshall(context, source, type);
        return this;
    }

    public XmlDataLoader<T> where(final Function<T, ?> getter) {
        this.getter = getter;
        return this;
    }

    public T is(final String value) {
        return loadedData.stream()
            .filter(object -> StringUtils.equals(valueOf(getter.apply(object)), value))
            .findFirst().orElse(null);
    }
}
