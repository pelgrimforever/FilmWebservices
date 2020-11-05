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
import film.interfaces.searchentity.IPhotosubjectssearch;
import film.interfaces.servlet.IPhotosubjectsOperation;
import film.logicentity.Photosubjects;
import film.searchentity.Photosubjectssearch;
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
@Path("rsphotosubjects")
public class RSPhotosubjects {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public RSPhotosubjects() {
    }

    /**
     * Retrieves representation of an instance of photosubjects.restservices.RSPhotosubjects
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLphotosubjects blphotosubjects = new BLphotosubjects();
            ArrayList photosubjectss = blphotosubjects.getAll();
            JSONArray jsonphotosubjectss = JSONPhotosubjects.toJSONArray(photosubjectss);
            return jsonphotosubjectss.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of photosubjects.restservices.RSPhotosubjects
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLphotosubjects blphotosubjects = new BLphotosubjects();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IPhotosubjectsPK photosubjectsPK;
            IPhotosubjects photosubjects;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blphotosubjects.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IPhotosubjectsOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blphotosubjects.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IPhotosubjectsOperation.SELECT_ALL:
                            result = JSONPhotosubjects.toJSONArray(blphotosubjects.getPhotosubjectss()).toJSONString();
                            break;
                        case IPhotosubjectsOperation.SELECT_PHOTOSUBJECTS:
                            photosubjectsPK = (IPhotosubjectsPK)JSONPhotosubjects.toPhotosubjectsPK((JSONObject)json.get("photosubjectspk"));
                            result = JSONPhotosubjects.toJSON(blphotosubjects.getPhotosubjects(photosubjectsPK)).toJSONString();
                            break;
                        case IPhotosubjectsOperation.SELECT_Photo:
                            IPhotoPK photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
                            result = JSONPhotosubjects.toJSONArray(blphotosubjects.getPhotosubjectss4photo(photoPK)).toJSONString();
                            break;
                        case IPhotosubjectsOperation.SELECT_Subject:
                            ISubjectPK subjectPK = (ISubjectPK)JSONSubject.toSubjectPK((JSONObject)json.get("subjectpk"));
                            result = JSONPhotosubjects.toJSONArray(blphotosubjects.getPhotosubjectss4subject(subjectPK)).toJSONString();
                            break;
                        case IPhotosubjectsOperation.SELECT_SEARCH:
                            IPhotosubjectssearch search = (IPhotosubjectssearch)JSONPhotosubjects.toPhotosubjectssearch((JSONObject)json.get("search"));
                            result = JSONPhotosubjects.toJSONArray(blphotosubjects.search(search)).toJSONString();
                            break;
                        case IPhotosubjectsOperation.SELECT_SEARCHCOUNT:
                            IPhotosubjectssearch photosubjectssearch = (IPhotosubjectssearch)JSONPhotosubjects.toPhotosubjectssearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blphotosubjects.searchcount(photosubjectssearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IPhotosubjectsOperation.INSERT_PHOTOSUBJECTS:
                            photosubjects = (IPhotosubjects)JSONPhotosubjects.toPhotosubjects((JSONObject)json.get("photosubjects"));
                            blphotosubjects.insertPhotosubjects(photosubjects);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IPhotosubjectsOperation.UPDATE_PHOTOSUBJECTS:
                            JSONObject jsonphotosubjects = (JSONObject)json.get("photosubjects");
                            photosubjectsPK = JSONPhotosubjects.toPhotosubjectsPK((JSONObject)jsonphotosubjects.get("PK"));
                            photosubjects = blphotosubjects.getPhotosubjects(photosubjectsPK);
                            JSONPhotosubjects.updatePhotosubjects(photosubjects, jsonphotosubjects);
                            blphotosubjects.updatePhotosubjects(photosubjects);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IPhotosubjectsOperation.DELETE_PHOTOSUBJECTS:
                            photosubjects = (IPhotosubjects)JSONPhotosubjects.toPhotosubjects((JSONObject)json.get("photosubjects"));
                            blphotosubjects.deletePhotosubjects(photosubjects);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IPhotosubjectsOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blphotosubjects.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IPhotosubjectsOperation.SELECT_ALL:
                            result = JSONPhotosubjects.toJSONArray(blphotosubjects.getPhotosubjectss()).toJSONString();
                            break;
                        case IPhotosubjectsOperation.SELECT_PHOTOSUBJECTS:
                            photosubjectsPK = (IPhotosubjectsPK)JSONPhotosubjects.toPhotosubjectsPK((JSONObject)json.get("photosubjectspk"));
                            result = JSONPhotosubjects.toJSON(blphotosubjects.getPhotosubjects(photosubjectsPK)).toJSONString();
                            break;
                        case IPhotosubjectsOperation.SELECT_Photo:
                            IPhotoPK photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
                            result = JSONPhotosubjects.toJSONArray(blphotosubjects.getPhotosubjectss4photo(photoPK)).toJSONString();
                            break;
                        case IPhotosubjectsOperation.SELECT_Subject:
                            ISubjectPK subjectPK = (ISubjectPK)JSONSubject.toSubjectPK((JSONObject)json.get("subjectpk"));
                            result = JSONPhotosubjects.toJSONArray(blphotosubjects.getPhotosubjectss4subject(subjectPK)).toJSONString();
                            break;
                        case IPhotosubjectsOperation.SELECT_SEARCH:
                            IPhotosubjectssearch search = (IPhotosubjectssearch)JSONPhotosubjects.toPhotosubjectssearch((JSONObject)json.get("search"));
                            result = JSONPhotosubjects.toJSONArray(blphotosubjects.search(search)).toJSONString();
                            break;
                        case IPhotosubjectsOperation.SELECT_SEARCHCOUNT:
                            IPhotosubjectssearch photosubjectssearch = (IPhotosubjectssearch)JSONPhotosubjects.toPhotosubjectssearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blphotosubjects.searchcount(photosubjectssearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IPhotosubjectsOperation.INSERT_PHOTOSUBJECTS:
                            photosubjects = (IPhotosubjects)JSONPhotosubjects.toPhotosubjects((JSONObject)json.get("photosubjects"));
                            blphotosubjects.secureinsertPhotosubjects(photosubjects);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IPhotosubjectsOperation.UPDATE_PHOTOSUBJECTS:
                            JSONObject jsonphotosubjects = (JSONObject)json.get("photosubjects");
                            photosubjectsPK = JSONPhotosubjects.toPhotosubjectsPK((JSONObject)jsonphotosubjects.get("PK"));
                            photosubjects = blphotosubjects.getPhotosubjects(photosubjectsPK);
                            JSONPhotosubjects.updatePhotosubjects(photosubjects, jsonphotosubjects);
                            blphotosubjects.secureupdatePhotosubjects(photosubjects);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IPhotosubjectsOperation.DELETE_PHOTOSUBJECTS:
                            photosubjects = (IPhotosubjects)JSONPhotosubjects.toPhotosubjects((JSONObject)json.get("photosubjects"));
                            blphotosubjects.securedeletePhotosubjects(photosubjects);
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
     * PUT method for updating or creating an instance of RSPhotosubjects
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

