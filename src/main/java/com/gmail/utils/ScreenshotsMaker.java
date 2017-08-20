package com.gmail.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

public class ScreenshotsMaker {

    private static final String PATH_TOSCREENSHOTS_FOLDER = "screenshots";
    private static Logger logger = LogManager.getLogger(ScreenshotsMaker.class);

    public static void makeScreenshot() {
        File screenshot = ((TakesScreenshot) DriverManager.getInstance()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFileToDirectory(screenshot, new File(PATH_TOSCREENSHOTS_FOLDER));
        } catch (IOException e) {
            logger.error("We have problem with copy file: Details\n" + e.getMessage());
        }
    }

    public static void makeScreenshotWithHighlight(final WebElement element) {
        String origin_background = element.getCssValue("backgroundColor");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverManager.getInstance();
        javascriptExecutor.executeScript("arguments[0].style.backgroundColor = 'red'", element);
        makeScreenshot();
        javascriptExecutor.executeScript("arguments[0].style.backgroundColor = '" + origin_background + "'", element);
    }

}
