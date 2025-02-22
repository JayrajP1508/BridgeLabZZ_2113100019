package Bridgelabz_2113100011.Assignment23;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractLinks {
    public static void main(String[] args) {
        String sample = "Visit https://www.google.com and http://example.org for more info.";
        String regex = "\\bhttps?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sample);

        while (matcher.find()) {
            System.out.println("Extracted Link: " + matcher.group());
        }
    }
}
