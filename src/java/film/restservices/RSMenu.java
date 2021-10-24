/*
 * RSMenu.java
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
import film.interfaces.searchentity.IMenusearch;
import film.interfaces.servlet.IMenuOperation;
import film.logicentity.Menu;
import film.searchentity.Menusearch;
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
@Path("rsmenu")
public class RSMenu {

    /**
     * Creates a new instance of HelloWorld
     */
    public RSMenu() {
    }

    /**
     * Retrieves representation of an instance of menu.restservices.RSMenu
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{json}")
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("json") String jsonstring) {
        try {
            BLmenu blmenu = new BLmenu();
            ArrayList menus = blmenu.getAll();
            JSONArray jsonmenus = JSONMenu.toJSONArray(menus);
            return jsonmenus.toJSONString();
        }
        catch(DBException e) {
            return "{ \"status\": \"error\"}";
        }
    }

    /**
     * Retrieves representation of an instance of menu.restservices.RSMenu
     * @param jsonstring
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        String result = "";
        BLmenu blmenu = new BLmenu();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject)parser.parse(jsonstring);
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            IMenuPK menuPK;
            IMenu menu;
//Security parameters
            boolean loggedin = RSsecurity.check(json);
            blmenu.setAuthenticated(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IMenuOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blmenu.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IMenuOperation.SELECT_ALL:
                            result = JSONMenu.toJSONArray(blmenu.getMenus()).toJSONString();
                            break;
                        case IMenuOperation.SELECT_MENU:
                            menuPK = (IMenuPK)JSONMenu.toMenuPK((JSONObject)json.get("menupk"));
                            result = JSONMenu.toJSON(blmenu.getMenu(menuPK)).toJSONString();
                            break;
                        case IMenuOperation.SELECT_Mainmenu:
                            IMainmenuPK mainmenuPK = (IMainmenuPK)JSONMainmenu.toMainmenuPK((JSONObject)json.get("mainmenupk"));
                            result = JSONMenu.toJSONArray(blmenu.getMenus4mainmenu(mainmenuPK)).toJSONString();
                            break;
                        case IMenuOperation.SELECT_Menuitem:
                            IMenuitemPK menuitemPK = (IMenuitemPK)JSONMenuitem.toMenuitemPK((JSONObject)json.get("menuitempk"));
                            result = JSONMenu.toJSON(blmenu.getMenuitem(menuitemPK)).toJSONString();
                            break;
                        case IMenuOperation.SELECT_SEARCH:
                            IMenusearch search = (IMenusearch)JSONMenu.toMenusearch((JSONObject)json.get("search"));
                            result = JSONMenu.toJSONArray(blmenu.search(search)).toJSONString();
                            break;
                        case IMenuOperation.SELECT_SEARCHCOUNT:
                            IMenusearch menusearch = (IMenusearch)JSONMenu.toMenusearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blmenu.searchcount(menusearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_INSERT:
                    switch(operation) {
                        case IMenuOperation.INSERT_MENU:
                            menu = (IMenu)JSONMenu.toMenu((JSONObject)json.get("menu"));
                            blmenu.insertMenu(menu);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_UPDATE:
                    switch(operation) {
                        case IMenuOperation.UPDATE_MENU:
                            JSONObject jsonmenu = (JSONObject)json.get("menu");
                            menuPK = JSONMenu.toMenuPK((JSONObject)jsonmenu.get("PK"));
                            menu = blmenu.getMenu(menuPK);
                            JSONMenu.updateMenu(menu, jsonmenu);
                            blmenu.updateMenu(menu);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_DELETE:
                    switch(operation) {
                        case IMenuOperation.DELETE_MENU:
                            menu = (IMenu)JSONMenu.toMenu((JSONObject)json.get("menu"));
                            blmenu.deleteMenu(menu);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECURESELECT:
                    switch(operation) {
                        case IMenuOperation.SELECT_COUNT:
                            JSONObject jsoncount = new JSONObject();
                            jsoncount.put("recordcount", blmenu.count());
                            result = jsoncount.toJSONString();
                            break;
                        case IMenuOperation.SELECT_ALL:
                            result = JSONMenu.toJSONArray(blmenu.getMenus()).toJSONString();
                            break;
                        case IMenuOperation.SELECT_MENU:
                            menuPK = (IMenuPK)JSONMenu.toMenuPK((JSONObject)json.get("menupk"));
                            result = JSONMenu.toJSON(blmenu.getMenu(menuPK)).toJSONString();
                            break;
                        case IMenuOperation.SELECT_Mainmenu:
                            IMainmenuPK mainmenuPK = (IMainmenuPK)JSONMainmenu.toMainmenuPK((JSONObject)json.get("mainmenupk"));
                            result = JSONMenu.toJSONArray(blmenu.getMenus4mainmenu(mainmenuPK)).toJSONString();
                            break;
                        case IMenuOperation.SELECT_Menuitem:
                            IMenuitemPK menuitemPK = (IMenuitemPK)JSONMenuitem.toMenuitemPK((JSONObject)json.get("menuitempk"));
                            result = JSONMenu.toJSON(blmenu.getMenuitem(menuitemPK)).toJSONString();
                            break;
                        case IMenuOperation.SELECT_SEARCH:
                            IMenusearch search = (IMenusearch)JSONMenu.toMenusearch((JSONObject)json.get("search"));
                            result = JSONMenu.toJSONArray(blmenu.search(search)).toJSONString();
                            break;
                        case IMenuOperation.SELECT_SEARCHCOUNT:
                            IMenusearch menusearch = (IMenusearch)JSONMenu.toMenusearch((JSONObject)json.get("search"));
                            JSONObject jsonsearchcount = new JSONObject();
                            jsonsearchcount.put("recordcount", blmenu.searchcount(menusearch));
                            result = jsonsearchcount.toJSONString();
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREINSERT:
                    switch(operation) {
                        case IMenuOperation.INSERT_MENU:
                            menu = (IMenu)JSONMenu.toMenu((JSONObject)json.get("menu"));
                            blmenu.secureinsertMenu(menu);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREUPDATE:
                    switch(operation) {
                        case IMenuOperation.UPDATE_MENU:
                            JSONObject jsonmenu = (JSONObject)json.get("menu");
                            menuPK = JSONMenu.toMenuPK((JSONObject)jsonmenu.get("PK"));
                            menu = blmenu.getMenu(menuPK);
                            JSONMenu.updateMenu(menu, jsonmenu);
                            blmenu.secureupdateMenu(menu);
                            result = returnstatus("OK");
                            break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
                    }
                    break;
                case DataServlet.OPERATIONTYPE_SECUREDELETE:
                    switch(operation) {
                        case IMenuOperation.DELETE_MENU:
                            menu = (IMenu)JSONMenu.toMenu((JSONObject)json.get("menu"));
                            blmenu.securedeleteMenu(menu);
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
     * PUT method for updating or creating an instance of RSMenu
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public void put(String content) {
    }
}

