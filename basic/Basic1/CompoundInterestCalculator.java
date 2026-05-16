import java.util.Scanner;

public class CompoundInterestCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Principal: ");
        double P = sc.nextDouble();

        System.out.print("Enter Rate (%): ");
        double R = sc.nextDouble();

        System.out.print("Enter Time (years): ");
        double T = sc.nextDouble();

        System.out.print("Enter Compounds per year: ");
        int N = sc.nextInt();

        double r = R / 100.0;
        double A = P * Math.pow(1 + (r / N), N * T);
        double CI = A - P;

        System.out.println("Final Amount: " + A);
        System.out.println("Compound Interest: " + CI);

        sc.close();
    }
}