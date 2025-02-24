package Bridgelabz_2113100011.Assignment24.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        this.username = username;
        validateMaxLength();
    }

    private void validateMaxLength() {
        try {
            for (Field field : this.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(MaxLength.class)) {
                    field.setAccessible(true);
                    String fieldValue = (String) field.get(this);
                    int maxLength = field.getAnnotation(MaxLength.class).value();

                    if (fieldValue.length() > maxLength) {
                        throw new IllegalArgumentException(
                                field.getName() + " exceeds max length of " + maxLength);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}

public class MaxLengthValidator {
    public static void main(String[] args) {
        try {
            User user1 = new User("JohnDoe");
            System.out.println("User created with username: " + user1.getUsername());

            User user2 = new User("LongUsername123");
            System.out.println("User created with username: " + user2.getUsername());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
