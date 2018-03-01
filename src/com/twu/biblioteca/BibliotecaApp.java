package com.twu.biblioteca;

import com.twu.biblioteca.pojos.Book;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private static BooksService booksService;

    static {
        booksService = new BooksService();
    }

    public static void main(String[] args) {

        System.out.println(welcomeMessage());
        int option;
        List<Book> bookList =  booksService.getBookList();
        do{

            System.out.printf("%n%n%s", MenuDraw.principalMenu());
            Scanner scanner = new Scanner(System.in);
            try{
                option = scanner.nextInt();
            }catch (InputMismatchException e) {
                option = 0;
                System.out.println("Select a valid option!");
            }


            switch (option) {
                case 1:
                    booksService.printBooksList(bookList);
                    break;
                case 2:
                    int bookSelected = MenuDraw.checkoutBookSelection();
                    booksService.manageBookSelection(bookSelected, bookList);
                    break;
                case 3:
                    System.out.println("Good Bye!");
                    break;
                default:
                    System.out.println("Select a valid option!");
                    break;
            }

        }while(option != 3);
    }

    public static String welcomeMessage() {
        return "Welcome to Biblioteca!";
    }
}
