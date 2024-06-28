package com.abrenica.Model;

import java.util.*;

public class ProductList {
    private List<Product> products;
    private Map<Integer, Product> productMap;

    public ProductList() {
        this.products = new ArrayList<>(); // List to store products
        this.productMap = new HashMap<>(); // Map to store products by ID
        initializeProducts();
    }

    private void initializeProducts() {
        addProduct(new Product(1, "Dell XPS 15 Laptop", 1999.99, "Laptops", 5, true));
        addProduct(new Product(2, "iPhone 13 Pro Max", 1099.99, "Smartphones", 10, true));
        addProduct(new Product(3, "Sony WH-1000XM4 Noise Cancelling Headphones", 349.99, "Headphones", 8, true));
        addProduct(new Product(4, "Nike Dri-FIT Men's T-shirt", 39.99, "T-shirts", 30, true));
        addProduct(new Product(5, "Levi's 511 Slim Fit Jeans", 69.99, "Jeans", 20, true));
        addProduct(new Product(6, "Samsonite Tectonic 2 Backpack", 89.99, "Backpacks", 15, true));
        addProduct(new Product(7, "Apple Watch Series 7", 399.99, "Smartwatches", 5, true));
        addProduct(new Product(8, "Ray-Ban Classic Aviator Sunglasses", 149.99, "Sunglasses", 12, true));
        addProduct(new Product(9, "Sony PlayStation 5", 499.99, "Gaming Consoles", 3, true));
        addProduct(new Product(10, "Adidas Essentials Men's Hoodie", 49.99, "Hoodies", 25, true));
        addProduct(new Product(11, "Nike Air Zoom Pegasus 38 Running Shoes", 119.99, "Running Shoes", 20, true));
        addProduct(new Product(12, "Calvin Klein Slim Fit Dress Shirt", 69.99, "Dress Shirts", 18, true));
        addProduct(new Product(13, "Samsung 55-inch QLED 4K Smart TV", 1299.99, "Televisions", 7, true));
        addProduct(new Product(14, "Bose QuietComfort 45 Wireless Headphones", 329.99, "Headphones", 10, true));
        addProduct(new Product(15, "Canon EOS R5 Mirrorless Camera", 3899.99, "Cameras", 4, true));
        addProduct(new Product(16, "Fitbit Charge 5 Fitness Tracker", 179.99, "Fitness Trackers", 15, true));
        addProduct(new Product(17, "Patagonia Men's Better Sweater", 139.99, "Sweaters", 20, true));
        addProduct(new Product(18, "Microsoft Surface Pro 8", 1199.99, "Tablets", 8, true));
        addProduct(new Product(19, "Breville Barista Express Espresso Machine", 699.99, "Coffee Machines", 6, true));
        addProduct(new Product(20, "Nintendo Switch OLED Model", 349.99, "Gaming Consoles", 10, true));
    }

    // Method to find a product by ID in the list of products
    public Optional<Product> findProductInListById(int productId) {
        return products.stream()
                .filter(product -> product.getProductId() == productId)
                .findFirst();
    }

    // Method to add a product to the list of products
    public void addProduct(Product product) {
        this.products.add(product);
        this.productMap.put(product.getProductId(), product);
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void sortProductsByCategory() {
        this.products.sort(Comparator.comparing(Product::getCategory));
    }

    public Product findProductById(int id) {
        return this.productMap.get(id);
    }
}