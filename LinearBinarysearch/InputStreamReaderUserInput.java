package Bridgelabz_2113100011.Assignment17;

import java.io.*;

class InputStreamReaderUserInput {
    public static void main(String[] args) {
        String filePath = "output.txt"; // Replace with actual file path
        writeUserInputToFile(filePath);
    }

    public static void writeUserInputToFile(String filePath) {
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter fw = new FileWriter(filePath)) {

            System.out.println("Enter text (type 'exit' to stop):");

            String line;
            while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
                fw.write(line + System.lineSeparator());
            }

            System.out.println("Input saved to " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

