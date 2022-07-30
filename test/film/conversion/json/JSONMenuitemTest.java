package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Menuitem;
import film.searchentity.Menuitemsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONMenuitemTest {
    
    public JSONMenuitemTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Menuitem menuitem = new Menuitem();
        ArrayList<Menuitem> menuitemlist = new ArrayList<>();
        menuitemlist.add(menuitem);
        JSONArray jsonmenuitemarray = JSONMenuitem.toJSONArray(menuitemlist);
        JSONObject jsonmenuitem = (JSONObject)jsonmenuitemarray.get(0);
        menuitem = JSONMenuitem.toMenuitem(jsonmenuitem);
        menuitem = JSONMenuitem.initMenuitem(jsonmenuitem);
        JSONMenuitem.updateMenuitem(menuitem, jsonmenuitem);
        Menuitemsearch search = new Menuitemsearch();
        JSONObject jsonsearch = JSONMenuitem.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONMenuitem.toMenuitemsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

