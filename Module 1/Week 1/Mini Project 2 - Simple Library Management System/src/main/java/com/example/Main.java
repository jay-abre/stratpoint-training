package com.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookService bookService = new BookService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add a book");
            System.out.println("2. Remove a book by ISBN");
            System.out.println("3. Search for books by ISBN");
            System.out.println("4. Show all books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                //Add a Book
                case 1:
                    System.out.print("Enter title of the book: ");
                    String bookTitle = scanner.nextLine().trim();

                    System.out.print("Enter author of the book: ");
                    String bookAuthor = scanner.nextLine().trim();

                    System.out.print("Enter ISBN of the book: ");
                    String bookIsbn = scanner.nextLine().trim();

                    bookService.addBook(bookTitle, bookAuthor, bookIsbn);
                    bookService.showPublicationType();
                    break;
                // Remove a book by its ISBN
                case 2:
                    System.out.print("Enter ISBN of the book to remove: ");
                    String isbnToRemove = scanner.nextLine().trim();
                    bookService.removeBook(isbnToRemove);
                    break;
                // Search a book by ISBN
                case 3:
                    String isbnToSearch = scanner.nextLine().trim();
                    bookService.searchBook(isbnToSearch);
                    break;
                // Display all books
                case 4:
                    bookService.displayAllBooks();
                    break;
                //Exit the program
                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
