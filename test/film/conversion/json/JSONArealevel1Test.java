package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Arealevel1;
import film.searchentity.Arealevel1search;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONArealevel1Test {
    
    public JSONArealevel1Test() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Arealevel1 arealevel1 = new Arealevel1();
        ArrayList<Arealevel1> arealevel1list = new ArrayList<>();
        arealevel1list.add(arealevel1);
        JSONArray jsonarealevel1array = JSONArealevel1.toJSONArray(arealevel1list);
        JSONObject jsonarealevel1 = (JSONObject)jsonarealevel1array.get(0);
        arealevel1 = JSONArealevel1.toArealevel1(jsonarealevel1);
        arealevel1 = JSONArealevel1.initArealevel1(jsonarealevel1);
        JSONArealevel1.updateArealevel1(arealevel1, jsonarealevel1);
        Arealevel1search search = new Arealevel1search();
        JSONObject jsonsearch = JSONArealevel1.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONArealevel1.toArealevel1search(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

