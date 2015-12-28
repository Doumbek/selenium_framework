package com.gmail.panels.users;

import com.gmail.panels.BasePanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Описывает панель для ввода login пользователя
 */
public class LoginPanel extends BasePanel {

	@FindBy(name = "Email")
	private WebElement loginInput;

	@FindBy(id = "next")
	private WebElement nextButton;

	public LoginPanel() {
		super();
	}

	public void setLogin(String login) {
		loginInput.sendKeys(login);
	}

	public void clickNextButton() {
		nextButton.click();
	}

	public WebElement getLoginInput() {
		return loginInput;
	}

}
