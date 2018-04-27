package com.gmail.properties;

import com.gmail.properties.providers.FrameworkPropertiesProvider;
import com.gmail.utils.properties.OwnerPropertiesUtils;

public enum FrameworkProperties implements OwnerProperties {
    TEST_DATA_USERS_PATH,
    TEST_DATA_MESSAGES_PATH,
    REMOTE_HUB_URL,
    GMAIL_BASE_URL;

    public <T> T readProperty() {
        return OwnerPropertiesUtils.readPropertyByKeyValue(
            getProxy(FrameworkPropertiesProvider.class),
            getKeyValue(this));
    }

}
