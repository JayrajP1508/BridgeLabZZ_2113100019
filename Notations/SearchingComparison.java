package Bridgelabz_2113100011.Assignment18;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class SearchingComparison {

    public static void main(String[] args) {
        int[] numbers = {5, 12, 8, 25, 12, 30, 7, 18, 5, 22, 30, 8, 14, 18, 25, 10, 7, 22, 14, 10};
        HashSet<Integer> set = new HashSet<>();
        TreeSet<Integer> treeset = new TreeSet<>();

        int target = 14;

        for (Integer i : numbers) {
            set.add(i);
            treeset.add(i);
        }

        long startLinearTime = System.nanoTime();

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                System.out.println("Element found at index: " + i);
                break;
            }
        }
        long endLinearTime = System.nanoTime();

        long startHashTime = System.nanoTime();
        System.out.println(set.contains(target));
        long endHashTime = System.nanoTime();

        long startTreeTime = System.nanoTime();
        System.out.println(treeset.contains(target));
        long endTreeTime = System.nanoTime();

        System.out.println("Elapse time for linear search: " + (endLinearTime - startLinearTime));
        System.out.println("Elapse time for hash set: " + (endHashTime - startHashTime));
        System.out.println("Elapse time for tree set: " + (endTreeTime - startTreeTime));


    }
}
