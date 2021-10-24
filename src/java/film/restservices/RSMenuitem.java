/*
 * RSMenuitem.java
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
import film.interfaces.searchentity.IMenuitemsearch;
import film.interfaces.servlet.IMenuitemOperation;
import film.logicentity.Menuitem;
import film.searchentity.Menuitemsearch;
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
@Path("rsmenuitem")
public class RSMenuitem {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSMenuitem() {
    }

    /**
     * Retrieves representation of an instance of menuitem.restservices.RSMenuitem
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLmenuitem blmenuitem = new BLmenuitem();
            ArrayList menuitems = blmenuitem.getAll();
            JSONArray jsonmenuitems = JSONMenuitem.toJSONArray(menuitems);
            return jsonmenuitems.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of menuitem.restservices.RSMenuitem
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLmenuitem blmenuitem = new BLmenuitem();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IMenuitemPK menuitemPK;
            IMenuitem menuitem;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blmenuitem.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IMenuitemOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blmenuitem.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IMenuitemOperation.SELECT_ALL:
                            result = JSONMenuitem.toJSONArray(blmenuitem.getMenuitems()).toJSONString();
                            break;
                        case IMenuitemOperation.SELECT_MENUITEM:
                            menuitemPK = (IMenuitemPK)JSONMenuitem.toMenuitemPK((JSONObject)json.get("menuitempk"));
                            result = JSONMenuitem.toJSON(blmenuitem.getMenuitem(menuitemPK)).toJSONString();
                            break;
                        case IMenuitemOperation.SELECT_Menu:
                            IMenuPK menuPK = (IMenuPK)JSONMenu.toMenuPK((JSONObject)json.get("menupk"));
                            result = JSONMenuitem.toJSONArray(blmenuitem.getMenuitems4menu(menuPK)).toJSONString();
                            break;
                        case IMenuitemOperation.SELECT_SEARCH:
                            IMenuitemsearch search = (IMenuitemsearch)JSONMenuitem.toMenuitemsearch((JSONObject)json.get("search"));
                            result = JSONMenuitem.toJSONArray(blmenuitem.search(search)).toJSONString();
                            break;
                        case IMenuitemOperation.SELECT_SEARCHCOUNT:
                            IMenuitemsearch menuitemsearch = (IMenuitemsearch)JSONMenuitem.toMenuitemsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blmenuitem.searchcount(menuitemsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IMenuitemOperation.INSERT_MENUITEM:
                            menuitem = (IMenuitem)JSONMenuitem.toMenuitem((JSONObject)json.get("menuitem"));
                            blmenuitem.insertMenuitem(menuitem);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IMenuitemOperation.UPDATE_MENUITEM:
                            JSONObject jsonmenuitem = (JSONObject)json.get("menuitem");
                            menuitemPK = JSONMenuitem.toMenuitemPK((JSONObject)jsonmenuitem.get("PK"));
                            menuitem = blmenuitem.getMenuitem(menuitemPK);
                            JSONMenuitem.updateMenuitem(menuitem, jsonmenuitem);
                            blmenuitem.updateMenuitem(menuitem);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IMenuitemOperation.DELETE_MENUITEM:
                            menuitem = (IMenuitem)JSONMenuitem.toMenuitem((JSONObject)json.get("menuitem"));
                            blmenuitem.deleteMenuitem(menuitem);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IMenuitemOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blmenuitem.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IMenuitemOperation.SELECT_ALL:
                            result = JSONMenuitem.toJSONArray(blmenuitem.getMenuitems()).toJSONString();
                            break;
                        case IMenuitemOperation.SELECT_MENUITEM:
                            menuitemPK = (IMenuitemPK)JSONMenuitem.toMenuitemPK((JSONObject)json.get("menuitempk"));
                            result = JSONMenuitem.toJSON(blmenuitem.getMenuitem(menuitemPK)).toJSONString();
                            break;
                        case IMenuitemOperation.SELECT_Menu:
                            IMenuPK menuPK = (IMenuPK)JSONMenu.toMenuPK((JSONObject)json.get("menupk"));
                            result = JSONMenuitem.toJSONArray(blmenuitem.getMenuitems4menu(menuPK)).toJSONString();
                            break;
                        case IMenuitemOperation.SELECT_SEARCH:
                            IMenuitemsearch search = (IMenuitemsearch)JSONMenuitem.toMenuitemsearch((JSONObject)json.get("search"));
                            result = JSONMenuitem.toJSONArray(blmenuitem.search(search)).toJSONString();
                            break;
                        case IMenuitemOperation.SELECT_SEARCHCOUNT:
                            IMenuitemsearch menuitemsearch = (IMenuitemsearch)JSONMenuitem.toMenuitemsearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blmenuitem.searchcount(menuitemsearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IMenuitemOperation.INSERT_MENUITEM:
                            menuitem = (IMenuitem)JSONMenuitem.toMenuitem((JSONObject)json.get("menuitem"));
                            blmenuitem.secureinsertMenuitem(menuitem);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IMenuitemOperation.UPDATE_MENUITEM:
                            JSONObject jsonmenuitem = (JSONObject)json.get("menuitem");
                            menuitemPK = JSONMenuitem.toMenuitemPK((JSONObject)jsonmenuitem.get("PK"));
                            menuitem = blmenuitem.getMenuitem(menuitemPK);
                            JSONMenuitem.updateMenuitem(menuitem, jsonmenuitem);
                            blmenuitem.secureupdateMenuitem(menuitem);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IMenuitemOperation.DELETE_MENUITEM:
                            menuitem = (IMenuitem)JSONMenuitem.toMenuitem((JSONObject)json.get("menuitem"));
                            blmenuitem.securedeleteMenuitem(menuitem);
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
     * PUT method for updating or creating an instance of RSMenuitem
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

