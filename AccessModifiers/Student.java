package Assignment9.Level1;

public class Student {

    public int rollNumber;
    protected String name;
    private double CGPA;

    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    public void setCGPA(double CGPA) {
        if (CGPA >= 0 && CGPA <= 10) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA value");
        }
    }

    public double getCGPA() {
        return CGPA;
    }

    class PostgraduateStudent {
        public void displayDetails() {
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
        }
    }

    public static void main(String[] args) {
        Student student = new Student(101, "Alice Johnson", 8.5);
        Student.PostgraduateStudent pgStudent = student.new PostgraduateStudent();
        pgStudent.displayDetails();

        student.setCGPA(9.0);
        System.out.println("Updated CGPA: " + student.getCGPA());
    }

}
