package com.twu.biblioteca.menu;

import com.twu.biblioteca.services.BooksService;
import com.twu.biblioteca.services.LoginService;
import com.twu.biblioteca.services.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class IMenuHandlerTest {

    private static final int BOOKS_LIST = 1;
    private static final int MOVIES_LIST = 2;
    private static final int CHECKOUT_BOOK = 3;
    private static final int CHECKOUT_MOVIE = 4;
    private static final int RETURN_BOOK = 5;
    private static final int LOGIN = 6;

    @Test
    public void option1ShouldPrintBooksList() {

        ListBookHandler listBookHandler = new ListBookHandler();

        BooksService mock = Mockito.mock(BooksService.class);
        listBookHandler.setBooksService(mock);

        listBookHandler.handlerOption(BOOKS_LIST);

        Mockito.verify(mock).printBooksList();
    }

    @Test
    public void option2ShouldPrintMoviesList() {

        ListMovieHandler listMovieHandler = new ListMovieHandler();

        MovieService mock = Mockito.mock(MovieService.class);
        listMovieHandler.setMoviesService(mock);

        listMovieHandler.handlerOption(MOVIES_LIST);

        Mockito.verify(mock).printMoviesList();
    }

    @Test
    public void option3ShouldCheckoutABook() {
        CheckOutHandler checkOutHandler = new CheckOutHandler();

        BooksService mock = Mockito.mock(BooksService.class);
        checkOutHandler.setBooksService(mock);

        checkOutHandler.handlerOption(CHECKOUT_BOOK);

        Mockito.verify(mock).checkoutBook();
    }

    @Test
    public void option4ShouldCheckoutAMovie() {
        CheckOutMovieHandler checkOutMovieHandler = new CheckOutMovieHandler();

        MovieService mock = Mockito.mock(MovieService.class);
        checkOutMovieHandler.setMoviesService(mock);

        checkOutMovieHandler.handlerOption(CHECKOUT_MOVIE);

        Mockito.verify(mock).checkoutMovie();
    }

    @Test
    public void option5ShouldReturnABook() {

        ReturnBookHandler returnBookHandler = new ReturnBookHandler();

        BooksService mock = Mockito.mock(BooksService.class);
        returnBookHandler.setBooksService(mock);

        returnBookHandler.handlerOption(RETURN_BOOK);

        Mockito.verify(mock).returnBook();
    }


    @Test
    public void option6ShouldLoginUser() {

        LoginUserHandler loginUserHandler = new LoginUserHandler();

        LoginService mock = Mockito.mock(LoginService.class);
        loginUserHandler.setLoginService(mock);

        loginUserHandler.handlerOption(LOGIN);

        Mockito.verify(mock).loginUser();
    }

}