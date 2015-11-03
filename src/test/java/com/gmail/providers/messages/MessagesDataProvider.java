package com.gmail.providers.messages;

import com.gmail.test_objects.messages.TestMessage;
import com.gmail.test_objects.users.TestUser;
import com.gmail.utils.bo_creator.DataLoader;
import org.testng.annotations.DataProvider;

public class MessagesDataProvider {

	private static TestUser testUser = new TestUser(DataLoader.loadXmlUsersSAX("users.xml", "Bart"));
	private static TestMessage firstTestMessage = new TestMessage("firstMessage.properties");

	@DataProvider
	public static Object[][] forCreationData() {

		return  new Object[][] {
				{testUser, firstTestMessage}};
	}

	@DataProvider
	public static Object[][] forDeletingData() {

		return  new Object[][] {
				{testUser, firstTestMessage}
		};
	}

}
