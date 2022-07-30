package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicview.Geography_columns;
import film.searchentity.Geography_columnssearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONGeography_columnsTest {
    
    public JSONGeography_columnsTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Geography_columns geography_columns = new Geography_columns();
        ArrayList<Geography_columns> geography_columnslist = new ArrayList<>();
        geography_columnslist.add(geography_columns);
        JSONArray jsongeography_columnsarray = JSONGeography_columns.toJSONArray(geography_columnslist);
        JSONObject jsongeography_columns = (JSONObject)jsongeography_columnsarray.get(0);
        geography_columns = JSONGeography_columns.toGeography_columns(jsongeography_columns);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

