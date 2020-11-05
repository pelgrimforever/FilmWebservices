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
import film.interfaces.searchentity.IMainmenusearch;
import film.interfaces.servlet.IMainmenuOperation;
import film.logicentity.Mainmenu;
import film.searchentity.Mainmenusearch;
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
@Path("rsmainmenu")
public class RSMainmenu {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public RSMainmenu() {
    }

    /**
     * Retrieves representation of an instance of mainmenu.restservices.RSMainmenu
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLmainmenu blmainmenu = new BLmainmenu();
            ArrayList mainmenus = blmainmenu.getAll();
            JSONArray jsonmainmenus = JSONMainmenu.toJSONArray(mainmenus);
            return jsonmainmenus.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of mainmenu.restservices.RSMainmenu
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLmainmenu blmainmenu = new BLmainmenu();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IMainmenuPK mainmenuPK;
            IMainmenu mainmenu;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blmainmenu.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IMainmenuOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blmainmenu.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IMainmenuOperation.SELECT_ALL:
                            result = JSONMainmenu.toJSONArray(blmainmenu.getMainmenus()).toJSONString();
                            break;
                        case IMainmenuOperation.SELECT_MAINMENU:
                            mainmenuPK = (IMainmenuPK)JSONMainmenu.toMainmenuPK((JSONObject)json.get("mainmenupk"));
                            result = JSONMainmenu.toJSON(blmainmenu.getMainmenu(mainmenuPK)).toJSONString();
                            break;
                        case IMainmenuOperation.SELECT_Menu:
                            IMenuPK menuPK = (IMenuPK)JSONMenu.toMenuPK((JSONObject)json.get("menupk"));
                            result = JSONMainmenu.toJSON(blmainmenu.getMenu(menuPK)).toJSONString();
                            break;
                        case IMainmenuOperation.SELECT_SEARCH:
                            IMainmenusearch search = (IMainmenusearch)JSONMainmenu.toMainmenusearch((JSONObject)json.get("search"));
                            result = JSONMainmenu.toJSONArray(blmainmenu.search(search)).toJSONString();
                            break;
                        case IMainmenuOperation.SELECT_SEARCHCOUNT:
                            IMainmenusearch mainmenusearch = (IMainmenusearch)JSONMainmenu.toMainmenusearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blmainmenu.searchcount(mainmenusearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IMainmenuOperation.INSERT_MAINMENU:
                            mainmenu = (IMainmenu)JSONMainmenu.toMainmenu((JSONObject)json.get("mainmenu"));
                            blmainmenu.insertMainmenu(mainmenu);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IMainmenuOperation.UPDATE_MAINMENU:
                            JSONObject jsonmainmenu = (JSONObject)json.get("mainmenu");
                            mainmenuPK = JSONMainmenu.toMainmenuPK((JSONObject)jsonmainmenu.get("PK"));
                            mainmenu = blmainmenu.getMainmenu(mainmenuPK);
                            JSONMainmenu.updateMainmenu(mainmenu, jsonmainmenu);
                            blmainmenu.updateMainmenu(mainmenu);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IMainmenuOperation.DELETE_MAINMENU:
                            mainmenu = (IMainmenu)JSONMainmenu.toMainmenu((JSONObject)json.get("mainmenu"));
                            blmainmenu.deleteMainmenu(mainmenu);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IMainmenuOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blmainmenu.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IMainmenuOperation.SELECT_ALL:
                            result = JSONMainmenu.toJSONArray(blmainmenu.getMainmenus()).toJSONString();
                            break;
                        case IMainmenuOperation.SELECT_MAINMENU:
                            mainmenuPK = (IMainmenuPK)JSONMainmenu.toMainmenuPK((JSONObject)json.get("mainmenupk"));
                            result = JSONMainmenu.toJSON(blmainmenu.getMainmenu(mainmenuPK)).toJSONString();
                            break;
                        case IMainmenuOperation.SELECT_Menu:
                            IMenuPK menuPK = (IMenuPK)JSONMenu.toMenuPK((JSONObject)json.get("menupk"));
                            result = JSONMainmenu.toJSON(blmainmenu.getMenu(menuPK)).toJSONString();
                            break;
                        case IMainmenuOperation.SELECT_SEARCH:
                            IMainmenusearch search = (IMainmenusearch)JSONMainmenu.toMainmenusearch((JSONObject)json.get("search"));
                            result = JSONMainmenu.toJSONArray(blmainmenu.search(search)).toJSONString();
                            break;
                        case IMainmenuOperation.SELECT_SEARCHCOUNT:
                            IMainmenusearch mainmenusearch = (IMainmenusearch)JSONMainmenu.toMainmenusearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blmainmenu.searchcount(mainmenusearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IMainmenuOperation.INSERT_MAINMENU:
                            mainmenu = (IMainmenu)JSONMainmenu.toMainmenu((JSONObject)json.get("mainmenu"));
                            blmainmenu.secureinsertMainmenu(mainmenu);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IMainmenuOperation.UPDATE_MAINMENU:
                            JSONObject jsonmainmenu = (JSONObject)json.get("mainmenu");
                            mainmenuPK = JSONMainmenu.toMainmenuPK((JSONObject)jsonmainmenu.get("PK"));
                            mainmenu = blmainmenu.getMainmenu(mainmenuPK);
                            JSONMainmenu.updateMainmenu(mainmenu, jsonmainmenu);
                            blmainmenu.secureupdateMainmenu(mainmenu);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IMainmenuOperation.DELETE_MAINMENU:
                            mainmenu = (IMainmenu)JSONMainmenu.toMainmenu((JSONObject)json.get("mainmenu"));
                            blmainmenu.securedeleteMainmenu(mainmenu);
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
     * PUT method for updating or creating an instance of RSMainmenu
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

