package Bridgelabz_2113100011.Assignment22;


import java.util.Scanner;

public class DivisionWithFinally {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter the first number: ");
            int num1 = sc.nextInt();

            System.out.print("Enter the second number: ");
            int num2 = sc.nextInt();

            int result = num1 / num2; // May throw ArithmeticException if num2 is 0
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        } finally {
            System.out.println("Operation completed."); // Always executes
            sc.close(); // Closing Scanner to prevent resource leaks
        }
    }
}

