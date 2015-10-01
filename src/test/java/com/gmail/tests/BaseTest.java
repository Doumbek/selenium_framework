package com.gmail.tests;

import com.gmail.utils.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.uncommons.reportng.HTMLReporter;

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
