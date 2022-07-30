package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Art_academy;
import film.searchentity.Art_academysearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONArt_academyTest {
    
    public JSONArt_academyTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Art_academy art_academy = new Art_academy();
        ArrayList<Art_academy> art_academylist = new ArrayList<>();
        art_academylist.add(art_academy);
        JSONArray jsonart_academyarray = JSONArt_academy.toJSONArray(art_academylist);
        JSONObject jsonart_academy = (JSONObject)jsonart_academyarray.get(0);
        art_academy = JSONArt_academy.toArt_academy(jsonart_academy);
        art_academy = JSONArt_academy.initArt_academy(jsonart_academy);
        JSONArt_academy.updateArt_academy(art_academy, jsonart_academy);
        Art_academysearch search = new Art_academysearch();
        JSONObject jsonsearch = JSONArt_academy.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONArt_academy.toArt_academysearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

