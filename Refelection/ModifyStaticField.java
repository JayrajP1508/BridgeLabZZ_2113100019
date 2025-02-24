package Bridgelabz_2113100011.Assignment24.Reflections;

import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "ORIGINAL_API_KEY"; // Private static field

    public static String getApiKey() {
        return API_KEY; // Normal getter method
    }
}

public class ModifyStaticField {
    public static void main(String[] args) throws Exception {
        // Get the Class object
        Class<?> cls = Configuration.class;

        // Access the private static field "API_KEY"
        Field field = cls.getDeclaredField("API_KEY");

        // Make it accessible
        field.setAccessible(true);

        // Modify the static field value
        field.set(null, "NEW_SECRET_API_KEY");

        // Print the modified value
        System.out.println("Updated API_KEY: " + Configuration.getApiKey());
    }
}

