package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by njimenez on 9/25/15.
 */
public class ReturnBookCommandTest {
    private Library library;
    private UserBufferedReader reader;
    private ReturnBookCommand returnBookCommand;

    @Before
    public void setUp(){
        library = mock(Library.class);
        reader = mock(UserBufferedReader.class);
        returnBookCommand = new ReturnBookCommand(library, reader);

    }

    @Test
    public void shouldReturnBookWhenUserEntersThree(){
        when(reader.readLine()).thenReturn("book title");
        returnBookCommand.execute();
        verify(library).returnBook("book title");
    }

}