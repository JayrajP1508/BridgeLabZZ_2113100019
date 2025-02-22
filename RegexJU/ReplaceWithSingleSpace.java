package Bridgelabz_2113100011.Assignment23;

import java.util.regex.Pattern;

public class ReplaceWithSingleSpace {

    public static void main(String[] args) {
        String input = "This       is an example with        multiple      spaces.";

        // Replacing multiple spaces with a single space
        String result = input.replaceAll("\\s+", " ");

        System.out.println("Before: " + input);
        System.out.println("After: " + result);
    }
}
