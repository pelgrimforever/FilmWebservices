package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Arealevel3;
import film.searchentity.Arealevel3search;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONArealevel3Test {
    
    public JSONArealevel3Test() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Arealevel3 arealevel3 = new Arealevel3();
        ArrayList<Arealevel3> arealevel3list = new ArrayList<>();
        arealevel3list.add(arealevel3);
        JSONArray jsonarealevel3array = JSONArealevel3.toJSONArray(arealevel3list);
        JSONObject jsonarealevel3 = (JSONObject)jsonarealevel3array.get(0);
        arealevel3 = JSONArealevel3.toArealevel3(jsonarealevel3);
        arealevel3 = JSONArealevel3.initArealevel3(jsonarealevel3);
        JSONArealevel3.updateArealevel3(arealevel3, jsonarealevel3);
        Arealevel3search search = new Arealevel3search();
        JSONObject jsonsearch = JSONArealevel3.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONArealevel3.toArealevel3search(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

