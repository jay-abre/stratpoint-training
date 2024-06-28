# E-commerce Store Application

## Overview

This Java application simulates an e-commerce store where users can browse products, add them to a cart, manage the cart contents, and proceed to checkout. It includes functionality to display products, add to/remove from the cart, and view the cart with total prices.

## Features

- Display list of products sorted by category.
- Add products to the cart with specified quantities.
- View and manage items in the cart: add, remove, or update quantities.
- Checkout process to finalize selected items.

## Technologies Used

- Java 8+
- Maven for project management
- JUnit and Mockito for unit testing

## Class Structure

### Main Class (`com.abrenica.Main`)

The `Main` class serves as the entry point and controls user interaction with the application.

#### Methods:

- **`main(String[] args)`**: Entry point of the application. Displays a menu for user actions:
  - Add a product to the cart.
  - Display the current cart contents.
  - Remove a product from the cart.
  - Checkout and finalize the transaction.
  - Exit the application.

- **`clearConsole()`**: Clears the console output for better readability.

- **`getUserInput(Scanner scanner, String message)`**: Helper method to validate and retrieve integer inputs from the user.

- **`addProductToCart(Scanner scanner, ProductList productList, Cart cart)`**: Allows users to add a selected product to the cart with a specified quantity. Handles validation for available quantities.

- **`removeProductFromCart(Scanner scanner, ProductList productList, Cart cart)`**: Enables users to remove a selected product from the cart or update its quantity.

- **`printCart(Cart cart)`**: Prints out the current contents of the cart with details like product ID, name, price, category, availability, and quantity.

- **`updateProductList(ProductList productList, int productId, int quantityToRemove)`**: Updates the product list when items are removed from the cart to restore their availability.

### ProductList Class (`com.abrenica.Model.ProductList`)

- Manages a list of available products (`List<Product>`).

- Provides methods to retrieve products and find products by ID.

### Cart Class (`com.abrenica.Model.Cart`)

- Represents the user's shopping cart.

- Includes methods to add products, remove products, display the cart contents, calculate the total price, and handle the checkout process.

### Product Class (`com.abrenica.Model.Product`)

- Represents a product with attributes such as ID, name, price, category, availability, and quantity.

- Provides getters and setters for these attributes.

## Process Flow

### Starting the Application

1. **Start Application**:
   - The `Main` class initializes a list of products (`ProductList`) and an empty cart (`Cart`).
   - A menu is displayed for user interaction.

2. **Display Products**:
   - Products are displayed sorted by category in a formatted table.
   - Each product shows details like ID, name, price, category, availability, and quantity.

### User Interaction

3. **User Interaction**:
   - Users choose actions from the main menu:
     - **Add Product to Cart**: Prompts for product ID and quantity to add to the cart.
     - **Display Cart**: Shows current items in the cart with total price.
     - **Remove Product from Cart**: Allows removal of products from the cart or updates their quantities.
     - **Checkout**: Finalizes selected items in the cart and completes the transaction.
     - **Exit**: Terminates the application.

4. **Validation and Error Handling**:
   - Inputs are validated to ensure they are within valid ranges.
   - Errors, such as adding more than available quantities or selecting invalid products, are handled gracefully with appropriate messages.

5. **Checkout Process**:
   - Users are prompted to confirm their cart contents.
   - Items are removed from the cart upon successful checkout, and the total cost is displayed.

### Console Output

6. **Console Output**:
   - Console output is formatted for clarity and user-friendly interaction.
   - Cart details, errors, and confirmation messages are displayed as required.

## Testing

### Technologies Used

- **Maven**: Manages dependencies and builds the project.
- **JUnit**: Framework for writing and running unit tests.
- **Mockito**: Mocking framework to create mock objects for testing.

### Testing Strategy

- **Unit Testing**:
  - Test individual methods in classes like `Cart`, `ProductList`, and `Main`.
  - Mock dependencies (like `Scanner` input) using Mockito for isolated testing.
  - Ensure methods handle edge cases such as invalid inputs and empty states.

- **Integration Testing**:
  - Test interactions between components such as adding products to the cart and updating the product list accordingly.
  - Ensure the flow from adding products to checking out works seamlessly.

- **Edge Cases**:
  - Test scenarios like adding products with quantities exceeding availability, removing non-existent products from the cart, and checking out with empty carts.

### Running Tests

- Use Maven to compile and run tests:
  ```bash
  mvn clean test
