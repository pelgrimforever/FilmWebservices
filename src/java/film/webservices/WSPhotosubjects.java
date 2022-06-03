/*
 * WSPhotosubjects.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 *
 */

package film.webservices;

import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.webservice.WSIPhotosubjects;
import film.logicentity.Photosubjects;
import film.searchentity.Photosubjectssearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIPhotosubjects")
public class WSPhotosubjects implements WSIPhotosubjects {

    private JSONArray toJSONArray(ArrayList photosubjectss) {
        JSONArray jsonphotosubjectss = new JSONArray();
        Iterator photosubjectssI = photosubjectss.iterator();
        while(photosubjectssI.hasNext()) {
            jsonphotosubjectss.add(JSONPhotosubjects.toJSON((Photosubjects)photosubjectssI.next()));
        }
        return jsonphotosubjectss;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getPhotosubjectss")
    @Override
    public String getPhotosubjectss() {
        try {
            BLphotosubjects blphotosubjects = new BLphotosubjects();
            ArrayList photosubjectss = blphotosubjects.getAll();
            JSONArray jsonphotosubjectss = toJSONArray(photosubjectss);
            return jsonphotosubjectss.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLphotosubjects blphotosubjects = new BLphotosubjects();
        JSONParser parser = new JSONParser();
        String result = "";
        Photosubjects photosubjects;
        try {
            Photosubjectssearch photosubjectssearch = JSONPhotosubjects.toPhotosubjectssearch((JSONObject)parser.parse(json));
            ArrayList photosubjectss = blphotosubjects.search(photosubjectssearch);
            JSONArray jsonphotosubjectss = toJSONArray(photosubjectss);
            result = jsonphotosubjectss.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getPhotosubjects")
    @Override
    public String getPhotosubjects(String json) {
        BLphotosubjects blphotosubjects = new BLphotosubjects();
        JSONParser parser = new JSONParser();
        String result = "";
        Photosubjects photosubjects;
        try {
            PhotosubjectsPK photosubjectsPK = JSONPhotosubjects.toPhotosubjectsPK((JSONObject)parser.parse(json));
            photosubjects = blphotosubjects.getPhotosubjects(photosubjectsPK);
            if(photosubjects!=null) {
                result = JSONPhotosubjects.toJSON(photosubjects).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertPhotosubjects")
    @Override
    public void insertPhotosubjects(String json) {
        BLphotosubjects blphotosubjects = new BLphotosubjects();
        JSONParser parser = new JSONParser();
        try {
            IPhotosubjects photosubjects = JSONPhotosubjects.toPhotosubjects((JSONObject)parser.parse(json));
            blphotosubjects.insertPhotosubjects(photosubjects);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updatePhotosubjects")
    @Override
    public void updatePhotosubjects(String json) {
        BLphotosubjects blphotosubjects = new BLphotosubjects();
        JSONParser parser = new JSONParser();
        try {
            IPhotosubjects photosubjects = JSONPhotosubjects.toPhotosubjects((JSONObject)parser.parse(json));
            blphotosubjects.updatePhotosubjects(photosubjects);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deletePhotosubjects")
    @Override
    public void deletePhotosubjects(String json) {
        BLphotosubjects blphotosubjects = new BLphotosubjects();
        JSONParser parser = new JSONParser();
        try {
            IPhotosubjects photosubjects = JSONPhotosubjects.toPhotosubjects((JSONObject)parser.parse(json));
            blphotosubjects.deletePhotosubjects(photosubjects);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getPhotosubjectss4photo")
    @Override
    public String getPhotosubjectss4photo(String json) {
        BLphotosubjects blphotosubjects = new BLphotosubjects();
        JSONParser parser = new JSONParser();
        Photosubjects photosubjects;
        try {
            IPhotoPK photoPK = JSONPhoto.toPhotoPK((JSONObject)parser.parse(json));
            ArrayList photosubjectss = blphotosubjects.getPhotosubjectss4photo(photoPK);
            JSONArray jsonphotosubjectss = toJSONArray(photosubjectss);
            return jsonphotosubjectss.toJSONString();
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
        BLphotosubjects blphotosubjects = new BLphotosubjects();
        JSONParser parser = new JSONParser();
        Photosubjects photosubjects;
        try {
            IPhotoPK photoPK = JSONPhoto.toPhotoPK((JSONObject)parser.parse(json));
            blphotosubjects.delete4photo(photoPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getPhotosubjectss4subject")
    @Override
    public String getPhotosubjectss4subject(String json) {
        BLphotosubjects blphotosubjects = new BLphotosubjects();
        JSONParser parser = new JSONParser();
        Photosubjects photosubjects;
        try {
            ISubjectPK subjectPK = JSONSubject.toSubjectPK((JSONObject)parser.parse(json));
            ArrayList photosubjectss = blphotosubjects.getPhotosubjectss4subject(subjectPK);
            JSONArray jsonphotosubjectss = toJSONArray(photosubjectss);
            return jsonphotosubjectss.toJSONString();
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

    //@WebMethod(operationName = "delete4subject")
    @Override
    public void delete4subject(String json) {
        BLphotosubjects blphotosubjects = new BLphotosubjects();
        JSONParser parser = new JSONParser();
        Photosubjects photosubjects;
        try {
            ISubjectPK subjectPK = JSONSubject.toSubjectPK((JSONObject)parser.parse(json));
            blphotosubjects.delete4subject(subjectPK);
        }
        catch(ParseException e) {
        }
    }


}

