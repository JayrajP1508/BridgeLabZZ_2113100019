package Bridgelabz_2113100011.Assignment23.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

// Implementation Class
public class NumberUtils {
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}

// JUnit Test Class
class NumberUtilsTest {
    NumberUtils numberUtils = new NumberUtils();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void testIsEvenWithEvenNumbers(int number) {
        assertTrue(numberUtils.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    void testIsEvenWithOddNumbers(int number) {
        assertFalse(numberUtils.isEven(number));
    }
}
