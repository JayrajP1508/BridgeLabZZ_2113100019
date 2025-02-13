package Assignment15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubArraysZeroSum {
    public static void findSubarrays(int[] arr) {
        HashMap<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;

        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sumMap.containsKey(sum)) {
                List<Integer> indices = sumMap.get(sum);
                for (int index : indices) {
                    System.out.println("Subarray: " + Arrays.toString(Arrays.copyOfRange(arr, index + 1, i + 1)));
                }
            }

            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, -1, -4, 5, 1, -5, 2};
        findSubarrays(arr);
    }
}
