package com.gmail.panels.info;

import com.gmail.panels.BasePanel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Описывает блок сигнальных сообщений
 */
public class AlertPanel extends BasePanel{

	@FindBy(xpath = "//div[@role='alert']//div[@class='vh']")
	private WebElement confirmAlert;

	public AlertPanel() {
		super();
	}

	public boolean isAlertContainsText(String text) {
		return (new WebDriverWait(driver, 10)).until(ExpectedConditions.textToBePresentInElement(confirmAlert, text));
	}

}
