public class Driver { // Ye ek Driver class hai, jisme driver ki properties aur methods define honge

    static int minAgeForDriving = 18; // Static variable - driving ke liye minimum age 18 years

    String name; // Driver ka naam
    int age; // Driver ki age
    String dateOfLicense; // License ki date jab driver ko license mila

    public boolean isAllowedToDrive() { // Ye method check karta hai ki driver driving kar sakta hai ya nahi
        return this.age >= minAgeForDriving; // Driver ki age minimum age se zyada ya equal hai toh true return karega
    }


    public static void main(String[] args) { // Main method - program yahan se start hota hai
//        Car myCar = new Car(); // Naya car object ban rahe hain (commented hai)
//        myCar.addFuel(6); // Car mein 6 liter fuel add kar rahe hain (commented hai)
//        myCar.drive(); // Car ko drive kar rahe hain (commented hai)
//        myCar.drive(); // Dobra car drive kar rahe hain (commented hai)
//        myCar.drive(); // Teesri baar car drive kar rahe hain (commented hai)
//        myCar.addFuel(3); // Car mein 3 liter fuel add kar rahe hain (commented hai)
//        myCar.drive(); // Car ko dobara drive kar rahe hain (commented hai)
//        System.out.println(myCar.getCurrentFuelLevel()); // Current fuel level print kar rahe hain (commented hai)

        Car swift = new Car("Red"); // Swift naam ka naya red color ka car object ban rahe hain
        Car thar = new Car(); // Thar naam ka naya car object ban rahe hain (default constructor call hoga)
        thar = null; // Thar object ko null kar rahe hain - ab ye garbage collect ho jaayega
        //swift.addFuel(6); // Swift car mein fuel add kar rahe hain (commented hai)
        swift.start().drive(); // Method chaining - pehle car start kar rahe hain phir drive kar rahe hain
        System.out.println(swift.color); // Swift car ka color print kar rahe hain

//        Driver myDriver = new Driver(); // Naya driver object ban rahe hain (commented hai)
//        myDriver.dateOfLicense = "1/Jan/2024"; // Driver ki license date set kar rahe hain (commented hai)
//        System.out.println(minAgeForDriving); // Minimum driving age print kar rahe hain (commented hai)
    }
}
