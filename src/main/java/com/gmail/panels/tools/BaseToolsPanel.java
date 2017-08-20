package com.gmail.panels.tools;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gmail.panels.BasePanel;

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
