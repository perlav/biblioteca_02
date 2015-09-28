package com.thoughtworks.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BookTest {

    private Book book1;

    @Before
    public void setup() {
        book1 = new Book("Book1", "Lucy", "1995");
    }

    @Test
    public void shouldPrintNameAuthorYearOfBook(){

        assertThat(book1.bookOutput(), is("Book1 | Lucy | 1995"));

    }

    @Test
    public void shouldReturnTrueIfTheBookHasTheTitle() {
        assertThat(book1.hasTitle("Book1"), is(true));
    }

    @Test
    public void shouldReturnFalseIfTheBookDoesNotHaveTheTitle() {
        assertThat(book1.hasTitle("blah"), is(false));
    }
}