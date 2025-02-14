package Bridgelabz_2113100011.Assignment16;

import java.util.Arrays;

public class CountSort {

    static void countingSort(int[] arr) {
        int minAge = 10;
        int maxAge = 18;

        int[] count = new int[maxAge - minAge + 1];

        for (int age : arr) {
            count[age - minAge]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int age = arr[i];
            int position = count[age - minAge] - 1;
            output[position] = age;
            count[age - minAge]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        int[] arr = {7, 6, 9, 3, 6, 1, 3};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
