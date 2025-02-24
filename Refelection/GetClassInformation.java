package Bridgelabz_2113100011.Assignment24.Reflections;

import java.lang.reflect.*;
import java.util.Scanner;

public class GetClassInformation {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter class name (e.g., java.util.ArrayList): ");
        String className = scanner.next();  // User inputs class name
        scanner.close();

        // Load the class dynamically
        Class<?> cls = Class.forName(className);

        // Display class name
        System.out.println("\nClass: " + cls.getName());

        // Display fields
        System.out.println("\nFields:");
        for (Field field : cls.getDeclaredFields()) {
            System.out.println(" - " + field);
        }

        // Display methods
        System.out.println("\nMethods:");
        for (Method method : cls.getDeclaredMethods()) {
            System.out.println(" - " + method);
        }

        // Display constructors
        System.out.println("\nConstructors:");
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            System.out.println(" - " + constructor);
        }
    }
}
