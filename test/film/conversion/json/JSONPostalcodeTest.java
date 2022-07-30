package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Postalcode;
import film.searchentity.Postalcodesearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONPostalcodeTest {
    
    public JSONPostalcodeTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Postalcode postalcode = new Postalcode();
        ArrayList<Postalcode> postalcodelist = new ArrayList<>();
        postalcodelist.add(postalcode);
        JSONArray jsonpostalcodearray = JSONPostalcode.toJSONArray(postalcodelist);
        JSONObject jsonpostalcode = (JSONObject)jsonpostalcodearray.get(0);
        postalcode = JSONPostalcode.toPostalcode(jsonpostalcode);
        postalcode = JSONPostalcode.initPostalcode(jsonpostalcode);
        JSONPostalcode.updatePostalcode(postalcode, jsonpostalcode);
        Postalcodesearch search = new Postalcodesearch();
        JSONObject jsonsearch = JSONPostalcode.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONPostalcode.toPostalcodesearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

