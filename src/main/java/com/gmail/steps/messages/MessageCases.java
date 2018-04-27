package com.gmail.steps.messages;

import com.gmail.pages.main.BaseMainPage;
import com.gmail.pages.main.DraftPage;
import com.gmail.pages.main.SentPage;
import com.gmail.dto.messages.TestMessage;

public class MessageCases {

    public static void sendMessage(BaseMainPage page, TestMessage message) {
        openNewMessagePopupAndFill(page, message);
        page.getNewMailPanel().clickSendButton();
    }

    public static void createDraft(BaseMainPage page, TestMessage message) {
        openNewMessagePopupAndFill(page, message);
        page.getNewMailPanel().clickClosePopupButton();
    }

    public static void deleteAllSentMessages(SentPage page) {
        page.getSentToolsPanel().checkAllCheckbox();
        page.getSentToolsPanel().clickDeleteButton();
//        page.getConfirmDeletePanel().clickOkButton();

    }

    public static void deleteAllDraft(DraftPage page) {
        page.getDraftToolsPanel().checkAllCheckbox();
        page.getDraftToolsPanel().clickDeleteButton();
    }

    private static void openNewMessagePopupAndFill(BaseMainPage page, TestMessage message) {
        page.getNavigationPanel().clickNewLetterButton();
        page.getNewMailPanel().setTo(message.getTo());
        page.getNewMailPanel().setSubject(message.getSubject());
        page.getNewMailPanel().setBody(message.getBody());
    }



}
