package Assignment14;


class CircularNode {
    private int taskId;
    private String taskName;
    private int priority;
    private int dueDate;
    CircularNode next;
    CircularNode prev;

    public CircularNode(int taskId, String taskName, int priority, int dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        next = null;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getPriority() {
        return priority;
    }

    public int getDueDate() {
        return dueDate;
    }
}

public class TaskScheduler {

    CircularNode head;
    CircularNode tail;

    void addTaskAtBeginning(int taskId, String taskName, int priority, int dueDate) {
        CircularNode node = new CircularNode(taskId, taskName, priority, dueDate);

        if (head == null) {
            head = tail = node;
            tail.next = head;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    void addTaskAtEnd(int taskId, String taskName, int priority, int dueDate) {
        CircularNode node = new CircularNode(taskId, taskName, priority, dueDate);

        if (head == null) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        tail.next = node;
        tail = node;
        tail.next = head;
    }

    void addTaskAtSpecificPosition(int position, int taskId, String taskName, int priority, int dueDate) {
        CircularNode node = new CircularNode(taskId, taskName, priority, dueDate);


        if (head == null || position == 1) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        CircularNode temp = head;
        int count = 1;

        while (count < position - 1 && temp.next != head) {
            count++;
            temp = temp.next;
        }

        if (temp == tail) {
            addTaskAtEnd(taskId, taskName, priority, dueDate);
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    void removeTask(int taskId) {
        if (head == null) {
            System.out.println("No task to remove!!");
            return;
        }

        if (head.getTaskId() == taskId) {
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            System.out.println("Task with ID " + taskId + " removed.");
            return;
        }


        CircularNode temp = head;
        do {
            if (temp.next != null && temp.next.getTaskId() == taskId) {
                temp.next = temp.next.next;
                if (temp.next == head) {
                    tail = temp;
                }
                System.out.println("Task with ID " + taskId + " removed.");
                return;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task with ID " + taskId + " not found.");
    }

    void viewCurrentAndMove() {
        if (head == null) {
            System.out.println("No tasks to view.");
            return;
        }

        CircularNode current = head;
        // Display the current task at the head
        System.out.println("Current Task: ");
        System.out.println("Task ID: " + current.getTaskId() + ", Name: " + current.getTaskName() +
                ", Priority: " + current.getPriority() + ", Due Date: " + current.getDueDate());


        current = current.next;


        System.out.println("Next Task: ");
        System.out.println("Task ID: " + current.getTaskId() + ", Name: " + current.getTaskName() +
                ", Priority: " + current.getPriority() + ", Due Date: " + current.getDueDate());
    }


    void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        CircularNode temp = head;
        System.out.println("All Tasks in the List: ");
        do {
            System.out.println("Task ID: " + temp.getTaskId() + ", Name: " + temp.getTaskName() +
                    ", Priority: " + temp.getPriority() + ", Due Date: " + temp.getDueDate());
            temp = temp.next;
        } while (temp != head);
    }

    void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }

        CircularNode temp = head;
        boolean found = false;
        System.out.println("Searching for tasks with Priority " + priority + ": ");
        do {
            if (temp.getPriority() == priority) {
                System.out.println("Task ID: " + temp.getTaskId() + ", Name: " + temp.getTaskName() +
                        ", Due Date: " + temp.getDueDate());
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }


}
