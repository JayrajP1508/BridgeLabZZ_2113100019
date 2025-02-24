package Bridgelabz_2113100011.Assignment24.Annotations;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

public class BugTracker {

    @BugReport(description = "UI issue - Button misaligned")
    @BugReport(description = "Performance issue - Slow response")
    public void testMethod() {
        System.out.println("Executing testMethod...");
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = BugTracker.class.getMethod("testMethod");

        if (method.isAnnotationPresent(BugReports.class)) {
            BugReports bugReports = method.getAnnotation(BugReports.class);
            for (BugReport bugReport : bugReports.value()) {
                System.out.println("Bug Description: " + bugReport.description());
            }
        }
    }
}
