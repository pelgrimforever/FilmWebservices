/*
 * RSArt_group.java
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
import film.interfaces.searchentity.IArt_groupsearch;
import film.interfaces.servlet.IArt_groupOperation;
import film.logicentity.Art_group;
import film.searchentity.Art_groupsearch;
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
@Path("rsart_group")
public class RSArt_group {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSArt_group() {
    }

    /**
     * Retrieves representation of an instance of art_group.restservices.RSArt_group
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLart_group blart_group = new BLart_group();
            ArrayList art_groups = blart_group.getAll();
            JSONArray jsonart_groups = JSONArt_group.toJSONArray(art_groups);
            return jsonart_groups.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of art_group.restservices.RSArt_group
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLart_group blart_group = new BLart_group();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IArt_groupPK art_groupPK;
            IArt_group art_group;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blart_group.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IArt_groupOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blart_group.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IArt_groupOperation.SELECT_ALL:
                            result = JSONArt_group.toJSONArray(blart_group.getArt_groups()).toJSONString();
                            break;
                        case IArt_groupOperation.SELECT_ART_GROUP:
                            art_groupPK = (IArt_groupPK)JSONArt_group.toArt_groupPK((JSONObject)json.get("art_grouppk"));
                            result = JSONArt_group.toJSON(blart_group.getArt_group(art_groupPK)).toJSONString();
                            break;
                        case IArt_groupOperation.SELECT_SEARCH:
                            IArt_groupsearch search = (IArt_groupsearch)JSONArt_group.toArt_groupsearch((JSONObject)json.get("search"));
                            result = JSONArt_group.toJSONArray(blart_group.search(search)).toJSONString();
                            break;
                        case IArt_groupOperation.SELECT_SEARCHCOUNT:
                            IArt_groupsearch art_groupsearch = (IArt_groupsearch)JSONArt_group.toArt_groupsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blart_group.searchcount(art_groupsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IArt_groupOperation.INSERT_ART_GROUP:
                            art_group = (IArt_group)JSONArt_group.toArt_group((JSONObject)json.get("art_group"));
                            blart_group.insertArt_group(art_group);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IArt_groupOperation.UPDATE_ART_GROUP:
                            JSONObject jsonart_group = (JSONObject)json.get("art_group");
                            art_groupPK = JSONArt_group.toArt_groupPK((JSONObject)jsonart_group.get("PK"));
                            art_group = blart_group.getArt_group(art_groupPK);
                            JSONArt_group.updateArt_group(art_group, jsonart_group);
                            blart_group.updateArt_group(art_group);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IArt_groupOperation.DELETE_ART_GROUP:
                            art_group = (IArt_group)JSONArt_group.toArt_group((JSONObject)json.get("art_group"));
                            blart_group.deleteArt_group(art_group);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IArt_groupOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blart_group.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IArt_groupOperation.SELECT_ALL:
                            result = JSONArt_group.toJSONArray(blart_group.getArt_groups()).toJSONString();
                            break;
                        case IArt_groupOperation.SELECT_ART_GROUP:
                            art_groupPK = (IArt_groupPK)JSONArt_group.toArt_groupPK((JSONObject)json.get("art_grouppk"));
                            result = JSONArt_group.toJSON(blart_group.getArt_group(art_groupPK)).toJSONString();
                            break;
                        case IArt_groupOperation.SELECT_SEARCH:
                            IArt_groupsearch search = (IArt_groupsearch)JSONArt_group.toArt_groupsearch((JSONObject)json.get("search"));
                            result = JSONArt_group.toJSONArray(blart_group.search(search)).toJSONString();
                            break;
                        case IArt_groupOperation.SELECT_SEARCHCOUNT:
                            IArt_groupsearch art_groupsearch = (IArt_groupsearch)JSONArt_group.toArt_groupsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blart_group.searchcount(art_groupsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IArt_groupOperation.INSERT_ART_GROUP:
                            art_group = (IArt_group)JSONArt_group.toArt_group((JSONObject)json.get("art_group"));
                            blart_group.secureinsertArt_group(art_group);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IArt_groupOperation.UPDATE_ART_GROUP:
                            JSONObject jsonart_group = (JSONObject)json.get("art_group");
                            art_groupPK = JSONArt_group.toArt_groupPK((JSONObject)jsonart_group.get("PK"));
                            art_group = blart_group.getArt_group(art_groupPK);
                            JSONArt_group.updateArt_group(art_group, jsonart_group);
                            blart_group.secureupdateArt_group(art_group);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IArt_groupOperation.DELETE_ART_GROUP:
                            art_group = (IArt_group)JSONArt_group.toArt_group((JSONObject)json.get("art_group"));
                            blart_group.securedeleteArt_group(art_group);
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
     * PUT method for updating or creating an instance of RSArt_group
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

