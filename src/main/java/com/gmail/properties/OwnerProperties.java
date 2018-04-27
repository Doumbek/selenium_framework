package com.gmail.properties;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigCache;

import com.gmail.properties.providers.FrameworkPropertiesProvider;

public interface OwnerProperties {

    default Config getProxy(final Class<? extends Config> propertyType) {
        return ConfigCache.getOrCreate(propertyType, System.getProperties());
    }

    default String getKeyValue(final Enum property) {
        return property.name().toLowerCase().replaceAll("_", ".");
    }

}
