package Bridgelabz_2113100011.Assignment25;

import java.io.*;

public class ModifyRecord {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\Bridge\\Bridgelabz_2113100011\\Assignment25\\employee.csv";
        String tempFile = "copyFile.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                String[] stringLine = line.split(",");  // ✅ Corrected split

                if (isHeader) {
                    bw.write(line);  // ✅ Write header as is
                    isHeader = false;
                } else if (stringLine.length == 4) {
                    float newSalary = Float.parseFloat(stringLine[3]) * 1.1f;  // ✅ Corrected parsing
                    stringLine[3] = String.format("%.2f", newSalary);
                    bw.write(String.join(",", stringLine));
                }
                bw.newLine();  // ✅ Ensure correct formatting
            }
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // ✅ Replace the original file with the updated one
        File originalFile = new File(filePath);
        File updatedFile = new File(tempFile);

        if (originalFile.delete() && updatedFile.renameTo(originalFile)) {
            System.out.println("File updated successfully.");
        } else {
            System.out.println("Error updating file.");
        }
    }
}
