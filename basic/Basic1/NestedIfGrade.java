import java.util.Scanner;

public class NestedIfGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks: ");
        int marks = sc.nextInt();

        if (marks >= 40) {
            if (marks >= 75) {
                System.out.println("Pass with Distinction");
            } else {
                System.out.println("Pass");
            }
        } else {
            System.out.println("Fail");
        }

        sc.close();
    }
}