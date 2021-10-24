/*
 * RSSpatial_ref_sys.java
 *
 * Generated on 24.9.2021 14:50
 *
 */

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
import film.interfaces.searchentity.ISpatial_ref_syssearch;
import film.interfaces.servlet.ISpatial_ref_sysOperation;
import film.logicentity.Spatial_ref_sys;
import film.searchentity.Spatial_ref_syssearch;
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
@Path("rsspatial_ref_sys")
public class RSSpatial_ref_sys {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSSpatial_ref_sys() {
    }

    /**
     * Retrieves representation of an instance of spatial_ref_sys.restservices.RSSpatial_ref_sys
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLspatial_ref_sys blspatial_ref_sys = new BLspatial_ref_sys();
            ArrayList spatial_ref_syss = blspatial_ref_sys.getAll();
            JSONArray jsonspatial_ref_syss = JSONSpatial_ref_sys.toJSONArray(spatial_ref_syss);
            return jsonspatial_ref_syss.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of spatial_ref_sys.restservices.RSSpatial_ref_sys
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLspatial_ref_sys blspatial_ref_sys = new BLspatial_ref_sys();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            ISpatial_ref_sysPK spatial_ref_sysPK;
            ISpatial_ref_sys spatial_ref_sys;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blspatial_ref_sys.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case ISpatial_ref_sysOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blspatial_ref_sys.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISpatial_ref_sysOperation.SELECT_ALL:
                            result = JSONSpatial_ref_sys.toJSONArray(blspatial_ref_sys.getSpatial_ref_syss()).toJSONString();
                            break;
                        case ISpatial_ref_sysOperation.SELECT_SPATIAL_REF_SYS:
                            spatial_ref_sysPK = (ISpatial_ref_sysPK)JSONSpatial_ref_sys.toSpatial_ref_sysPK((JSONObject)json.get("spatial_ref_syspk"));
                            result = JSONSpatial_ref_sys.toJSON(blspatial_ref_sys.getSpatial_ref_sys(spatial_ref_sysPK)).toJSONString();
                            break;
                        case ISpatial_ref_sysOperation.SELECT_SEARCH:
                            ISpatial_ref_syssearch search = (ISpatial_ref_syssearch)JSONSpatial_ref_sys.toSpatial_ref_syssearch((JSONObject)json.get("search"));
                            result = JSONSpatial_ref_sys.toJSONArray(blspatial_ref_sys.search(search)).toJSONString();
                            break;
                        case ISpatial_ref_sysOperation.SELECT_SEARCHCOUNT:
                            ISpatial_ref_syssearch spatial_ref_syssearch = (ISpatial_ref_syssearch)JSONSpatial_ref_sys.toSpatial_ref_syssearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blspatial_ref_sys.searchcount(spatial_ref_syssearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case ISpatial_ref_sysOperation.INSERT_SPATIAL_REF_SYS:
                            spatial_ref_sys = (ISpatial_ref_sys)JSONSpatial_ref_sys.toSpatial_ref_sys((JSONObject)json.get("spatial_ref_sys"));
                            blspatial_ref_sys.insertSpatial_ref_sys(spatial_ref_sys);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case ISpatial_ref_sysOperation.UPDATE_SPATIAL_REF_SYS:
                            JSONObject jsonspatial_ref_sys = (JSONObject)json.get("spatial_ref_sys");
                            spatial_ref_sysPK = JSONSpatial_ref_sys.toSpatial_ref_sysPK((JSONObject)jsonspatial_ref_sys.get("PK"));
                            spatial_ref_sys = blspatial_ref_sys.getSpatial_ref_sys(spatial_ref_sysPK);
                            JSONSpatial_ref_sys.updateSpatial_ref_sys(spatial_ref_sys, jsonspatial_ref_sys);
                            blspatial_ref_sys.updateSpatial_ref_sys(spatial_ref_sys);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case ISpatial_ref_sysOperation.DELETE_SPATIAL_REF_SYS:
                            spatial_ref_sys = (ISpatial_ref_sys)JSONSpatial_ref_sys.toSpatial_ref_sys((JSONObject)json.get("spatial_ref_sys"));
                            blspatial_ref_sys.deleteSpatial_ref_sys(spatial_ref_sys);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case ISpatial_ref_sysOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blspatial_ref_sys.count());
                            result = jsoncount.toJSONString();
                            break;
                        case ISpatial_ref_sysOperation.SELECT_ALL:
                            result = JSONSpatial_ref_sys.toJSONArray(blspatial_ref_sys.getSpatial_ref_syss()).toJSONString();
                            break;
                        case ISpatial_ref_sysOperation.SELECT_SPATIAL_REF_SYS:
                            spatial_ref_sysPK = (ISpatial_ref_sysPK)JSONSpatial_ref_sys.toSpatial_ref_sysPK((JSONObject)json.get("spatial_ref_syspk"));
                            result = JSONSpatial_ref_sys.toJSON(blspatial_ref_sys.getSpatial_ref_sys(spatial_ref_sysPK)).toJSONString();
                            break;
                        case ISpatial_ref_sysOperation.SELECT_SEARCH:
                            ISpatial_ref_syssearch search = (ISpatial_ref_syssearch)JSONSpatial_ref_sys.toSpatial_ref_syssearch((JSONObject)json.get("search"));
                            result = JSONSpatial_ref_sys.toJSONArray(blspatial_ref_sys.search(search)).toJSONString();
                            break;
                        case ISpatial_ref_sysOperation.SELECT_SEARCHCOUNT:
                            ISpatial_ref_syssearch spatial_ref_syssearch = (ISpatial_ref_syssearch)JSONSpatial_ref_sys.toSpatial_ref_syssearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blspatial_ref_sys.searchcount(spatial_ref_syssearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case ISpatial_ref_sysOperation.INSERT_SPATIAL_REF_SYS:
                            spatial_ref_sys = (ISpatial_ref_sys)JSONSpatial_ref_sys.toSpatial_ref_sys((JSONObject)json.get("spatial_ref_sys"));
                            blspatial_ref_sys.secureinsertSpatial_ref_sys(spatial_ref_sys);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case ISpatial_ref_sysOperation.UPDATE_SPATIAL_REF_SYS:
                            JSONObject jsonspatial_ref_sys = (JSONObject)json.get("spatial_ref_sys");
                            spatial_ref_sysPK = JSONSpatial_ref_sys.toSpatial_ref_sysPK((JSONObject)jsonspatial_ref_sys.get("PK"));
                            spatial_ref_sys = blspatial_ref_sys.getSpatial_ref_sys(spatial_ref_sysPK);
                            JSONSpatial_ref_sys.updateSpatial_ref_sys(spatial_ref_sys, jsonspatial_ref_sys);
                            blspatial_ref_sys.secureupdateSpatial_ref_sys(spatial_ref_sys);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case ISpatial_ref_sysOperation.DELETE_SPATIAL_REF_SYS:
                            spatial_ref_sys = (ISpatial_ref_sys)JSONSpatial_ref_sys.toSpatial_ref_sys((JSONObject)json.get("spatial_ref_sys"));
                            blspatial_ref_sys.securedeleteSpatial_ref_sys(spatial_ref_sys);
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
     * PUT method for updating or creating an instance of RSSpatial_ref_sys
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

