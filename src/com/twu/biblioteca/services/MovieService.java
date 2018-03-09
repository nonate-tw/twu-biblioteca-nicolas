package com.twu.biblioteca.services;

import com.twu.biblioteca.MovieListDraw;
import com.twu.biblioteca.MovieManager;
import com.twu.biblioteca.pojos.Movie;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MovieService {

    private List<Movie> movieList;
    private MovieListDraw movieListDraw;
    private MovieManager movieManager;
    private static final String PADDING = "%n%-10s%s%n";



    public MovieService() {
        movieList = new ArrayList<Movie>();
        movieList.add(new Movie("Lord of the Rings", 2001, "", "10"));
        movieList.add(new Movie("Avatar", 2010, "James Cameron", "8"));
        movieList.add(new Movie("Avengers", 2015, "", "unrated"));

        movieListDraw = new MovieListDraw();
        movieManager = new MovieManager(this);
    }

    public void printMoviesList() {
        System.out.println(movieListDraw.movieListGenerate(movieList));
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public void successfulMessage() {
        System.out.printf(PADDING, "", "Thank you! Enjoy the movie");
    }

    public void checkoutMovieUnsuccessfulMessage() {
        System.out.printf(PADDING, "", "That movie is not available.");
    }

    public void checkoutMovie() {

        if(getMovieList().isEmpty()) {
            System.out.println("Movie List Is Empty!");
        }else{
            Scanner scanner = new Scanner(System.in);
            int movieNumber;

            try {
                System.out.print("Enter the number of the movie > ");
                movieNumber = scanner.nextInt();
            }catch (InputMismatchException ex) {
                scanner.nextLine();
                movieNumber = 0;
            }

            movieManager.checkoutMovieManager(movieNumber);
        }
    }
}
