package com.gmail.panels.users;

import com.gmail.panels.BasePanel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Описывает панель для ввода пароля пользователя
 */
public class PasswordPanel extends BasePanel {

	@FindBy(name = "Passwd")
	private WebElement passwordInput;

	@FindBy(id = "signIn")
	private WebElement enterButton;

	public PasswordPanel() {
		super();
	}

	public boolean isPasswordInputDisplayed() {
		return passwordInput.isDisplayed();
	}

	public void setPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public void clickEnterButton() {
		enterButton.click();
	}

}
