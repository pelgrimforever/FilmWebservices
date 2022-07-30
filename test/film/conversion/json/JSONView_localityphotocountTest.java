package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicview.View_localityphotocount;
import film.searchentity.View_localityphotocountsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_localityphotocountTest {
    
    public JSONView_localityphotocountTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_localityphotocount view_localityphotocount = new View_localityphotocount();
        ArrayList<View_localityphotocount> view_localityphotocountlist = new ArrayList<>();
        view_localityphotocountlist.add(view_localityphotocount);
        JSONArray jsonview_localityphotocountarray = JSONView_localityphotocount.toJSONArray(view_localityphotocountlist);
        JSONObject jsonview_localityphotocount = (JSONObject)jsonview_localityphotocountarray.get(0);
        view_localityphotocount = JSONView_localityphotocount.toView_localityphotocount(jsonview_localityphotocount);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

