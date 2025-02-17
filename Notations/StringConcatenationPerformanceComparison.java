package Bridgelabz_2113100011.Assignment18;

import java.util.Random;

public class StringConcatenationPerformanceComparison {


    public static String[] generateRandomStrings(int size, int stringLength) {
        String[] randomStrings = new String[size];
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < stringLength; j++) {
                sb.append(characters.charAt(rand.nextInt(characters.length())));
            }
            randomStrings[i] = sb.toString();
        }
        return randomStrings;
    }

    public static void main(String[] args) {
        String s1 = "";
        StringBuilder s2 = new StringBuilder();
        StringBuffer s3 = new StringBuffer();

        int numStrings = 1000; // Number of strings to concatenate
        String[] strings = generateRandomStrings(numStrings, 10);

        long startTimeString = System.nanoTime();
        for (String string : strings) {
            s1 = s1 + string;
        }
        long endTimeString = System.nanoTime();

        System.out.println("Elapse time for String: " + (endTimeString - startTimeString));

        long startTimeStringBuilder = System.nanoTime();
        for (String string : strings) {
            s2.append(string);
        }
        long endTimeStringBuilder = System.nanoTime();

        System.out.println("Elapse time for StringBuilder: " + (endTimeStringBuilder - startTimeStringBuilder));

        long startTimeStringBuffer = System.nanoTime();
        for (String string : strings) {
            s3.append(string);
        }
        long endTimeStringBuffer = System.nanoTime();

        System.out.println("Elapse time for StringBuffer: " + (endTimeStringBuffer - startTimeStringBuffer));

    }
}
