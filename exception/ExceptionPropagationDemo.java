package Bridgelabz_2113100011.Assignment22;


public class ExceptionPropagationDemo {

    // Method that throws an ArithmeticException
    public static void method1() {
        System.out.println("Inside method1");
        int result = 10 / 0; // Throws ArithmeticException
    }

    // Method that calls method1()
    public static void method2() {
        System.out.println("Inside method2");
        method1(); // Exception propagates to method2()
    }

    // Main method that calls method2() and handles the exception
    public static void main(String[] args) {
        try {
            System.out.println("Inside main");
            method2(); // Exception propagates to main()
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main: " + e.getMessage());
        }
    }
}

