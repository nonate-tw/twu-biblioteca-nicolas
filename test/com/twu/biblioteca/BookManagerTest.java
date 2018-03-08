package com.twu.biblioteca;

import com.twu.biblioteca.pojos.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

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

        assertEquals(true, selection);
    }

    @Test
    public void selectedOptionInBooksListIsGreaterThanListSize() {

        boolean selection = bookManager.checkoutManager(12);

        assertEquals(false, selection);
    }

    @Test
    public void selectedOptionInBookListIsLowerThanZero() {

        boolean selection = bookManager.checkoutManager(-1);

        assertEquals(false, selection);
    }

    @Test
    public void returnBorrowedBookTest() {

        List<Book> borrowedList = new ArrayList<Book>();
        borrowedList.add(new Book("Lean UX", "", 2005));
        booksService.setBorrowedList(borrowedList);

        assertEquals(true, bookManager.returnBookManager(1));
    }

    @Test
    public void returnABookFromBorrowedListAnnShowInBookListTest() {

        int bookListSize1 = booksList.size();
        booksService.checkout(booksList.get(0));

        bookManager.returnBookManager(1);
        int bookListSize2 = booksList.size();

        assertEquals(bookListSize1, bookListSize2);
    }
}
