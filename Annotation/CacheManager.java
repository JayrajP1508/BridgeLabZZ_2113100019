package Bridgelabz_2113100011.Assignment24.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

class ComputationService {
    private final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int expensiveComputation(int number) {
        if (cache.containsKey(number)) {
            System.out.println("Returning cached result for: " + number);
            return cache.get(number);
        }
        System.out.println("Computing result for: " + number);
        int result = number * number; // Simulating expensive operation
        cache.put(number, result);
        return result;
    }
}

public class CacheManager {
    public static void main(String[] args) {
        ComputationService service = new ComputationService();
        System.out.println(service.expensiveComputation(5));
        System.out.println(service.expensiveComputation(5)); // Should return cached result
        System.out.println(service.expensiveComputation(10));
        System.out.println(service.expensiveComputation(10)); // Should return cached result
    }
}
