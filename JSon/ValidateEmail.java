import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;

public class ValidateEmail {
    public static void main(String[] args) {
        String schemaJson = "{ \"type\": \"object\", \"properties\": { \"email\": { \"type\": \"string\", \"format\": \"email\" } }, \"required\": [\"email\"] }";
        String dataJson = "{ \"email\": \"test@example.com\" }";

        JSONObject jsonSchema = new JSONObject(schemaJson);
        JSONObject jsonData = new JSONObject(dataJson);

        Schema schema = SchemaLoader.load(jsonSchema);
        schema.validate(jsonData);

        System.out.println("Valid JSON!");
    }
}