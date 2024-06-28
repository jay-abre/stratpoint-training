package CartServiceTest;

import com.abrenica.Model.Product;
import com.abrenica.Service.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Optional;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CheckoutTest {
    private CartService cartService;
    private Product product;

    @BeforeEach
    void setUp() {
        cartService = new CartService();
        product = new Product(1, "Test Product", 100.0, "Test Category", 10, true);
        cartService.addToCart(product, 5);
    }

    @Test
    void checkout() {
        Scanner scanner = Mockito.mock(Scanner.class);
        when(scanner.nextLine()).thenReturn("1", "2", "no");

        // Assert that the product is in the cart before checkout
        Optional<Product> productOptBefore = cartService.findProductInListById(1);
        assertTrue(productOptBefore.isPresent());
        assertEquals(5, productOptBefore.get().getQuantity());

        cartService.checkout(scanner);

        // Assert that the product quantity has decreased after checkout
        Optional<Product> productOptAfter = cartService.findProductInListById(1);
        assertTrue(productOptAfter.isPresent());
        assertEquals(3, productOptAfter.get().getQuantity());
    }
    @Test
    void checkoutEmptyCart() {
        // Clear the cart before the test
        cartService.getCart().clear();

        Scanner scanner = Mockito.mock(Scanner.class);
        // No user input is needed because the cart is empty

        cartService.checkout(scanner);

        // Assert that the cart is still empty after checkout
        assertTrue(cartService.getCart().isEmpty());
    }
    @Test
    void checkoutNonExistentProduct() {
        Scanner scanner = Mockito.mock(Scanner.class);
        when(scanner.nextLine()).thenReturn("999", "no"); // 999 is a non-existent product ID

        cartService.checkout(scanner);

        // Assert that the cart size remains the same after checkout
        assertEquals(1, cartService.getCart().size());
    }

    @Test
    void checkoutInvalidProductId() {
        Scanner scanner = Mockito.mock(Scanner.class);
        when(scanner.nextLine()).thenReturn("invalid", "no"); // "invalid" is not a number

        assertThrows(NumberFormatException.class, () -> cartService.checkout(scanner));
    }
}