package com.gmail.pages.main;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import org.openqa.selenium.JavascriptExecutor;

/**
 * Описывает страницу "Входящие"
 */
public class InboxPage extends BaseMainPage {

	public InboxPage() {
		super();
	}

	public String getTitle() {

		String title;

//		title = driver.getTitle();
		title = ((JavascriptExecutor) driver).executeScript("var title = document.title; return title").toString();

		return title;

	}

}
