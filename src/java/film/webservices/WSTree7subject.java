package film.webservices;

import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.webservice.WSITree7subject;
import film.logicentity.Tree7subject;
import film.searchentity.Tree7subjectsearch;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "film.interfaces.webservice.WSITree7subject")
public class WSTree7subject implements WSITree7subject {

    private JSONArray toJSONArray(ArrayList tree7subjects) {
        JSONArray jsontree7subjects = new JSONArray();
        Iterator tree7subjectsI = tree7subjects.iterator();
        while(tree7subjectsI.hasNext()) {
            jsontree7subjects.add(JSONTree7subject.toJSON((Tree7subject)tree7subjectsI.next()));
        }
        return jsontree7subjects;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getTree7subjects")
    @Override
    public String getTree7subjects() {
        try {
            BLtree7subject bltree7subject = new BLtree7subject();
            ArrayList tree7subjects = bltree7subject.getAll();
            JSONArray jsontree7subjects = toJSONArray(tree7subjects);
            return jsontree7subjects.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLtree7subject bltree7subject = new BLtree7subject();
        JSONParser parser = new JSONParser();
        String result = "";
        Tree7subject tree7subject;
        try {
            Tree7subjectsearch tree7subjectsearch = JSONTree7subject.toTree7subjectsearch((JSONObject)parser.parse(json));
            ArrayList tree7subjects = bltree7subject.search(tree7subjectsearch);
            JSONArray jsontree7subjects = toJSONArray(tree7subjects);
            result = jsontree7subjects.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getTree7subject")
    @Override
    public String getTree7subject(String json) {
        BLtree7subject bltree7subject = new BLtree7subject();
        JSONParser parser = new JSONParser();
        String result = "";
        Tree7subject tree7subject;
        try {
            Tree7subjectPK tree7subjectPK = JSONTree7subject.toTree7subjectPK((JSONObject)parser.parse(json));
            tree7subject = bltree7subject.getTree7subject(tree7subjectPK);
            if(tree7subject!=null) {
                result = JSONTree7subject.toJSON(tree7subject).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertTree7subject")
    @Override
    public void insertTree7subject(String json) {
        BLtree7subject bltree7subject = new BLtree7subject();
        JSONParser parser = new JSONParser();
        try {
            ITree7subject tree7subject = JSONTree7subject.toTree7subject((JSONObject)parser.parse(json));
            bltree7subject.insertTree7subject(tree7subject);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateTree7subject")
    @Override
    public void updateTree7subject(String json) {
        BLtree7subject bltree7subject = new BLtree7subject();
        JSONParser parser = new JSONParser();
        try {
            ITree7subject tree7subject = JSONTree7subject.toTree7subject((JSONObject)parser.parse(json));
            bltree7subject.updateTree7subject(tree7subject);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteTree7subject")
    @Override
    public void deleteTree7subject(String json) {
        BLtree7subject bltree7subject = new BLtree7subject();
        JSONParser parser = new JSONParser();
        try {
            ITree7subject tree7subject = JSONTree7subject.toTree7subject((JSONObject)parser.parse(json));
            bltree7subject.deleteTree7subject(tree7subject);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getTree7subjects4tree7subjectParentsubjectid")
    @Override
    public String getTree7subjects4tree7subjectParentsubjectid(String json) {
        BLtree7subject bltree7subject = new BLtree7subject();
        JSONParser parser = new JSONParser();
        Tree7subject tree7subject;
        try {
            ITree7subjectPK tree7subjectParentsubjectidPK = JSONTree7subject.toTree7subjectPK((JSONObject)parser.parse(json));
            ArrayList tree7subjects = bltree7subject.getTree7subjects4tree7subjectParentsubjectid(tree7subjectParentsubjectidPK);
            JSONArray jsontree7subjects = toJSONArray(tree7subjects);
            return jsontree7subjects.toJSONString();
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4tree7subjectParentsubjectid")
    @Override
    public void delete4tree7subjectParentsubjectid(String json) {
        BLtree7subject bltree7subject = new BLtree7subject();
        JSONParser parser = new JSONParser();
        Tree7subject tree7subject;
        try {
            ITree7subjectPK tree7subjectParentsubjectidPK = JSONTree7subject.toTree7subjectPK((JSONObject)parser.parse(json));
            bltree7subject.delete4tree7subjectParentsubjectid(this.getClass().getName(), tree7subjectParentsubjectidPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getTree7subjects4phototree7subject")
    @Override
    public String getTree7subjects4phototree7subject(String json) {
        BLtree7subject bltree7subject = new BLtree7subject();
        JSONParser parser = new JSONParser();
        Tree7subject tree7subject;
        try {
            String result = null;
            IPhototree7subjectPK phototree7subjectPK = JSONPhototree7subject.toPhototree7subjectPK((JSONObject)parser.parse(json));
            tree7subject = (Tree7subject)bltree7subject.getPhototree7subject(phototree7subjectPK);
            if(tree7subject!=null) {
                result = JSONTree7subject.toJSON(tree7subject).toJSONString();
            }
            return result;
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }


}

