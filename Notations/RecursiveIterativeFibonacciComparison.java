package Bridgelabz_2113100011.Assignment18;

public class RecursiveIterativeFibonacciComparison {

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    //    Iterative:
    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {

        int num = 10;

        long starTimeIter = System.nanoTime();
        int result1 = fibonacciIterative(num);
        long endtimeIter = System.nanoTime();

        long starTimeRec = System.nanoTime();
        int result2 = fibonacciRecursive(num);
        long endtimeRec = System.nanoTime();

        System.out.println("Result from iteration: "+result1);
        System.out.println("Result from recursion: "+result2);

        System.out.println("Elapse time for Iteration: " + (endtimeIter - starTimeIter));
        System.out.println("Elapse time for Recursion: " + (endtimeRec - starTimeRec));

    }

}
