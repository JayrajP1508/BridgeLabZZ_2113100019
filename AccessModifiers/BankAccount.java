package Assignment9.Level1;

public class BankAccount {

    public int accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Invalid or insufficient funds");
        }
    }

    public double getBalance() {
        return balance;
    }

    class SavingsAccount {
        public void displayDetails() {
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Holder: " + accountHolder);
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(123456, "John Doe", 5000);
        BankAccount.SavingsAccount savings = account.new SavingsAccount();
        savings.displayDetails();

        account.deposit(1500);
        System.out.println("Updated Balance: " + account.getBalance());
    }
}

