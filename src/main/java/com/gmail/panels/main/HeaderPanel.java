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

	@FindBy(xpath = "//a[@class='gb_ca gb_l gb_r gb_h']")
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
