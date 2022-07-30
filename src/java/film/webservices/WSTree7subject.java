/*
 * WSTree7subject.java
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
import film.interfaces.searchentity.ITree7subjectsearch;
import film.interfaces.webservice.WSITree7subject;
import film.logicentity.Tree7subject;
import film.searchentity.Tree7subjectsearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSITree7subject")
public class WSTree7subject extends RS_json_login implements WSITree7subject {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList tree7subjects) {
        JSONArray jsontree7subjects = new JSONArray();
        Iterator tree7subjectsI = tree7subjects.iterator();
        while(tree7subjectsI.hasNext()) {
            jsontree7subjects.add(JSONTree7subject.toJSON((Tree7subject)tree7subjectsI.next()));
        }
        return jsontree7subjects;
    }

    //@WebMethod(operationName = "getTree7subjects")
    @Override
    public String getTree7subjects() {
        try {
            Tree7subject_usecases tree7subjectusecases = new Tree7subject_usecases(loggedin);
            return get_all_tree7subject(tree7subjectusecases);
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
            Tree7subject_usecases tree7subjectusecases = new Tree7subject_usecases(loggedin);
            return search_tree7subject(tree7subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getTree7subject")
    @Override
    public String getTree7subject(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tree7subject_usecases tree7subjectusecases = new Tree7subject_usecases(loggedin);
            return get_tree7subject_with_primarykey(tree7subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertTree7subject")
    @Override
    public void insertTree7subject(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tree7subject_usecases tree7subjectusecases = new Tree7subject_usecases(loggedin);
            insert_tree7subject(tree7subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateTree7subject")
    @Override
    public void updateTree7subject(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tree7subject_usecases tree7subjectusecases = new Tree7subject_usecases(loggedin);
            update_tree7subject(tree7subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteTree7subject")
    @Override
    public void deleteTree7subject(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tree7subject_usecases tree7subjectusecases = new Tree7subject_usecases(loggedin);
            delete_tree7subject(tree7subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getTree7subjects4tree7subjectParentsubjectid")
    @Override
    public String getTree7subjects4tree7subjectParentsubjectid(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tree7subject_usecases tree7subjectusecases = new Tree7subject_usecases(loggedin);
            return get_tree7subject_with_foreignkey_tree7subjectParentsubjectid(tree7subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4tree7subjectParentsubjectid")
    @Override
    public void delete4tree7subjectParentsubjectid(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tree7subject_usecases tree7subjectusecases = new Tree7subject_usecases(loggedin);
            delete_tree7subject(tree7subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getTree7subjects4phototree7subject")
    @Override
    public String getTree7subjects4phototree7subject(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Tree7subject_usecases tree7subjectusecases = new Tree7subject_usecases(loggedin);
            return get_tree7subject_with_externalforeignkey_phototree7subject(tree7subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


    private String count_records(Tree7subject_usecases tree7subjectusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", tree7subjectusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_tree7subject(Tree7subject_usecases tree7subjectusecases) throws ParseException, CustomException {
    	return JSONTree7subject.toJSONArray(tree7subjectusecases.get_all()).toJSONString();
    }
    
    private String get_tree7subject_with_primarykey(Tree7subject_usecases tree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        ITree7subjectPK tree7subjectPK = (ITree7subjectPK)JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectpk"));
	return JSONTree7subject.toJSON(tree7subjectusecases.get_tree7subject_by_primarykey(tree7subjectPK)).toJSONString();
    }
    
    private String get_tree7subject_with_foreignkey_tree7subjectParentsubjectid(Tree7subject_usecases tree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        ITree7subjectPK tree7subjectParentsubjectidPK = (ITree7subjectPK)JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectpk"));
        return JSONTree7subject.toJSONArray(tree7subjectusecases.get_tree7subject_with_foreignkey_tree7subjectParentsubjectid(tree7subjectParentsubjectidPK)).toJSONString();
    }
    
    private String get_tree7subject_with_externalforeignkey_phototree7subject(Tree7subject_usecases tree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        IPhototree7subjectPK phototree7subjectPK = (IPhototree7subjectPK)JSONPhototree7subject.toPhototree7subjectPK((JSONObject)json.get("phototree7subjectpk"));
        return JSONTree7subject.toJSON(tree7subjectusecases.get_tree7subject_with_externalforeignkey_phototree7subject(phototree7subjectPK)).toJSONString();
    }
    
    private String search_tree7subject(Tree7subject_usecases tree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        ITree7subjectsearch search = (ITree7subjectsearch)JSONTree7subject.toTree7subjectsearch((JSONObject)json.get("search"));
        return JSONTree7subject.toJSONArray(tree7subjectusecases.search_tree7subject(search)).toJSONString();
    }
    
    private String search_tree7subject_count(Tree7subject_usecases tree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        ITree7subjectsearch tree7subjectsearch = (ITree7subjectsearch)JSONTree7subject.toTree7subjectsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", tree7subjectusecases.search_tree7subject_count(tree7subjectsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_tree7subject(Tree7subject_usecases tree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        ITree7subject tree7subject = (ITree7subject)JSONTree7subject.toTree7subject((JSONObject)json.get("tree7subject"));
        tree7subjectusecases.insertTree7subject(tree7subject);
        setReturnstatus("OK");
    }

    private void update_tree7subject(Tree7subject_usecases tree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        ITree7subject tree7subject = (ITree7subject)JSONTree7subject.toTree7subject((JSONObject)json.get("tree7subject"));
        tree7subjectusecases.updateTree7subject(tree7subject);
        setReturnstatus("OK");
    }

    private void delete_tree7subject(Tree7subject_usecases tree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        ITree7subject tree7subject = (ITree7subject)JSONTree7subject.toTree7subject((JSONObject)json.get("tree7subject"));
        tree7subjectusecases.deleteTree7subject(tree7subject);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Tree7subjectparentsubjectid(Tree7subject_usecases tree7subjectusecases, JSONObject json) throws ParseException, CustomException {
        ITree7subjectPK tree7subjectParentsubjectidPK = (ITree7subjectPK)JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectpk"));
        tree7subjectusecases.delete_all_containing_Tree7subjectparentsubjectid(tree7subjectParentsubjectidPK);
        setReturnstatus("OK");
    }

}

