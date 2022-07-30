/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */
 
package film.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import film.entity.pk.MenuPK;
import film.interfaces.entity.pk.IMenuPK;
import film.interfaces.logicentity.IMenu;
import film.logicentity.Menu;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Franky Laseure
 */
public class JSONMenu {
    
    public static JSONArray toJSONArray(ArrayList menus) {
        JSONArray jsonmenus = new JSONArray();
        Iterator menusI = menus.iterator();
        while(menusI.hasNext()) {
            jsonmenus.add(toJSON((Menu)menusI.next()));
        }
        return jsonmenus;
    }

    public static JSONObject toJSON(IMenuPK menuPK) {
        JSONObject json = null;
        if(menuPK!=null) {
            json = new JSONObject();
            json.put("mainmenu", menuPK.getMainmenu());
            json.put("menu", menuPK.getMenu());
        }
        return json;
    }

    public static JSONObject toJSON(IMenu menu) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(menu.getPrimaryKey()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Menusearch menusearch) {
        JSONObject json = new JSONObject();
        if(menusearch.used()) {
            byte andoroperator = menusearch.getAndoroperator();
            int maxresults = menusearch.getMaxresults();
            boolean docount = menusearch.getDocount();
            Iterator<EntityPK> primarykeysI = menusearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = menusearch.getFieldsearchers().iterator();
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
            if(menusearch.getMainmenusearch()!=null && menusearch.getMainmenusearch().used()) {
                kss.put("mainmenusearcher", JSONMainmenu.toJSON((Mainmenusearch)menusearch.getMainmenusearch()));
            }
            if(menusearch.getMenuitemsearch()!=null && menusearch.getMenuitemsearch().used()) {
                kss.put("menuitemsearcher", JSONMenuitem.toJSON((Menuitemsearch)menusearch.getMenuitemsearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Menusearch toMenusearch(JSONObject json) {
        Menusearch menusearch = new Menusearch();
        menusearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        menusearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        menusearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            menusearch.addPrimarykey(MenuPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("menu");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            menusearch.menu(valuearray, compareoperator, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("mainmenusearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Mainmenusearch mainmenusearch = JSONMainmenu.toMainmenusearch((JSONObject)keysearch.get(i));
                menusearch.mainmenu(mainmenusearch);
            }
        }
        keysearch = (JSONArray)kss.get("menuitemsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Menuitemsearch menuitemsearch = JSONMenuitem.toMenuitemsearch((JSONObject)keysearch.get(i));
                menusearch.menuitem(menuitemsearch);
            }
        }
        return menusearch;
    }
    
    public static MenuPK toMenuPK(JSONObject json) {
        MenuPK menuPK = null;
        if(json!=null) {
            menuPK = new MenuPK(JSONConversion.getString(json, "mainmenu"), JSONConversion.getString(json, "menu"));
        }
        return menuPK;
    }

    public static Menu toMenu(JSONObject json) {
        Menu menu = new Menu(toMenuPK((JSONObject)json.get("PK")));
        updateMenu(menu, json);
        return menu;
    }

    public static void updateMenu(IMenu menu, JSONObject json) {
    }

    public static Menu initMenu(JSONObject json) {
        Menu menu = new Menu(toMenuPK((JSONObject)json.get("PK")));
        return menu;
    }
}

