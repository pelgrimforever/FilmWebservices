package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Securityuserprofile;
import film.searchentity.Securityuserprofilesearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONSecurityuserprofileTest {
    
    public JSONSecurityuserprofileTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Securityuserprofile securityuserprofile = new Securityuserprofile();
        ArrayList<Securityuserprofile> securityuserprofilelist = new ArrayList<>();
        securityuserprofilelist.add(securityuserprofile);
        JSONArray jsonsecurityuserprofilearray = JSONSecurityuserprofile.toJSONArray(securityuserprofilelist);
        JSONObject jsonsecurityuserprofile = (JSONObject)jsonsecurityuserprofilearray.get(0);
        securityuserprofile = JSONSecurityuserprofile.toSecurityuserprofile(jsonsecurityuserprofile);
        securityuserprofile = JSONSecurityuserprofile.initSecurityuserprofile(jsonsecurityuserprofile);
        JSONSecurityuserprofile.updateSecurityuserprofile(securityuserprofile, jsonsecurityuserprofile);
        Securityuserprofilesearch search = new Securityuserprofilesearch();
        JSONObject jsonsearch = JSONSecurityuserprofile.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONSecurityuserprofile.toSecurityuserprofilesearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

