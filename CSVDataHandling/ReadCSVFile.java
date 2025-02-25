package Bridgelabz_2113100011.Assignment25;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

public class ReadCSVFile {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\Bridge\\Bridgelabz_2113100011\\Assignment25\\UserInfo.csv"));) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] stringLine = line.split(",");
                System.out.println(stringLine[0] + '\t' + stringLine[1] + '\t' + stringLine[2] + '\t' + stringLine[3]);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
