import Models.Location;
import Utils.CityNotFoundException;
import Utils.FileWriter;
import Utils.GoEuroClient;
import org.codehaus.jettison.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws CityNotFoundException {
        String url = "http://api.goeuro.com/api/v2/position/suggest/en/";
        if(args.length==0)
            throw new CityNotFoundException();
        url = url.concat(args[0]);
        GoEuroClient client = new GoEuroClient(url);
        try{
            String response = client.makeRequest();
            ArrayList<Location> locations = client.extractArray(response);
            ArrayList<String> data = client.extractData(locations);
            FileWriter.write("result.csv", data);
        }
        catch(IOException e){
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
