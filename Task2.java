import java.util.Scanner;

// BankAccount class representing the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            System.out.println("Invalid amount for deposit.");
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient funds.");
            return false;
        }
    }

    public double checkBalance() {
        return balance;
    }
}

// ATM class representing the ATM machine
class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    withdraw();
                    break;
                case "2":
                    deposit();
                    break;
                case "3":
                    checkBalance();
                    break;
                case "4":
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        if (bankAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Withdrawal failed.");
        }
    }

    public void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        if (bankAccount.deposit(amount)) {
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Deposit failed.");
        }
    }

    public void checkBalance() {
        double balance = bankAccount.checkBalance();
        System.out.println("Your balance is: " + balance);
    }
}

 class ATM_INTERFACE {
    public static void main(String[] args) {
        // Create a bank account
        BankAccount account = new BankAccount(1000);

        // Connect the ATM with the bank account
        ATM atm = new ATM(account);

        // Run the ATM
        atm.run();
    }
}
