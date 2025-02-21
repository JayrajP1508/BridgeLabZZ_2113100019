package Bridgelabz_2113100011.Assignment22;

import java.util.Scanner;

public class ValidateAge {

    public static void validateAge(int age) {
        if (age < 18) {
            throw new ArithmeticException("Exception: Age must be 18 or above");
        }
        System.out.println("Access Granted");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter the age:");
            int age = sc.nextInt();
            validateAge(age);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
        } finally {
            sc.close(); // Closing Scanner
        }
    }
}
