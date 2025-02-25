package Bridgelabz_2113100011.Assignment25;

import java.io.*;
import java.util.*;

public class SortBySalary {
    public static void main(String[] args) {
        String filePath = "D:\\Bridge\\Bridgelabz_2113100011\\Assignment25\\employee.csv";
        List<String[]> employeeList = new ArrayList<>();
        String header = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (isHeader) {
                    header = line; // Store the header separately
                    isHeader = false;
                } else {
                    employeeList.add(data); // Store employee data
                }
            }
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Sorting employees by salary (column index 3) in descending order
        employeeList.sort((a, b) -> Float.compare(Float.parseFloat(b[3]), Float.parseFloat(a[3])));

        // Print sorted results
        System.out.println(header); // Print header
        for (int i = 0; i < Math.min(5, employeeList.size()); i++) {
            System.out.println(String.join("\t", employeeList.get(i))); // Print top 5 highest-paid employees
        }
    }
}
