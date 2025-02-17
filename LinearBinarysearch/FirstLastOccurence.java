package Bridgelabz_2113100011.Assignment17;

class FirstLastOccurrence {
    public static int findFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1, first = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                first = mid;
                right = mid - 1; // Continue searching left
            } else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return first;
    }

    public static int findLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1, last = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                last = mid;
                left = mid + 1; // Continue searching right
            } else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return last;
    }

    public static int[] searchRange(int[] nums, int target) {
        return new int[]{findFirst(nums, target), findLast(nums, target)};
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = searchRange(nums, target);
        System.out.println("First Occurrence: " + result[0] + ", Last Occurrence: " + result[1]);
        // Output: First Occurrence: 3, Last Occurrence: 4
    }
}

