import com.abrenica.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookServiceTest {

    private BookService bookService;

    @BeforeEach
    public void setUp() {
        bookService = new BookService();
    }

    //testing for add book
    @Test
    public void testAddBook() {
        bookService.addBook("The Grass is Always Greener", "Jeffrey Archer", "1-86092-049-7");
        List<Book> books = bookService.getBooks();
        assertEquals(1, books.size());
        assertEquals("The Grass is Always Greener", books.get(0).getTitle());
        assertEquals("Jeffrey Archer", books.get(0).getAuthor());
        assertEquals("1-86092-049-7", books.get(0).getISBN());
    }

    //testing for removing book
    @Test
    public void testRemoveBook() {
        bookService.addBook("The Grass is Always Greener", "Jeffrey Archer", "1-86092-049-7");
        bookService.removeBook("1-86092-049-7");
        List<Book> books = bookService.getBooks();
        assertTrue(books.isEmpty());
    }

    //testing for removing book exception handler
    @Test
    public void testRemoveBookError() {
        bookService.addBook("The Grass is Always Greener", "Jeffrey Archer", "1-86092-049-7");
        bookService.removeBook("1-12392-049-7");

        assertEquals("Books with ISBN: 1-12392-049-7 found.", "Books with ISBN: 1-12392-049-7 found.");
    }

    //testing for searching book
    @Test
    public void testSearchBook() {
        bookService.addBook("The Grass is Always Greener", "Jeffrey Archer", "1-86092-049-7");
        List<Book> foundBooks = bookService.searchBook("1-86092-049-7");
        assertEquals(1, foundBooks.size());
        assertEquals("The Grass is Always Greener", foundBooks.get(0).getTitle());
        assertEquals("Jeffrey Archer", foundBooks.get(0).getAuthor());
        assertEquals("1-86092-049-7", foundBooks.get(0).getISBN());
    }

    //testing for exception handler of search book function
    @Test
    public void testSearchBookError() {
        bookService.addBook("The Grass is Always Greener", "Jeffrey Archer", "1-86092-049-7");
        List<Book> foundBooks = bookService.searchBook("1-12392-049-7");
        assertEquals("No book(s) found with ISBN: '1-12392-049-7'", "No book(s) found with ISBN: '1-12392-049-7'");
    }

    //testing of displaying all books
    @Test
    public void testDisplayAllBooks() {
        // Initially, the books list should be empty
        bookService.displayAllBooks();
        List<Book> books = bookService.getBooks();
        assertTrue(books.isEmpty());

        // Add a book and check if it's displayed
        bookService.addBook("The Grass is Always Greener", "Jeffrey Archer", "1-86092-049-7");
        bookService.displayAllBooks();
        books = bookService.getBooks();
        assertEquals(1, books.size());
    }

    //testing of displaying all books if books in the library are empty
    @Test
    public void testDisplayAllBooksEmpty() {
        // Initially, the books list should be empty
        bookService.displayAllBooks();
        List<Book> books = bookService.getBooks();
        assertTrue(books.isEmpty());
        assertEquals("No books in the library.", "No books in the library.");
    }

    @Test
    public void testShowPublicationType() {
        // The showPublicationType method doesn't return anything, so we can't directly test its output.
        // However, we can at least call it to make sure it doesn't throw an exception.
        bookService.showPublicationType();
    }

}