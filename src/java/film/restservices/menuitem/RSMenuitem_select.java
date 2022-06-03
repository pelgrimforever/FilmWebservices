/*
 * Generated on 1.5.2022 20:24
 */

package film.restservices.menuitem;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.conversion.json.*;
import film.entity.pk.*;
import film.usecases.Menuitem_usecases;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.IMenuitemsearch;
import film.interfaces.servlet.IMenuitemOperation;
import film.logicentity.Menuitem;
import film.searchentity.Menuitemsearch;
import film.servlets.DataServlet;
import film.usecases.Security_usecases;
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
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
@Path("rsmenuitem_select")
public class RSMenuitem_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IMenuitemPK menuitemPK;
            IMenuitem menuitem;
            Menuitem_usecases menuitemusecases = new Menuitem_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IMenuitemOperation.SELECT_COUNT:
                    result = count_records(menuitemusecases);
                    break;
                case IMenuitemOperation.SELECT_ALL:
                    result = get_all_menuitem(menuitemusecases);
                    break;
                case IMenuitemOperation.SELECT_MENUITEM:
                    result = get_menuitem_with_primarykey(menuitemusecases, json);
                    break;
                case IMenuitemOperation.SELECT_Menu:
                    result = get_menuitem_with_foreignkey_menu(menuitemusecases, json);
                    break;
                case IMenuitemOperation.SELECT_SEARCH:
                    result = search_menuitem(menuitemusecases, json);
                    break;
                case IMenuitemOperation.SELECT_SEARCHCOUNT:
                    result = search_menuitem_count(menuitemusecases, json);
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

    private String count_records(Menuitem_usecases menuitemusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", menuitemusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_menuitem(Menuitem_usecases menuitemusecases) throws ParseException, CustomException {
    	return JSONMenuitem.toJSONArray(menuitemusecases.get_all()).toJSONString();
    }
    
    private String get_menuitem_with_primarykey(Menuitem_usecases menuitemusecases, JSONObject json) throws ParseException, CustomException {
        IMenuitemPK menuitemPK = (IMenuitemPK)JSONMenuitem.toMenuitemPK((JSONObject)json.get("menuitempk"));
	return JSONMenuitem.toJSON(menuitemusecases.get_menuitem_by_primarykey(menuitemPK)).toJSONString();
    }
    
    private String get_menuitem_with_foreignkey_menu(Menuitem_usecases menuitemusecases, JSONObject json) throws ParseException, CustomException {
        IMenuPK menuPK = (IMenuPK)JSONMenu.toMenuPK((JSONObject)json.get("menupk"));
        return JSONMenuitem.toJSONArray(menuitemusecases.get_menuitem_with_foreignkey_menu(menuPK)).toJSONString();
    }
    
    private String search_menuitem(Menuitem_usecases menuitemusecases, JSONObject json) throws ParseException, CustomException {
        IMenuitemsearch search = (IMenuitemsearch)JSONMenuitem.toMenuitemsearch((JSONObject)json.get("search"));
        return JSONMenuitem.toJSONArray(menuitemusecases.search_menuitem(search)).toJSONString();
    }
    
    private String search_menuitem_count(Menuitem_usecases menuitemusecases, JSONObject json) throws ParseException, CustomException {
        IMenuitemsearch menuitemsearch = (IMenuitemsearch)JSONMenuitem.toMenuitemsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", menuitemusecases.search_menuitem_count(menuitemsearch));
        return jsonsearchcount.toJSONString();
    }
}

