package Bridgelabz_2113100011.Assignment23.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

// Implementation Class
public class PerformanceTester {
    public String longRunningTask() {
        try {
            Thread.sleep(3000); // Simulates a long-running process (3 seconds)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Task Completed";
    }
}

// JUnit Test Class
class PerformanceTesterTest {
    PerformanceTester performanceTester = new PerformanceTester();

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS) // Test should fail if it exceeds 2 seconds
    void testLongRunningTask() {
        assertEquals("Task Completed", performanceTester.longRunningTask());
    }
}
