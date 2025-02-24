package Bridgelabz_2113100011.Assignment24.Reflections;


import java.lang.reflect.Method;

class Calculate {
    private int multiply(int a, int b) {
        return a * b;
    }
}


public class MethodExecutionTiming {
    public static void main(String[] args) throws Exception {
        Calculate cal = new Calculate();
        Class<?> cls = cal.getClass();
        Method method = cls.getDeclaredMethod("multiply", int.class, int.class);
        method.setAccessible(true);

        long startTime = System.nanoTime();
        int result = (int) method.invoke(cal, 5, 3);
        long endTime = System.nanoTime();
        System.out.println("Result: " + result);
        System.out.println("Elapsed Time for method call: " + (endTime - startTime) / 1000000 + "ms");
    }
}
