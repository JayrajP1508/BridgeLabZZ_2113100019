package Bridgelabz_2113100011.Assignment25;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSVFile {
    private int id;
    private String Name;
    private String department;
    private float Salary;

    public static void main(String[] args) throws IOException {

        String[][] employees = {
                {"101", "John Doe", "IT", "50000"},
                {"102", "Jane Smith", "HR", "60000"},
                {"103", "Michael Brown", "Finance", "55000"},
                {"104", "Emily Davis", "Marketing", "58000"},
                {"105", "Chris Wilson", "Sales", "62000"}
        };
        try(BufferedWriter bw=new BufferedWriter(new FileWriter("Bridgelabz_2113100011/Assignment25/writingData.csv"));){

            bw.write("ID,Name,Department,Salary\n");

            for (String[] employee : employees) {
                bw.write(String.join(",", employee));
                bw.newLine();
            }

            System.out.println("CSV file written successfully!");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
