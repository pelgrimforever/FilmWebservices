package film.webservices;

import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.webservice.WSISecurityprofile;
import film.logicentity.Securityprofile;
import film.searchentity.Securityprofilesearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSISecurityprofile")
public class WSSecurityprofile implements WSISecurityprofile {

    private JSONArray toJSONArray(ArrayList securityprofiles) {
        JSONArray jsonsecurityprofiles = new JSONArray();
        Iterator securityprofilesI = securityprofiles.iterator();
        while(securityprofilesI.hasNext()) {
            jsonsecurityprofiles.add(JSONSecurityprofile.toJSON((Securityprofile)securityprofilesI.next()));
        }
        return jsonsecurityprofiles;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getSecurityprofiles")
    @Override
    public String getSecurityprofiles() {
        try {
            BLsecurityprofile blsecurityprofile = new BLsecurityprofile();
            ArrayList securityprofiles = blsecurityprofile.getAll();
            JSONArray jsonsecurityprofiles = toJSONArray(securityprofiles);
            return jsonsecurityprofiles.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLsecurityprofile blsecurityprofile = new BLsecurityprofile();
        JSONParser parser = new JSONParser();
        String result = "";
        Securityprofile securityprofile;
        try {
            Securityprofilesearch securityprofilesearch = JSONSecurityprofile.toSecurityprofilesearch((JSONObject)parser.parse(json));
            ArrayList securityprofiles = blsecurityprofile.search(securityprofilesearch);
            JSONArray jsonsecurityprofiles = toJSONArray(securityprofiles);
            result = jsonsecurityprofiles.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getSecurityprofile")
    @Override
    public String getSecurityprofile(String json) {
        BLsecurityprofile blsecurityprofile = new BLsecurityprofile();
        JSONParser parser = new JSONParser();
        String result = "";
        Securityprofile securityprofile;
        try {
            SecurityprofilePK securityprofilePK = JSONSecurityprofile.toSecurityprofilePK((JSONObject)parser.parse(json));
            securityprofile = blsecurityprofile.getSecurityprofile(securityprofilePK);
            if(securityprofile!=null) {
                result = JSONSecurityprofile.toJSON(securityprofile).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertSecurityprofile")
    @Override
    public void insertSecurityprofile(String json) {
        BLsecurityprofile blsecurityprofile = new BLsecurityprofile();
        JSONParser parser = new JSONParser();
        try {
            ISecurityprofile securityprofile = JSONSecurityprofile.toSecurityprofile((JSONObject)parser.parse(json));
            blsecurityprofile.insertSecurityprofile(securityprofile);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateSecurityprofile")
    @Override
    public void updateSecurityprofile(String json) {
        BLsecurityprofile blsecurityprofile = new BLsecurityprofile();
        JSONParser parser = new JSONParser();
        try {
            ISecurityprofile securityprofile = JSONSecurityprofile.toSecurityprofile((JSONObject)parser.parse(json));
            blsecurityprofile.updateSecurityprofile(securityprofile);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteSecurityprofile")
    @Override
    public void deleteSecurityprofile(String json) {
        BLsecurityprofile blsecurityprofile = new BLsecurityprofile();
        JSONParser parser = new JSONParser();
        try {
            ISecurityprofile securityprofile = JSONSecurityprofile.toSecurityprofile((JSONObject)parser.parse(json));
            blsecurityprofile.deleteSecurityprofile(securityprofile);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getSecurityprofiles4securityuserprofile")
    @Override
    public String getSecurityprofiles4securityuserprofile(String json) {
        BLsecurityprofile blsecurityprofile = new BLsecurityprofile();
        JSONParser parser = new JSONParser();
        Securityprofile securityprofile;
        try {
            String result = null;
            ISecurityuserprofilePK securityuserprofilePK = JSONSecurityuserprofile.toSecurityuserprofilePK((JSONObject)parser.parse(json));
            securityprofile = (Securityprofile)blsecurityprofile.getSecurityuserprofile(securityuserprofilePK);
            if(securityprofile!=null) {
                result = JSONSecurityprofile.toJSON(securityprofile).toJSONString();
            }
            return result;
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


}

