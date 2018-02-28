package com.twu.biblioteca;


import com.twu.biblioteca.pojos.Book;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    @Test
    public void welcomeMessageTest() {

        String message = BibliotecaApp.welcomeMessage();

        assertEquals("Welcome to Biblioteca!", message);
    }

    @Test
    public void listOfBooks() {

        List<Book> booksList = BibliotecaApp.booksList();

        assertEquals(11, booksList.size());
    }

}
