package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicview.View_photodatespublic;
import film.searchentity.View_photodatespublicsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_photodatespublicTest {
    
    public JSONView_photodatespublicTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_photodatespublic view_photodatespublic = new View_photodatespublic();
        ArrayList<View_photodatespublic> view_photodatespubliclist = new ArrayList<>();
        view_photodatespubliclist.add(view_photodatespublic);
        JSONArray jsonview_photodatespublicarray = JSONView_photodatespublic.toJSONArray(view_photodatespubliclist);
        JSONObject jsonview_photodatespublic = (JSONObject)jsonview_photodatespublicarray.get(0);
        view_photodatespublic = JSONView_photodatespublic.toView_photodatespublic(jsonview_photodatespublic);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

