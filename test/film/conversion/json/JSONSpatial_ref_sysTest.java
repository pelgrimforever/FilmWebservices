package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Spatial_ref_sys;
import film.searchentity.Spatial_ref_syssearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONSpatial_ref_sysTest {
    
    public JSONSpatial_ref_sysTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Spatial_ref_sys spatial_ref_sys = new Spatial_ref_sys();
        ArrayList<Spatial_ref_sys> spatial_ref_syslist = new ArrayList<>();
        spatial_ref_syslist.add(spatial_ref_sys);
        JSONArray jsonspatial_ref_sysarray = JSONSpatial_ref_sys.toJSONArray(spatial_ref_syslist);
        JSONObject jsonspatial_ref_sys = (JSONObject)jsonspatial_ref_sysarray.get(0);
        spatial_ref_sys = JSONSpatial_ref_sys.toSpatial_ref_sys(jsonspatial_ref_sys);
        spatial_ref_sys = JSONSpatial_ref_sys.initSpatial_ref_sys(jsonspatial_ref_sys);
        JSONSpatial_ref_sys.updateSpatial_ref_sys(spatial_ref_sys, jsonspatial_ref_sys);
        Spatial_ref_syssearch search = new Spatial_ref_syssearch();
        JSONObject jsonsearch = JSONSpatial_ref_sys.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONSpatial_ref_sys.toSpatial_ref_syssearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

