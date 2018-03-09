package com.twu.biblioteca.services;

import com.twu.biblioteca.BookListDraw;
import com.twu.biblioteca.BookManager;
import com.twu.biblioteca.pojos.Book;

import java.util.*;

public class BooksService {

    private List<Book> bookList;
    private List<Book> borrowedList;
    private BookManager bookManager;
    private static final String PADDING = "%n%-10s%s%n";

    public BooksService() {
        bookList = new ArrayList<Book>();
        borrowedList = new ArrayList<Book>();

        bookManager = new BookManager(this);

        generateBookList();
    }


    private void generateBookList() {

        bookList.add(new Book("Agile Analytics", "Ken Collier", 2012));
        bookList.add(new Book("Building Microservices", "Sam Newman", 2015));
        bookList.add(new Book("ReWork", "Jason Fried,David Heinemeier Hansson", 2010));

    }

    public void printBooksList() {
        System.out.print(BookListDraw.bookListGenerate(bookList));
    }

    private void printBorrowedList() {
        System.out.println(BookListDraw.bookListGenerate(borrowedList));
    }

    public void checkoutBook() {
        if (getBookList().isEmpty()) {
            System.out.println("Book List Is Empty!");
        }else{

            Scanner scanner = new Scanner(System.in);
            int bookNumber;

            try {
                System.out.print("Enter the number of the book > ");
                bookNumber = scanner.nextInt();
            } catch (InputMismatchException ex) {
                scanner.nextLine();
                bookNumber = 0;
            }

            bookManager.checkoutManager(bookNumber);
        }
    }

    public void returnBook() {

        this.printBorrowedList();

        if (!getBorrowedList().isEmpty()) {

            Scanner scanner = new Scanner(System.in);
            int bookNumber;

            try {
                System.out.print("Enter the number of the book > ");
                bookNumber = scanner.nextInt();
            } catch (InputMismatchException ex) {
                scanner.nextLine();
                bookNumber = 0;
            }

            bookManager.returnBookManager(bookNumber);
        }
    }


    public void checkoutBookSuccessfulMessage() {
        System.out.printf(PADDING, "", "Thank you! Enjoy the book");
    }

    public void returnBookSuccessfulMessage() {
        System.out.printf(PADDING, "", "Thank you for returning the book.");
    }

    public void checkoutBookUnsuccessfulMessage() {
        System.out.printf(PADDING, "", "That book is not available.");
    }

    public void returnBookUnsuccessfulMessage() {
        System.out.printf(PADDING, "", "That is not a valid book to return.");
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<Book> getBorrowedList() {
        return borrowedList;
    }

    public void setBorrowedList(List<Book> borrowedList) {
        this.borrowedList = borrowedList;
    }

    public void setBooksList(List<Book> booksList) {
        this.bookList = booksList;
    }
}
