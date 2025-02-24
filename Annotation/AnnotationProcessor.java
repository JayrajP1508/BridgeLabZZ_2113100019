package Bridgelabz_2113100011.Assignment24.Annotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define Custom Annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.METHOD)         // Can be applied to methods
@interface TaskInfo {
    String priority();
    String assignedTo();
}

// Step 2: Apply Annotation in TaskManager
class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "John Doe")
    public void completeTask() {
        System.out.println("Task is being completed...");
    }
}

// Step 3: Retrieve Annotation Details Using Reflection API
public class AnnotationProcessor {
    public static void main(String[] args) {
        try {
            Method method = TaskManager.class.getMethod("completeTask");

            if (method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
                System.out.println("Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

