package com.gmail.panels.mail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gmail.panels.BasePanel;

public class NewMessagePanel extends BasePanel {

    @FindBy(name = "to")
    private WebElement toInput;

    @FindBy(name = "subjectbox")
    private WebElement subjectInput;

    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement bodyInput;

    @FindBy(xpath = "//td[@class='gU Up']//div[@role='button']")
    private WebElement sendButton;

    @FindBy(xpath = "//img[@alt='Close']")
    private WebElement closePopupButton;

    public NewMessagePanel() {
        super();
    }

    public void setTo(final String to) {
        toInput.sendKeys(to);
    }

    public void setSubject(final String subject) {
        subjectInput.sendKeys(subject);
    }

    public void setBody(final String body) {
        bodyInput.sendKeys(body);
    }

    public void clickSendButton() {
        sendButton.click();
    }

    public void clickClosePopupButton() {
        closePopupButton.click();
    }

}
