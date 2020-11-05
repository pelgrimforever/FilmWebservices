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
import film.interfaces.searchentity.IFilmtypesearch;
import film.interfaces.servlet.IFilmtypeOperation;
import film.logicentity.Filmtype;
import film.searchentity.Filmtypesearch;
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
@Path("rsfilmtype")
public class RSFilmtype {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public RSFilmtype() {
    }

    /**
     * Retrieves representation of an instance of filmtype.restservices.RSFilmtype
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLfilmtype blfilmtype = new BLfilmtype();
            ArrayList filmtypes = blfilmtype.getAll();
            JSONArray jsonfilmtypes = JSONFilmtype.toJSONArray(filmtypes);
            return jsonfilmtypes.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of filmtype.restservices.RSFilmtype
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLfilmtype blfilmtype = new BLfilmtype();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IFilmtypePK filmtypePK;
            IFilmtype filmtype;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blfilmtype.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IFilmtypeOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blfilmtype.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IFilmtypeOperation.SELECT_ALL:
                            result = JSONFilmtype.toJSONArray(blfilmtype.getFilmtypes()).toJSONString();
                            break;
                        case IFilmtypeOperation.SELECT_FILMTYPE:
                            filmtypePK = (IFilmtypePK)JSONFilmtype.toFilmtypePK((JSONObject)json.get("filmtypepk"));
                            result = JSONFilmtype.toJSON(blfilmtype.getFilmtype(filmtypePK)).toJSONString();
                            break;
                        case IFilmtypeOperation.SELECT_SEARCH:
                            IFilmtypesearch search = (IFilmtypesearch)JSONFilmtype.toFilmtypesearch((JSONObject)json.get("search"));
                            result = JSONFilmtype.toJSONArray(blfilmtype.search(search)).toJSONString();
                            break;
                        case IFilmtypeOperation.SELECT_SEARCHCOUNT:
                            IFilmtypesearch filmtypesearch = (IFilmtypesearch)JSONFilmtype.toFilmtypesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blfilmtype.searchcount(filmtypesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IFilmtypeOperation.INSERT_FILMTYPE:
                            filmtype = (IFilmtype)JSONFilmtype.toFilmtype((JSONObject)json.get("filmtype"));
                            blfilmtype.insertFilmtype(filmtype);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IFilmtypeOperation.UPDATE_FILMTYPE:
                            JSONObject jsonfilmtype = (JSONObject)json.get("filmtype");
                            filmtypePK = JSONFilmtype.toFilmtypePK((JSONObject)jsonfilmtype.get("PK"));
                            filmtype = blfilmtype.getFilmtype(filmtypePK);
                            JSONFilmtype.updateFilmtype(filmtype, jsonfilmtype);
                            blfilmtype.updateFilmtype(filmtype);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IFilmtypeOperation.DELETE_FILMTYPE:
                            filmtype = (IFilmtype)JSONFilmtype.toFilmtype((JSONObject)json.get("filmtype"));
                            blfilmtype.deleteFilmtype(filmtype);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IFilmtypeOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blfilmtype.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IFilmtypeOperation.SELECT_ALL:
                            result = JSONFilmtype.toJSONArray(blfilmtype.getFilmtypes()).toJSONString();
                            break;
                        case IFilmtypeOperation.SELECT_FILMTYPE:
                            filmtypePK = (IFilmtypePK)JSONFilmtype.toFilmtypePK((JSONObject)json.get("filmtypepk"));
                            result = JSONFilmtype.toJSON(blfilmtype.getFilmtype(filmtypePK)).toJSONString();
                            break;
                        case IFilmtypeOperation.SELECT_SEARCH:
                            IFilmtypesearch search = (IFilmtypesearch)JSONFilmtype.toFilmtypesearch((JSONObject)json.get("search"));
                            result = JSONFilmtype.toJSONArray(blfilmtype.search(search)).toJSONString();
                            break;
                        case IFilmtypeOperation.SELECT_SEARCHCOUNT:
                            IFilmtypesearch filmtypesearch = (IFilmtypesearch)JSONFilmtype.toFilmtypesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blfilmtype.searchcount(filmtypesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IFilmtypeOperation.INSERT_FILMTYPE:
                            filmtype = (IFilmtype)JSONFilmtype.toFilmtype((JSONObject)json.get("filmtype"));
                            blfilmtype.secureinsertFilmtype(filmtype);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IFilmtypeOperation.UPDATE_FILMTYPE:
                            JSONObject jsonfilmtype = (JSONObject)json.get("filmtype");
                            filmtypePK = JSONFilmtype.toFilmtypePK((JSONObject)jsonfilmtype.get("PK"));
                            filmtype = blfilmtype.getFilmtype(filmtypePK);
                            JSONFilmtype.updateFilmtype(filmtype, jsonfilmtype);
                            blfilmtype.secureupdateFilmtype(filmtype);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IFilmtypeOperation.DELETE_FILMTYPE:
                            filmtype = (IFilmtype)JSONFilmtype.toFilmtype((JSONObject)json.get("filmtype"));
                            blfilmtype.securedeleteFilmtype(filmtype);
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
     * PUT method for updating or creating an instance of RSFilmtype
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

