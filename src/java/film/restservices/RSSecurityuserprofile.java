/*
 * RSSecurityuserprofile.java
 *
 * Generated on 24.9.2021 14:50
 *
 */

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
import film.interfaces.searchentity.ISecurityuserprofilesearch;
import film.interfaces.servlet.ISecurityuserprofileOperation;
import film.logicentity.Securityuserprofile;
import film.searchentity.Securityuserprofilesearch;
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
@Path("rssecurityuserprofile")
public class RSSecurityuserprofile {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSSecurityuserprofile() {
    }

    /**
     * Retrieves representation of an instance of securityuserprofile.restservices.RSSecurityuserprofile
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLsecurityuserprofile blsecurityuserprofile = new BLsecurityuserprofile();
            ArrayList securityuserprofiles = blsecurityuserprofile.getAll();
            JSONArray jsonsecurityuserprofiles = JSONSecurityuserprofile.toJSONArray(securityuserprofiles);
            return jsonsecurityuserprofiles.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of securityuserprofile.restservices.RSSecurityuserprofile
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLsecurityuserprofile blsecurityuserprofile = new BLsecurityuserprofile();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            ISecurityuserprofilePK securityuserprofilePK;
            ISecurityuserprofile securityuserprofile;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blsecurityuserprofile.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case ISecurityuserprofileOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blsecurityuserprofile.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISecurityuserprofileOperation.SELECT_ALL:
                            result = JSONSecurityuserprofile.toJSONArray(blsecurityuserprofile.getSecurityuserprofiles()).toJSONString();
                            break;
                        case ISecurityuserprofileOperation.SELECT_SECURITYUSERPROFILE:
                            securityuserprofilePK = (ISecurityuserprofilePK)JSONSecurityuserprofile.toSecurityuserprofilePK((JSONObject)json.get("securityuserprofilepk"));
                            result = JSONSecurityuserprofile.toJSON(blsecurityuserprofile.getSecurityuserprofile(securityuserprofilePK)).toJSONString();
                            break;
                        case ISecurityuserprofileOperation.SELECT_Securityprofile:
                            ISecurityprofilePK securityprofilePK = (ISecurityprofilePK)JSONSecurityprofile.toSecurityprofilePK((JSONObject)json.get("securityprofilepk"));
                            result = JSONSecurityuserprofile.toJSONArray(blsecurityuserprofile.getSecurityuserprofiles4securityprofile(securityprofilePK)).toJSONString();
                            break;
                        case ISecurityuserprofileOperation.SELECT_SEARCH:
                            ISecurityuserprofilesearch search = (ISecurityuserprofilesearch)JSONSecurityuserprofile.toSecurityuserprofilesearch((JSONObject)json.get("search"));
                            result = JSONSecurityuserprofile.toJSONArray(blsecurityuserprofile.search(search)).toJSONString();
                            break;
                        case ISecurityuserprofileOperation.SELECT_SEARCHCOUNT:
                            ISecurityuserprofilesearch securityuserprofilesearch = (ISecurityuserprofilesearch)JSONSecurityuserprofile.toSecurityuserprofilesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blsecurityuserprofile.searchcount(securityuserprofilesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case ISecurityuserprofileOperation.INSERT_SECURITYUSERPROFILE:
                            securityuserprofile = (ISecurityuserprofile)JSONSecurityuserprofile.toSecurityuserprofile((JSONObject)json.get("securityuserprofile"));
                            blsecurityuserprofile.insertSecurityuserprofile(securityuserprofile);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case ISecurityuserprofileOperation.UPDATE_SECURITYUSERPROFILE:
                            JSONObject jsonsecurityuserprofile = (JSONObject)json.get("securityuserprofile");
                            securityuserprofilePK = JSONSecurityuserprofile.toSecurityuserprofilePK((JSONObject)jsonsecurityuserprofile.get("PK"));
                            securityuserprofile = blsecurityuserprofile.getSecurityuserprofile(securityuserprofilePK);
                            JSONSecurityuserprofile.updateSecurityuserprofile(securityuserprofile, jsonsecurityuserprofile);
                            blsecurityuserprofile.updateSecurityuserprofile(securityuserprofile);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case ISecurityuserprofileOperation.DELETE_SECURITYUSERPROFILE:
                            securityuserprofile = (ISecurityuserprofile)JSONSecurityuserprofile.toSecurityuserprofile((JSONObject)json.get("securityuserprofile"));
                            blsecurityuserprofile.deleteSecurityuserprofile(securityuserprofile);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case ISecurityuserprofileOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blsecurityuserprofile.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISecurityuserprofileOperation.SELECT_ALL:
                            result = JSONSecurityuserprofile.toJSONArray(blsecurityuserprofile.getSecurityuserprofiles()).toJSONString();
                            break;
                        case ISecurityuserprofileOperation.SELECT_SECURITYUSERPROFILE:
                            securityuserprofilePK = (ISecurityuserprofilePK)JSONSecurityuserprofile.toSecurityuserprofilePK((JSONObject)json.get("securityuserprofilepk"));
                            result = JSONSecurityuserprofile.toJSON(blsecurityuserprofile.getSecurityuserprofile(securityuserprofilePK)).toJSONString();
                            break;
                        case ISecurityuserprofileOperation.SELECT_Securityprofile:
                            ISecurityprofilePK securityprofilePK = (ISecurityprofilePK)JSONSecurityprofile.toSecurityprofilePK((JSONObject)json.get("securityprofilepk"));
                            result = JSONSecurityuserprofile.toJSONArray(blsecurityuserprofile.getSecurityuserprofiles4securityprofile(securityprofilePK)).toJSONString();
                            break;
                        case ISecurityuserprofileOperation.SELECT_SEARCH:
                            ISecurityuserprofilesearch search = (ISecurityuserprofilesearch)JSONSecurityuserprofile.toSecurityuserprofilesearch((JSONObject)json.get("search"));
                            result = JSONSecurityuserprofile.toJSONArray(blsecurityuserprofile.search(search)).toJSONString();
                            break;
                        case ISecurityuserprofileOperation.SELECT_SEARCHCOUNT:
                            ISecurityuserprofilesearch securityuserprofilesearch = (ISecurityuserprofilesearch)JSONSecurityuserprofile.toSecurityuserprofilesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blsecurityuserprofile.searchcount(securityuserprofilesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case ISecurityuserprofileOperation.INSERT_SECURITYUSERPROFILE:
                            securityuserprofile = (ISecurityuserprofile)JSONSecurityuserprofile.toSecurityuserprofile((JSONObject)json.get("securityuserprofile"));
                            blsecurityuserprofile.secureinsertSecurityuserprofile(securityuserprofile);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case ISecurityuserprofileOperation.UPDATE_SECURITYUSERPROFILE:
                            JSONObject jsonsecurityuserprofile = (JSONObject)json.get("securityuserprofile");
                            securityuserprofilePK = JSONSecurityuserprofile.toSecurityuserprofilePK((JSONObject)jsonsecurityuserprofile.get("PK"));
                            securityuserprofile = blsecurityuserprofile.getSecurityuserprofile(securityuserprofilePK);
                            JSONSecurityuserprofile.updateSecurityuserprofile(securityuserprofile, jsonsecurityuserprofile);
                            blsecurityuserprofile.secureupdateSecurityuserprofile(securityuserprofile);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case ISecurityuserprofileOperation.DELETE_SECURITYUSERPROFILE:
                            securityuserprofile = (ISecurityuserprofile)JSONSecurityuserprofile.toSecurityuserprofile((JSONObject)json.get("securityuserprofile"));
                            blsecurityuserprofile.securedeleteSecurityuserprofile(securityuserprofile);
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
     * PUT method for updating or creating an instance of RSSecurityuserprofile
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

