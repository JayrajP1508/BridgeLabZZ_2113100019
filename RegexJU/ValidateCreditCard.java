package Bridgelabz_2113100011.Assignment23;

import java.util.regex.Pattern;

public class ValidateCreditCard {
    public static void main(String[] args) {
        String[] visaCards = {"4111111111111111", "4000123412341234"};
        String[] masterCards = {"5105105105105100", "2221000000000009"};

        String visaRegex = "^4[0-9]{15}$";
        String masterRegex = "^(5[1-5][0-9]{14}|2(2[2-9][0-9]{12}|2[3-9][0-9]{13}|[3-6][0-9]{14}|7[0-1][0-9]{13}|720[0-9]{12}))$";

        Pattern visaPattern = Pattern.compile(visaRegex);
        Pattern masterPattern = Pattern.compile(masterRegex);

        for (String card : visaCards) {
            System.out.println(card + " is " + (visaPattern.matcher(card).matches() ? "a valid Visa card" : "NOT a valid Visa card"));
        }

        for (String card : masterCards) {
            System.out.println(card + " is " + (masterPattern.matcher(card).matches() ? "a valid MasterCard" : "NOT a valid MasterCard"));
        }
    }
}

