package com.gmail.tests.users;

import com.gmail.tests.BaseTest;
import com.gmail.cases.users.UserCases;
import com.gmail.pages.main.InboxPage;
import com.gmail.pages.users.LoginPage;
import com.gmail.providers.users.AuthorizationDataProvider;
import com.gmail.test_objects.users.TestUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

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

	@Test(dataProvider = "loginData",
			dataProviderClass = AuthorizationDataProvider.class)
	public void shouldLogin(TestUser user){

		logger.info("Check login user with valid data");

		loginPage.open();

		UserCases.login(loginPage, user);

		System.out.print("Get page title through JavascriptExecutor: ");
		System.out.println(inboxPage.getTitle());

		assertTrue(
				inboxPage.getHeaderPanel().isAccountLinkPresented(),
				"Account link for authorized user must be presented!"
		);

	}

	@Test(dataProvider = "logoutData",
			dataProviderClass = AuthorizationDataProvider.class)
	public void shouldLogout(TestUser user) {

		logger.info("Check logout user");

		loginPage.open();

		UserCases.login(loginPage, user);

		UserCases.logout(inboxPage);

		assertTrue(loginPage.getPasswordPanel().isPasswordInputDisplayed());

	}

}
