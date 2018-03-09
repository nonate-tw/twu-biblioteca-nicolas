package com.twu.biblioteca.users;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UserAccountTest {

    @Test
    public void userLoginTest() {

        User user = new User("Nicolás", "nonate@thoughtworks.com", "11111111");
        user.setLibraryNumber("000-1111");
        user.setPassword("123");
        UserAccount userAccount = UserAccount.getInstance();

        userAccount.setUser(user);

        String libraryNumber = "000-1111";
        String password = "123";
        boolean loginSuccessful = userAccount.login(libraryNumber, password);

        assertTrue(loginSuccessful);
    }
}
