package com.twu.biblioteca;

import com.twu.biblioteca.pojos.Book;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuDraw {

    public static String getLines(int n) {

        StringBuilder lines = new StringBuilder();
        for (int i = 0; i < n; i++) {
            lines.append("=");
        }

        return lines.toString();
    }

    public static String principalMenu() {

        String lines = getLines(50);
        String menu = "";

        menu += String.format("%s%n",lines);
        menu += String.format("%-20s%s%n","","MENU");
        menu += String.format("%s%n",lines);
        menu += String.format("%-15s%s%n","","1.- List Books");
        menu += String.format("%-15s%s%n","","2.- Checkout Book");
        menu += String.format("%-15s%s%n","","3.- Quit");
        menu += String.format("%s%n",lines);

        menu += String.format("%s", "choose an option > ");

        return menu;
    }

    public static String bookListGenerate(List<Book> bookList) {
        String lines = getLines(120);
        String bookListStr = "";
        bookListStr += String.format("%s%n",lines);
        bookListStr += String.format("%-60s%s%n", "" ,"List of Books");
        bookListStr += String.format("%s%n",lines);
        bookListStr += String.format("%-53s%-50s%-50s%n","Name","Author","Year Published");
        bookListStr += String.format("%s%n",lines);

        int i = 1;
        for (Book book: bookList){

            bookListStr += String.format("%02d-%-50s%-50s%d%n",i ,book.getName(), book.getAuthor(), book.getYear());
            i++;
        }
        bookListStr += String.format("%s%n",lines);

        return bookListStr;
    }

    public static int checkoutBookSelection() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the book > ");
        int bookNumber;

        try{
            bookNumber = scanner.nextInt();
        }catch (InputMismatchException ex){
            bookNumber = -1;
        }
        return bookNumber;
    }
}
