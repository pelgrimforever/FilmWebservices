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
import film.interfaces.searchentity.IArt_subgroupsearch;
import film.interfaces.servlet.IArt_subgroupOperation;
import film.logicentity.Art_subgroup;
import film.searchentity.Art_subgroupsearch;
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
@Path("rsart_subgroup")
public class RSArt_subgroup {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public RSArt_subgroup() {
    }

    /**
     * Retrieves representation of an instance of art_subgroup.restservices.RSArt_subgroup
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLart_subgroup blart_subgroup = new BLart_subgroup();
            ArrayList art_subgroups = blart_subgroup.getAll();
            JSONArray jsonart_subgroups = JSONArt_subgroup.toJSONArray(art_subgroups);
            return jsonart_subgroups.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of art_subgroup.restservices.RSArt_subgroup
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLart_subgroup blart_subgroup = new BLart_subgroup();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IArt_subgroupPK art_subgroupPK;
            IArt_subgroup art_subgroup;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blart_subgroup.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IArt_subgroupOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blart_subgroup.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IArt_subgroupOperation.SELECT_ALL:
                            result = JSONArt_subgroup.toJSONArray(blart_subgroup.getArt_subgroups()).toJSONString();
                            break;
                        case IArt_subgroupOperation.SELECT_ART_SUBGROUP:
                            art_subgroupPK = (IArt_subgroupPK)JSONArt_subgroup.toArt_subgroupPK((JSONObject)json.get("art_subgrouppk"));
                            result = JSONArt_subgroup.toJSON(blart_subgroup.getArt_subgroup(art_subgroupPK)).toJSONString();
                            break;
                        case IArt_subgroupOperation.SELECT_Art_group:
                            IArt_groupPK art_groupPK = (IArt_groupPK)JSONArt_group.toArt_groupPK((JSONObject)json.get("art_grouppk"));
                            result = JSONArt_subgroup.toJSONArray(blart_subgroup.getArt_subgroups4art_group(art_groupPK)).toJSONString();
                            break;
                        case IArt_subgroupOperation.SELECT_SEARCH:
                            IArt_subgroupsearch search = (IArt_subgroupsearch)JSONArt_subgroup.toArt_subgroupsearch((JSONObject)json.get("search"));
                            result = JSONArt_subgroup.toJSONArray(blart_subgroup.search(search)).toJSONString();
                            break;
                        case IArt_subgroupOperation.SELECT_SEARCHCOUNT:
                            IArt_subgroupsearch art_subgroupsearch = (IArt_subgroupsearch)JSONArt_subgroup.toArt_subgroupsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blart_subgroup.searchcount(art_subgroupsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IArt_subgroupOperation.INSERT_ART_SUBGROUP:
                            art_subgroup = (IArt_subgroup)JSONArt_subgroup.toArt_subgroup((JSONObject)json.get("art_subgroup"));
                            blart_subgroup.insertArt_subgroup(art_subgroup);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IArt_subgroupOperation.UPDATE_ART_SUBGROUP:
                            JSONObject jsonart_subgroup = (JSONObject)json.get("art_subgroup");
                            art_subgroupPK = JSONArt_subgroup.toArt_subgroupPK((JSONObject)jsonart_subgroup.get("PK"));
                            art_subgroup = blart_subgroup.getArt_subgroup(art_subgroupPK);
                            JSONArt_subgroup.updateArt_subgroup(art_subgroup, jsonart_subgroup);
                            blart_subgroup.updateArt_subgroup(art_subgroup);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IArt_subgroupOperation.DELETE_ART_SUBGROUP:
                            art_subgroup = (IArt_subgroup)JSONArt_subgroup.toArt_subgroup((JSONObject)json.get("art_subgroup"));
                            blart_subgroup.deleteArt_subgroup(art_subgroup);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IArt_subgroupOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blart_subgroup.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IArt_subgroupOperation.SELECT_ALL:
                            result = JSONArt_subgroup.toJSONArray(blart_subgroup.getArt_subgroups()).toJSONString();
                            break;
                        case IArt_subgroupOperation.SELECT_ART_SUBGROUP:
                            art_subgroupPK = (IArt_subgroupPK)JSONArt_subgroup.toArt_subgroupPK((JSONObject)json.get("art_subgrouppk"));
                            result = JSONArt_subgroup.toJSON(blart_subgroup.getArt_subgroup(art_subgroupPK)).toJSONString();
                            break;
                        case IArt_subgroupOperation.SELECT_Art_group:
                            IArt_groupPK art_groupPK = (IArt_groupPK)JSONArt_group.toArt_groupPK((JSONObject)json.get("art_grouppk"));
                            result = JSONArt_subgroup.toJSONArray(blart_subgroup.getArt_subgroups4art_group(art_groupPK)).toJSONString();
                            break;
                        case IArt_subgroupOperation.SELECT_SEARCH:
                            IArt_subgroupsearch search = (IArt_subgroupsearch)JSONArt_subgroup.toArt_subgroupsearch((JSONObject)json.get("search"));
                            result = JSONArt_subgroup.toJSONArray(blart_subgroup.search(search)).toJSONString();
                            break;
                        case IArt_subgroupOperation.SELECT_SEARCHCOUNT:
                            IArt_subgroupsearch art_subgroupsearch = (IArt_subgroupsearch)JSONArt_subgroup.toArt_subgroupsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blart_subgroup.searchcount(art_subgroupsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IArt_subgroupOperation.INSERT_ART_SUBGROUP:
                            art_subgroup = (IArt_subgroup)JSONArt_subgroup.toArt_subgroup((JSONObject)json.get("art_subgroup"));
                            blart_subgroup.secureinsertArt_subgroup(art_subgroup);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IArt_subgroupOperation.UPDATE_ART_SUBGROUP:
                            JSONObject jsonart_subgroup = (JSONObject)json.get("art_subgroup");
                            art_subgroupPK = JSONArt_subgroup.toArt_subgroupPK((JSONObject)jsonart_subgroup.get("PK"));
                            art_subgroup = blart_subgroup.getArt_subgroup(art_subgroupPK);
                            JSONArt_subgroup.updateArt_subgroup(art_subgroup, jsonart_subgroup);
                            blart_subgroup.secureupdateArt_subgroup(art_subgroup);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IArt_subgroupOperation.DELETE_ART_SUBGROUP:
                            art_subgroup = (IArt_subgroup)JSONArt_subgroup.toArt_subgroup((JSONObject)json.get("art_subgroup"));
                            blart_subgroup.securedeleteArt_subgroup(art_subgroup);
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
     * PUT method for updating or creating an instance of RSArt_subgroup
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

