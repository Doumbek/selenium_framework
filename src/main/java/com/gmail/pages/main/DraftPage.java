package com.gmail.pages.main;

import com.gmail.panels.tools.DraftToolsPanel;

/**
 * Описывает страницу "Черновики"
 */
public class DraftPage extends BaseMainPage {

	private DraftToolsPanel draftToolsPanel;

	public DraftPage() {
		super();
		draftToolsPanel = new DraftToolsPanel();
	}

	public DraftToolsPanel getDraftToolsPanel() {
		return draftToolsPanel;
	}

}
