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
import film.interfaces.searchentity.IArealevel1search;
import film.interfaces.servlet.IArealevel1Operation;
import film.logicentity.Arealevel1;
import film.searchentity.Arealevel1search;
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
@Path("rsarealevel1")
public class RSArealevel1 {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public RSArealevel1() {
    }

    /**
     * Retrieves representation of an instance of arealevel1.restservices.RSArealevel1
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLarealevel1 blarealevel1 = new BLarealevel1();
            ArrayList arealevel1s = blarealevel1.getAll();
            JSONArray jsonarealevel1s = JSONArealevel1.toJSONArray(arealevel1s);
            return jsonarealevel1s.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of arealevel1.restservices.RSArealevel1
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLarealevel1 blarealevel1 = new BLarealevel1();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IArealevel1PK arealevel1PK;
            IArealevel1 arealevel1;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blarealevel1.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IArealevel1Operation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blarealevel1.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IArealevel1Operation.SELECT_ALL:
                            result = JSONArealevel1.toJSONArray(blarealevel1.getArealevel1s()).toJSONString();
                            break;
                        case IArealevel1Operation.SELECT_AREALEVEL1:
                            arealevel1PK = (IArealevel1PK)JSONArealevel1.toArealevel1PK((JSONObject)json.get("arealevel1pk"));
                            result = JSONArealevel1.toJSON(blarealevel1.getArealevel1(arealevel1PK)).toJSONString();
                            break;
                        case IArealevel1Operation.SELECT_Country:
                            ICountryPK countryPK = (ICountryPK)JSONCountry.toCountryPK((JSONObject)json.get("countrypk"));
                            result = JSONArealevel1.toJSONArray(blarealevel1.getArealevel1s4country(countryPK)).toJSONString();
                            break;
                        case IArealevel1Operation.SELECT_Arealevel2:
                            IArealevel2PK arealevel2PK = (IArealevel2PK)JSONArealevel2.toArealevel2PK((JSONObject)json.get("arealevel2pk"));
                            result = JSONArealevel1.toJSON(blarealevel1.getArealevel2(arealevel2PK)).toJSONString();
                            break;
                        case IArealevel1Operation.SELECT_SEARCH:
                            IArealevel1search search = (IArealevel1search)JSONArealevel1.toArealevel1search((JSONObject)json.get("search"));
                            result = JSONArealevel1.toJSONArray(blarealevel1.search(search)).toJSONString();
                            break;
                        case IArealevel1Operation.SELECT_SEARCHCOUNT:
                            IArealevel1search arealevel1search = (IArealevel1search)JSONArealevel1.toArealevel1search((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blarealevel1.searchcount(arealevel1search));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IArealevel1Operation.INSERT_AREALEVEL1:
                            arealevel1 = (IArealevel1)JSONArealevel1.toArealevel1((JSONObject)json.get("arealevel1"));
                            blarealevel1.insertArealevel1(arealevel1);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IArealevel1Operation.UPDATE_AREALEVEL1:
                            JSONObject jsonarealevel1 = (JSONObject)json.get("arealevel1");
                            arealevel1PK = JSONArealevel1.toArealevel1PK((JSONObject)jsonarealevel1.get("PK"));
                            arealevel1 = blarealevel1.getArealevel1(arealevel1PK);
                            JSONArealevel1.updateArealevel1(arealevel1, jsonarealevel1);
                            blarealevel1.updateArealevel1(arealevel1);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IArealevel1Operation.DELETE_AREALEVEL1:
                            arealevel1 = (IArealevel1)JSONArealevel1.toArealevel1((JSONObject)json.get("arealevel1"));
                            blarealevel1.deleteArealevel1(arealevel1);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IArealevel1Operation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blarealevel1.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IArealevel1Operation.SELECT_ALL:
                            result = JSONArealevel1.toJSONArray(blarealevel1.getArealevel1s()).toJSONString();
                            break;
                        case IArealevel1Operation.SELECT_AREALEVEL1:
                            arealevel1PK = (IArealevel1PK)JSONArealevel1.toArealevel1PK((JSONObject)json.get("arealevel1pk"));
                            result = JSONArealevel1.toJSON(blarealevel1.getArealevel1(arealevel1PK)).toJSONString();
                            break;
                        case IArealevel1Operation.SELECT_Country:
                            ICountryPK countryPK = (ICountryPK)JSONCountry.toCountryPK((JSONObject)json.get("countrypk"));
                            result = JSONArealevel1.toJSONArray(blarealevel1.getArealevel1s4country(countryPK)).toJSONString();
                            break;
                        case IArealevel1Operation.SELECT_Arealevel2:
                            IArealevel2PK arealevel2PK = (IArealevel2PK)JSONArealevel2.toArealevel2PK((JSONObject)json.get("arealevel2pk"));
                            result = JSONArealevel1.toJSON(blarealevel1.getArealevel2(arealevel2PK)).toJSONString();
                            break;
                        case IArealevel1Operation.SELECT_SEARCH:
                            IArealevel1search search = (IArealevel1search)JSONArealevel1.toArealevel1search((JSONObject)json.get("search"));
                            result = JSONArealevel1.toJSONArray(blarealevel1.search(search)).toJSONString();
                            break;
                        case IArealevel1Operation.SELECT_SEARCHCOUNT:
                            IArealevel1search arealevel1search = (IArealevel1search)JSONArealevel1.toArealevel1search((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blarealevel1.searchcount(arealevel1search));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IArealevel1Operation.INSERT_AREALEVEL1:
                            arealevel1 = (IArealevel1)JSONArealevel1.toArealevel1((JSONObject)json.get("arealevel1"));
                            blarealevel1.secureinsertArealevel1(arealevel1);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IArealevel1Operation.UPDATE_AREALEVEL1:
                            JSONObject jsonarealevel1 = (JSONObject)json.get("arealevel1");
                            arealevel1PK = JSONArealevel1.toArealevel1PK((JSONObject)jsonarealevel1.get("PK"));
                            arealevel1 = blarealevel1.getArealevel1(arealevel1PK);
                            JSONArealevel1.updateArealevel1(arealevel1, jsonarealevel1);
                            blarealevel1.secureupdateArealevel1(arealevel1);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IArealevel1Operation.DELETE_AREALEVEL1:
                            arealevel1 = (IArealevel1)JSONArealevel1.toArealevel1((JSONObject)json.get("arealevel1"));
                            blarealevel1.securedeleteArealevel1(arealevel1);
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
     * PUT method for updating or creating an instance of RSArealevel1
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

