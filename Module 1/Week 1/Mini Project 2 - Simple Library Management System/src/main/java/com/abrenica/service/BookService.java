package com.abrenica.service;

import com.abrenica.model.Book;
import org.apache.commons.validator.routines.ISBNValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Service class for managing books in a library.
 * Provides methods to add, remove, search, and display books,
 * as well as showing the type of publication (inherited from ShowPublicationType).
 */

public class BookService implements IBookService {

    private List<Book> books; // List to store all books in the library
    private Scanner scanner; // Scanner object for user input
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);
    private ISBNValidator validator = new ISBNValidator(); // ISBN validator object, see addBook method

    /**
     * Constructor to initialize BookService with an empty list of books and a Scanner object.
     */
    public BookService() {
        this.books = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

   //add book to the library
    public void addBook(String bookTitle, String bookAuthor, String bookIsbn) {
        Book newBook = new Book(bookTitle, bookAuthor, bookIsbn);
        boolean isValidISBN = validator.isValid(bookIsbn);

        if (isValidISBN) {
            books.add(newBook);
            System.out.println("\n\n--------------------------------------------------");
            System.out.println("Book added successfully to the library:" + newBook);
            System.out.println("-------------------------------------------------------");
            showPublicationType();
        } else {
            System.out.println("The ISBN is not valid.");
        }
    }

    // Removes a book from the library by its ISBN.
    public void removeBook(String isbn) {
        boolean removed = books.removeIf(book -> book.getISBN().equals(isbn));
        if (removed) {
            System.out.println("Removed book with ISBN: " + isbn);
        } else {
            System.out.println("Book with ISBN " + isbn + " not found.");
        }
    }
    //Searches for books in the library by ISBN.
    public List<Book> searchBook(String ISBN) {
        List<Book> foundBooks = books.stream()
                .filter(book -> book.getISBN().equals(ISBN))
                .collect(Collectors.toList());

        if (!foundBooks.isEmpty()) {
            System.out.println("Found " + foundBooks.size() + " book(s) with ISBN '" + ISBN + "':");
            foundBooks.forEach(System.out::println);
        } else {
            System.out.println("No books found with ISBN '" + ISBN + "'.");
        }
        return foundBooks;
    }

    //Shows the type of publication handled by this service (always "Book" in this basic version).
    @Override
    public void showPublicationType() {
        System.out.println("Type of Publication: Book ");
    }

    //Displays all books currently in the library.
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

