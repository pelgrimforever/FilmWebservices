/*
 * WSPhototree7subject.java
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
import film.interfaces.searchentity.IPhototree7subjectsearch;
import film.interfaces.webservice.WSIPhototree7subject;
import film.logicentity.Phototree7subject;
import film.searchentity.Phototree7subjectsearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIPhototree7subject")
public class WSPhototree7subject extends RS_json_login implements WSIPhototree7subject {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList phototree7subjects) {
        JSONArray jsonphototree7subjects = new JSONArray();
        Iterator phototree7subjectsI = phototree7subjects.iterator();
        while(phototree7subjectsI.hasNext()) {
            jsonphototree7subjects.add(JSONPhototree7subject.toJSON((Phototree7subject)phototree7subjectsI.next()));
        }
        return jsonphototree7subjects;
    }

    //@WebMethod(operationName = "getPhototree7subjects")
    @Override
    public String getPhototree7subjects() {
        try {
            Phototree7subject_usecases phototree7subjectusecases = new Phototree7subject_usecases(loggedin);
            return get_all_phototree7subject(phototree7subjectusecases);
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
            Phototree7subject_usecases phototree7subjectusecases = new Phototree7subject_usecases(loggedin);
            return search_phototree7subject(phototree7subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getPhototree7subject")
    @Override
    public String getPhototree7subject(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Phototree7subject_usecases phototree7subjectusecases = new Phototree7subject_usecases(loggedin);
            return get_phototree7subject_with_primarykey(phototree7subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertPhototree7subject")
    @Override
    public void insertPhototree7subject(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Phototree7subject_usecases phototree7subjectusecases = new Phototree7subject_usecases(loggedin);
            insert_phototree7subject(phototree7subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updatePhototree7subject")
    @Override
    public void updatePhototree7subject(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Phototree7subject_usecases phototree7subjectusecases = new Phototree7subject_usecases(loggedin);
            update_phototree7subject(phototree7subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deletePhototree7subject")
    @Override
    public void deletePhototree7subject(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Phototree7subject_usecases phototree7subjectusecases = new Phototree7subject_usecases(loggedin);
            delete_phototree7subject(phototree7subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getPhototree7subjects4tree7subject")
    @Override
    public String getPhototree7subjects4tree7subject(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Phototree7subject_usecases phototree7subjectusecases = new Phototree7subject_usecases(loggedin);
            return get_phototree7subject_with_foreignkey_tree7subject(phototree7subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4tree7subject")
    @Override
    public void delete4tree7subject(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Phototree7subject_usecases phototree7subjectusecases = new Phototree7subject_usecases(loggedin);
            delete_phototree7subject(phototree7subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getPhototree7subjects4photo")
    @Override
    public String getPhototree7subjects4photo(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Phototree7subject_usecases phototree7subjectusecases = new Phototree7subject_usecases(loggedin);
            return get_phototree7subject_with_foreignkey_photo(phototree7subjectusecases, json);
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
            Phototree7subject_usecases phototree7subjectusecases = new Phototree7subject_usecases(loggedin);
            delete_phototree7subject(phototree7subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Phototree7subject_usecases phototree7subjectusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", phototree7subjectusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_phototree7subject(Phototree7subject_usecases phototree7subjectusecases) throws ParseException, CustomException {
    	return JSONPhototree7subject.toJSONArray(phototree7subjectusecases.get_all()).toJSONString();
    }
    
    private String get_phototree7subject_with_primarykey(Phototree7subject_usecases phototree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        IPhototree7subjectPK phototree7subjectPK = (IPhototree7subjectPK)JSONPhototree7subject.toPhototree7subjectPK((JSONObject)json.get("phototree7subjectpk"));
	return JSONPhototree7subject.toJSON(phototree7subjectusecases.get_phototree7subject_by_primarykey(phototree7subjectPK)).toJSONString();
    }
    
    private String get_phototree7subject_with_foreignkey_tree7subject(Phototree7subject_usecases phototree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        ITree7subjectPK tree7subjectPK = (ITree7subjectPK)JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectpk"));
        return JSONPhototree7subject.toJSONArray(phototree7subjectusecases.get_phototree7subject_with_foreignkey_tree7subject(tree7subjectPK)).toJSONString();
    }
    
    private String get_phototree7subject_with_foreignkey_photo(Phototree7subject_usecases phototree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        IPhotoPK photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
        return JSONPhototree7subject.toJSONArray(phototree7subjectusecases.get_phototree7subject_with_foreignkey_photo(photoPK)).toJSONString();
    }
    
    private String search_phototree7subject(Phototree7subject_usecases phototree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        IPhototree7subjectsearch search = (IPhototree7subjectsearch)JSONPhototree7subject.toPhototree7subjectsearch((JSONObject)json.get("search"));
        return JSONPhototree7subject.toJSONArray(phototree7subjectusecases.search_phototree7subject(search)).toJSONString();
    }
    
    private String search_phototree7subject_count(Phototree7subject_usecases phototree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        IPhototree7subjectsearch phototree7subjectsearch = (IPhototree7subjectsearch)JSONPhototree7subject.toPhototree7subjectsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", phototree7subjectusecases.search_phototree7subject_count(phototree7subjectsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_phototree7subject(Phototree7subject_usecases phototree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        IPhototree7subject phototree7subject = (IPhototree7subject)JSONPhototree7subject.toPhototree7subject((JSONObject)json.get("phototree7subject"));
        phototree7subjectusecases.insertPhototree7subject(phototree7subject);
        setReturnstatus("OK");
    }

    private void update_phototree7subject(Phototree7subject_usecases phototree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        IPhototree7subject phototree7subject = (IPhototree7subject)JSONPhototree7subject.toPhototree7subject((JSONObject)json.get("phototree7subject"));
        phototree7subjectusecases.updatePhototree7subject(phototree7subject);
        setReturnstatus("OK");
    }

    private void delete_phototree7subject(Phototree7subject_usecases phototree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        IPhototree7subject phototree7subject = (IPhototree7subject)JSONPhototree7subject.toPhototree7subject((JSONObject)json.get("phototree7subject"));
        phototree7subjectusecases.deletePhototree7subject(phototree7subject);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Tree7subject(Phototree7subject_usecases phototree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        ITree7subjectPK tree7subjectPK = (ITree7subjectPK)JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectpk"));
        phototree7subjectusecases.delete_all_containing_Tree7subject(tree7subjectPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Photo(Phototree7subject_usecases phototree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        IPhotoPK photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
        phototree7subjectusecases.delete_all_containing_Photo(photoPK);
        setReturnstatus("OK");
    }

}

