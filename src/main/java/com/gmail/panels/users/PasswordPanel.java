package com.gmail.panels.users;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gmail.panels.BasePanel;

public class PasswordPanel extends BasePanel {

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[@id='passwordNext']")
    private WebElement enterButton;

    public PasswordPanel() {
        super();
    }

    public boolean isPasswordInputDisplayed() {
        return passwordInput.isDisplayed();
    }

    public void setPassword(final String password) {
        new WebDriverWait(driver, 10)
            .until(visibilityOf(passwordInput));
        passwordInput.sendKeys(password);
    }

    public void clickEnterButton() {
        enterButton.click();
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

}
