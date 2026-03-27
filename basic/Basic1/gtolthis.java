public class gtolthis {
    // Global variable (instance variable)
    private String name;

    // Constructor
    public gtolthis(String name) {
        // Using "this" to access the global variable and distinguish it from parameter
        this.name = name;
    }

    // Method to display the global variable using "this"
    public void display() {
        System.out.println("Global value accessed using this: " + this.name);
    }

    // Main method to test
    public static void main(String[] args) {
        gtolthis obj = new gtolthis("Hello World");
        obj.display();
    }
}
