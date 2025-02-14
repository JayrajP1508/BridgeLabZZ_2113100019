package Bridgelabz_2113100011.Assignment16;

import java.util.Arrays;

public class QuickSort {

    static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        int pivot = arr[mid];
        int s = left;
        int e = right;

        while (s <= e) {

            while (arr[s] < pivot) {
                s++;
            }
            while (arr[e] > pivot) {
                e--;
            }

            if (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }

        }

        quickSort(arr, left, e);
        quickSort(arr, s, right);
    }

    public static void main(String[] args) {
        int[] productPrices = {799, 455, 900, 199, 299, 600};
        quickSort(productPrices, 0, productPrices.length - 1);
        System.out.println(Arrays.toString(productPrices));
    }

}
