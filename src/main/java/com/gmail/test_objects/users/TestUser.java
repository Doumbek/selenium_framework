package com.gmail.test_objects.users;

import com.gmail.utils.PropertiesManager;

import java.util.Properties;

/**
 * Описывает обьект тестового пользователя
 */
public class TestUser {

	private String user_dir = System.getProperty("users.properties.path");

	private String login;
	private String password;

	public TestUser(String userFileName) {

		Properties user = PropertiesManager.loadProperties(user_dir, userFileName);

		this.login = user.getProperty("login");
		this.password = user.getProperty("password");
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

}
