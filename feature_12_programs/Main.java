package Assignment14;

public class Main {

    public static void main(String[] args) {
//        StudentLinkedList list = new StudentLinkedList();
//        list.insertAtEnd(101, "Alice", 20, 'A');
//        list.insertAtEnd(102, "Bob", 21, 'B');
//        list.insertAtBeginning(100, "Charlie", 22, 'C');
//        list.insertAtEnd(103, "David", 20, 'B');
//        list.insertAtEnd(104, "Eve", 23, 'A');
//
//        System.out.println("\nStudent Records:");
//        list.display();
//
//        System.out.println("\nInserting at Position 3:");
//        list.insertAtPosition(3, 105, "Frank", 21, 'D');
//        list.display();
//
//        System.out.println("\nUpdating grade for Roll No 102:");
//        list.updateGrade(102, 'A');
//        list.display();
//
//        System.out.println("\nDeleting record for Roll No 100:");
//        list.deleteByRollNumber(100);
//        list.display();
//
//        System.out.println("\nSearching for Roll No 103:");
//        StudentNode found = list.searchByRollNumber(103);
//        if (found != null) {
//            System.out.println("Found: " + found.name + " with Grade " + found.grade);
//        } else {
//            System.out.println("Record not found.");
//
//        }

//        -----------------------------------------------------------------------------------

//        MovieManagementSystem movie = new MovieManagementSystem();
//        movie.insertAtBeginning("PK", "Rajkumar Hirani", 2015, 8.5f);
//        movie.insertAtBeginning("3 Idiots", "Rajkumar Hirani", 2009, 8.4f);
//        movie.insertAtBeginning("Dangal", "Nitesh Tiwari", 2016, 8.3f);
//        movie.insertAtBeginning("Zindagi Na Milegi Dobara", "Zoya Akhtar", 2011, 8.2f);
//        movie.insertAtBeginning("Gully Boy", "Zoya Akhtar", 2019, 8.0f);
//        movie.insertAtBeginning("Swades", "Ashutosh Gowariker", 2004, 8.2f);
//
//        movie.displayRecordReverse();
//        System.out.println();
//        movie.displayRecordForward();

//        ------------------------------------------------------------------------------------------

//        Inventory inventory = new Inventory();
//        inventory.addAtEnd("Item1", 101, 10, 5.5);
//        inventory.addAtEnd("Item2", 102, 20, 3.5);
//        inventory.addAtBeginning("Item0", 100, 5, 7.0);
//        inventory.addAtPosition(1, "Item1.5", 105, 15, 6.0);
//        inventory.printInventory();
//        System.out.println("Total Value: " + inventory.calculateTotalValue());
//        inventory.mergeSort();
//        System.out.println("Sorted Inventory:");
//        inventory.printInventory();
//
//        ------------------------------------------------------------------------------------------

//        Library library = new Library();
//        library.addAtEnd("Book1", "Author1", "Fiction", 101, true);
//        library.addAtEnd("Book2", "Author2", "Non-Fiction", 102, true);
//        library.addAtBeginning("Book0", "Author0", "Science", 100, true);
//        library.addAtPosition(1, "Book1.5", "Author1.5", "Fiction", 105, true);
//
//        System.out.println("Library Books (Forward Order):");
//        library.displayForward();
//
//        System.out.println("Total Books: " + library.countTotalBooks());
//
//        library.updateAvailabilityStatus(102, false);
//        System.out.println("Book with ID 102 updated availability:");
//        library.displayForward();
//
//        library.removeByBookID(100);
//        System.out.println("Library Books (After Removal of Book ID 100):");
//        library.displayForward();
//
//        System.out.println("Library Books (Reverse Order):");
//        library.displayReverse();
//
//        --------------------------------------------------------------------------------------------

//        TicketReservationSystem system = new TicketReservationSystem();
//
//        system.addTicket(101, "John Doe", "Avatar", "A1", "2025-02-10 18:30");
//        system.addTicket(102, "Jane Smith", "Avengers", "B2", "2025-02-10 20:00");
//        system.addTicket(103, "Alice Brown", "Avatar", "C3", "2025-02-11 16:00");
//
//        System.out.println("All tickets:");
//        system.displayTickets();
//
//        System.out.println("Total Tickets: " + system.countTotalTickets());
//
//        Ticket searchedTicket = system.searchByCustomerName("John Doe");
//        if (searchedTicket != null) {
//            System.out.println("Found ticket for customer: " + searchedTicket.customerName);
//        } else {
//            System.out.println("No ticket found for the given customer.");
//        }
//
//        system.removeTicketByID(102);
//        System.out.println("All tickets after removal of ticket with ID 102:");
//        system.displayTickets();
//
//        System.out.println("Total Tickets: " + system.countTotalTickets());

//        --------------------------------------------------------------------------------------------

//        TaskScheduler scheduler = new TaskScheduler();
//
//        // Adding tasks
//        scheduler.addTaskAtBeginning(1, "Task 1", 3, 20250212);
//        scheduler.addTaskAtEnd(2, "Task 2", 2, 20250213);
//        scheduler.addTaskAtEnd(3, "Task 3", 1, 20250214);
//        scheduler.addTaskAtSpecificPosition(2, 4, "Task 4", 5, 20250215);  // Add at position 2
//
//        // Displaying all tasks
//        scheduler.displayAllTasks();
//
//        // Viewing current task and moving to the next
//        scheduler.viewCurrentAndMove();
//
//        // Searching tasks by priority
//        scheduler.searchByPriority(2);
//        scheduler.searchByPriority(5);
//
//        // Removing a task
//        scheduler.removeTask(3);  // Remove Task with ID 3
//        scheduler.removeTask(5);  // Try removing a non-existing task
//
//        // Displaying all tasks again after removal
//        scheduler.displayAllTasks();

//        ------------------------------------------------------------------------------

//        RoundRobinScheduler scheduler = new RoundRobinScheduler(4);
//
//        scheduler.addProcess(1, 10, 1);
//        scheduler.addProcess(2, 5, 2);
//        scheduler.addProcess(3, 8, 3);
//        scheduler.addProcess(4, 12, 4);
//
//        scheduler.displayProcesses();
//        scheduler.simulateRoundRobin();
//        scheduler.displayProcesses();

//        SocialMedia sm = new SocialMedia();
//        sm.addUser(1, "Alice", 25);
//        sm.addUser(2, "Bob", 24);
//        sm.addUser(3, "Charlie", 23);
//
//        sm.addFriend(1, 2);
//        sm.addFriend(2, 3);
//        sm.displayFriends(2);
//
//        System.out.println("Mutual friends between Alice and Charlie: " + sm.findMutualFriends(1, 3));
//        sm.countFriends();

//        ------------------------------------------------------------------------

        TextEditor editor = new TextEditor(10);

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();
    }



}
