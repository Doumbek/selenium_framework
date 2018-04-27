package com.gmail.providers.users;

import static com.gmail.properties.FrameworkProperties.TEST_DATA_USERS_PATH;
import static com.gmail.dataloaders.XmlDataLoader.getInstance;
import static com.gmail.utils.xml.XmlUtils.byTag;

import org.testng.annotations.DataProvider;

import com.gmail.dto.users.TestUser;
import com.gmail.dataloaders.XmlDataLoader;

public class AuthorizationDataProvider {

    private static final String USERS_DATA = TEST_DATA_USERS_PATH.readProperty();
    private static final XmlDataLoader<TestUser> usersTestData = getInstance(TestUser.class)
        .load(byTag("user"), USERS_DATA);

    @DataProvider
    public static Object[][] loginData() {
        return new Object[][] {
            { usersTestData.where(TestUser::getName).is("Yakush") }
        };
    }

    @DataProvider
    public static Object[][] logoutData() {
        return new Object[][] {
            { usersTestData.where(TestUser::getName).is("Yakush") }
        };
    }

}
