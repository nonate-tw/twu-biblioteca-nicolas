package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuDrawTest {

    @Test
    public void linesMenuTest() {

        String lines = MenuDraw.getLines(120);

        assertEquals(120, lines.length());
    }
}
