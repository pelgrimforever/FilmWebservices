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
import film.interfaces.searchentity.IArealevel2search;
import film.interfaces.servlet.IArealevel2Operation;
import film.logicentity.Arealevel2;
import film.searchentity.Arealevel2search;
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
@Path("rsarealevel2")
public class RSArealevel2 {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public RSArealevel2() {
    }

    /**
     * Retrieves representation of an instance of arealevel2.restservices.RSArealevel2
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLarealevel2 blarealevel2 = new BLarealevel2();
            ArrayList arealevel2s = blarealevel2.getAll();
            JSONArray jsonarealevel2s = JSONArealevel2.toJSONArray(arealevel2s);
            return jsonarealevel2s.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of arealevel2.restservices.RSArealevel2
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLarealevel2 blarealevel2 = new BLarealevel2();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IArealevel2PK arealevel2PK;
            IArealevel2 arealevel2;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blarealevel2.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IArealevel2Operation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blarealevel2.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IArealevel2Operation.SELECT_ALL:
                            result = JSONArealevel2.toJSONArray(blarealevel2.getArealevel2s()).toJSONString();
                            break;
                        case IArealevel2Operation.SELECT_AREALEVEL2:
                            arealevel2PK = (IArealevel2PK)JSONArealevel2.toArealevel2PK((JSONObject)json.get("arealevel2pk"));
                            result = JSONArealevel2.toJSON(blarealevel2.getArealevel2(arealevel2PK)).toJSONString();
                            break;
                        case IArealevel2Operation.SELECT_Arealevel1:
                            IArealevel1PK arealevel1PK = (IArealevel1PK)JSONArealevel1.toArealevel1PK((JSONObject)json.get("arealevel1pk"));
                            result = JSONArealevel2.toJSONArray(blarealevel2.getArealevel2s4arealevel1(arealevel1PK)).toJSONString();
                            break;
                        case IArealevel2Operation.SELECT_Arealevel3:
                            IArealevel3PK arealevel3PK = (IArealevel3PK)JSONArealevel3.toArealevel3PK((JSONObject)json.get("arealevel3pk"));
                            result = JSONArealevel2.toJSON(blarealevel2.getArealevel3(arealevel3PK)).toJSONString();
                            break;
                        case IArealevel2Operation.SELECT_SEARCH:
                            IArealevel2search search = (IArealevel2search)JSONArealevel2.toArealevel2search((JSONObject)json.get("search"));
                            result = JSONArealevel2.toJSONArray(blarealevel2.search(search)).toJSONString();
                            break;
                        case IArealevel2Operation.SELECT_SEARCHCOUNT:
                            IArealevel2search arealevel2search = (IArealevel2search)JSONArealevel2.toArealevel2search((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blarealevel2.searchcount(arealevel2search));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IArealevel2Operation.INSERT_AREALEVEL2:
                            arealevel2 = (IArealevel2)JSONArealevel2.toArealevel2((JSONObject)json.get("arealevel2"));
                            blarealevel2.insertArealevel2(arealevel2);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IArealevel2Operation.UPDATE_AREALEVEL2:
                            JSONObject jsonarealevel2 = (JSONObject)json.get("arealevel2");
                            arealevel2PK = JSONArealevel2.toArealevel2PK((JSONObject)jsonarealevel2.get("PK"));
                            arealevel2 = blarealevel2.getArealevel2(arealevel2PK);
                            JSONArealevel2.updateArealevel2(arealevel2, jsonarealevel2);
                            blarealevel2.updateArealevel2(arealevel2);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IArealevel2Operation.DELETE_AREALEVEL2:
                            arealevel2 = (IArealevel2)JSONArealevel2.toArealevel2((JSONObject)json.get("arealevel2"));
                            blarealevel2.deleteArealevel2(arealevel2);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IArealevel2Operation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blarealevel2.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IArealevel2Operation.SELECT_ALL:
                            result = JSONArealevel2.toJSONArray(blarealevel2.getArealevel2s()).toJSONString();
                            break;
                        case IArealevel2Operation.SELECT_AREALEVEL2:
                            arealevel2PK = (IArealevel2PK)JSONArealevel2.toArealevel2PK((JSONObject)json.get("arealevel2pk"));
                            result = JSONArealevel2.toJSON(blarealevel2.getArealevel2(arealevel2PK)).toJSONString();
                            break;
                        case IArealevel2Operation.SELECT_Arealevel1:
                            IArealevel1PK arealevel1PK = (IArealevel1PK)JSONArealevel1.toArealevel1PK((JSONObject)json.get("arealevel1pk"));
                            result = JSONArealevel2.toJSONArray(blarealevel2.getArealevel2s4arealevel1(arealevel1PK)).toJSONString();
                            break;
                        case IArealevel2Operation.SELECT_Arealevel3:
                            IArealevel3PK arealevel3PK = (IArealevel3PK)JSONArealevel3.toArealevel3PK((JSONObject)json.get("arealevel3pk"));
                            result = JSONArealevel2.toJSON(blarealevel2.getArealevel3(arealevel3PK)).toJSONString();
                            break;
                        case IArealevel2Operation.SELECT_SEARCH:
                            IArealevel2search search = (IArealevel2search)JSONArealevel2.toArealevel2search((JSONObject)json.get("search"));
                            result = JSONArealevel2.toJSONArray(blarealevel2.search(search)).toJSONString();
                            break;
                        case IArealevel2Operation.SELECT_SEARCHCOUNT:
                            IArealevel2search arealevel2search = (IArealevel2search)JSONArealevel2.toArealevel2search((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blarealevel2.searchcount(arealevel2search));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IArealevel2Operation.INSERT_AREALEVEL2:
                            arealevel2 = (IArealevel2)JSONArealevel2.toArealevel2((JSONObject)json.get("arealevel2"));
                            blarealevel2.secureinsertArealevel2(arealevel2);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IArealevel2Operation.UPDATE_AREALEVEL2:
                            JSONObject jsonarealevel2 = (JSONObject)json.get("arealevel2");
                            arealevel2PK = JSONArealevel2.toArealevel2PK((JSONObject)jsonarealevel2.get("PK"));
                            arealevel2 = blarealevel2.getArealevel2(arealevel2PK);
                            JSONArealevel2.updateArealevel2(arealevel2, jsonarealevel2);
                            blarealevel2.secureupdateArealevel2(arealevel2);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IArealevel2Operation.DELETE_AREALEVEL2:
                            arealevel2 = (IArealevel2)JSONArealevel2.toArealevel2((JSONObject)json.get("arealevel2"));
                            blarealevel2.securedeleteArealevel2(arealevel2);
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
     * PUT method for updating or creating an instance of RSArealevel2
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

