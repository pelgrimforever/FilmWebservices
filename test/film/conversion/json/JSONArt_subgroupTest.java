package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Art_subgroup;
import film.searchentity.Art_subgroupsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONArt_subgroupTest {
    
    public JSONArt_subgroupTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Art_subgroup art_subgroup = new Art_subgroup();
        ArrayList<Art_subgroup> art_subgrouplist = new ArrayList<>();
        art_subgrouplist.add(art_subgroup);
        JSONArray jsonart_subgrouparray = JSONArt_subgroup.toJSONArray(art_subgrouplist);
        JSONObject jsonart_subgroup = (JSONObject)jsonart_subgrouparray.get(0);
        art_subgroup = JSONArt_subgroup.toArt_subgroup(jsonart_subgroup);
        art_subgroup = JSONArt_subgroup.initArt_subgroup(jsonart_subgroup);
        JSONArt_subgroup.updateArt_subgroup(art_subgroup, jsonart_subgroup);
        Art_subgroupsearch search = new Art_subgroupsearch();
        JSONObject jsonsearch = JSONArt_subgroup.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONArt_subgroup.toArt_subgroupsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

