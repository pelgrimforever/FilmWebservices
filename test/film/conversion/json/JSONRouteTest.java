package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Route;
import film.searchentity.Routesearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONRouteTest {
    
    public JSONRouteTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Route route = new Route();
        ArrayList<Route> routelist = new ArrayList<>();
        routelist.add(route);
        JSONArray jsonroutearray = JSONRoute.toJSONArray(routelist);
        JSONObject jsonroute = (JSONObject)jsonroutearray.get(0);
        route = JSONRoute.toRoute(jsonroute);
        route = JSONRoute.initRoute(jsonroute);
        JSONRoute.updateRoute(route, jsonroute);
        Routesearch search = new Routesearch();
        JSONObject jsonsearch = JSONRoute.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONRoute.toRoutesearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

