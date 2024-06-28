package com.abrenica.Service;

import com.abrenica.Model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class CartService implements ICartService {
    private List<Product> myCart;
    private static final Logger logger = LogManager.getLogger(CartService.class);

    public CartService() {
        this.myCart = new ArrayList<>();
    }

    // Method to add a product to the cart
    @Override
    public void addToCart(Product product, int quantity) {
        // Check if the product is not null
        Objects.requireNonNull(product, "Product cannot be null");

        // Check if the product is in stock and the quantity is more than 0
        if (product.isInStock() && product.getQuantity() >= quantity) {
            // Decrease the quantity of the product by the desired quantity
            product.setQuantity(product.getQuantity() - quantity);

            // Create a new product with the same details but with the desired quantity to add to the cart
            Product productToAdd = new Product(product.getProductId(), product.getName(), product.getPrice(), product.getCategory(), quantity, true);
            myCart.add(productToAdd);
            logger.info(String.format("Added to cart: %s", product.getName()));
        } else {
            // If the product is out of stock or the quantity is less than the desired quantity, throw an exception
            throw new IllegalArgumentException(String.format("Cannot add out-of-stock product or insufficient quantity to cart: %s", product.getName()));
        }
    }

    // Optional for methods that may not always return a value.
    public Optional<Product> findProductInListById(int productId) {
        return myCart.stream()
                .filter(product -> product.getProductId() == productId)
                .findFirst();
    }

    // Method to remove a product from the cart
    @Override
    public void removeFromCart(Product product) {
        Objects.requireNonNull(product, "Product cannot be null");

        if (myCart.remove(product)) {
            logger.info("Removed from cart: " + product.getName());
        } else {
            logger.info("Product not found in cart.");
        }
    }

    // Method to calculate the total price of items in the cart
    @Override
    public double getTotal() {
        return myCart.stream()
                .mapToDouble(product -> product.getPrice() * product.getQuantity())
                .sum();
    }

    // Method to display the items in the cart
    public void displayCart() {
        if (myCart.isEmpty()) {
            logger.info("Your cart is empty.");
        } else {
            logger.info("Items in your cart:");
            logger.info(String.format("%-20s %-10s %-10s %-15s", "Product Name", "Price", "Quantity", "Availability"));
            myCart.forEach(product -> logger.info(String.format("%-20s $%-10.2f %-10d %-15s", product.getName(), product.getPrice(), product.getQuantity(), (product.isInStock() ? "Available" : "Not available"))));
            double totalPrice = getTotal();
            logger.info(String.format("Total Price: $%.2f", totalPrice));
        }
    }

    @Override
    public void checkout(Scanner scanner) {
        if (myCart.isEmpty()) {
            logger.info("Your cart is empty. Please add items before checking out.");
        } else {
            List<Product> checkedOutProducts = new ArrayList<>();
            String response = "yes";
            do {
                displayCart();
                logger.info("Enter Product ID to checkout:");
                int productId = Integer.parseInt(scanner.nextLine());
                Optional<Product> productOpt = findProductInListById(productId);
                if (productOpt.isPresent()) {
                    Product product = productOpt.get();
                    logger.info("Enter quantity to checkout for product " + product.getName() + " (0-" + product.getQuantity() + "):");
                    int quantityToCheckout = Integer.parseInt(scanner.nextLine());
                    if (quantityToCheckout < 0 || quantityToCheckout > product.getQuantity()) {
                        logger.info("Invalid quantity. Please enter a number between 0 and " + product.getQuantity() + ".");
                        continue;
                    }
                    if (quantityToCheckout > 0) {
                        Product productToCheckout = new Product(product.getProductId(), product.getName(), product.getPrice(), product.getCategory(), quantityToCheckout, true);
                        checkedOutProducts.add(productToCheckout);
                        product.setQuantity(product.getQuantity() - quantityToCheckout);
                    }
                } else {
                    logger.info("Product not found in cart with ID: " + productId);
                }
                logger.info("Do you want to checkout more items? (yes/no):");
                response = scanner.nextLine();
            } while (response.equalsIgnoreCase("yes"));

            myCart.removeAll(checkedOutProducts);
            logger.info("Thank you for shopping with us!");
        }
    }
    @Override
    public List<Product> getCart() {
        return myCart;
    }

    public Product findProductInListById(int productId, List<Product> products) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

}