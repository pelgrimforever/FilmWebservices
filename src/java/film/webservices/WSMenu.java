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
import film.interfaces.searchentity.IMenusearch;
import film.interfaces.webservice.WSIMenu;
import film.logicentity.Menu;
import film.searchentity.Menusearch;
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

@WebService(endpointInterface = "film.interfaces.webservice.WSIMenu")
public class WSMenu extends RS_json_login implements WSIMenu {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList menus) {
        JSONArray jsonmenus = new JSONArray();
        Iterator menusI = menus.iterator();
        while(menusI.hasNext()) {
            jsonmenus.add(JSONMenu.toJSON((Menu)menusI.next()));
        }
        return jsonmenus;
    }

    //@WebMethod(operationName = "getMenus")
    @Override
    public String getMenus() {
        try {
            Menu_usecases menuusecases = new Menu_usecases(loggedin);
            return get_all_menu(menuusecases);
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
            Menu_usecases menuusecases = new Menu_usecases(loggedin);
            return search_menu(menuusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getMenu")
    @Override
    public String getMenu(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Menu_usecases menuusecases = new Menu_usecases(loggedin);
            return get_menu_with_primarykey(menuusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertMenu")
    @Override
    public void insertMenu(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Menu_usecases menuusecases = new Menu_usecases(loggedin);
            insert_menu(menuusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateMenu")
    @Override
    public void updateMenu(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Menu_usecases menuusecases = new Menu_usecases(loggedin);
            update_menu(menuusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteMenu")
    @Override
    public void deleteMenu(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Menu_usecases menuusecases = new Menu_usecases(loggedin);
            delete_menu(menuusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getMenus4mainmenu")
    @Override
    public String getMenus4mainmenu(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Menu_usecases menuusecases = new Menu_usecases(loggedin);
            return get_menu_with_foreignkey_mainmenu(menuusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4mainmenu")
    @Override
    public void delete4mainmenu(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Menu_usecases menuusecases = new Menu_usecases(loggedin);
            delete_menu(menuusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getMenus4menuitem")
    @Override
    public String getMenus4menuitem(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Menu_usecases menuusecases = new Menu_usecases(loggedin);
            return get_menu_with_externalforeignkey_menuitem(menuusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


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

    private void insert_menu(Menu_usecases menuusecases, JSONObject json) throws ParseException, CustomException {
        IMenu menu = (IMenu)JSONMenu.toMenu((JSONObject)json.get("menu"));
        menuusecases.insertMenu(menu);
        setReturnstatus("OK");
    }

    private void update_menu(Menu_usecases menuusecases, JSONObject json) throws ParseException, CustomException {
        IMenu menu = (IMenu)JSONMenu.toMenu((JSONObject)json.get("menu"));
        menuusecases.updateMenu(menu);
        setReturnstatus("OK");
    }

    private void delete_menu(Menu_usecases menuusecases, JSONObject json) throws ParseException, CustomException {
        IMenu menu = (IMenu)JSONMenu.toMenu((JSONObject)json.get("menu"));
        menuusecases.deleteMenu(menu);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Mainmenu(Menu_usecases menuusecases, JSONObject json) throws ParseException, CustomException {
        IMainmenuPK mainmenuPK = (IMainmenuPK)JSONMainmenu.toMainmenuPK((JSONObject)json.get("mainmenupk"));
        menuusecases.delete_all_containing_Mainmenu(mainmenuPK);
        setReturnstatus("OK");
    }

}

