package com.twu.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotecaApp {

    private static BooksService booksService;

    static {
        booksService = new BooksService();
    }

    public static void main(String[] args) {

        System.out.println(welcomeMessage());
        int option = 0;


        do{

            System.out.printf("%n%n%s", MenuDraw.principalMenu());
            Scanner scanner = new Scanner(System.in);
            try{
                option = scanner.nextInt();
            }catch (InputMismatchException e){
                option = 0;
                System.out.println("Select a valid option!");
            }


            switch (option) {
                case 1:
                    booksService.printBooksList();
                    break;
                case 2:
                    System.out.println("Good Bye!");
                    break;
                default:
                    System.out.println("Select a valid option!");
                    break;
            }

        }while(option != 2);
    }

    public static String welcomeMessage() {
        return "Welcome to Biblioteca!";
    }



}
