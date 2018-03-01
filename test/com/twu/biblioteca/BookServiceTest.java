package com.twu.biblioteca;

import com.twu.biblioteca.pojos.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BookServiceTest {

   private BooksService booksService;
   private List<Book> booksList;

   @Before
   public void setup() {
       booksService = new BooksService();
       booksList = booksService.generateBookList();
   }

   @Test
   public void listOfBooks() {

       assertEquals(11, booksList.size());
   }

   @Test
   public void authorOfFirstBookIsKenColler() {

       String author = booksList.get(0).getAuthor();

       assertEquals("Ken Collier", author);

   }

   @Test
   public void yearPublishedOfFirstBookIs2012(){

       int year = booksList.get(0).getYear();

       assertEquals(2012, year);
   }

   @Test
   public void checkoutTest() {

       booksService.checkout(booksList.get(0));
       List<Book> borrowedList = booksService.getBorrowedList();

       assertEquals(1, borrowedList.size());

   }

   @Test
   public void checkedOutBookNotAppearInTheListOfAllLibraryBooks() {

       Book checkedOutBook = booksList.get(0);
       booksService.checkout(checkedOutBook);

       assertNotEquals(checkedOutBook, booksList.get(0));
   }

   @Test
    public void selectedBookInListReturnSuccessfulCheckout() {

       boolean selection = booksService.manageBookSelection(1, booksList, false);

       assertEquals(true, selection);
   }

   @Test
    public void selectedOptionInBooksListIsGreaterThanListSize() {

       boolean selection = booksService.manageBookSelection(12, booksList, false);

       assertEquals(false, selection);
   }

   @Test
    public void selectedOptionInBookListIsLowerThanZero() {

       boolean selection = booksService.manageBookSelection(-1, booksList, false);

       assertEquals(false, selection);
   }

   @Test
    public void borrowedListSizeIs1(){

       booksService.checkout(booksList.get(0));

       List<Book> borrowedList = booksService.getBorrowedList();

       assertEquals(1, borrowedList.size());
   }

   @Test
    public void returnBorrowedBookTest() {

       booksService.checkout(booksList.get(0));
       List<Book> borrowedList = booksService.getBorrowedList();

       booksService.returnBook(borrowedList.get(0));

       assertEquals(0, borrowedList.size());
   }

   @Test
    public void returnABookFromBorrowedListAnnShowInBookListTest() {

       int bookListSize1 = booksList.size();
       booksService.checkout(booksList.get(0));
       List<Book> borrowedList = booksService.getBorrowedList();

       booksService.returnBook(borrowedList.get(0));
       int bookListSize2 = booksList.size();

       assertEquals(bookListSize1, bookListSize2);
   }
}
