package Bridgelabz_2113100011.Assignment23;

import java.util.regex.*;
import java.util.HashSet;

public class FindRepeatingWords {
    public static void main(String[] args) {
        String input = "This is is a repeated repeated word test.";

        String regex = "\\b(\\w+)\\s+\\1\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        HashSet<String> repeatedWords = new HashSet<>();

        while (matcher.find()) {
            repeatedWords.add(matcher.group(1));  // Capture the repeated word
        }

        System.out.println("Repeating words: " + repeatedWords);
    }
}

