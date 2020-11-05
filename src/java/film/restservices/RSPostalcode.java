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
import film.interfaces.searchentity.IPostalcodesearch;
import film.interfaces.servlet.IPostalcodeOperation;
import film.logicentity.Postalcode;
import film.searchentity.Postalcodesearch;
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
@Path("rspostalcode")
public class RSPostalcode {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public RSPostalcode() {
    }

    /**
     * Retrieves representation of an instance of postalcode.restservices.RSPostalcode
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLpostalcode blpostalcode = new BLpostalcode();
            ArrayList postalcodes = blpostalcode.getAll();
            JSONArray jsonpostalcodes = JSONPostalcode.toJSONArray(postalcodes);
            return jsonpostalcodes.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of postalcode.restservices.RSPostalcode
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLpostalcode blpostalcode = new BLpostalcode();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IPostalcodePK postalcodePK;
            IPostalcode postalcode;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blpostalcode.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IPostalcodeOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blpostalcode.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IPostalcodeOperation.SELECT_ALL:
                            result = JSONPostalcode.toJSONArray(blpostalcode.getPostalcodes()).toJSONString();
                            break;
                        case IPostalcodeOperation.SELECT_POSTALCODE:
                            postalcodePK = (IPostalcodePK)JSONPostalcode.toPostalcodePK((JSONObject)json.get("postalcodepk"));
                            result = JSONPostalcode.toJSON(blpostalcode.getPostalcode(postalcodePK)).toJSONString();
                            break;
                        case IPostalcodeOperation.SELECT_Arealevel3:
                            IArealevel3PK arealevel3PK = (IArealevel3PK)JSONArealevel3.toArealevel3PK((JSONObject)json.get("arealevel3pk"));
                            result = JSONPostalcode.toJSONArray(blpostalcode.getPostalcodes4arealevel3(arealevel3PK)).toJSONString();
                            break;
                        case IPostalcodeOperation.SELECT_Locality:
                            ILocalityPK localityPK = (ILocalityPK)JSONLocality.toLocalityPK((JSONObject)json.get("localitypk"));
                            result = JSONPostalcode.toJSON(blpostalcode.getLocality(localityPK)).toJSONString();
                            break;
                        case IPostalcodeOperation.SELECT_SEARCH:
                            IPostalcodesearch search = (IPostalcodesearch)JSONPostalcode.toPostalcodesearch((JSONObject)json.get("search"));
                            result = JSONPostalcode.toJSONArray(blpostalcode.search(search)).toJSONString();
                            break;
                        case IPostalcodeOperation.SELECT_SEARCHCOUNT:
                            IPostalcodesearch postalcodesearch = (IPostalcodesearch)JSONPostalcode.toPostalcodesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blpostalcode.searchcount(postalcodesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IPostalcodeOperation.INSERT_POSTALCODE:
                            postalcode = (IPostalcode)JSONPostalcode.toPostalcode((JSONObject)json.get("postalcode"));
                            blpostalcode.insertPostalcode(postalcode);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IPostalcodeOperation.UPDATE_POSTALCODE:
                            JSONObject jsonpostalcode = (JSONObject)json.get("postalcode");
                            postalcodePK = JSONPostalcode.toPostalcodePK((JSONObject)jsonpostalcode.get("PK"));
                            postalcode = blpostalcode.getPostalcode(postalcodePK);
                            JSONPostalcode.updatePostalcode(postalcode, jsonpostalcode);
                            blpostalcode.updatePostalcode(postalcode);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IPostalcodeOperation.DELETE_POSTALCODE:
                            postalcode = (IPostalcode)JSONPostalcode.toPostalcode((JSONObject)json.get("postalcode"));
                            blpostalcode.deletePostalcode(postalcode);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IPostalcodeOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blpostalcode.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IPostalcodeOperation.SELECT_ALL:
                            result = JSONPostalcode.toJSONArray(blpostalcode.getPostalcodes()).toJSONString();
                            break;
                        case IPostalcodeOperation.SELECT_POSTALCODE:
                            postalcodePK = (IPostalcodePK)JSONPostalcode.toPostalcodePK((JSONObject)json.get("postalcodepk"));
                            result = JSONPostalcode.toJSON(blpostalcode.getPostalcode(postalcodePK)).toJSONString();
                            break;
                        case IPostalcodeOperation.SELECT_Arealevel3:
                            IArealevel3PK arealevel3PK = (IArealevel3PK)JSONArealevel3.toArealevel3PK((JSONObject)json.get("arealevel3pk"));
                            result = JSONPostalcode.toJSONArray(blpostalcode.getPostalcodes4arealevel3(arealevel3PK)).toJSONString();
                            break;
                        case IPostalcodeOperation.SELECT_Locality:
                            ILocalityPK localityPK = (ILocalityPK)JSONLocality.toLocalityPK((JSONObject)json.get("localitypk"));
                            result = JSONPostalcode.toJSON(blpostalcode.getLocality(localityPK)).toJSONString();
                            break;
                        case IPostalcodeOperation.SELECT_SEARCH:
                            IPostalcodesearch search = (IPostalcodesearch)JSONPostalcode.toPostalcodesearch((JSONObject)json.get("search"));
                            result = JSONPostalcode.toJSONArray(blpostalcode.search(search)).toJSONString();
                            break;
                        case IPostalcodeOperation.SELECT_SEARCHCOUNT:
                            IPostalcodesearch postalcodesearch = (IPostalcodesearch)JSONPostalcode.toPostalcodesearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blpostalcode.searchcount(postalcodesearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IPostalcodeOperation.INSERT_POSTALCODE:
                            postalcode = (IPostalcode)JSONPostalcode.toPostalcode((JSONObject)json.get("postalcode"));
                            blpostalcode.secureinsertPostalcode(postalcode);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IPostalcodeOperation.UPDATE_POSTALCODE:
                            JSONObject jsonpostalcode = (JSONObject)json.get("postalcode");
                            postalcodePK = JSONPostalcode.toPostalcodePK((JSONObject)jsonpostalcode.get("PK"));
                            postalcode = blpostalcode.getPostalcode(postalcodePK);
                            JSONPostalcode.updatePostalcode(postalcode, jsonpostalcode);
                            blpostalcode.secureupdatePostalcode(postalcode);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IPostalcodeOperation.DELETE_POSTALCODE:
                            postalcode = (IPostalcode)JSONPostalcode.toPostalcode((JSONObject)json.get("postalcode"));
                            blpostalcode.securedeletePostalcode(postalcode);
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
     * PUT method for updating or creating an instance of RSPostalcode
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

