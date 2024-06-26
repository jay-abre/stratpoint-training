package com.abrenica.model;

/**
 * Represents a reference or identifier for different publications in the library (journals, articles, magazines)       .
 * In this case, specifically for books using ISBN (International   Standard Book Number).
 * This class demonstrates inheritance for managing different publication types.
 */
public class Reference {
    private String ISBN;

    public Reference(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}


