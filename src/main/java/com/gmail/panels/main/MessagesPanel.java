package com.gmail.panels.main;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gmail.panels.BasePanel;

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

    public boolean isSubjectContains(final String subject) {
        return (new WebDriverWait(driver, 10)
            .until(textToBePresentInElement(lastMailSubject, subject)));
    }

    public boolean isBodyContains(final String body) {
        return (new WebDriverWait(driver, 10)
            .until(textToBePresentInElement(lastMailBody, body)));
    }

    public boolean isMessageInfoContains(final String message) {
        return (new WebDriverWait(driver, 10)
            .until(textToBePresentInElement(messageInfo, message)));
    }

}
