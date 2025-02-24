package Bridgelabz_2113100011.Assignment24.Reflections;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

// Step 1: Define a custom annotation @Author
@Retention(RetentionPolicy.RUNTIME) // Retain annotation at runtime
@interface Author {
    String name();  // Annotation parameter
}

// Step 2: Apply the @Author annotation to a class
@Author(name = "John Doe")
class Book {
    @Author(name = "Jane Smith")
    public void display() {
        System.out.println("Displaying Book Details...");
    }
}

public class RetrieveAnnotation {
    public static void main(String[] args) {
        try {
            // Step 3: Get Class object
            Class<?> cls = Book.class;

            // Step 4: Retrieve annotation from class
            if (cls.isAnnotationPresent(Author.class)) {
                Author author = cls.getAnnotation(Author.class);
                System.out.println("Class Author: " + author.name());
            }

            // Step 5: Retrieve annotation from method
            Method method = cls.getMethod("display");
            if (method.isAnnotationPresent(Author.class)) {
                Author authorMethod = method.getAnnotation(Author.class);
                System.out.println("Method Author: " + authorMethod.name());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
