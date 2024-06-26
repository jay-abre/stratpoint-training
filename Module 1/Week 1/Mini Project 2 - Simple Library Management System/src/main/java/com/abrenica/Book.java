package com.abrenica;

// Book class extends Reference, meaning it inherits all of its properties and methods


public class Book extends Reference {
    private String title;
    private String author;

    public Book(String title, String author, String ISBN) {
        super(ISBN);
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // for easy formatting
    @Override
    public String toString() {
        return title + " by " + author + " - ISBN: " + getISBN();
    }


}
