package com.abrenica;

import com.abrenica.Model.Cart;
import com.abrenica.Model.Product;
import com.abrenica.Model.ProductList;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // List of products
        ProductList productList = new ProductList();

        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);

        // Main loop for user interaction
        while (true) {
            // Clear the console
            clearConsole();

            // Display sorted list of products by category
            System.out.println("Welcome to Our E-commerce Store!");
            System.out.println("Products Available:");
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-5s %-25s %-15s %-20s %-15s %-10s\n", "ID", "Name", "Price", "Category", "Availability", "Quantity");
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            for (Product product : productList.getProducts()) {
                // Limit the width of the Name column to 25 characters and wrap if necessary
                String productName = product.getName();
                if (productName.length() > 25) {
                    productName = productName.substring(0, 22) + "..."; // shorten long names for display
                }
                System.out.printf("%-5d %-25s $%-12.2f %-20s %-15s %-10d\n", product.getProductId(), productName, product.getPrice(), product.getCategory(), (product.isInStock() ? "Available" : "Not available"), product.getQuantity());
            }
            System.out.println("-------------------------------------------------------------------------------------------------------------------");


            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Add Product to Cart");
            System.out.println("2. Display Cart");
            System.out.println("3. Remove a Product from Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                // Add Product to Cart
                case "1":
                    addProductToCart(scanner, productList, cart);
                    break;

                // Display Cart
                case "2":
                    cart.displayCart();
                    break;

                // Remove a Product from Cart
                case "3":
                    removeProductFromCart(scanner, productList, cart);
                    break;

                // Checkout
                case "4":
                    cart.checkout(scanner);
                    break;

                // Exit
                case "5":
                    System.exit(0);
                    break;


                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
                    break;
            }

            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();  // Wait for the user to press Enter
        }
    }

    // Method to clear the console
    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    // Method to validate and get user input as integer
    private static int getUserInput(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }


    // Method to add a product to the cart
    public static void addProductToCart(Scanner scanner, ProductList productList, Cart cart) {
        int productId = getUserInput(scanner, "Enter Product ID: ");

        // Find the product by ID in predefined products
        Optional<Product> selectedProductOpt = productList.findProductInListById(productId);

        selectedProductOpt.ifPresentOrElse(product -> {
            System.out.print("Enter quantity to add: ");
            int quantityToAdd = getUserInput(scanner, "");
            if (quantityToAdd > product.getQuantity()) {
                System.out.println(String.format("Cannot add more than available quantity. Available quantity: %d", product.getQuantity()));
            } else {
                cart.addToCart(product, quantityToAdd);
                System.out.println(String.format("Product added to cart: %s", product.getName()));
            }
        }, () -> System.out.println(String.format("Product not found with ID: %d", productId)));
    }

    // Method to remove a product from the cart
    public static void removeProductFromCart(Scanner scanner, ProductList productList, Cart cart) {
        printCart(cart);
        int productId = getUserInput(scanner, "Enter Product ID to remove: ");

        // Find the product by ID in the cart
        Optional<Product> selectedProductOpt = cart.getCart().stream()
                .filter(product -> product.getProductId() == productId)
                .findFirst();

        selectedProductOpt.ifPresentOrElse(product -> {
            System.out.print("Enter quantity to remove: ");
            int quantityToRemove = getUserInput(scanner, "");
            if (quantityToRemove > product.getQuantity()) {
                System.out.println("Cannot remove more than available quantity. Available quantity: " + product.getQuantity());
            } else {
                product.setQuantity(product.getQuantity() - quantityToRemove);
                if (product.getQuantity() == 0) {
                    cart.removeFromCart(product);
                }
                System.out.println("Product quantity updated in cart: " + product.getName());
                updateProductList(productList, productId, quantityToRemove);
            }
        }, () -> System.out.println("Product not found in cart with ID: " + productId));
    }

    // Method to print the cart
    private static void printCart(Cart cart) {
        System.out.println("Your Cart:");
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-5s %-20s %-10s %-15s %-15s %-10s\n", "ID", "Name", "Price", "Category", "Availability", "Quantity");
        System.out.println("-----------------------------------------------------------------");
        for (Product product : cart.getCart()) {
            System.out.printf("%-5d %-20s $%-10.2f %-15s %-15s %-10d\n", product.getProductId(), product.getName(), product.getPrice(), product.getCategory(), (product.isInStock() ? "Available" : "Not available"), product.getQuantity());
        }
        System.out.println("-----------------------------------------------------------------");
    }

    // Method to update the product list
    private static void updateProductList(ProductList productList, int productId, int quantityToRemove) {
        for (Product product : productList.getProducts()) {
            if (product.getProductId() == productId) {
                product.setQuantity(product.getQuantity() + quantityToRemove);
                break;
            }
        }
    }
}