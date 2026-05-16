import java.util.Scanner;
import java.util.Random;

/**
 * Advanced While Loop Examples
 * Demonstrates:
 * - Basic while loop
 * - While loop with condition
 * - Sentinel-controlled loop
 * - Input validation with while
 * - Infinite loop with break
 * - While loop for countdown
 */
public class WhileLoopExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Advanced While Loop Examples ===");
        
        // 1. Basic while loop
        System.out.println("\n--- Basic While Loop ---");
        int i = 1;
        while (i <= 5) {
            System.out.println("Count: " + i);
            i++;
        }
        
        // 2. While loop for countdown
        System.out.println("\n--- Countdown ---");
        int countdown = 10;
        while (countdown > 0) {
            System.out.println(countdown + "...");
            countdown--;
        }
        System.out.println("Liftoff!");
        
        // 3. While loop for sum calculation
        System.out.println("\n--- Sum of Numbers ---");
        int sum = 0;
        int num = 1;
        while (num <= 100) {
            sum += num;
            num++;
        }
        System.out.println("Sum of 1 to 100: " + sum);
        
        // 4. While loop for factorial
        System.out.println("\n--- Factorial Calculation ---");
        int number = 5;
        int factorial = 1;
        int temp = number;
        while (temp > 0) {
            factorial *= temp;
            temp--;
        }
        System.out.println("Factorial of " + number + ": " + factorial);
        
        // 5. While loop for digit reversal
        System.out.println("\n--- Digit Reversal ---");
        int originalNum = 12345;
        int reversedNum = 0;
        int tempNum = originalNum;
        while (tempNum != 0) {
            int digit = tempNum % 10;
            reversedNum = reversedNum * 10 + digit;
            tempNum /= 10;
        }
        System.out.println("Original: " + originalNum);
        System.out.println("Reversed: " + reversedNum);
        
        // 6. While loop for palindrome check
        System.out.println("\n--- Palindrome Check ---");
        int palindromeNum = 12321;
        int tempPalin = palindromeNum;
        int reversedPalin = 0;
        while (tempPalin != 0) {
            int digit = tempPalin % 10;
            reversedPalin = reversedPalin * 10 + digit;
            tempPalin /= 10;
        }
        System.out.println(palindromeNum + " is " + 
            (palindromeNum == reversedPalin ? "a palindrome" : "not a palindrome"));
        
        // 7. Sentinel-controlled loop
        System.out.println("\n--- Sentinel-Controlled Loop ---");
        System.out.println("Enter numbers to sum (enter 0 to stop):");
        int sentinelSum = 0;
        int input;
        while (true) {
            input = scanner.nextInt();
            if (input == 0) break;
            sentinelSum += input;
        }
        System.out.println("Sum: " + sentinelSum);
        
        // 8. While loop for GCD calculation
        System.out.println("\n--- GCD Calculation ---");
        int a = 48, b = 18;
        while (b != 0) {
            int tempGcd = b;
            b = a % b;
            a = tempGcd;
        }
        System.out.println("GCD of 48 and 18: " + a);
        
        // 9. While loop for random number generation
        System.out.println("\n--- Random Number Until Target ---");
        Random random = new Random();
        int target = 7;
        int randomNum;
        int attempts = 0;
        while (true) {
            randomNum = random.nextInt(10) + 1;
            attempts++;
            System.out.println("Generated: " + randomNum);
            if (randomNum == target) {
                System.out.println("Got " + target + " in " + attempts + " attempts!");
                break;
            }
        }
        
        // 10. While loop for binary conversion
        System.out.println("\n--- Decimal to Binary ---");
        int decimal = 25;
        StringBuilder binary = new StringBuilder();
        int tempDec = decimal;
        while (tempDec > 0) {
            binary.insert(0, tempDec % 2);
            tempDec /= 2;
        }
        System.out.println("Decimal " + decimal + " = Binary " + binary);
        
        scanner.close();
    }
}