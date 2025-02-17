package Bridgelabz_2113100011.Assignment17;

public class SearchWord {
    public static String findSentence(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) return sentence;
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {"Hello world", "Java programming", "Learn coding"};
        String word = "Java";
        System.out.println("Sentence: " + findSentence(sentences, word));
    }
}
