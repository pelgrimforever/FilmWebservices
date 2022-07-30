package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicview.View_publiclocalityphotocount;
import film.searchentity.View_publiclocalityphotocountsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_publiclocalityphotocountTest {
    
    public JSONView_publiclocalityphotocountTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_publiclocalityphotocount view_publiclocalityphotocount = new View_publiclocalityphotocount();
        ArrayList<View_publiclocalityphotocount> view_publiclocalityphotocountlist = new ArrayList<>();
        view_publiclocalityphotocountlist.add(view_publiclocalityphotocount);
        JSONArray jsonview_publiclocalityphotocountarray = JSONView_publiclocalityphotocount.toJSONArray(view_publiclocalityphotocountlist);
        JSONObject jsonview_publiclocalityphotocount = (JSONObject)jsonview_publiclocalityphotocountarray.get(0);
        view_publiclocalityphotocount = JSONView_publiclocalityphotocount.toView_publiclocalityphotocount(jsonview_publiclocalityphotocount);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

