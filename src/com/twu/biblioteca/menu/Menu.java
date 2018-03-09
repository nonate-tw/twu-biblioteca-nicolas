package com.twu.biblioteca.menu;

import com.twu.biblioteca.services.BooksService;
import com.twu.biblioteca.services.MovieService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu implements IMenuHandler {

    private IMenuHandler next;
    private BooksService booksService;
    private MovieService moviesService;

    public Menu() {
        booksService = new BooksService();
        moviesService = new MovieService();
    }

    @Override
    public void setNext(IMenuHandler   handler) {
        next = handler;
    }

    @Override
    public void handlerOption(int option) {

        ListBookHandler listBookHandler = new ListBookHandler();
        this.setNext(listBookHandler);
        listBookHandler.setBooksService(booksService);

        ListMovieHandler listMovieHandler = new ListMovieHandler();
        listBookHandler.setNext(listMovieHandler);
        listMovieHandler.setMoviesService(moviesService);

        CheckOutHandler checkOutHandler = new CheckOutHandler();
        listMovieHandler.setNext(checkOutHandler);
        checkOutHandler.setBooksService(booksService);

        CheckOutMovieHandler checkOutMovieHandler = new CheckOutMovieHandler();
        checkOutHandler.setNext(checkOutMovieHandler);
        checkOutMovieHandler.setMoviesService(moviesService);


        ReturnBookHandler returnBookHandler = new ReturnBookHandler();
        checkOutMovieHandler.setNext(returnBookHandler);
        returnBookHandler.setBooksService(booksService);

        ExitMenuHandler exitMenuHandler = new ExitMenuHandler();
        returnBookHandler.setNext(exitMenuHandler);

        next.handlerOption(option);
    }


    public void printMenu(){
        Scanner scanner = new Scanner(System.in);
        int option;
        while(true){
            System.out.println("\n\nMENU");
            System.out.println("1.- List Books");
            System.out.println("2.- List Movies");
            System.out.println("3.- Checkout Book");
            System.out.println("4.- Checkout Movie");
            System.out.println("5.- Return Book");
            System.out.println("6.- Quit");


            System.out.print("Choose an option: ");
            try{
                option = scanner.nextInt();
            }catch (InputMismatchException ex){
                scanner.nextLine();
                option = 0;
            }

            handlerOption(option);
        }
    }
}
