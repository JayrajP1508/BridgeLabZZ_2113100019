package Bridgelabz_2113100011.Assignment24.Reflections;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethod {
    public static void main(String[] args) throws Exception {
        Calculator cal = new Calculator();
        Class<?> cls = cal.getClass();
        Method method = cls.getDeclaredMethod("multiply", int.class, int.class);
        method.setAccessible(true);

        int result = (int) method.invoke(cal, 5, 3);
        System.out.println("Result: " + result);
    }

}
