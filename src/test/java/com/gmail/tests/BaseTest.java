package com.gmail.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.uncommons.reportng.HTMLReporter;

import com.gmail.utils.DriverManager;

@Listeners({HTMLReporter.class})
abstract public class BaseTest {

    protected Logger logger = LogManager.getLogger(this.getClass());
    protected WebDriver driver;

    @BeforeMethod()
    public void setUp() {
        driver = DriverManager.getInstance();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.closeSession();
    }

}
