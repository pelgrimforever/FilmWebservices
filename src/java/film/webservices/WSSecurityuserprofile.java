/*
 * WSSecurityuserprofile.java
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
import film.interfaces.searchentity.ISecurityuserprofilesearch;
import film.interfaces.webservice.WSISecurityuserprofile;
import film.logicentity.Securityuserprofile;
import film.searchentity.Securityuserprofilesearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSISecurityuserprofile")
public class WSSecurityuserprofile extends RS_json_login implements WSISecurityuserprofile {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList securityuserprofiles) {
        JSONArray jsonsecurityuserprofiles = new JSONArray();
        Iterator securityuserprofilesI = securityuserprofiles.iterator();
        while(securityuserprofilesI.hasNext()) {
            jsonsecurityuserprofiles.add(JSONSecurityuserprofile.toJSON((Securityuserprofile)securityuserprofilesI.next()));
        }
        return jsonsecurityuserprofiles;
    }

    //@WebMethod(operationName = "getSecurityuserprofiles")
    @Override
    public String getSecurityuserprofiles() {
        try {
            Securityuserprofile_usecases securityuserprofileusecases = new Securityuserprofile_usecases(loggedin);
            return get_all_securityuserprofile(securityuserprofileusecases);
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
            Securityuserprofile_usecases securityuserprofileusecases = new Securityuserprofile_usecases(loggedin);
            return search_securityuserprofile(securityuserprofileusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getSecurityuserprofile")
    @Override
    public String getSecurityuserprofile(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Securityuserprofile_usecases securityuserprofileusecases = new Securityuserprofile_usecases(loggedin);
            return get_securityuserprofile_with_primarykey(securityuserprofileusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertSecurityuserprofile")
    @Override
    public void insertSecurityuserprofile(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Securityuserprofile_usecases securityuserprofileusecases = new Securityuserprofile_usecases(loggedin);
            insert_securityuserprofile(securityuserprofileusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateSecurityuserprofile")
    @Override
    public void updateSecurityuserprofile(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Securityuserprofile_usecases securityuserprofileusecases = new Securityuserprofile_usecases(loggedin);
            update_securityuserprofile(securityuserprofileusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteSecurityuserprofile")
    @Override
    public void deleteSecurityuserprofile(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Securityuserprofile_usecases securityuserprofileusecases = new Securityuserprofile_usecases(loggedin);
            delete_securityuserprofile(securityuserprofileusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSecurityuserprofiles4securityprofile")
    @Override
    public String getSecurityuserprofiles4securityprofile(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Securityuserprofile_usecases securityuserprofileusecases = new Securityuserprofile_usecases(loggedin);
            return get_securityuserprofile_with_foreignkey_securityprofile(securityuserprofileusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4securityprofile")
    @Override
    public void delete4securityprofile(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Securityuserprofile_usecases securityuserprofileusecases = new Securityuserprofile_usecases(loggedin);
            delete_securityuserprofile(securityuserprofileusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Securityuserprofile_usecases securityuserprofileusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", securityuserprofileusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_securityuserprofile(Securityuserprofile_usecases securityuserprofileusecases) throws ParseException, CustomException {
    	return JSONSecurityuserprofile.toJSONArray(securityuserprofileusecases.get_all()).toJSONString();
    }
    
    private String get_securityuserprofile_with_primarykey(Securityuserprofile_usecases securityuserprofileusecases, JSONObject json) throws ParseException, CustomException {
        ISecurityuserprofilePK securityuserprofilePK = (ISecurityuserprofilePK)JSONSecurityuserprofile.toSecurityuserprofilePK((JSONObject)json.get("securityuserprofilepk"));
	return JSONSecurityuserprofile.toJSON(securityuserprofileusecases.get_securityuserprofile_by_primarykey(securityuserprofilePK)).toJSONString();
    }
    
    private String get_securityuserprofile_with_foreignkey_securityprofile(Securityuserprofile_usecases securityuserprofileusecases, JSONObject json) throws ParseException, CustomException {
        ISecurityprofilePK securityprofilePK = (ISecurityprofilePK)JSONSecurityprofile.toSecurityprofilePK((JSONObject)json.get("securityprofilepk"));
        return JSONSecurityuserprofile.toJSONArray(securityuserprofileusecases.get_securityuserprofile_with_foreignkey_securityprofile(securityprofilePK)).toJSONString();
    }
    
    private String search_securityuserprofile(Securityuserprofile_usecases securityuserprofileusecases, JSONObject json) throws ParseException, CustomException {
        ISecurityuserprofilesearch search = (ISecurityuserprofilesearch)JSONSecurityuserprofile.toSecurityuserprofilesearch((JSONObject)json.get("search"));
        return JSONSecurityuserprofile.toJSONArray(securityuserprofileusecases.search_securityuserprofile(search)).toJSONString();
    }
    
    private String search_securityuserprofile_count(Securityuserprofile_usecases securityuserprofileusecases, JSONObject json) throws ParseException, CustomException {
        ISecurityuserprofilesearch securityuserprofilesearch = (ISecurityuserprofilesearch)JSONSecurityuserprofile.toSecurityuserprofilesearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", securityuserprofileusecases.search_securityuserprofile_count(securityuserprofilesearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_securityuserprofile(Securityuserprofile_usecases securityuserprofileusecases, JSONObject json) throws ParseException, CustomException {
        ISecurityuserprofile securityuserprofile = (ISecurityuserprofile)JSONSecurityuserprofile.toSecurityuserprofile((JSONObject)json.get("securityuserprofile"));
        securityuserprofileusecases.insertSecurityuserprofile(securityuserprofile);
        setReturnstatus("OK");
    }

    private void update_securityuserprofile(Securityuserprofile_usecases securityuserprofileusecases, JSONObject json) throws ParseException, CustomException {
        ISecurityuserprofile securityuserprofile = (ISecurityuserprofile)JSONSecurityuserprofile.toSecurityuserprofile((JSONObject)json.get("securityuserprofile"));
        securityuserprofileusecases.updateSecurityuserprofile(securityuserprofile);
        setReturnstatus("OK");
    }

    private void delete_securityuserprofile(Securityuserprofile_usecases securityuserprofileusecases, JSONObject json) throws ParseException, CustomException {
        ISecurityuserprofile securityuserprofile = (ISecurityuserprofile)JSONSecurityuserprofile.toSecurityuserprofile((JSONObject)json.get("securityuserprofile"));
        securityuserprofileusecases.deleteSecurityuserprofile(securityuserprofile);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Securityprofile(Securityuserprofile_usecases securityuserprofileusecases, JSONObject json) throws ParseException, CustomException {
        ISecurityprofilePK securityprofilePK = (ISecurityprofilePK)JSONSecurityprofile.toSecurityprofilePK((JSONObject)json.get("securityprofilepk"));
        securityuserprofileusecases.delete_all_containing_Securityprofile(securityprofilePK);
        setReturnstatus("OK");
    }

}

