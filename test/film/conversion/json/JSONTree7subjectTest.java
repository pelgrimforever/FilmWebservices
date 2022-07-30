package film.conversion.json;

import data.conversion.JSONConversion;
import film.logicentity.Tree7subject;
import film.searchentity.Tree7subjectsearch;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.*;

/**
 * @author Franky Laseure
 */
public class JSONTree7subjectTest {
    
    public JSONTree7subjectTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void test_defaultfunctionality_for_exceptions() {
        Tree7subject tree7subject = new Tree7subject();
        ArrayList<Tree7subject> tree7subjectlist = new ArrayList<>();
        tree7subjectlist.add(tree7subject);
        JSONArray jsontree7subjectarray = JSONTree7subject.toJSONArray(tree7subjectlist);
        JSONObject jsontree7subject = (JSONObject)jsontree7subjectarray.get(0);
        tree7subject = JSONTree7subject.toTree7subject(jsontree7subject);
        tree7subject = JSONTree7subject.initTree7subject(jsontree7subject);
        JSONTree7subject.updateTree7subject(tree7subject, jsontree7subject);
        Tree7subjectsearch search = new Tree7subjectsearch();
        JSONObject jsonsearch = JSONTree7subject.toJSON(search);
        jsonsearch.put("andor", 0);
        jsonsearch.put("maxresults", 0);
        jsonsearch.put("docount", false);
        jsonsearch.put("primarykeys", new JSONArray());
        jsonsearch.put("fields", new JSONObject());
        jsonsearch.put("keysearch", new JSONObject());
        search = JSONTree7subject.toTree7subjectsearch(jsonsearch);
    }
    
//Custom code, do not change this line
//Custom code, do not change this line
}

