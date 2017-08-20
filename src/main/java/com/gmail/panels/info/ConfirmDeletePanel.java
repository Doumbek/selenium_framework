package com.gmail.panels.info;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gmail.panels.BasePanel;

public class ConfirmDeletePanel extends BasePanel {

    @FindBy(xpath = "//button[@name='ok']")
    private WebElement okButton;

    public ConfirmDeletePanel() {
        super();
    }

    public void clickOkButton() {
        (new WebDriverWait(driver, 10))
            .until(elementToBeClickable(okButton)).click();
    }

}
