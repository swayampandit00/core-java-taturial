import java.util.Scanner;

public class Relational {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Driving License Portal");
        System.out.print("Please enter your age: ");
        int age = input.nextInt();

        if (age >= 18) {
            System.out.println("You are eligible to drive");
        } else {
            System.out.println("you are not eligible to drive");
        }
    }
}

//output
/*Welcome to Driving License Portal
Please enter your age: 18
You are eligible to drive

Welcome to Driving License Portal
Please enter your age: 17
you are not eligible to drive */