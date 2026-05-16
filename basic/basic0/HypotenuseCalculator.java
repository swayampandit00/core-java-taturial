import java.util.Scanner;

public class HypotenuseCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter base: ");
        double base = sc.nextDouble();

        System.out.print("Enter perpendicular: ");
        double perpendicular = sc.nextDouble();

        double hypotenuse = Math.sqrt(base * base + perpendicular * perpendicular);
        System.out.println("Hypotenuse is: " + hypotenuse);

        sc.close();
    }
}