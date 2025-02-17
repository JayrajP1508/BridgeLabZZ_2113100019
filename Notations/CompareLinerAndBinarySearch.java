package Bridgelabz_2113100011.Assignment18;

import java.util.Arrays;
import java.util.Random;

public class CompareLinerAndBinarySearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (target > arr[mid]) {
                s = mid + 1;
            } else if (target < arr[mid]) {
                e = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = new int[1000];
        Random rand = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000) + 1;
        }

        Arrays.sort(numbers);

        long startTime = System.nanoTime();
        int index1 = linearSearch(numbers, 1000);
        long endLinearTime = System.nanoTime();



        long startBinaryTime = System.nanoTime();
        int index2 = binarySearch(numbers, 1000);
        long endBinaryTime = System.nanoTime();

        System.out.println("Linear Search result: " + index1);
        System.out.println("Binary Search result: " + index2);
        System.out.println("Elapsed time for linear search: " + (endLinearTime - startTime) + " ns");
        System.out.println("Elapsed time for binary search: " + (endBinaryTime - startBinaryTime) + " ns");
    }
}
