package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Film;
import film.searchentity.Filmsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONFilmTest {
    
    public JSONFilmTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Film film = new Film();
        ArrayList<Film> filmlist = new ArrayList<>();
        filmlist.add(film);
        JSONArray jsonfilmarray = JSONFilm.toJSONArray(filmlist);
        JSONObject jsonfilm = (JSONObject)jsonfilmarray.get(0);
        film = JSONFilm.toFilm(jsonfilm);
        film = JSONFilm.initFilm(jsonfilm);
        JSONFilm.updateFilm(film, jsonfilm);
        Filmsearch search = new Filmsearch();
        JSONObject jsonsearch = JSONFilm.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONFilm.toFilmsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

