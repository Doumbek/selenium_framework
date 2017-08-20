package com.gmail.panels.users;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gmail.panels.BasePanel;

public class AccountInfoPanel extends BasePanel {

    @FindBy(xpath = ".//a[contains(@href, 'https://accounts.google.com/Logout')]")
    private WebElement logoutButton;

    public AccountInfoPanel() {
        super();
    }

    public void clickLogoutButton() {
        (new WebDriverWait(driver, 10))
            .until(visibilityOf(logoutButton)).click();
    }

}
