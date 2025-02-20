package AssignmentCollectionFramework;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);

        queue = reverseQueue(queue);
        System.out.println(queue);
    }

    public static Queue<Integer> reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return queue;
        }
        int front = queue.poll();
        queue = reverseQueue(queue);
        queue.add(front);
        return queue;
    }
}
