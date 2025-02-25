package Bridgelabz_2113100011.Assignment25;


import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class DatabaseToCSV {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database";  // Change DB URL
        String username = "your_username";  // Change DB username
        String password = "your_password";  // Change DB password
        String csvFilePath = "D:\\Bridge\\Bridgelabz_2113100011\\Assignment25\\employees.csv";

        String query = "SELECT EmployeeID, Name, Department, Salary FROM employees";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
             FileWriter fileWriter = new FileWriter(csvFilePath)) {

            // Write CSV Header
            fileWriter.append("Employee ID,Name,Department,Salary\n");

            // Write Data
            while (resultSet.next()) {
                fileWriter.append(resultSet.getString("EmployeeID")).append(",");
                fileWriter.append(resultSet.getString("Name")).append(",");
                fileWriter.append(resultSet.getString("Department")).append(",");
                fileWriter.append(resultSet.getString("Salary")).append("\n");
            }

            System.out.println("CSV file generated successfully at " + csvFilePath);

        } catch (SQLException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
