/*
 * WSSubject.java
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
import film.interfaces.searchentity.ISubjectsearch;
import film.interfaces.webservice.WSISubject;
import film.logicentity.Subject;
import film.searchentity.Subjectsearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSISubject")
public class WSSubject extends RS_json_login implements WSISubject {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList subjects) {
        JSONArray jsonsubjects = new JSONArray();
        Iterator subjectsI = subjects.iterator();
        while(subjectsI.hasNext()) {
            jsonsubjects.add(JSONSubject.toJSON((Subject)subjectsI.next()));
        }
        return jsonsubjects;
    }

    //@WebMethod(operationName = "getSubjects")
    @Override
    public String getSubjects() {
        try {
            Subject_usecases subjectusecases = new Subject_usecases(loggedin);
            return get_all_subject(subjectusecases);
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
            Subject_usecases subjectusecases = new Subject_usecases(loggedin);
            return search_subject(subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getSubject")
    @Override
    public String getSubject(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Subject_usecases subjectusecases = new Subject_usecases(loggedin);
            return get_subject_with_primarykey(subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertSubject")
    @Override
    public void insertSubject(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Subject_usecases subjectusecases = new Subject_usecases(loggedin);
            insert_subject(subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateSubject")
    @Override
    public void updateSubject(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Subject_usecases subjectusecases = new Subject_usecases(loggedin);
            update_subject(subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteSubject")
    @Override
    public void deleteSubject(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Subject_usecases subjectusecases = new Subject_usecases(loggedin);
            delete_subject(subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSubjects4subjectcatCat1")
    @Override
    public String getSubjects4subjectcatCat1(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Subject_usecases subjectusecases = new Subject_usecases(loggedin);
            return get_subject_with_foreignkey_subjectcatCat1(subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4subjectcatCat1")
    @Override
    public void delete4subjectcatCat1(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Subject_usecases subjectusecases = new Subject_usecases(loggedin);
            delete_subject(subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSubjects4tree7subject")
    @Override
    public String getSubjects4tree7subject(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Subject_usecases subjectusecases = new Subject_usecases(loggedin);
            return get_subject_with_foreignkey_tree7subject(subjectusecases, json);
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
            Subject_usecases subjectusecases = new Subject_usecases(loggedin);
            delete_subject(subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSubjects4subjectcatCat2")
    @Override
    public String getSubjects4subjectcatCat2(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Subject_usecases subjectusecases = new Subject_usecases(loggedin);
            return get_subject_with_foreignkey_subjectcatCat2(subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4subjectcatCat2")
    @Override
    public void delete4subjectcatCat2(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Subject_usecases subjectusecases = new Subject_usecases(loggedin);
            delete_subject(subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSubjects4filmsubjects")
    @Override
    public String getSubjects4filmsubjects(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Subject_usecases subjectusecases = new Subject_usecases(loggedin);
            return get_subject_with_externalforeignkey_filmsubjects(subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getSubjects4photosubjects")
    @Override
    public String getSubjects4photosubjects(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Subject_usecases subjectusecases = new Subject_usecases(loggedin);
            return get_subject_with_externalforeignkey_photosubjects(subjectusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


    private String count_records(Subject_usecases subjectusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", subjectusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_subject(Subject_usecases subjectusecases) throws ParseException, CustomException {
    	return JSONSubject.toJSONArray(subjectusecases.get_all()).toJSONString();
    }
    
    private String get_subject_with_primarykey(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectPK subjectPK = (ISubjectPK)JSONSubject.toSubjectPK((JSONObject)json.get("subjectpk"));
	return JSONSubject.toJSON(subjectusecases.get_subject_by_primarykey(subjectPK)).toJSONString();
    }
    
    private String get_subject_with_foreignkey_subjectcatCat1(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectcatPK subjectcatCat1PK = (ISubjectcatPK)JSONSubjectcat.toSubjectcatPK((JSONObject)json.get("subjectcatpk"));
        return JSONSubject.toJSONArray(subjectusecases.get_subject_with_foreignkey_subjectcatCat1(subjectcatCat1PK)).toJSONString();
    }
    
    private String get_subject_with_foreignkey_tree7subject(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        ITree7subjectPK tree7subjectPK = (ITree7subjectPK)JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectpk"));
        return JSONSubject.toJSONArray(subjectusecases.get_subject_with_foreignkey_tree7subject(tree7subjectPK)).toJSONString();
    }
    
    private String get_subject_with_foreignkey_subjectcatCat2(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectcatPK subjectcatCat2PK = (ISubjectcatPK)JSONSubjectcat.toSubjectcatPK((JSONObject)json.get("subjectcatpk"));
        return JSONSubject.toJSONArray(subjectusecases.get_subject_with_foreignkey_subjectcatCat2(subjectcatCat2PK)).toJSONString();
    }
    
    private String get_subject_with_externalforeignkey_filmsubjects(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        IFilmsubjectsPK filmsubjectsPK = (IFilmsubjectsPK)JSONFilmsubjects.toFilmsubjectsPK((JSONObject)json.get("filmsubjectspk"));
        return JSONSubject.toJSON(subjectusecases.get_subject_with_externalforeignkey_filmsubjects(filmsubjectsPK)).toJSONString();
    }
    
    private String get_subject_with_externalforeignkey_photosubjects(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        IPhotosubjectsPK photosubjectsPK = (IPhotosubjectsPK)JSONPhotosubjects.toPhotosubjectsPK((JSONObject)json.get("photosubjectspk"));
        return JSONSubject.toJSON(subjectusecases.get_subject_with_externalforeignkey_photosubjects(photosubjectsPK)).toJSONString();
    }
    
    private String search_subject(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectsearch search = (ISubjectsearch)JSONSubject.toSubjectsearch((JSONObject)json.get("search"));
        return JSONSubject.toJSONArray(subjectusecases.search_subject(search)).toJSONString();
    }
    
    private String search_subject_count(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectsearch subjectsearch = (ISubjectsearch)JSONSubject.toSubjectsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", subjectusecases.search_subject_count(subjectsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_subject(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        ISubject subject = (ISubject)JSONSubject.toSubject((JSONObject)json.get("subject"));
        subjectusecases.insertSubject(subject);
        setReturnstatus("OK");
    }

    private void update_subject(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        ISubject subject = (ISubject)JSONSubject.toSubject((JSONObject)json.get("subject"));
        subjectusecases.updateSubject(subject);
        setReturnstatus("OK");
    }

    private void delete_subject(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        ISubject subject = (ISubject)JSONSubject.toSubject((JSONObject)json.get("subject"));
        subjectusecases.deleteSubject(subject);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Subjectcatcat1(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectcatPK subjectcatCat1PK = (ISubjectcatPK)JSONSubjectcat.toSubjectcatPK((JSONObject)json.get("subjectcatpk"));
        subjectusecases.delete_all_containing_Subjectcatcat1(subjectcatCat1PK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Tree7subject(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        ITree7subjectPK tree7subjectPK = (ITree7subjectPK)JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectpk"));
        subjectusecases.delete_all_containing_Tree7subject(tree7subjectPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Subjectcatcat2(Subject_usecases subjectusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectcatPK subjectcatCat2PK = (ISubjectcatPK)JSONSubjectcat.toSubjectcatPK((JSONObject)json.get("subjectcatpk"));
        subjectusecases.delete_all_containing_Subjectcatcat2(subjectcatCat2PK);
        setReturnstatus("OK");
    }

}

