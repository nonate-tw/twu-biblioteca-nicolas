package com.twu.biblioteca;

import com.twu.biblioteca.menu.Menu;

public class BibliotecaApp {

    public static void main(String[] args) {

        System.out.println(welcomeMessage());

        Menu menu = new Menu();

        menu.printMenu();
    }

    public static String welcomeMessage() {
        return "Welcome to Biblioteca!";
    }
}
