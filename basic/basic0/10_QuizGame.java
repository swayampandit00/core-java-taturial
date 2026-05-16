import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] questions = {"Capital of India?", "2 + 2 = ?"};
        String[][] options = {
            {"A. Delhi", "B. Mumbai", "C. Kolkata", "D. Chennai"},
            {"A. 3", "B. 4", "C. 5", "D. 6"}
        };
        char[] answers = {'A', 'B'};

        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (String opt : options[i]) {
                System.out.println(opt);
            }
            char ans = sc.next().toUpperCase().charAt(0);
            if (ans == answers[i]) score++;
        }

        System.out.println("Score: " + score);
        sc.close();
    }
}