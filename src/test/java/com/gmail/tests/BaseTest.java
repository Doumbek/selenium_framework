package com.gmail.tests;

import com.gmail.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

abstract public class BaseTest {

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
