package Assignment15;

class MyHashMap {
    private class Node {
        int key, value;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Node[] map;
    private static final int SIZE = 10000;

    public MyHashMap() {
        map = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (map[index] == null) {
            map[index] = new Node(key, value);
        } else {
            Node current = map[index];
            while (current != null) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            Node newNode = new Node(key, value);
            newNode.next = map[index];
            map[index] = newNode;
        }
    }

    public int get(int key) {
        int index = hash(key);
        Node current = map[index];
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node current = map[index];
        Node prev = null;
        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    map[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1)); // Output: 1
        System.out.println(hashMap.get(3)); // Output: -1
        hashMap.put(2, 1);
        System.out.println(hashMap.get(2)); // Output: 1
        hashMap.remove(2);
        System.out.println(hashMap.get(2)); // Output: -1
    }
}

