package Bridgelabz_2113100011.Assignment23.JUnit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Implementation Class
public class DateFormatter {
    public String formatDate(String inputDate) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");

        Date date = inputFormat.parse(inputDate);
        return outputFormat.format(date);
    }
}

// JUnit Test Class
class DateFormatterTest {
    private DateFormatter dateFormatter;

    @BeforeEach
    void setUp() {
        dateFormatter = new DateFormatter();
    }

    @Test
    void testValidDateFormat() throws ParseException {
        assertEquals("25-12-2023", dateFormatter.formatDate("2023-12-25"));
        assertEquals("01-01-2000", dateFormatter.formatDate("2000-01-01"));
    }

    @Test
    void testInvalidDateFormatThrowsException() {
        assertThrows(ParseException.class, () -> dateFormatter.formatDate("25-12-2023"));
        assertThrows(ParseException.class, () -> dateFormatter.formatDate("2023/12/25"));
        assertThrows(ParseException.class, () -> dateFormatter.formatDate("abcd-ef-gh"));
    }

    @Test
    void testNullDateThrowsException() {
        assertThrows(NullPointerException.class, () -> dateFormatter.formatDate(null));
    }
}
