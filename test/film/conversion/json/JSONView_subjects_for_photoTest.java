package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicview.View_subjects_for_photo;
import film.searchentity.View_subjects_for_photosearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_subjects_for_photoTest {
    
    public JSONView_subjects_for_photoTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_subjects_for_photo view_subjects_for_photo = new View_subjects_for_photo();
        ArrayList<View_subjects_for_photo> view_subjects_for_photolist = new ArrayList<>();
        view_subjects_for_photolist.add(view_subjects_for_photo);
        JSONArray jsonview_subjects_for_photoarray = JSONView_subjects_for_photo.toJSONArray(view_subjects_for_photolist);
        JSONObject jsonview_subjects_for_photo = (JSONObject)jsonview_subjects_for_photoarray.get(0);
        view_subjects_for_photo = JSONView_subjects_for_photo.toView_subjects_for_photo(jsonview_subjects_for_photo);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

