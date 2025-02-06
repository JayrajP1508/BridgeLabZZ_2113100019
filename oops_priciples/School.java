package Assignment11;

import java.util.ArrayList;

class School {
    private String schoolName;
    private ArrayList<Student> students;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showStudents() {
        System.out.println("Students in " + schoolName + ":");
        for (Student s : students) {
            System.out.println(s.getStudentName());
        }
    }
}

class Student {
    private String studentName;
    private ArrayList<Course> courses;

    public Student(String name) {
        this.studentName = name;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        this.courses.add(course);
        course.addStudent(this);
    }

    public void viewCourses() {
        System.out.println("Student Name: " + studentName);
        System.out.println("Courses Enrolled:");
        for (Course c : courses) {
            System.out.println(c.getCourseName());
        }
    }

    public String getStudentName() {
        return studentName;
    }
}

class Course {
    private String courseName;
    private ArrayList<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public void addStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void showEnrolledStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student s : enrolledStudents) {
            System.out.println(s.getStudentName());
        }
    }

    public String getCourseName() {
        return courseName;
    }
}

class Main7 {
    public static void main(String[] args) {
        School school = new School("Green Valley School");

        Course course1 = new Course("Mathematics");
        Course course2 = new Course("Science");

        Student student1 = new Student("John");
        Student student2 = new Student("Emma");

        student1.addCourse(course1);
        student1.addCourse(course2);

        student2.addCourse(course1);

        school.addStudent(student1);
        school.addStudent(student2);

        school.showStudents();

        student1.viewCourses();
        student2.viewCourses();

        course1.showEnrolledStudents();
        course2.showEnrolledStudents();
    }
}


