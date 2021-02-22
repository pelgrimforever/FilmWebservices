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
import film.interfaces.searchentity.IArt_academysearch;
import film.interfaces.servlet.IArt_academyOperation;
import film.logicentity.Art_academy;
import film.searchentity.Art_academysearch;
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
@Path("rsart_academy")
public class RSArt_academy {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public RSArt_academy() {
    }

    /**
     * Retrieves representation of an instance of art_academy.restservices.RSArt_academy
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLart_academy blart_academy = new BLart_academy();
            ArrayList art_academys = blart_academy.getAll();
            JSONArray jsonart_academys = JSONArt_academy.toJSONArray(art_academys);
            return jsonart_academys.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of art_academy.restservices.RSArt_academy
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLart_academy blart_academy = new BLart_academy();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IArt_academyPK art_academyPK;
            IArt_academy art_academy;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blart_academy.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IArt_academyOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blart_academy.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IArt_academyOperation.SELECT_ALL:
                            result = JSONArt_academy.toJSONArray(blart_academy.getArt_academys()).toJSONString();
                            break;
                        case IArt_academyOperation.SELECT_ART_ACADEMY:
                            art_academyPK = (IArt_academyPK)JSONArt_academy.toArt_academyPK((JSONObject)json.get("art_academypk"));
                            result = JSONArt_academy.toJSON(blart_academy.getArt_academy(art_academyPK)).toJSONString();
                            break;
                        case IArt_academyOperation.SELECT_SEARCH:
                            IArt_academysearch search = (IArt_academysearch)JSONArt_academy.toArt_academysearch((JSONObject)json.get("search"));
                            result = JSONArt_academy.toJSONArray(blart_academy.search(search)).toJSONString();
                            break;
                        case IArt_academyOperation.SELECT_SEARCHCOUNT:
                            IArt_academysearch art_academysearch = (IArt_academysearch)JSONArt_academy.toArt_academysearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blart_academy.searchcount(art_academysearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IArt_academyOperation.INSERT_ART_ACADEMY:
                            art_academy = (IArt_academy)JSONArt_academy.toArt_academy((JSONObject)json.get("art_academy"));
                            blart_academy.insertArt_academy(art_academy);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IArt_academyOperation.UPDATE_ART_ACADEMY:
                            JSONObject jsonart_academy = (JSONObject)json.get("art_academy");
                            art_academyPK = JSONArt_academy.toArt_academyPK((JSONObject)jsonart_academy.get("PK"));
                            art_academy = blart_academy.getArt_academy(art_academyPK);
                            JSONArt_academy.updateArt_academy(art_academy, jsonart_academy);
                            blart_academy.updateArt_academy(art_academy);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IArt_academyOperation.DELETE_ART_ACADEMY:
                            art_academy = (IArt_academy)JSONArt_academy.toArt_academy((JSONObject)json.get("art_academy"));
                            blart_academy.deleteArt_academy(art_academy);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IArt_academyOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blart_academy.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IArt_academyOperation.SELECT_ALL:
                            result = JSONArt_academy.toJSONArray(blart_academy.getArt_academys()).toJSONString();
                            break;
                        case IArt_academyOperation.SELECT_ART_ACADEMY:
                            art_academyPK = (IArt_academyPK)JSONArt_academy.toArt_academyPK((JSONObject)json.get("art_academypk"));
                            result = JSONArt_academy.toJSON(blart_academy.getArt_academy(art_academyPK)).toJSONString();
                            break;
                        case IArt_academyOperation.SELECT_SEARCH:
                            IArt_academysearch search = (IArt_academysearch)JSONArt_academy.toArt_academysearch((JSONObject)json.get("search"));
                            result = JSONArt_academy.toJSONArray(blart_academy.search(search)).toJSONString();
                            break;
                        case IArt_academyOperation.SELECT_SEARCHCOUNT:
                            IArt_academysearch art_academysearch = (IArt_academysearch)JSONArt_academy.toArt_academysearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blart_academy.searchcount(art_academysearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IArt_academyOperation.INSERT_ART_ACADEMY:
                            art_academy = (IArt_academy)JSONArt_academy.toArt_academy((JSONObject)json.get("art_academy"));
                            blart_academy.secureinsertArt_academy(art_academy);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IArt_academyOperation.UPDATE_ART_ACADEMY:
                            JSONObject jsonart_academy = (JSONObject)json.get("art_academy");
                            art_academyPK = JSONArt_academy.toArt_academyPK((JSONObject)jsonart_academy.get("PK"));
                            art_academy = blart_academy.getArt_academy(art_academyPK);
                            JSONArt_academy.updateArt_academy(art_academy, jsonart_academy);
                            blart_academy.secureupdateArt_academy(art_academy);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IArt_academyOperation.DELETE_ART_ACADEMY:
                            art_academy = (IArt_academy)JSONArt_academy.toArt_academy((JSONObject)json.get("art_academy"));
                            blart_academy.securedeleteArt_academy(art_academy);
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
     * PUT method for updating or creating an instance of RSArt_academy
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}
