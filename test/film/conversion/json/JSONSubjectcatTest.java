package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Subjectcat;
import film.searchentity.Subjectcatsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONSubjectcatTest {
    
    public JSONSubjectcatTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Subjectcat subjectcat = new Subjectcat();
        ArrayList<Subjectcat> subjectcatlist = new ArrayList<>();
        subjectcatlist.add(subjectcat);
        JSONArray jsonsubjectcatarray = JSONSubjectcat.toJSONArray(subjectcatlist);
        JSONObject jsonsubjectcat = (JSONObject)jsonsubjectcatarray.get(0);
        subjectcat = JSONSubjectcat.toSubjectcat(jsonsubjectcat);
        subjectcat = JSONSubjectcat.initSubjectcat(jsonsubjectcat);
        JSONSubjectcat.updateSubjectcat(subjectcat, jsonsubjectcat);
        Subjectcatsearch search = new Subjectcatsearch();
        JSONObject jsonsearch = JSONSubjectcat.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONSubjectcat.toSubjectcatsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

