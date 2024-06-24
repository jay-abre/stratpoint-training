import com.example.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookServiceTest {

    private BookService bookService;

    @BeforeEach
    public void setUp() {
        bookService = new BookService();
    }

    @Test
    public void testAddBook() {
        bookService.addBook("The Grass is Always Greener", "Jeffrey Archer", "1-86092-049-7");
        List<Book> books = bookService.getBooks();
        assertEquals(1, books.size());
        assertEquals("The Grass is Always Greener", books.get(0).getTitle());
        assertEquals("Jeffrey Archer", books.get(0).getAuthor());
        assertEquals("1-86092-049-7", books.get(0).getISBN());
    }

    @Test
    public void testRemoveBook() {
        bookService.addBook("The Grass is Always Greener", "Jeffrey Archer", "1-86092-049-7");
        bookService.removeBook("1-86092-049-7");
        List<Book> books = bookService.getBooks();
        assertTrue(books.isEmpty());
    }

    @Test
    public void testSearchBook() {
        bookService.addBook("The Grass is Always Greener", "Jeffrey Archer", "1-86092-049-7");
        List<Book> foundBooks = bookService.searchBook("1-86092-049-7");
        assertEquals(1, foundBooks.size());
        assertEquals("Title1", foundBooks.get(0).getTitle());
        assertEquals("Author1", foundBooks.get(0).getAuthor());
        assertEquals("ISBN1", foundBooks.get(0).getISBN());
    }
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

    @Test
    public void testShowPublicationType() {
        // The showPublicationType method doesn't return anything, so we can't directly test its output.
        // However, we can at least call it to make sure it doesn't throw an exception.
        bookService.showPublicationType();
    }
}