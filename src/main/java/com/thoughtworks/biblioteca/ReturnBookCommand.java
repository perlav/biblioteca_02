package com.thoughtworks.biblioteca;

/**
 * Created by njimenez on 9/25/15.
 */
public class ReturnBookCommand implements Command {

    private Library library;
    private UserBufferedReader reader;

    public ReturnBookCommand(Library library, UserBufferedReader reader) {
        this.library = library;
        this.reader = reader;
    }

    @Override
    public void execute() {
        String bookTitle = reader.readLine();
        library.returnBook(bookTitle);
    }
}
