package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LibraryTest {

    private Library library;
    private Book book1;
    private Book book2;
    private Movie movie1;
    private ArrayList<Book> availableBooks;
    private PrintStream printStream;
    private ArrayList <Book> checkedOutBooks;
    private ArrayList<Movie> availableMovies;

    @Before
    public void setUp(){
        book1 = mock(Book.class);
        book2 = mock(Book.class);
        movie1 = mock(Movie.class);
        availableBooks = new ArrayList<>();
        checkedOutBooks= new ArrayList<>();
        availableMovies = new ArrayList<>();
        availableBooks.add(book1);
        checkedOutBooks.add(book2);
        availableMovies.add(movie1);

        printStream = mock(PrintStream.class);
        library = new Library(availableBooks, checkedOutBooks, printStream, availableMovies);

    }
    @Test
    public void shouldCallToStringFromBookClass(){
        library.showBooks();

        verify(book1).bookOutput();
    }

    @Test
    public void shouldCallToStringFromMoviesClass(){
        library.showMovies();
        verify(movie1).movieOutput();
    }

    @Test
    public void shouldReturnTrueWhenTheLibraryContainsTheBook() {
        assertThat(availableBooks.contains(book1), is(true));
    }

    @Test
    public void shouldRemoveBookFromAvailableBooksWhenCheckedOut(){
        when(book1.hasTitle("book title")).thenReturn(true);

        library.checkOut("book title");

        assertThat(availableBooks.contains(book1), is(false));
    }

    @Test
    public void shouldAddBookToCheckedOutBooksWhenCheckedOut(){
        when(book1.hasTitle("book title")).thenReturn(true);

        library.checkOut("book title");

        assertThat(checkedOutBooks.contains(book1), is(true));
    }

    @Test
    public void shouldGiveSuccessfulCheckoutMessageIfBookIsCheckedOut(){
        when(book1.hasTitle("book title")).thenReturn(true);

        library.checkOut("book title");

        verify(printStream).println("Thank You! Enjoy the book.");
    }

    @Test
    public void shouldGiveErrorCheckoutMessageIfBookIsNotAvailable(){
        when(book1.hasTitle("book title")).thenReturn(false);

        library.checkOut("book title");

        verify(printStream).println("That book is not available.");
    }

    @Test
    public void shouldAddBookToAvailableBooksLibraryWhenBookReturned(){
        when(book2.hasTitle("Book to Return")).thenReturn(true);

        library.returnBook("Book to Return");

        assertThat(availableBooks.contains(book2), is(true));
    }

    @Test
    public void shouldRemoveBookFromCheckedOutBooksLibraryWhenBookReturned(){
        when(book2.hasTitle("Book to Return")).thenReturn(true);

        library.returnBook("Book to Return");

        assertThat(checkedOutBooks.contains(book2), is(false));
    }



    @Test
    public void shouldGiveSuccessfulReturnMessageIfBookIsReturned(){
        when(book2.hasTitle("book title")).thenReturn(true);

        library.returnBook("book title");

        verify(printStream).println("Thank you for returning the book.");
    }

    @Test
    public void shouldGiveErrorReturnMessageIfBookDoesNotBelongInLibrary(){
        when(book1.hasTitle("book title")).thenReturn(false);

        library.returnBook("book title");

        verify(printStream).println("That is not a valid book to return.");
    }

    @Test
    public void shouldListDetailsOfAllMoviesWhenShowingMovies() {
        library.showMovies();

        verify(movie1).movieOutput();
    }

}