package com.twu.biblioteca;

import com.twu.biblioteca.pojos.Book;
import java.util.List;

public class BookListDraw {

    public static String getLines(int n) {

        StringBuilder lines = new StringBuilder();
        for (int i = 0; i < n; i++) {
            lines.append("=");
        }

        return lines.toString();
    }

    public static String bookListGenerate(List<Book> bookList) {
        if (bookList.isEmpty()){
            return "Book List Is Empty!";
        }else{

            String lines = getLines(120);
            StringBuilder bookListStr = new StringBuilder();
            String linesFormat = String.format("%s%n",lines);

            bookListStr.append(linesFormat);
            bookListStr.append(String.format("%-53s%s%n", "", "List of Books"));
            bookListStr.append(linesFormat);
            bookListStr.append(String.format("%-53s%-50s%-50s%n", "Name", "Author", "Year Published"));
            bookListStr.append(linesFormat);

            int i = 1;
            for (Book book: bookList){

                bookListStr.append(String.format("%02d-%-50s%-50s%d%n", i, book.getName(), book.getAuthor(), book.getYear()));
                i++;
            }

            bookListStr.append(linesFormat);

            return bookListStr.toString();
        }
    }

}
