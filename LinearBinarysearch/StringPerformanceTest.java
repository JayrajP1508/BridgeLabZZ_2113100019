package Bridgelabz_2113100011.Assignment17;

public class StringPerformanceTest {
    public static void main(String[] args) {
        int n = 1000000;
        String str = "hello";

        // Using StringBuffer
        long startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbf.append(str);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endTime - startTime) / 1e6 + " ms");

        // Using StringBuilder
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime - startTime) / 1e6 + " ms");
    }
}
