/*
 * WSFilmsubjects.java
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
import film.interfaces.searchentity.IFilmsubjectssearch;
import film.interfaces.webservice.WSIFilmsubjects;
import film.logicentity.Filmsubjects;
import film.searchentity.Filmsubjectssearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIFilmsubjects")
public class WSFilmsubjects extends RS_json_login implements WSIFilmsubjects {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList filmsubjectss) {
        JSONArray jsonfilmsubjectss = new JSONArray();
        Iterator filmsubjectssI = filmsubjectss.iterator();
        while(filmsubjectssI.hasNext()) {
            jsonfilmsubjectss.add(JSONFilmsubjects.toJSON((Filmsubjects)filmsubjectssI.next()));
        }
        return jsonfilmsubjectss;
    }

    //@WebMethod(operationName = "getFilmsubjectss")
    @Override
    public String getFilmsubjectss() {
        try {
            Filmsubjects_usecases filmsubjectsusecases = new Filmsubjects_usecases(loggedin);
            return get_all_filmsubjects(filmsubjectsusecases);
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
            Filmsubjects_usecases filmsubjectsusecases = new Filmsubjects_usecases(loggedin);
            return search_filmsubjects(filmsubjectsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getFilmsubjects")
    @Override
    public String getFilmsubjects(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Filmsubjects_usecases filmsubjectsusecases = new Filmsubjects_usecases(loggedin);
            return get_filmsubjects_with_primarykey(filmsubjectsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertFilmsubjects")
    @Override
    public void insertFilmsubjects(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Filmsubjects_usecases filmsubjectsusecases = new Filmsubjects_usecases(loggedin);
            insert_filmsubjects(filmsubjectsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateFilmsubjects")
    @Override
    public void updateFilmsubjects(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Filmsubjects_usecases filmsubjectsusecases = new Filmsubjects_usecases(loggedin);
            update_filmsubjects(filmsubjectsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteFilmsubjects")
    @Override
    public void deleteFilmsubjects(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Filmsubjects_usecases filmsubjectsusecases = new Filmsubjects_usecases(loggedin);
            delete_filmsubjects(filmsubjectsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getFilmsubjectss4subject")
    @Override
    public String getFilmsubjectss4subject(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Filmsubjects_usecases filmsubjectsusecases = new Filmsubjects_usecases(loggedin);
            return get_filmsubjects_with_foreignkey_subject(filmsubjectsusecases, json);
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
            Filmsubjects_usecases filmsubjectsusecases = new Filmsubjects_usecases(loggedin);
            delete_filmsubjects(filmsubjectsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getFilmsubjectss4film")
    @Override
    public String getFilmsubjectss4film(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Filmsubjects_usecases filmsubjectsusecases = new Filmsubjects_usecases(loggedin);
            return get_filmsubjects_with_foreignkey_film(filmsubjectsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4film")
    @Override
    public void delete4film(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Filmsubjects_usecases filmsubjectsusecases = new Filmsubjects_usecases(loggedin);
            delete_filmsubjects(filmsubjectsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Filmsubjects_usecases filmsubjectsusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", filmsubjectsusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_filmsubjects(Filmsubjects_usecases filmsubjectsusecases) throws ParseException, CustomException {
    	return JSONFilmsubjects.toJSONArray(filmsubjectsusecases.get_all()).toJSONString();
    }
    
    private String get_filmsubjects_with_primarykey(Filmsubjects_usecases filmsubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IFilmsubjectsPK filmsubjectsPK = (IFilmsubjectsPK)JSONFilmsubjects.toFilmsubjectsPK((JSONObject)json.get("filmsubjectspk"));
	return JSONFilmsubjects.toJSON(filmsubjectsusecases.get_filmsubjects_by_primarykey(filmsubjectsPK)).toJSONString();
    }
    
    private String get_filmsubjects_with_foreignkey_subject(Filmsubjects_usecases filmsubjectsusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectPK subjectPK = (ISubjectPK)JSONSubject.toSubjectPK((JSONObject)json.get("subjectpk"));
        return JSONFilmsubjects.toJSONArray(filmsubjectsusecases.get_filmsubjects_with_foreignkey_subject(subjectPK)).toJSONString();
    }
    
    private String get_filmsubjects_with_foreignkey_film(Filmsubjects_usecases filmsubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IFilmPK filmPK = (IFilmPK)JSONFilm.toFilmPK((JSONObject)json.get("filmpk"));
        return JSONFilmsubjects.toJSONArray(filmsubjectsusecases.get_filmsubjects_with_foreignkey_film(filmPK)).toJSONString();
    }
    
    private String search_filmsubjects(Filmsubjects_usecases filmsubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IFilmsubjectssearch search = (IFilmsubjectssearch)JSONFilmsubjects.toFilmsubjectssearch((JSONObject)json.get("search"));
        return JSONFilmsubjects.toJSONArray(filmsubjectsusecases.search_filmsubjects(search)).toJSONString();
    }
    
    private String search_filmsubjects_count(Filmsubjects_usecases filmsubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IFilmsubjectssearch filmsubjectssearch = (IFilmsubjectssearch)JSONFilmsubjects.toFilmsubjectssearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", filmsubjectsusecases.search_filmsubjects_count(filmsubjectssearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_filmsubjects(Filmsubjects_usecases filmsubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IFilmsubjects filmsubjects = (IFilmsubjects)JSONFilmsubjects.toFilmsubjects((JSONObject)json.get("filmsubjects"));
        filmsubjectsusecases.insertFilmsubjects(filmsubjects);
        setReturnstatus("OK");
    }

    private void update_filmsubjects(Filmsubjects_usecases filmsubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IFilmsubjects filmsubjects = (IFilmsubjects)JSONFilmsubjects.toFilmsubjects((JSONObject)json.get("filmsubjects"));
        filmsubjectsusecases.updateFilmsubjects(filmsubjects);
        setReturnstatus("OK");
    }

    private void delete_filmsubjects(Filmsubjects_usecases filmsubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IFilmsubjects filmsubjects = (IFilmsubjects)JSONFilmsubjects.toFilmsubjects((JSONObject)json.get("filmsubjects"));
        filmsubjectsusecases.deleteFilmsubjects(filmsubjects);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Subject(Filmsubjects_usecases filmsubjectsusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectPK subjectPK = (ISubjectPK)JSONSubject.toSubjectPK((JSONObject)json.get("subjectpk"));
        filmsubjectsusecases.delete_all_containing_Subject(subjectPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Film(Filmsubjects_usecases filmsubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IFilmPK filmPK = (IFilmPK)JSONFilm.toFilmPK((JSONObject)json.get("filmpk"));
        filmsubjectsusecases.delete_all_containing_Film(filmPK);
        setReturnstatus("OK");
    }

}

