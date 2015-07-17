package com.gmail.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.concurrent.TimeUnit;

/**
 * Управляет обьектом driver
 */
public class DriverManager {

	private static String browser = System.getProperty("browser");
	private static boolean isMaximizeWindow = Boolean.valueOf(System.getProperty("isMaximizeWindow"));

	private static WebDriver driver;

	private DriverManager() {}

	/**
	 * Singleton
	 * @return driver
	 */
	public static WebDriver getInstance() {

		if(driver == null || hasQuite()) {

			driver = initDriver();

		}

		return driver;

	}

	/**
	 * Закрывает текущую сессию и 'обнуляет' driver
	 */
	public static void closeSession() {

		driver.quit();

		driver = null;

	}

	/**
	 * Инициализирует driver и разворачивает окно браузера в зависимости от параметров окружения 'browser' и 'isMaximizeWindow'
	 * Устанавливает неявные ожидания
	 * @return driver
	 */
	private static WebDriver initDriver() {

		WebDriver driver;

		switch (browser) {

			case "firefox":
				driver = new FirefoxDriver();
				break;

			case "ie":
				driver = new InternetExplorerDriver();
				break;

			case "html":
				driver = new HtmlUnitDriver();
				break;

			case "chrome":
			default:
				driver = new ChromeDriver();
				break;

		}

		if(isMaximizeWindow) {

			driver.manage().window().maximize();

		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		return driver;

	}

	/**
	 * Проверяет активна или нет текущая сессия driver
	 * @return boolean
	 */
	private static boolean hasQuite() {
		return (driver.toString().contains("(null)"));
	}

}
