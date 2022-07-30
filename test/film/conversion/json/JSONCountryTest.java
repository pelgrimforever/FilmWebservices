package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Country;
import film.searchentity.Countrysearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONCountryTest {
    
    public JSONCountryTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Country country = new Country();
        ArrayList<Country> countrylist = new ArrayList<>();
        countrylist.add(country);
        JSONArray jsoncountryarray = JSONCountry.toJSONArray(countrylist);
        JSONObject jsoncountry = (JSONObject)jsoncountryarray.get(0);
        country = JSONCountry.toCountry(jsoncountry);
        country = JSONCountry.initCountry(jsoncountry);
        JSONCountry.updateCountry(country, jsoncountry);
        Countrysearch search = new Countrysearch();
        JSONObject jsonsearch = JSONCountry.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONCountry.toCountrysearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

