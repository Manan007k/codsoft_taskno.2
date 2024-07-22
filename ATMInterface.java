import java.util.Scanner;

// Class to represent the User's Bank Account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance > 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }
}

// Class to represent the ATM Machine
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("ATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    if (account.deposit(depositAmount)) {
                        System.out.println("Deposit successful. New Balance: " + account.getBalance());
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawalAmount)) {
                        System.out.println("Withdrawal successful. New Balance: " + account.getBalance());
                    } else {
                        System.out.println("Invalid withdrawal amount or insufficient balance.");
                    }
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting ATM. Thank you!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}

// Main class to run the ATM interface
public class ATMInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initial balance of 1000
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}