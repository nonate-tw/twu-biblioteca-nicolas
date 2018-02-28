package com.twu.biblioteca;

import com.twu.biblioteca.pojos.Book;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BooksService {

    private List<Book> bookList;

    public BooksService() {
    }

    public List<Book> getBookList() {

        Scanner scan = null;
        bookList = new ArrayList<Book>();
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

        getBookList();
        String lines = "";
        for (int i = 0; i < 120; i++) {
            lines += "=";
        }

        System.out.println(lines);
        System.out.printf("%-60s%s%n", "" ,"List of Books");
        System.out.println(lines);
        System.out.printf("%-50s%-50s%-50s%n","Name","Author","Year Published");
        System.out.println(lines);
        for (Book book: bookList){

            System.out.printf("%-50s%-50s%d%n", book.getName(), book.getAuthor(), book.getYear());
        }
        System.out.println(lines);
    }


}
