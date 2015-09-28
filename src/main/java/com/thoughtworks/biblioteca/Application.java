package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by lsantano on 9/22/15.
 */
public class Application {

    private PrintStream printStream;
    private MainMenu mainMenu;

    public Application(PrintStream printStream, MainMenu mainMenu) {
        this.printStream = printStream;
        this.mainMenu = mainMenu;
    }

    public void start() {
        printStream.println("Welcome!");
        mainMenu.selectOption();
    }
}
