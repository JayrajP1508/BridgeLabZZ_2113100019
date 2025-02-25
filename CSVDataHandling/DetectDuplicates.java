package Bridgelabz_2113100011.Assignment25;

import java.io.*;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) {
        String filePath = "D:\\Bridge\\Bridgelabz_2113100011\\Assignment25\\employee.csv";
        Set<String> uniqueIds = new HashSet<>();
        List<String> duplicateRecords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip header
                    isHeader = false;
                    continue;
                }

                String[] columns = line.split(",");
                String id = columns[0].trim(); // Assuming ID is in the first column

                // Check if the ID is already in the set
                if (!uniqueIds.add(id)) {
                    duplicateRecords.add(line); // Store duplicate record
                }
            }

            // Print duplicate records
            if (!duplicateRecords.isEmpty()) {
                System.out.println("Duplicate Records Found:");
                for (String record : duplicateRecords) {
                    System.out.println(record);
                }
            } else {
                System.out.println("No duplicates found.");
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
