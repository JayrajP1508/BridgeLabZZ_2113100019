package Bridgelabz_2113100011.Assignment23;

import java.util.regex.Pattern;
import java.util.regex.Matcher;



public class ExtractCapitalizedWords {

    public static void main(String[] args) {
        String sample = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        String regex = "[A-Z][a-z]+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sample);

        while (matcher.find()) {
            System.out.println("Capitalized Word: " + matcher.group());
        }
    }
}
