package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicview.View_locality_photolocations;
import film.searchentity.View_locality_photolocationssearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_locality_photolocationsTest {
    
    public JSONView_locality_photolocationsTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_locality_photolocations view_locality_photolocations = new View_locality_photolocations();
        ArrayList<View_locality_photolocations> view_locality_photolocationslist = new ArrayList<>();
        view_locality_photolocationslist.add(view_locality_photolocations);
        JSONArray jsonview_locality_photolocationsarray = JSONView_locality_photolocations.toJSONArray(view_locality_photolocationslist);
        JSONObject jsonview_locality_photolocations = (JSONObject)jsonview_locality_photolocationsarray.get(0);
        view_locality_photolocations = JSONView_locality_photolocations.toView_locality_photolocations(jsonview_locality_photolocations);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

