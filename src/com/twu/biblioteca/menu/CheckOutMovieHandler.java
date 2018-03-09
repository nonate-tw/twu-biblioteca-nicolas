package com.twu.biblioteca.menu;

import com.twu.biblioteca.services.MovieService;

public class CheckOutMovieHandler implements IMenuHandler{

    private IMenuHandler next;
    private MovieService moviesService;

    public void setMoviesService(MovieService moviesService) {
        this.moviesService = moviesService;
    }

    @Override
    public void setNext(IMenuHandler handler) {
        next = handler;
    }

    @Override
    public void handlerOption(int option) {

        if (option == MenuOptions.CHECKOUT_MOVIE) {
            this.moviesService.checkoutMovie();
        }else{
            this.next.handlerOption(option);
        }
    }
}
