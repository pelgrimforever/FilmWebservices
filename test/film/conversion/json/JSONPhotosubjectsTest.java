package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Photosubjects;
import film.searchentity.Photosubjectssearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONPhotosubjectsTest {
    
    public JSONPhotosubjectsTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Photosubjects photosubjects = new Photosubjects();
        ArrayList<Photosubjects> photosubjectslist = new ArrayList<>();
        photosubjectslist.add(photosubjects);
        JSONArray jsonphotosubjectsarray = JSONPhotosubjects.toJSONArray(photosubjectslist);
        JSONObject jsonphotosubjects = (JSONObject)jsonphotosubjectsarray.get(0);
        photosubjects = JSONPhotosubjects.toPhotosubjects(jsonphotosubjects);
        photosubjects = JSONPhotosubjects.initPhotosubjects(jsonphotosubjects);
        JSONPhotosubjects.updatePhotosubjects(photosubjects, jsonphotosubjects);
        Photosubjectssearch search = new Photosubjectssearch();
        JSONObject jsonsearch = JSONPhotosubjects.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONPhotosubjects.toPhotosubjectssearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

