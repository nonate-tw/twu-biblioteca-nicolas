package com.twu.biblioteca.menu;

import com.twu.biblioteca.BooksService;
import java.util.Scanner;

public class Menu implements IMenuHandler {

    private IMenuHandler next;
    private BooksService booksService;

    public Menu() {
        booksService = new BooksService();
    }

    @Override
    public void setNext(IMenuHandler   handler) {
        next = handler;
    }

    @Override
    public IMenuHandler getNext() {
        return next;
    }

    @Override
    public void handlerOption(int option) {

        ListBookHandler listBookHandler = new ListBookHandler();
        this.setNext(listBookHandler);
        listBookHandler.setBooksService(booksService);

        CheckOutHandler checkOutHandler = new CheckOutHandler();
        listBookHandler.setNext(checkOutHandler);
        checkOutHandler.setBooksService(booksService);


        ReturnBookHandler returnBookHandler = new ReturnBookHandler();
        checkOutHandler.setNext(returnBookHandler);
        returnBookHandler.setBooksService(booksService);

        ExitMenuHandler exitMenuHandler = new ExitMenuHandler();
        returnBookHandler.setNext(exitMenuHandler);

        next.handlerOption(option);
    }


    public void menuPrint(){
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        while(true){
            System.out.println("\n\nMENU");
            System.out.println("1.- List Books");
            System.out.println("2.- Checkout Book");
            System.out.println("3.- Return Book");
            System.out.println("4.- Quit");


            System.out.print("Option: ");
            option = scanner.nextInt();

            handlerOption(option);
        }
    }
}
