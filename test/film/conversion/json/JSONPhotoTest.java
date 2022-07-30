package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Photo;
import film.searchentity.Photosearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONPhotoTest {
    
    public JSONPhotoTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Photo photo = new Photo();
        ArrayList<Photo> photolist = new ArrayList<>();
        photolist.add(photo);
        JSONArray jsonphotoarray = JSONPhoto.toJSONArray(photolist);
        JSONObject jsonphoto = (JSONObject)jsonphotoarray.get(0);
        photo = JSONPhoto.toPhoto(jsonphoto);
        photo = JSONPhoto.initPhoto(jsonphoto);
        JSONPhoto.updatePhoto(photo, jsonphoto);
        Photosearch search = new Photosearch();
        JSONObject jsonsearch = JSONPhoto.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONPhoto.toPhotosearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

