/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.webservices;

import base.restservices.RS_json_login;
import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.ISubjectcatsearch;
import film.interfaces.webservice.WSISubjectcat;
import film.logicentity.Subjectcat;
import film.searchentity.Subjectcatsearch;
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

@WebService(endpointInterface = "film.interfaces.webservice.WSISubjectcat")
public class WSSubjectcat extends RS_json_login implements WSISubjectcat {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList subjectcats) {
        JSONArray jsonsubjectcats = new JSONArray();
        Iterator subjectcatsI = subjectcats.iterator();
        while(subjectcatsI.hasNext()) {
            jsonsubjectcats.add(JSONSubjectcat.toJSON((Subjectcat)subjectcatsI.next()));
        }
        return jsonsubjectcats;
    }

    //@WebMethod(operationName = "getSubjectcats")
    @Override
    public String getSubjectcats() {
        try {
            Subjectcat_usecases subjectcatusecases = new Subjectcat_usecases(loggedin);
            return get_all_subjectcat(subjectcatusecases);
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
            Subjectcat_usecases subjectcatusecases = new Subjectcat_usecases(loggedin);
            return search_subjectcat(subjectcatusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getSubjectcat")
    @Override
    public String getSubjectcat(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Subjectcat_usecases subjectcatusecases = new Subjectcat_usecases(loggedin);
            return get_subjectcat_with_primarykey(subjectcatusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertSubjectcat")
    @Override
    public void insertSubjectcat(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Subjectcat_usecases subjectcatusecases = new Subjectcat_usecases(loggedin);
            insert_subjectcat(subjectcatusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateSubjectcat")
    @Override
    public void updateSubjectcat(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Subjectcat_usecases subjectcatusecases = new Subjectcat_usecases(loggedin);
            update_subjectcat(subjectcatusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteSubjectcat")
    @Override
    public void deleteSubjectcat(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Subjectcat_usecases subjectcatusecases = new Subjectcat_usecases(loggedin);
            delete_subjectcat(subjectcatusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSubjectcats4subjectCat1")
    @Override
    public String getSubjectcats4subjectCat1(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Subjectcat_usecases subjectcatusecases = new Subjectcat_usecases(loggedin);
            return get_subjectcat_with_externalforeignkey_subjectCat1(subjectcatusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getSubjectcats4subjectCat2")
    @Override
    public String getSubjectcats4subjectCat2(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Subjectcat_usecases subjectcatusecases = new Subjectcat_usecases(loggedin);
            return get_subjectcat_with_externalforeignkey_subjectCat2(subjectcatusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


    private String count_records(Subjectcat_usecases subjectcatusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", subjectcatusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_subjectcat(Subjectcat_usecases subjectcatusecases) throws ParseException, CustomException {
    	return JSONSubjectcat.toJSONArray(subjectcatusecases.get_all()).toJSONString();
    }
    
    private String get_subjectcat_with_primarykey(Subjectcat_usecases subjectcatusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectcatPK subjectcatPK = (ISubjectcatPK)JSONSubjectcat.toSubjectcatPK((JSONObject)json.get("subjectcatpk"));
	return JSONSubjectcat.toJSON(subjectcatusecases.get_subjectcat_by_primarykey(subjectcatPK)).toJSONString();
    }
    
    private String get_subjectcat_with_externalforeignkey_subjectCat1(Subjectcat_usecases subjectcatusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectPK subjectCat1PK = (ISubjectPK)JSONSubject.toSubjectPK((JSONObject)json.get("subjectpk"));
        return JSONSubjectcat.toJSON(subjectcatusecases.get_subjectcat_with_externalforeignkey_subjectCat1(subjectCat1PK)).toJSONString();
    }
    
    private String get_subjectcat_with_externalforeignkey_subjectCat2(Subjectcat_usecases subjectcatusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectPK subjectCat2PK = (ISubjectPK)JSONSubject.toSubjectPK((JSONObject)json.get("subjectpk"));
        return JSONSubjectcat.toJSON(subjectcatusecases.get_subjectcat_with_externalforeignkey_subjectCat2(subjectCat2PK)).toJSONString();
    }
    
    private String search_subjectcat(Subjectcat_usecases subjectcatusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectcatsearch search = (ISubjectcatsearch)JSONSubjectcat.toSubjectcatsearch((JSONObject)json.get("search"));
        return JSONSubjectcat.toJSONArray(subjectcatusecases.search_subjectcat(search)).toJSONString();
    }
    
    private String search_subjectcat_count(Subjectcat_usecases subjectcatusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectcatsearch subjectcatsearch = (ISubjectcatsearch)JSONSubjectcat.toSubjectcatsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", subjectcatusecases.search_subjectcat_count(subjectcatsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_subjectcat(Subjectcat_usecases subjectcatusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectcat subjectcat = (ISubjectcat)JSONSubjectcat.toSubjectcat((JSONObject)json.get("subjectcat"));
        subjectcatusecases.insertSubjectcat(subjectcat);
        setReturnstatus("OK");
    }

    private void update_subjectcat(Subjectcat_usecases subjectcatusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectcat subjectcat = (ISubjectcat)JSONSubjectcat.toSubjectcat((JSONObject)json.get("subjectcat"));
        subjectcatusecases.updateSubjectcat(subjectcat);
        setReturnstatus("OK");
    }

    private void delete_subjectcat(Subjectcat_usecases subjectcatusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectcat subjectcat = (ISubjectcat)JSONSubjectcat.toSubjectcat((JSONObject)json.get("subjectcat"));
        subjectcatusecases.deleteSubjectcat(subjectcat);
        setReturnstatus("OK");
    }

}

