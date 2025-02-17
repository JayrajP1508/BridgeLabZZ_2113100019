package Bridgelabz_2113100011.Assignment17;

import java.io.*;

class InputStreamReaderFileReader {
    public static void main(String[] args) {
        String filePath = "input.txt"; // Replace with actual file path
        readFile(filePath);
    }

    public static void readFile(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

