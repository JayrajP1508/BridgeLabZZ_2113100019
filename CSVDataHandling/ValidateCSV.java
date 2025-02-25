package Bridgelabz_2113100011.Assignment25;


import java.io.*;
import java.util.regex.Pattern;

public class ValidateCSV {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\Bridge\\Bridgelabz_2113100011\\Assignment25\\employee.csv";

        // Define regex patterns
        Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        // Read file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) { // Skip the header row
                    isHeader = false;
                    continue;
                }

                // Split CSV row
                String[] data = line.split(",");

                // Assuming CSV columns: ID, Name, Department, Salary, Email, Phone
                String email = data[4].trim();
                String phone = data[5].trim();

                boolean isValid = true;
                StringBuilder errorMsg = new StringBuilder("Invalid row: " + line + " | Error: ");

                // Validate email
                if (!emailPattern.matcher(email).matches()) {
                    errorMsg.append("Invalid email format. ");
                    isValid = false;
                }

                // Validate phone number
                if (!phonePattern.matcher(phone).matches()) {
                    errorMsg.append("Phone number must have exactly 10 digits. ");
                    isValid = false;
                }

                // Print invalid rows
                if (!isValid) {
                    System.out.println(errorMsg);
                }
            }
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
