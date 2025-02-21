package Bridgelabz_2113100011.Assignment22;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderWithResources {
    public static void main(String[] args) {
        String fileName = "info.txt"; // File to read

        // Try-with-resources ensures BufferedReader is automatically closed
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String firstLine = br.readLine(); // Read the first line
            if (firstLine != null) {
                System.out.println("First line: " + firstLine);
            } else {
                System.out.println("File is empty.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
