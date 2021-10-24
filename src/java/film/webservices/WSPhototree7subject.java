/*
 * WSPhototree7subject.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 24.9.2021 14:50
 *
 */

package film.webservices;

import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.webservice.WSIPhototree7subject;
import film.logicentity.Phototree7subject;
import film.searchentity.Phototree7subjectsearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIPhototree7subject")
public class WSPhototree7subject implements WSIPhototree7subject {

    private JSONArray toJSONArray(ArrayList phototree7subjects) {
        JSONArray jsonphototree7subjects = new JSONArray();
        Iterator phototree7subjectsI = phototree7subjects.iterator();
        while(phototree7subjectsI.hasNext()) {
            jsonphototree7subjects.add(JSONPhototree7subject.toJSON((Phototree7subject)phototree7subjectsI.next()));
        }
        return jsonphototree7subjects;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getPhototree7subjects")
    @Override
    public String getPhototree7subjects() {
        try {
            BLphototree7subject blphototree7subject = new BLphototree7subject();
            ArrayList phototree7subjects = blphototree7subject.getAll();
            JSONArray jsonphototree7subjects = toJSONArray(phototree7subjects);
            return jsonphototree7subjects.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLphototree7subject blphototree7subject = new BLphototree7subject();
        JSONParser parser = new JSONParser();
        String result = "";
        Phototree7subject phototree7subject;
        try {
            Phototree7subjectsearch phototree7subjectsearch = JSONPhototree7subject.toPhototree7subjectsearch((JSONObject)parser.parse(json));
            ArrayList phototree7subjects = blphototree7subject.search(phototree7subjectsearch);
            JSONArray jsonphototree7subjects = toJSONArray(phototree7subjects);
            result = jsonphototree7subjects.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getPhototree7subject")
    @Override
    public String getPhototree7subject(String json) {
        BLphototree7subject blphototree7subject = new BLphototree7subject();
        JSONParser parser = new JSONParser();
        String result = "";
        Phototree7subject phototree7subject;
        try {
            Phototree7subjectPK phototree7subjectPK = JSONPhototree7subject.toPhototree7subjectPK((JSONObject)parser.parse(json));
            phototree7subject = blphototree7subject.getPhototree7subject(phototree7subjectPK);
            if(phototree7subject!=null) {
                result = JSONPhototree7subject.toJSON(phototree7subject).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertPhototree7subject")
    @Override
    public void insertPhototree7subject(String json) {
        BLphototree7subject blphototree7subject = new BLphototree7subject();
        JSONParser parser = new JSONParser();
        try {
            IPhototree7subject phototree7subject = JSONPhototree7subject.toPhototree7subject((JSONObject)parser.parse(json));
            blphototree7subject.insertPhototree7subject(phototree7subject);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updatePhototree7subject")
    @Override
    public void updatePhototree7subject(String json) {
        BLphototree7subject blphototree7subject = new BLphototree7subject();
        JSONParser parser = new JSONParser();
        try {
            IPhototree7subject phototree7subject = JSONPhototree7subject.toPhototree7subject((JSONObject)parser.parse(json));
            blphototree7subject.updatePhototree7subject(phototree7subject);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deletePhototree7subject")
    @Override
    public void deletePhototree7subject(String json) {
        BLphototree7subject blphototree7subject = new BLphototree7subject();
        JSONParser parser = new JSONParser();
        try {
            IPhototree7subject phototree7subject = JSONPhototree7subject.toPhototree7subject((JSONObject)parser.parse(json));
            blphototree7subject.deletePhototree7subject(phototree7subject);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getPhototree7subjects4tree7subject")
    @Override
    public String getPhototree7subjects4tree7subject(String json) {
        BLphototree7subject blphototree7subject = new BLphototree7subject();
        JSONParser parser = new JSONParser();
        Phototree7subject phototree7subject;
        try {
            ITree7subjectPK tree7subjectPK = JSONTree7subject.toTree7subjectPK((JSONObject)parser.parse(json));
            ArrayList phototree7subjects = blphototree7subject.getPhototree7subjects4tree7subject(tree7subjectPK);
            JSONArray jsonphototree7subjects = toJSONArray(phototree7subjects);
            return jsonphototree7subjects.toJSONString();
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

    //@WebMethod(operationName = "delete4tree7subject")
    @Override
    public void delete4tree7subject(String json) {
        BLphototree7subject blphototree7subject = new BLphototree7subject();
        JSONParser parser = new JSONParser();
        Phototree7subject phototree7subject;
        try {
            ITree7subjectPK tree7subjectPK = JSONTree7subject.toTree7subjectPK((JSONObject)parser.parse(json));
            blphototree7subject.delete4tree7subject(tree7subjectPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getPhototree7subjects4photo")
    @Override
    public String getPhototree7subjects4photo(String json) {
        BLphototree7subject blphototree7subject = new BLphototree7subject();
        JSONParser parser = new JSONParser();
        Phototree7subject phototree7subject;
        try {
            IPhotoPK photoPK = JSONPhoto.toPhotoPK((JSONObject)parser.parse(json));
            ArrayList phototree7subjects = blphototree7subject.getPhototree7subjects4photo(photoPK);
            JSONArray jsonphototree7subjects = toJSONArray(phototree7subjects);
            return jsonphototree7subjects.toJSONString();
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

    //@WebMethod(operationName = "delete4photo")
    @Override
    public void delete4photo(String json) {
        BLphototree7subject blphototree7subject = new BLphototree7subject();
        JSONParser parser = new JSONParser();
        Phototree7subject phototree7subject;
        try {
            IPhotoPK photoPK = JSONPhoto.toPhotoPK((JSONObject)parser.parse(json));
            blphototree7subject.delete4photo(photoPK);
        }
        catch(ParseException e) {
        }
    }


}

