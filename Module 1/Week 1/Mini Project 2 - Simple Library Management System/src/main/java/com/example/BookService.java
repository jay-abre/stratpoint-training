package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Service class for managing books in a library.
 * Provides methods to add, remove, search, and display books,
 * as well as showing the type of publication (inherited from ShowPublicationType).
 */

public class BookService implements ShowPublicationType {

    private List<Book> books; // List to store all books in the library
    private Scanner scanner; // Scanner object for user input

    /**
     * Constructor to initialize BookService with an empty list of books and a Scanner object.
     */
    public BookService() {
        this.books = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Adds a new book to the library.
     * @param bookTitle Title of the book.
     * @param bookAuthor Author of the book.
     * @param bookIsbn ISBN of the book.
     */
    public void addBook(String bookTitle, String bookAuthor, String bookIsbn) {
        Book newBook = new Book(bookTitle, bookAuthor, bookIsbn);
        books.add(newBook);
        System.out.println("Added book: " + newBook);
    }

    /**
     * Removes a book from the library by its ISBN.
     * @param isbn ISBN of the book to be removed.
     */
    public void removeBook(String isbn) {
        boolean removed = false;
        for (Book book : books) {
            if (book.getISBN().equals(isbn)) {
                books.remove(book);
                System.out.println("Removed book: " + book);
                removed = true;
                break;
            }

        }
        if (!removed) {
            System.out.println("Book with ISBN " + isbn + " not found.");
        }
    }

    /**
     * Searches for books in the library by ISBN.
     * @param ISBN ISBN of the book to search for.
     * @return List of books matching the given ISBN.
     */
    public List<Book> searchBook(String ISBN) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                foundBooks.add(book);
            }
        }
        if (!foundBooks.isEmpty()) {
            System.out.println("Found " + foundBooks.size() + " book(s) with ISBN '" + ISBN + "':");
            for (Book book : foundBooks) {
                System.out.println(book);
            }
        } else {
            System.out.println("No books found with ISBN '" + ISBN + "'.");
        }
        return foundBooks;
    }

    /**
     * Shows the type of publication handled by this service (always "Book" in this basic version).
     */
    @Override
    public void showPublicationType() {
        System.out.println("Type of Publication: Book ");
    }

    /**
     * Displays all books currently in the library.
     */
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("\n--- List of All Books ---");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
    // Method to get the list of all books
    public List<Book> getBooks() {
        return books;
    }

}

