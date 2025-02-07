public class Main {
    public static void main(String[] args) {
        System.out.println("--- Savings Account ---");
        SavingsAccount savings = new SavingsAccount("S15989", 50000, 4.5);
        savings.displayDetails();
        savings.displayAccountType();
        savings.applyInterest();

        System.out.println("\n--- Checking Account ---");
        CheckingAccount checking = new CheckingAccount("C66865", 88500, 1000);
        checking.displayDetails();
        checking.displayAccountType();
        checking.withdraw(1200); 
        checking.withdraw(800); 
        System.out.println("\n--- Fixed Deposit Account ---");
        FixedDepositAccount fixedDeposit = new FixedDepositAccount("FD5H671", 100000, 2, 5);
        fixedDeposit.displayDetails();
        fixedDeposit.displayAccountType();
        fixedDeposit.matureBalance();
    }
}

class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        System.out.println("New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("Remaining Balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

    public void displayAccountType() {
        System.out.println("Generic Bank Account");
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest Applied: " + interest);
        System.out.println("New Balance: " + balance);
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Savings Account");
    }
}

class CheckingAccount extends BankAccount {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > withdrawalLimit) {
            System.out.println("Withdrawal failed! Exceeds limit of " + withdrawalLimit);
        } else {
            super.withdraw(amount);
        }
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Checking Account");
    }
}

class FixedDepositAccount extends BankAccount {
    private int termInMonths;
    private double interestRate;

    public FixedDepositAccount(String accountNumber, double balance, int termInMonths, double interestRate) {
        super(accountNumber, balance);
        this.termInMonths = termInMonths;
        this.interestRate = interestRate;
    }

    public void matureBalance() {
        double interest = balance * (interestRate / 100) * (termInMonths / 12.0);
        balance += interest;
        System.out.println("Maturity Interest: " + interest);
        System.out.println("Total Balance at Maturity: " + balance);
    }

    @Override
    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
    }
}

