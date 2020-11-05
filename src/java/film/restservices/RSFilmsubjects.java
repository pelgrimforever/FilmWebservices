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
import film.interfaces.searchentity.IFilmsubjectssearch;
import film.interfaces.servlet.IFilmsubjectsOperation;
import film.logicentity.Filmsubjects;
import film.searchentity.Filmsubjectssearch;
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
@Path("rsfilmsubjects")
public class RSFilmsubjects {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public RSFilmsubjects() {
    }

    /**
     * Retrieves representation of an instance of filmsubjects.restservices.RSFilmsubjects
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLfilmsubjects blfilmsubjects = new BLfilmsubjects();
            ArrayList filmsubjectss = blfilmsubjects.getAll();
            JSONArray jsonfilmsubjectss = JSONFilmsubjects.toJSONArray(filmsubjectss);
            return jsonfilmsubjectss.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of filmsubjects.restservices.RSFilmsubjects
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLfilmsubjects blfilmsubjects = new BLfilmsubjects();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IFilmsubjectsPK filmsubjectsPK;
            IFilmsubjects filmsubjects;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blfilmsubjects.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IFilmsubjectsOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blfilmsubjects.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IFilmsubjectsOperation.SELECT_ALL:
                            result = JSONFilmsubjects.toJSONArray(blfilmsubjects.getFilmsubjectss()).toJSONString();
                            break;
                        case IFilmsubjectsOperation.SELECT_FILMSUBJECTS:
                            filmsubjectsPK = (IFilmsubjectsPK)JSONFilmsubjects.toFilmsubjectsPK((JSONObject)json.get("filmsubjectspk"));
                            result = JSONFilmsubjects.toJSON(blfilmsubjects.getFilmsubjects(filmsubjectsPK)).toJSONString();
                            break;
                        case IFilmsubjectsOperation.SELECT_Subject:
                            ISubjectPK subjectPK = (ISubjectPK)JSONSubject.toSubjectPK((JSONObject)json.get("subjectpk"));
                            result = JSONFilmsubjects.toJSONArray(blfilmsubjects.getFilmsubjectss4subject(subjectPK)).toJSONString();
                            break;
                        case IFilmsubjectsOperation.SELECT_Film:
                            IFilmPK filmPK = (IFilmPK)JSONFilm.toFilmPK((JSONObject)json.get("filmpk"));
                            result = JSONFilmsubjects.toJSONArray(blfilmsubjects.getFilmsubjectss4film(filmPK)).toJSONString();
                            break;
                        case IFilmsubjectsOperation.SELECT_SEARCH:
                            IFilmsubjectssearch search = (IFilmsubjectssearch)JSONFilmsubjects.toFilmsubjectssearch((JSONObject)json.get("search"));
                            result = JSONFilmsubjects.toJSONArray(blfilmsubjects.search(search)).toJSONString();
                            break;
                        case IFilmsubjectsOperation.SELECT_SEARCHCOUNT:
                            IFilmsubjectssearch filmsubjectssearch = (IFilmsubjectssearch)JSONFilmsubjects.toFilmsubjectssearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blfilmsubjects.searchcount(filmsubjectssearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IFilmsubjectsOperation.INSERT_FILMSUBJECTS:
                            filmsubjects = (IFilmsubjects)JSONFilmsubjects.toFilmsubjects((JSONObject)json.get("filmsubjects"));
                            blfilmsubjects.insertFilmsubjects(filmsubjects);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IFilmsubjectsOperation.UPDATE_FILMSUBJECTS:
                            JSONObject jsonfilmsubjects = (JSONObject)json.get("filmsubjects");
                            filmsubjectsPK = JSONFilmsubjects.toFilmsubjectsPK((JSONObject)jsonfilmsubjects.get("PK"));
                            filmsubjects = blfilmsubjects.getFilmsubjects(filmsubjectsPK);
                            JSONFilmsubjects.updateFilmsubjects(filmsubjects, jsonfilmsubjects);
                            blfilmsubjects.updateFilmsubjects(filmsubjects);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IFilmsubjectsOperation.DELETE_FILMSUBJECTS:
                            filmsubjects = (IFilmsubjects)JSONFilmsubjects.toFilmsubjects((JSONObject)json.get("filmsubjects"));
                            blfilmsubjects.deleteFilmsubjects(filmsubjects);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IFilmsubjectsOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blfilmsubjects.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IFilmsubjectsOperation.SELECT_ALL:
                            result = JSONFilmsubjects.toJSONArray(blfilmsubjects.getFilmsubjectss()).toJSONString();
                            break;
                        case IFilmsubjectsOperation.SELECT_FILMSUBJECTS:
                            filmsubjectsPK = (IFilmsubjectsPK)JSONFilmsubjects.toFilmsubjectsPK((JSONObject)json.get("filmsubjectspk"));
                            result = JSONFilmsubjects.toJSON(blfilmsubjects.getFilmsubjects(filmsubjectsPK)).toJSONString();
                            break;
                        case IFilmsubjectsOperation.SELECT_Subject:
                            ISubjectPK subjectPK = (ISubjectPK)JSONSubject.toSubjectPK((JSONObject)json.get("subjectpk"));
                            result = JSONFilmsubjects.toJSONArray(blfilmsubjects.getFilmsubjectss4subject(subjectPK)).toJSONString();
                            break;
                        case IFilmsubjectsOperation.SELECT_Film:
                            IFilmPK filmPK = (IFilmPK)JSONFilm.toFilmPK((JSONObject)json.get("filmpk"));
                            result = JSONFilmsubjects.toJSONArray(blfilmsubjects.getFilmsubjectss4film(filmPK)).toJSONString();
                            break;
                        case IFilmsubjectsOperation.SELECT_SEARCH:
                            IFilmsubjectssearch search = (IFilmsubjectssearch)JSONFilmsubjects.toFilmsubjectssearch((JSONObject)json.get("search"));
                            result = JSONFilmsubjects.toJSONArray(blfilmsubjects.search(search)).toJSONString();
                            break;
                        case IFilmsubjectsOperation.SELECT_SEARCHCOUNT:
                            IFilmsubjectssearch filmsubjectssearch = (IFilmsubjectssearch)JSONFilmsubjects.toFilmsubjectssearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blfilmsubjects.searchcount(filmsubjectssearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IFilmsubjectsOperation.INSERT_FILMSUBJECTS:
                            filmsubjects = (IFilmsubjects)JSONFilmsubjects.toFilmsubjects((JSONObject)json.get("filmsubjects"));
                            blfilmsubjects.secureinsertFilmsubjects(filmsubjects);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IFilmsubjectsOperation.UPDATE_FILMSUBJECTS:
                            JSONObject jsonfilmsubjects = (JSONObject)json.get("filmsubjects");
                            filmsubjectsPK = JSONFilmsubjects.toFilmsubjectsPK((JSONObject)jsonfilmsubjects.get("PK"));
                            filmsubjects = blfilmsubjects.getFilmsubjects(filmsubjectsPK);
                            JSONFilmsubjects.updateFilmsubjects(filmsubjects, jsonfilmsubjects);
                            blfilmsubjects.secureupdateFilmsubjects(filmsubjects);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IFilmsubjectsOperation.DELETE_FILMSUBJECTS:
                            filmsubjects = (IFilmsubjects)JSONFilmsubjects.toFilmsubjects((JSONObject)json.get("filmsubjects"));
                            blfilmsubjects.securedeleteFilmsubjects(filmsubjects);
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
     * PUT method for updating or creating an instance of RSFilmsubjects
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

