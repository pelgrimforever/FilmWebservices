package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Subject;
import film.searchentity.Subjectsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONSubjectTest {
    
    public JSONSubjectTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Subject subject = new Subject();
        ArrayList<Subject> subjectlist = new ArrayList<>();
        subjectlist.add(subject);
        JSONArray jsonsubjectarray = JSONSubject.toJSONArray(subjectlist);
        JSONObject jsonsubject = (JSONObject)jsonsubjectarray.get(0);
        subject = JSONSubject.toSubject(jsonsubject);
        subject = JSONSubject.initSubject(jsonsubject);
        JSONSubject.updateSubject(subject, jsonsubject);
        Subjectsearch search = new Subjectsearch();
        JSONObject jsonsearch = JSONSubject.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONSubject.toSubjectsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

