/*
 * JSONMenuitem.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.9.2021 14:50
 *
 */
 
package film.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import film.entity.pk.MenuitemPK;
import film.interfaces.entity.pk.IMenuitemPK;
import film.interfaces.logicentity.IMenuitem;
import film.logicentity.Menuitem;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * JSON fields are by default ignored
 * @author Franky Laseure
 */
public class JSONMenuitem {
    
    public static JSONArray toJSONArray(ArrayList menuitems) {
        JSONArray jsonmenuitems = new JSONArray();
        Iterator menuitemsI = menuitems.iterator();
        while(menuitemsI.hasNext()) {
            jsonmenuitems.add(toJSON((Menuitem)menuitemsI.next()));
        }
        return jsonmenuitems;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IMenuitemPK menuitemPK) {
        JSONObject json = null;
        if(menuitemPK!=null) {
            json = new JSONObject();
            json.put("mainmenu", menuitemPK.getMainmenu());
            json.put("menu", menuitemPK.getMenu());
            json.put("menuitem", menuitemPK.getMenuitem());
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IMenuitem menuitem) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(menuitem.getPrimaryKey()));
        json.put("tabpanel", menuitem.getTabpanel());
        json.put("editpanel", menuitem.getEditpanel());
        json.put("servlet", menuitem.getServlet());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Menuitemsearch menuitemsearch) {
        JSONObject json = new JSONObject();
        if(menuitemsearch.used()) {
            byte andoroperator = menuitemsearch.getAndoroperator();
            int maxresults = menuitemsearch.getMaxresults();
            boolean docount = menuitemsearch.getDocount();
            Iterator<EntityPK> primarykeysI = menuitemsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = menuitemsearch.getFieldsearchers().iterator();
            EntityPK primarykey;
            Fieldsearcher fieldsearcher;
            
            json.put("andor", andoroperator);
            json.put("maxresults", maxresults);
            json.put("docount", docount);
            JSONArray pks = new JSONArray();
            int i = 0;
            while(primarykeysI.hasNext()) {
                primarykey = primarykeysI.next();
                pks.add(primarykey.getKeystring());
            }
            json.put("primarykeys", pks);
            JSONObject fss = new JSONObject();
            while(fieldsearchersI.hasNext()) {
                fieldsearcher = fieldsearchersI.next();
                if(fieldsearcher.used()) {
                    fss.put(fieldsearcher.getShortFieldname(), JSONConversion.toJSON(fieldsearcher));
                }
            }
            json.put("fields", fss);
            JSONObject kss = new JSONObject();
            if(menuitemsearch.getMenusearch()!=null && menuitemsearch.getMenusearch().used()) {
                kss.put("menusearcher", JSONMenu.toJSON((Menusearch)menuitemsearch.getMenusearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    /**
     * 
     * @param json: JSONObject with the Filmsearch parameters
     * @return 
     */
    public static Menuitemsearch toMenuitemsearch(JSONObject json) {
        Menuitemsearch menuitemsearch = new Menuitemsearch();
        menuitemsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        menuitemsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        menuitemsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            menuitemsearch.addPrimarykey(MenuitemPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("menuitem");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            menuitemsearch.menuitem(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("tabpanel");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            menuitemsearch.tabpanel(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("editpanel");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            menuitemsearch.editpanel(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("servlet");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            menuitemsearch.servlet(valuearray, compareoperator, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("menusearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Menusearch menusearch = JSONMenu.toMenusearch((JSONObject)keysearch.get(i));
                menuitemsearch.menu(menusearch);
            }
        }
        return menuitemsearch;
    }
    
    public static MenuitemPK toMenuitemPK(JSONObject json) {
        MenuitemPK menuitemPK = null;
        if(json!=null) {
            menuitemPK = new MenuitemPK(JSONConversion.getString(json, "mainmenu"), JSONConversion.getString(json, "menu"), JSONConversion.getString(json, "menuitem"));
        }
        return menuitemPK;
    }

    public static Menuitem toMenuitem(JSONObject json) {
        Menuitem menuitem = new Menuitem(toMenuitemPK((JSONObject)json.get("PK")));
        updateMenuitem(menuitem, json);
        return menuitem;
    }

    public static void updateMenuitem(IMenuitem menuitem, JSONObject json) {
        menuitem.setTabpanel(JSONConversion.getString(json, "tabpanel"));
        menuitem.setEditpanel(JSONConversion.getString(json, "editpanel"));
        menuitem.setServlet(JSONConversion.getString(json, "servlet"));
    }

    public static Menuitem initMenuitem(JSONObject json) {
        Menuitem menuitem = new Menuitem(toMenuitemPK((JSONObject)json.get("PK")));
        menuitem.initTabpanel(JSONConversion.getString(json, "tabpanel"));
        menuitem.initEditpanel(JSONConversion.getString(json, "editpanel"));
        menuitem.initServlet(JSONConversion.getString(json, "servlet"));
        return menuitem;
    }
}

