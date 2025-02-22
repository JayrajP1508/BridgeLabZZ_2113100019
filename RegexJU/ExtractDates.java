package Bridgelabz_2113100011.Assignment23;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractDates {
    public static void main(String[] args) {
        String sample = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        String regex = "\\b[0-9]{2}/[0-9]{2}/[0-9]{4}\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sample);

        while (matcher.find()) {
            System.out.println("Extracted Date: " + matcher.group());
        }
    }
}

