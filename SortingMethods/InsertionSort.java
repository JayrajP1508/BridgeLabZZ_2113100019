package Bridgelabz_2113100011.Assignment16;

public class InsertionSort {
    static void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    public static void main(String args[]) {
        int employeeIDs[] = {105, 102, 108, 101, 107};
        insertionSort(employeeIDs);
        for (int id : employeeIDs) System.out.print(id + " ");
    }
}
