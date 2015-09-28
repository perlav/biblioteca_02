package com.thoughtworks.biblioteca;

/**
 * Created by njimenez on 9/25/15.
 */
public class CheckoutCommand implements Command {
    Library library;
    UserBufferedReader bufferedReader;

    public CheckoutCommand(Library library, UserBufferedReader bufferedReader) {
        this.library=library;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void execute() {
        String bookTitle = bufferedReader.readLine();
        library.checkOut(bookTitle);
    }

}
