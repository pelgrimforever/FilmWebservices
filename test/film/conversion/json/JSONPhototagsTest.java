package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Phototags;
import film.searchentity.Phototagssearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONPhototagsTest {
    
    public JSONPhototagsTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Phototags phototags = new Phototags();
        ArrayList<Phototags> phototagslist = new ArrayList<>();
        phototagslist.add(phototags);
        JSONArray jsonphototagsarray = JSONPhototags.toJSONArray(phototagslist);
        JSONObject jsonphototags = (JSONObject)jsonphototagsarray.get(0);
        phototags = JSONPhototags.toPhototags(jsonphototags);
        phototags = JSONPhototags.initPhototags(jsonphototags);
        JSONPhototags.updatePhototags(phototags, jsonphototags);
        Phototagssearch search = new Phototagssearch();
        JSONObject jsonsearch = JSONPhototags.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONPhototags.toPhototagssearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

