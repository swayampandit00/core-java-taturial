public class Car { // Ye ek Car class hai, jisme car ke properties aur methods define honge
    static int noOfCarsSold; // Static variable hai, ye class level par hota hai aur saare objects ke liye common hota hai - kitni cars bechi gayi
    int noOfWheels; // Instance variable - har car object ke paas apne wheels ki count hogi
    String color; // Instance variable - har car ka apna color hoga
    float maxSpeed; // Instance variable - car ki maximum speed
    float currentFuelInLiters; // Instance variable - car mein currently kitna fuel hai
    int noOfSeats; // Instance variable - car mein kitni seats hain

    static { // Static block - ye class load hote hi ek baar chalta hai
        noOfCarsSold = 0; // Static variable ko initialize kar rahe hain - 0 cars bechi gayi
        System.out.println("I am in Static Block"); // Message print kar rahe hain ki static block chal raha hai
    }

    { // Instance Initialization Block - ye har baar chalta hai jab naya object banaya jaata hai
        noOfCarsSold++; // Bechi gayi cars ki count badha rahe hain
        System.out.println("I am in Init Block"); // Message print kar rahe hain ki init block chal raha hai
    }

    Car(String color) { // Parameterized constructor - color parameter le raha hai
        noOfWheels = 4; // Car ke 4 wheels set kar rahe hain
        this.color = color; // Parameter wale color ko instance variable mein store kar rahe hain
        maxSpeed = 150; // Maximum speed set kar rahe hain
        currentFuelInLiters = 2; // Shuru mein 2 liter fuel kar rahe hain
        noOfSeats = 5; // 5 seats set kar rahe hain
    }

    Car() { // Default constructor - koi parameter nahi le raha
        this("Black"); // Apne hi parameterized constructor ko call kar rahe hain "Black" color ke saath
        currentFuelInLiters = 5; // Fuel ko 5 liter set kar rahe hain
    }

    public Car start() { // Car ko start karne ka method
        int pop = 5; // Local variable - sirf is method mein use hoga
        if (currentFuelInLiters == 0) { // Check kar rahe hain ki fuel khatam toh nahi hua
            System.out.println(pop); // Local variable ki value print kar rahe hain
            System.out.println("Car is out if fuel, can not start"); // Fuel nahi hai toh message
        } else if (currentFuelInLiters < 5) { // Check kar rahe hain ki fuel 5 liter se kam hai
            System.out.println("Car is in reserved mode, please refuel"); // Fuel kam hai toh warning message
        } else { // Fuel sufficient hai
            System.out.println("Car is started.. bruhhhh....."); // Car start ho gaya
        }
        return this; // Current object return kar rahe hain taaki method chaining ho sake
    }

    public void drive() { // Car ko drive karne ka method
        currentFuelInLiters--; // Drive karne ke baad fuel 1 liter kam ho jaayega
        System.out.println("Car is driving"); // Message print kar rahe hain ki car chal rahi hai
    }

    public void addFuel(float currentFuelInLiters) { // Fuel add karne ka method
        this.currentFuelInLiters += currentFuelInLiters; // Current fuel mein naya fuel add kar rahe hain
    }

    public float getCurrentFuelLevel() { // Current fuel level check karne ka method
        return currentFuelInLiters; // Current fuel ki value return kar rahe hain
    }

    @Override // Ye method Object class ke toString method ko override kar raha hai
    public String toString() { // Object ko string mein convert karne ka method
        return "Car{" + // Car object ka string representation banate hain
                "noOfWheels=" + noOfWheels + // Wheels ki count add kar rahe hain
                ", color='" + color + '\'' + // Color add kar rahe hain
                ", maxSpeed=" + maxSpeed + // Max speed add kar rahe hain
                ", currentFuelInLiters=" + currentFuelInLiters + // Current fuel add kar rahe hain
                ", noOfSeats=" + noOfSeats + // Seats ki count add kar rahe hain
                '}';
    }
}
