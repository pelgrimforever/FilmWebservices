package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicview.View_publicphotolocations;
import film.searchentity.View_publicphotolocationssearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_publicphotolocationsTest {
    
    public JSONView_publicphotolocationsTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_publicphotolocations view_publicphotolocations = new View_publicphotolocations();
        ArrayList<View_publicphotolocations> view_publicphotolocationslist = new ArrayList<>();
        view_publicphotolocationslist.add(view_publicphotolocations);
        JSONArray jsonview_publicphotolocationsarray = JSONView_publicphotolocations.toJSONArray(view_publicphotolocationslist);
        JSONObject jsonview_publicphotolocations = (JSONObject)jsonview_publicphotolocationsarray.get(0);
        view_publicphotolocations = JSONView_publicphotolocations.toView_publicphotolocations(jsonview_publicphotolocations);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

