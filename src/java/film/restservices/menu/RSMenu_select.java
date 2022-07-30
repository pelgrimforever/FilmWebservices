/*
 * Generated on 27.6.2022 16:45
 */

package film.restservices.menu;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.conversion.json.*;
import film.entity.pk.*;
import film.usecases.*;
import film.usecases.custom.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.IMenusearch;
import film.interfaces.servlet.IMenuOperation;
import film.logicentity.Menu;
import film.searchentity.Menusearch;
import film.servlets.DataServlet;
import film.usecases.custom.*;
import general.exception.*;
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
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
@Path("rsmenu_select")
public class RSMenu_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Menu_usecases menuusecases = new Menu_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IMenuOperation.SELECT_COUNT:
                    result = count_records(menuusecases);
                    break;
                case IMenuOperation.SELECT_ALL:
                    result = get_all_menu(menuusecases);
                    break;
                case IMenuOperation.SELECT_MENU:
                    result = get_menu_with_primarykey(menuusecases, json);
                    break;
                case IMenuOperation.SELECT_Mainmenu:
                    result = get_menu_with_foreignkey_mainmenu(menuusecases, json);
                    break;
                case IMenuOperation.SELECT_Menuitem:
                    result = get_menu_with_externalforeignkey_menuitem(menuusecases, json);
                    break;
                case IMenuOperation.SELECT_SEARCH:
                    result = search_menu(menuusecases, json);
                    break;
                case IMenuOperation.SELECT_SEARCHCOUNT:
                    result = search_menu_count(menuusecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            }
        }
        catch(ParseException | CustomException | IOException e) {
            setReturnstatus(e.getMessage());
        }
        return result;
    }

//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    private String count_records(Menu_usecases menuusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", menuusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_menu(Menu_usecases menuusecases) throws ParseException, CustomException {
    	return JSONMenu.toJSONArray(menuusecases.get_all()).toJSONString();
    }
    
    private String get_menu_with_primarykey(Menu_usecases menuusecases, JSONObject json) throws ParseException, CustomException {
        IMenuPK menuPK = (IMenuPK)JSONMenu.toMenuPK((JSONObject)json.get("menupk"));
	return JSONMenu.toJSON(menuusecases.get_menu_by_primarykey(menuPK)).toJSONString();
    }
    
    private String get_menu_with_foreignkey_mainmenu(Menu_usecases menuusecases, JSONObject json) throws ParseException, CustomException {
        IMainmenuPK mainmenuPK = (IMainmenuPK)JSONMainmenu.toMainmenuPK((JSONObject)json.get("mainmenupk"));
        return JSONMenu.toJSONArray(menuusecases.get_menu_with_foreignkey_mainmenu(mainmenuPK)).toJSONString();
    }
    
    private String get_menu_with_externalforeignkey_menuitem(Menu_usecases menuusecases, JSONObject json) throws ParseException, CustomException {
        IMenuitemPK menuitemPK = (IMenuitemPK)JSONMenuitem.toMenuitemPK((JSONObject)json.get("menuitempk"));
        return JSONMenu.toJSON(menuusecases.get_menu_with_externalforeignkey_menuitem(menuitemPK)).toJSONString();
    }
    
    private String search_menu(Menu_usecases menuusecases, JSONObject json) throws ParseException, CustomException {
        IMenusearch search = (IMenusearch)JSONMenu.toMenusearch((JSONObject)json.get("search"));
        return JSONMenu.toJSONArray(menuusecases.search_menu(search)).toJSONString();
    }
    
    private String search_menu_count(Menu_usecases menuusecases, JSONObject json) throws ParseException, CustomException {
        IMenusearch menusearch = (IMenusearch)JSONMenu.toMenusearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", menuusecases.search_menu_count(menusearch));
        return jsonsearchcount.toJSONString();
    }
}

