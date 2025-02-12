package Assignment14;

class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    public Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    Item head;

    public Inventory() {
        head = null;
    }

    public void addAtBeginning(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addAtEnd(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    public void addAtPosition(int position, String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        if (position == 0) {
            newItem.next = head;
            head = newItem;
            return;
        }
        Item temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            return;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }

    public void removeByID(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next == null) return;
        temp.next = temp.next.next;
    }

    public void updateQuantityByID(int id, int quantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = quantity;
                return;
            }
            temp = temp.next;
        }
    }

    public Item searchByID(int id) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public Item searchByName(String name) {
        Item temp = head;
        while (temp != null) {
            if (temp.name.equals(name)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public double calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        return totalValue;
    }

    public void mergeSort() {
        head = mergeSortRec(head);
    }

    private Item mergeSortRec(Item node) {
        if (node == null || node.next == null) {
            return node;
        }
        Item middle = getMiddle(node);
        Item nextOfMiddle = middle.next;
        middle.next = null;
        Item left = mergeSortRec(node);
        Item right = mergeSortRec(nextOfMiddle);
        return sortedMerge(left, right);
    }

    private Item sortedMerge(Item left, Item right) {
        if (left == null) return right;
        if (right == null) return left;
        if (left.name.compareTo(right.name) < 0) {
            left.next = sortedMerge(left.next, right);
            return left;
        } else {
            right.next = sortedMerge(left, right.next);
            return right;
        }
    }

    private Item getMiddle(Item node) {
        if (node == null) return node;
        Item slow = node;
        Item fast = node.next;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

    public void printInventory() {
        Item temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.id + ", Name: " + temp.name + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }
}


