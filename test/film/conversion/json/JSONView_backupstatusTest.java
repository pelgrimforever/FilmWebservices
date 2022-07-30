package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicview.View_backupstatus;
import film.searchentity.View_backupstatussearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_backupstatusTest {
    
    public JSONView_backupstatusTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_backupstatus view_backupstatus = new View_backupstatus();
        ArrayList<View_backupstatus> view_backupstatuslist = new ArrayList<>();
        view_backupstatuslist.add(view_backupstatus);
        JSONArray jsonview_backupstatusarray = JSONView_backupstatus.toJSONArray(view_backupstatuslist);
        JSONObject jsonview_backupstatus = (JSONObject)jsonview_backupstatusarray.get(0);
        view_backupstatus = JSONView_backupstatus.toView_backupstatus(jsonview_backupstatus);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

