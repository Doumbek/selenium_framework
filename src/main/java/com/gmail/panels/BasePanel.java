package com.gmail.panels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.gmail.utils.DriverManager;

abstract public class BasePanel {

    protected WebDriver driver;
    protected Actions actions;

    public BasePanel() {
        this.driver = DriverManager.getInstance();
        this.actions = new Actions(this.driver);
        PageFactory.initElements(this.driver, this);
    }

}
