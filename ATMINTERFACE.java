import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Welcome to OurBank ATM");
        
        while (true) {
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    displayBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using OurBank ATM");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void displayBalance() {
        System.out.println("Balance: $" + bankAccount.getBalance());
    }

    private void deposit() {
        System.out.print("Enter deposit amount: $");
        double depositAmount = scanner.nextDouble();
        bankAccount.deposit(depositAmount);
        System.out.println("Deposit successful");
    }

    private void withdraw() {
        System.out.print("Enter withdrawal amount: $");
        double withdrawalAmount = scanner.nextDouble();
        if (bankAccount.withdraw(withdrawalAmount)) {
            System.out.println("Withdrawal successful");
        } else {
            System.out.println("Insufficient funds");
        }
    }
}

public class ATMINTERFACE {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);
        ATM atm = new ATM(account);
        atm.run();
    }
}
