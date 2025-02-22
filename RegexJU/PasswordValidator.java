package Bridgelabz_2113100011.Assignment23.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

// Implementation Class
public class PasswordValidator {
    public boolean isValid(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUppercase = false, hasDigit = false;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            }
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }
        return hasUppercase && hasDigit;
    }
}

// JUnit Test Class
class PasswordValidatorTest {
    private PasswordValidator validator;

    @BeforeEach
    void setUp() {
        validator = new PasswordValidator();
    }

    @Test
    void testValidPassword() {
        assertTrue(validator.isValid("StrongPass1"));
    }

    @Test
    void testPasswordTooShort() {
        assertFalse(validator.isValid("Abc1"));
    }

    @Test
    void testPasswordWithoutUppercase() {
        assertFalse(validator.isValid("weakpass1"));
    }

    @Test
    void testPasswordWithoutDigit() {
        assertFalse(validator.isValid("WeakPass"));
    }

    @Test
    void testNullPassword() {
        assertFalse(validator.isValid(null));
    }

    @Test
    void testPasswordWithSpecialCharacters() {
        assertTrue(validator.isValid("Valid1@Pass"));
    }
}
