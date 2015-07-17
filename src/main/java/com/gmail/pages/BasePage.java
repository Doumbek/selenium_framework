package com.gmail.pages;

import com.gmail.utils.Config;
import com.gmail.utils.DriverManager;
import org.openqa.selenium.WebDriver;

/**
 * Описывает общую базовую страницу
 * Инициализирует driver и общие параметры для тестов(url и т.д)
 */
abstract public class BasePage {

	protected String url = Config.getInstance().getBaseUrl();

	protected WebDriver driver;

	public BasePage() {
		this.driver = DriverManager.getInstance();
	}

}
