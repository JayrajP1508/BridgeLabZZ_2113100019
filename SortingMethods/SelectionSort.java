package Bridgelabz_2113100011.Assignment16;


class SelectionSort {
    static void selectionSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String args[]) {
        int scores[] = {85, 70, 95, 60, 90};
        selectionSort(scores);
        for (int score : scores) System.out.print(score + " ");
    }
}
