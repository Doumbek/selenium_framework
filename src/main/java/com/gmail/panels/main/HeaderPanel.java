package com.gmail.panels.main;

import com.gmail.pages.BasePage;
import com.gmail.panels.BasePanel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

		return (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(accountLink)).isDisplayed();

	}

	public void clickAccountLink() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(accountLink)).click();
//		accountLink.click();
	}

	public WebElement getAccountLink() {
		return accountLink;
	}

}
