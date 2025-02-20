package AssignmentCollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RotateList {
    public static <T> void rotateList(List<T> list, int positions) {
        int size = list.size();
        positions = positions % size;

        if (positions < 0) {
            positions += size;
        }

        Collections.rotate(list, -positions);
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
        numbers.add(60);
        numbers.add(70);
        numbers.add(80);
        numbers.add(90);
        numbers.add(100);
        numbers.add(110);

        int rotateBy = 5;

        System.out.println("Original List: " + numbers);
        rotateList(numbers, rotateBy);
        System.out.println("Rotated List: " + numbers);
    }
}
