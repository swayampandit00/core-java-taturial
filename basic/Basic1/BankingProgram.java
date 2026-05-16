import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Advanced Banking Program
 * Demonstrates:
 * - Object-oriented design with Account class
 * - Encapsulation with private fields
 * - Transaction history tracking
 * - Input validation
 * - Multiple account types
 * - Interest calculation
 * - Account management operations
 */
public class BankingProgram {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Account> accounts = new ArrayList<>();
    private static Account currentAccount = null;
    
    public static void main(String[] args) {
        System.out.println("=== Advanced Banking System ===");
        System.out.println("==============================");
        
        boolean running = true;
        
        while (running) {
            if (currentAccount == null) {
                displayMainMenu();
            } else {
                displayAccountMenu();
            }
            
            try {
                int choice = scanner.nextInt();
                
                if (currentAccount == null) {
                    running = handleMainMenu(choice);
                } else {
                    handleAccountMenu(choice);
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
        System.out.println("1. Create New Account");
        System.out.println("2. Login to Existing Account");
        System.out.println("3. View All Accounts");
        System.out.println("4. Exit");
        System.out.print("Choose option: ");
    }
    
    private static void displayAccountMenu() {
        System.out.println("\n--- Account Menu ---");
        System.out.println("Account: " + currentAccount.getAccountNumber());
        System.out.println("Balance: $" + currentAccount.getBalance());
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.println("4. View Transaction History");
        System.out.println("5. Calculate Interest");
        System.out.println("6. Account Details");
        System.out.println("7. Logout");
        System.out.print("Choose option: ");
    }
    
    private static boolean handleMainMenu(int choice) {
        switch (choice) {
            case 1:
                createAccount();
                break;
            case 2:
                loginToAccount();
                break;
            case 3:
                viewAllAccounts();
                break;
            case 4:
                System.out.println("Thank you for using our banking system!");
                return false;
            default:
                System.out.println("Invalid choice!");
        }
        return true;
    }
    
    private static void handleAccountMenu(int choice) {
        switch (choice) {
            case 1:
                deposit();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                transfer();
                break;
            case 4:
                viewTransactionHistory();
                break;
            case 5:
                calculateInterest();
                break;
            case 6:
                displayAccountDetails();
                break;
            case 7:
                logout();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    
    private static void createAccount() {
        scanner.nextLine(); // Clear buffer
        
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();
        
        if (initialDeposit < 0) {
            System.out.println("Initial deposit cannot be negative!");
            return;
        }
        
        System.out.println("Select Account Type:");
        System.out.println("1. Savings Account (2.5% annual interest)");
        System.out.println("2. Checking Account (1.0% annual interest)");
        System.out.println("3. Business Account (3.0% annual interest)");
        System.out.print("Choose type: ");
        
        int type = scanner.nextInt();
        Account account;
        
        switch (type) {
            case 1:
                account = new SavingsAccount(name, initialDeposit);
                break;
            case 2:
                account = new CheckingAccount(name, initialDeposit);
                break;
            case 3:
                account = new BusinessAccount(name, initialDeposit);
                break;
            default:
                account = new SavingsAccount(name, initialDeposit);
        }
        
        accounts.add(account);
        System.out.println("\nAccount created successfully!");
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + name);
        System.out.println("Initial Balance: $" + initialDeposit);
    }
    
    private static void loginToAccount() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts exist. Please create an account first.");
            return;
        }
        
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                currentAccount = account;
                System.out.println("Login successful! Welcome, " + account.getAccountHolder());
                return;
            }
        }
        
        System.out.println("Account not found!");
    }
    
    private static void viewAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts exist.");
            return;
        }
        
        System.out.println("\n--- All Accounts ---");
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            System.out.println((i + 1) + ". " + account.getAccountNumber() + 
                " - " + account.getAccountHolder() + 
                " - Balance: $" + account.getBalance());
        }
    }
    
    private static void deposit() {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive!");
            return;
        }
        
        currentAccount.deposit(amount);
        System.out.println("Deposit successful! New balance: $" + currentAccount.getBalance());
    }
    
    private static void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive!");
            return;
        }
        
        if (currentAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful! New balance: $" + currentAccount.getBalance());
        } else {
            System.out.println("Insufficient funds!");
        }
    }
    
    private static void transfer() {
        if (accounts.size() < 2) {
            System.out.println("Need at least 2 accounts to transfer!");
            return;
        }
        
        System.out.print("Enter recipient account number: ");
        String recipientNumber = scanner.next();
        
        Account recipient = null;
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(recipientNumber) && 
                !account.getAccountNumber().equals(currentAccount.getAccountNumber())) {
                recipient = account;
                break;
            }
        }
        
        if (recipient == null) {
            System.out.println("Recipient account not found!");
            return;
        }
        
        System.out.print("Enter transfer amount: ");
        double amount = scanner.nextDouble();
        
        if (amount <= 0) {
            System.out.println("Transfer amount must be positive!");
            return;
        }
        
        if (currentAccount.transfer(recipient, amount)) {
            System.out.println("Transfer successful!");
            System.out.println("Your balance: $" + currentAccount.getBalance());
            System.out.println("Recipient balance: $" + recipient.getBalance());
        } else {
            System.out.println("Transfer failed! Insufficient funds.");
        }
    }
    
    private static void viewTransactionHistory() {
        currentAccount.displayTransactionHistory();
    }
    
    private static void calculateInterest() {
        if (currentAccount instanceof InterestBearing) {
            double interest = ((InterestBearing) currentAccount).calculateInterest();
            System.out.println("Interest calculated: $" + interest);
            System.out.println("Balance with interest: $" + (currentAccount.getBalance() + interest));
        } else {
            System.out.println("This account type does not earn interest.");
        }
    }
    
    private static void displayAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + currentAccount.getAccountNumber());
        System.out.println("Account Holder: " + currentAccount.getAccountHolder());
        System.out.println("Account Type: " + currentAccount.getAccountType());
        System.out.println("Balance: $" + currentAccount.getBalance());
        
        if (currentAccount instanceof InterestBearing) {
            double rate = ((InterestBearing) currentAccount).getInterestRate();
            System.out.println("Interest Rate: " + (rate * 100) + "%");
        }
    }
    
    private static void logout() {
        currentAccount = null;
        System.out.println("Logged out successfully.");
    }
}

