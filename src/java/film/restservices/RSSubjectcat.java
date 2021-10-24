/*
 * RSSubjectcat.java
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
import film.interfaces.searchentity.ISubjectcatsearch;
import film.interfaces.servlet.ISubjectcatOperation;
import film.logicentity.Subjectcat;
import film.searchentity.Subjectcatsearch;
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
@Path("rssubjectcat")
public class RSSubjectcat {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSSubjectcat() {
    }

    /**
     * Retrieves representation of an instance of subjectcat.restservices.RSSubjectcat
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLsubjectcat blsubjectcat = new BLsubjectcat();
            ArrayList subjectcats = blsubjectcat.getAll();
            JSONArray jsonsubjectcats = JSONSubjectcat.toJSONArray(subjectcats);
            return jsonsubjectcats.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of subjectcat.restservices.RSSubjectcat
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLsubjectcat blsubjectcat = new BLsubjectcat();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            ISubjectcatPK subjectcatPK;
            ISubjectcat subjectcat;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blsubjectcat.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case ISubjectcatOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blsubjectcat.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISubjectcatOperation.SELECT_ALL:
                            result = JSONSubjectcat.toJSONArray(blsubjectcat.getSubjectcats()).toJSONString();
                            break;
                        case ISubjectcatOperation.SELECT_SUBJECTCAT:
                            subjectcatPK = (ISubjectcatPK)JSONSubjectcat.toSubjectcatPK((JSONObject)json.get("subjectcatpk"));
                            result = JSONSubjectcat.toJSON(blsubjectcat.getSubjectcat(subjectcatPK)).toJSONString();
                            break;
                        case ISubjectcatOperation.SELECT_Subjectcat1:
                            ISubjectPK subjectCat1PK = (ISubjectPK)JSONSubject.toSubjectPK((JSONObject)json.get("subjectpk"));
                            result = JSONSubjectcat.toJSON(blsubjectcat.getSubjectcat1(subjectCat1PK)).toJSONString();
                            break;
                        case ISubjectcatOperation.SELECT_Subjectcat2:
                            ISubjectPK subjectCat2PK = (ISubjectPK)JSONSubject.toSubjectPK((JSONObject)json.get("subjectpk"));
                            result = JSONSubjectcat.toJSON(blsubjectcat.getSubjectcat2(subjectCat2PK)).toJSONString();
                            break;
                        case ISubjectcatOperation.SELECT_SEARCH:
                            ISubjectcatsearch search = (ISubjectcatsearch)JSONSubjectcat.toSubjectcatsearch((JSONObject)json.get("search"));
                            result = JSONSubjectcat.toJSONArray(blsubjectcat.search(search)).toJSONString();
                            break;
                        case ISubjectcatOperation.SELECT_SEARCHCOUNT:
                            ISubjectcatsearch subjectcatsearch = (ISubjectcatsearch)JSONSubjectcat.toSubjectcatsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blsubjectcat.searchcount(subjectcatsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case ISubjectcatOperation.INSERT_SUBJECTCAT:
                            subjectcat = (ISubjectcat)JSONSubjectcat.toSubjectcat((JSONObject)json.get("subjectcat"));
                            blsubjectcat.insertSubjectcat(subjectcat);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case ISubjectcatOperation.UPDATE_SUBJECTCAT:
                            JSONObject jsonsubjectcat = (JSONObject)json.get("subjectcat");
                            subjectcatPK = JSONSubjectcat.toSubjectcatPK((JSONObject)jsonsubjectcat.get("PK"));
                            subjectcat = blsubjectcat.getSubjectcat(subjectcatPK);
                            JSONSubjectcat.updateSubjectcat(subjectcat, jsonsubjectcat);
                            blsubjectcat.updateSubjectcat(subjectcat);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case ISubjectcatOperation.DELETE_SUBJECTCAT:
                            subjectcat = (ISubjectcat)JSONSubjectcat.toSubjectcat((JSONObject)json.get("subjectcat"));
                            blsubjectcat.deleteSubjectcat(subjectcat);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case ISubjectcatOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blsubjectcat.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISubjectcatOperation.SELECT_ALL:
                            result = JSONSubjectcat.toJSONArray(blsubjectcat.getSubjectcats()).toJSONString();
                            break;
                        case ISubjectcatOperation.SELECT_SUBJECTCAT:
                            subjectcatPK = (ISubjectcatPK)JSONSubjectcat.toSubjectcatPK((JSONObject)json.get("subjectcatpk"));
                            result = JSONSubjectcat.toJSON(blsubjectcat.getSubjectcat(subjectcatPK)).toJSONString();
                            break;
                        case ISubjectcatOperation.SELECT_Subjectcat1:
                            ISubjectPK subjectCat1PK = (ISubjectPK)JSONSubject.toSubjectPK((JSONObject)json.get("subjectpk"));
                            result = JSONSubjectcat.toJSON(blsubjectcat.getSubjectcat1(subjectCat1PK)).toJSONString();
                            break;
                        case ISubjectcatOperation.SELECT_Subjectcat2:
                            ISubjectPK subjectCat2PK = (ISubjectPK)JSONSubject.toSubjectPK((JSONObject)json.get("subjectpk"));
                            result = JSONSubjectcat.toJSON(blsubjectcat.getSubjectcat2(subjectCat2PK)).toJSONString();
                            break;
                        case ISubjectcatOperation.SELECT_SEARCH:
                            ISubjectcatsearch search = (ISubjectcatsearch)JSONSubjectcat.toSubjectcatsearch((JSONObject)json.get("search"));
                            result = JSONSubjectcat.toJSONArray(blsubjectcat.search(search)).toJSONString();
                            break;
                        case ISubjectcatOperation.SELECT_SEARCHCOUNT:
                            ISubjectcatsearch subjectcatsearch = (ISubjectcatsearch)JSONSubjectcat.toSubjectcatsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blsubjectcat.searchcount(subjectcatsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case ISubjectcatOperation.INSERT_SUBJECTCAT:
                            subjectcat = (ISubjectcat)JSONSubjectcat.toSubjectcat((JSONObject)json.get("subjectcat"));
                            blsubjectcat.secureinsertSubjectcat(subjectcat);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case ISubjectcatOperation.UPDATE_SUBJECTCAT:
                            JSONObject jsonsubjectcat = (JSONObject)json.get("subjectcat");
                            subjectcatPK = JSONSubjectcat.toSubjectcatPK((JSONObject)jsonsubjectcat.get("PK"));
                            subjectcat = blsubjectcat.getSubjectcat(subjectcatPK);
                            JSONSubjectcat.updateSubjectcat(subjectcat, jsonsubjectcat);
                            blsubjectcat.secureupdateSubjectcat(subjectcat);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case ISubjectcatOperation.DELETE_SUBJECTCAT:
                            subjectcat = (ISubjectcat)JSONSubjectcat.toSubjectcat((JSONObject)json.get("subjectcat"));
                            blsubjectcat.securedeleteSubjectcat(subjectcat);
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
     * PUT method for updating or creating an instance of RSSubjectcat
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

