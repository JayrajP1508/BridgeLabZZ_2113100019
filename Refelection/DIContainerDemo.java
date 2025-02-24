package Bridgelabz_2113100011.Assignment24.Reflections;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {
}

class DIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    public void register(Class<?> clazz) throws Exception {
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        Object instance = constructor.newInstance();
        instances.put(clazz, instance);
    }

    public void injectDependencies(Object object) throws Exception {
        for (Field field : object.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldType = field.getType();
                Object dependency = instances.get(fieldType);
                if (dependency == null) {
                    throw new RuntimeException("No registered instance for " + fieldType.getName());
                }
                field.setAccessible(true);
                field.set(object, dependency);
            }
        }
    }

    public <T> T getInstance(Class<T> clazz) throws Exception {
        T instance = (T) instances.get(clazz);
        if (instance == null) {
            throw new RuntimeException("No instance found for " + clazz.getName());
        }
        return instance;
    }
}

class Service {
    public void execute() {
        System.out.println("Service Executed!");
    }
}

class Client {
    @Inject
    private Service service;

    public void run() {
        service.execute();
    }
}

public class DIContainerDemo {
    public static void main(String[] args) throws Exception {
        DIContainer container = new DIContainer();
        container.register(Service.class);

        Client client = new Client();
        container.injectDependencies(client);

        client.run();
    }
}
