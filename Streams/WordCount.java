//package AssignmentJavaStreams;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.*;
//
//public class WordCount {
//    public static void main(String[] args) {
//        String filePath =  "C:Users\sneha\desktop\text.txt" ;
//        Map<String, Integer> wordCountMap = new HashMap<>();
//
//        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] words = line.split("\\W+");
//                for (String word : words) {
//                    word = word.toLowerCase();
//                    if (!word.isEmpty()) {
//                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCountMap.entrySet());
//        sortedEntries.sort((a, b) -> b.getValue().compareTo(a.getValue()));
//
//        System.out.println("Total unique words: " + wordCountMap.size());
//        System.out.println("Top 5 most frequently occurring words:");
//        for (int i = 0; i < Math.min(5, sortedEntries.size()); i++) {
//            System.out.println(sortedEntries.get(i).getKey() + ": " + sortedEntries.get(i).getValue());
//        }
//    }
//}
