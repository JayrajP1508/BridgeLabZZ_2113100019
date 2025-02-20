package AssignmentCollectionFramework;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer> symmetricDifference = new HashSet<>();

        for (Integer num : set1) {
            if (!set2.contains(num)) {
                symmetricDifference.add(num);
            }
        }

        for (Integer num : set2) {
            if (!set1.contains(num)) {
                symmetricDifference.add(num);
            }
        }

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Symmetric Difference: " + symmetricDifference);
    }
}
