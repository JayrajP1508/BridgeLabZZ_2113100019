package Bridgelabz_2113100011.Assignment16;

public class MergeSort {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        mergeSortArray(arr, left, mid, right);

    }

    public static void mergeSortArray(int[] arr, int left, int mid, int right) {

        int[] mix = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else if (arr[i] > arr[j]) {
                mix[k] = arr[j];
                j++;
            } else {
                mix[k++] = arr[i++];
                mix[k] = arr[j++];
            }
            k++;

        }

        while (i <= mid) mix[k++] = arr[i++];
        while (j <= right) mix[k++] = arr[j++];


        for (int l = 0; l < mix.length; l++) {
            arr[l + left] = mix[l];
        }
    }

    public static void main(String args[]) {
        int bookPrices[] = {300, 150, 500, 200, 100};
        mergeSort(bookPrices, 0, bookPrices.length - 1);
        for (int price : bookPrices) System.out.print(price + " ");
    }
}
