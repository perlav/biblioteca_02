package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> availableBooks;
    private ArrayList<Book> checkedOutBooks;
    private PrintStream printStream;
    private ArrayList<Movie> availableMovies;

    public Library(ArrayList<Book> availableBooks, ArrayList<Book> checkedOutBooks, PrintStream printStream, ArrayList<Movie> availableMovies){
        this.availableBooks = availableBooks;
        this.checkedOutBooks=checkedOutBooks;
        this.printStream = printStream;
        this.availableMovies = availableMovies;
    }

    public void showBooks() {
        String bookList = "";
        for(Book item: availableBooks){
            bookList+=(item.bookOutput() + "\n");
        }
        printStream.println(bookList);
    }

    public void checkOut(String bookTitle) {
        boolean bookExists = false;
        for(Book book: availableBooks){
            if (book.hasTitle(bookTitle)){
                bookExists = true;
                availableBooks.remove(book);
                checkedOutBooks.add(book);
                printStream.println("Thank You! Enjoy the book.");
                break;
            }
        }

        if(!bookExists){
            printStream.println("That book is not available.");
        }

    }

    public void returnBook(String title) {
        boolean bookExists = false;
        for(Book book: checkedOutBooks){
            if (book.hasTitle(title)){
                bookExists = true;
                checkedOutBooks.remove(book);
                availableBooks.add(book);
                printStream.println("Thank you for returning the book.");
                break;
            }
        }

        if(!bookExists){
            printStream.println("That is not a valid book to return.");
        }
    }

    public void showMovies() {
        String movieList = "";
        for(Movie item: availableMovies){
            movieList+=(item.movieOutput() + "\n");
        }
        printStream.println(movieList);

    }
}
