package com.gmail.panels.info;

import com.gmail.pages.BasePage;
import com.gmail.panels.BasePanel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Описывает попап подтверждения удаления сообщений
 */
public class ConfirmDeletePanel extends BasePanel {

	@FindBy(xpath = "//button[@name='ok']")
	private WebElement okButton;

	public ConfirmDeletePanel() {
		super();
	}

	public void clickOkButton() {
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(okButton)).click();
	}

}
