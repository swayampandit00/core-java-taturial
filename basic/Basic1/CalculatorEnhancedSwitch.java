import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Advanced Calculator with Enhanced Switch Expression
 * Demonstrates:
 * - Menu-driven interface with loop
 * - Comprehensive error handling
 * - Multiple mathematical operations
 * - Enhanced switch expressions (Java 14+)
 * - Input validation
 * - Memory feature for storing results
 */
public class CalculatorEnhancedSwitch {
    private static double memory = 0.0;
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== Advanced Scientific Calculator ===");
        System.out.println("====================================");
        
        boolean running = true;
        
        while (running) {
            displayMenu();
            
            try {
                System.out.print("\nEnter your choice (1-12, 0 to exit): ");
                int choice = scanner.nextInt();
                
                if (choice == 0) {
                    running = false;
                    System.out.println("Calculator closed. Goodbye!");
                    continue;
                }
                
                double result = performOperation(choice);
                
                if (result != Double.NaN) {
                    System.out.println("\nResult: " + formatResult(result));
                    System.out.print("Store in memory? (Y/N): ");
                    char storeMemory = scanner.next().toUpperCase().charAt(0);
                    
                    if (storeMemory == 'Y') {
                        memory = result;
                        System.out.println("Result stored in memory: " + memory);
                    }
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            } catch (ArithmeticException e) {
                System.out.println("Mathematical error: " + e.getMessage());
            }
        }
        
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("\n--- Operations Menu ---");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.println("5. Modulus (%)");
        System.out.println("6. Power (^)");
        System.out.println("7. Square Root (√)");
        System.out.println("8. Absolute Value (|x|)");
        System.out.println("9. Maximum (max)");
        System.out.println("10. Minimum (min)");
        System.out.println("11. Recall Memory (MR)");
        System.out.println("12. Clear Memory (MC)");
        System.out.println("0. Exit");
        System.out.println("Current Memory: " + memory);
    }
    
    private static double performOperation(int choice) {
        return switch (choice) {
            case 1 -> {
                double[] nums = getTwoNumbers();
                yield nums[0] + nums[1];
            }
            case 2 -> {
                double[] nums = getTwoNumbers();
                yield nums[0] - nums[1];
            }
            case 3 -> {
                double[] nums = getTwoNumbers();
                yield nums[0] * nums[1];
            }
            case 4 -> {
                double[] nums = getTwoNumbers();
                if (nums[1] == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                yield nums[0] / nums[1];
            }
            case 5 -> {
                double[] nums = getTwoNumbers();
                if (nums[1] == 0) {
                    throw new ArithmeticException("Modulus by zero is not allowed");
                }
                yield nums[0] % nums[1];
            }
            case 6 -> {
                double[] nums = getTwoNumbers();
                yield Math.pow(nums[0], nums[1]);
            }
            case 7 -> {
                System.out.print("Enter number: ");
                double num = scanner.nextDouble();
                if (num < 0) {
                    throw new ArithmeticException("Square root of negative number");
                }
                yield Math.sqrt(num);
            }
            case 8 -> {
                System.out.print("Enter number: ");
                double num = scanner.nextDouble();
                yield Math.abs(num);
            }
            case 9 -> {
                double[] nums = getTwoNumbers();
                yield Math.max(nums[0], nums[1]);
            }
            case 10 -> {
                double[] nums = getTwoNumbers();
                yield Math.min(nums[0], nums[1]);
            }
            case 11 -> {
                System.out.println("Memory value: " + memory);
                yield memory;
            }
            case 12 -> {
                memory = 0.0;
                System.out.println("Memory cleared");
                yield 0.0;
            }
            default -> {
                System.out.println("Invalid choice! Please select 1-12 or 0 to exit.");
                yield Double.NaN;
            }
        };
    }
    
    private static double[] getTwoNumbers() {
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        return new double[]{num1, num2};
    }
    
    private static String formatResult(double result) {
        if (result == (long) result) {
            return String.format("%d", (long) result);
        }
        return String.format("%.4f", result);
    }
}