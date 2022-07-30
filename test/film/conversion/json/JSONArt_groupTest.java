package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Art_group;
import film.searchentity.Art_groupsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONArt_groupTest {
    
    public JSONArt_groupTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Art_group art_group = new Art_group();
        ArrayList<Art_group> art_grouplist = new ArrayList<>();
        art_grouplist.add(art_group);
        JSONArray jsonart_grouparray = JSONArt_group.toJSONArray(art_grouplist);
        JSONObject jsonart_group = (JSONObject)jsonart_grouparray.get(0);
        art_group = JSONArt_group.toArt_group(jsonart_group);
        art_group = JSONArt_group.initArt_group(jsonart_group);
        JSONArt_group.updateArt_group(art_group, jsonart_group);
        Art_groupsearch search = new Art_groupsearch();
        JSONObject jsonsearch = JSONArt_group.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONArt_group.toArt_groupsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

