package com.gmail.tests;

import com.gmail.utils.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

abstract public class BaseTest {

	protected Logger logger = LogManager.getLogger(this.getClass());

	protected WebDriver driver;
	protected Actions actions;



	@BeforeMethod()
	public void setUp() {

		driver = DriverManager.getInstance();

		actions = new Actions(driver);

	}

	@AfterMethod
	public void tearDown() {

		DriverManager.closeSession();

	}

}
