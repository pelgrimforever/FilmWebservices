package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Uploadsession;
import film.searchentity.Uploadsessionsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONUploadsessionTest {
    
    public JSONUploadsessionTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Uploadsession uploadsession = new Uploadsession();
        ArrayList<Uploadsession> uploadsessionlist = new ArrayList<>();
        uploadsessionlist.add(uploadsession);
        JSONArray jsonuploadsessionarray = JSONUploadsession.toJSONArray(uploadsessionlist);
        JSONObject jsonuploadsession = (JSONObject)jsonuploadsessionarray.get(0);
        uploadsession = JSONUploadsession.toUploadsession(jsonuploadsession);
        uploadsession = JSONUploadsession.initUploadsession(jsonuploadsession);
        JSONUploadsession.updateUploadsession(uploadsession, jsonuploadsession);
        Uploadsessionsearch search = new Uploadsessionsearch();
        JSONObject jsonsearch = JSONUploadsession.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONUploadsession.toUploadsessionsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

