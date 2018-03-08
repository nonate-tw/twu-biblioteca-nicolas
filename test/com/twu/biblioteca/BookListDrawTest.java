package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookListDrawTest {

    @Test
    public void drawLinesTest() {

        String lines = BookListDraw.getLines(120);

        assertEquals(120, lines.length());
    }
}
