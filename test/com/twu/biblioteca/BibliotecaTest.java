package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {


    @Test
    public void welcomeMessageTest() {

        String message = BibliotecaApp.welcomeMessage();

        assertEquals("Welcome to Biblioteca!", message);
    }


}
