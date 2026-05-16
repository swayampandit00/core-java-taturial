import java.util.Scanner;

public class BankingProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 1000;

        System.out.print("Enter amount to deposit: ");
        int deposit = sc.nextInt();
        balance += deposit;

        System.out.print("Enter amount to withdraw: ");
        int withdraw = sc.nextInt();
        balance -= withdraw;

        System.out.println("Final Balance: " + balance);
        sc.close();
    }
}