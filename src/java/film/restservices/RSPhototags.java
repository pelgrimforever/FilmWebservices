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
import film.interfaces.searchentity.IPhototagssearch;
import film.interfaces.servlet.IPhototagsOperation;
import film.logicentity.Phototags;
import film.searchentity.Phototagssearch;
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
@Path("rsphototags")
public class RSPhototags {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public RSPhototags() {
    }

    /**
     * Retrieves representation of an instance of phototags.restservices.RSPhototags
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLphototags blphototags = new BLphototags();
            ArrayList phototagss = blphototags.getAll();
            JSONArray jsonphototagss = JSONPhototags.toJSONArray(phototagss);
            return jsonphototagss.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of phototags.restservices.RSPhototags
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLphototags blphototags = new BLphototags();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IPhototagsPK phototagsPK;
            IPhototags phototags;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blphototags.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IPhototagsOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blphototags.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IPhototagsOperation.SELECT_ALL:
                            result = JSONPhototags.toJSONArray(blphototags.getPhototagss()).toJSONString();
                            break;
                        case IPhototagsOperation.SELECT_PHOTOTAGS:
                            phototagsPK = (IPhototagsPK)JSONPhototags.toPhototagsPK((JSONObject)json.get("phototagspk"));
                            result = JSONPhototags.toJSON(blphototags.getPhototags(phototagsPK)).toJSONString();
                            break;
                        case IPhototagsOperation.SELECT_Photo:
                            IPhotoPK photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
                            result = JSONPhototags.toJSONArray(blphototags.getPhototagss4photo(photoPK)).toJSONString();
                            break;
                        case IPhototagsOperation.SELECT_SEARCH:
                            IPhototagssearch search = (IPhototagssearch)JSONPhototags.toPhototagssearch((JSONObject)json.get("search"));
                            result = JSONPhototags.toJSONArray(blphototags.search(search)).toJSONString();
                            break;
                        case IPhototagsOperation.SELECT_SEARCHCOUNT:
                            IPhototagssearch phototagssearch = (IPhototagssearch)JSONPhototags.toPhototagssearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blphototags.searchcount(phototagssearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IPhototagsOperation.INSERT_PHOTOTAGS:
                            phototags = (IPhototags)JSONPhototags.toPhototags((JSONObject)json.get("phototags"));
                            blphototags.insertPhototags(phototags);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IPhototagsOperation.UPDATE_PHOTOTAGS:
                            JSONObject jsonphototags = (JSONObject)json.get("phototags");
                            phototagsPK = JSONPhototags.toPhototagsPK((JSONObject)jsonphototags.get("PK"));
                            phototags = blphototags.getPhototags(phototagsPK);
                            JSONPhototags.updatePhototags(phototags, jsonphototags);
                            blphototags.updatePhototags(phototags);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IPhototagsOperation.DELETE_PHOTOTAGS:
                            phototags = (IPhototags)JSONPhototags.toPhototags((JSONObject)json.get("phototags"));
                            blphototags.deletePhototags(phototags);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IPhototagsOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blphototags.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IPhototagsOperation.SELECT_ALL:
                            result = JSONPhototags.toJSONArray(blphototags.getPhototagss()).toJSONString();
                            break;
                        case IPhototagsOperation.SELECT_PHOTOTAGS:
                            phototagsPK = (IPhototagsPK)JSONPhototags.toPhototagsPK((JSONObject)json.get("phototagspk"));
                            result = JSONPhototags.toJSON(blphototags.getPhototags(phototagsPK)).toJSONString();
                            break;
                        case IPhototagsOperation.SELECT_Photo:
                            IPhotoPK photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
                            result = JSONPhototags.toJSONArray(blphototags.getPhototagss4photo(photoPK)).toJSONString();
                            break;
                        case IPhototagsOperation.SELECT_SEARCH:
                            IPhototagssearch search = (IPhototagssearch)JSONPhototags.toPhototagssearch((JSONObject)json.get("search"));
                            result = JSONPhototags.toJSONArray(blphototags.search(search)).toJSONString();
                            break;
                        case IPhototagsOperation.SELECT_SEARCHCOUNT:
                            IPhototagssearch phototagssearch = (IPhototagssearch)JSONPhototags.toPhototagssearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blphototags.searchcount(phototagssearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IPhototagsOperation.INSERT_PHOTOTAGS:
                            phototags = (IPhototags)JSONPhototags.toPhototags((JSONObject)json.get("phototags"));
                            blphototags.secureinsertPhototags(phototags);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IPhototagsOperation.UPDATE_PHOTOTAGS:
                            JSONObject jsonphototags = (JSONObject)json.get("phototags");
                            phototagsPK = JSONPhototags.toPhototagsPK((JSONObject)jsonphototags.get("PK"));
                            phototags = blphototags.getPhototags(phototagsPK);
                            JSONPhototags.updatePhototags(phototags, jsonphototags);
                            blphototags.secureupdatePhototags(phototags);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IPhototagsOperation.DELETE_PHOTOTAGS:
                            phototags = (IPhototags)JSONPhototags.toPhototags((JSONObject)json.get("phototags"));
                            blphototags.securedeletePhototags(phototags);
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
     * PUT method for updating or creating an instance of RSPhototags
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

