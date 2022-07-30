package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicview.Geometry_columns;
import film.searchentity.Geometry_columnssearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONGeometry_columnsTest {
    
    public JSONGeometry_columnsTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Geometry_columns geometry_columns = new Geometry_columns();
        ArrayList<Geometry_columns> geometry_columnslist = new ArrayList<>();
        geometry_columnslist.add(geometry_columns);
        JSONArray jsongeometry_columnsarray = JSONGeometry_columns.toJSONArray(geometry_columnslist);
        JSONObject jsongeometry_columns = (JSONObject)jsongeometry_columnsarray.get(0);
        geometry_columns = JSONGeometry_columns.toGeometry_columns(jsongeometry_columns);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

