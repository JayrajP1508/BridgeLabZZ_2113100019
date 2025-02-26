import org.json.JSONObject;

public class JsonGenerator {

   public static void main(String[] args) {
       JSONObject jsonObject = new JSONObject();
       jsonObject.put("name", "Arpit");
       jsonObject.put("age", 21);
       jsonObject.put("Sub", "Maths");
      
       // Write JSON to file (see next step for file handling)
       System.out.println(jsonObject.toString()); // Prints the JSON string
   }
}