package Bridgelabz_2113100011.Assignment17;

import java.util.HashSet;

public class RemoveDuplicates {
    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (!seen.contains(c)) {
                sb.append(c);
                seen.add(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "programming";
        System.out.println("Without duplicates: " + removeDuplicates(input));
    }
}

