package com.gmail.panels.main;

import com.gmail.panels.BasePanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Описывает блок навигации по страницам для работы с сообщениями
 */
public class NavigationPanel extends BasePanel {

	@FindBy(xpath = "//div[@gh='cm']")
	private WebElement newLetterButton;

	@FindBy(partialLinkText = "Отправленные")
	private WebElement sentLink;

	@FindBy(partialLinkText = "Черновики")
	private  WebElement draftLink;

	public NavigationPanel() {
		super();
	}

	public void clickNewLetterButton(){
		newLetterButton.click();
	}

	public void clickSentLink() {
		sentLink.click();
	}

	public void clickDraftLink() {
		draftLink.click();
	}

	public boolean isSentPageActive() {

		return (new WebDriverWait(driver, 10)).until(ExpectedConditions.urlContains("#sent"));

	}

	public boolean isDraftPageActive() {

		return (new WebDriverWait(driver, 10)).until(ExpectedConditions.urlContains("#draft"));

	}

	public int getNumberOfDrafts() {

		int numberOfDrafts = 0;

		Pattern pattern = Pattern.compile("([а-яА-Я]+)([ (]+(\\d+)[)]+)|([а-яА-Я]+)");

		Matcher matcher = pattern.matcher(draftLink.getText());

		while(matcher.find()) {

			if (matcher.group(3) != null) {

				numberOfDrafts = Integer.valueOf(matcher.group(3));

			}

		}

		return numberOfDrafts;

	}

	public boolean isNumberOfDraftsIncrease(int expected_number) {
		return (new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElement(draftLink, String.valueOf(expected_number))));
	}

}
