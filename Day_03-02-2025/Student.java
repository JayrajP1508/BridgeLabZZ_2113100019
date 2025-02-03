class Student {
    private static String universityName = "XYZ University";
    private static int totalStudents = 0;
    private String name;
    private final int rollNumber;
    private String grade;
    private static int idCounter = 1;

    public Student(String name, String grade) {
        this.rollNumber = idCounter++;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
            System.out.println("University: " + universityName);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Alice", "A");
        Student s2 = new Student("Bob", "B");

        s1.displayStudentDetails();
        System.out.println();
        s2.displayStudentDetails();
        System.out.println();
        Student.displayTotalStudents();
    }
}
