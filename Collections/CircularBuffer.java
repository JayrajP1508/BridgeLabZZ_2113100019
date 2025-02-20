package AssignmentCollectionFramework;

class CircularBuffer {
    private int[] buffer;
    private int size;
    private int head;
    private int tail;
    private boolean isFull;

    public CircularBuffer(int capacity) {
        buffer = new int[capacity];
        size = capacity;
        head = 0;
        tail = 0;
        isFull = false;
    }

    public void insert(int value) {
        buffer[tail] = value;
        if (isFull) {
            head = (head + 1) % size;
        }
        tail = (tail + 1) % size;
        isFull = tail == head;
    }

    public void printBuffer() {
        int i = head;
        int count = isFull ? size : (tail - head + size) % size;
        System.out.print("Buffer: [");
        for (int j = 0; j < count; j++) {
            System.out.print(buffer[i] + (j < count - 1 ? ", " : ""));
            i = (i + 1) % size;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.printBuffer();

        cb.insert(4);
        cb.printBuffer();

        cb.insert(5);
        cb.printBuffer();
    }
}
