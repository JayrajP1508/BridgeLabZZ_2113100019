package Bridgelabz_2113100011.Assignment24.Annotations;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class AccessControlService {
    @RoleAllowed("ADMIN")
    public void restrictedTask() {
        System.out.println("Restricted admin task executed.");
    }

    public void openTask() {
        System.out.println("Open task executed.");
    }
}

class UserRole {
    private String role;

    public UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

public class RoleAccessManager {
    public static void main(String[] args) {
        UserRole adminUser = new UserRole("ADMIN");
        UserRole normalUser = new UserRole("USER");

        AccessControlService service = new AccessControlService();

        validateAndExecute(adminUser, service, "restrictedTask");
        validateAndExecute(normalUser, service, "restrictedTask");
        validateAndExecute(normalUser, service, "openTask");
    }

    public static void validateAndExecute(UserRole user, AccessControlService service, String methodName) {
        try {
            Method method = AccessControlService.class.getMethod(methodName);
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                if (!user.getRole().equals(roleAllowed.value())) {
                    System.out.println("Access Denied!");
                    return;
                }
            }
            method.invoke(service);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
