package film.restservices;

import base.servlets.Securitycheck;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.ISecurityprofilesearch;
import film.interfaces.servlet.ISecurityprofileOperation;
import film.logicentity.Securityprofile;
import film.searchentity.Securityprofilesearch;
import film.servlets.DataServlet;
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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * REST Web Service
 *
 * @author Franky Laseure
 */
@Path("rssecurityprofile")
public class RSSecurityprofile {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public RSSecurityprofile() {
    }

    /**
     * Retrieves representation of an instance of securityprofile.restservices.RSSecurityprofile
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLsecurityprofile blsecurityprofile = new BLsecurityprofile();
            ArrayList securityprofiles = blsecurityprofile.getAll();
            JSONArray jsonsecurityprofiles = JSONSecurityprofile.toJSONArray(securityprofiles);
            return jsonsecurityprofiles.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of securityprofile.restservices.RSSecurityprofile
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLsecurityprofile blsecurityprofile = new BLsecurityprofile();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            ISecurityprofilePK securityprofilePK;
            ISecurityprofile securityprofile;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blsecurityprofile.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case ISecurityprofileOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blsecurityprofile.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISecurityprofileOperation.SELECT_ALL:
                            result = JSONSecurityprofile.toJSONArray(blsecurityprofile.getSecurityprofiles()).toJSONString();
                            break;
                        case ISecurityprofileOperation.SELECT_SECURITYPROFILE:
                            securityprofilePK = (ISecurityprofilePK)JSONSecurityprofile.toSecurityprofilePK((JSONObject)json.get("securityprofilepk"));
                            result = JSONSecurityprofile.toJSON(blsecurityprofile.getSecurityprofile(securityprofilePK)).toJSONString();
                            break;
                        case ISecurityprofileOperation.SELECT_Securityuserprofile:
                            ISecurityuserprofilePK securityuserprofilePK = (ISecurityuserprofilePK)JSONSecurityuserprofile.toSecurityuserprofilePK((JSONObject)json.get("securityuserprofilepk"));
                            result = JSONSecurityprofile.toJSON(blsecurityprofile.getSecurityuserprofile(securityuserprofilePK)).toJSONString();
                            break;
                        case ISecurityprofileOperation.SELECT_SEARCH:
                            ISecurityprofilesearch search = (ISecurityprofilesearch)JSONSecurityprofile.toSecurityprofilesearch((JSONObject)json.get("search"));
                            result = JSONSecurityprofile.toJSONArray(blsecurityprofile.search(search)).toJSONString();
                            break;
                        case ISecurityprofileOperation.SELECT_SEARCHCOUNT:
                            ISecurityprofilesearch securityprofilesearch = (ISecurityprofilesearch)JSONSecurityprofile.toSecurityprofilesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blsecurityprofile.searchcount(securityprofilesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case ISecurityprofileOperation.INSERT_SECURITYPROFILE:
                            securityprofile = (ISecurityprofile)JSONSecurityprofile.toSecurityprofile((JSONObject)json.get("securityprofile"));
                            blsecurityprofile.insertSecurityprofile(securityprofile);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case ISecurityprofileOperation.UPDATE_SECURITYPROFILE:
                            JSONObject jsonsecurityprofile = (JSONObject)json.get("securityprofile");
                            securityprofilePK = JSONSecurityprofile.toSecurityprofilePK((JSONObject)jsonsecurityprofile.get("PK"));
                            securityprofile = blsecurityprofile.getSecurityprofile(securityprofilePK);
                            JSONSecurityprofile.updateSecurityprofile(securityprofile, jsonsecurityprofile);
                            blsecurityprofile.updateSecurityprofile(securityprofile);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case ISecurityprofileOperation.DELETE_SECURITYPROFILE:
                            securityprofile = (ISecurityprofile)JSONSecurityprofile.toSecurityprofile((JSONObject)json.get("securityprofile"));
                            blsecurityprofile.deleteSecurityprofile(securityprofile);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case ISecurityprofileOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blsecurityprofile.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISecurityprofileOperation.SELECT_ALL:
                            result = JSONSecurityprofile.toJSONArray(blsecurityprofile.getSecurityprofiles()).toJSONString();
                            break;
                        case ISecurityprofileOperation.SELECT_SECURITYPROFILE:
                            securityprofilePK = (ISecurityprofilePK)JSONSecurityprofile.toSecurityprofilePK((JSONObject)json.get("securityprofilepk"));
                            result = JSONSecurityprofile.toJSON(blsecurityprofile.getSecurityprofile(securityprofilePK)).toJSONString();
                            break;
                        case ISecurityprofileOperation.SELECT_Securityuserprofile:
                            ISecurityuserprofilePK securityuserprofilePK = (ISecurityuserprofilePK)JSONSecurityuserprofile.toSecurityuserprofilePK((JSONObject)json.get("securityuserprofilepk"));
                            result = JSONSecurityprofile.toJSON(blsecurityprofile.getSecurityuserprofile(securityuserprofilePK)).toJSONString();
                            break;
                        case ISecurityprofileOperation.SELECT_SEARCH:
                            ISecurityprofilesearch search = (ISecurityprofilesearch)JSONSecurityprofile.toSecurityprofilesearch((JSONObject)json.get("search"));
                            result = JSONSecurityprofile.toJSONArray(blsecurityprofile.search(search)).toJSONString();
                            break;
                        case ISecurityprofileOperation.SELECT_SEARCHCOUNT:
                            ISecurityprofilesearch securityprofilesearch = (ISecurityprofilesearch)JSONSecurityprofile.toSecurityprofilesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blsecurityprofile.searchcount(securityprofilesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case ISecurityprofileOperation.INSERT_SECURITYPROFILE:
                            securityprofile = (ISecurityprofile)JSONSecurityprofile.toSecurityprofile((JSONObject)json.get("securityprofile"));
                            blsecurityprofile.secureinsertSecurityprofile(securityprofile);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case ISecurityprofileOperation.UPDATE_SECURITYPROFILE:
                            JSONObject jsonsecurityprofile = (JSONObject)json.get("securityprofile");
                            securityprofilePK = JSONSecurityprofile.toSecurityprofilePK((JSONObject)jsonsecurityprofile.get("PK"));
                            securityprofile = blsecurityprofile.getSecurityprofile(securityprofilePK);
                            JSONSecurityprofile.updateSecurityprofile(securityprofile, jsonsecurityprofile);
                            blsecurityprofile.secureupdateSecurityprofile(securityprofile);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case ISecurityprofileOperation.DELETE_SECURITYPROFILE:
                            securityprofile = (ISecurityprofile)JSONSecurityprofile.toSecurityprofile((JSONObject)json.get("securityprofile"));
                            blsecurityprofile.securedeleteSecurityprofile(securityprofile);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
            }
        }
        catch(ParseException e) {
            result = returnstatus(e.getMessage());
        }
        catch(CustomException e) {
            result = returnstatus(e.getMessage());
        }
        return result;
    }

    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }

    /**
     * PUT method for updating or creating an instance of RSSecurityprofile
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

