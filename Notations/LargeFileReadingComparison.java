package Bridgelabz_2113100011.Assignment18;

import java.io.*;

public class LargeFileReadingComparison {

    public static void main(String[] args) {
        String filePath = "LargeFile"; // Replace with your large file path

        System.out.println("Reading using FileReader...");
        long startTimeFileReader = System.nanoTime();
        readUsingFileReader(filePath);
        long endTimeFileReader = System.nanoTime();
        System.out.println("Time taken by FileReader: " + (endTimeFileReader - startTimeFileReader) / 1e6 + " ms");

        System.out.println("\nReading using InputStreamReader...");
        long startTimeInputStreamReader = System.nanoTime();
        readUsingInputStreamReader(filePath);
        long endTimeInputStreamReader = System.nanoTime();
        System.out.println("Time taken by InputStreamReader: " + (endTimeInputStreamReader - startTimeInputStreamReader) / 1e6 + " ms");
    }

    public static void readUsingFileReader(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            int ch;
            while ((ch = reader.read()) != -1) {} // Read character by character
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readUsingInputStreamReader(String filePath) {
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath))) {
            int ch;
            while ((ch = reader.read()) != -1) {} // Read byte by byte and convert to char
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

