package AssignmentCollectionFramework;

import java.util.HashMap;
import java.util.Map;

public class KeyWithHighestValue {
    public static String findKeyWithMaxValue(Map<String, Integer> map) {
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }

    public static void main(String[] args) {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 10);
        inputMap.put("B", 20);
        inputMap.put("C", 15);
        inputMap.put("D", 19);
        inputMap.put("E", 150);

        String keyWithMaxValue = findKeyWithMaxValue(inputMap);
        System.out.println(keyWithMaxValue);
    }
}

