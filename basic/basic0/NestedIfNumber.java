import java.util.Scanner;

public class NestedIfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();

        if (num > 0) {
            if (num % 2 == 0) {
                System.out.println("Positive and Even");
            } else {
                System.out.println("Positive and Odd");
            }
        } else {
            System.out.println("Negative number");
        }

        sc.close();
    }
}