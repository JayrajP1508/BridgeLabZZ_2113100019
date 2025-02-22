package Bridgelabz_2113100011.Assignment23.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.regex.Pattern;

// Implementation Class
public class UserRegistration {
    public void registerUser(String username, String email, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (email == null || !isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(emailRegex, email);
    }
}

// JUnit Test Class
class UserRegistrationTest {
    private UserRegistration userRegistration;

    @BeforeEach
    void setUp() {
        userRegistration = new UserRegistration();
    }

    @Test
    void testValidRegistration() {
        assertDoesNotThrow(() -> userRegistration.registerUser("JohnDoe", "john@example.com", "SecurePass1"));
    }

    @Test
    void testEmptyUsernameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("", "john@example.com", "SecurePass1"));
    }

    @Test
    void testInvalidEmailThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("JohnDoe", "invalid-email", "SecurePass1"));
    }

    @Test
    void testShortPasswordThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("JohnDoe", "john@example.com", "12345"));
    }

    @Test
    void testNullInputsThrowException() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser(null, "john@example.com", "SecurePass1"));
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("JohnDoe", null, "SecurePass1"));
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("JohnDoe", "john@example.com", null));
    }
}
