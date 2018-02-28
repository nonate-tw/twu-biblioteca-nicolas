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

        Scanner scan = null;
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

        String lines = "";
        for (int i = 0; i < 120; i++) {
            lines += "=";
        }

        int option = -1;
        do{

            System.out.println(lines);
            System.out.printf("%-60s%s%n", "" ,"List of Books");
            System.out.println(lines);
            System.out.printf("%-53s%-50s%-50s%n","Name","Author","Year Published");
            System.out.println(lines);

            int i = 1;
            for (Book book: bookList){

                System.out.printf("%02d-%-50s%-50s%d%n",i ,book.getName(), book.getAuthor(), book.getYear());
                i++;
            }
            System.out.println(lines);

            System.out.print("Borrow a book (enter the number, 0 to return): ");

            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();

            if (option > 0 && option < bookList.size()){
                checkout(bookList.get(option-1));
                break;
            }


        }while(option != 0);



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

    public void successfulCheckoutMessage() {
        System.out.printf("%n%-10s%s%n", "", "Thank you! Enjoy the book");
    }
}
