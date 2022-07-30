package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Mainmenu;
import film.searchentity.Mainmenusearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONMainmenuTest {
    
    public JSONMainmenuTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Mainmenu mainmenu = new Mainmenu();
        ArrayList<Mainmenu> mainmenulist = new ArrayList<>();
        mainmenulist.add(mainmenu);
        JSONArray jsonmainmenuarray = JSONMainmenu.toJSONArray(mainmenulist);
        JSONObject jsonmainmenu = (JSONObject)jsonmainmenuarray.get(0);
        mainmenu = JSONMainmenu.toMainmenu(jsonmainmenu);
        mainmenu = JSONMainmenu.initMainmenu(jsonmainmenu);
        JSONMainmenu.updateMainmenu(mainmenu, jsonmainmenu);
        Mainmenusearch search = new Mainmenusearch();
        JSONObject jsonsearch = JSONMainmenu.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONMainmenu.toMainmenusearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

