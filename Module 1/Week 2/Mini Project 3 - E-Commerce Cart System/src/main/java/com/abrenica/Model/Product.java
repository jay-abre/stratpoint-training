package com.abrenica.Model;


import lombok.*;



public class Product {

    private int productId;
    private String name;
    private double price;
    private String category;
    private int quantity;
    private boolean inStock;

    public Product(int productId, String name, double price, String category, int quantity, boolean inStock) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.inStock = inStock;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
}
