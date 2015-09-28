package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class MainMenu {

    private PrintStream printStream;
    private Library library;
    private UserBufferedReader reader;
    private Map<String, Command> commandMap;

    public MainMenu(PrintStream printStream, Library library, UserBufferedReader reader, HashMap<String, Command> commandMap) {
        this.printStream = printStream;
        this.library = library;
        this.reader = reader;
        this.commandMap = commandMap;

    }

    public void selectOption() {
        printStream.println("Please choose an option from below or type \"Quit\""+
                            "\n1 - List Books" +
                            "\n2 - Checkout" +
                            "\n3 - Return Book");
        String option= reader.readLine();
        while(!option.equals("Quit")){
            if(commandMap.containsKey(option)){
                commandMap.get(option).execute();
            }
            else  {
                printStream.println("Select Valid Option!");
            }
            option = reader.readLine();
        }

        printStream.println("Done!");

    }

}
