package Bridgelabz_2113100011.Assignment24.Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime {
}

class TaskExecutor {

    @LogExecutionTime
    public void processData() {
        long startTime = System.nanoTime();
        try {
            Thread.sleep(500); // Simulating a task that takes time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        System.out.println("processData executed in " + (endTime - startTime) / 1_000_000.0 + " ms");
    }

    @LogExecutionTime
    public void performComputation() {
        long startTime = System.nanoTime();
        long sum = 0;
        for (long i = 0; i < 1_000_000; i++) {
            sum += i;
        }
        long endTime = System.nanoTime();
        System.out.println("performComputation executed in " + (endTime - startTime) / 1_000_000.0 + " ms");
    }
}

public class ExecutionTimeLogger {

    public static void main(String[] args) {
        TaskExecutor executor = new TaskExecutor();

        for (Method method : TaskExecutor.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                try {
                    method.invoke(executor);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
