package Assignment15;

import java.util.Stack;

public class QueueUsingStacks {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    QueueUsingStacks() {
        this.stack1 = new Stack();
        this.stack2 = new Stack();
    }

    public void enqueue(int x) {
        stack1.push(x);
    }

    public void dequeue() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        int ele = stack2.pop();
        System.out.println("Element Removed: " + ele);

    }

    public void displayQueue() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = stack2.size() - 1; i >= 0; i--) {
            System.out.println(stack2.get(i));
        }
        for (int i = 0; i < stack1.size(); i++) {
            System.out.println(stack1.get(i));
        }
    }

    public static void main(String[] args) {
        QueueUsingStacks q=new QueueUsingStacks();
        q.enqueue(12);
        q.enqueue(23);
        q.enqueue(55);
        q.enqueue(76);
        q.enqueue(88);
        q.enqueue(36);
        q.enqueue(90);

        q.displayQueue();
        System.out.println();
        q.dequeue();
        System.out.println();
        q.displayQueue();
    }

}
