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
import film.interfaces.searchentity.IUploadsessionsearch;
import film.interfaces.servlet.IUploadsessionOperation;
import film.logicentity.Uploadsession;
import film.searchentity.Uploadsessionsearch;
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
@Path("rsuploadsession")
public class RSUploadsession {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public RSUploadsession() {
    }

    /**
     * Retrieves representation of an instance of uploadsession.restservices.RSUploadsession
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLuploadsession bluploadsession = new BLuploadsession();
            ArrayList uploadsessions = bluploadsession.getAll();
            JSONArray jsonuploadsessions = JSONUploadsession.toJSONArray(uploadsessions);
            return jsonuploadsessions.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of uploadsession.restservices.RSUploadsession
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLuploadsession bluploadsession = new BLuploadsession();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IUploadsessionPK uploadsessionPK;
            IUploadsession uploadsession;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            bluploadsession.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IUploadsessionOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bluploadsession.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IUploadsessionOperation.SELECT_ALL:
                            result = JSONUploadsession.toJSONArray(bluploadsession.getUploadsessions()).toJSONString();
                            break;
                        case IUploadsessionOperation.SELECT_UPLOADSESSION:
                            uploadsessionPK = (IUploadsessionPK)JSONUploadsession.toUploadsessionPK((JSONObject)json.get("uploadsessionpk"));
                            result = JSONUploadsession.toJSON(bluploadsession.getUploadsession(uploadsessionPK)).toJSONString();
                            break;
                        case IUploadsessionOperation.SELECT_Creator:
                            ICreatorPK creatorPK = (ICreatorPK)JSONCreator.toCreatorPK((JSONObject)json.get("creatorpk"));
                            result = JSONUploadsession.toJSONArray(bluploadsession.getUploadsessions4creator(creatorPK)).toJSONString();
                            break;
                        case IUploadsessionOperation.SELECT_SEARCH:
                            IUploadsessionsearch search = (IUploadsessionsearch)JSONUploadsession.toUploadsessionsearch((JSONObject)json.get("search"));
                            result = JSONUploadsession.toJSONArray(bluploadsession.search(search)).toJSONString();
                            break;
                        case IUploadsessionOperation.SELECT_SEARCHCOUNT:
                            IUploadsessionsearch uploadsessionsearch = (IUploadsessionsearch)JSONUploadsession.toUploadsessionsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bluploadsession.searchcount(uploadsessionsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IUploadsessionOperation.INSERT_UPLOADSESSION:
                            uploadsession = (IUploadsession)JSONUploadsession.toUploadsession((JSONObject)json.get("uploadsession"));
                            bluploadsession.insertUploadsession(uploadsession);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IUploadsessionOperation.UPDATE_UPLOADSESSION:
                            JSONObject jsonuploadsession = (JSONObject)json.get("uploadsession");
                            uploadsessionPK = JSONUploadsession.toUploadsessionPK((JSONObject)jsonuploadsession.get("PK"));
                            uploadsession = bluploadsession.getUploadsession(uploadsessionPK);
                            JSONUploadsession.updateUploadsession(uploadsession, jsonuploadsession);
                            bluploadsession.updateUploadsession(uploadsession);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IUploadsessionOperation.DELETE_UPLOADSESSION:
                            uploadsession = (IUploadsession)JSONUploadsession.toUploadsession((JSONObject)json.get("uploadsession"));
                            bluploadsession.deleteUploadsession(uploadsession);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IUploadsessionOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bluploadsession.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IUploadsessionOperation.SELECT_ALL:
                            result = JSONUploadsession.toJSONArray(bluploadsession.getUploadsessions()).toJSONString();
                            break;
                        case IUploadsessionOperation.SELECT_UPLOADSESSION:
                            uploadsessionPK = (IUploadsessionPK)JSONUploadsession.toUploadsessionPK((JSONObject)json.get("uploadsessionpk"));
                            result = JSONUploadsession.toJSON(bluploadsession.getUploadsession(uploadsessionPK)).toJSONString();
                            break;
                        case IUploadsessionOperation.SELECT_Creator:
                            ICreatorPK creatorPK = (ICreatorPK)JSONCreator.toCreatorPK((JSONObject)json.get("creatorpk"));
                            result = JSONUploadsession.toJSONArray(bluploadsession.getUploadsessions4creator(creatorPK)).toJSONString();
                            break;
                        case IUploadsessionOperation.SELECT_SEARCH:
                            IUploadsessionsearch search = (IUploadsessionsearch)JSONUploadsession.toUploadsessionsearch((JSONObject)json.get("search"));
                            result = JSONUploadsession.toJSONArray(bluploadsession.search(search)).toJSONString();
                            break;
                        case IUploadsessionOperation.SELECT_SEARCHCOUNT:
                            IUploadsessionsearch uploadsessionsearch = (IUploadsessionsearch)JSONUploadsession.toUploadsessionsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bluploadsession.searchcount(uploadsessionsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IUploadsessionOperation.INSERT_UPLOADSESSION:
                            uploadsession = (IUploadsession)JSONUploadsession.toUploadsession((JSONObject)json.get("uploadsession"));
                            bluploadsession.secureinsertUploadsession(uploadsession);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IUploadsessionOperation.UPDATE_UPLOADSESSION:
                            JSONObject jsonuploadsession = (JSONObject)json.get("uploadsession");
                            uploadsessionPK = JSONUploadsession.toUploadsessionPK((JSONObject)jsonuploadsession.get("PK"));
                            uploadsession = bluploadsession.getUploadsession(uploadsessionPK);
                            JSONUploadsession.updateUploadsession(uploadsession, jsonuploadsession);
                            bluploadsession.secureupdateUploadsession(uploadsession);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IUploadsessionOperation.DELETE_UPLOADSESSION:
                            uploadsession = (IUploadsession)JSONUploadsession.toUploadsession((JSONObject)json.get("uploadsession"));
                            bluploadsession.securedeleteUploadsession(uploadsession);
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
     * PUT method for updating or creating an instance of RSUploadsession
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

