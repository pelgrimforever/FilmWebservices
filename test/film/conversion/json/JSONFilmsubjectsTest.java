package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Filmsubjects;
import film.searchentity.Filmsubjectssearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONFilmsubjectsTest {
    
    public JSONFilmsubjectsTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Filmsubjects filmsubjects = new Filmsubjects();
        ArrayList<Filmsubjects> filmsubjectslist = new ArrayList<>();
        filmsubjectslist.add(filmsubjects);
        JSONArray jsonfilmsubjectsarray = JSONFilmsubjects.toJSONArray(filmsubjectslist);
        JSONObject jsonfilmsubjects = (JSONObject)jsonfilmsubjectsarray.get(0);
        filmsubjects = JSONFilmsubjects.toFilmsubjects(jsonfilmsubjects);
        filmsubjects = JSONFilmsubjects.initFilmsubjects(jsonfilmsubjects);
        JSONFilmsubjects.updateFilmsubjects(filmsubjects, jsonfilmsubjects);
        Filmsubjectssearch search = new Filmsubjectssearch();
        JSONObject jsonsearch = JSONFilmsubjects.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONFilmsubjects.toFilmsubjectssearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

