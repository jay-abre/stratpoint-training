package model;

import com.abrenica.model.Book;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    private Book book;

    @BeforeEach
    public void setUp() {
        book = new Book("The Grass is Always Greener", "Jeffrey Archer", "1-86092-049-7");
    }

    @Test
    public void testGetTitle() {
        assertEquals("The Grass is Always Greener", book.getTitle());
    }

    @Test
    public void testSetTitle() {
        book.setTitle("New Title");
        assertEquals("New Title", book.getTitle());
    }

    @Test
    public void testGetAuthor() {
        assertEquals("Jeffrey Archer", book.getAuthor());
    }

    @Test
    public void testSetAuthor() {
        book.setAuthor("New Author");
        assertEquals("New Author", book.getAuthor());
    }

    @Test
    public void testToString() {
        String expectedString = "The Grass is Always Greener by Jeffrey Archer - ISBN: 1-86092-049-7";
        assertEquals(expectedString, book.toString());
    }

}