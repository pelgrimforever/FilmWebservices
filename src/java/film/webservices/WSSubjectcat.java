/*
 * WSSubjectcat.java
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
import film.interfaces.webservice.WSISubjectcat;
import film.logicentity.Subjectcat;
import film.searchentity.Subjectcatsearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSISubjectcat")
public class WSSubjectcat implements WSISubjectcat {

    private JSONArray toJSONArray(ArrayList subjectcats) {
        JSONArray jsonsubjectcats = new JSONArray();
        Iterator subjectcatsI = subjectcats.iterator();
        while(subjectcatsI.hasNext()) {
            jsonsubjectcats.add(JSONSubjectcat.toJSON((Subjectcat)subjectcatsI.next()));
        }
        return jsonsubjectcats;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getSubjectcats")
    @Override
    public String getSubjectcats() {
        try {
            BLsubjectcat blsubjectcat = new BLsubjectcat();
            ArrayList subjectcats = blsubjectcat.getAll();
            JSONArray jsonsubjectcats = toJSONArray(subjectcats);
            return jsonsubjectcats.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLsubjectcat blsubjectcat = new BLsubjectcat();
        JSONParser parser = new JSONParser();
        String result = "";
        Subjectcat subjectcat;
        try {
            Subjectcatsearch subjectcatsearch = JSONSubjectcat.toSubjectcatsearch((JSONObject)parser.parse(json));
            ArrayList subjectcats = blsubjectcat.search(subjectcatsearch);
            JSONArray jsonsubjectcats = toJSONArray(subjectcats);
            result = jsonsubjectcats.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getSubjectcat")
    @Override
    public String getSubjectcat(String json) {
        BLsubjectcat blsubjectcat = new BLsubjectcat();
        JSONParser parser = new JSONParser();
        String result = "";
        Subjectcat subjectcat;
        try {
            SubjectcatPK subjectcatPK = JSONSubjectcat.toSubjectcatPK((JSONObject)parser.parse(json));
            subjectcat = blsubjectcat.getSubjectcat(subjectcatPK);
            if(subjectcat!=null) {
                result = JSONSubjectcat.toJSON(subjectcat).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertSubjectcat")
    @Override
    public void insertSubjectcat(String json) {
        BLsubjectcat blsubjectcat = new BLsubjectcat();
        JSONParser parser = new JSONParser();
        try {
            ISubjectcat subjectcat = JSONSubjectcat.toSubjectcat((JSONObject)parser.parse(json));
            blsubjectcat.insertSubjectcat(subjectcat);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateSubjectcat")
    @Override
    public void updateSubjectcat(String json) {
        BLsubjectcat blsubjectcat = new BLsubjectcat();
        JSONParser parser = new JSONParser();
        try {
            ISubjectcat subjectcat = JSONSubjectcat.toSubjectcat((JSONObject)parser.parse(json));
            blsubjectcat.updateSubjectcat(subjectcat);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteSubjectcat")
    @Override
    public void deleteSubjectcat(String json) {
        BLsubjectcat blsubjectcat = new BLsubjectcat();
        JSONParser parser = new JSONParser();
        try {
            ISubjectcat subjectcat = JSONSubjectcat.toSubjectcat((JSONObject)parser.parse(json));
            blsubjectcat.deleteSubjectcat(subjectcat);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getSubjectcats4subjectCat1")
    @Override
    public String getSubjectcats4subjectCat1(String json) {
        BLsubjectcat blsubjectcat = new BLsubjectcat();
        JSONParser parser = new JSONParser();
        Subjectcat subjectcat;
        try {
            String result = null;
            ISubjectPK subjectCat1PK = JSONSubject.toSubjectPK((JSONObject)parser.parse(json));
            subjectcat = (Subjectcat)blsubjectcat.getSubjectcat1(subjectCat1PK);
            if(subjectcat!=null) {
                result = JSONSubjectcat.toJSON(subjectcat).toJSONString();
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

    //@WebMethod(operationName = "getSubjectcats4subjectCat2")
    @Override
    public String getSubjectcats4subjectCat2(String json) {
        BLsubjectcat blsubjectcat = new BLsubjectcat();
        JSONParser parser = new JSONParser();
        Subjectcat subjectcat;
        try {
            String result = null;
            ISubjectPK subjectCat2PK = JSONSubject.toSubjectPK((JSONObject)parser.parse(json));
            subjectcat = (Subjectcat)blsubjectcat.getSubjectcat2(subjectCat2PK);
            if(subjectcat!=null) {
                result = JSONSubjectcat.toJSON(subjectcat).toJSONString();
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

