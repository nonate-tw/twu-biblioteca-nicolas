package com.twu.biblioteca;

import com.twu.biblioteca.pojos.Book;

import java.util.*;

public class BooksService {

    private List<Book> bookList;
    private List<Book> borrowedList;

    public BooksService() {
        bookList = new ArrayList<Book>();
        borrowedList = new ArrayList<Book>();

        generateBookList();
    }


    public void generateBookList() {

        bookList.add(new Book("Agile Analytics", "Ken Collier", 2012));
        bookList.add(new Book("Building Microservices", "Sam Newman", 2015));
        bookList.add(new Book("ReWork", "Jason Fried,David Heinemeier Hansson", 2010));

    }

    public void printBooksList() {
        System.out.print(MenuDraw.bookListGenerate(bookList));
    }

    public void printBorrowedList() {
        System.out.println(MenuDraw.bookListGenerate(borrowedList));
    }

    public void checkoutBook() {
        if (!getBookList().isEmpty()) {

            Scanner scanner = new Scanner(System.in);
            int bookNumber = scanner.nextInt();

            checkoutManager(bookNumber);
        }

    }

    public boolean checkoutManager(int bookNumber) {
        if (bookNumber > 0 && bookNumber <= getBookList().size()) {

            Book book = getBookList().get(bookNumber - 1);

            checkout(book);

            checkoutBookSuccessfulMessage();

            return true;
        }

        checkoutBookUnsuccessfulMessage();
        return false;
    }

    public void checkout(Book book) {
        getBookList().remove(book);
        getBorrowedList().add(book);
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public List<Book> getBorrowedList() {
        return borrowedList;
    }

    private void checkoutBookSuccessfulMessage() {
        System.out.printf("%n%-10s%s%n", "", "Thank you! Enjoy the book");
    }

    private void returnBookSuccessfulMessage() {
        System.out.printf("%n%-10s%s%n", "", "Thank you for returning the book.");
    }

    private void checkoutBookUnsuccessfulMessage() {
        System.out.printf("%n%-10s%s%n", "", "That book is not available.");
    }

    private void returnBookUnsucessfulMessage() {
        System.out.printf("%n%-10s%s%n", "", "That is not a valid book to return.");
    }

    /*public boolean manageBookSelection(int bookSelected, List<Book> bookList, boolean returnBook) {
        if (bookSelected > 0 && bookSelected <= bookList.size()) {
            if (!returnBook) {
                checkout(bookList.get(bookSelected - 1));
            } else {
                returnBook(bookSelected - 1);
            }
            successfulMessage(returnBook);
            return true;
        }
        unsuccessfulMessage(returnBook);
        return false;
    }*/

    public void returnBook() {

        this.printBorrowedList();

        if (!getBorrowedList().isEmpty()) {

            Scanner scanner = new Scanner(System.in);
            int bookNumber = scanner.nextInt();

            returnBookManager(bookNumber);
        }
    }

    public boolean returnBookManager(int bookNumber) {
        if (bookNumber > 0 && bookNumber <= getBorrowedList().size()) {

            Book book = getBorrowedList().get(bookNumber - 1);

            getBorrowedList().remove(book);
            getBookList().add(book);

            returnBookSuccessfulMessage();

            return true;
        }

        returnBookUnsucessfulMessage();
        return false;
    }

    public void setBorrowedList(List<Book> borrowedList) {
        this.borrowedList = borrowedList;
    }

    public void setBooksList(List<Book> booksList) {
        this.bookList = booksList;
    }
}
