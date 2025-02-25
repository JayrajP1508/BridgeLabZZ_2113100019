package Bridgelabz_2113100011.Assignment25;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchRecord {
    public static void main(String[] args) throws IOException {
        String name = "Michael Brown";
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\Bridge\\Bridgelabz_2113100011\\Assignment25\\employee.csv"));) {
            String string = br.readLine();
            System.out.println(string);

            boolean found = false;
            while ((string = br.readLine()) != null) {
                String[] s = string.split(",");
                if (s[1].equals(name)) {
                    System.out.println("Department: " + s[2] + " Salary: " + s[3]);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Employee not found!!");
            }
        }
    }

}
