import java.util.ArrayList;
import java.util.List;

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public abstract double calculateInterest();
}

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double initialBalance, double interestRate) {
        super(accountNumber, holderName, initialBalance);
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    public void applyForLoan(double amount) {
        System.out.println(getHolderName() + " applied for a loan of " + amount);
    }

    public boolean calculateLoanEligibility() {
        return getBalance() >= 1000;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double initialBalance, double overdraftLimit) {
        super(accountNumber, holderName, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    public double calculateInterest() {
        return 0; // No interest for current accounts
    }

    public void applyForLoan(double amount) {
        System.out.println(getHolderName() + " applied for a loan of " + amount);
    }

    public boolean calculateLoanEligibility() {
        return getBalance() + overdraftLimit >= 500; // Minimum balance requirement
    }
}

class BankingSystem {
    public static void processAccounts(List<BankAccount> accounts) {
        for (BankAccount account : accounts) {
            double interest = account.calculateInterest();
            System.out.println("Account Holder: " + account.getHolderName());
            System.out.println("Interest Earned: " + interest);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SA001", "Alice", 1500, 0.04));
        accounts.add(new CurrentAccount("CA001", "Bob", 800, 200));

        processAccounts(accounts);
    }
}
