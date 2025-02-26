import org.json.JSONObject;
import org.json.XML;

public class ConvertJSONToXML {
    public static void main(String[] args) {
        String json = "{ \"name\": \"John\", \"age\": 30, \"city\": \"New York\" }";
        JSONObject jsonObject = new JSONObject(json);

        String xml = XML.toString(jsonObject);
        System.out.println(xml);
    }
}