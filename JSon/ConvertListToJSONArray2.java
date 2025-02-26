import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class ConvertListToJSONArray2 {
    public static void main(String[] args) {
        List<JSONObject> cars = new ArrayList<>();

        JSONObject car1 = new JSONObject();
        car1.put("brand", "Honda");
        car1.put("model", "Civic");
        car1.put("year", 2022);

        JSONObject car2 = new JSONObject();
        car2.put("brand", "Ford");
        car2.put("model", "Focus");
        car2.put("year", 2021);

        cars.add(car1);
        cars.add(car2);

        JSONArray jsonArray = new JSONArray(cars);
        System.out.println(jsonArray.toString());
    }
}