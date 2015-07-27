package com.gmail.tests.messages;

import com.gmail.tests.BaseTest;
import com.gmail.cases.messages.MessageCases;
import com.gmail.cases.users.UserCases;
import com.gmail.pages.main.DraftPage;
import com.gmail.pages.main.InboxPage;
import com.gmail.pages.users.LoginPage;
import com.gmail.providers.messages.MessagesDataProvider;
import com.gmail.test_objects.messages.TestMessage;
import com.gmail.test_objects.users.TestUser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

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

	@Test(dataProvider = "forCreationData",
			dataProviderClass = MessagesDataProvider.class)
	public void shouldCreateDraft(TestUser user, TestMessage message){

		logger.info("Check creation of draft message ");

		loginPage.open();

		UserCases.login(loginPage, user);

		int numberOfDraftsBefore = inboxPage.getNavigationPanel().getNumberOfDrafts();

		MessageCases.createDraft(inboxPage, message);

		assertTrue(
				inboxPage.getNavigationPanel().isNumberOfDraftsIncrease(numberOfDraftsBefore + 1),
				"Number of drafts must be incremented by 1!"
		);

		inboxPage.getNavigationPanel().clickDraftLink();

		assertTrue(
				draftPage.getMessagesPanel().isSubjectContains(message.getSubject()),
				"The firs part of draft must be message's subject!"
		);

		assertTrue(
				draftPage.getMessagesPanel().isBodyContains(message.getBody()),
				"The second part of draft must contain message's body!"
		);

	}

	@Test(dataProvider = "forDeletingData",
			dataProviderClass = MessagesDataProvider.class)
	public void shouldDeleteAllSentMessages(TestUser user, TestMessage message) {

		logger.info("Check deletion of all draft messages");

		loginPage.open();

		UserCases.login(loginPage, user);

		MessageCases.sendMessage(inboxPage, message);

		inboxPage.getNavigationPanel().clickDraftLink();

		inboxPage.getNavigationPanel().isDraftPageActive();

		MessageCases.deleteAllDraft(draftPage);

		assertTrue(
				draftPage.getMessagesPanel().isMessageInfoContains("Нет сохраненных черновиков"),
				"Expected no records in drafts!"
		);

	}

}
