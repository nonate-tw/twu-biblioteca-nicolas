package com.twu.biblioteca.menu;

import com.twu.biblioteca.services.BooksService;

public class ReturnBookHandler implements IMenuHandler {

    private BooksService booksService;
    private IMenuHandler next;

    @Override
    public void setNext(IMenuHandler handler) {
        next = handler;
    }

    @Override
    public void handlerOption(int option) {

        if (option == MenuOptions.RETURN_BOOK)
            booksService.returnBook();
        else
            next.handlerOption(option);

    }

    public void setBooksService(BooksService booksService) {
        this.booksService = booksService;
    }
}
