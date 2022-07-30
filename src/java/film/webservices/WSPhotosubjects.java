/*
 * WSPhotosubjects.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 27.6.2022 16:45
 *
 */

package film.webservices;

import base.restservices.RS_json_login;
import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.IPhotosubjectssearch;
import film.interfaces.webservice.WSIPhotosubjects;
import film.logicentity.Photosubjects;
import film.searchentity.Photosubjectssearch;
import film.usecases.*;
import general.exception.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import film.usecases.custom.Security_usecases;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "film.interfaces.webservice.WSIPhotosubjects")
public class WSPhotosubjects extends RS_json_login implements WSIPhotosubjects {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList photosubjectss) {
        JSONArray jsonphotosubjectss = new JSONArray();
        Iterator photosubjectssI = photosubjectss.iterator();
        while(photosubjectssI.hasNext()) {
            jsonphotosubjectss.add(JSONPhotosubjects.toJSON((Photosubjects)photosubjectssI.next()));
        }
        return jsonphotosubjectss;
    }

    //@WebMethod(operationName = "getPhotosubjectss")
    @Override
    public String getPhotosubjectss() {
        try {
            Photosubjects_usecases photosubjectsusecases = new Photosubjects_usecases(loggedin);
            return get_all_photosubjects(photosubjectsusecases);
        }
        catch(CustomException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photosubjects_usecases photosubjectsusecases = new Photosubjects_usecases(loggedin);
            return search_photosubjects(photosubjectsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getPhotosubjects")
    @Override
    public String getPhotosubjects(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photosubjects_usecases photosubjectsusecases = new Photosubjects_usecases(loggedin);
            return get_photosubjects_with_primarykey(photosubjectsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertPhotosubjects")
    @Override
    public void insertPhotosubjects(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photosubjects_usecases photosubjectsusecases = new Photosubjects_usecases(loggedin);
            insert_photosubjects(photosubjectsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updatePhotosubjects")
    @Override
    public void updatePhotosubjects(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photosubjects_usecases photosubjectsusecases = new Photosubjects_usecases(loggedin);
            update_photosubjects(photosubjectsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deletePhotosubjects")
    @Override
    public void deletePhotosubjects(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photosubjects_usecases photosubjectsusecases = new Photosubjects_usecases(loggedin);
            delete_photosubjects(photosubjectsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getPhotosubjectss4photo")
    @Override
    public String getPhotosubjectss4photo(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photosubjects_usecases photosubjectsusecases = new Photosubjects_usecases(loggedin);
            return get_photosubjects_with_foreignkey_photo(photosubjectsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4photo")
    @Override
    public void delete4photo(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photosubjects_usecases photosubjectsusecases = new Photosubjects_usecases(loggedin);
            delete_photosubjects(photosubjectsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getPhotosubjectss4subject")
    @Override
    public String getPhotosubjectss4subject(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photosubjects_usecases photosubjectsusecases = new Photosubjects_usecases(loggedin);
            return get_photosubjects_with_foreignkey_subject(photosubjectsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4subject")
    @Override
    public void delete4subject(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photosubjects_usecases photosubjectsusecases = new Photosubjects_usecases(loggedin);
            delete_photosubjects(photosubjectsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Photosubjects_usecases photosubjectsusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", photosubjectsusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_photosubjects(Photosubjects_usecases photosubjectsusecases) throws ParseException, CustomException {
    	return JSONPhotosubjects.toJSONArray(photosubjectsusecases.get_all()).toJSONString();
    }
    
    private String get_photosubjects_with_primarykey(Photosubjects_usecases photosubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IPhotosubjectsPK photosubjectsPK = (IPhotosubjectsPK)JSONPhotosubjects.toPhotosubjectsPK((JSONObject)json.get("photosubjectspk"));
	return JSONPhotosubjects.toJSON(photosubjectsusecases.get_photosubjects_by_primarykey(photosubjectsPK)).toJSONString();
    }
    
    private String get_photosubjects_with_foreignkey_photo(Photosubjects_usecases photosubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IPhotoPK photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
        return JSONPhotosubjects.toJSONArray(photosubjectsusecases.get_photosubjects_with_foreignkey_photo(photoPK)).toJSONString();
    }
    
    private String get_photosubjects_with_foreignkey_subject(Photosubjects_usecases photosubjectsusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectPK subjectPK = (ISubjectPK)JSONSubject.toSubjectPK((JSONObject)json.get("subjectpk"));
        return JSONPhotosubjects.toJSONArray(photosubjectsusecases.get_photosubjects_with_foreignkey_subject(subjectPK)).toJSONString();
    }
    
    private String search_photosubjects(Photosubjects_usecases photosubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IPhotosubjectssearch search = (IPhotosubjectssearch)JSONPhotosubjects.toPhotosubjectssearch((JSONObject)json.get("search"));
        return JSONPhotosubjects.toJSONArray(photosubjectsusecases.search_photosubjects(search)).toJSONString();
    }
    
    private String search_photosubjects_count(Photosubjects_usecases photosubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IPhotosubjectssearch photosubjectssearch = (IPhotosubjectssearch)JSONPhotosubjects.toPhotosubjectssearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", photosubjectsusecases.search_photosubjects_count(photosubjectssearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_photosubjects(Photosubjects_usecases photosubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IPhotosubjects photosubjects = (IPhotosubjects)JSONPhotosubjects.toPhotosubjects((JSONObject)json.get("photosubjects"));
        photosubjectsusecases.insertPhotosubjects(photosubjects);
        setReturnstatus("OK");
    }

    private void update_photosubjects(Photosubjects_usecases photosubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IPhotosubjects photosubjects = (IPhotosubjects)JSONPhotosubjects.toPhotosubjects((JSONObject)json.get("photosubjects"));
        photosubjectsusecases.updatePhotosubjects(photosubjects);
        setReturnstatus("OK");
    }

    private void delete_photosubjects(Photosubjects_usecases photosubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IPhotosubjects photosubjects = (IPhotosubjects)JSONPhotosubjects.toPhotosubjects((JSONObject)json.get("photosubjects"));
        photosubjectsusecases.deletePhotosubjects(photosubjects);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Photo(Photosubjects_usecases photosubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IPhotoPK photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
        photosubjectsusecases.delete_all_containing_Photo(photoPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Subject(Photosubjects_usecases photosubjectsusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectPK subjectPK = (ISubjectPK)JSONSubject.toSubjectPK((JSONObject)json.get("subjectpk"));
        photosubjectsusecases.delete_all_containing_Subject(subjectPK);
        setReturnstatus("OK");
    }

}

