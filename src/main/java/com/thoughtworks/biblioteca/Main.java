package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList<Book> availableBooks = new ArrayList<>();
        ArrayList <Book> checkedOutBooks = new ArrayList<>();
        Book book1 = new Book("book1", "author1", "2010");
        Book book2 = new Book("Programmers Guide to Programming", "Natasha", "2005");
        Book book3 = new Book("Thoughtworks: A How To", "Lucy", "2008");
        Book book4 = new Book("CheckIn", "Natasha", "2012");
        availableBooks.add(book1);
        availableBooks.add(book2);
        availableBooks.add(book3);
        checkedOutBooks.add(book4);

        ArrayList<Movie> availableMovies = new ArrayList<>();
        Movie movie1 = new Movie("The Revenge of the Programmers", "2015", "Perla", "10");
        availableMovies.add(movie1);

        UserBufferedReader bufferedReader = new UserBufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        Library library = new Library(availableBooks, checkedOutBooks, System.out, availableMovies);
        HashMap<String, Command> commandMap = new HashMap<>();
        commandMap.put("1", new ListBooksCommand(library));
        commandMap.put("2", new CheckoutCommand(library, bufferedReader));
        commandMap.put("3", new ReturnBookCommand(library, bufferedReader));
        MainMenu mainMenu = new MainMenu(System.out, library, bufferedReader, commandMap);
        Application app = new Application(System.out, mainMenu);
        app.start();
    }
}
