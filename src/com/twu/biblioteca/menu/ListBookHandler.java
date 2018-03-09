package com.twu.biblioteca.menu;

import com.twu.biblioteca.services.BooksService;

public class ListBookHandler implements IMenuHandler {

    private BooksService booksService;
    private IMenuHandler next;

    @Override
    public void setNext(IMenuHandler handler) {
        next = handler;
    }

    @Override
    public void handlerOption(int option) {

        if (option == MenuOptions.LIST_BOOKS)
            booksService.printBooksList();
        else
            next.handlerOption(option);
    }


    public void setBooksService(BooksService booksService) {
        this.booksService = booksService;
    }
}
