
import java.util.Scanner;

public class Main {

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }


    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return num1 / num2;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.println("Select operation (1, 2, 3, 4): ");
            System.out.println("1 - Addition 2 - Subtraction  3 - Multiply  4 - Division");
            char operation = scanner.next().charAt(0);

            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();


            double result = 0;
            switch (operation) {
                case '1':
                    result = add(num1, num2);
                    break;
                case '2':
                    result = subtract(num1, num2);
                    break;
                case '3':
                    result = multiply(num1, num2);
                    break;
                case '4':
                    result = divide(num1, num2);
                    break;
                default:
                    System.out.println("Invalid operation!");
                    return;
            }

            System.out.println("Result: " + result);


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
