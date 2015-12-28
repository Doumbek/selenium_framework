package com.gmail.cases.users;

import com.gmail.pages.main.BaseMainPage;
import com.gmail.pages.users.LoginPage;
import com.gmail.test_objects.users.TestUser;
import com.gmail.utils.ScreenshotsMaker;

public class UserCases {

	/**
	 * Логинится в систему. Ожидается, что мы находимся на странице входа пользователя в систему
	 * @param page страница входа пользователя в систему
	 * @param user обьект пользователя. Содержит login, password
	 */
	public static void login(LoginPage page, TestUser user) {

		page.getLoginPanel().setLogin(user.getLogin());

//		ScreenshotsMaker.makeScreenshotWithHighlight(page.getLoginPanel().getLoginInput());

		page.getLoginPanel().clickNextButton();
		page.getPasswordPanel().setPassword(user.getPassword());

//		ScreenshotsMaker.makeScreenshotWithHighlight(page.getPasswordPanel().getPasswordInput());

		page.getPasswordPanel().clickEnterButton();

	}

	/**
	 * Выходит их учетной записи
	 * @param page текущая страница, с которой вызывается
	 */
	public static void logout(BaseMainPage page) {

		page.getHeaderPanel().clickAccountLink();
		page.getAccountInfoPanel().clickLogoutButton();

	}

}
