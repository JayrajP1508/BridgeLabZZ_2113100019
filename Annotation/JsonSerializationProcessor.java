package Bridgelabz_2113100011.Assignment24.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class UserEntity {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public UserEntity(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

class JsonSerializer {
    public static String toJson(Object obj) throws IllegalAccessException {
        Map<String, String> jsonMap = new HashMap<>();
        Class<?> objClass = obj.getClass();
        for (Field field : objClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                jsonMap.put(annotation.name(), field.get(obj).toString());
            }
        }
        return jsonMap.toString().replace("=", ":"); // Formatting as JSON
    }
}

public class JsonSerializationProcessor {
    public static void main(String[] args) throws IllegalAccessException {
        UserEntity user = new UserEntity("JohnDoe", 25);
        String jsonString = JsonSerializer.toJson(user);
        System.out.println(jsonString);
    }
}
