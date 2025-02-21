package AssignmentJavaStreams;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LargeFileReader {
    public static void main(String[] args) {
        String filePath = "\"C:\\Users\\sneha\\Desktop\\text.txt.txt\"";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
