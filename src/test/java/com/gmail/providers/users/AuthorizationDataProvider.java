package com.gmail.providers.users;

import com.gmail.test_objects.users.TestUser;
import org.testng.annotations.DataProvider;

public class AuthorizationDataProvider {

	private static TestUser testUser = new TestUser("yakush.properties");

	@DataProvider
	public static Object[][] loginData() {

		return  new Object[][] {
				{testUser},
				{testUser}
		};
	}

	@DataProvider
	public static Object[][] logoutData() {

		return  new Object[][] {
				{testUser}
		};
	}

}
