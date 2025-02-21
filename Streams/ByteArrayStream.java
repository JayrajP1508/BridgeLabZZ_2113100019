package AssignmentJavaStreams;

import java.io.*;

public class ByteArrayStream {
    public static void main(String[] args) {
        String inputImagePath = "passportpic.jpeg";
        String outputImagePath = "output.jpg";

        byte[] imageBytes = convertImageToByteArray(inputImagePath);
        if (imageBytes != null) {
            writeByteArrayToImage(imageBytes, outputImagePath);
        }
    }

    private static byte[] convertImageToByteArray(String imagePath) {
        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            System.out.println("Error reading image file: " + e.getMessage());
            return null;
        }
    }

    private static void writeByteArrayToImage(byte[] imageBytes, String outputPath) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("Image successfully written to " + outputPath);
        } catch (IOException e) {
            System.out.println("Error writing image file: " + e.getMessage());
        }
    }
}

