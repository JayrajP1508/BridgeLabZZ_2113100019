package Bridgelabz_2113100011.Assignment25;

import java.io.*;

public class LargeCSVReader {
    public static void main(String[] args) {
        String filePath = "D:\\Bridge\\Bridgelabz_2113100011\\Assignment25\\large_employee.csv";
        int batchSize = 100;  // Process 100 lines at a time
        int totalRecords = 0;  // Counter for total records processed

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int batchCount = 0;

            while ((line = br.readLine()) != null) {
                totalRecords++;
                batchCount++;

                // Process the line (Example: Just print it)
                // System.out.println(line); // Uncomment if you want to print

                // After processing 100 lines, display progress
                if (batchCount == batchSize) {
                    System.out.println("Processed: " + totalRecords + " records...");
                    batchCount = 0; // Reset batch counter
                }
            }

            System.out.println("Total records processed: " + totalRecords);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
