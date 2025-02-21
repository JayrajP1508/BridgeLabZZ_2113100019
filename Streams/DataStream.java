package AssignmentJavaStreams;

import java.io.*;

public class DataStream {
    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        writeStudentData();
        readStudentData();
    }

    private static void writeStudentData() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            dos.writeInt(101);
            dos.writeUTF("Anika");
            dos.writeDouble(3.8);

            dos.writeInt(102);
            dos.writeUTF("Disha");
            dos.writeDouble(3.5);

            System.out.println("Student data written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing student data: " + e.getMessage());
        }
    }

    private static void readStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll Number: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println("Error reading student data: " + e.getMessage());
        }
    }
}
