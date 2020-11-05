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
import film.interfaces.searchentity.IPhototree7subjectsearch;
import film.interfaces.servlet.IPhototree7subjectOperation;
import film.logicentity.Phototree7subject;
import film.searchentity.Phototree7subjectsearch;
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
@Path("rsphototree7subject")
public class RSPhototree7subject {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public RSPhototree7subject() {
    }

    /**
     * Retrieves representation of an instance of phototree7subject.restservices.RSPhototree7subject
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLphototree7subject blphototree7subject = new BLphototree7subject();
            ArrayList phototree7subjects = blphototree7subject.getAll();
            JSONArray jsonphototree7subjects = JSONPhototree7subject.toJSONArray(phototree7subjects);
            return jsonphototree7subjects.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of phototree7subject.restservices.RSPhototree7subject
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLphototree7subject blphototree7subject = new BLphototree7subject();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IPhototree7subjectPK phototree7subjectPK;
            IPhototree7subject phototree7subject;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blphototree7subject.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IPhototree7subjectOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blphototree7subject.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IPhototree7subjectOperation.SELECT_ALL:
                            result = JSONPhototree7subject.toJSONArray(blphototree7subject.getPhototree7subjects()).toJSONString();
                            break;
                        case IPhototree7subjectOperation.SELECT_PHOTOTREE7SUBJECT:
                            phototree7subjectPK = (IPhototree7subjectPK)JSONPhototree7subject.toPhototree7subjectPK((JSONObject)json.get("phototree7subjectpk"));
                            result = JSONPhototree7subject.toJSON(blphototree7subject.getPhototree7subject(phototree7subjectPK)).toJSONString();
                            break;
                        case IPhototree7subjectOperation.SELECT_Tree7subject:
                            ITree7subjectPK tree7subjectPK = (ITree7subjectPK)JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectpk"));
                            result = JSONPhototree7subject.toJSONArray(blphototree7subject.getPhototree7subjects4tree7subject(tree7subjectPK)).toJSONString();
                            break;
                        case IPhototree7subjectOperation.SELECT_Photo:
                            IPhotoPK photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
                            result = JSONPhototree7subject.toJSONArray(blphototree7subject.getPhototree7subjects4photo(photoPK)).toJSONString();
                            break;
                        case IPhototree7subjectOperation.SELECT_SEARCH:
                            IPhototree7subjectsearch search = (IPhototree7subjectsearch)JSONPhototree7subject.toPhototree7subjectsearch((JSONObject)json.get("search"));
                            result = JSONPhototree7subject.toJSONArray(blphototree7subject.search(search)).toJSONString();
                            break;
                        case IPhototree7subjectOperation.SELECT_SEARCHCOUNT:
                            IPhototree7subjectsearch phototree7subjectsearch = (IPhototree7subjectsearch)JSONPhototree7subject.toPhototree7subjectsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blphototree7subject.searchcount(phototree7subjectsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IPhototree7subjectOperation.INSERT_PHOTOTREE7SUBJECT:
                            phototree7subject = (IPhototree7subject)JSONPhototree7subject.toPhototree7subject((JSONObject)json.get("phototree7subject"));
                            blphototree7subject.insertPhototree7subject(phototree7subject);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IPhototree7subjectOperation.UPDATE_PHOTOTREE7SUBJECT:
                            JSONObject jsonphototree7subject = (JSONObject)json.get("phototree7subject");
                            phototree7subjectPK = JSONPhototree7subject.toPhototree7subjectPK((JSONObject)jsonphototree7subject.get("PK"));
                            phototree7subject = blphototree7subject.getPhototree7subject(phototree7subjectPK);
                            JSONPhototree7subject.updatePhototree7subject(phototree7subject, jsonphototree7subject);
                            blphototree7subject.updatePhototree7subject(phototree7subject);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IPhototree7subjectOperation.DELETE_PHOTOTREE7SUBJECT:
                            phototree7subject = (IPhototree7subject)JSONPhototree7subject.toPhototree7subject((JSONObject)json.get("phototree7subject"));
                            blphototree7subject.deletePhototree7subject(phototree7subject);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IPhototree7subjectOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blphototree7subject.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IPhototree7subjectOperation.SELECT_ALL:
                            result = JSONPhototree7subject.toJSONArray(blphototree7subject.getPhototree7subjects()).toJSONString();
                            break;
                        case IPhototree7subjectOperation.SELECT_PHOTOTREE7SUBJECT:
                            phototree7subjectPK = (IPhototree7subjectPK)JSONPhototree7subject.toPhototree7subjectPK((JSONObject)json.get("phototree7subjectpk"));
                            result = JSONPhototree7subject.toJSON(blphototree7subject.getPhototree7subject(phototree7subjectPK)).toJSONString();
                            break;
                        case IPhototree7subjectOperation.SELECT_Tree7subject:
                            ITree7subjectPK tree7subjectPK = (ITree7subjectPK)JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectpk"));
                            result = JSONPhototree7subject.toJSONArray(blphototree7subject.getPhototree7subjects4tree7subject(tree7subjectPK)).toJSONString();
                            break;
                        case IPhototree7subjectOperation.SELECT_Photo:
                            IPhotoPK photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
                            result = JSONPhototree7subject.toJSONArray(blphototree7subject.getPhototree7subjects4photo(photoPK)).toJSONString();
                            break;
                        case IPhototree7subjectOperation.SELECT_SEARCH:
                            IPhototree7subjectsearch search = (IPhototree7subjectsearch)JSONPhototree7subject.toPhototree7subjectsearch((JSONObject)json.get("search"));
                            result = JSONPhototree7subject.toJSONArray(blphototree7subject.search(search)).toJSONString();
                            break;
                        case IPhototree7subjectOperation.SELECT_SEARCHCOUNT:
                            IPhototree7subjectsearch phototree7subjectsearch = (IPhototree7subjectsearch)JSONPhototree7subject.toPhototree7subjectsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blphototree7subject.searchcount(phototree7subjectsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IPhototree7subjectOperation.INSERT_PHOTOTREE7SUBJECT:
                            phototree7subject = (IPhototree7subject)JSONPhototree7subject.toPhototree7subject((JSONObject)json.get("phototree7subject"));
                            blphototree7subject.secureinsertPhototree7subject(phototree7subject);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IPhototree7subjectOperation.UPDATE_PHOTOTREE7SUBJECT:
                            JSONObject jsonphototree7subject = (JSONObject)json.get("phototree7subject");
                            phototree7subjectPK = JSONPhototree7subject.toPhototree7subjectPK((JSONObject)jsonphototree7subject.get("PK"));
                            phototree7subject = blphototree7subject.getPhototree7subject(phototree7subjectPK);
                            JSONPhototree7subject.updatePhototree7subject(phototree7subject, jsonphototree7subject);
                            blphototree7subject.secureupdatePhototree7subject(phototree7subject);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IPhototree7subjectOperation.DELETE_PHOTOTREE7SUBJECT:
                            phototree7subject = (IPhototree7subject)JSONPhototree7subject.toPhototree7subject((JSONObject)json.get("phototree7subject"));
                            blphototree7subject.securedeletePhototree7subject(phototree7subject);
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
     * PUT method for updating or creating an instance of RSPhototree7subject
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

