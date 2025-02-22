package Bridgelabz_2113100011.Assignment23;

import java.util.regex.*;
import java.util.*;

public class ExtractCurrencyValues {
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";

        // Regex pattern to extract currency values
        String regex = "\\$?\\b\\d+\\.\\d{2}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> currencyValues = new ArrayList<>();

        while (matcher.find()) {
            currencyValues.add(matcher.group());
        }

        System.out.println("Extracted Currency Values: " + String.join(", ", currencyValues));
    }
}
