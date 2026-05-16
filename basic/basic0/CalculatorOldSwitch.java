import java.util.Scanner;

public class CalculatorOldSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1.Add 2.Subtract 3.Multiply 4.Divide");
        int ch = sc.nextInt();

        System.out.print("Enter two numbers: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();

        switch(ch) {
            case 1:
                System.out.println(a + b);
                break;
            case 2:
                System.out.println(a - b);
                break;
            case 3:
                System.out.println(a * b);
                break;
            case 4:
                if (b != 0)
                    System.out.println(a / b);
                else
                    System.out.println("Divide by zero");
                break;
            default:
                System.out.println("Invalid");
        }

        sc.close();
    }
}