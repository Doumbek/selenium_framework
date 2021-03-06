package com.gmail.tests.messages;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gmail.steps.messages.MessageCases;
import com.gmail.steps.users.UserCases;
import com.gmail.pages.main.DraftPage;
import com.gmail.pages.main.InboxPage;
import com.gmail.pages.users.LoginPage;
import com.gmail.providers.messages.MessagesDataProvider;
import com.gmail.dto.messages.TestMessage;
import com.gmail.dto.users.TestUser;
import com.gmail.tests.BaseTest;

public class DraftTest extends BaseTest {

    private LoginPage loginPage;
    private InboxPage inboxPage;
    private DraftPage draftPage;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        inboxPage = new InboxPage();
        draftPage = new DraftPage();
        loginPage = new LoginPage();
    }

    @Test(dataProvider = "forCreationData", dataProviderClass = MessagesDataProvider.class)
    public void shouldCreateDraft(TestUser user, TestMessage message) {
        loginPage.open();
        UserCases.login(loginPage, user);
        int numberOfDraftsBefore = inboxPage.getNavigationPanel().getNumberOfDrafts();
        MessageCases.createDraft(inboxPage, message);
        assertTrue(
            inboxPage.getNavigationPanel().isNumberOfDraftsIncrease(numberOfDraftsBefore + 1),
            "Number of drafts must be incremented by 1!");
        inboxPage.getNavigationPanel().clickDraftLink();
        assertTrue(
            draftPage.getMessagesPanel().isSubjectContains(message.getSubject()),
            "The firs part of draft must be message's subject!");
        assertTrue(
            draftPage.getMessagesPanel().isBodyContains(message.getBody()),
            "The second part of draft must contain message's body!");

    }

    @Test(dataProvider = "forDeletingData", dataProviderClass = MessagesDataProvider.class)
    public void shouldDeleteAllDraftMessages(TestUser user, TestMessage message) {
        loginPage.open();
        UserCases.login(loginPage, user);
        inboxPage.getNavigationPanel().clickDraftLink();
        inboxPage.getNavigationPanel().isDraftPageActive();
        MessageCases.deleteAllDraft(draftPage);
        assertTrue(
            draftPage.getMessagesPanel().isMessageInfoContains("You don't have any saved drafts"),
            "Expected no records in drafts!");
    }

}
