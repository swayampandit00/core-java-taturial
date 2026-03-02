/**
 * Java 'new' Operator Examples
 * 
 * The 'new' operator in Java is used to:
 * 1. Create new objects (instantiate classes)
 * 2. Create new arrays
 * 3. Create new string objects
 */

// Class definition for demonstrating object creation
class Student {
    // Fields
    private String name;
    private int age;
    private String grade;
    
    // Constructor
    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
    
    // Method to display student info
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
}

public class newoprtor {
    public static void main(String[] args) {
        System.out.println("=== Java 'new' Operator Examples ===\n");
        
        // Example 1: Creating objects using 'new' operator
        System.out.println("--- Example 1: Creating Objects with 'new' ---");
        
        // Using 'new' to create an instance of Student class
        Student student1 = new Student("John", 20, "A");
        Student student2 = new Student("Alice", 22, "B+");
        
        // Accessing object methods
        student1.displayInfo();
        System.out.println();
        student2.displayInfo();
        
        // Example 2: Creating arrays using 'new' operator
        System.out.println("\n--- Example 2: Creating Arrays with 'new' ---");
        
        // Array of primitive type
        int[] numbers = new int[5];
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;
        
        System.out.print("Integer array: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        
        // Array of objects
        Student[] students = new Student[3];
        students[0] = new Student("Bob", 19, "A-");
        students[1] = new Student("Charlie", 21, "B");
        students[2] = new Student("Diana", 20, "A");
        
        System.out.println("\nStudent array:");
        for (int i = 0; i < students.length; i++) {
            System.out.println("Student " + (i + 1) + ": " + students[i].getName() + 
                             ", Age: " + students[i].getAge());
        }
        
        // Example 3: Creating String objects with 'new'
        System.out.println("\n--- Example 3: Creating Strings with 'new' ---");
        
        // String using string literal
        String str1 = "Hello";
        
        // String using 'new' operator
        String str2 = new String("World");
        
        System.out.println("String literal: " + str1);
        System.out.println("String with new: " + str2);
        
        // Example 4: Dynamic array creation
        System.out.println("\n--- Example 4: Dynamic Array Size with 'new' ---");
        
        int size = 5;
        double[] prices = new double[size];
        prices[0] = 19.99;
        prices[1] = 29.99;
        prices[2] = 39.99;
        prices[3] = 49.99;
        prices[4] = 59.99;
        
        System.out.print("Dynamic array: ");
        for (double price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
        
        // Summary
        System.out.println("\n=== Summary ===");
        System.out.println("The 'new' operator is used to:");
        System.out.println("1. Instantiate classes (create objects)");
        System.out.println("2. Create arrays with specified size");
        printDescription();
    }
    
    public static void printDescription() {
        System.out.println("\n=== How 'new' operator works ===");
        System.out.println("Syntax: ClassName object = new ClassName(parameters)");
        System.out.println("Steps:");
        System.out.println("1. 'new' allocates memory for the object in heap");
        System.out.println("2. Calls the constructor to initialize the object");
        System.out.println("3. Returns a reference to the newly created object");
    }
}
