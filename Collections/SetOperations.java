package AssignmentCollectionFramework;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(5);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(10);
        set2.add(5);

        Set<Integer> union = new HashSet<>();
        for (Integer num : set1) {
            union.add(num);
        }
        for (Integer num : set2) {
            union.add(num);
        }

        Set<Integer> intersection = new HashSet<>();
        for (Integer num : set1) {
            if (set2.contains(num)) {
                intersection.add(num);
            }
        }


        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Union: " + union);
        System.out.println("Intersection: " + intersection);
    }
}
