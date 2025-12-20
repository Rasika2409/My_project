import java.util.Scanner;

class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            balance = initialBalance;
        } else {
            balance = 0;
        }
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}


public class ATMSystem {

    private BankAccount account;
    private Scanner scanner;

    public ATMSystem(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;

        do {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = getValidInt();

            switch (choice) {
                case 1 -> withdraw();
                case 2 -> deposit();
                case 3 -> checkBalance();
                case 4 -> System.out.println("Thank you for using the ATM.");
                default -> System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);
    }

    
    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = getValidDouble();

        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
            System.out.println("Remaining Balance: " + account.getBalance());
        } else {
            System.out.println("Withdrawal failed. Insufficient balance or invalid amount.");
        }
    }

    
    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = getValidDouble();

        if (account.deposit(amount)) {
            System.out.println("Deposit successful.");
            System.out.println("Updated Balance: " + account.getBalance());
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    
    private void checkBalance() {
        System.out.println("Current Balance: " + account.getBalance());
    }

    
    private int getValidInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private double getValidDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Enter a valid amount: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

   
    public static void main(String[] args) {

        BankAccount account = new BankAccount(5000.0); 
        ATMSystem atm = new ATMSystem(account);
        atm.start();
    }
}
