import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int number = rand.nextInt(100) + 1;
        int guess;

        do {
            System.out.print("Guess number (1-100): ");
            guess = sc.nextInt();

            if (guess > number) System.out.println("Too high!");
            else if (guess < number) System.out.println("Too low!");
            else System.out.println("Correct!");

        } while (guess != number);

        sc.close();
    }
}