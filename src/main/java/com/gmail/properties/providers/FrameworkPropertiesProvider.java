package com.gmail.properties.providers;

import java.net.URL;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({ "classpath:properties/framework.properties" })
public interface FrameworkPropertiesProvider extends Config {

    @Key("remote.hub.url")
    URL getRemoteHubUrl();

    @Key("gmail.base.url")
    String getGmailBaseUrl();

    @Key("test.data.users.path")
    String getPathToUsersTestData();

    @Key("test.data.messages.path")
    String getPathToMessagesTestData();

}
