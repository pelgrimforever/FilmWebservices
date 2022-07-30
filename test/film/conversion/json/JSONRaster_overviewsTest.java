package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicview.Raster_overviews;
import film.searchentity.Raster_overviewssearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONRaster_overviewsTest {
    
    public JSONRaster_overviewsTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Raster_overviews raster_overviews = new Raster_overviews();
        ArrayList<Raster_overviews> raster_overviewslist = new ArrayList<>();
        raster_overviewslist.add(raster_overviews);
        JSONArray jsonraster_overviewsarray = JSONRaster_overviews.toJSONArray(raster_overviewslist);
        JSONObject jsonraster_overviews = (JSONObject)jsonraster_overviewsarray.get(0);
        raster_overviews = JSONRaster_overviews.toRaster_overviews(jsonraster_overviews);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

