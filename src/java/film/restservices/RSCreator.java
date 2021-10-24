/*
 * RSCreator.java
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
import film.interfaces.searchentity.ICreatorsearch;
import film.interfaces.servlet.ICreatorOperation;
import film.logicentity.Creator;
import film.searchentity.Creatorsearch;
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
@Path("rscreator")
public class RSCreator {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSCreator() {
    }

    /**
     * Retrieves representation of an instance of creator.restservices.RSCreator
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLcreator blcreator = new BLcreator();
            ArrayList creators = blcreator.getAll();
            JSONArray jsoncreators = JSONCreator.toJSONArray(creators);
            return jsoncreators.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of creator.restservices.RSCreator
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLcreator blcreator = new BLcreator();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            ICreatorPK creatorPK;
            ICreator creator;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blcreator.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case ICreatorOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blcreator.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ICreatorOperation.SELECT_ALL:
                            result = JSONCreator.toJSONArray(blcreator.getCreators()).toJSONString();
                            break;
                        case ICreatorOperation.SELECT_CREATOR:
                            creatorPK = (ICreatorPK)JSONCreator.toCreatorPK((JSONObject)json.get("creatorpk"));
                            result = JSONCreator.toJSON(blcreator.getCreator(creatorPK)).toJSONString();
                            break;
                        case ICreatorOperation.SELECT_SEARCH:
                            ICreatorsearch search = (ICreatorsearch)JSONCreator.toCreatorsearch((JSONObject)json.get("search"));
                            result = JSONCreator.toJSONArray(blcreator.search(search)).toJSONString();
                            break;
                        case ICreatorOperation.SELECT_SEARCHCOUNT:
                            ICreatorsearch creatorsearch = (ICreatorsearch)JSONCreator.toCreatorsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blcreator.searchcount(creatorsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case ICreatorOperation.INSERT_CREATOR:
                            creator = (ICreator)JSONCreator.toCreator((JSONObject)json.get("creator"));
                            blcreator.insertCreator(creator);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case ICreatorOperation.UPDATE_CREATOR:
                            JSONObject jsoncreator = (JSONObject)json.get("creator");
                            creatorPK = JSONCreator.toCreatorPK((JSONObject)jsoncreator.get("PK"));
                            creator = blcreator.getCreator(creatorPK);
                            JSONCreator.updateCreator(creator, jsoncreator);
                            blcreator.updateCreator(creator);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case ICreatorOperation.DELETE_CREATOR:
                            creator = (ICreator)JSONCreator.toCreator((JSONObject)json.get("creator"));
                            blcreator.deleteCreator(creator);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case ICreatorOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blcreator.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ICreatorOperation.SELECT_ALL:
                            result = JSONCreator.toJSONArray(blcreator.getCreators()).toJSONString();
                            break;
                        case ICreatorOperation.SELECT_CREATOR:
                            creatorPK = (ICreatorPK)JSONCreator.toCreatorPK((JSONObject)json.get("creatorpk"));
                            result = JSONCreator.toJSON(blcreator.getCreator(creatorPK)).toJSONString();
                            break;
                        case ICreatorOperation.SELECT_SEARCH:
                            ICreatorsearch search = (ICreatorsearch)JSONCreator.toCreatorsearch((JSONObject)json.get("search"));
                            result = JSONCreator.toJSONArray(blcreator.search(search)).toJSONString();
                            break;
                        case ICreatorOperation.SELECT_SEARCHCOUNT:
                            ICreatorsearch creatorsearch = (ICreatorsearch)JSONCreator.toCreatorsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blcreator.searchcount(creatorsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case ICreatorOperation.INSERT_CREATOR:
                            creator = (ICreator)JSONCreator.toCreator((JSONObject)json.get("creator"));
                            blcreator.secureinsertCreator(creator);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case ICreatorOperation.UPDATE_CREATOR:
                            JSONObject jsoncreator = (JSONObject)json.get("creator");
                            creatorPK = JSONCreator.toCreatorPK((JSONObject)jsoncreator.get("PK"));
                            creator = blcreator.getCreator(creatorPK);
                            JSONCreator.updateCreator(creator, jsoncreator);
                            blcreator.secureupdateCreator(creator);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case ICreatorOperation.DELETE_CREATOR:
                            creator = (ICreator)JSONCreator.toCreator((JSONObject)json.get("creator"));
                            blcreator.securedeleteCreator(creator);
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
     * PUT method for updating or creating an instance of RSCreator
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

