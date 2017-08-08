package com.gmail.panels.users;

import com.gmail.panels.BasePanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Описывает выпадающий блок с для работы с информацией пользователя
 */
public class AccountInfoPanel extends BasePanel {

	@FindBy(xpath = ".//a[contains(@href, 'https://accounts.google.com/Logout')]")
	private WebElement logoutButton;

	public AccountInfoPanel() {
		super();
	}

	public void clickLogoutButton() {

		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(logoutButton)).click();

	}

}
