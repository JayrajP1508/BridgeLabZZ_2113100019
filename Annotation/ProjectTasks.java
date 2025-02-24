package Bridgelabz_2113100011.Assignment24.Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

public class ProjectTasks {

    @Todo(task = "Implement authentication", assignedTo = "Alice", priority = "HIGH")
    public void authentication() {
        System.out.println("Authentication logic pending...");
    }

    @Todo(task = "Improve database indexing", assignedTo = "Bob")
    public void optimizeDatabase() {
        System.out.println("Database optimization pending...");
    }

    @Todo(task = "Redesign dashboard UI", assignedTo = "Charlie", priority = "LOW")
    public void redesignUI() {
        System.out.println("UI redesign pending...");
    }

    public static void main(String[] args) {
        Method[] methods = ProjectTasks.class.getDeclaredMethods();

        System.out.println("Pending Tasks:");
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo annotation = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName() +
                        " | Task: " + annotation.task() +
                        " | Assigned To: " + annotation.assignedTo() +
                        " | Priority: " + annotation.priority());
            }
        }
    }
}
