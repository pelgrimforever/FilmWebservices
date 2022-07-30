package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Art_photo;
import film.searchentity.Art_photosearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONArt_photoTest {
    
    public JSONArt_photoTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Art_photo art_photo = new Art_photo();
        ArrayList<Art_photo> art_photolist = new ArrayList<>();
        art_photolist.add(art_photo);
        JSONArray jsonart_photoarray = JSONArt_photo.toJSONArray(art_photolist);
        JSONObject jsonart_photo = (JSONObject)jsonart_photoarray.get(0);
        art_photo = JSONArt_photo.toArt_photo(jsonart_photo);
        art_photo = JSONArt_photo.initArt_photo(jsonart_photo);
        JSONArt_photo.updateArt_photo(art_photo, jsonart_photo);
        Art_photosearch search = new Art_photosearch();
        JSONObject jsonsearch = JSONArt_photo.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONArt_photo.toArt_photosearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

