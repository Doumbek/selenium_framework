package com.gmail.panels.main;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gmail.panels.BasePanel;

public class HeaderPanel extends BasePanel {

    @FindBy(xpath = ".//a[contains(@href, 'https://accounts.google.com/SignOutOptions')]")
    private WebElement accountLink;

    public HeaderPanel() {
        super();
    }

    public boolean isAccountLinkPresented() {
        return (new WebDriverWait(driver, 10))
            .until(visibilityOf(accountLink)).isDisplayed();
    }

    public void clickAccountLink() {
        (new WebDriverWait(driver, 10))
            .until(elementToBeClickable(accountLink)).click();
    }

    public WebElement getAccountLink() {
        return accountLink;
    }

}
