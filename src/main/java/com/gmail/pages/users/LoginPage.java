package com.gmail.pages.users;

import com.gmail.pages.BasePage;
import com.gmail.panels.users.LoginPanel;
import com.gmail.panels.users.PasswordPanel;

/**
 * Описывает страницу для входа пользователя в систему
 */
public class LoginPage extends BasePage{

	private LoginPanel loginPanel;
	private PasswordPanel passwordPanel;

	public LoginPage(){
		super();
		loginPanel = new LoginPanel();
		passwordPanel = new PasswordPanel();
	}

	public void open() {
		driver.get(url);
	}

	public LoginPanel getLoginPanel() {
		return loginPanel;
	}

	public PasswordPanel getPasswordPanel() {
		return passwordPanel;
	}

}
