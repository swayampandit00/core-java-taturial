/**
 * Advanced For Loop Examples
 * Demonstrates:
 * - Basic for loop
 * - Enhanced for-each loop
 * - Nested loops
 * - Labeled loops with break/continue
 * - Loop patterns (reverse, step)
 */
public class ForLoopExample {
    public static void main(String[] args) {
        System.out.println("=== Advanced For Loop Examples ===");
        
        // 1. Basic for loop
        System.out.println("\n--- Basic For Loop ---");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
        }
        
        // 2. Reverse for loop
        System.out.println("\n--- Reverse For Loop ---");
        for (int i = 10; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // 3. For loop with step
        System.out.println("\n--- For Loop with Step ---");
        for (int i = 0; i <= 20; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // 4. Enhanced for-each loop with array
        System.out.println("\n--- Enhanced For-Each Loop ---");
        int[] numbers = {10, 20, 30, 40, 50};
        int sum = 0;
        for (int num : numbers) {
            System.out.println("Number: " + num);
            sum += num;
        }
        System.out.println("Sum: " + sum);
        
        // 5. Nested for loop (multiplication table)
        System.out.println("\n--- Nested For Loop (Multiplication Table) ---");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
        
        // 6. Labeled loop with break
        System.out.println("\n--- Labeled Loop with Break ---");
        outer:
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    System.out.println("Breaking at i=" + i + ", j=" + j);
                    break outer;
                }
                System.out.println("i=" + i + ", j=" + j);
            }
        }
        
        // 7. Loop with continue
        System.out.println("\n--- Loop with Continue ---");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue; // Skip even numbers
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        // 8. Pattern printing (triangle)
        System.out.println("\n--- Pattern Printing ---");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        // 9. Finding prime numbers
        System.out.println("\n--- Prime Numbers (1-50) ---");
        for (int i = 2; i <= 50; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        
        // 10. Fibonacci series
        System.out.println("\n--- Fibonacci Series (First 10) ---");
        int n = 10;
        int first = 0, second = 1;
        System.out.print(first + " " + second + " ");
        for (int i = 2; i < n; i++) {
            int next = first + second;
            System.out.print(next + " ");
            first = second;
            second = next;
        }
        System.out.println();
    }
    
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}