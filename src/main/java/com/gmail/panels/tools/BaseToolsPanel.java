package com.gmail.panels.tools;

import com.gmail.panels.BasePanel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Описывает базовый блок инструментов для работы с сообщениями
 *
 */
abstract public class BaseToolsPanel extends BasePanel {

	@FindBy(xpath = "//div[@gh='mtb']//span[@dir='ltr']")
	private WebElement allCheckbox;

	public BaseToolsPanel() {
		super();
	}

	public void checkAllCheckbox() {
		allCheckbox.click();
	}

}
