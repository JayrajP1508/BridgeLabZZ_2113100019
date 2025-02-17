package Bridgelabz_2113100011.Assignment17;

public class ConcatenateStrings {
    public static String concatenate(String[] strings) {
        StringBuffer sb = new StringBuffer();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = {"Hello", " ", "World", "!"};
        System.out.println("Concatenated String: " + concatenate(words));
    }
}

