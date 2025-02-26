import org.json.JSONObject;

public class ConvertCarObjectToJSON {
    public static void main(String[] args) {
        JSONObject carJson = new JSONObject();
        carJson.put("brand", "Toyota");
        carJson.put("model", "Camry");
        carJson.put("year", 2023);

        System.out.println(carJson.toString());
    }
}