package Bridgelabz_2113100011.Assignment25;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Define the Student class
class Student {
    private int id;
    private String name;
    private int age;
    private double marks;

    // Constructor
    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    // Override toString() for easy printing
    @Override
    public String toString() {
        return "Student { ID=" + id + ", Name='" + name + "', Age=" + age + ", Marks=" + marks + " }";
    }
}

public class CSVToStudentObject {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\Bridge\\Bridgelabz_2113100011\\Assignment25\\students.csv";
        List<Student> studentList = new ArrayList<>();

        // Read file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip header row
                    isHeader = false;
                    continue;
                }

                // Split the line by commas
                String[] data = line.split(",");

                // Convert fields and create Student object
                int id = Integer.parseInt(data[0].trim());
                String name = data[1].trim();
                int age = Integer.parseInt(data[2].trim());
                double marks = Double.parseDouble(data[3].trim());

                // Add to the list
                studentList.add(new Student(id, name, age, marks));
            }
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Print all Student objects
        System.out.println("Student List:");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
