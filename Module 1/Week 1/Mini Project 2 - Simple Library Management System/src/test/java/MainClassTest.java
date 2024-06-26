import com.abrenica.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainClassTest {


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }


    @Test
    public void testMainMenu() {
        // Test the main method if the menu is displayed correctly
        String input = "5\n"; // 5 is for exiting the program
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.main(new String[]{});

        // Check that the output contains the expected strings
        assertTrue(outContent.toString().contains("\n1. Add a book"));
        assertTrue(outContent.toString().contains("2. Remove a book by ISBN"));
        assertTrue(outContent.toString().contains("3. Search for books by ISBN"));
        assertTrue(outContent.toString().contains("4. Show all books"));
        assertTrue(outContent.toString().contains("5. Exit"));
        assertTrue(outContent.toString().contains("Exiting program."));
    }

    @Test
    public void testMainInvalid() {
        // Test the main method if the user enter an invalid choice

        String input = "6\n5\n"; // 6 is an invalid choice, 5 is for exiting the program
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.main(new String[]{});

        // Check that the output contains the expected strings
        assertTrue(outContent.toString().contains("Invalid choice. Please enter a number between 1 and 4."));
        assertTrue(outContent.toString().contains("Exiting program."));
    }

    @Test
    public void testAddBook() {
        // Test the main method if the user chooses to add a book
        String input = "1\nTitle1\nAuthor1\nISBN1\n5\n"; // 1 is for adding a book, 5 is for exiting the program
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.main(new String[]{});

        // Check that the output contains the expected strings
        assertTrue(outContent.toString().contains("Enter title of the book: "));
        assertTrue(outContent.toString().contains("Enter author of the book: "));
        assertTrue(outContent.toString().contains("Enter ISBN of the book: "));
        assertTrue(outContent.toString().contains("Exiting program."));
    }
    @Test
    public void testRemoveBook() {
        // Test the main method if the user chooses to remove a book
        String input = "2\nISBN1\n5\n"; // 2 is for removing a book, 5 is for exiting the program
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.main(new String[]{});

        // Check that the output contains the expected strings
        assertTrue(outContent.toString().contains("Enter ISBN of the book to remove: "));
        assertTrue(outContent.toString().contains("Exiting program."));
    }

    @Test
    public void testSearchBook() {
        // Test the main method if the user chooses to search a book
        String input = "3\nISBN1\n5\n"; // 3 is for searching a book, 5 is for exiting the program
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.main(new String[]{});

        // Check that the output contains the expected strings
        assertTrue(outContent.toString().contains("Enter the ISBN of the book to search: "));
        assertTrue(outContent.toString().contains("Exiting program."));
    }
    @Test
    public void testExitProgram() {
        // Test the main method if the user chooses to exit the program
        String input = "5\n"; // 5 is for exiting the program
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.main(new String[]{});

        // Check that the output contains the expected strings
        assertTrue(outContent.toString().contains("Exiting program."));
    }

}
