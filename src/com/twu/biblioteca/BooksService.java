package com.twu.biblioteca;

import com.twu.biblioteca.pojos.Book;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BooksService {

    private List<Book> bookList;

    public BooksService() {
    }

    public List<Book> getBookList() {

        Scanner scan = null;
        bookList = new ArrayList<Book>();
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

    public void printBooksList() {

        getBookList();

        System.out.println("============================");
        System.out.println("        List of Books       ");
        System.out.println("============================");
        for (Book book: bookList){

            System.out.printf("%s%n", book.getName());
        }
        System.out.println("============================");
    }
}
