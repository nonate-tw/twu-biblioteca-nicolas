package com.twu.biblioteca;

import com.twu.biblioteca.pojos.Book;
import com.twu.biblioteca.services.BooksService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookManagerTest {


    private BooksService booksService;
    private List<Book> booksList;
    private BookManager bookManager;

    @Before
    public void setup() {
        booksService = new BooksService();
        booksList = new ArrayList<Book>();

        bookManager = new BookManager(booksService);


        booksList.add(new Book("Agile Analytics", "Ken Collier", 2012));
        booksList.add(new Book("Building Microservices", "Sam Newman", 2015));
        booksList.add(new Book("ReWork", "Jason Fried,David Heinemeier Hansson", 2010));

        booksService.setBooksList(booksList);
    }


    @Test
    public void selectedBookInListReturnSuccessfulCheckout() {

        boolean selection = bookManager.checkoutManager(1);

        assertTrue(selection);
    }

    @Test
    public void selectedOptionInBooksListIsGreaterThanListSize() {

        boolean selection = bookManager.checkoutManager(12);

        assertFalse(selection);
    }

    @Test
    public void selectedOptionInBookListIsLowerThanZero() {

        boolean selection = bookManager.checkoutManager(-1);

        assertFalse(selection);
    }

    @Test
    public void returnBorrowedBookTest() {

        List<Book> borrowedList = new ArrayList<Book>();
        borrowedList.add(new Book("Lean UX", "", 2005));
        booksService.setBorrowedList(borrowedList);

        assertTrue(bookManager.returnBookManager(1));
    }

    @Test
    public void checkoutTest() {

        bookManager.checkoutManager(1);
        List<Book> borrowedList = booksService.getBorrowedList();

        assertEquals(1, borrowedList.size());
    }

    @Test
    public void checkedOutBookShouldNotBeInAvailableBooksList() {

        int checkedoutBookIndex = 1;
        Book checkedOutBook = booksList.get(checkedoutBookIndex - 1);
        bookManager.checkoutManager(checkedoutBookIndex);

        assertFalse(booksList.contains(checkedOutBook));
    }

    @Test
    public void returnABookFromBorrowedListAndShowInBookListTest() {

        int checkedoutBookIndex = 1;
        int bookListSize1 = booksList.size();
        bookManager.checkoutManager(checkedoutBookIndex);

        bookManager.returnBookManager(checkedoutBookIndex);
        int bookListSize2 = booksList.size();

        assertEquals(bookListSize1, bookListSize2);
    }
}
