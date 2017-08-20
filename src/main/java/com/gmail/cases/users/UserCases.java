package com.gmail.cases.users;

import com.gmail.pages.main.BaseMainPage;
import com.gmail.pages.users.LoginPage;
import com.gmail.test_objects.users.TestUser;

public class UserCases {

    public static void login(LoginPage page, TestUser user) {
        page.getLoginPanel().setLogin(user.getLogin());
        page.getLoginPanel().clickNextButton();
        page.getPasswordPanel().setPassword(user.getPassword());
        page.getPasswordPanel().clickEnterButton();

    }

    public static void logout(BaseMainPage page) {
        page.getHeaderPanel().clickAccountLink();
        page.getAccountInfoPanel().clickLogoutButton();
    }

}
