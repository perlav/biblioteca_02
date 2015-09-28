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
public class CheckoutCommandTest {
    private Library library;
    private UserBufferedReader reader;
    private CheckoutCommand checkoutCommand;

    @Before
    public void setUp(){
        library = mock(Library.class);
        reader = mock(UserBufferedReader.class);
        checkoutCommand = new CheckoutCommand(library, reader);

    }

    @Test
    public void shouldListBooksWhenUserEntersOne(){
        when(reader.readLine()).thenReturn("book title");
        checkoutCommand.execute();
        verify(library).checkOut("book title");
    }


}