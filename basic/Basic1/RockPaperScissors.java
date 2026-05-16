import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String[] choices = {"rock", "paper", "scissors"};
        String comp = choices[rand.nextInt(3)];

        System.out.print("Enter rock/paper/scissors: ");
        String user = sc.nextLine();

        System.out.println("Computer: " + comp);

        if (user.equalsIgnoreCase(comp)) System.out.println("Draw");
        else if (
            (user.equalsIgnoreCase("rock") && comp.equals("scissors")) ||
            (user.equalsIgnoreCase("paper") && comp.equals("rock")) ||
            (user.equalsIgnoreCase("scissors") && comp.equals("paper"))
        ) System.out.println("You Win");
        else System.out.println("Computer Wins");

        sc.close();
    }
}