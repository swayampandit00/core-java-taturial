import java.util.Scanner;
import java.util.Random;

/**
 * Advanced Do-While Loop Examples
 * Demonstrates:
 * - Basic do-while loop
 * - Menu-driven programs
 * - Input validation
 * - Game loops
 * - Retry mechanisms
 */
public class DoWhileLoopExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Advanced Do-While Loop Examples ===");
        
        // 1. Basic do-while loop
        System.out.println("\n--- Basic Do-While Loop ---");
        int i = 1;
        do {
            System.out.println("Count: " + i);
            i++;
        } while (i <= 5);
        
        // 2. Do-while for input validation
        System.out.println("\n--- Input Validation ---");
        int positiveNumber;
        do {
            System.out.print("Enter a positive number: ");
            positiveNumber = scanner.nextInt();
            if (positiveNumber <= 0) {
                System.out.println("Invalid! Please enter a positive number.");
            }
        } while (positiveNumber <= 0);
        System.out.println("Valid number entered: " + positiveNumber);
        
        // 3. Menu-driven program
        System.out.println("\n--- Menu-Driven Program ---");
        boolean menuRunning = true;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Say Hello");
            System.out.println("2. Say Goodbye");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Hello!");
                    break;
                case 2:
                    System.out.println("Goodbye!");
                    break;
                case 3:
                    System.out.println("Exiting...");
                    menuRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (menuRunning);
        
        // 4. Do-while for password validation
        System.out.println("\n--- Password Validation ---");
        String correctPassword = "java123";
        String enteredPassword;
        int attempts = 0;
        final int maxAttempts = 3;
        
        do {
            System.out.print("Enter password (attempt " + (attempts + 1) + "/" + maxAttempts + "): ");
            enteredPassword = scanner.next();
            attempts++;
            
            if (enteredPassword.equals(correctPassword)) {
                System.out.println("Access granted!");
                break;
            } else if (attempts < maxAttempts) {
                System.out.println("Incorrect password. Try again.");
            } else {
                System.out.println("Maximum attempts reached. Access denied.");
            }
        } while (!enteredPassword.equals(correctPassword) && attempts < maxAttempts);
        
        // 5. Do-while for guessing game
        System.out.println("\n--- Number Guessing Game ---");
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;
        int guess;
        int guessAttempts = 0;
        
        do {
            System.out.print("Guess a number (1-100): ");
            guess = scanner.nextInt();
            guessAttempts++;
            
            if (guess < secretNumber) {
                System.out.println("Too low!");
            } else if (guess > secretNumber) {
                System.out.println("Too high!");
            } else {
                System.out.println("Correct! You guessed it in " + guessAttempts + " attempts!");
            }
        } while (guess != secretNumber);
        
        // 6. Do-while for calculator
        System.out.println("\n--- Simple Calculator ---");
        boolean calcRunning = true;
        do {
            System.out.print("Enter first number (0 to exit): ");
            double num1 = scanner.nextDouble();
            
            if (num1 == 0) {
                calcRunning = false;
                continue;
            }
            
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();
            
            System.out.print("Enter operation (+, -, *, /): ");
            String operation = scanner.next();
            
            double result;
            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("Cannot divide by zero!");
                        continue;
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Invalid operation!");
                    continue;
            }
            
            System.out.println("Result: " + result);
        } while (calcRunning);
        
        // 7. Do-while for number validation
        System.out.println("\n--- Range Validation ---");
        int rangeNumber;
        do {
            System.out.print("Enter a number between 10 and 50: ");
            rangeNumber = scanner.nextInt();
            if (rangeNumber < 10 || rangeNumber > 50) {
                System.out.println("Number must be between 10 and 50!");
            }
        } while (rangeNumber < 10 || rangeNumber > 50);
        System.out.println("Valid number: " + rangeNumber);
        
        scanner.close();
    }
}