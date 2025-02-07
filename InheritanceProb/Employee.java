public class Main {
    public static void main(String[] args) {
        Employee manager = new Manager("Anil", 191, 100000, 15);
        Employee developer = new Developer("Bhavna", 102, 600000, "Java");
        Employee intern = new Intern("Anika", 136, 80000, "GLA");
        
        manager.displayDetails();
        developer.displayDetails();
        intern.displayDetails();
    }
}

class Employee {
    protected String name;
    protected int id;
    protected double salary;
    
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    
    public void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + id + ", Salary: " + salary);
    }
}


class Manager extends Employee {
    private int teamSize;
    
    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }
    
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

class Developer extends Employee {
    private String programmingLanguage;
    
    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }
    
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}


class Intern extends Employee {
    private String university;
    
    public Intern(String name, int id, double salary, String university) {
        super(name, id, salary);
        this.university = university;
    }
    
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("University: " + university);
    }
}

