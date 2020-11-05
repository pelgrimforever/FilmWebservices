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
import film.interfaces.searchentity.IArealevel3search;
import film.interfaces.servlet.IArealevel3Operation;
import film.logicentity.Arealevel3;
import film.searchentity.Arealevel3search;
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
@Path("rsarealevel3")
public class RSArealevel3 {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public RSArealevel3() {
    }

    /**
     * Retrieves representation of an instance of arealevel3.restservices.RSArealevel3
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLarealevel3 blarealevel3 = new BLarealevel3();
            ArrayList arealevel3s = blarealevel3.getAll();
            JSONArray jsonarealevel3s = JSONArealevel3.toJSONArray(arealevel3s);
            return jsonarealevel3s.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of arealevel3.restservices.RSArealevel3
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLarealevel3 blarealevel3 = new BLarealevel3();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IArealevel3PK arealevel3PK;
            IArealevel3 arealevel3;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blarealevel3.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IArealevel3Operation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blarealevel3.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IArealevel3Operation.SELECT_ALL:
                            result = JSONArealevel3.toJSONArray(blarealevel3.getArealevel3s()).toJSONString();
                            break;
                        case IArealevel3Operation.SELECT_AREALEVEL3:
                            arealevel3PK = (IArealevel3PK)JSONArealevel3.toArealevel3PK((JSONObject)json.get("arealevel3pk"));
                            result = JSONArealevel3.toJSON(blarealevel3.getArealevel3(arealevel3PK)).toJSONString();
                            break;
                        case IArealevel3Operation.SELECT_Arealevel2:
                            IArealevel2PK arealevel2PK = (IArealevel2PK)JSONArealevel2.toArealevel2PK((JSONObject)json.get("arealevel2pk"));
                            result = JSONArealevel3.toJSONArray(blarealevel3.getArealevel3s4arealevel2(arealevel2PK)).toJSONString();
                            break;
                        case IArealevel3Operation.SELECT_SEARCH:
                            IArealevel3search search = (IArealevel3search)JSONArealevel3.toArealevel3search((JSONObject)json.get("search"));
                            result = JSONArealevel3.toJSONArray(blarealevel3.search(search)).toJSONString();
                            break;
                        case IArealevel3Operation.SELECT_SEARCHCOUNT:
                            IArealevel3search arealevel3search = (IArealevel3search)JSONArealevel3.toArealevel3search((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blarealevel3.searchcount(arealevel3search));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IArealevel3Operation.INSERT_AREALEVEL3:
                            arealevel3 = (IArealevel3)JSONArealevel3.toArealevel3((JSONObject)json.get("arealevel3"));
                            blarealevel3.insertArealevel3(arealevel3);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IArealevel3Operation.UPDATE_AREALEVEL3:
                            JSONObject jsonarealevel3 = (JSONObject)json.get("arealevel3");
                            arealevel3PK = JSONArealevel3.toArealevel3PK((JSONObject)jsonarealevel3.get("PK"));
                            arealevel3 = blarealevel3.getArealevel3(arealevel3PK);
                            JSONArealevel3.updateArealevel3(arealevel3, jsonarealevel3);
                            blarealevel3.updateArealevel3(arealevel3);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IArealevel3Operation.DELETE_AREALEVEL3:
                            arealevel3 = (IArealevel3)JSONArealevel3.toArealevel3((JSONObject)json.get("arealevel3"));
                            blarealevel3.deleteArealevel3(arealevel3);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IArealevel3Operation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blarealevel3.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IArealevel3Operation.SELECT_ALL:
                            result = JSONArealevel3.toJSONArray(blarealevel3.getArealevel3s()).toJSONString();
                            break;
                        case IArealevel3Operation.SELECT_AREALEVEL3:
                            arealevel3PK = (IArealevel3PK)JSONArealevel3.toArealevel3PK((JSONObject)json.get("arealevel3pk"));
                            result = JSONArealevel3.toJSON(blarealevel3.getArealevel3(arealevel3PK)).toJSONString();
                            break;
                        case IArealevel3Operation.SELECT_Arealevel2:
                            IArealevel2PK arealevel2PK = (IArealevel2PK)JSONArealevel2.toArealevel2PK((JSONObject)json.get("arealevel2pk"));
                            result = JSONArealevel3.toJSONArray(blarealevel3.getArealevel3s4arealevel2(arealevel2PK)).toJSONString();
                            break;
                        case IArealevel3Operation.SELECT_SEARCH:
                            IArealevel3search search = (IArealevel3search)JSONArealevel3.toArealevel3search((JSONObject)json.get("search"));
                            result = JSONArealevel3.toJSONArray(blarealevel3.search(search)).toJSONString();
                            break;
                        case IArealevel3Operation.SELECT_SEARCHCOUNT:
                            IArealevel3search arealevel3search = (IArealevel3search)JSONArealevel3.toArealevel3search((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blarealevel3.searchcount(arealevel3search));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IArealevel3Operation.INSERT_AREALEVEL3:
                            arealevel3 = (IArealevel3)JSONArealevel3.toArealevel3((JSONObject)json.get("arealevel3"));
                            blarealevel3.secureinsertArealevel3(arealevel3);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IArealevel3Operation.UPDATE_AREALEVEL3:
                            JSONObject jsonarealevel3 = (JSONObject)json.get("arealevel3");
                            arealevel3PK = JSONArealevel3.toArealevel3PK((JSONObject)jsonarealevel3.get("PK"));
                            arealevel3 = blarealevel3.getArealevel3(arealevel3PK);
                            JSONArealevel3.updateArealevel3(arealevel3, jsonarealevel3);
                            blarealevel3.secureupdateArealevel3(arealevel3);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IArealevel3Operation.DELETE_AREALEVEL3:
                            arealevel3 = (IArealevel3)JSONArealevel3.toArealevel3((JSONObject)json.get("arealevel3"));
                            blarealevel3.securedeleteArealevel3(arealevel3);
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
     * PUT method for updating or creating an instance of RSArealevel3
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

