package AssignmentCollectionFramework;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumberUsingQueue {
    public static void main(String[] args) {
        int N = 9;
        String[] binaryNumbers = generateBinaryNumbers(N);
        for (String binary : binaryNumbers) {
            System.out.println(binary);
        }
    }

    public static String[] generateBinaryNumbers(int N) {
        String[] result = new String[N];
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");

        for (int i = 0; i < N; i++) {
            String current = queue.poll();
            result[i] = current;

            queue.offer(current + "0");
            queue.offer(current + "1");
        }

        return result;
    }
}
