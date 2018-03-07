package com.twu.biblioteca;

import com.twu.biblioteca.menu.Menu;
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

        Menu menu = new Menu();

        menu.menuPrint();

        /*int option;
        List<Book> bookList =  booksService.generateBookList();
        do{

            System.out.printf("%n%n%s", MenuDraw.principalMenu());
            Scanner scanner = new Scanner(System.in);
            try{
                option = scanner.nextInt();
            }catch (InputMismatchException e) {
                option = 0;
            }

            int bookSelected;
            switch (option) {
                case 1:
                    booksService.printBooksList();
                    break;
                case 2:
                    bookSelected = MenuDraw.checkoutBookSelection();
                    //booksService.manageBookSelection(bookSelected, bookList, false);
                    break;
                case 3:
                    List<Book> borrowedList = booksService.getBorrowedList();
                    booksService.printBorrowedList();
                    if (!borrowedList.isEmpty()){
                        bookSelected = MenuDraw.checkoutBookSelection();
                        //booksService.manageBookSelection(bookSelected, borrowedList, true);
                    }
                    break;
                case 4:
                    System.out.println("Good Bye!");
                    break;
                default:
                    System.out.println("Select a valid option!");
                    break;
            }

        }while(option != 4);*/
    }

    public static String welcomeMessage() {
        return "Welcome to Biblioteca!";
    }
}
