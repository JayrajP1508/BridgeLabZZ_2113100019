package Bridgelabz_2113100011.Assignment25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRows {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\Bridge\\Bridgelabz_2113100011\\Assignment25\\writingData.csv"));) {
            int count = 0;
            br.readLine();
            while (br.readLine() != null) {
                count++;
            }

            System.out.println("Number of records: " + count);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
