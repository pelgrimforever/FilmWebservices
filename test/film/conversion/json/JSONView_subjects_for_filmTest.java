package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicview.View_subjects_for_film;
import film.searchentity.View_subjects_for_filmsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONView_subjects_for_filmTest {
    
    public JSONView_subjects_for_filmTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        View_subjects_for_film view_subjects_for_film = new View_subjects_for_film();
        ArrayList<View_subjects_for_film> view_subjects_for_filmlist = new ArrayList<>();
        view_subjects_for_filmlist.add(view_subjects_for_film);
        JSONArray jsonview_subjects_for_filmarray = JSONView_subjects_for_film.toJSONArray(view_subjects_for_filmlist);
        JSONObject jsonview_subjects_for_film = (JSONObject)jsonview_subjects_for_filmarray.get(0);
        view_subjects_for_film = JSONView_subjects_for_film.toView_subjects_for_film(jsonview_subjects_for_film);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

