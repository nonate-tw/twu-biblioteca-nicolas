package com.twu.biblioteca;


import com.twu.biblioteca.pojos.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    private BooksService booksService;

    @Before
    public void setup() {
        booksService = new BooksService();
    }

    @Test
    public void welcomeMessageTest() {

        String message = BibliotecaApp.welcomeMessage();

        assertEquals("Welcome to Biblioteca!", message);
    }

    @Test
    public void listOfBooks() {

        List<Book> booksList = booksService.getBookList();

        assertEquals(11, booksList.size());
    }


    @Test
    public void linesMenuTest() {

        String lines = BibliotecaApp.getLines(120);

        assertEquals(120, lines.length());
    }


    @Test
    public void authorOfFirstBookIsKenColler(){

        List<Book> bookList = booksService.getBookList();

        String author = bookList.get(0).getAuthor();

        assertEquals("Ken Collier", author);

    }

    @Test
    public void yearPublishedOfFirstBookIs2012(){

        List<Book> bookList = booksService.getBookList();

        int year = bookList.get(0).getYear();

        assertEquals(2012, year);
    }

}
