package com.abrenica.Service;



import com.abrenica.Model.Product;

import java.util.List;
import java.util.Scanner;

public interface ICartService {
    void addToCart(Product product, int quantity);
    void removeFromCart(Product product);
    double getTotal();
    void displayCart();
    void checkout(Scanner scanner);
    List<Product> getCart();

}
