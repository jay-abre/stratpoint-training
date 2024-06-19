import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Library {
    private List<Book> books;
    private Scanner scanner;


    public Library() {
        this.books = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addBook() {
        System.out.print("Enter title of the book: ");
        String title = scanner.nextLine().trim();

        System.out.print("Enter author of the book: ");
        String author = scanner.nextLine().trim();

        System.out.print("Enter ISBN of the book: ");
        String isbn = scanner.nextLine().trim();

        Book newBook = new Book(title, author, isbn);
        books.add(newBook);
        System.out.println("Added book: " +newBook.getTitle() +" by " + newBook.getAuthor()+ "ISBN: " + newBook.getISBN());
    }

    public void removeBook(String isbn) {
        boolean removed = false;
        for (Book book : books) {
            if (book.getISBN().equals(isbn)) {
                books.remove(book);
                System.out.println("Removed book: " + book.getTitle() + " by " + book.getAuthor() + " " + " ISBN: "+ book.getISBN());
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Book with ISBN " + isbn + " not found.");
        }
    }


    public void searchBook(String ISBN) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
                foundBooks.add(book);
        }
        if (!foundBooks.isEmpty()) {
            System.out.println("Found " + foundBooks.size() + " book(s) with title '" + ISBN + "':");
            for (Book book : foundBooks) {
                System.out.println(book.getTitle() + " by " + book.getAuthor() + " " + " ISBN: "+ book.getISBN());
            }
        } else {
            System.out.println("No books found with ISBN '" + ISBN + "'.");
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add a book");
            System.out.println("2. Remove a book by ISBN");
            System.out.println("3. Search for books by ISBN");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    library.addBook();
                    break;
                case 2:
                    System.out.print("Enter ISBN of the book to remove: ");
                    String isbnToRemove = scanner.nextLine().trim();
                    library.removeBook(isbnToRemove);
                    break;
                case 3:
                    System.out.print("Enter title of the book to search: ");
                    String titleToSearch = scanner.nextLine().trim();
                    library.searchBook(titleToSearch);
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}
