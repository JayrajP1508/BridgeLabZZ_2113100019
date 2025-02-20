package AssignmentCollectionFramework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String filePath = "\"C:\\Users\\sneha\\Desktop\\text.txt.txt\"";
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null)
            {
                line = line.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");

                String[] words = line.split("\\s+");

                // Count words in the HashMap
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        System.out.println(wordCountMap);
    }
}

