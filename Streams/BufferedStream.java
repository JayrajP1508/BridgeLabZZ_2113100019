package AssignmentJavaStreams;

import java.io.*;

public class BufferedStream  {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        long startTime, endTime;

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            startTime = System.nanoTime();

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            endTime = System.nanoTime();
            System.out.println("File copied successfully using Buffered Streams!");
            System.out.println("Execution time (Buffered Streams): " + (endTime - startTime) + " nanoseconds");
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading or writing file: " + e.getMessage());
        }

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int data;
            startTime = System.nanoTime();

            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            endTime = System.nanoTime();
            System.out.println("File copied successfully using Unbuffered Streams!");
            System.out.println("Execution time (Unbuffered Streams): " + (endTime - startTime) + " nanoseconds");
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading or writing file: " + e.getMessage());
        }
    }
}
