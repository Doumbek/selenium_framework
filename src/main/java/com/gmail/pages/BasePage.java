package com.gmail.pages;

import org.openqa.selenium.WebDriver;

import com.gmail.utils.Config;
import com.gmail.utils.DriverManager;

abstract public class BasePage {

    protected String url = Config.getInstance().getBaseUrl();
    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverManager.getInstance();
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
