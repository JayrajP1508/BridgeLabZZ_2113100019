package Bridgelabz_2113100011.Assignment22;

import java.util.Scanner;

public class ArrayOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = null; // Initially null to simulate NullPointerException

        try {
            System.out.println("Do you want to initialize the array? (yes/no)");
            String response = sc.next().toLowerCase();

            if (response.equals("yes")) {
                arr = new int[10];
                System.out.println("Enter 10 integer values: ");
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = sc.nextInt();
                }
            }

            System.out.println("Enter an index:");
            int index = sc.nextInt();

            System.out.println("Value at index " + index + ": " + arr[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } finally {
            sc.close(); // Closing the scanner
        }
    }
}
