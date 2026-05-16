import java.util.Scanner;

/**
 * Advanced If-Else Example with Input Validation and Multiple Conditions
 * Demonstrates:
 * - User input handling
 * - Input validation
 * - Multiple conditional checks
 * - Ternary operator usage
 * - Even/Odd number detection
 */
public class IfElseExample1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        
        // Input validation
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a valid integer.");
            scanner.next(); // Clear invalid input
            System.out.print("Enter a number: ");
        }
        
        int num = scanner.nextInt();
        
        // Advanced conditional checks
        String result;
        
        if (num == 0) {
            result = "Zero";
        } else if (num > 0) {
            result = "Positive";
        } else {
            result = "Negative";
        }
        
        // Check if number is even or odd using ternary operator
        String parity = (num % 2 == 0) ? "Even" : "Odd";
        
        // Check if number is within specific ranges
        String range;
        if (Math.abs(num) < 10) {
            range = "Single digit";
        } else if (Math.abs(num) < 100) {
            range = "Two digit";
        } else if (Math.abs(num) < 1000) {
            range = "Three digit";
        } else {
            range = "Large number";
        }
        
        // Display all results
        System.out.println("\nNumber Analysis:");
        System.out.println("Number: " + num);
        System.out.println("Sign: " + result);
        System.out.println("Parity: " + parity);
        System.out.println("Range: " + range);
        
        // Additional check: Prime number (for positive numbers > 1)
        if (num > 1) {
            boolean isPrime = checkPrime(num);
            System.out.println("Prime: " + (isPrime ? "Yes" : "No"));
        }
        
        scanner.close();
    }
    
    /**
     * Helper method to check if a number is prime
     * @param num The number to check
     * @return true if prime, false otherwise
     */
    private static boolean checkPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}