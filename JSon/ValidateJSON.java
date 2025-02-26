import org.json.JSONException;
import org.json.JSONObject;

public class ValidateJSON {
    public static void main(String[] args) {
        String validJson = "{\"name\":\"Bob\", \"age\":30}";
        String invalidJson = "{name:\"Bob\", age:30}";

        System.out.println("Valid JSON: " + isValidJSON(validJson));
        System.out.println("Invalid JSON: " + isValidJSON(invalidJson));
    }

    public static boolean isValidJSON(String json) {
        try {
            new JSONObject(json);
            return true;
        } catch (JSONException e) {
            return false;
        }
    }
}