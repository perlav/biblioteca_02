package com.thoughtworks.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by lsantano on 9/23/15.
 */
public class UserBufferedReader {

    private BufferedReader reader;

    public UserBufferedReader(BufferedReader reader){
        this.reader = reader;
    }

    public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeIOException();
        }
    }

}
