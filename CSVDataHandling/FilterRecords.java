package Bridgelabz_2113100011.Assignment25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecords {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\Bridge\\Bridgelabz_2113100011\\Assignment25\\UserInfo.csv"))) {
            // Read and print header separately
            String header = br.readLine();
            System.out.println(header);

            String line;
            while ((line = br.readLine()) != null) {
                String[] stringLine = line.split(",");

                // Ensure the record has the expected number of columns
                if (stringLine.length < 4) {
                    continue;
                }

                try {
                    int marks = Integer.parseInt(stringLine[3]);
                    if (marks > 80) {
                        System.out.println(line);  // Print the entire line
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid record: " + line);
                }
            }
            System.out.println("Records filtered successfully.");
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
