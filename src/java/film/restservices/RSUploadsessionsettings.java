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
import film.interfaces.searchentity.IUploadsessionsettingssearch;
import film.interfaces.servlet.IUploadsessionsettingsOperation;
import film.logicentity.Uploadsessionsettings;
import film.searchentity.Uploadsessionsettingssearch;
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
@Path("rsuploadsessionsettings")
public class RSUploadsessionsettings {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public RSUploadsessionsettings() {
    }

    /**
     * Retrieves representation of an instance of uploadsessionsettings.restservices.RSUploadsessionsettings
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLuploadsessionsettings bluploadsessionsettings = new BLuploadsessionsettings();
            ArrayList uploadsessionsettingss = bluploadsessionsettings.getAll();
            JSONArray jsonuploadsessionsettingss = JSONUploadsessionsettings.toJSONArray(uploadsessionsettingss);
            return jsonuploadsessionsettingss.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of uploadsessionsettings.restservices.RSUploadsessionsettings
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLuploadsessionsettings bluploadsessionsettings = new BLuploadsessionsettings();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IUploadsessionsettingsPK uploadsessionsettingsPK;
            IUploadsessionsettings uploadsessionsettings;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            bluploadsessionsettings.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IUploadsessionsettingsOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bluploadsessionsettings.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IUploadsessionsettingsOperation.SELECT_ALL:
                            result = JSONUploadsessionsettings.toJSONArray(bluploadsessionsettings.getUploadsessionsettingss()).toJSONString();
                            break;
                        case IUploadsessionsettingsOperation.SELECT_UPLOADSESSIONSETTINGS:
                            uploadsessionsettingsPK = (IUploadsessionsettingsPK)JSONUploadsessionsettings.toUploadsessionsettingsPK((JSONObject)json.get("uploadsessionsettingspk"));
                            result = JSONUploadsessionsettings.toJSON(bluploadsessionsettings.getUploadsessionsettings(uploadsessionsettingsPK)).toJSONString();
                            break;
                        case IUploadsessionsettingsOperation.SELECT_SEARCH:
                            IUploadsessionsettingssearch search = (IUploadsessionsettingssearch)JSONUploadsessionsettings.toUploadsessionsettingssearch((JSONObject)json.get("search"));
                            result = JSONUploadsessionsettings.toJSONArray(bluploadsessionsettings.search(search)).toJSONString();
                            break;
                        case IUploadsessionsettingsOperation.SELECT_SEARCHCOUNT:
                            IUploadsessionsettingssearch uploadsessionsettingssearch = (IUploadsessionsettingssearch)JSONUploadsessionsettings.toUploadsessionsettingssearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bluploadsessionsettings.searchcount(uploadsessionsettingssearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IUploadsessionsettingsOperation.INSERT_UPLOADSESSIONSETTINGS:
                            uploadsessionsettings = (IUploadsessionsettings)JSONUploadsessionsettings.toUploadsessionsettings((JSONObject)json.get("uploadsessionsettings"));
                            bluploadsessionsettings.insertUploadsessionsettings(uploadsessionsettings);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IUploadsessionsettingsOperation.UPDATE_UPLOADSESSIONSETTINGS:
                            JSONObject jsonuploadsessionsettings = (JSONObject)json.get("uploadsessionsettings");
                            uploadsessionsettingsPK = JSONUploadsessionsettings.toUploadsessionsettingsPK((JSONObject)jsonuploadsessionsettings.get("PK"));
                            uploadsessionsettings = bluploadsessionsettings.getUploadsessionsettings(uploadsessionsettingsPK);
                            JSONUploadsessionsettings.updateUploadsessionsettings(uploadsessionsettings, jsonuploadsessionsettings);
                            bluploadsessionsettings.updateUploadsessionsettings(uploadsessionsettings);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IUploadsessionsettingsOperation.DELETE_UPLOADSESSIONSETTINGS:
                            uploadsessionsettings = (IUploadsessionsettings)JSONUploadsessionsettings.toUploadsessionsettings((JSONObject)json.get("uploadsessionsettings"));
                            bluploadsessionsettings.deleteUploadsessionsettings(uploadsessionsettings);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IUploadsessionsettingsOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bluploadsessionsettings.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IUploadsessionsettingsOperation.SELECT_ALL:
                            result = JSONUploadsessionsettings.toJSONArray(bluploadsessionsettings.getUploadsessionsettingss()).toJSONString();
                            break;
                        case IUploadsessionsettingsOperation.SELECT_UPLOADSESSIONSETTINGS:
                            uploadsessionsettingsPK = (IUploadsessionsettingsPK)JSONUploadsessionsettings.toUploadsessionsettingsPK((JSONObject)json.get("uploadsessionsettingspk"));
                            result = JSONUploadsessionsettings.toJSON(bluploadsessionsettings.getUploadsessionsettings(uploadsessionsettingsPK)).toJSONString();
                            break;
                        case IUploadsessionsettingsOperation.SELECT_SEARCH:
                            IUploadsessionsettingssearch search = (IUploadsessionsettingssearch)JSONUploadsessionsettings.toUploadsessionsettingssearch((JSONObject)json.get("search"));
                            result = JSONUploadsessionsettings.toJSONArray(bluploadsessionsettings.search(search)).toJSONString();
                            break;
                        case IUploadsessionsettingsOperation.SELECT_SEARCHCOUNT:
                            IUploadsessionsettingssearch uploadsessionsettingssearch = (IUploadsessionsettingssearch)JSONUploadsessionsettings.toUploadsessionsettingssearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bluploadsessionsettings.searchcount(uploadsessionsettingssearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IUploadsessionsettingsOperation.INSERT_UPLOADSESSIONSETTINGS:
                            uploadsessionsettings = (IUploadsessionsettings)JSONUploadsessionsettings.toUploadsessionsettings((JSONObject)json.get("uploadsessionsettings"));
                            bluploadsessionsettings.secureinsertUploadsessionsettings(uploadsessionsettings);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IUploadsessionsettingsOperation.UPDATE_UPLOADSESSIONSETTINGS:
                            JSONObject jsonuploadsessionsettings = (JSONObject)json.get("uploadsessionsettings");
                            uploadsessionsettingsPK = JSONUploadsessionsettings.toUploadsessionsettingsPK((JSONObject)jsonuploadsessionsettings.get("PK"));
                            uploadsessionsettings = bluploadsessionsettings.getUploadsessionsettings(uploadsessionsettingsPK);
                            JSONUploadsessionsettings.updateUploadsessionsettings(uploadsessionsettings, jsonuploadsessionsettings);
                            bluploadsessionsettings.secureupdateUploadsessionsettings(uploadsessionsettings);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IUploadsessionsettingsOperation.DELETE_UPLOADSESSIONSETTINGS:
                            uploadsessionsettings = (IUploadsessionsettings)JSONUploadsessionsettings.toUploadsessionsettings((JSONObject)json.get("uploadsessionsettings"));
                            bluploadsessionsettings.securedeleteUploadsessionsettings(uploadsessionsettings);
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
     * PUT method for updating or creating an instance of RSUploadsessionsettings
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

