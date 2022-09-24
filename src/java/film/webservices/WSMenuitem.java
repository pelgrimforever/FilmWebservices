/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.webservices;

import base.restservices.RS_json_login;
import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.IMenuitemsearch;
import film.interfaces.webservice.WSIMenuitem;
import film.logicentity.Menuitem;
import film.searchentity.Menuitemsearch;
import film.usecases.*;
import general.exception.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import film.usecases.custom.Security_usecases;

@WebService(endpointInterface = "film.interfaces.webservice.WSIMenuitem")
public class WSMenuitem extends RS_json_login implements WSIMenuitem {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList menuitems) {
        JSONArray jsonmenuitems = new JSONArray();
        Iterator menuitemsI = menuitems.iterator();
        while(menuitemsI.hasNext()) {
            jsonmenuitems.add(JSONMenuitem.toJSON((Menuitem)menuitemsI.next()));
        }
        return jsonmenuitems;
    }

    //@WebMethod(operationName = "getMenuitems")
    @Override
    public String getMenuitems() {
        try {
            Menuitem_usecases menuitemusecases = new Menuitem_usecases(loggedin);
            return get_all_menuitem(menuitemusecases);
        }
        catch(CustomException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Menuitem_usecases menuitemusecases = new Menuitem_usecases(loggedin);
            return search_menuitem(menuitemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getMenuitem")
    @Override
    public String getMenuitem(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Menuitem_usecases menuitemusecases = new Menuitem_usecases(loggedin);
            return get_menuitem_with_primarykey(menuitemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertMenuitem")
    @Override
    public void insertMenuitem(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Menuitem_usecases menuitemusecases = new Menuitem_usecases(loggedin);
            insert_menuitem(menuitemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateMenuitem")
    @Override
    public void updateMenuitem(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Menuitem_usecases menuitemusecases = new Menuitem_usecases(loggedin);
            update_menuitem(menuitemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteMenuitem")
    @Override
    public void deleteMenuitem(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Menuitem_usecases menuitemusecases = new Menuitem_usecases(loggedin);
            delete_menuitem(menuitemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getMenuitems4menu")
    @Override
    public String getMenuitems4menu(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Menuitem_usecases menuitemusecases = new Menuitem_usecases(loggedin);
            return get_menuitem_with_foreignkey_menu(menuitemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4menu")
    @Override
    public void delete4menu(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Menuitem_usecases menuitemusecases = new Menuitem_usecases(loggedin);
            delete_menuitem(menuitemusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


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

    private void insert_menuitem(Menuitem_usecases menuitemusecases, JSONObject json) throws ParseException, CustomException {
        IMenuitem menuitem = (IMenuitem)JSONMenuitem.toMenuitem((JSONObject)json.get("menuitem"));
        menuitemusecases.insertMenuitem(menuitem);
        setReturnstatus("OK");
    }

    private void update_menuitem(Menuitem_usecases menuitemusecases, JSONObject json) throws ParseException, CustomException {
        IMenuitem menuitem = (IMenuitem)JSONMenuitem.toMenuitem((JSONObject)json.get("menuitem"));
        menuitemusecases.updateMenuitem(menuitem);
        setReturnstatus("OK");
    }

    private void delete_menuitem(Menuitem_usecases menuitemusecases, JSONObject json) throws ParseException, CustomException {
        IMenuitem menuitem = (IMenuitem)JSONMenuitem.toMenuitem((JSONObject)json.get("menuitem"));
        menuitemusecases.deleteMenuitem(menuitem);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Menu(Menuitem_usecases menuitemusecases, JSONObject json) throws ParseException, CustomException {
        IMenuPK menuPK = (IMenuPK)JSONMenu.toMenuPK((JSONObject)json.get("menupk"));
        menuitemusecases.delete_all_containing_Menu(menuPK);
        setReturnstatus("OK");
    }

}

