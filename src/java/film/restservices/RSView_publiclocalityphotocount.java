/*
 * RSView_publiclocalityphotocount.java
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
import film.interfaces.logicview.IView_publiclocalityphotocount;
import film.interfaces.servlet.IView_publiclocalityphotocountOperation;
import film.logicview.View_publiclocalityphotocount;
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
@Path("rsview_publiclocalityphotocount")
public class RSView_publiclocalityphotocount {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RSView_publiclocalityphotocount
     */
    public RSView_publiclocalityphotocount() {
    }

    /**
     * Retrieves representation of an instance of view_publiclocalityphotocount.restservices.RSView_publiclocalityphotocount
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLview_publiclocalityphotocount blview_publiclocalityphotocount = new BLview_publiclocalityphotocount();
            ArrayList view_publiclocalityphotocounts = blview_publiclocalityphotocount.getAll();
            JSONArray jsonview_publiclocalityphotocounts = JSONView_publiclocalityphotocount.toJSONArray(view_publiclocalityphotocounts);
            return jsonview_publiclocalityphotocounts.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of view_publiclocalityphotocount.restservices.RSView_publiclocalityphotocount
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLview_publiclocalityphotocount blview_publiclocalityphotocount = new BLview_publiclocalityphotocount();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IView_publiclocalityphotocount view_publiclocalityphotocount;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IView_publiclocalityphotocountOperation.SELECT_ALL:
                            result = JSONView_publiclocalityphotocount.toJSONArray(blview_publiclocalityphotocount.getView_publiclocalityphotocounts()).toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
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
     * PUT method for updating or creating an instance of RSView_publiclocalityphotocount
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

