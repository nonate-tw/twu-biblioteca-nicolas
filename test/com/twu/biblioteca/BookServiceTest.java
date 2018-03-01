package com.twu.biblioteca;

import com.twu.biblioteca.pojos.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BookServiceTest {

   private BooksService booksService;

   @Before
   public void setup() {
       booksService = new BooksService();
   }

   @Test
   public void listOfBooks() {

       List<Book> booksList = booksService.getBookList();

       assertEquals(11, booksList.size());
   }

   @Test
   public void authorOfFirstBookIsKenColler() {

       List<Book> bookList = booksService.getBookList();

       String author = bookList.get(0).getAuthor();

       assertEquals("Ken Collier", author);

   }

   @Test
   public void yearPublishedOfFirstBookIs2012(){

       List<Book> bookList = booksService.getBookList();

       int year = bookList.get(0).getYear();

       assertEquals(2012, year);
   }

   @Test
   public void checkoutTest() {

       List<Book> bookList = booksService.getBookList();
       booksService.checkout(bookList.get(0));
       List<Book> borrowedList = booksService.getBorrowedList();

       assertEquals(1, borrowedList.size());

   }

   @Test
   public void checkedOutBookNotAppearInTheListOfAllLibraryBooks() {

       List<Book> bookList = booksService.getBookList();
       Book checkedOutBook = bookList.get(0);
       booksService.checkout(checkedOutBook);

       assertNotEquals(checkedOutBook, bookList.get(0));
   }

   @Test
    public void selectedBookInListReturnSuccessfulCheckout() {

       List<Book> bookList = booksService.getBookList();
       boolean selection = booksService.manageBookSelection(1, bookList, false);

       assertEquals(true, selection);
   }

   @Test
    public void selectedOptionInBooksListIsGreaterThanListSize() {

       List<Book> bookList = booksService.getBookList();
       boolean selection = booksService.manageBookSelection(12, bookList, false);

       assertEquals(false, selection);
   }

   @Test
    public void selectedOptionInBookListIsLowerThanZero() {

       List<Book> bookList = booksService.getBookList();
       boolean selection = booksService.manageBookSelection(-1, bookList, false);

       assertEquals(false, selection);
   }

   @Test
    public void borrowedListSizeIs1(){

       List<Book> bookList = booksService.getBookList();
       booksService.checkout(bookList.get(0));

       List<Book> borrowedList = booksService.getBorrowedList();

       assertEquals(1, borrowedList.size());
   }

   @Test
    public void returnBorrowedBookTest() {

       List<Book> bookList = booksService.getBookList();
       booksService.checkout(bookList.get(0));
       List<Book> borrowedList = booksService.getBorrowedList();

       booksService.returnBook(borrowedList.get(0));

       assertEquals(0, borrowedList.size());
   }

   @Test
    public void returnABookFromBorrowedListAnnShowInBookListTest() {

       List<Book> bookList = booksService.getBookList();
       int bookListSize1 = bookList.size();
       booksService.checkout(bookList.get(0));
       List<Book> borrowedList = booksService.getBorrowedList();

       booksService.returnBook(borrowedList.get(0));
       int bookListSize2 = bookList.size();

       assertEquals(bookListSize1, bookListSize2);
   }
}
