package com.gmail.utils;

import static com.gmail.properties.FrameworkProperties.REMOTE_HUB_URL;
import static com.gmail.properties.WebdriverProperties.WEBDRIVER_BROWSER_NAME;
import static com.gmail.properties.WebdriverProperties.WEBDRIVER_CHROME_DRIVER_PATH;
import static com.gmail.properties.WebdriverProperties.WEBDRIVER_GECKO_DRIVER_PATH;
import static com.gmail.properties.WebdriverProperties.WEBDRIVER_IS_USE_REMOTE_DRIVER;
import static com.gmail.properties.WebdriverProperties.WEBDRIVER_IS_WINDOW_MAXIMIZED;
import static java.lang.System.setProperty;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {

    private static final String BROWSER_NAME = WEBDRIVER_BROWSER_NAME.readProperty();
    private static final Boolean USE_REMOTE_DRIVER = WEBDRIVER_IS_USE_REMOTE_DRIVER.readProperty();
    private static final URL REMOTE_HUB = REMOTE_HUB_URL.readProperty();
    private static final String WEBDRIVER_CHROME_DRIVER = WEBDRIVER_CHROME_DRIVER_PATH.readProperty();
    private static final String WEBDRIVER_GECKO_DRIVER = WEBDRIVER_GECKO_DRIVER_PATH.readProperty();

    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getInstance() {
        if (driver == null || hasQuite()) {
            driver = initDriver();
            manageDriver();
        }
        return driver;
    }

    public static void closeSession() {
        driver.quit();
        driver = null;
    }

    private static WebDriver initDriver() {
        WebDriver driver;
        if (!USE_REMOTE_DRIVER) {
            switch (BROWSER_NAME) {
                case "firefox":
                    setProperty("webdriver.gecko.driver", WEBDRIVER_GECKO_DRIVER);
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                default:
                    setProperty("webdriver.chrome.driver", WEBDRIVER_CHROME_DRIVER);
                    driver = new ChromeDriver();
                    break;
            }
        } else {
            driver = setRemoteDriver();
        }
        return driver;
    }

    private static void manageDriver() {
        if (WEBDRIVER_IS_WINDOW_MAXIMIZED.readProperty()) {
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    private static WebDriver setRemoteDriver() {
        DesiredCapabilities capabilities;
        WebDriver driver = null;
        capabilities = setCapabilities();
        driver = new RemoteWebDriver(REMOTE_HUB, capabilities);
        return driver;
    }

    private static DesiredCapabilities setCapabilities() {
        DesiredCapabilities capabilities;
        switch (BROWSER_NAME) {
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

    private static boolean hasQuite() {
        return (driver.toString().contains("(null)"));
    }

}
