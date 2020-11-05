package film.restservices;

import base.servlets.Securitycheck;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.interfaces.logicview.IView_photodates;
import film.interfaces.servlet.IView_photodatesOperation;
import film.logicview.View_photodates;
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
@Path("rsview_photodates")
public class RSView_photodates {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RSView_photodates
     */
    public RSView_photodates() {
    }

    /**
     * Retrieves representation of an instance of view_photodates.restservices.RSView_photodates
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLview_photodates blview_photodates = new BLview_photodates();
            ArrayList view_photodatess = blview_photodates.getAll();
            JSONArray jsonview_photodatess = JSONView_photodates.toJSONArray(view_photodatess);
            return jsonview_photodatess.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of view_photodates.restservices.RSView_photodates
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLview_photodates blview_photodates = new BLview_photodates();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IView_photodates view_photodates;
//Custom code, do not change this line
//add here custom operations
            boolean loggedin = RSsecurity.check(json);
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IView_photodatesOperation.SELECT_ALL:
                            result = JSONView_photodates.toJSONArray(blview_photodates.getView_photodatess()).toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
                        case IView_photodatesOperation.SECURE_SELECT_ALL:
                            result = JSONView_photodates.toJSONArray(blview_photodates.getView_photodatess(loggedin)).toJSONString();
                            break;
//Custom code, do not change this line   
                    }
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
     * PUT method for updating or creating an instance of RSView_photodates
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

