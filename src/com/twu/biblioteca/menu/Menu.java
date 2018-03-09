package com.twu.biblioteca.menu;

import com.twu.biblioteca.services.BooksService;
import com.twu.biblioteca.services.LoginService;
import com.twu.biblioteca.services.MovieService;
import com.twu.biblioteca.users.UserAccount;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu implements IMenuHandler {

    private IMenuHandler next;
    private BooksService booksService;
    private MovieService moviesService;
    private LoginService loginService;

    private UserAccount userAccount;

    public Menu() {
        booksService = new BooksService();
        moviesService = new MovieService();
        loginService = new LoginService();

        userAccount = UserAccount.getInstance();
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


        if (userAccount.isUserSessionStarted()){

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
        }else{

            LoginUserHandler loginUserHandler = new LoginUserHandler();
            listMovieHandler.setNext(loginUserHandler);
            loginUserHandler.setLoginService(loginService);

            ExitMenuHandler exitMenuHandler = new ExitMenuHandler();
            loginUserHandler.setNext(exitMenuHandler);
        }

        next.handlerOption(option);
    }


    public void printMenu(){
        Scanner scanner = new Scanner(System.in);
        int option;
        while(true){
            System.out.println("\n\nMENU");
            System.out.println("1.- List Books");
            System.out.println("2.- List Movies");
            if (userAccount.isUserSessionStarted()){

                System.out.println("3.- Checkout Book");
                System.out.println("4.- Checkout Movie");
                System.out.println("5.- Return Book");
            }else{
                System.out.println("6.- Login");
            }
            System.out.println("7.- Quit");


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
