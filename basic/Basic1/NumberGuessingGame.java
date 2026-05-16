import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.List;

/**
 * Advanced Number Guessing Game
 * Demonstrates:
 * - Multiple difficulty levels
 * - Attempt tracking and limits
 * - Hint system
 * - Score calculation
 * - Game history
 * - Input validation
 * - Statistics tracking
 */
public class NumberGuessingGame {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static final List<GameResult> gameHistory = new ArrayList<>();
    
    private static int totalGamesPlayed = 0;
    private static int totalWins = 0;
    private static int bestScore = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        System.out.println("=== Advanced Number Guessing Game ===");
        System.out.println("=====================================");
        
        boolean playing = true;
        
        while (playing) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Play Game");
            System.out.println("2. View Statistics");
            System.out.println("3. View Game History");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            
            try {
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        playGame();
                        break;
                    case 2:
                        displayStatistics();
                        break;
                    case 3:
                        displayGameHistory();
                        break;
                    case 4:
                        playing = false;
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
    
    private static void playGame() {
        System.out.println("\n--- Select Difficulty ---");
        System.out.println("1. Easy (1-50, 15 attempts)");
        System.out.println("2. Medium (1-100, 10 attempts)");
        System.out.println("3. Hard (1-200, 7 attempts)");
        System.out.println("4. Expert (1-500, 5 attempts)");
        System.out.print("Choose difficulty: ");
        
        int difficulty = scanner.nextInt();
        
        int maxNumber, maxAttempts;
        String difficultyName;
        
        switch (difficulty) {
            case 1:
                maxNumber = 50;
                maxAttempts = 15;
                difficultyName = "Easy";
                break;
            case 2:
                maxNumber = 100;
                maxAttempts = 10;
                difficultyName = "Medium";
                break;
            case 3:
                maxNumber = 200;
                maxAttempts = 7;
                difficultyName = "Hard";
                break;
            case 4:
                maxNumber = 500;
                maxAttempts = 5;
                difficultyName = "Expert";
                break;
            default:
                maxNumber = 100;
                maxAttempts = 10;
                difficultyName = "Medium";
        }
        
        int targetNumber = random.nextInt(maxNumber) + 1;
        int attempts = 0;
        boolean won = false;
        List<Integer> guesses = new ArrayList<>();
        
        System.out.println("\n--- Game Started ---");
        System.out.println("Guess a number between 1 and " + maxNumber);
        System.out.println("You have " + maxAttempts + " attempts");
        System.out.println("Type 'hint' for a hint (costs 1 attempt)");
        
        while (attempts < maxAttempts && !won) {
            System.out.print("\nAttempt " + (attempts + 1) + "/" + maxAttempts + ": ");
            
            String input = scanner.next();
            
            if (input.equalsIgnoreCase("hint")) {
                attempts++;
                provideHint(targetNumber, maxNumber);
                continue;
            }
            
            try {
                int guess = Integer.parseInt(input);
                guesses.add(guess);
                attempts++;
                
                if (guess == targetNumber) {
                    won = true;
                    System.out.println("🎉 Congratulations! You guessed it in " + attempts + " attempts!");
                } else if (guess < targetNumber) {
                    System.out.println("Too low! ");
                    System.out.println("Previous guesses: " + guesses);
                } else {
                    System.out.println("Too high! ");
                    System.out.println("Previous guesses: " + guesses);
                }
                
                if (!won && attempts < maxAttempts) {
                    int remaining = maxAttempts - attempts;
                    System.out.println("Attempts remaining: " + remaining);
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number or 'hint'.");
            }
        }
        
        if (!won) {
            System.out.println("\nGame Over! The number was: " + targetNumber);
        }
        
        // Calculate score
        int score = calculateScore(attempts, maxAttempts, won);
        
        // Update statistics
        totalGamesPlayed++;
        if (won) {
            totalWins++;
            if (attempts < bestScore) {
                bestScore = attempts;
            }
        }
        
        // Save game result
        GameResult result = new GameResult(difficultyName, targetNumber, attempts, won, score);
        gameHistory.add(result);
        
        System.out.println("\nScore: " + score + "/100");
        System.out.println("Games won: " + totalWins + "/" + totalGamesPlayed);
    }
    
    private static void provideHint(int targetNumber, int maxNumber) {
        int hintType = random.nextInt(3);
        
        switch (hintType) {
            case 0:
                System.out.println("Hint: The number is " + (targetNumber % 2 == 0 ? "even" : "odd"));
                break;
            case 1:
                int range = maxNumber / 4;
                int lowerBound = (targetNumber / range) * range;
                int upperBound = lowerBound + range;
                System.out.println("Hint: The number is between " + lowerBound + " and " + upperBound);
                break;
            case 2:
                System.out.println("Hint: The number " + (targetNumber > maxNumber / 2 ? "is greater than" : "is less than or equal to") + " " + (maxNumber / 2));
                break;
        }
    }
    
    private static int calculateScore(int attempts, int maxAttempts, boolean won) {
        if (!won) return 0;
        
        double baseScore = 100.0;
        double penalty = ((double) attempts / maxAttempts) * 50;
        return (int) Math.max(baseScore - penalty, 10);
    }
    
    private static void displayStatistics() {
        System.out.println("\n--- Game Statistics ---");
        System.out.println("Total Games Played: " + totalGamesPlayed);
        System.out.println("Total Wins: " + totalWins);
        System.out.println("Win Rate: " + (totalGamesPlayed > 0 ? 
            String.format("%.2f%%", (double) totalWins / totalGamesPlayed * 100) : "0%"));
        System.out.println("Best Score (fewest attempts): " + 
            (bestScore != Integer.MAX_VALUE ? bestScore : "N/A"));
    }
    
    private static void displayGameHistory() {
        System.out.println("\n--- Game History ---");
        
        if (gameHistory.isEmpty()) {
            System.out.println("No games played yet.");
            return;
        }
        
        for (int i = 0; i < gameHistory.size(); i++) {
            GameResult result = gameHistory.get(i);
            System.out.println((i + 1) + ". " + result.difficulty + " - " + 
                (result.won ? "Won" : "Lost") + " - Attempts: " + 
                result.attempts + " - Score: " + result.score);
        }
    }
    
    private static class GameResult {
        String difficulty;
        int targetNumber;
        int attempts;
        boolean won;
        int score;
        
        GameResult(String difficulty, int targetNumber, int attempts, boolean won, int score) {
            this.difficulty = difficulty;
            this.targetNumber = targetNumber;
            this.attempts = attempts;
            this.won = won;
            this.score = score;
        }
    }
}