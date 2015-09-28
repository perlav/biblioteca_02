package com.thoughtworks.biblioteca;

public class Book {

    private String name;
    private String author;
    private String yearPublished;

    public Book(String name, String author, String yearPublished){
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String bookOutput(){
        return name+" | "+author+" | "+yearPublished;
    }

    public boolean hasTitle(String title) {
        return this.name.equals(title);
    }
}
