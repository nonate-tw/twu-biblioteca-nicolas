package com.twu.biblioteca.menu;

import com.twu.biblioteca.services.MovieService;

public class ListMovieHandler implements IMenuHandler{

    private MovieService moviesService;
    private IMenuHandler next;

    public void setMoviesService(MovieService moviesService) {
        this.moviesService = moviesService;
    }

    @Override
    public void setNext(IMenuHandler handler) {
        this.next = handler;
    }

    @Override
    public void handlerOption(int option) {

        if (option == MenuOptions.LIST_MOVIES) {
            moviesService.printMoviesList();
        }else{
            next.handlerOption(option);
        }
    }
}
