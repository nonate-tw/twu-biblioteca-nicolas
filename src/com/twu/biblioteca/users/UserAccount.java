package com.twu.biblioteca.users;

public class UserAccount {

    private User user;

    private boolean userSessionStarted;
    private static UserAccount userAccount;


    public static UserAccount getInstance() {
        if (userAccount == null)
            return new UserAccount();
        return userAccount;
    }

    public UserAccount() {
        this.user = user;
        this.userSessionStarted = false;
    }

    public boolean login(String libraryNumber, String password) {

        return userSessionStarted = libraryNumber.equals(user.getLibraryNumber())
                && password.equals(user.getPassword());
    }

    public boolean isUserSessionStarted() {
        return userSessionStarted;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
