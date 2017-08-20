package com.gmail.test_objects.users;

import java.util.Map;

public class TestUser {

    private String login;
    private String password;

    public TestUser(final Map<String, String> userValues) {
        this.login = userValues.get("login");
        this.password = userValues.get("password");
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "TestUser{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
