
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
                case 1:
                    bookService.addBook();
                    break;
                case 2:
                    System.out.print("Enter ISBN of the book to remove: ");
                    String isbnToRemove = scanner.nextLine().trim();
                    bookService.removeBook(isbnToRemove);
                    break;
                case 3:
                    System.out.print("Enter title of the book to search: ");
                    String titleToSearch = scanner.nextLine().trim();
                    bookService.searchBook(titleToSearch);
                    break;
                case 4:
                    System.out.println("\n--- List of All Books ---");
                    bookService.displayBooks();

                    break;
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
