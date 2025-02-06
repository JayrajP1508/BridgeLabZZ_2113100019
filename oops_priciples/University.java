package Assignment11;

import java.util.ArrayList;

public class University {
    private String univName;
    private ArrayList<Faculty> faculty;
    private ArrayList<Department2> departments;

    University(String univName) {
        this.univName = univName;
        faculty = new ArrayList<>();
        departments = new ArrayList<>();
    }

    void addFaculty(Faculty faculty) {
        this.faculty.add(faculty);
    }

    void addDepartment(Department2 department) {
        this.departments.add(department);
    }

    void deleteUniversity() {
        departments.clear();
        System.out.println(univName + " and all its departments are deleted!!");
    }

    void displayFaculty() {
        System.out.println("Faculty members in " + univName + ":");
        for (Faculty f : faculty) {
            System.out.println(f.getFacultyName());
        }
    }
}

class Faculty {
    private String facultyName;

    Faculty(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyName() {
        return facultyName;
    }
}

class Department2 {
    private String deptName;
    private ArrayList<Faculty> faculty;

    Department2(String deptName) {
        this.deptName = deptName;
        faculty = new ArrayList<>();
    }

    void addFaculty(Faculty faculty) {
        this.faculty.add(faculty);
    }

    void displayFaculty() {
        System.out.println("Faculty members in " + deptName + " department:");
        for (Faculty f : faculty) {
            System.out.println(f.getFacultyName());
        }
    }
}

class Main8 {
    public static void main(String[] args) {
        University university = new University("XYZ University");

        Faculty faculty1 = new Faculty("Dr. John Smith");
        Faculty faculty2 = new Faculty("Dr. Jane Doe");

        Department2 department1 = new Department2("Computer Science");
        Department2 department2 = new Department2("Electrical Engineering");

        department1.addFaculty(faculty1);
        department2.addFaculty(faculty2);

        university.addFaculty(faculty1);
        university.addFaculty(faculty2);
        university.addDepartment(department1);
        university.addDepartment(department2);

        university.displayFaculty();
        department1.displayFaculty();
        department2.displayFaculty();

        university.deleteUniversity();
    }
}


