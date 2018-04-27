package com.gmail.properties.providers;

import org.aeonbits.owner.Accessible;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "classpath:properties/webdriver.properties" })
public interface WebDriverPropertiesProvider extends Config {

    @Key("webdriver.browser.name")
    String getBrowserName();

    @Key("webdriver.is.window.maximized")
    Boolean isMaximizeWindow();

    @Key("webdriver.is.use.remote.driver")
    Boolean isRemoteDriver();

    @Key("webdriver.chrome.driver.path")
    String getChromeDriverPath();

    @Key("webdriver.gecko.driver.path")
    String getGeckoDriverPath();

}
