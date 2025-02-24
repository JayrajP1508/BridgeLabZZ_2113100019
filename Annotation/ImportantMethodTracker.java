package Bridgelabz_2113100011.Assignment24.Annotations;

import java.lang.annotation.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface ImportantMethod {
    String level() default "HIGH";
}

public class ImportantMethodTracker {

    @ImportantMethod
    public void processData() {
        System.out.println("Processing important data...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void logActivity() {
        System.out.println("Logging user activity...");
    }

    public void regularTask() {
        System.out.println("Executing a regular task...");
    }

    public static void main(String[] args) {
        Method[] methods = ImportantMethodTracker.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + " | Importance Level: " + annotation.level());
            }
        }
    }
}
