import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name = input.nextLine();
        System.out.println("Good Morning " + name);
        System.out.print(name + ", Also tell me your age:");
        int age = input.nextInt();
        System.out.println("Your age is: " + age);
    }
}

//output

/* Please enter your name: swayam pandit
Good Morning swayam pandit
swayam pandit, Also tell me your age:21
Your age is: 21*/
