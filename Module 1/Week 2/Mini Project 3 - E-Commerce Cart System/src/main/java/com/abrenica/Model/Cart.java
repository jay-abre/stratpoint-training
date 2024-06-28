package com.abrenica.Model;

import com.abrenica.Service.CartService;
import com.abrenica.Service.ICartService;

import java.util.List;
import java.util.Scanner;

public class Cart {
    private ICartService cartService;

    // Constructor with argument
    public Cart(List<Product> myCart) {
        this.cartService = new CartService();
        if (myCart != null) {
            for (Product product : myCart) {
                this.cartService.addToCart(product, product.getQuantity());  // Add each product to the cart
            }
        }
    }

    // Empty constructor
    public Cart() {
        this.cartService = new CartService();
    }

    // Method to add a product to the cart
    public void addToCart(Product product, int quantityToAdd) {
        this.cartService.addToCart(product, quantityToAdd   );
    }

    // Method to remove a product from the cart
    public void removeFromCart(Product product) {
        this.cartService.removeFromCart(product);
    }

    // Method to calculate the total price of items in the cart
    public double getTotal() {
        return this.cartService.getTotal();
    }

    // Method to display the items in the cart
    public void displayCart() {
        this.cartService.displayCart();
    }


    // Method to checkout (clear the cart)
    public void checkout(Scanner scanner) {
        this.cartService.checkout(scanner);
    }

    // Getter for cart items (read-only)
    public List<Product> getCart() {
        return this.cartService.getCart();
    }
}