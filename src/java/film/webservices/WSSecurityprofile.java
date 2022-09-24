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
import film.interfaces.searchentity.ISecurityprofilesearch;
import film.interfaces.webservice.WSISecurityprofile;
import film.logicentity.Securityprofile;
import film.searchentity.Securityprofilesearch;
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

@WebService(endpointInterface = "film.interfaces.webservice.WSISecurityprofile")
public class WSSecurityprofile extends RS_json_login implements WSISecurityprofile {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList securityprofiles) {
        JSONArray jsonsecurityprofiles = new JSONArray();
        Iterator securityprofilesI = securityprofiles.iterator();
        while(securityprofilesI.hasNext()) {
            jsonsecurityprofiles.add(JSONSecurityprofile.toJSON((Securityprofile)securityprofilesI.next()));
        }
        return jsonsecurityprofiles;
    }

    //@WebMethod(operationName = "getSecurityprofiles")
    @Override
    public String getSecurityprofiles() {
        try {
            Securityprofile_usecases securityprofileusecases = new Securityprofile_usecases(loggedin);
            return get_all_securityprofile(securityprofileusecases);
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
            Securityprofile_usecases securityprofileusecases = new Securityprofile_usecases(loggedin);
            return search_securityprofile(securityprofileusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getSecurityprofile")
    @Override
    public String getSecurityprofile(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Securityprofile_usecases securityprofileusecases = new Securityprofile_usecases(loggedin);
            return get_securityprofile_with_primarykey(securityprofileusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertSecurityprofile")
    @Override
    public void insertSecurityprofile(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Securityprofile_usecases securityprofileusecases = new Securityprofile_usecases(loggedin);
            insert_securityprofile(securityprofileusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateSecurityprofile")
    @Override
    public void updateSecurityprofile(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Securityprofile_usecases securityprofileusecases = new Securityprofile_usecases(loggedin);
            update_securityprofile(securityprofileusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteSecurityprofile")
    @Override
    public void deleteSecurityprofile(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Securityprofile_usecases securityprofileusecases = new Securityprofile_usecases(loggedin);
            delete_securityprofile(securityprofileusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSecurityprofiles4securityuserprofile")
    @Override
    public String getSecurityprofiles4securityuserprofile(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Securityprofile_usecases securityprofileusecases = new Securityprofile_usecases(loggedin);
            return get_securityprofile_with_externalforeignkey_securityuserprofile(securityprofileusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


    private String count_records(Securityprofile_usecases securityprofileusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", securityprofileusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_securityprofile(Securityprofile_usecases securityprofileusecases) throws ParseException, CustomException {
    	return JSONSecurityprofile.toJSONArray(securityprofileusecases.get_all()).toJSONString();
    }
    
    private String get_securityprofile_with_primarykey(Securityprofile_usecases securityprofileusecases, JSONObject json) throws ParseException, CustomException {
        ISecurityprofilePK securityprofilePK = (ISecurityprofilePK)JSONSecurityprofile.toSecurityprofilePK((JSONObject)json.get("securityprofilepk"));
	return JSONSecurityprofile.toJSON(securityprofileusecases.get_securityprofile_by_primarykey(securityprofilePK)).toJSONString();
    }
    
    private String get_securityprofile_with_externalforeignkey_securityuserprofile(Securityprofile_usecases securityprofileusecases, JSONObject json) throws ParseException, CustomException {
        ISecurityuserprofilePK securityuserprofilePK = (ISecurityuserprofilePK)JSONSecurityuserprofile.toSecurityuserprofilePK((JSONObject)json.get("securityuserprofilepk"));
        return JSONSecurityprofile.toJSON(securityprofileusecases.get_securityprofile_with_externalforeignkey_securityuserprofile(securityuserprofilePK)).toJSONString();
    }
    
    private String search_securityprofile(Securityprofile_usecases securityprofileusecases, JSONObject json) throws ParseException, CustomException {
        ISecurityprofilesearch search = (ISecurityprofilesearch)JSONSecurityprofile.toSecurityprofilesearch((JSONObject)json.get("search"));
        return JSONSecurityprofile.toJSONArray(securityprofileusecases.search_securityprofile(search)).toJSONString();
    }
    
    private String search_securityprofile_count(Securityprofile_usecases securityprofileusecases, JSONObject json) throws ParseException, CustomException {
        ISecurityprofilesearch securityprofilesearch = (ISecurityprofilesearch)JSONSecurityprofile.toSecurityprofilesearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", securityprofileusecases.search_securityprofile_count(securityprofilesearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_securityprofile(Securityprofile_usecases securityprofileusecases, JSONObject json) throws ParseException, CustomException {
        ISecurityprofile securityprofile = (ISecurityprofile)JSONSecurityprofile.toSecurityprofile((JSONObject)json.get("securityprofile"));
        securityprofileusecases.insertSecurityprofile(securityprofile);
        setReturnstatus("OK");
    }

    private void update_securityprofile(Securityprofile_usecases securityprofileusecases, JSONObject json) throws ParseException, CustomException {
        ISecurityprofile securityprofile = (ISecurityprofile)JSONSecurityprofile.toSecurityprofile((JSONObject)json.get("securityprofile"));
        securityprofileusecases.updateSecurityprofile(securityprofile);
        setReturnstatus("OK");
    }

    private void delete_securityprofile(Securityprofile_usecases securityprofileusecases, JSONObject json) throws ParseException, CustomException {
        ISecurityprofile securityprofile = (ISecurityprofile)JSONSecurityprofile.toSecurityprofile((JSONObject)json.get("securityprofile"));
        securityprofileusecases.deleteSecurityprofile(securityprofile);
        setReturnstatus("OK");
    }

}

