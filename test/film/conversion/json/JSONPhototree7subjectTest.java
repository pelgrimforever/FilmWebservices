package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Phototree7subject;
import film.searchentity.Phototree7subjectsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONPhototree7subjectTest {
    
    public JSONPhototree7subjectTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Phototree7subject phototree7subject = new Phototree7subject();
        ArrayList<Phototree7subject> phototree7subjectlist = new ArrayList<>();
        phototree7subjectlist.add(phototree7subject);
        JSONArray jsonphototree7subjectarray = JSONPhototree7subject.toJSONArray(phototree7subjectlist);
        JSONObject jsonphototree7subject = (JSONObject)jsonphototree7subjectarray.get(0);
        phototree7subject = JSONPhototree7subject.toPhototree7subject(jsonphototree7subject);
        phototree7subject = JSONPhototree7subject.initPhototree7subject(jsonphototree7subject);
        JSONPhototree7subject.updatePhototree7subject(phototree7subject, jsonphototree7subject);
        Phototree7subjectsearch search = new Phototree7subjectsearch();
        JSONObject jsonsearch = JSONPhototree7subject.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONPhototree7subject.toPhototree7subjectsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

