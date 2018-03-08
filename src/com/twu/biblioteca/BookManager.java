package com.twu.biblioteca;

import com.twu.biblioteca.pojos.Book;

public class BookManager {

    private BooksService booksService;

    public BookManager(BooksService booksService) {
        this.booksService = booksService;
    }

    public boolean checkoutManager(int bookNumber) {
        if (bookNumber > 0 && bookNumber <= booksService.getBookList().size()) {

            Book book = booksService.getBookList().get(bookNumber - 1);

            booksService.checkout(book);

            booksService.checkoutBookSuccessfulMessage();

            return true;
        }

        booksService.checkoutBookUnsuccessfulMessage();
        return false;
    }

    public boolean returnBookManager(int bookNumber) {
        if (bookNumber > 0 && bookNumber <= booksService.getBorrowedList().size()) {

            Book book = booksService.getBorrowedList().get(bookNumber - 1);

            booksService.getBorrowedList().remove(book);
            booksService.getBookList().add(book);

            booksService.returnBookSuccessfulMessage();

            return true;
        }

        booksService.returnBookUnsuccessfulMessage();
        return false;
    }
}
