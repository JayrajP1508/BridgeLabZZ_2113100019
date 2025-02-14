package Bridgelabz_2113100011.Assignment16;

public class BubbleSort {
    static void bubbleSort(int arr[]) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
    public static void main(String args[]) {
        int marks[] = {50, 40, 90, 20, 10};
        bubbleSort(marks);
        for (int mark : marks) System.out.print(mark + " ");
    }
}