import java.util.Scanner;

public class WeightConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter weight in kg: ");
        double kg = sc.nextDouble();

        System.out.println("Grams: " + (kg * 1000));
        System.out.println("Pounds: " + (kg * 2.20462));

        sc.close();
    }
}