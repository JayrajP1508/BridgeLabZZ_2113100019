package Bridgelabz_2113100011.Assignment24.Reflections;

import java.lang.reflect.Field;
import java.util.Map;

class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance(); // Create an instance of the class

            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                try {
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true); // Allow access to private fields
                    field.set(instance, fieldValue);
                } catch (NoSuchFieldException e) {
                    System.out.println("Warning: Field '" + fieldName + "' does not exist in " + clazz.getSimpleName());
                }
            }

            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create object: " + e.getMessage(), e);
        }
    }
}

// Sample class
class User {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + "}";
    }
}

// Example usage
public class CustomObjectMapper {
    public static void main(String[] args) {
        Map<String, Object> properties = Map.of(
                "name", "John Doe",
                "age", 25
        );

        User user = ObjectMapper.toObject(User.class, properties);
        System.out.println(user);
    }
}

