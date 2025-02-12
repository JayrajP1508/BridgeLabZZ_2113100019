package Assignment14;


class ProcessNode {
    private int processId;
    private int burstTime;
    private int priority;
    private int remainingTime;
    ProcessNode next;

    public ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
        this.next = null;
    }

    public int getProcessId() {
        return processId;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void decreaseRemainingTime(int timeQuantum) {
        remainingTime -= timeQuantum;
    }

    public boolean isComplete() {
        return remainingTime <= 0;
    }
}

public class RoundRobinScheduler {

    private ProcessNode head;
    private ProcessNode tail;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.head = null;
        this.tail = null;
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(int processId, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(processId, burstTime, priority);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void removeProcess(int processId) {
        if (head == null) {
            System.out.println("No process to remove.");
            return;
        }

        if (head.getProcessId() == processId) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            System.out.println("Process " + processId + " removed.");
            return;
        }

        ProcessNode temp = head;
        do {
            if (temp.next.getProcessId() == processId) {
                temp.next = temp.next.next;
                if (temp.next == head) {
                    tail = temp;
                }
                System.out.println("Process " + processId + " removed.");
                return;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println("Process with ID " + processId + " not found.");
    }

    public void simulateRoundRobin() {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int processCount = 0;
        ProcessNode temp = head;

        // Calculate total number of processes for average calculation later
        do {
            processCount++;
            temp = temp.next;
        } while (temp != head);

        temp = head;
        int currentTime = 0;

        while (processCount > 0) {
            if (temp.getRemainingTime() > 0) {
                System.out.println("Executing process " + temp.getProcessId() + " for " + Math.min(timeQuantum, temp.getRemainingTime()) + " units.");

                int executionTime = Math.min(timeQuantum, temp.getRemainingTime());
                temp.decreaseRemainingTime(executionTime);
                currentTime += executionTime;

                if (temp.isComplete()) {
                    int waitingTime = currentTime - temp.getBurstTime();
                    int turnAroundTime = waitingTime + temp.getBurstTime();
                    totalWaitingTime += waitingTime;
                    totalTurnAroundTime += turnAroundTime;
                    processCount--;
                    System.out.println("Process " + temp.getProcessId() + " completed. Waiting Time: " + waitingTime + ", Turnaround Time: " + turnAroundTime);
                }
            }

            temp = temp.next;
        }

        System.out.println("Average Waiting Time: " + (double) totalWaitingTime / processCount);
        System.out.println("Average Turnaround Time: " + (double) totalTurnAroundTime / processCount);
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes to display.");
            return;
        }

        ProcessNode temp = head;
        System.out.println("Processes in the Round-Robin queue:");
        do {
            System.out.println("Process ID: " + temp.getProcessId() + ", Burst Time: " + temp.getBurstTime() + ", Remaining Time: " + temp.getRemainingTime());
            temp = temp.next;
        } while (temp != head);
    }
}