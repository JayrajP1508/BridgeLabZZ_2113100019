package AssignmentCollectionFramework;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {
    public static <T> List<T> removeDuplicates(List<T> list) {
        ArrayList<T> uniqueList = new ArrayList<>();
        for (T item : list) {
            if (!uniqueList.contains(item)) {
                uniqueList.add(item);
            }
        }
        return uniqueList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(3,1,1, 22, 2, 3, 4,5,4,11));

        System.out.println("Original List: " + numbers);
        List<Integer> uniqueNumbers = removeDuplicates(numbers);
        System.out.println("List without duplicates: " + uniqueNumbers);
    }
}