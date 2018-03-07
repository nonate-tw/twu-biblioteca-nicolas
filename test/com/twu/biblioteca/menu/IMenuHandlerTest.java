package com.twu.biblioteca.menu;

import com.twu.biblioteca.BooksService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class IMenuHandlerTest {

    @Test
    public void option1ShouldPrintBooksList() {

        ListBookHandler listBookHandler = new ListBookHandler();

        BooksService mock = Mockito.mock(BooksService.class);
        listBookHandler.setBooksService(mock);

        listBookHandler.handlerOption(1);


        Mockito.verify(mock).printBooksList();

    }

    @Test
    public void option2ShouldCheckoutABook() {
        CheckOutHandler checkOutHandler = new CheckOutHandler();

        BooksService mock = Mockito.mock(BooksService.class);
        checkOutHandler.setBooksService(mock);

        checkOutHandler.handlerOption(2);

        Mockito.verify(mock).checkoutBook();

    }

    @Test
    public void option3ShouldReturnABook() {

        ReturnBookHandler returnBookHandler = new ReturnBookHandler();

        BooksService mock = Mockito.mock(BooksService.class);
        returnBookHandler.setBooksService(mock);

        returnBookHandler.handlerOption(3);

        Mockito.verify(mock).returnBook();

    }

 }