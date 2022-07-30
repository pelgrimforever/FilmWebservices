package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicview.View_photo_firstlastdate;
import film.searchentity.View_photo_firstlastdatesearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_photo_firstlastdateTest {
    
    public JSONView_photo_firstlastdateTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_photo_firstlastdate view_photo_firstlastdate = new View_photo_firstlastdate();
        ArrayList<View_photo_firstlastdate> view_photo_firstlastdatelist = new ArrayList<>();
        view_photo_firstlastdatelist.add(view_photo_firstlastdate);
        JSONArray jsonview_photo_firstlastdatearray = JSONView_photo_firstlastdate.toJSONArray(view_photo_firstlastdatelist);
        JSONObject jsonview_photo_firstlastdate = (JSONObject)jsonview_photo_firstlastdatearray.get(0);
        view_photo_firstlastdate = JSONView_photo_firstlastdate.toView_photo_firstlastdate(jsonview_photo_firstlastdate);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

