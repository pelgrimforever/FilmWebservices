package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicview.View_locationtree;
import film.searchentity.View_locationtreesearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_locationtreeTest {
    
    public JSONView_locationtreeTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_locationtree view_locationtree = new View_locationtree();
        ArrayList<View_locationtree> view_locationtreelist = new ArrayList<>();
        view_locationtreelist.add(view_locationtree);
        JSONArray jsonview_locationtreearray = JSONView_locationtree.toJSONArray(view_locationtreelist);
        JSONObject jsonview_locationtree = (JSONObject)jsonview_locationtreearray.get(0);
        view_locationtree = JSONView_locationtree.toView_locationtree(jsonview_locationtree);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

