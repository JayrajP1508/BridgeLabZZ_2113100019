package Bridgelabz_2113100011.Assignment23;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUserName {

    public static void main(String[] args) {
        String string = "user_123,123user,123user";
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";

        Pattern pattern = Pattern.compile(regex);
        String[] userNames = string.split(",");

        for (String userName : userNames) {
            Matcher matcher = pattern.matcher(userName);

            if (matcher.matches()) {
                System.out.println("Valid UserName: " + userName);
            } else {
                System.out.println("Invalid UserName: " + userName);
            }

        }
    }
}
