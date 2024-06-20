import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookService {

    private List<Book> books;
    private Scanner scanner;

    public BookService() {
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
        System.out.println("Added book: " + newBook);
        newBook.displayInfo();

    }

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

    public void searchBook(String ISBN) {
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
    }


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

}
