package com.gmail.panels.main;

import com.gmail.pages.BasePage;
import com.gmail.panels.BasePanel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Описывает блок header
 */
public class HeaderPanel extends BasePanel {

	@FindBy(xpath = ".//a[contains(@href, 'https://accounts.google.com/SignOutOptions')]")
	private WebElement accountLink;

	public HeaderPanel() {
		super();
	}

	public boolean isAccountLinkPresented() {
		return accountLink.isDisplayed();
	}

	public void clickAccountLink() {
		accountLink.click();
	}

}
