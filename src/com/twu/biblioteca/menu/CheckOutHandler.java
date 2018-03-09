package com.twu.biblioteca.menu;

import com.twu.biblioteca.services.BooksService;

public class CheckOutHandler implements IMenuHandler{

    private BooksService booksService;
    private IMenuHandler next;

    @Override
    public void setNext(IMenuHandler handler) {
        next = handler;
    }

    @Override
    public void handlerOption(int option) {

        if (option == MenuOptions.CHECKOUT_BOOK)
            booksService.checkoutBook();
        else
            next.handlerOption(option);
    }

    public void setBooksService(BooksService booksService) {
        this.booksService = booksService;
    }
}
