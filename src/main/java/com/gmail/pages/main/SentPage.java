package com.gmail.pages.main;

import com.gmail.panels.tools.SentToolsPanel;

public class SentPage extends BaseMainPage {

    private SentToolsPanel sentToolsPanel;

    public SentPage() {
        super();
        sentToolsPanel = new SentToolsPanel();
    }

    public SentToolsPanel getSentToolsPanel() {
        return sentToolsPanel;
    }

}
