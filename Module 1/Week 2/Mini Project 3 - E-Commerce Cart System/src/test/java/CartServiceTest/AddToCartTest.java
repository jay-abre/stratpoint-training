package CartServiceTest;

import com.abrenica.Model.Cart;
import com.abrenica.Model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddToCartTest {
    private Cart cart;
    private Product product;

    @BeforeEach
    void setUp() {
        cart = new Cart();
        product = new Product(1, "Test Product", 100.0, "Test Category", 10, true);
    }

    @Test
    void testAddToCart_Success() {
        cart.addToCart(product, 5);
        assertEquals(1, cart.getCart().size());
        assertEquals(5, cart.getCart().get(0).getQuantity());
    }

    @Test
    void testAddToCart_InsufficientQuantity() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addToCart(product, 15);
        });

        String expectedMessage = "Cannot add out-of-stock product or insufficient quantity to cart: Test Product";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testAddToCart_OutOfStock() {
        product.setInStock(false);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addToCart(product, 5);
        });

        String expectedMessage = "Cannot add out-of-stock product or insufficient quantity to cart: Test Product";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testAddToCart_NullProduct() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            cart.addToCart(null, 5);
        });

        String expectedMessage = "Product cannot be null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}