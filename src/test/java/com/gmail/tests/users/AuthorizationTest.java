package com.gmail.tests.users;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gmail.steps.users.UserCases;
import com.gmail.pages.main.InboxPage;
import com.gmail.pages.users.LoginPage;
import com.gmail.providers.users.AuthorizationDataProvider;
import com.gmail.dto.users.TestUser;
import com.gmail.tests.BaseTest;

public class AuthorizationTest extends BaseTest {

    private LoginPage loginPage;
    private InboxPage inboxPage;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        loginPage = new LoginPage();
        inboxPage = new InboxPage();
    }

    @Test(dataProvider = "loginData", dataProviderClass = AuthorizationDataProvider.class)
    public void shouldLogin(TestUser user) {
        loginPage.open();
        UserCases.login(loginPage, user);
        assertTrue(
            inboxPage.getHeaderPanel().isAccountLinkPresented(),
            "Account link for authorized user must be presented!");
    }


    @Test(dataProvider = "logoutData", dataProviderClass = AuthorizationDataProvider.class)
    public void shouldLogout(TestUser user) {
        logger.info("Check logout user");
        loginPage.open();
        UserCases.login(loginPage, user);
        UserCases.logout(inboxPage);
        assertTrue(loginPage.getPasswordPanel().isPasswordInputDisplayed());
    }

}
