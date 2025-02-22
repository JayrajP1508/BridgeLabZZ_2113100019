package Bridgelabz_2113100011.Assignment23.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringUtils {
    public String reverse(String str) {
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();
    }

    public boolean isPalindrome(String str) {
        if (str == null) return false;
        String reversed = reverse(str);
        return str.equals(reversed);
    }

    public String toUpperCase(String str) {
        if (str == null) return null;
        return str.toUpperCase();
    }
}
 class StringTest{

    StringUtils stringUtils=new StringUtils();

    @Test
    void testReverse() {
        assertEquals("cba", stringUtils.reverse("abc"));
        assertEquals("racecar", stringUtils.reverse("racecar"));
        assertEquals("", stringUtils.reverse(""));       assertNull(stringUtils.reverse(null));
    }

     @Test
     void testIsPalindrome() {
         assertTrue(stringUtils.isPalindrome("madam"));
         assertTrue(stringUtils.isPalindrome("Racecar"));
         assertFalse(stringUtils.isPalindrome("hello"));
         assertFalse(stringUtils.isPalindrome("Java"));
         assertFalse(stringUtils.isPalindrome(null));
     }

     @Test
     void testToUpperCase() {
         assertEquals("HELLO", stringUtils.toUpperCase("hello"));
         assertEquals("WORLD", stringUtils.toUpperCase("World"));
         assertEquals("", stringUtils.toUpperCase(""));
         assertNull(stringUtils.toUpperCase(null));
     }
}
