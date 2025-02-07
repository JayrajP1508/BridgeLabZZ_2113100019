public class Main{
    public static void main(String[] args) {
        System.out.println("--- Chef ---");
        Chef chef = new Chef("Henry", 188, "South Indian");
        chef.displayDetails();
        chef.performDuties();

        System.out.println("\n--- Waiter ---");
        Waiter waiter = new Waiter("Hitika", 208, 10);
        waiter.displayDetails();
        waiter.performDuties();
    }
}

interface Worker {
    void performDuties();
}

class Person2 {
    protected String name;
    protected int id;

    public Person2(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

class Chef extends Person2 implements Worker {
    private String specialty;

    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is preparing dishes, specializing in " + specialty);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Chef");
        System.out.println("Specialty: " + specialty);
    }
}

class Waiter extends Person2 implements Worker {
    private int tablesAssigned;

    public Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is serving customers at " + tablesAssigned + " tables.");
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Waiter");
        System.out.println("Tables Assigned: " + tablesAssigned);
    }
}


