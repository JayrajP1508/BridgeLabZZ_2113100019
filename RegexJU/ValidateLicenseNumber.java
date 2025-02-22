package Bridgelabz_2113100011.Assignment23;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateLicenseNumber {

    public static void main(String[] args) {
        String[] input = {"AB1234", "A12345"};

        String regex = "^[A-Z]{2}[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);

        for (String s : input) {
            Matcher matcher = pattern.matcher(s);

            if (matcher.matches()) {
                System.out.println("Valid License Number: " + s);
            } else {
                System.out.println("Invalid License Number: " + s);
            }

        }
    }
}
