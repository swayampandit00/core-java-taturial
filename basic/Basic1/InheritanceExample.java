/**
 * Advanced Inheritance Example
 * Demonstrates:
 * - Abstract classes
 * - Method overriding
 * - Polymorphism
 * - Interface implementation
 * - Protected and private access modifiers
 * - Constructor chaining with super()
 * - Dynamic method dispatch
 */

// Abstract base class
abstract class Animal {
    protected String name;
    protected int age;
    protected String species;
    
    // Constructor
    public Animal(String name, int age, String species) {
        this.name = name;
        this.age = age;
        this.species = species;
    }
    
    // Abstract method (must be implemented by subclasses)
    public abstract void makeSound();
    
    // Concrete method (can be overridden)
    public void eat() {
        System.out.println(name + " is eating.");
    }
    
    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
    
    // Getter methods
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getSpecies() {
        return species;
    }
    
    // Display animal info
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Species: " + species);
    }
}

// Interface for trainable animals
interface Trainable {
    void train();
    void performTrick();
}

// Dog class extending Animal and implementing Trainable
class Dog extends Animal implements Trainable {
    private String breed;
    private boolean isTrained;
    
    public Dog(String name, int age, String breed) {
        super(name, age, "Dog");
        this.breed = breed;
        this.isTrained = false;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof! Woof!");
    }
    
    @Override
    public void eat() {
        System.out.println(name + " the " + breed + " is eating dog food.");
    }
    
    // Dog-specific method
    public void bark() {
        System.out.println(name + " is barking loudly!");
    }
    
    public void wagTail() {
        System.out.println(name + " is wagging its tail happily!");
    }
    
    // Interface implementation
    @Override
    public void train() {
        isTrained = true;
        System.out.println(name + " has been trained!");
    }
    
    @Override
    public void performTrick() {
        if (isTrained) {
            System.out.println(name + " performs a trick: Roll over!");
        } else {
            System.out.println(name + " is not trained yet. Please train first!");
        }
    }
    
    public String getBreed() {
        return breed;
    }
}

// Cat class extending Animal
class Cat extends Animal {
    private boolean isIndoor;
    
    public Cat(String name, int age, boolean isIndoor) {
        super(name, age, "Cat");
        this.isIndoor = isIndoor;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }
    
    @Override
    public void eat() {
        System.out.println(name + " is eating cat food.");
    }
    
    // Cat-specific method
    public void purr() {
        System.out.println(name + " is purring contentedly.");
    }
    
    public void climb() {
        System.out.println(name + " is climbing a tree!");
    }
    
    public boolean isIndoor() {
        return isIndoor;
    }
}

// Bird class extending Animal
class Bird extends Animal {
    private boolean canFly;
    private String color;
    
    public Bird(String name, int age, String color, boolean canFly) {
        super(name, age, "Bird");
        this.color = color;
        this.canFly = canFly;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Tweet! Tweet!");
    }
    
    @Override
    public void eat() {
        System.out.println(name + " is eating seeds and worms.");
    }
    
    // Bird-specific method
    public void fly() {
        if (canFly) {
            System.out.println(name + " is flying high in the sky!");
        } else {
            System.out.println(name + " cannot fly (like a penguin or ostrich).");
        }
    }
    
    public void sing() {
        System.out.println(name + " is singing a beautiful song!");
    }
    
    public String getColor() {
        return color;
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        System.out.println("=== Advanced Inheritance Example ===");
        System.out.println("===================================\n");
        
        // Create different animal objects
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        Cat cat = new Cat("Whiskers", 2, true);
        Bird bird = new Bird("Tweety", 1, "Yellow", true);
        
        // Demonstrate inheritance
        System.out.println("--- Dog ---");
        dog.displayInfo();
        dog.makeSound();
        dog.eat();
        dog.sleep();
        dog.bark();
        dog.wagTail();
        
        // Demonstrate interface implementation
        dog.train();
        dog.performTrick();
        
        System.out.println("\n--- Cat ---");
        cat.displayInfo();
        cat.makeSound();
        cat.eat();
        cat.sleep();
        cat.purr();
        cat.climb();
        
        System.out.println("\n--- Bird ---");
        bird.displayInfo();
        bird.makeSound();
        bird.eat();
        bird.sleep();
        bird.fly();
        bird.sing();
        
        // Demonstrate polymorphism
        System.out.println("\n--- Polymorphism Example ---");
        Animal[] animals = new Animal[3];
        animals[0] = dog;
        animals[1] = cat;
        animals[2] = bird;
        
        for (Animal animal : animals) {
            System.out.println("\n" + animal.getName() + ":");
            animal.makeSound();  // Dynamic method dispatch
            animal.eat();        // May call overridden method
            animal.displayInfo();
        }
        
        // Demonstrate instanceof operator
        System.out.println("\n--- Instanceof Check ---");
        for (Animal animal : animals) {
            System.out.print(animal.getName() + " is a ");
            if (animal instanceof Dog) {
                System.out.println("Dog");
            } else if (animal instanceof Cat) {
                System.out.println("Cat");
            } else if (animal instanceof Bird) {
                System.out.println("Bird");
            }
        }
        
        // Demonstrate upcasting and downcasting
        System.out.println("\n--- Type Casting ---");
        Animal animalRef = dog;  // Upcasting (implicit)
        animalRef.makeSound();    // Calls Dog's makeSound()
        
        if (animalRef instanceof Dog) {
            Dog dogRef = (Dog) animalRef;  // Downcasting (explicit)
            dogRef.bark();  // Can now access Dog-specific methods
        }
    }
}