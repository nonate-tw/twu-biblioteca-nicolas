package com.twu.biblioteca;

public class BibliotecaApp {

    public static BooksService booksService;

    static {
        booksService = new BooksService();
    }

    public static void main(String[] args) {

        System.out.println(welcomeMessage());

        booksService.printBooksList();

    }

    public static String welcomeMessage() {
        return "Welcome to Biblioteca!";
    }



}
