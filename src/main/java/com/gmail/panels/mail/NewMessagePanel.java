package com.gmail.panels.mail;

import com.gmail.panels.BasePanel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Описывает попап отправки нового сообщения
 */
public class NewMessagePanel extends BasePanel {

	@FindBy(name = "to")
	private WebElement toInput;

	@FindBy(name = "subjectbox")
	private WebElement subjectInput;

	@FindBy(xpath = "//div[@role='textbox']")
	private WebElement bodyInput;

	@FindBy(xpath = "//td[@class='gU Up']//div[@role='button']")
	private WebElement sendButton;

	@FindBy(xpath = "//img[@alt='Закрыть']")
	private WebElement closePopupButton;

	public NewMessagePanel() {
		super();
	}

	public void setTo(String to) {
		toInput.sendKeys(to);
	}

	public void setSubject(String subject) {
		subjectInput.sendKeys(subject);
	}

	public void setBody(String body) {
		bodyInput.sendKeys(body);
	}

	public void clickSendButton() {
		sendButton.click();
	}

	public void clickClosePopupButton() {
		closePopupButton.click();
	}

}
