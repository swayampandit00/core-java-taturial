import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Celsius: ");
        double c = sc.nextDouble();

        double f = (9.0/5.0) * c + 32;
        double k = c + 273.15;

        System.out.println("Fahrenheit: " + f);
        System.out.println("Kelvin: " + k);

        sc.close();
    }
}