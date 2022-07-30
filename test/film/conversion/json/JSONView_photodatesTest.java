package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicview.View_photodates;
import film.searchentity.View_photodatessearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_photodatesTest {
    
    public JSONView_photodatesTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_photodates view_photodates = new View_photodates();
        ArrayList<View_photodates> view_photodateslist = new ArrayList<>();
        view_photodateslist.add(view_photodates);
        JSONArray jsonview_photodatesarray = JSONView_photodates.toJSONArray(view_photodateslist);
        JSONObject jsonview_photodates = (JSONObject)jsonview_photodatesarray.get(0);
        view_photodates = JSONView_photodates.toView_photodates(jsonview_photodates);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

