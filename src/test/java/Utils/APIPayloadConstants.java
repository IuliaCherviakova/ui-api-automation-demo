package Utils;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;

public class APIPayloadConstants {
    //pass the body in multiple format

    public static String createEmployeePayload(){
        String createEmployee="{\n" +
                "  \"firstName\": \"Iuliia\",\n" +
                "  \"lastName\": \"Cherviakova\",\n" +
                "  \"middleName\": \"A\",\n" +
                "  \"employeeId\": \"E" +"\"\n" +
                "}";
        return createEmployeePayload();
    }

    public static String createEmployeePayloadJson(){
        JSONObject object=new JSONObject();
        object.put("firstName","Iuliia");
        object.put("lastName","Cherviakova");
        object.put("middleName","A");
        object.put("employeeId","E");
      return object.toString();
    }
}
