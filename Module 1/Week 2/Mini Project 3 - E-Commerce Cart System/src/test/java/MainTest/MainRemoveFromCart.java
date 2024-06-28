package MainTest;

import com.abrenica.Model.Cart;
import com.abrenica.Model.Product;
import com.abrenica.Model.ProductList;
import com.abrenica.Main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainRemoveFromCart {
    private ProductList productList;
    private Cart cart;
    private Product product;
    private Scanner scanner;

    @BeforeEach
    void setUp() {
        productList = new ProductList();
        cart = new Cart();
        product = new Product(1, "Test Product", 100.0, "Test Category", 10, true);
        productList.addProduct(product);
        cart.addToCart(product, 5);
    }

    @Test
    void testRemoveFromCart_Success() {
        scanner = new Scanner(new ByteArrayInputStream("1\n5\n".getBytes()));
        Main.removeProductFromCart(scanner, productList, cart);
        assertEquals(0, cart.getCart().size());
    }

    @Test
    void testRemoveFromCart_ProductNotFound() {
        scanner = new Scanner(new ByteArrayInputStream("2\n5\n".getBytes()));
        Main.removeProductFromCart(scanner, productList, cart);
        assertEquals(1, cart.getCart().size());
    }

    @Test
    void testRemoveFromCart_InsufficientQuantity() {
        scanner = new Scanner(new ByteArrayInputStream("1\n15\n".getBytes()));
        Main.removeProductFromCart(scanner, productList, cart);
        assertEquals(1, cart.getCart().size());
    }
}