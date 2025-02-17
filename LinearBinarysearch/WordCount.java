package Bridgelabz_2113100011.Assignment17;

import java.io.*;

public class WordCount {
    public static int countWordOccurrences(String filename, String targetWord) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void main(String[] args) {
        String filename = "test.txt";
        String word = "hello";
        System.out.println("Occurrences of '" + word + "': " + countWordOccurrences(filename, word));
    }
}

