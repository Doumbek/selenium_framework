package com.gmail.providers.messages;

import static com.gmail.properties.FrameworkProperties.TEST_DATA_MESSAGES_PATH;
import static com.gmail.properties.FrameworkProperties.TEST_DATA_USERS_PATH;
import static com.gmail.dataloaders.XmlDataLoader.getInstance;
import static com.gmail.utils.xml.XmlUtils.byAttribute;
import static com.gmail.utils.xml.XmlUtils.byTag;

import org.testng.annotations.DataProvider;

import com.gmail.dto.messages.TestMessage;
import com.gmail.dto.users.TestUser;
import com.gmail.dataloaders.XmlDataLoader;

public class MessagesDataProvider {

    private static final String USERS_DATA = TEST_DATA_USERS_PATH.readProperty();
    private static final String MESSAGES_DATA = TEST_DATA_MESSAGES_PATH.readProperty();

    private static final XmlDataLoader<TestUser> usersTestData = getInstance(TestUser.class)
        .load(byTag("user"), USERS_DATA);
    private static final XmlDataLoader<TestMessage> messagesTestData = getInstance(TestMessage.class)
        .load(byAttribute("subject", "Test subject"), MESSAGES_DATA);

    @DataProvider
    public static Object[][] forCreationData() {
        return new Object[][] {
            {
                usersTestData.where(TestUser::getName).is("Yakush"),
                messagesTestData.where(TestMessage::getSubject).is("Test subject")
            }
        };
    }

    @DataProvider
    public static Object[][] forDeletingData() {
        return new Object[][] {
            {
                usersTestData.where(TestUser::getName).is("Yakush"),
                messagesTestData.where(TestMessage::getSubject).is("Test subject")
            }
        };
    }

}
