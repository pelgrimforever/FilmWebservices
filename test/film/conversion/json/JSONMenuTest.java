package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Menu;
import film.searchentity.Menusearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONMenuTest {
    
    public JSONMenuTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Menu menu = new Menu();
        ArrayList<Menu> menulist = new ArrayList<>();
        menulist.add(menu);
        JSONArray jsonmenuarray = JSONMenu.toJSONArray(menulist);
        JSONObject jsonmenu = (JSONObject)jsonmenuarray.get(0);
        menu = JSONMenu.toMenu(jsonmenu);
        menu = JSONMenu.initMenu(jsonmenu);
        JSONMenu.updateMenu(menu, jsonmenu);
        Menusearch search = new Menusearch();
        JSONObject jsonsearch = JSONMenu.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONMenu.toMenusearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

