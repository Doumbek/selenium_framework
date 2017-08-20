package com.gmail.panels.users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gmail.panels.BasePanel;

public class LoginPanel extends BasePanel {

    @FindBy(xpath = "//input[@type='email']")
    private WebElement loginInput;

    @FindBy(xpath = "//div[@id='identifierNext']")
    private WebElement nextButton;

    public LoginPanel() {
        super();
    }

    public void setLogin(final String login) {
        loginInput.sendKeys(login);
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public WebElement getLoginInput() {
        return loginInput;
    }

}
