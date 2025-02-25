package Bridgelabz_2113100011.Assignment25;

import java.io.*;
import java.util.*;

public class MergeCSVFiles {
    private static final String FILE1 = "D:\\Bridge\\Bridgelabz_2113100011\\Assignment25\\students1.csv";
    private static final String FILE2 = "D:\\Bridge\\Bridgelabz_2113100011\\Assignment25\\students2.csv";
    private static final String MERGED_FILE = "D:\\Bridge\\Bridgelabz_2113100011\\Assignment25\\merged_students.csv";

    public static void main(String[] args) {
        Map<String, String[]> studentData = new HashMap<>();

        // Read first CSV (ID, Name, Age)
        readCSV(FILE1, studentData, new int[]{0, 1, 2});

        // Read second CSV (ID, Marks, Grade)
        readCSV(FILE2, studentData, new int[]{0, 3, 4});

        // Write merged data to new CSV
        writeMergedCSV(MERGED_FILE, studentData);

        System.out.println("CSV files merged successfully!");
    }

    // Reads a CSV file and stores data in HashMap
    private static void readCSV(String filePath, Map<String, String[]> studentData, int[] columns) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip header
                    isHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                String id = data[columns[0]];
                String[] record = studentData.getOrDefault(id, new String[]{"", "", "", "", ""});

                for (int i = 1; i < columns.length; i++) {
                    record[columns[i]] = data[i];
                }

                studentData.put(id, record);
            }
        } catch (IOException e) {
            System.out.println("Error reading file " + filePath + ": " + e.getMessage());
        }
    }

    // Writes the merged data into a new CSV file
    private static void writeMergedCSV(String filePath, Map<String, String[]> studentData) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("ID,Name,Age,Marks,Grade"); // Header
            bw.newLine();

            for (Map.Entry<String, String[]> entry : studentData.entrySet()) {
                String[] values = entry.getValue();
                bw.write(entry.getKey() + "," + String.join(",", values));
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error writing merged CSV file: " + e.getMessage());
        }
    }
}
