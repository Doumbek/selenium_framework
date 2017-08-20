package com.gmail.tests.messages;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gmail.cases.messages.MessageCases;
import com.gmail.cases.users.UserCases;
import com.gmail.pages.main.InboxPage;
import com.gmail.pages.main.SentPage;
import com.gmail.pages.users.LoginPage;
import com.gmail.providers.messages.MessagesDataProvider;
import com.gmail.test_objects.messages.TestMessage;
import com.gmail.test_objects.users.TestUser;
import com.gmail.tests.BaseTest;

public class SentTest extends BaseTest {

    private LoginPage loginPage;
    private InboxPage inboxPage;
    private SentPage sentPage;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        inboxPage = new InboxPage();
        sentPage = new SentPage();
        loginPage = new LoginPage();
    }

    @Test(dataProvider = "forCreationData", dataProviderClass = MessagesDataProvider.class)
    public void shouldSendEmail(TestUser user, TestMessage message) {
        loginPage.open();
        UserCases.login(loginPage, user);
        MessageCases.sendMessage(inboxPage, message);
        assertTrue(inboxPage.getAlertPanel().isAlertContainsText("Your message has been sent."));
        inboxPage.getNavigationPanel().clickSentLink();
        assertTrue(
            sentPage.getMessagesPanel().isSubjectContains(message.getSubject()),
            "The firs part of draft must be message's subject!");
        assertTrue(
            sentPage.getMessagesPanel().isBodyContains(message.getBody()),
            "The second part of draft must contain message's body!");
    }

    @Test(dataProvider = "forDeletingData", dataProviderClass = MessagesDataProvider.class)
    public void shouldDeleteAllSentMessages(TestUser user, TestMessage message) {
        loginPage.open();
        UserCases.login(loginPage, user);
        MessageCases.sendMessage(inboxPage, message);
        inboxPage.getNavigationPanel().clickSentLink();
        inboxPage.getNavigationPanel().isSentPageActive();
        MessageCases.deleteAllSentMessages(sentPage);
        assertTrue(
            sentPage.getMessagesPanel().isMessageInfoContains("No sent messages!"),
            "Expected no records in sent!");
    }

}
