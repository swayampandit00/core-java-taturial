// Class definition
class Car {
    // Fields (instance variables)
    private String brand;
    private String model;
    private int year;
    
    // Constructor
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    
    // Method to display car info
    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
    
    // Getter method
    public String getBrand() {
        return brand;
    }
}

public class instance {
    public static void main(String[] args) {
        // Creating an instance/object of the Car class using the 'new' keyword
        Car myCar = new Car("Toyota", "Camry", 2023);
        
        // Accessing the object using reference variable 'myCar'
        myCar.displayInfo();
        
        // Creating another instance
        Car anotherCar = new Car("Honda", "Civic", 2022);
        anotherCar.displayInfo();
        
        // Using getter to access field
        System.out.println("My car brand: " + myCar.getBrand());
    }
}
