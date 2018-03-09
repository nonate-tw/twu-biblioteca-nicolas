package com.twu.biblioteca;

import com.twu.biblioteca.pojos.Movie;
import com.twu.biblioteca.services.MovieService;

public class MovieManager {

    private MovieService movieService;

    public MovieManager(MovieService movieService) {

        this.movieService = movieService;
    }

    public boolean checkoutMovieManager(int movieIndex) {

        if (movieIndex > movieService.getMovieList().size() || movieIndex <= 0 ){
            movieService.checkoutMovieUnsuccessfulMessage();
            return false;
        }else{
            Movie movie = movieService.getMovieList().get(movieIndex - 1);
            movieService.getMovieList().remove(movie);

            movieService.successfulMessage();
            return true;
        }
    }
}
