package com.gmail.panels.users;

import com.gmail.panels.BasePanel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Описывает панель для ввода пароля пользователя
 */
public class PasswordPanel extends BasePanel {

	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordInput;

	@FindBy(xpath = "//div[@id='passwordNext']")
	private WebElement enterButton;

	public PasswordPanel() {
		super();
	}

	public boolean isPasswordInputDisplayed() {
		return passwordInput.isDisplayed();
	}

	public void setPassword(String password) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(passwordInput));
		passwordInput.sendKeys(password);
	}

	public void clickEnterButton() {
		enterButton.click();
	}

	public WebElement getPasswordInput() {
		return passwordInput;
	}

}
