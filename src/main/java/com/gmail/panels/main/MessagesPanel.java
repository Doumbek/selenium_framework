package com.gmail.panels.main;

import com.gmail.panels.BasePanel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Описывает блок с сообщениями на страницах работы с сообщениями
 * Сейчас работает с первым сообщением из списка доступных
 */

//TODO Реализовать работу с разными сообщениями из списка

public class MessagesPanel extends BasePanel {

	@FindBy(xpath = "//div[@gh='tl']//tr[1]//div[@role='link']//span[1]")
	private WebElement lastMailSubject;

	@FindBy(xpath = "//div[@gh='tl']//tr[1]//div[@role='link']//span[2]")
	private WebElement lastMailBody;

	@FindBy(xpath = "//div[@gh='tl']")
	private WebElement messageInfo;

	public MessagesPanel() {
		super();
	}

	public boolean isSubjectContains(String subject) {
		return (new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(lastMailSubject, subject)));
	}

	public boolean isBodyContains(String body) {
		return (new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(lastMailBody, body)));
	}

	public boolean isMessageInfoContains(String message) {
		return (new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(messageInfo, message)));
	}

}
