public class Main{
    public static void main(String[] args) {
        System.out.println("--- Teacher ---");
        Teacher teacher = new Teacher("Anup Kumar", 30, "Maths");
        teacher.displayDetails();
        teacher.displayRole();
        teacher.teach();

        System.out.println("\n--- Student ---");
        Student student = new Student("Ashii", 16, "10th Grade");
        student.displayDetails();
        student.displayRole();
        student.study();

        System.out.println("\n--- Staff ---");
        Staff staff = new Staff("Srishthi", 35, "Administration");
        staff.displayDetails();
        staff.displayRole();
        staff.work();
    }
}

class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public void displayRole() {
        System.out.println("Role: General Person");
    }
}

class Teacher extends Person {
    private String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void teach() {
        System.out.println(name + " is teaching " + subject);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Teacher");
    }
}

class Student extends Person {
    private String grade;

    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    public void study() {
        System.out.println(name + " is studying in grade " + grade);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Student");
    }
}

class Staff extends Person {
    private String department;

    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public void work() {
        System.out.println(name + " works in the " + department + " department.");
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Staff");
    }
}

