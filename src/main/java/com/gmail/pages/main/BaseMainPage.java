package com.gmail.pages.main;

import com.gmail.pages.BasePage;
import com.gmail.panels.mail.NewMessagePanel;
import com.gmail.panels.info.AlertPanel;
import com.gmail.panels.main.HeaderPanel;
import com.gmail.panels.main.MessagesPanel;
import com.gmail.panels.main.NavigationPanel;
import com.gmail.panels.info.ConfirmDeletePanel;
import com.gmail.panels.users.AccountInfoPanel;

/**
 * Описывает базовую страницу для страниц работы с сообщениями. "Отправленные", "Черновики" и т.д.
 * Инициализирует общий для всех набор панелей. "Header", "Navigation" sidebar и т.д
 */
abstract public class BaseMainPage extends BasePage {

	private HeaderPanel headerPanel;
	private NewMessagePanel newMailPanel;
	private NavigationPanel navigationPanel;
	private MessagesPanel messagesPanel;
	private AlertPanel alertPanel;
	private ConfirmDeletePanel confirmDeletePanel;
	private AccountInfoPanel accountInfoPanel;

	public BaseMainPage() {
		super();
		headerPanel = new HeaderPanel();
		newMailPanel = new NewMessagePanel();
		navigationPanel = new NavigationPanel();
		messagesPanel = new MessagesPanel();
		alertPanel = new AlertPanel();
		confirmDeletePanel = new ConfirmDeletePanel();
		accountInfoPanel = new AccountInfoPanel();
	}

	public HeaderPanel getHeaderPanel() {
		return headerPanel;
	}

	public NewMessagePanel getNewMailPanel() {
		return newMailPanel;
	}

	public NavigationPanel getNavigationPanel() {
		return navigationPanel;
	}

	public MessagesPanel getMessagesPanel() {
		return messagesPanel;
	}

	public AlertPanel getAlertPanel() {
		return alertPanel;
	}

	public ConfirmDeletePanel getConfirmDeletePanel() {
		return confirmDeletePanel;
	}

	public AccountInfoPanel getAccountInfoPanel() {
		return accountInfoPanel;
	}

}
