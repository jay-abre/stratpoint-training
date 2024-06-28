package CartServiceTest;

import com.abrenica.Model.Product;
import com.abrenica.Service.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetTotalTest {
    private CartService cartService;
    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() {
        cartService = new CartService();
        product1 = new Product(1, "Test Product 1", 100.0, "Test Category", 10, true);
        product2 = new Product(2, "Test Product 2", 200.0, "Test Category", 5, true);
    }

    @Test
    void testGetTotal_EmptyCart() {
        assertEquals(0.0, cartService.getTotal(), 0.01);
    }

    @Test
    void testGetTotal_OneProduct() {
        cartService.addToCart(product1, 5);
        assertEquals(500.0, cartService.getTotal(), 0.01);
    }

    @Test
    void testGetTotal_MultipleProducts() {
        cartService.addToCart(product1, 5);
        cartService.addToCart(product2, 2);
        assertEquals(900.0, cartService.getTotal(), 0.01);
    }
}
