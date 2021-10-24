/*
 * WSMenu.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 24.9.2021 14:50
 *
 */

package film.webservices;

import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.webservice.WSIMenu;
import film.logicentity.Menu;
import film.searchentity.Menusearch;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "film.interfaces.webservice.WSIMenu")
public class WSMenu implements WSIMenu {

    private JSONArray toJSONArray(ArrayList menus) {
        JSONArray jsonmenus = new JSONArray();
        Iterator menusI = menus.iterator();
        while(menusI.hasNext()) {
            jsonmenus.add(JSONMenu.toJSON((Menu)menusI.next()));
        }
        return jsonmenus;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getMenus")
    @Override
    public String getMenus() {
        try {
            BLmenu blmenu = new BLmenu();
            ArrayList menus = blmenu.getAll();
            JSONArray jsonmenus = toJSONArray(menus);
            return jsonmenus.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLmenu blmenu = new BLmenu();
        JSONParser parser = new JSONParser();
        String result = "";
        Menu menu;
        try {
            Menusearch menusearch = JSONMenu.toMenusearch((JSONObject)parser.parse(json));
            ArrayList menus = blmenu.search(menusearch);
            JSONArray jsonmenus = toJSONArray(menus);
            result = jsonmenus.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getMenu")
    @Override
    public String getMenu(String json) {
        BLmenu blmenu = new BLmenu();
        JSONParser parser = new JSONParser();
        String result = "";
        Menu menu;
        try {
            MenuPK menuPK = JSONMenu.toMenuPK((JSONObject)parser.parse(json));
            menu = blmenu.getMenu(menuPK);
            if(menu!=null) {
                result = JSONMenu.toJSON(menu).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertMenu")
    @Override
    public void insertMenu(String json) {
        BLmenu blmenu = new BLmenu();
        JSONParser parser = new JSONParser();
        try {
            IMenu menu = JSONMenu.toMenu((JSONObject)parser.parse(json));
            blmenu.insertMenu(menu);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateMenu")
    @Override
    public void updateMenu(String json) {
        BLmenu blmenu = new BLmenu();
        JSONParser parser = new JSONParser();
        try {
            IMenu menu = JSONMenu.toMenu((JSONObject)parser.parse(json));
            blmenu.updateMenu(menu);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteMenu")
    @Override
    public void deleteMenu(String json) {
        BLmenu blmenu = new BLmenu();
        JSONParser parser = new JSONParser();
        try {
            IMenu menu = JSONMenu.toMenu((JSONObject)parser.parse(json));
            blmenu.deleteMenu(menu);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getMenus4mainmenu")
    @Override
    public String getMenus4mainmenu(String json) {
        BLmenu blmenu = new BLmenu();
        JSONParser parser = new JSONParser();
        Menu menu;
        try {
            IMainmenuPK mainmenuPK = JSONMainmenu.toMainmenuPK((JSONObject)parser.parse(json));
            ArrayList menus = blmenu.getMenus4mainmenu(mainmenuPK);
            JSONArray jsonmenus = toJSONArray(menus);
            return jsonmenus.toJSONString();
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4mainmenu")
    @Override
    public void delete4mainmenu(String json) {
        BLmenu blmenu = new BLmenu();
        JSONParser parser = new JSONParser();
        Menu menu;
        try {
            IMainmenuPK mainmenuPK = JSONMainmenu.toMainmenuPK((JSONObject)parser.parse(json));
            blmenu.delete4mainmenu(mainmenuPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getMenus4menuitem")
    @Override
    public String getMenus4menuitem(String json) {
        BLmenu blmenu = new BLmenu();
        JSONParser parser = new JSONParser();
        Menu menu;
        try {
            String result = null;
            IMenuitemPK menuitemPK = JSONMenuitem.toMenuitemPK((JSONObject)parser.parse(json));
            menu = (Menu)blmenu.getMenuitem(menuitemPK);
            if(menu!=null) {
                result = JSONMenu.toJSON(menu).toJSONString();
            }
            return result;
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }


}

