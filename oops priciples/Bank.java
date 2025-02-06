
package Assignment11;

import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Customer> customers;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }

    public void openAccount(Customer customer) {
        customers.add(customer);
        System.out.println("Account successfully opened for " + customer.getCustName());
    }

    public void viewDetails() {
        System.out.println("Bank Name: " + bankName);
        if (customers.isEmpty()) {
            System.out.println("No customers in this bank.");
        } else {
            for (Customer c : customers) {
                System.out.println("Customer Name: " + c.getCustName());
                System.out.println("Customer Id: " + c.getCustId());
                System.out.println("Bank Balance: " + c.getDeposit());
                System.out.println();
            }
        }
    }
}

class Customer {
    private String custName;
    private int custId;
    private double deposit;

    public Customer(String custName, int custId, double deposit) {
        this.custName = custName;
        this.custId = custId;
        this.deposit = deposit;
    }

    public String getCustName() {
        return custName;
    }

    public int getCustId() {
        return custId;
    }

    public double getDeposit() {
        return deposit;
    }

    public double viewBalance() {
        return deposit;
    }
}


 class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("ABC Bank");

        Customer customer1 = new Customer("John Doe", 101, 5000.0);
        Customer customer2 = new Customer("Jane Smith", 102, 3000.0);

        bank.openAccount(customer1);
        bank.openAccount(customer2);

        bank.viewDetails();
    }
}



