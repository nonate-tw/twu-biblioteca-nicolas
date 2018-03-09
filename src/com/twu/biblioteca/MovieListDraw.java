package com.twu.biblioteca;

import com.twu.biblioteca.pojos.Movie;

import java.util.List;

public class MovieListDraw {


    public String movieListGenerate(List<Movie> movieList) {

        String lines = BookListDraw.getLines(100);
        StringBuilder movieListStr = new StringBuilder();
        String linesFormat = String.format("%s%n",lines);

        movieListStr.append(linesFormat);
        movieListStr.append(String.format("%-53s%s%n", "", "List of Movies"));
        movieListStr.append(linesFormat);
        movieListStr.append(String.format("%-27s%-20s%-20s%s%n", "Name", "Year", "Director", "Rating"));
        movieListStr.append(linesFormat);

        int i = 1;
        for(Movie movie : movieList){
            movieListStr.append(String.format("%02d-%-25s%-20d%-20s%s%n", i, movie.getName(), movie.getYear(), movie.getDirector(), movie.getRating()));
            i++;
        }

        movieListStr.append(linesFormat);


        return movieListStr.toString();
    }
}
