package com.twu.biblioteca.services;

import com.twu.biblioteca.pojos.Book;
import com.twu.biblioteca.services.BooksService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {

    private BooksService booksService;
    private List<Book> booksList;

    @Before
    public void setup() {
        booksService = new BooksService();
        booksList = new ArrayList<Book>();


        booksList.add(new Book("Agile Analytics", "Ken Collier", 2012));
        booksList.add(new Book("Building Microservices", "Sam Newman", 2015));
        booksList.add(new Book("ReWork", "Jason Fried,David Heinemeier Hansson", 2010));

        booksService.setBooksList(booksList);
    }

    @Test
    public void listOfBooks() {

        assertEquals(3, booksList.size());
    }

    @Test
    public void authorOfFirstBookIsKenColler() {

        String author = booksList.get(0).getAuthor();

        assertEquals("Ken Collier", author);
    }

    @Test
    public void yearPublishedOfFirstBookIs2012() {

        int year = booksList.get(0).getYear();

        assertEquals(2012, year);
    }

}
