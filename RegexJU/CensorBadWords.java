package Bridgelabz_2113100011.Assignment23;

public class CensorBadWords {
    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";


        String[] badWords = {"damn", "stupid"};

        for (String word : badWords) {
            input = input.replaceAll("(?i)\\b" + word + "\\b", "****");
        }

        System.out.println("Censored Output: " + input);
    }
}
