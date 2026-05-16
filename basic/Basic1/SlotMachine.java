import java.util.Random;

public class SlotMachine {
    public static void main(String[] args) {
        Random rand = new Random();
        String[] symbols = {"Cherry", "Lemon", "Bell"};

        String s1 = symbols[rand.nextInt(3)];
        String s2 = symbols[rand.nextInt(3)];
        String s3 = symbols[rand.nextInt(3)];

        System.out.println("| " + s1 + " | " + s2 + " | " + s3 + " |");

        if (s1.equals(s2) && s2.equals(s3)) {
            System.out.println("Jackpot!");
        } else {
            System.out.println("Try Again!");
        }
    }
}