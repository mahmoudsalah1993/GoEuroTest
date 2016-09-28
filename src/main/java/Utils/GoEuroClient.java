package Utils;

import java.util.ArrayList;
import Models.Location;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class GoEuroClient extends Client {

    public GoEuroClient(String url) {
        super(url);
    }

    public ArrayList<Location> extractArray(String json) throws JSONException {
       JSONArray jLocations = new JSONArray(json);
        ArrayList<Location> locations = new ArrayList<Location>();
        for(int i = 0; i < jLocations.length(); i++){
            JSONObject jobj = jLocations.getJSONObject(i);
            Location temp = Parser.parse(jobj, Location.class);
            locations.add(temp);
        }
        return locations;
    }

    public ArrayList<String> extractData(ArrayList<Location> locations){
        ArrayList<String> data = new ArrayList<String>();
        for(int i=0; i<locations.size(); i++){
            StringBuilder line = new StringBuilder();
            line.append(locations.get(i).getId());
            line.append(',');
            line.append(locations.get(i).getName());
            line.append(',');
            line.append(locations.get(i).getType());
            line.append(',');
            line.append(locations.get(i).getGeo_position().getLatitude());
            line.append(',');
            line.append(locations.get(i).getGeo_position().getLongitude());
            data.add(line.toString());
        }
        return data;
    }
}
