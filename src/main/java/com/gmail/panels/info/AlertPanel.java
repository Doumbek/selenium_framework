package com.gmail.panels.info;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gmail.panels.BasePanel;

public class AlertPanel extends BasePanel{

    @FindBy(xpath = "//div[@role='alert']//div[@class='vh']")
    private WebElement confirmAlert;

    public AlertPanel() {
        super();
    }

    public boolean isAlertContainsText(final String text) {
        return (new WebDriverWait(driver, 10))
            .until(textToBePresentInElement(confirmAlert, text));
    }

}
