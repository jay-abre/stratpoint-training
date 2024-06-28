package CartServiceTest;

import com.abrenica.Model.Product;
import com.abrenica.Service.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveFromCart {
    private CartService cartService;
    private Product product;

    @BeforeEach
    void setUp() {
        cartService = new CartService();
        product = new Product(1, "Test Product", 100.0, "Test Category", 10, true);
        cartService.addToCart(product, 5);
    }

    @Test
    void testRemoveFromCart_Success() {
        cartService.removeFromCart(product);
        assertEquals(1, cartService.getCart().size());
    }

    @Test
    void testRemoveFromCart_ProductNotFound() {
        Product nonExistentProduct = new Product(2, "Non-existent Product", 200.0, "Test Category", 10, true);
        cartService.removeFromCart(nonExistentProduct);
        assertEquals(1, cartService.getCart().size());
    }

    @Test
    void testRemoveFromCart_NullProduct() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            cartService.removeFromCart(null);
        });

        String expectedMessage = "Product cannot be null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}