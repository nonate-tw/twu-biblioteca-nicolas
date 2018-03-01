package com.twu.biblioteca;

import com.twu.biblioteca.pojos.Book;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BooksService {

    private List<Book> bookList;
    private List<Book> borrowedList;

    public BooksService() {
        bookList = new ArrayList<Book>();
        borrowedList = new ArrayList<Book>();
    }

    public List<Book> getBookList() {

        Scanner scan;
        try {

            scan = new Scanner(new File("books.txt"));

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                StringTokenizer stk = new StringTokenizer(line, "_");
                try{
                    bookList.add(new Book(stk.nextToken(), stk.nextToken(), Integer.parseInt(stk.nextToken())));
                }catch(NoSuchElementException e) {
                    System.out.println("Element not found.");
                }
            }
        }catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        return bookList;
    }

    public void printBooksList(List<Book> bookList) {
        System.out.print(MenuDraw.bookListGenerate(bookList));
    }


    public void checkout(Book book) {
        book.setBorrowed(true);

        bookList.remove(book);
        borrowedList.add(book);
    }

    public List<Book> getBorrowedList() {
        return borrowedList;
    }

    private void successfulCheckoutMessage() {
        System.out.printf("%n%-10s%s%n", "", "Thank you! Enjoy the book");
    }

    private void unsuccessfulCheckoutMessage() {
        System.out.printf("%n%-10s%s%n", "", "That book is not available.");
    }

    public boolean manageBookSelection(int bookSelected, List<Book> bookList) {
        if (bookSelected > 0 && bookSelected <= bookList.size()){
            checkout(bookList.get(bookSelected-1));
            successfulCheckoutMessage();
            return true;
        }
        unsuccessfulCheckoutMessage();
        return false;
    }
}
