package com.gmail.panels.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Описывает блок инструментов для работы с "Черновиками"
 */
public class DraftToolsPanel extends BaseToolsPanel {

	@FindBy(xpath = "//div[@act='16']")
	private WebElement deleteButton;


	public DraftToolsPanel() {
		super();
	}

	public void clickDeleteButton() {
		deleteButton.click();
	}

}
