package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Sublocality;
import film.searchentity.Sublocalitysearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONSublocalityTest {
    
    public JSONSublocalityTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Sublocality sublocality = new Sublocality();
        ArrayList<Sublocality> sublocalitylist = new ArrayList<>();
        sublocalitylist.add(sublocality);
        JSONArray jsonsublocalityarray = JSONSublocality.toJSONArray(sublocalitylist);
        JSONObject jsonsublocality = (JSONObject)jsonsublocalityarray.get(0);
        sublocality = JSONSublocality.toSublocality(jsonsublocality);
        sublocality = JSONSublocality.initSublocality(jsonsublocality);
        JSONSublocality.updateSublocality(sublocality, jsonsublocality);
        Sublocalitysearch search = new Sublocalitysearch();
        JSONObject jsonsearch = JSONSublocality.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONSublocality.toSublocalitysearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

