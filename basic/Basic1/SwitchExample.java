/**
 * Advanced Switch Statement Examples
 * Demonstrates:
 * - Traditional switch with break
 * - Switch expressions (Java 14+)
 * - Switch with strings
 * - Switch with enums
 * - Fall-through cases
 * - Multiple case labels
 * - Yield in switch expressions
 */
public class SwitchExample {
    public static void main(String[] args) {
        System.out.println("=== Advanced Switch Examples ===");
        
        // 1. Traditional switch with int
        System.out.println("\n--- Traditional Switch (Days) ---");
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day");
        }
        
        // 2. Switch with multiple case labels
        System.out.println("\n--- Multiple Case Labels ---");
        int month = 5;
        String season;
        switch (month) {
            case 12:
            case 1:
            case 2:
                season = "Winter";
                break;
            case 3:
            case 4:
            case 5:
                season = "Spring";
                break;
            case 6:
            case 7:
            case 8:
                season = "Summer";
                break;
            case 9:
            case 10:
            case 11:
                season = "Fall";
                break;
            default:
                season = "Invalid";
        }
        System.out.println("Month " + month + " is in " + season);
        
        // 3. Switch with strings
        System.out.println("\n--- Switch with Strings ---");
        String fruit = "apple";
        switch (fruit.toLowerCase()) {
            case "apple":
                System.out.println("Apple is red or green.");
                break;
            case "banana":
                System.out.println("Banana is yellow.");
                break;
            case "orange":
                System.out.println("Orange is orange.");
                break;
            default:
                System.out.println("Unknown fruit.");
        }
        
        // 4. Switch with enum
        System.out.println("\n--- Switch with Enum ---");
        Day today = Day.WEDNESDAY;
        switch (today) {
            case MONDAY:
                System.out.println("Start of the work week!");
                break;
            case FRIDAY:
                System.out.println("Almost weekend!");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekend!");
                break;
            default:
                System.out.println("Midweek day.");
        }
        
        // 5. Switch expression (Java 14+)
        System.out.println("\n--- Switch Expression ---");
        int score = 85;
        String grade = switch (score / 10) {
            case 10, 9 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            case 6 -> "D";
            default -> "F";
        };
        System.out.println("Score: " + score + ", Grade: " + grade);
        
        // 6. Switch expression with yield
        System.out.println("\n--- Switch Expression with Yield ---");
        int num = 4;
        String result = switch (num) {
            case 1 -> {
                yield "One";
            }
            case 2 -> {
                yield "Two";
            }
            case 3 -> {
                yield "Three";
            }
            default -> {
                yield "Other";
            }
        };
        System.out.println("Number " + num + " is " + result);
        
        // 7. Fall-through example
        System.out.println("\n--- Fall-Through Example ---");
        int level = 2;
        switch (level) {
            case 1:
                System.out.println("Level 1: Basic");
            case 2:
                System.out.println("Level 2: Intermediate");
            case 3:
                System.out.println("Level 3: Advanced");
                break;
            default:
                System.out.println("Unknown level");
        }
        
        // 8. Switch for vowel check
        System.out.println("\n--- Vowel Check ---");
        char ch = 'e';
        switch (ch) {
            case 'a', 'e', 'i', 'o', 'u':
                System.out.println(ch + " is a vowel");
                break;
            default:
                System.out.println(ch + " is a consonant");
        }
        
        // 9. Switch for calculator
        System.out.println("\n--- Calculator Switch ---");
        double a = 10, b = 5;
        char operator = '*';
        double calcResult;
        
        switch (operator) {
            case '+':
                calcResult = a + b;
                break;
            case '-':
                calcResult = a - b;
                break;
            case '*':
                calcResult = a * b;
                break;
            case '/':
                calcResult = b != 0 ? a / b : Double.NaN;
                break;
            default:
                calcResult = Double.NaN;
        }
        System.out.println(a + " " + operator + " " + b + " = " + calcResult);
    }
}

// Enum for switch example
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}