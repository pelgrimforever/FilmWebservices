package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicview.View_publiccountryphotocount;
import film.searchentity.View_publiccountryphotocountsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_publiccountryphotocountTest {
    
    public JSONView_publiccountryphotocountTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_publiccountryphotocount view_publiccountryphotocount = new View_publiccountryphotocount();
        ArrayList<View_publiccountryphotocount> view_publiccountryphotocountlist = new ArrayList<>();
        view_publiccountryphotocountlist.add(view_publiccountryphotocount);
        JSONArray jsonview_publiccountryphotocountarray = JSONView_publiccountryphotocount.toJSONArray(view_publiccountryphotocountlist);
        JSONObject jsonview_publiccountryphotocount = (JSONObject)jsonview_publiccountryphotocountarray.get(0);
        view_publiccountryphotocount = JSONView_publiccountryphotocount.toView_publiccountryphotocount(jsonview_publiccountryphotocount);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

