package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Creator;
import film.searchentity.Creatorsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONCreatorTest {
    
    public JSONCreatorTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Creator creator = new Creator();
        ArrayList<Creator> creatorlist = new ArrayList<>();
        creatorlist.add(creator);
        JSONArray jsoncreatorarray = JSONCreator.toJSONArray(creatorlist);
        JSONObject jsoncreator = (JSONObject)jsoncreatorarray.get(0);
        creator = JSONCreator.toCreator(jsoncreator);
        creator = JSONCreator.initCreator(jsoncreator);
        JSONCreator.updateCreator(creator, jsoncreator);
        Creatorsearch search = new Creatorsearch();
        JSONObject jsonsearch = JSONCreator.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONCreator.toCreatorsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

