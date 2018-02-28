package com.twu.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotecaApp {

    public static BooksService booksService;

    static {
        booksService = new BooksService();
    }

    public static void main(String[] args) {

        System.out.println(welcomeMessage());
        int option = 0;


        do{

            System.out.printf("%n%n%s",menu());
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


    public static String menu() {

        String lines = getLines(50);
        String menu = "";

        menu += String.format("%s%n",lines);
        menu += String.format("%-20s%s%n","","MENU");
        menu += String.format("%s%n",lines);
        menu += String.format("%-15s%s%n","","1.- List Books");
        menu += String.format("%-15s%s%n","","2.- Quit");
        menu += String.format("%s%n",lines);

        menu += String.format("%s", "choose an option > ");

        return menu;
    }


    public static String getLines(int n) {
        StringBuilder lines = new StringBuilder();

        for (int i = 0; i < n; i++) {
            lines.append("=");
        }

        return lines.toString();
    }
}
