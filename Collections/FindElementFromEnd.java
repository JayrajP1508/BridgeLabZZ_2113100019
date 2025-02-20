package AssignmentCollectionFramework;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public String findNthFromEnd(int N) {
        Node mainPtr = head;
        Node refPtr = head;

        for (int i = 0; i < N; i++) {
            if (refPtr == null) {
                return " ";
            }
            refPtr = refPtr.next;
        }

        while (refPtr != null) {
            mainPtr = mainPtr.next;
            refPtr = refPtr.next;
        }

        return mainPtr.data;
    }

    public void add(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
}

public class FindElementFromEnd {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("G");
        list.add("H");
        list.add("I");
        list.add("J");

        int N = 2;
        String result = list.findNthFromEnd(N);
        System.out.println(list);
        System.out.println(result);
    }
}
