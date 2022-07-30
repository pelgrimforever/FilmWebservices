package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicview.Raster_columns;
import film.searchentity.Raster_columnssearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONRaster_columnsTest {
    
    public JSONRaster_columnsTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Raster_columns raster_columns = new Raster_columns();
        ArrayList<Raster_columns> raster_columnslist = new ArrayList<>();
        raster_columnslist.add(raster_columns);
        JSONArray jsonraster_columnsarray = JSONRaster_columns.toJSONArray(raster_columnslist);
        JSONObject jsonraster_columns = (JSONObject)jsonraster_columnsarray.get(0);
        raster_columns = JSONRaster_columns.toRaster_columns(jsonraster_columns);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

