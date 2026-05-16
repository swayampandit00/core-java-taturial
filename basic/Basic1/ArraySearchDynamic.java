import java.util.Scanner;

public class ArraySearchDynamic {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] arr = {5, 15, 25, 35, 40, 45, 50, 55, 60};
        int target;
        boolean found = false;

        System.out.println("enter your number you want to search them : ");
        target = scanner.nextInt();


        for (int num : arr) {
            if (num == target) {
                found = true;
                break;
            }
        }

        System.out.println(found ? "Found" : "Not Found");
    }

}

