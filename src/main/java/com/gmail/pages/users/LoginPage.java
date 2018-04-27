package com.gmail.pages.users;

import static com.gmail.properties.FrameworkProperties.GMAIL_BASE_URL;

import com.gmail.pages.BasePage;
import com.gmail.panels.users.LoginPanel;
import com.gmail.panels.users.PasswordPanel;

public class LoginPage extends BasePage{

    private LoginPanel loginPanel;
    private PasswordPanel passwordPanel;

    public LoginPage() {
        super();
        loginPanel = new LoginPanel();
        passwordPanel = new PasswordPanel();
    }

    public void open() {
        driver.get(GMAIL_BASE_URL.readProperty());
    }

    public LoginPanel getLoginPanel() {
        return loginPanel;
    }

    public PasswordPanel getPasswordPanel() {
        return passwordPanel;
    }

}
