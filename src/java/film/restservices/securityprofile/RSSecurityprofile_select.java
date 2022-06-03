/*
 * Generated on 1.5.2022 20:24
 */

package film.restservices.securityprofile;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.conversion.json.*;
import film.entity.pk.*;
import film.usecases.Securityprofile_usecases;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.ISecurityprofilesearch;
import film.interfaces.servlet.ISecurityprofileOperation;
import film.logicentity.Securityprofile;
import film.searchentity.Securityprofilesearch;
import film.servlets.DataServlet;
import film.usecases.Security_usecases;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
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
@Path("rssecurityprofile_select")
public class RSSecurityprofile_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            ISecurityprofilePK securityprofilePK;
            ISecurityprofile securityprofile;
            Securityprofile_usecases securityprofileusecases = new Securityprofile_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case ISecurityprofileOperation.SELECT_COUNT:
                    result = count_records(securityprofileusecases);
                    break;
                case ISecurityprofileOperation.SELECT_ALL:
                    result = get_all_securityprofile(securityprofileusecases);
                    break;
                case ISecurityprofileOperation.SELECT_SECURITYPROFILE:
                    result = get_securityprofile_with_primarykey(securityprofileusecases, json);
                    break;
                case ISecurityprofileOperation.SELECT_Securityuserprofile:
                    result = get_securityprofile_with_externalforeignkey_securityuserprofile(securityprofileusecases, json);
                    break;
                case ISecurityprofileOperation.SELECT_SEARCH:
                    result = search_securityprofile(securityprofileusecases, json);
                    break;
                case ISecurityprofileOperation.SELECT_SEARCHCOUNT:
                    result = search_securityprofile_count(securityprofileusecases, json);
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
}

