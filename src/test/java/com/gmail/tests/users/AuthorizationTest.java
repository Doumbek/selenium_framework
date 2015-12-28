package com.gmail.tests.users;

import com.gmail.tests.BaseTest;
import com.gmail.cases.users.UserCases;
import com.gmail.pages.main.InboxPage;
import com.gmail.pages.users.LoginPage;
import com.gmail.providers.users.AuthorizationDataProvider;
import com.gmail.test_objects.users.TestUser;
import com.gmail.utils.ScreenshotsMaker;
import jdk.nashorn.internal.ir.annotations.Ignore;
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
		logger.info("User open main page");
		loginPage.open();

		ScreenshotsMaker.makeScreenshot();

		logger.info("User try to login");
		UserCases.login(loginPage, user);

		logger.info("User get page title through JavascriptExecutor");
		System.out.println(inboxPage.getTitle());

		logger.info("User checks that his account link is presented");
		assertTrue(
				inboxPage.getHeaderPanel().isAccountLinkPresented(),
				"Account link for authorized user must be presented!"
		);

		ScreenshotsMaker.makeScreenshotWithHighlight(inboxPage.getHeaderPanel().getAccountLink());

	}


	@Test(dataProvider = "logoutData",
			dataProviderClass = AuthorizationDataProvider.class, enabled = false)
	public void shouldLogout(TestUser user) {

		logger.info("Check logout user");

		loginPage.open();

		UserCases.login(loginPage, user);

		UserCases.logout(inboxPage);

		assertTrue(loginPage.getPasswordPanel().isPasswordInputDisplayed());

	}

}
