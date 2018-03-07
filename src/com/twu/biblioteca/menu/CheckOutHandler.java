package com.twu.biblioteca.menu;

import com.twu.biblioteca.BooksService;

import java.util.Scanner;

public class CheckOutHandler implements IMenuHandler{

    private BooksService booksService;
    private IMenuHandler next;

    @Override
    public void setNext(IMenuHandler handler) {
        next = handler;
    }

    @Override
    public IMenuHandler getNext() {
        return next;
    }

    @Override
    public void handlerOption(int option) {

        if (option == 2)
            booksService.checkoutBook();
        else
            next.handlerOption(option);
    }

    public void setBooksService(BooksService booksService) {
        this.booksService = booksService;
    }
}
