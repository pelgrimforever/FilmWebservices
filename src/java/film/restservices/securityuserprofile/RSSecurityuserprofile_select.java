/*
 * Generated on 27.6.2022 16:45
 */

package film.restservices.securityuserprofile;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.conversion.json.*;
import film.entity.pk.*;
import film.usecases.*;
import film.usecases.custom.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.ISecurityuserprofilesearch;
import film.interfaces.servlet.ISecurityuserprofileOperation;
import film.logicentity.Securityuserprofile;
import film.searchentity.Securityuserprofilesearch;
import film.servlets.DataServlet;
import film.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.sql.Time;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
@Path("rssecurityuserprofile_select")
public class RSSecurityuserprofile_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Securityuserprofile_usecases securityuserprofileusecases = new Securityuserprofile_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ISecurityuserprofileOperation.SELECT_COUNT:
                    result = count_records(securityuserprofileusecases);
                    break;
                case ISecurityuserprofileOperation.SELECT_ALL:
                    result = get_all_securityuserprofile(securityuserprofileusecases);
                    break;
                case ISecurityuserprofileOperation.SELECT_SECURITYUSERPROFILE:
                    result = get_securityuserprofile_with_primarykey(securityuserprofileusecases, json);
                    break;
                case ISecurityuserprofileOperation.SELECT_Securityprofile:
                    result = get_securityuserprofile_with_foreignkey_securityprofile(securityuserprofileusecases, json);
                    break;
                case ISecurityuserprofileOperation.SELECT_SEARCH:
                    result = search_securityuserprofile(securityuserprofileusecases, json);
                    break;
                case ISecurityuserprofileOperation.SELECT_SEARCHCOUNT:
                    result = search_securityuserprofile_count(securityuserprofileusecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            }
        }
        catch(ParseException | CustomException | IOException e) {
            setReturnstatus(e.getMessage());
        }
        return result;
    }

//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

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
}

