package com.gmail.panels.tools;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SentToolsPanel extends BaseToolsPanel {

    @FindBy(xpath = "//div[@gh='mtb']//div[@act='10']")
    private WebElement deleteButton;

    public SentToolsPanel() {
        super();
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

}
