package com.gmail.providers.users;

import org.testng.annotations.DataProvider;

import com.gmail.test_objects.users.TestUser;
import com.gmail.utils.bo_creator.DataLoader;

public class AuthorizationDataProvider {

    private static TestUser testUser = new TestUser(DataLoader.loadXmlUsersSAX("users.xml", "Yakush"));

    @DataProvider
    public static Object[][] loginData() {
        return new Object[][] {
            { testUser }
        };
    }

    @DataProvider
    public static Object[][] logoutData() {
        return new Object[][] {
            { testUser }
        };
    }

}
