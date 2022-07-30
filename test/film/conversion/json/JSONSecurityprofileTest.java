package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Securityprofile;
import film.searchentity.Securityprofilesearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONSecurityprofileTest {
    
    public JSONSecurityprofileTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Securityprofile securityprofile = new Securityprofile();
        ArrayList<Securityprofile> securityprofilelist = new ArrayList<>();
        securityprofilelist.add(securityprofile);
        JSONArray jsonsecurityprofilearray = JSONSecurityprofile.toJSONArray(securityprofilelist);
        JSONObject jsonsecurityprofile = (JSONObject)jsonsecurityprofilearray.get(0);
        securityprofile = JSONSecurityprofile.toSecurityprofile(jsonsecurityprofile);
        securityprofile = JSONSecurityprofile.initSecurityprofile(jsonsecurityprofile);
        JSONSecurityprofile.updateSecurityprofile(securityprofile, jsonsecurityprofile);
        Securityprofilesearch search = new Securityprofilesearch();
        JSONObject jsonsearch = JSONSecurityprofile.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONSecurityprofile.toSecurityprofilesearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

