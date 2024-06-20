import java.util.Scanner;

public class Calculator {

    // Method to add multiple numbers
    public double add(double... numbers) {
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum;
    }

    // Method to subtract two numbers
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    // Method to multiply multiple numbers
    public double multiply(double... numbers) {
        double product = 1;
        for (double num : numbers) {
            product *= num;
        }
        return product;
    }

    // Method to divide two numbers
    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return num1 / num2;
    }

    // Method to validate and get double input from user
    private double getValidDoubleInput(Scanner scanner, String prompt) {
        double input = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(prompt);
                input = scanner.nextDouble();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear scanner buffer
            }
        }

        return input;
    }
}
