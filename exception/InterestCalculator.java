package Bridgelabz_2113100011.Assignment22;

import java.util.Scanner;

public class InterestCalculator {

    // Method that throws an exception if input values are invalid
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        return (amount * rate * years) / 100; // Simple Interest formula
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Principal Amount: ");
            double amount = sc.nextDouble();

            System.out.print("Enter Interest Rate (%): ");
            double rate = sc.nextDouble();

            System.out.print("Enter Time (years): ");
            int years = sc.nextInt();

            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated Interest: " + interest);

        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            sc.close();
            System.out.println("Operation completed.");
        }
    }
}

