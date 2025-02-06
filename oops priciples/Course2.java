package Assignment11;

import java.util.ArrayList;

public class Course2 {
    private String courseName;
    private Professor professor;
    private ArrayList<Student2> students;

    public Course2(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    public void enrollStudent(Student2 student) {
        students.add(student);
    }

    public String getCourseName() {
        return courseName;
    }

    public Professor getProfessor() {
        return professor;
    }

    public ArrayList<Student2> getStudents() {
        return students;
    }

    public void displayCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Professor: " + (professor != null ? professor.getProfessorName() : "Not Assigned"));
        System.out.println("Enrolled Students:");
        for (Student2 student : students) {
            System.out.println(student.getStudentName());
        }
    }
}

class Professor {
    private String professorName;
    private ArrayList<Course2> courses;  // Corrected the type from Course to Course2

    public Professor(String professorName) {
        this.professorName = professorName;
        this.courses = new ArrayList<>();
    }

    public void teachCourse(Course2 course) {
        courses.add(course);
        course.assignProfessor(this);
    }

    public String getProfessorName() {
        return professorName;
    }
}

class Student2 {
    private String studentName;
    private ArrayList<Course2> courses;  // Corrected the type from Course to Course2

    public Student2(String studentName) {
        this.studentName = studentName;
        this.courses = new ArrayList<>();
    }

    public void enrollCourse(Course2 course) {
        courses.add(course);
        course.enrollStudent(this);
    }

    public String getStudentName() {
        return studentName;
    }
}

class Main3 {
    public static void main(String[] args) {
        Course2 course1 = new Course2("Java Programming");
        Course2 course2 = new Course2("Data Structures");

        Professor professor = new Professor("Dr. Smith");

        Student2 student1 = new Student2("Alice");
        Student2 student2 = new Student2("Bob");

        professor.teachCourse(course1);
        professor.teachCourse(course2);

        student1.enrollCourse(course1);
        student1.enrollCourse(course2);

        student2.enrollCourse(course1);

        course1.displayCourseDetails();
        course2.displayCourseDetails();
    }
}

