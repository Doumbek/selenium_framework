package com.gmail.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.xml.bind.SchemaOutputResolver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Управляет обьектом driver
 */
public class DriverManager {

	private final static String URL = Config.getInstance().getHubUrl();

	private static String browser = System.getProperty("browser");
	private static boolean isMaximizeWindow = Boolean.valueOf(System.getProperty("isMaximizeWindow"));
	private static boolean isRemote = Boolean.valueOf(System.getProperty("isRemote"));

	private static WebDriver driver;

	private DriverManager() {}

	/**
	 * Singleton
	 * @return driver
	 */
	public static WebDriver getInstance() {

		if(driver == null || hasQuite()) {

			driver = initDriver();

			manageDriver(driver);

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
	private static WebDriver initDriver(){

		WebDriver driver;

		if(!isRemote) {

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

		} else {

			driver = setRemoteDriver();

		}

		return driver;

	}

	/**
	 * Настраиваем драйвер
	 * @param driver WebDriver
	 */
	private static void manageDriver(WebDriver driver) {

		if(isMaximizeWindow) {
			driver.manage().window().maximize();
		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	/**
	 * Возвращаем драйвер для удаленного запуска
	 * @return RemoteWebDriver
	 */
	private static WebDriver setRemoteDriver(){

		DesiredCapabilities capabilities;
		WebDriver driver = null;

		capabilities = setCapabilities();

		try {

			driver = new RemoteWebDriver(new URL(URL), capabilities);

		} catch (MalformedURLException e) {

			System.out.println(e.getMessage());

		}

		return driver;

	}

	/**
	 * Устанавливает предпочтения в зависимости от указаного браузера
	 * @return capabilities
	 */
	private static DesiredCapabilities setCapabilities() {

		DesiredCapabilities capabilities;

		switch (browser) {

			case "firefox":
				capabilities = DesiredCapabilities.firefox();
				break;

			case "ie":
				capabilities = DesiredCapabilities.internetExplorer();
				break;

			case "html":
				capabilities = DesiredCapabilities.htmlUnit();
				break;

			case "chrome":
			default:
				capabilities = DesiredCapabilities.chrome();
				break;

		}

		return capabilities;
	}

	/**
	 * Проверяет активна или нет текущая сессия driver
	 * @return boolean
	 */
	private static boolean hasQuite() {
		return (driver.toString().contains("(null)"));
	}

}
