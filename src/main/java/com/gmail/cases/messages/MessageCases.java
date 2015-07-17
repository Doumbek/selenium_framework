package com.gmail.cases.messages;

import com.gmail.pages.main.BaseMainPage;
import com.gmail.pages.main.DraftPage;
import com.gmail.pages.main.SentPage;
import com.gmail.test_objects.messages.TestMessage;

public class MessageCases {

	/**
	 * Открывает попап отправки нового письма, заполняет форму и отпровляет
	 * @param page текущая страница, с которой вызывается
	 * @param message Обьект письма. Содержит to, subject, body
	 */
	public static void sendMessage(BaseMainPage page, TestMessage message) {

		openNewMessagePopupAndFill(page, message);
		page.getNewMailPanel().clickSendButton();

	}

	/**
	 * Открывает попап отправки нового письма, заполняет форму и закрывает попап
	 * @param page текущая страница, с которой вызывается
	 * @param message Обьект письма. Содержит to, subject, body
	 */
	public static void createDraft(BaseMainPage page, TestMessage message) {

		openNewMessagePopupAndFill(page, message);
		page.getNewMailPanel().clickClosePopupButton();

	}

	/**
	 * Удаляет все отправленные сообщения. Вызывается со страницы "Отправленные"
	 * @param page страница "Отправленные"
	 */
	public static void deleteAllSentMessages(SentPage page) {

		page.getSentToolsPanel().checkAllCheckbox();
		page.getSentToolsPanel().clickDeleteButton();
		page.getConfirmDeletePanel().clickOkButton();

	}

	/**
	 * Удаляет все отправленные сообщения. Вызывается со страницы "Черновики"
	 * @param page страница "Черновики"
	 */
	public static void deleteAllDraft(DraftPage page) {

		page.getDraftToolsPanel().checkAllCheckbox();
		page.getDraftToolsPanel().clickDeleteButton();

	}

	/**
	 * Открывает попап отправки нового письма и заполняет форму
	 * @param page текущая страница, с которой вызывается
	 * @param message Обьект письма. Содержит to, subject, body
	 */
	private static void openNewMessagePopupAndFill(BaseMainPage page, TestMessage message) {

		page.getNavigationPanel().clickNewLetterButton();
		page.getNewMailPanel().setTo(message.getTo());
		page.getNewMailPanel().setSubject(message.getSubject());
		page.getNewMailPanel().setBody(message.getBody());

	}



}
