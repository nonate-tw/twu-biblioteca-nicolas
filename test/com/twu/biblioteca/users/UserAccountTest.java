package com.twu.biblioteca.users;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserAccountTest {

    private User user;

    @Before
    public void setup() {

        user = new User("Nicolás", "nonate@thoughtworks.com", "11111111");
        user.setLibraryNumber("000-1111");
        user.setPassword("123");
    }

    @Test
    public void userLoginTest() {

        UserAccount userAccount = UserAccount.getInstance();
        userAccount.setUser(user);

        String libraryNumber = "000-1111";
        String password = "123";
        boolean loginSuccessful = userAccount.login(libraryNumber, password);

        assertTrue(loginSuccessful);
    }

    @Test
    public void userInformationTest() {

        UserAccount userAccount = UserAccount.getInstance();
        userAccount.setUser(user);

        String userInformationExpected = "Name: Nicolás\n" +
                "Email: nonate@thoughtworks.com\n" +
                "Phone Number: 11111111\n";

        assertEquals(userInformationExpected, userAccount.getUserInformation());

    }
}
