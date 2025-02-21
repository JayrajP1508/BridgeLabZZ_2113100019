package Bridgelabz_2113100011.Assignment22;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionOfTwoNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter first No.: ");
            int num1 = sc.nextInt();
            System.out.println("Enter second no.: ");
            int num2 = sc.nextInt();
            int div = num1 / num2;
            System.out.println("Division of two numbers " + num1 + " and " + num2 + " is " + div);
        } catch (ArithmeticException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Enter number values only!! ");
        }

    }
}
