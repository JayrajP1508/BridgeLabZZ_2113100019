package Bridgelabz_2113100011.Assignment22;

import java.util.Scanner;

public class NestedTryCatch {

    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 10 integer values: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        try {
            System.out.println("Enter an index: ");
            int index = sc.nextInt();

            try {
                int element = arr[index]; // May throw ArrayIndexOutOfBoundsException

                System.out.println("Enter the value of divisor: ");
                int divisor = sc.nextInt();

                try {
                    System.out.println("Division Result: " + (element / divisor)); // May throw ArithmeticException
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }

        } finally {
            sc.close(); // Closing scanner to prevent resource leaks
            System.out.println("Operation completed.");
        }
    }
}
