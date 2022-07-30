package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Locality;
import film.searchentity.Localitysearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONLocalityTest {
    
    public JSONLocalityTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Locality locality = new Locality();
        ArrayList<Locality> localitylist = new ArrayList<>();
        localitylist.add(locality);
        JSONArray jsonlocalityarray = JSONLocality.toJSONArray(localitylist);
        JSONObject jsonlocality = (JSONObject)jsonlocalityarray.get(0);
        locality = JSONLocality.toLocality(jsonlocality);
        locality = JSONLocality.initLocality(jsonlocality);
        JSONLocality.updateLocality(locality, jsonlocality);
        Localitysearch search = new Localitysearch();
        JSONObject jsonsearch = JSONLocality.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONLocality.toLocalitysearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

