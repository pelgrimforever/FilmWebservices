/*
 * WSMenuitem.java
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
import film.interfaces.webservice.WSIMenuitem;
import film.logicentity.Menuitem;
import film.searchentity.Menuitemsearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIMenuitem")
public class WSMenuitem implements WSIMenuitem {

    private JSONArray toJSONArray(ArrayList menuitems) {
        JSONArray jsonmenuitems = new JSONArray();
        Iterator menuitemsI = menuitems.iterator();
        while(menuitemsI.hasNext()) {
            jsonmenuitems.add(JSONMenuitem.toJSON((Menuitem)menuitemsI.next()));
        }
        return jsonmenuitems;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getMenuitems")
    @Override
    public String getMenuitems() {
        try {
            BLmenuitem blmenuitem = new BLmenuitem();
            ArrayList menuitems = blmenuitem.getAll();
            JSONArray jsonmenuitems = toJSONArray(menuitems);
            return jsonmenuitems.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLmenuitem blmenuitem = new BLmenuitem();
        JSONParser parser = new JSONParser();
        String result = "";
        Menuitem menuitem;
        try {
            Menuitemsearch menuitemsearch = JSONMenuitem.toMenuitemsearch((JSONObject)parser.parse(json));
            ArrayList menuitems = blmenuitem.search(menuitemsearch);
            JSONArray jsonmenuitems = toJSONArray(menuitems);
            result = jsonmenuitems.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getMenuitem")
    @Override
    public String getMenuitem(String json) {
        BLmenuitem blmenuitem = new BLmenuitem();
        JSONParser parser = new JSONParser();
        String result = "";
        Menuitem menuitem;
        try {
            MenuitemPK menuitemPK = JSONMenuitem.toMenuitemPK((JSONObject)parser.parse(json));
            menuitem = blmenuitem.getMenuitem(menuitemPK);
            if(menuitem!=null) {
                result = JSONMenuitem.toJSON(menuitem).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertMenuitem")
    @Override
    public void insertMenuitem(String json) {
        BLmenuitem blmenuitem = new BLmenuitem();
        JSONParser parser = new JSONParser();
        try {
            IMenuitem menuitem = JSONMenuitem.toMenuitem((JSONObject)parser.parse(json));
            blmenuitem.insertMenuitem(menuitem);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateMenuitem")
    @Override
    public void updateMenuitem(String json) {
        BLmenuitem blmenuitem = new BLmenuitem();
        JSONParser parser = new JSONParser();
        try {
            IMenuitem menuitem = JSONMenuitem.toMenuitem((JSONObject)parser.parse(json));
            blmenuitem.updateMenuitem(menuitem);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteMenuitem")
    @Override
    public void deleteMenuitem(String json) {
        BLmenuitem blmenuitem = new BLmenuitem();
        JSONParser parser = new JSONParser();
        try {
            IMenuitem menuitem = JSONMenuitem.toMenuitem((JSONObject)parser.parse(json));
            blmenuitem.deleteMenuitem(menuitem);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getMenuitems4menu")
    @Override
    public String getMenuitems4menu(String json) {
        BLmenuitem blmenuitem = new BLmenuitem();
        JSONParser parser = new JSONParser();
        Menuitem menuitem;
        try {
            IMenuPK menuPK = JSONMenu.toMenuPK((JSONObject)parser.parse(json));
            ArrayList menuitems = blmenuitem.getMenuitems4menu(menuPK);
            JSONArray jsonmenuitems = toJSONArray(menuitems);
            return jsonmenuitems.toJSONString();
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

    //@WebMethod(operationName = "delete4menu")
    @Override
    public void delete4menu(String json) {
        BLmenuitem blmenuitem = new BLmenuitem();
        JSONParser parser = new JSONParser();
        Menuitem menuitem;
        try {
            IMenuPK menuPK = JSONMenu.toMenuPK((JSONObject)parser.parse(json));
            blmenuitem.delete4menu(menuPK);
        }
        catch(ParseException e) {
        }
    }


}

