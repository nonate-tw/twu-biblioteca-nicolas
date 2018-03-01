package com.twu.biblioteca;

import com.twu.biblioteca.pojos.Book;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BooksService {

    private List<Book> bookList;
    private List<Book> borrowedList;

    public BooksService() {
        bookList = new ArrayList<Book>();
        borrowedList = new ArrayList<Book>();
    }

    public List<Book> getBookList() {

        Scanner scan;
        try {

            scan = new Scanner(new File("books.txt"));

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                StringTokenizer stk = new StringTokenizer(line, "_");
                try{
                    bookList.add(new Book(stk.nextToken(), stk.nextToken(), Integer.parseInt(stk.nextToken())));
                }catch(NoSuchElementException e) {
                    System.out.println("Element not found.");
                }
            }
        }catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        return bookList;
    }

    public void printBooksList() {

        if (bookList.isEmpty())
            getBookList();

        boolean result;
        do{

            System.out.print(bookListGenerate());
            result = menuOptions();

        }while(!result);
    }

    private String bookListGenerate() {
        String lines = MenuDraw.getLines(120);
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

        bookListStr += String.format("%s", "Borrow a book (enter the number, 0 to return): ");

        return bookListStr;
    }


    private boolean menuOptions() {
        int option;
        Scanner scanner = new Scanner(System.in);
        option = scanner.nextInt();

        if (option > 0 && option <= bookList.size()){
            checkout(bookList.get(option-1));
            return true;
        }else{
            if (option != 0){
                unsuccessfulCheckoutMessage();
            }else{
                return true;
            }
        }
        return false;
    }


    public void checkout(Book book) {
        book.setBorrowed(true);

        bookList.remove(book);
        borrowedList.add(book);

        successfulCheckoutMessage();

    }

    public List<Book> getBorrowedList() {
        return borrowedList;
    }

    private void successfulCheckoutMessage() {
        System.out.printf("%n%-10s%s%n", "", "Thank you! Enjoy the book");
    }

    private void unsuccessfulCheckoutMessage() {
        System.out.printf("%n%-10s%s%n", "", "That book is not available.");
    }

}
