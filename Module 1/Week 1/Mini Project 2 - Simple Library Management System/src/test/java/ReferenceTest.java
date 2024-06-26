import com.abrenica.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ReferenceTest {

    private Reference reference;

    @BeforeEach
    public void setUp() {
        reference = new Reference("1-86092-049-7");
    }

    @Test
    public void testGetISBN() {
        assertEquals("1-86092-049-7", reference.getISBN());
    }

    @Test
    public void testSetISBN() {
        reference.setISBN("0-12345-678-9");
        assertEquals("0-12345-678-9", reference.getISBN());
    }
}