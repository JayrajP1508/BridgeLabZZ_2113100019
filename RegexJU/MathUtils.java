package Bridgelabz_2113100011.Assignment23.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// Implementation Class
public class MathUtils {
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }
}

// JUnit Test Class
class MathUtilsTest {
    MathUtils mathUtils = new MathUtils();

    @Test
    void testDivide() {
        assertEquals(5, mathUtils.divide(10, 2));
        assertEquals(-3, mathUtils.divide(-9, 3));
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(10, 0));
    }
}
