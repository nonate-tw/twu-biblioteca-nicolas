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

            int bookSelected = 0;
            switch (option) {
                case 1:
                    booksService.printBooksList(bookList);
                    break;
                case 2:
                    bookSelected = MenuDraw.checkoutBookSelection();
                    booksService.manageBookSelection(bookSelected, bookList, false);
                    break;
                case 3:
                    List<Book> borrowedList = booksService.getBorrowedList();
                    booksService.printBorrowedList(borrowedList);
                    bookSelected = MenuDraw.checkoutBookSelection();
                    booksService.manageBookSelection(bookSelected, borrowedList, true);
                    break;
                case 4:
                    System.out.println("Good Bye!");
                    break;
                default:
                    System.out.println("Select a valid option!");
                    break;
            }

        }while(option != 4);
    }

    public static String welcomeMessage() {
        return "Welcome to Biblioteca!";
    }
}
