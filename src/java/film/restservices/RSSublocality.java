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
import film.interfaces.searchentity.ISublocalitysearch;
import film.interfaces.servlet.ISublocalityOperation;
import film.logicentity.Sublocality;
import film.searchentity.Sublocalitysearch;
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
@Path("rssublocality")
public class RSSublocality {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public RSSublocality() {
    }

    /**
     * Retrieves representation of an instance of sublocality.restservices.RSSublocality
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLsublocality blsublocality = new BLsublocality();
            ArrayList sublocalitys = blsublocality.getAll();
            JSONArray jsonsublocalitys = JSONSublocality.toJSONArray(sublocalitys);
            return jsonsublocalitys.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of sublocality.restservices.RSSublocality
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLsublocality blsublocality = new BLsublocality();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            ISublocalityPK sublocalityPK;
            ISublocality sublocality;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blsublocality.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case ISublocalityOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blsublocality.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISublocalityOperation.SELECT_ALL:
                            result = JSONSublocality.toJSONArray(blsublocality.getSublocalitys()).toJSONString();
                            break;
                        case ISublocalityOperation.SELECT_SUBLOCALITY:
                            sublocalityPK = (ISublocalityPK)JSONSublocality.toSublocalityPK((JSONObject)json.get("sublocalitypk"));
                            result = JSONSublocality.toJSON(blsublocality.getSublocality(sublocalityPK)).toJSONString();
                            break;
                        case ISublocalityOperation.SELECT_Locality:
                            ILocalityPK localityPK = (ILocalityPK)JSONLocality.toLocalityPK((JSONObject)json.get("localitypk"));
                            result = JSONSublocality.toJSONArray(blsublocality.getSublocalitys4locality(localityPK)).toJSONString();
                            break;
                        case ISublocalityOperation.SELECT_Route:
                            IRoutePK routePK = (IRoutePK)JSONRoute.toRoutePK((JSONObject)json.get("routepk"));
                            result = JSONSublocality.toJSON(blsublocality.getRoute(routePK)).toJSONString();
                            break;
                        case ISublocalityOperation.SELECT_SEARCH:
                            ISublocalitysearch search = (ISublocalitysearch)JSONSublocality.toSublocalitysearch((JSONObject)json.get("search"));
                            result = JSONSublocality.toJSONArray(blsublocality.search(search)).toJSONString();
                            break;
                        case ISublocalityOperation.SELECT_SEARCHCOUNT:
                            ISublocalitysearch sublocalitysearch = (ISublocalitysearch)JSONSublocality.toSublocalitysearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blsublocality.searchcount(sublocalitysearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case ISublocalityOperation.INSERT_SUBLOCALITY:
                            sublocality = (ISublocality)JSONSublocality.toSublocality((JSONObject)json.get("sublocality"));
                            blsublocality.insertSublocality(sublocality);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case ISublocalityOperation.UPDATE_SUBLOCALITY:
                            JSONObject jsonsublocality = (JSONObject)json.get("sublocality");
                            sublocalityPK = JSONSublocality.toSublocalityPK((JSONObject)jsonsublocality.get("PK"));
                            sublocality = blsublocality.getSublocality(sublocalityPK);
                            JSONSublocality.updateSublocality(sublocality, jsonsublocality);
                            blsublocality.updateSublocality(sublocality);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case ISublocalityOperation.DELETE_SUBLOCALITY:
                            sublocality = (ISublocality)JSONSublocality.toSublocality((JSONObject)json.get("sublocality"));
                            blsublocality.deleteSublocality(sublocality);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case ISublocalityOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blsublocality.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISublocalityOperation.SELECT_ALL:
                            result = JSONSublocality.toJSONArray(blsublocality.getSublocalitys()).toJSONString();
                            break;
                        case ISublocalityOperation.SELECT_SUBLOCALITY:
                            sublocalityPK = (ISublocalityPK)JSONSublocality.toSublocalityPK((JSONObject)json.get("sublocalitypk"));
                            result = JSONSublocality.toJSON(blsublocality.getSublocality(sublocalityPK)).toJSONString();
                            break;
                        case ISublocalityOperation.SELECT_Locality:
                            ILocalityPK localityPK = (ILocalityPK)JSONLocality.toLocalityPK((JSONObject)json.get("localitypk"));
                            result = JSONSublocality.toJSONArray(blsublocality.getSublocalitys4locality(localityPK)).toJSONString();
                            break;
                        case ISublocalityOperation.SELECT_Route:
                            IRoutePK routePK = (IRoutePK)JSONRoute.toRoutePK((JSONObject)json.get("routepk"));
                            result = JSONSublocality.toJSON(blsublocality.getRoute(routePK)).toJSONString();
                            break;
                        case ISublocalityOperation.SELECT_SEARCH:
                            ISublocalitysearch search = (ISublocalitysearch)JSONSublocality.toSublocalitysearch((JSONObject)json.get("search"));
                            result = JSONSublocality.toJSONArray(blsublocality.search(search)).toJSONString();
                            break;
                        case ISublocalityOperation.SELECT_SEARCHCOUNT:
                            ISublocalitysearch sublocalitysearch = (ISublocalitysearch)JSONSublocality.toSublocalitysearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blsublocality.searchcount(sublocalitysearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case ISublocalityOperation.INSERT_SUBLOCALITY:
                            sublocality = (ISublocality)JSONSublocality.toSublocality((JSONObject)json.get("sublocality"));
                            blsublocality.secureinsertSublocality(sublocality);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case ISublocalityOperation.UPDATE_SUBLOCALITY:
                            JSONObject jsonsublocality = (JSONObject)json.get("sublocality");
                            sublocalityPK = JSONSublocality.toSublocalityPK((JSONObject)jsonsublocality.get("PK"));
                            sublocality = blsublocality.getSublocality(sublocalityPK);
                            JSONSublocality.updateSublocality(sublocality, jsonsublocality);
                            blsublocality.secureupdateSublocality(sublocality);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case ISublocalityOperation.DELETE_SUBLOCALITY:
                            sublocality = (ISublocality)JSONSublocality.toSublocality((JSONObject)json.get("sublocality"));
                            blsublocality.securedeleteSublocality(sublocality);
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
     * PUT method for updating or creating an instance of RSSublocality
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

