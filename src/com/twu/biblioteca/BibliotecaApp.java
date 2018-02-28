package com.twu.biblioteca;

import com.twu.biblioteca.pojos.Book;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BibliotecaApp {

    private static Scanner scan;


    public static void main(String[] args) {

        System.out.println(welcomeMessage());

    }

    public static String welcomeMessage() {
        return "Welcome to Biblioteca!";
    }

    public static List<Book> booksList() {

        Scanner scan = null;
        List<Book> bookList = new ArrayList<Book>();
        try {

            scan = new Scanner(new File("books.txt"));

            while (scan.hasNextLine()) {
                bookList.add(new Book(scan.nextLine(), null, 0));
            }
        }catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        return bookList;
    }

}
