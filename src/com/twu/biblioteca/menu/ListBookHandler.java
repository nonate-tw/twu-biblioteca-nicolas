package com.twu.biblioteca.menu;

import com.twu.biblioteca.BooksService;
import com.twu.biblioteca.pojos.Book;

import java.util.ArrayList;

public class ListBookHandler implements IMenuHandler {

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

        if (option == 1)
            booksService.printBooksList();
        else
            next.handlerOption(option);
    }


    public void setBooksService(BooksService booksService) {
        this.booksService = booksService;
    }
}
