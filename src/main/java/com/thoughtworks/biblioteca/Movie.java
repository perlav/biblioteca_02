package com.thoughtworks.biblioteca;

/**
 * Created by njimenez on 9/25/15.
 */
public class Movie {

    private String name;
    private String year;
    private String director;
    private String rating;

    public Movie(String name, String year, String director, String rating) {

        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String movieOutput(){
        return name+" | "+year+" | "+director+" | "+rating;
    }

}
