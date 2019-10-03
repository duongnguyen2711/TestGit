package utility;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class JsonReader {

    public static Object[][] getJSONdata(String JSON_Path, String JSON_data, int JSON_attibutes) throws IOException, ParseException {
            Object obj = new JSONParser().parse(new FileReader(JSON_Path));
            JSONObject jo = (JSONObject)obj;
            JSONArray ja = (JSONArray)jo.get(JSON_data);

            Object [][] arr = new String[ja.size()][JSON_attibutes];
            for (int i = 0; i <ja.size(); i++){
                JSONObject js = (JSONObject)ja.get(i);
                arr[i][0] = String.valueOf(js.get("FirstName"));
                arr[i][1] = String.valueOf(js.get("LastName"));
                arr[i][2] = String.valueOf(js.get("Email"));
                arr[i][3] = String.valueOf(js.get("DOBDay"));
                arr[i][4] = String.valueOf(js.get("DOBMonth"));
                arr[i][5] = String.valueOf(js.get("DOBYear"));
                arr[i][6] = String.valueOf(js.get("Gender"));
            }

            return arr;
    }

    public static Object[][] getData(String JSON_Path, String JSON_Data, int totalDataRow, int totalEntryColumn) throws FileNotFoundException {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObj =jsonParser.parse(new FileReader(JSON_Path)).getAsJsonObject();
        JsonArray array = (JsonArray) jsonObj.get(JSON_Data);
        return searchJsonElement(array, totalDataRow, totalEntryColumn);

    }

    public static Object[][] searchJsonElement(JsonArray jsonArray, int totalDataRow, int totalEntryColumn){
        Object[][] matrix = new Object[totalDataRow][totalEntryColumn];
        int i= 0;
        int j= 0;
        for (JsonElement jsonElement : jsonArray)
        {
            for (Map.Entry<String, JsonElement > entry : jsonElement.getAsJsonObject().entrySet())
            {
                matrix[i][j] = entry.getValue().toString().replace("\"", "");
                j++;
            }
            i++;
            j = 0;
        }
        return matrix;
    }
}
