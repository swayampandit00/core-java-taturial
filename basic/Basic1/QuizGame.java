import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.concurrent.TimeUnit;

/**
 * Advanced Quiz Game with Multiple Categories
 * Demonstrates:
 * - Object-oriented design with Question class
 * - Multiple quiz categories
 * - Timer functionality
 * - Score tracking and ranking
 * - Question randomization
 * - Difficulty levels
 * - Statistics tracking
 */
public class QuizGame {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<QuizResult> quizHistory = new ArrayList<>();
    private static int totalQuizzesTaken = 0;
    private static double highestScore = 0.0;
    
    public static void main(String[] args) {
        System.out.println("=== Advanced Quiz Game ===");
        System.out.println("=========================");
        
        boolean running = true;
        
        while (running) {
            displayMainMenu();
            
            try {
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        startQuiz();
                        break;
                    case 2:
                        viewQuizHistory();
                        break;
                    case 3:
                        viewStatistics();
                        break;
                    case 4:
                        running = false;
                        System.out.println("Thanks for playing!");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    private static void displayMainMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Start Quiz");
        System.out.println("2. View Quiz History");
        System.out.println("3. View Statistics");
        System.out.println("4. Exit");
        System.out.print("Choose option: ");
    }
    
    private static void startQuiz() {
        System.out.println("\n--- Select Category ---");
        System.out.println("1. General Knowledge");
        System.out.println("2. Science");
        System.out.println("3. Mathematics");
        System.out.println("4. Programming");
        System.out.println("5. Mixed (All Categories)");
        System.out.print("Choose category: ");
        
        int categoryChoice = scanner.nextInt();
        
        System.out.println("\n--- Select Difficulty ---");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        System.out.print("Choose difficulty: ");
        
        int difficultyChoice = scanner.nextInt();
        
        System.out.print("Enter your name: ");
        scanner.nextLine(); // Clear buffer
        String playerName = scanner.nextLine();
        
        System.out.print("Enable timer? (Y/N): ");
        char timerChoice = scanner.next().toUpperCase().charAt(0);
        boolean enableTimer = (timerChoice == 'Y');
        
        List<Question> questions = getQuestions(categoryChoice, difficultyChoice);
        
        if (questions.isEmpty()) {
            System.out.println("No questions available for this selection.");
            return;
        }
        
        // Shuffle questions
        Collections.shuffle(questions);
        
        // Limit to 10 questions
        int maxQuestions = Math.min(questions.size(), 10);
        questions = questions.subList(0, maxQuestions);
        
        int score = conductQuiz(questions, enableTimer);
        double percentage = (double) score / maxQuestions * 100;
        
        // Update statistics
        totalQuizzesTaken++;
        if (percentage > highestScore) {
            highestScore = percentage;
        }
        
        // Save quiz result
        QuizResult result = new QuizResult(playerName, categoryChoice, difficultyChoice, 
            score, maxQuestions, percentage);
        quizHistory.add(result);
        
        System.out.println("\n=== Quiz Complete ===");
        System.out.println("Player: " + playerName);
        System.out.println("Score: " + score + "/" + maxQuestions);
        System.out.println("Percentage: " + String.format("%.2f%%", percentage));
        System.out.println("Performance: " + getPerformanceRating(percentage));
    }
    
    private static List<Question> getQuestions(int category, int difficulty) {
        List<Question> allQuestions = new ArrayList<>();
        
        // Add questions based on category
        if (category == 1 || category == 5) {
            allQuestions.addAll(getGeneralKnowledgeQuestions(difficulty));
        }
        if (category == 2 || category == 5) {
            allQuestions.addAll(getScienceQuestions(difficulty));
        }
        if (category == 3 || category == 5) {
            allQuestions.addAll(getMathematicsQuestions(difficulty));
        }
        if (category == 4 || category == 5) {
            allQuestions.addAll(getProgrammingQuestions(difficulty));
        }
        
        return allQuestions;
    }
    
    private static List<Question> getGeneralKnowledgeQuestions(int difficulty) {
        List<Question> questions = new ArrayList<>();
        
        questions.add(new Question(
            "What is the capital of India?",
            new String[]{"A. Mumbai", "B. Delhi", "C. Kolkata", "D. Chennai"},
            'B',
            1
        ));
        
        questions.add(new Question(
            "Which planet is known as the Red Planet?",
            new String[]{"A. Venus", "B. Mars", "C. Jupiter", "D. Saturn"},
            'B',
            1
        ));
        
        questions.add(new Question(
            "Who wrote 'Romeo and Juliet'?",
            new String[]{"A. Charles Dickens", "B. William Shakespeare", "C. Jane Austen", "D. Mark Twain"},
            'B',
            2
        ));
        
        questions.add(new Question(
            "What is the largest ocean on Earth?",
            new String[]{"A. Atlantic", "B. Indian", "C. Pacific", "D. Arctic"},
            'C',
            1
        ));
        
        questions.add(new Question(
            "In which year did World War II end?",
            new String[]{"A. 1943", "B. 1944", "C. 1945", "D. 1946"},
            'C',
            2
        ));
        
        return questions;
    }
    
    private static List<Question> getScienceQuestions(int difficulty) {
        List<Question> questions = new ArrayList<>();
        
        questions.add(new Question(
            "What is the chemical symbol for water?",
            new String[]{"A. H2O", "B. CO2", "C. NaCl", "D. O2"},
            'A',
            1
        ));
        
        questions.add(new Question(
            "What is the speed of light in vacuum?",
            new String[]{"A. 3x10^6 m/s", "B. 3x10^8 m/s", "C. 3x10^10 m/s", "D. 3x10^12 m/s"},
            'B',
            2
        ));
        
        questions.add(new Question(
            "What is the powerhouse of the cell?",
            new String[]{"A. Nucleus", "B. Ribosome", "C. Mitochondria", "D. Golgi body"},
            'C',
            1
        ));
        
        questions.add(new Question(
            "What is Newton's first law of motion?",
            new String[]{"A. F=ma", "B. Action-Reaction", "C. Inertia", "D. Gravity"},
            'C',
            2
        ));
        
        return questions;
    }
    
    private static List<Question> getMathematicsQuestions(int difficulty) {
        List<Question> questions = new ArrayList<>();
        
        questions.add(new Question(
            "What is 15 + 27?",
            new String[]{"A. 42", "B. 41", "C. 43", "D. 44"},
            'A',
            1
        ));
        
        questions.add(new Question(
            "What is the square root of 144?",
            new String[]{"A. 10", "B. 11", "C. 12", "D. 13"},
            'C',
            1
        ));
        
        questions.add(new Question(
            "What is 2^5?",
            new String[]{"A. 16", "B. 32", "C. 64", "D. 128"},
            'B',
            1
        ));
        
        questions.add(new Question(
            "What is the value of π (pi) to two decimal places?",
            new String[]{"A. 3.12", "B. 3.14", "C. 3.16", "D. 3.18"},
            'B',
            1
        ));
        
        questions.add(new Question(
            "What is the derivative of x^2?",
            new String[]{"A. x", "B. 2x", "C. x^2", "D. 2"},
            'B',
            3
        ));
        
        return questions;
    }
    
    private static List<Question> getProgrammingQuestions(int difficulty) {
        List<Question> questions = new ArrayList<>();
        
        questions.add(new Question(
            "Which keyword is used to create a class in Java?",
            new String[]{"A. class", "B. Class", "C. CLASS", "D. create"},
            'A',
            1
        ));
        
        questions.add(new Question(
            "What does OOP stand for?",
            new String[]{"A. Object Oriented Programming", "B. Order Of Precedence", "C. Output Of Program", "D. Operator Overloading Protocol"},
            'A',
            1
        ));
        
        questions.add(new Question(
            "Which data type is used to store text in Java?",
            new String[]{"A. int", "B. char", "C. String", "D. boolean"},
            'C',
            1
        ));
        
        questions.add(new Question(
            "What is the time complexity of binary search?",
            new String[]{"A. O(n)", "B. O(log n)", "C. O(n^2)", "D. O(1)"},
            'B',
            2
        ));
        
        questions.add(new Question(
            "Which concept allows a class to inherit from another class?",
            new String[]{"A. Encapsulation", "B. Polymorphism", "C. Inheritance", "D. Abstraction"},
            'C',
            1
        ));
        
        return questions;
    }
    
    private static int conductQuiz(List<Question> questions, boolean enableTimer) {
        int score = 0;
        
        System.out.println("\n=== Quiz Started ===");
        System.out.println("Total Questions: " + questions.size());
        if (enableTimer) {
            System.out.println("Timer: 30 seconds per question");
        }
        
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            
            System.out.println("\nQuestion " + (i + 1) + "/" + questions.size());
            System.out.println(question.getQuestion());
            
            for (String option : question.getOptions()) {
                System.out.println(option);
            }
            
            long startTime = System.currentTimeMillis();
            System.out.print("Your answer: ");
            
            char answer = scanner.next().toUpperCase().charAt(0);
            
            long endTime = System.currentTimeMillis();
            long timeTaken = endTime - startTime;
            
            if (enableTimer && timeTaken > 30000) {
                System.out.println("Time's up! Moving to next question.");
                continue;
            }
            
            if (answer == question.getCorrectAnswer()) {
                score++;
                System.out.println("✓ Correct!");
            } else {
                System.out.println("✗ Wrong! Correct answer: " + question.getCorrectAnswer());
            }
            
            if (enableTimer) {
                System.out.println("Time taken: " + (timeTaken / 1000) + " seconds");
            }
        }
        
        return score;
    }
    
    private static String getPerformanceRating(double percentage) {
        if (percentage >= 90) return "Excellent! 🌟";
        if (percentage >= 75) return "Very Good! 👍";
        if (percentage >= 60) return "Good! 👌";
        if (percentage >= 50) return "Average 😐";
        return "Needs Improvement 😅";
    }
    
    private static void viewQuizHistory() {
        System.out.println("\n--- Quiz History ---");
        
        if (quizHistory.isEmpty()) {
            System.out.println("No quizzes taken yet.");
            return;
        }
        
        for (int i = 0; i < quizHistory.size(); i++) {
            QuizResult result = quizHistory.get(i);
            System.out.println((i + 1) + ". " + result.playerName + 
                " - Score: " + result.score + "/" + result.totalQuestions + 
                " (" + String.format("%.2f%%", result.percentage) + ")");
        }
    }
    
    private static void viewStatistics() {
        System.out.println("\n--- Statistics ---");
        System.out.println("Total Quizzes Taken: " + totalQuizzesTaken);
        System.out.println("Highest Score: " + String.format("%.2f%%", highestScore));
        
        if (totalQuizzesTaken > 0) {
            double averageScore = quizHistory.stream()
                .mapToDouble(r -> r.percentage)
                .average()
                .orElse(0.0);
            System.out.println("Average Score: " + String.format("%.2f%%", averageScore));
        }
    }
    
    private static class Question {
        private final String question;
        private final String[] options;
        private final char correctAnswer;
        private final int difficulty;
        
        public Question(String question, String[] options, char correctAnswer, int difficulty) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
            this.difficulty = difficulty;
        }
        
        public String getQuestion() {
            return question;
        }
        
        public String[] getOptions() {
            return options;
        }
        
        public char getCorrectAnswer() {
            return correctAnswer;
        }
        
        public int getDifficulty() {
            return difficulty;
        }
    }
    
    private static class QuizResult {
        String playerName;
        int category;
        int difficulty;
        int score;
        int totalQuestions;
        double percentage;
        
        public QuizResult(String playerName, int category, int difficulty, 
                         int score, int totalQuestions, double percentage) {
            this.playerName = playerName;
            this.category = category;
            this.difficulty = difficulty;
            this.score = score;
            this.totalQuestions = totalQuestions;
            this.percentage = percentage;
        }
    }
}