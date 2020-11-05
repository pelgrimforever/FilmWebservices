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
import film.interfaces.searchentity.ILocalitysearch;
import film.interfaces.servlet.ILocalityOperation;
import film.logicentity.Locality;
import film.searchentity.Localitysearch;
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
@Path("rslocality")
public class RSLocality {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public RSLocality() {
    }

    /**
     * Retrieves representation of an instance of locality.restservices.RSLocality
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLlocality bllocality = new BLlocality();
            ArrayList localitys = bllocality.getAll();
            JSONArray jsonlocalitys = JSONLocality.toJSONArray(localitys);
            return jsonlocalitys.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of locality.restservices.RSLocality
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLlocality bllocality = new BLlocality();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            ILocalityPK localityPK;
            ILocality locality;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            bllocality.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case ILocalityOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bllocality.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ILocalityOperation.SELECT_ALL:
                            result = JSONLocality.toJSONArray(bllocality.getLocalitys()).toJSONString();
                            break;
                        case ILocalityOperation.SELECT_LOCALITY:
                            localityPK = (ILocalityPK)JSONLocality.toLocalityPK((JSONObject)json.get("localitypk"));
                            result = JSONLocality.toJSON(bllocality.getLocality(localityPK)).toJSONString();
                            break;
                        case ILocalityOperation.SELECT_Postalcode:
                            IPostalcodePK postalcodePK = (IPostalcodePK)JSONPostalcode.toPostalcodePK((JSONObject)json.get("postalcodepk"));
                            result = JSONLocality.toJSONArray(bllocality.getLocalitys4postalcode(postalcodePK)).toJSONString();
                            break;
                        case ILocalityOperation.SELECT_Sublocality:
                            ISublocalityPK sublocalityPK = (ISublocalityPK)JSONSublocality.toSublocalityPK((JSONObject)json.get("sublocalitypk"));
                            result = JSONLocality.toJSON(bllocality.getSublocality(sublocalityPK)).toJSONString();
                            break;
                        case ILocalityOperation.SELECT_SEARCH:
                            ILocalitysearch search = (ILocalitysearch)JSONLocality.toLocalitysearch((JSONObject)json.get("search"));
                            result = JSONLocality.toJSONArray(bllocality.search(search)).toJSONString();
                            break;
                        case ILocalityOperation.SELECT_SEARCHCOUNT:
                            ILocalitysearch localitysearch = (ILocalitysearch)JSONLocality.toLocalitysearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bllocality.searchcount(localitysearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
                        case ILocalityOperation.SELECT_COUNTRY:
                            ICountryPK countryPK = (ICountryPK)JSONCountry.toCountryPK((JSONObject)json.get("countrypk"));
                            result = JSONLocality.toJSONArray(bllocality.getLocalitys4country(countryPK)).toJSONString();
                            break;
                        case ILocalityOperation.SELECT_AL1:
                            IArealevel1PK arealevel1PK = (IArealevel1PK)JSONArealevel1.toArealevel1PK((JSONObject)json.get("arealevel1pk"));
                            result = JSONLocality.toJSONArray(bllocality.getLocalitys4arealevel1(arealevel1PK)).toJSONString();
                            break;
                        case ILocalityOperation.SELECT_AL2:
                            IArealevel2PK arealevel2PK = (IArealevel2PK)JSONArealevel2.toArealevel2PK((JSONObject)json.get("arealevel2pk"));
                            result = JSONLocality.toJSONArray(bllocality.getLocalitys4arealevel2(arealevel2PK)).toJSONString();
                            break;
                        case ILocalityOperation.SELECT_AL3:
                            IArealevel3PK arealevel3PK = (IArealevel3PK)JSONArealevel3.toArealevel3PK((JSONObject)json.get("arealevel3pk"));
                            result = JSONLocality.toJSONArray(bllocality.getLocalitys4arealevel3(arealevel3PK)).toJSONString();
                            break;
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case ILocalityOperation.INSERT_LOCALITY:
                            locality = (ILocality)JSONLocality.toLocality((JSONObject)json.get("locality"));
                            bllocality.insertLocality(locality);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case ILocalityOperation.UPDATE_LOCALITY:
                            JSONObject jsonlocality = (JSONObject)json.get("locality");
                            localityPK = JSONLocality.toLocalityPK((JSONObject)jsonlocality.get("PK"));
                            locality = bllocality.getLocality(localityPK);
                            JSONLocality.updateLocality(locality, jsonlocality);
                            bllocality.updateLocality(locality);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case ILocalityOperation.DELETE_LOCALITY:
                            locality = (ILocality)JSONLocality.toLocality((JSONObject)json.get("locality"));
                            bllocality.deleteLocality(locality);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case ILocalityOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", bllocality.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ILocalityOperation.SELECT_ALL:
                            result = JSONLocality.toJSONArray(bllocality.getLocalitys()).toJSONString();
                            break;
                        case ILocalityOperation.SELECT_LOCALITY:
                            localityPK = (ILocalityPK)JSONLocality.toLocalityPK((JSONObject)json.get("localitypk"));
                            result = JSONLocality.toJSON(bllocality.getLocality(localityPK)).toJSONString();
                            break;
                        case ILocalityOperation.SELECT_Postalcode:
                            IPostalcodePK postalcodePK = (IPostalcodePK)JSONPostalcode.toPostalcodePK((JSONObject)json.get("postalcodepk"));
                            result = JSONLocality.toJSONArray(bllocality.getLocalitys4postalcode(postalcodePK)).toJSONString();
                            break;
                        case ILocalityOperation.SELECT_Sublocality:
                            ISublocalityPK sublocalityPK = (ISublocalityPK)JSONSublocality.toSublocalityPK((JSONObject)json.get("sublocalitypk"));
                            result = JSONLocality.toJSON(bllocality.getSublocality(sublocalityPK)).toJSONString();
                            break;
                        case ILocalityOperation.SELECT_SEARCH:
                            ILocalitysearch search = (ILocalitysearch)JSONLocality.toLocalitysearch((JSONObject)json.get("search"));
                            result = JSONLocality.toJSONArray(bllocality.search(search)).toJSONString();
                            break;
                        case ILocalityOperation.SELECT_SEARCHCOUNT:
                            ILocalitysearch localitysearch = (ILocalitysearch)JSONLocality.toLocalitysearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", bllocality.searchcount(localitysearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case ILocalityOperation.INSERT_LOCALITY:
                            locality = (ILocality)JSONLocality.toLocality((JSONObject)json.get("locality"));
                            bllocality.secureinsertLocality(locality);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case ILocalityOperation.UPDATE_LOCALITY:
                            JSONObject jsonlocality = (JSONObject)json.get("locality");
                            localityPK = JSONLocality.toLocalityPK((JSONObject)jsonlocality.get("PK"));
                            locality = bllocality.getLocality(localityPK);
                            JSONLocality.updateLocality(locality, jsonlocality);
                            bllocality.secureupdateLocality(locality);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case ILocalityOperation.DELETE_LOCALITY:
                            locality = (ILocality)JSONLocality.toLocality((JSONObject)json.get("locality"));
                            bllocality.securedeleteLocality(locality);
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
     * PUT method for updating or creating an instance of RSLocality
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

