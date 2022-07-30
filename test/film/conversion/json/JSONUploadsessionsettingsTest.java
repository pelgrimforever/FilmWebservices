package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Uploadsessionsettings;
import film.searchentity.Uploadsessionsettingssearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONUploadsessionsettingsTest {
    
    public JSONUploadsessionsettingsTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Uploadsessionsettings uploadsessionsettings = new Uploadsessionsettings();
        ArrayList<Uploadsessionsettings> uploadsessionsettingslist = new ArrayList<>();
        uploadsessionsettingslist.add(uploadsessionsettings);
        JSONArray jsonuploadsessionsettingsarray = JSONUploadsessionsettings.toJSONArray(uploadsessionsettingslist);
        JSONObject jsonuploadsessionsettings = (JSONObject)jsonuploadsessionsettingsarray.get(0);
        uploadsessionsettings = JSONUploadsessionsettings.toUploadsessionsettings(jsonuploadsessionsettings);
        uploadsessionsettings = JSONUploadsessionsettings.initUploadsessionsettings(jsonuploadsessionsettings);
        JSONUploadsessionsettings.updateUploadsessionsettings(uploadsessionsettings, jsonuploadsessionsettings);
        Uploadsessionsettingssearch search = new Uploadsessionsettingssearch();
        JSONObject jsonsearch = JSONUploadsessionsettings.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONUploadsessionsettings.toUploadsessionsettingssearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

