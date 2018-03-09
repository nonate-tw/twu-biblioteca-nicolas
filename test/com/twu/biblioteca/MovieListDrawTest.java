package com.twu.biblioteca;

import com.twu.biblioteca.pojos.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MovieListDrawTest {

    private List<Movie> movieList;

    @Before
    public void setup(){

        movieList = new ArrayList<Movie>();
        movieList.add(new Movie("Avatar", 2010, "James Cameron", "8"));
    }

    @Test
    public void shouldPrintOneMovieInList() {

        MovieListDraw movieListDraw = new MovieListDraw();

        String list = movieListDraw.movieListGenerate(movieList);

        assertTrue(list.contains("Avatar"));
    }
}
