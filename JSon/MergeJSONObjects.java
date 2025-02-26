

import org.json.JSONObject;

public class MergeJSONObjects {
    public static void main(String[] args) {
        JSONObject json1 = new JSONObject();
        json1.put("id", 1);
        json1.put("name", "Arpit");

        JSONObject json2 = new JSONObject();
        json2.put("email", "arpit@example.com");

        for (String key : json2.keySet()) {
            json1.put(key, json2.get(key));
        }

        System.out.println(json1.toString());
    }
}