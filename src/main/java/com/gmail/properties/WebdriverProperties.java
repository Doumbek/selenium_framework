package com.gmail.properties;

import com.gmail.properties.providers.WebDriverPropertiesProvider;
import com.gmail.utils.properties.OwnerPropertiesUtils;

public enum WebdriverProperties implements OwnerProperties {
    WEBDRIVER_BROWSER_NAME,
    WEBDRIVER_IS_WINDOW_MAXIMIZED,
    WEBDRIVER_IS_USE_REMOTE_DRIVER,
    WEBDRIVER_CHROME_DRIVER_PATH,
    WEBDRIVER_GECKO_DRIVER_PATH;

    public <T> T readProperty() {
        return OwnerPropertiesUtils.readPropertyByKeyValue(
            getProxy(WebDriverPropertiesProvider.class),
            getKeyValue(this));
    }
}
