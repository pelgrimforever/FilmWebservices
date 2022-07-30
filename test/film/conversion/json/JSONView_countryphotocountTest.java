package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicview.View_countryphotocount;
import film.searchentity.View_countryphotocountsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_countryphotocountTest {
    
    public JSONView_countryphotocountTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_countryphotocount view_countryphotocount = new View_countryphotocount();
        ArrayList<View_countryphotocount> view_countryphotocountlist = new ArrayList<>();
        view_countryphotocountlist.add(view_countryphotocount);
        JSONArray jsonview_countryphotocountarray = JSONView_countryphotocount.toJSONArray(view_countryphotocountlist);
        JSONObject jsonview_countryphotocount = (JSONObject)jsonview_countryphotocountarray.get(0);
        view_countryphotocount = JSONView_countryphotocount.toView_countryphotocount(jsonview_countryphotocount);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