/**
 * Base Account class with encapsulation
 */
abstract class Account {
    private final String accountNumber;
    private final String accountHolder;
    private double balance;
    private final List<Transaction> transactionHistory;
    private final LocalDateTime creationDate;
    
    public Account(String accountHolder, double initialBalance) {
        this.accountNumber = generateAccountNumber();
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        this.creationDate = LocalDateTime.now();
        
        if (initialBalance > 0) {
            addTransaction("Initial Deposit", initialBalance);
        }
    }
    
    private String generateAccountNumber() {
        return "ACC" + System.currentTimeMillis() + 
            String.format("%04d", (int)(Math.random() * 10000));
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public abstract String getAccountType();
    
    public void deposit(double amount) {
        balance += amount;
        addTransaction("Deposit", amount);
    }
    
    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        addTransaction("Withdrawal", -amount);
        return true;
    }
    
    public boolean transfer(Account recipient, double amount) {
        if (withdraw(amount)) {
            recipient.deposit(amount);
            addTransaction("Transfer to " + recipient.getAccountNumber(), -amount);
            recipient.addTransaction("Transfer from " + accountNumber, amount);
            return true;
        }
        return false;
    }
    
    protected void addTransaction(String description, double amount) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);
        transactionHistory.add(new Transaction(timestamp, description, amount, balance));
    }
    
    public void displayTransactionHistory() {
        System.out.println("\n--- Transaction History ---");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }
        
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
    
    @Override
    public String toString() {
        return accountNumber + " - " + accountHolder + " - $" + balance;
    }
}

/**
 * Interface for interest-bearing accounts
 */
interface InterestBearing {
    double calculateInterest();
    double getInterestRate();
}

/**
 * Savings Account with higher interest rate
 */
class SavingsAccount extends Account implements InterestBearing {
    private static final double INTEREST_RATE = 0.025; // 2.5%
    
    public SavingsAccount(String accountHolder, double initialBalance) {
        super(accountHolder, initialBalance);
    }
    
    @Override
    public String getAccountType() {
        return "Savings";
    }
    
    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
    
    @Override
    public double getInterestRate() {
        return INTEREST_RATE;
    }
}

/**
 * Checking Account with lower interest rate
 */
class CheckingAccount extends Account implements InterestBearing {
    private static final double INTEREST_RATE = 0.01; // 1%
    
    public CheckingAccount(String accountHolder, double initialBalance) {
        super(accountHolder, initialBalance);
    }
    
    @Override
    public String getAccountType() {
        return "Checking";
    }
    
    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
    
    @Override
    public double getInterestRate() {
        return INTEREST_RATE;
    }
}

/**
 * Business Account with highest interest rate
 */
class BusinessAccount extends Account implements InterestBearing {
    private static final double INTEREST_RATE = 0.03; // 3%
    
    public BusinessAccount(String accountHolder, double initialBalance) {
        super(accountHolder, initialBalance);
    }
    
    @Override
    public String getAccountType() {
        return "Business";
    }
    
    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
    
    @Override
    public double getInterestRate() {
        return INTEREST_RATE;
    }
}

/**
 * Transaction record class
 */
class Transaction {
    private final String timestamp;
    private final String description;
    private final double amount;
    private final double balanceAfter;
    
    public Transaction(String timestamp, String description, double amount, double balanceAfter) {
        this.timestamp = timestamp;
        this.description = description;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
    }
    
    @Override
    public String toString() {
        return String.format("[%s] %s: $%s (Balance: $%s)", 
            timestamp, description, 
            String.format("%.2f", amount), 
            String.format("%.2f", balanceAfter));
    }
}