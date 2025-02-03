class BankAccount {
    static String bankName = "XYZ Bank";
    static int totalAccounts = 0;
    final int accountNumber;
    String accountHolderName;
    double balance;
    
    BankAccount(String accountHolderName, int accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }
    
    static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }
    
    void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + this.accountHolderName);
            System.out.println("Account Number: " + this.accountNumber);
            System.out.println("Balance: " + this.balance);
        }
    }
    
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("John Doe", 1001, 5000.0);
        BankAccount acc2 = new BankAccount("Jane Smith", 1002, 7000.0);
        
        acc1.displayDetails();
        acc2.displayDetails();
        
        getTotalAccounts();
    }
}
