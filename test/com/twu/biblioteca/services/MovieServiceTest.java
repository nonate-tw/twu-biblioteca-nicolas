package com.twu.biblioteca.services;

import com.twu.biblioteca.pojos.Movie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MovieServiceTest {

    private List<Movie> movieList;

    @Before
    public void setup() {
        movieList = new ArrayList<Movie>();

        movieList.add(new Movie("Lord of the Rings", 2001, "", "10"));
        movieList.add(new Movie("Avatar", 2010, "James Cameron", "8"));
        movieList.add(new Movie("Avengers", 2015, "", "unrated"));
    }


    @Test
    public void movieListSizeShouldBe3() {
        assertEquals(3, movieList.size());
    }

}
