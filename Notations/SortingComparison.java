package Bridgelabz_2113100011.Assignment18;

import java.util.Arrays;
import java.util.Random;

public class SortingComparison {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int n = 10000;
        int[] bubbleArr = generateRandomArray(n);
        int[] mergeArr = generateRandomArray(n);
        int[] quickArr = generateRandomArray(n);

        // Bubble Sort
        long startTime = System.nanoTime();
        bubbleSort(bubbleArr);
        long endTime = System.nanoTime();
        System.out.println("Bubble Sort took: " + (endTime - startTime) + " ns");

        // Merge Sort
        startTime = System.nanoTime();
        mergeSort(mergeArr);
        endTime = System.nanoTime();
        System.out.println("Merge Sort took: " + (endTime - startTime) + " ns");

        // Quick Sort
        startTime = System.nanoTime();
        quickSort(quickArr, 0, quickArr.length - 1);
        endTime = System.nanoTime();
        System.out.println("Quick Sort took: " + (endTime - startTime) + " ns");
    }

    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000);
        }
        return arr;
    }
}

