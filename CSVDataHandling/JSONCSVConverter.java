package Bridgelabz_2113100011.Assignment25;


import org.json.JSONArray;
import org.json.JSONObject;
import org.json.CDL;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONCSVConverter {
    public static void main(String[] args) {
        String jsonFilePath = "D:\\Bridge\\Bridgelabz_2113100011\\Assignment25\\students.json";
        String csvFilePath = "D:\\Bridge\\Bridgelabz_2113100011\\Assignment25\\students.csv";
        String jsonOutputFilePath = "D:\\Bridge\\Bridgelabz_2113100011\\Assignment25\\students_output.json";

        // Convert JSON to CSV
        convertJSONToCSV(jsonFilePath, csvFilePath);

        // Convert CSV back to JSON
        convertCSVToJSON(csvFilePath, jsonOutputFilePath);
    }

    // Convert JSON to CSV
    public static void convertJSONToCSV(String jsonFile, String csvFile) {
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get(jsonFile)));
            JSONArray jsonArray = new JSONArray(jsonData);

            // Convert JSON Array to CSV format
            String csvData = CDL.toString(jsonArray);

            // Write to CSV file
            try (FileWriter fileWriter = new FileWriter(csvFile)) {
                fileWriter.write(csvData);
            }

            System.out.println("JSON converted to CSV successfully!");

        } catch (IOException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
    }

    // Convert CSV to JSON
    public static void convertCSVToJSON(String csvFile, String jsonFile) {
        try {
            String csvData = new String(Files.readAllBytes(Paths.get(csvFile)));

            // Convert CSV format back to JSON Array
            JSONArray jsonArray = CDL.toJSONArray(csvData);

            // Write JSON back to file
            try (FileWriter fileWriter = new FileWriter(jsonFile)) {
                fileWriter.write(jsonArray.toString(4)); // Pretty print JSON with 4 spaces
            }

            System.out.println("CSV converted back to JSON successfully!");

        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }
}
