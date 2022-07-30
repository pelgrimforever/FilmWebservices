package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Filmtype;
import film.searchentity.Filmtypesearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONFilmtypeTest {
    
    public JSONFilmtypeTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Filmtype filmtype = new Filmtype();
        ArrayList<Filmtype> filmtypelist = new ArrayList<>();
        filmtypelist.add(filmtype);
        JSONArray jsonfilmtypearray = JSONFilmtype.toJSONArray(filmtypelist);
        JSONObject jsonfilmtype = (JSONObject)jsonfilmtypearray.get(0);
        filmtype = JSONFilmtype.toFilmtype(jsonfilmtype);
        filmtype = JSONFilmtype.initFilmtype(jsonfilmtype);
        JSONFilmtype.updateFilmtype(filmtype, jsonfilmtype);
        Filmtypesearch search = new Filmtypesearch();
        JSONObject jsonsearch = JSONFilmtype.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONFilmtype.toFilmtypesearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

