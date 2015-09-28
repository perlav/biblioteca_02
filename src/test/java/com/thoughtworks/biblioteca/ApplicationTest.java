package com.thoughtworks.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by lsantano on 9/22/15.
 */
public class ApplicationTest {

    PrintStream printStream;
    Application app;
    Library library;
    MainMenu mainMenu;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        library = mock(Library.class);
        mainMenu = mock(MainMenu.class);
        app = new Application(printStream, mainMenu);

    }

    @Test
    public void shouldOutputWelcome() throws IOException {
        app.start();
        verify(printStream).println("Welcome!");
    }

    @Test
    public void shouldSelectOptionWhenAppStarting() {
        app.start();

        verify(mainMenu).selectOption();
    }
}