package Assignment15;

import java.util.Stack;

public class SortStack {
    public static void stackInsert(Stack<Integer> stack, int num) {

        if (stack.isEmpty() || stack.peek() < num || stack.peek() == num) {
            stack.push(num);
            return;
        }

        int top = stack.pop();
        stackInsert(stack, num);
        stack.push(top);
    }

    public static void stackSort(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        stackSort(stack);

        stackInsert(stack, top);

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(9);
        stack.push(8);
        stack.push(7);
        stack.push(6);
        stack.push(5);
        stack.push(4);

        System.out.println(stack.peek());
        stackSort(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
    }
}
