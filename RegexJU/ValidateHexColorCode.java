package Bridgelabz_2113100011.Assignment23;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateHexColorCode {

    public static void main(String[] args) {
        String[] input={"#FFA500","#ff4500","#123"};
        String regex="^#[0-9A-Fa-f]{6}$";

        Pattern pattern = Pattern.compile(regex);

        for (String s : input) {
            Matcher matcher = pattern.matcher(s);

            if (matcher.matches()) {
                System.out.println("Valid Hex Color: " + s);
            } else {
                System.out.println("Invalid Hex Color: " + s);
            }

        }

    }
}
