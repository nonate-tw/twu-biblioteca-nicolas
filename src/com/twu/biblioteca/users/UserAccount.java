package com.twu.biblioteca.users;

public class UserAccount {

    private User user;

    private static UserAccount userAccount;

    public static UserAccount getInstance() {
        if (userAccount == null)
            return new UserAccount();
        return userAccount;
    }

    public UserAccount() {
    }

    public boolean login(String libraryNumber, String password) {
        return libraryNumber.equals(user.getLibraryNumber())
                && password.equals(user.getPassword());
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserInformation() {
        StringBuilder userInformation = new StringBuilder();

        userInformation.append(String.format("%s: %s%n", "Name", this.user.getName()));
        userInformation.append(String.format("%s: %s%n", "Email", this.user.getEmail()));
        userInformation.append(String.format("%s: %s%n", "Phone Number", this.user.getPhoneNumber()));

        return userInformation.toString();
    }
}
