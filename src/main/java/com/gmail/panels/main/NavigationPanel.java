package com.gmail.panels.main;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gmail.panels.BasePanel;

public class NavigationPanel extends BasePanel {

    @FindBy(xpath = "//div[@gh='cm']")
    private WebElement newLetterButton;

    @FindBy(partialLinkText = "Sent Mail")
    private WebElement sentLink;

    @FindBy(partialLinkText = "Drafts")
    private WebElement draftLink;

    public NavigationPanel() {
        super();
    }

    public void clickNewLetterButton() {
        (new WebDriverWait(driver, 10))
            .until(elementToBeClickable(newLetterButton)).click();
    }

    public void clickSentLink() {
        sentLink.click();
    }

    public void clickDraftLink() {
        draftLink.click();
    }

    public boolean isSentPageActive() {
        return (new WebDriverWait(driver, 10))
            .until(urlContains("#sent"));
    }

    public boolean isDraftPageActive() {
        return (new WebDriverWait(driver, 10))
            .until(urlContains("#draft"));
    }

    public int getNumberOfDrafts() {
        int numberOfDrafts = 0;
        final Pattern pattern = Pattern.compile("([a-zA-Z]+)([ (]+(\\d+)[)]+)|([a-zA-Z]+)");
        final Matcher matcher = pattern.matcher(draftLink.getText());
        while (matcher.find()) {
            if (matcher.group(3) != null) {
                numberOfDrafts = Integer.valueOf(matcher.group(3));
            }
        }
        return numberOfDrafts;
    }

    public boolean isNumberOfDraftsIncrease(int expected_number) {
        return (new WebDriverWait(driver, 10)
            .until(textToBePresentInElement(draftLink, String.valueOf(expected_number))));
    }

}
