import java.util.Scanner;

public class CircleSphereCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter radius: ");
        double radius = sc.nextDouble();

        double circumference = 2 * Math.PI * radius;
        double area = Math.PI * radius * radius;
        double volume = (4.0 / 3.0) * Math.PI * radius * radius * radius;

        System.out.println("Circumference: " + circumference);
        System.out.println("Area: " + area);
        System.out.println("Volume of Sphere: " + volume);

        sc.close();
    }
}