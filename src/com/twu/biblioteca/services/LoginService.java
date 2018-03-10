package com.twu.biblioteca.services;

import com.twu.biblioteca.users.User;
import com.twu.biblioteca.users.UserAccount;

import java.util.Scanner;

public class LoginService {

    private UserAccount userAccount;
    private boolean isUserSessionStarted;

    public LoginService() {
        userAccount = UserAccount.getInstance();

        User user = new User("Nicolás Oñate", "nonate@thoughtworks.com", "1234567");
        user.setLibraryNumber("111-2233");
        user.setPassword("12345");
        userAccount.setUser(user);
    }

    public void loginUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please, enter your library number: ");
        String libraryNumber = scanner.nextLine();
        System.out.print("Please, enter your password: ");
        String password = scanner.nextLine();

        isUserSessionStarted = userAccount.login(libraryNumber, password);
        if (!isUserSessionStarted) {
            unsuccessfulLoginMessage();
        }
    }

    public boolean isLogin() {
        return this.isUserSessionStarted;
    }

    private void unsuccessfulLoginMessage() {
        System.out.println("Incorrect Credentials!");
    }

    public void getUserInfo() {
        System.out.println(userAccount.getUserInformation());
    }
}
