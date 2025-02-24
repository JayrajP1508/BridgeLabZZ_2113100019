package Bridgelabz_2113100011.Assignment24.Reflections;


import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class DynamicMethodInvocation {

    public static void main(String[] args) throws Exception {

        MathOperations mathOperations = new MathOperations();
        Class<?> cls = mathOperations.getClass();
        Scanner sc = new Scanner(System.in);

        System.out.println("Which operation you want to perform eg(+,-,*)");
        String c = sc.nextLine();

        int result;
        switch (c) {

            case "+":
                Method methodAdd = cls.getDeclaredMethod("add", int.class, int.class);
                result = (int) methodAdd.invoke(mathOperations, 5, 4);
                System.out.println("Result of addition of 5 and 4 is " + result);
                break;

            case "-":
                Method methodSubract = cls.getDeclaredMethod("subtract", int.class, int.class);
                result = (int) methodSubract.invoke(mathOperations, 5, 4);
                System.out.println("Result of subtraction of 5 and 4 is " + result);
                break;

            case "*":
                Method methodMultiply = cls.getDeclaredMethod("multiply", int.class, int.class);
                result = (int) methodMultiply.invoke(mathOperations, 5, 4);
                System.out.println("Result of multiplication of 5 and 4 is " + result);
                break;

            default:
                System.out.println("Invalid Operation!!");

        }

        sc.close();

    }
}
