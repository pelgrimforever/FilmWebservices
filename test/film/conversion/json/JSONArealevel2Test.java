package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Arealevel2;
import film.searchentity.Arealevel2search;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONArealevel2Test {
    
    public JSONArealevel2Test() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Arealevel2 arealevel2 = new Arealevel2();
        ArrayList<Arealevel2> arealevel2list = new ArrayList<>();
        arealevel2list.add(arealevel2);
        JSONArray jsonarealevel2array = JSONArealevel2.toJSONArray(arealevel2list);
        JSONObject jsonarealevel2 = (JSONObject)jsonarealevel2array.get(0);
        arealevel2 = JSONArealevel2.toArealevel2(jsonarealevel2);
        arealevel2 = JSONArealevel2.initArealevel2(jsonarealevel2);
        JSONArealevel2.updateArealevel2(arealevel2, jsonarealevel2);
        Arealevel2search search = new Arealevel2search();
        JSONObject jsonsearch = JSONArealevel2.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONArealevel2.toArealevel2search(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

