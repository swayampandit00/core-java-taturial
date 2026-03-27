import java.util.Scanner;

public class runtime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            // Display menu
            System.out.println("\n===== CALCULATOR =====");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            
            choice = scanner.nextInt();
            
            if (choice >= 1 && choice <= 4) {
                // Get two numbers from user
                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();
                
                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();
                
                // Perform calculation based on choice
                switch (choice) {
                    case 1:
                        System.out.println("Result: " + num1 + " + " + num2 + " = " + (num1 + num2));
                        break;
                    case 2:
                        System.out.println("Result: " + num1 + " - " + num2 + " = " + (num1 - num2));
                        break;
                    case 3:
                        System.out.println("Result: " + num1 + " * " + num2 + " = " + (num1 * num2));
                        break;
                    case 4:
                        if (num2 != 0) {
                            System.out.println("Result: " + num1 + " / " + num2 + " = " + (num1 / num2));
                        } else {
                            System.out.println("Error: Cannot divide by zero!");
                        }
                        break;
                }
            } else if (choice != 5) {
                System.out.println("Invalid choice! Please try again.");
            }
            
        } while (choice != 5);
        
        System.out.println("Thank you for using the Calculator. Goodbye!");
        scanner.close();
    }
}
