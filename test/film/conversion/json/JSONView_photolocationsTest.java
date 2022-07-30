package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicview.View_photolocations;
import film.searchentity.View_photolocationssearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_photolocationsTest {
    
    public JSONView_photolocationsTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_photolocations view_photolocations = new View_photolocations();
        ArrayList<View_photolocations> view_photolocationslist = new ArrayList<>();
        view_photolocationslist.add(view_photolocations);
        JSONArray jsonview_photolocationsarray = JSONView_photolocations.toJSONArray(view_photolocationslist);
        JSONObject jsonview_photolocations = (JSONObject)jsonview_photolocationsarray.get(0);
        view_photolocations = JSONView_photolocations.toView_photolocations(jsonview_photolocations);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

