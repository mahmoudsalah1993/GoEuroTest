package Utils;

import jodd.json.JsonParser;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Parser {

    public static <T>T parse(JSONObject jobj, Class<T> type) throws JSONException {
        JsonParser parser = new JsonParser();
        T obj = parser.parse(jobj.toString(), type);
        return obj;
    }

}

