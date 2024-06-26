import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        boolean computeAgain = true;

        while (computeAgain) {
            try {
                System.out.println("Select operation (1, 2, 3, 4): ");
                System.out.println("1 - Addition  2 - Subtraction  3 - Multiply  4 - Division");
                char operation = scanner.next().charAt(0);

                double result = 0;

                switch (operation) {
                    case '1':
                        System.out.print("Enter how many numbers you want to add: ");
                        int countAdd = scanner.nextInt();
                        double[] addNumbers = new double[countAdd];
                        for (int i = 0; i < countAdd; i++) {
                            System.out.print("Enter number " + (i + 1) + ": ");
                            addNumbers[i] = scanner.nextDouble();
                        }
                        result = calculator.add(addNumbers);
                        break;
                    case '2':
                        System.out.print("Enter the first number: ");
                        double num1 = scanner.nextDouble();
                        System.out.print("Enter the second number: ");
                        double num2 = scanner.nextDouble();
                        result = calculator.subtract(num1, num2);
                        break;
                    case '3':
                        System.out.print("Enter how many numbers you want to multiply: ");
                        int countMultiply = scanner.nextInt();
                        double[] multiplyNumbers = new double[countMultiply];
                        for (int i = 0; i < countMultiply; i++) {
                            System.out.print("Enter number " + (i + 1) + ": ");
                            multiplyNumbers[i] = scanner.nextDouble();
                        }
                        result = calculator.multiply(multiplyNumbers);
                        break;
                    case '4':
                        System.out.print("Enter the first number: ");
                        double num3 = scanner.nextDouble();
                        System.out.print("Enter the second number: ");
                        double num4 = scanner.nextDouble();
                        result = calculator.divide(num3, num4);
                        break;
                    default:
                        System.out.println("Invalid operation!");
                        continue; // Restart the loop if operation is invalid
                }

                System.out.println("Result: " + result);

                // Ask user if they want to compute again
                System.out.print("Do you want to compute again? (yes/no): ");
                String answer = scanner.next().toLowerCase();

                if (!answer.equals("yes")) {
                    computeAgain = false;
                }

            } catch (Exception e) {
                System.out.println("Error: Invalid input " );
                scanner.nextLine();
            }
        }
        System.out.println("Exiting program. Goodbye!");
        scanner.close();
    }
}
