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
import film.interfaces.searchentity.ICountrysearch;
import film.interfaces.servlet.ICountryOperation;
import film.logicentity.Country;
import film.searchentity.Countrysearch;
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
@Path("rscountry")
public class RSCountry {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public RSCountry() {
    }

    /**
     * Retrieves representation of an instance of country.restservices.RSCountry
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLcountry blcountry = new BLcountry();
            ArrayList countrys = blcountry.getAll();
            JSONArray jsoncountrys = JSONCountry.toJSONArray(countrys);
            return jsoncountrys.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of country.restservices.RSCountry
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLcountry blcountry = new BLcountry();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            ICountryPK countryPK;
            ICountry country;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blcountry.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case ICountryOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blcountry.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ICountryOperation.SELECT_ALL:
                            result = JSONCountry.toJSONArray(blcountry.getCountrys()).toJSONString();
                            break;
                        case ICountryOperation.SELECT_COUNTRY:
                            countryPK = (ICountryPK)JSONCountry.toCountryPK((JSONObject)json.get("countrypk"));
                            result = JSONCountry.toJSON(blcountry.getCountry(countryPK)).toJSONString();
                            break;
                        case ICountryOperation.SELECT_Arealevel1:
                            IArealevel1PK arealevel1PK = (IArealevel1PK)JSONArealevel1.toArealevel1PK((JSONObject)json.get("arealevel1pk"));
                            result = JSONCountry.toJSON(blcountry.getArealevel1(arealevel1PK)).toJSONString();
                            break;
                        case ICountryOperation.SELECT_SEARCH:
                            ICountrysearch search = (ICountrysearch)JSONCountry.toCountrysearch((JSONObject)json.get("search"));
                            result = JSONCountry.toJSONArray(blcountry.search(search)).toJSONString();
                            break;
                        case ICountryOperation.SELECT_SEARCHCOUNT:
                            ICountrysearch countrysearch = (ICountrysearch)JSONCountry.toCountrysearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blcountry.searchcount(countrysearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case ICountryOperation.INSERT_COUNTRY:
                            country = (ICountry)JSONCountry.toCountry((JSONObject)json.get("country"));
                            blcountry.insertCountry(country);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case ICountryOperation.UPDATE_COUNTRY:
                            JSONObject jsoncountry = (JSONObject)json.get("country");
                            countryPK = JSONCountry.toCountryPK((JSONObject)jsoncountry.get("PK"));
                            country = blcountry.getCountry(countryPK);
                            JSONCountry.updateCountry(country, jsoncountry);
                            blcountry.updateCountry(country);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case ICountryOperation.DELETE_COUNTRY:
                            country = (ICountry)JSONCountry.toCountry((JSONObject)json.get("country"));
                            blcountry.deleteCountry(country);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case ICountryOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blcountry.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ICountryOperation.SELECT_ALL:
                            result = JSONCountry.toJSONArray(blcountry.getCountrys()).toJSONString();
                            break;
                        case ICountryOperation.SELECT_COUNTRY:
                            countryPK = (ICountryPK)JSONCountry.toCountryPK((JSONObject)json.get("countrypk"));
                            result = JSONCountry.toJSON(blcountry.getCountry(countryPK)).toJSONString();
                            break;
                        case ICountryOperation.SELECT_Arealevel1:
                            IArealevel1PK arealevel1PK = (IArealevel1PK)JSONArealevel1.toArealevel1PK((JSONObject)json.get("arealevel1pk"));
                            result = JSONCountry.toJSON(blcountry.getArealevel1(arealevel1PK)).toJSONString();
                            break;
                        case ICountryOperation.SELECT_SEARCH:
                            ICountrysearch search = (ICountrysearch)JSONCountry.toCountrysearch((JSONObject)json.get("search"));
                            result = JSONCountry.toJSONArray(blcountry.search(search)).toJSONString();
                            break;
                        case ICountryOperation.SELECT_SEARCHCOUNT:
                            ICountrysearch countrysearch = (ICountrysearch)JSONCountry.toCountrysearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blcountry.searchcount(countrysearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case ICountryOperation.INSERT_COUNTRY:
                            country = (ICountry)JSONCountry.toCountry((JSONObject)json.get("country"));
                            blcountry.secureinsertCountry(country);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case ICountryOperation.UPDATE_COUNTRY:
                            JSONObject jsoncountry = (JSONObject)json.get("country");
                            countryPK = JSONCountry.toCountryPK((JSONObject)jsoncountry.get("PK"));
                            country = blcountry.getCountry(countryPK);
                            JSONCountry.updateCountry(country, jsoncountry);
                            blcountry.secureupdateCountry(country);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case ICountryOperation.DELETE_COUNTRY:
                            country = (ICountry)JSONCountry.toCountry((JSONObject)json.get("country"));
                            blcountry.securedeleteCountry(country);
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
     * PUT method for updating or creating an instance of RSCountry
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

