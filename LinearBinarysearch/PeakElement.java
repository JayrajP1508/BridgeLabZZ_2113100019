package Bridgelabz_2113100011.Assignment17;

public class PeakElement {
    public static int findPeak(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < arr[mid + 1]) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 6, 5};
        System.out.println("Peak index: " + findPeak(arr));
    }
}
