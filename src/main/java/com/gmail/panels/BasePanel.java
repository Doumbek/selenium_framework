package com.gmail.panels;

import com.gmail.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Описывает общую базовыую панель
 * Инициализирует driver и элементы страниц
 */
abstract public class BasePanel {

	protected WebDriver driver;

	public BasePanel() {
		this.driver = DriverManager.getInstance();
		PageFactory.initElements(this.driver, this);
	}

}
