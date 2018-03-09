package com.twu.biblioteca;

import com.twu.biblioteca.pojos.Movie;
import com.twu.biblioteca.services.MovieService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MovieManagerTest {

    private MovieService movieService;
    private MovieManager movieManager;
    private List<Movie> movieList;

    @Before
    public void setup() {
        movieService = new MovieService();
        movieManager = new MovieManager(movieService);

        movieList = new ArrayList<Movie>();
        movieList.add(new Movie("Avatar", 2010, "James Cameron", "8"));
        movieService.setMovieList(movieList);
    }

    @Test
    public void checkoutAMovieFromAvailableMovieListShouldReturnTrue() {

        int movieIndex = 1;

        boolean checkout = movieManager.checkoutMovieManager(movieIndex);

        assertTrue(checkout);
    }

    @Test
    public void checkoutMovieShouldBeFalseTest() {
        int outOfRangeMovieIndex = 20;

        boolean checkout = movieManager.checkoutMovieManager(outOfRangeMovieIndex);

        assertFalse(checkout);
    }

}
