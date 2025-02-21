package AssignmentJavaStreams;

import java.io.*;

public class FilterStreeam {
    public static void main(String[] args) {
        String inputFilePath = "text.txt";
        String outputFilePath = "text2.txt";

        convertUppercaseToLowercase(inputFilePath, outputFilePath);
    }

    private static void convertUppercaseToLowercase(String inputPath, String outputPath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }

            System.out.println("Text conversion completed successfully.");
        } catch (IOException e) {
            System.out.println("Error processing text file: " + e.getMessage());
        }
    }
}

