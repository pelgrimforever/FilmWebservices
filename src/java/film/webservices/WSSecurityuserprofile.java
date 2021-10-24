/*
 * WSSecurityuserprofile.java
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
import film.interfaces.webservice.WSISecurityuserprofile;
import film.logicentity.Securityuserprofile;
import film.searchentity.Securityuserprofilesearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSISecurityuserprofile")
public class WSSecurityuserprofile implements WSISecurityuserprofile {

    private JSONArray toJSONArray(ArrayList securityuserprofiles) {
        JSONArray jsonsecurityuserprofiles = new JSONArray();
        Iterator securityuserprofilesI = securityuserprofiles.iterator();
        while(securityuserprofilesI.hasNext()) {
            jsonsecurityuserprofiles.add(JSONSecurityuserprofile.toJSON((Securityuserprofile)securityuserprofilesI.next()));
        }
        return jsonsecurityuserprofiles;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getSecurityuserprofiles")
    @Override
    public String getSecurityuserprofiles() {
        try {
            BLsecurityuserprofile blsecurityuserprofile = new BLsecurityuserprofile();
            ArrayList securityuserprofiles = blsecurityuserprofile.getAll();
            JSONArray jsonsecurityuserprofiles = toJSONArray(securityuserprofiles);
            return jsonsecurityuserprofiles.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLsecurityuserprofile blsecurityuserprofile = new BLsecurityuserprofile();
        JSONParser parser = new JSONParser();
        String result = "";
        Securityuserprofile securityuserprofile;
        try {
            Securityuserprofilesearch securityuserprofilesearch = JSONSecurityuserprofile.toSecurityuserprofilesearch((JSONObject)parser.parse(json));
            ArrayList securityuserprofiles = blsecurityuserprofile.search(securityuserprofilesearch);
            JSONArray jsonsecurityuserprofiles = toJSONArray(securityuserprofiles);
            result = jsonsecurityuserprofiles.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getSecurityuserprofile")
    @Override
    public String getSecurityuserprofile(String json) {
        BLsecurityuserprofile blsecurityuserprofile = new BLsecurityuserprofile();
        JSONParser parser = new JSONParser();
        String result = "";
        Securityuserprofile securityuserprofile;
        try {
            SecurityuserprofilePK securityuserprofilePK = JSONSecurityuserprofile.toSecurityuserprofilePK((JSONObject)parser.parse(json));
            securityuserprofile = blsecurityuserprofile.getSecurityuserprofile(securityuserprofilePK);
            if(securityuserprofile!=null) {
                result = JSONSecurityuserprofile.toJSON(securityuserprofile).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertSecurityuserprofile")
    @Override
    public void insertSecurityuserprofile(String json) {
        BLsecurityuserprofile blsecurityuserprofile = new BLsecurityuserprofile();
        JSONParser parser = new JSONParser();
        try {
            ISecurityuserprofile securityuserprofile = JSONSecurityuserprofile.toSecurityuserprofile((JSONObject)parser.parse(json));
            blsecurityuserprofile.insertSecurityuserprofile(securityuserprofile);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateSecurityuserprofile")
    @Override
    public void updateSecurityuserprofile(String json) {
        BLsecurityuserprofile blsecurityuserprofile = new BLsecurityuserprofile();
        JSONParser parser = new JSONParser();
        try {
            ISecurityuserprofile securityuserprofile = JSONSecurityuserprofile.toSecurityuserprofile((JSONObject)parser.parse(json));
            blsecurityuserprofile.updateSecurityuserprofile(securityuserprofile);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteSecurityuserprofile")
    @Override
    public void deleteSecurityuserprofile(String json) {
        BLsecurityuserprofile blsecurityuserprofile = new BLsecurityuserprofile();
        JSONParser parser = new JSONParser();
        try {
            ISecurityuserprofile securityuserprofile = JSONSecurityuserprofile.toSecurityuserprofile((JSONObject)parser.parse(json));
            blsecurityuserprofile.deleteSecurityuserprofile(securityuserprofile);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getSecurityuserprofiles4securityprofile")
    @Override
    public String getSecurityuserprofiles4securityprofile(String json) {
        BLsecurityuserprofile blsecurityuserprofile = new BLsecurityuserprofile();
        JSONParser parser = new JSONParser();
        Securityuserprofile securityuserprofile;
        try {
            ISecurityprofilePK securityprofilePK = JSONSecurityprofile.toSecurityprofilePK((JSONObject)parser.parse(json));
            ArrayList securityuserprofiles = blsecurityuserprofile.getSecurityuserprofiles4securityprofile(securityprofilePK);
            JSONArray jsonsecurityuserprofiles = toJSONArray(securityuserprofiles);
            return jsonsecurityuserprofiles.toJSONString();
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

    //@WebMethod(operationName = "delete4securityprofile")
    @Override
    public void delete4securityprofile(String json) {
        BLsecurityuserprofile blsecurityuserprofile = new BLsecurityuserprofile();
        JSONParser parser = new JSONParser();
        Securityuserprofile securityuserprofile;
        try {
            ISecurityprofilePK securityprofilePK = JSONSecurityprofile.toSecurityprofilePK((JSONObject)parser.parse(json));
            blsecurityuserprofile.delete4securityprofile(securityprofilePK);
        }
        catch(ParseException e) {
        }
    }


}

