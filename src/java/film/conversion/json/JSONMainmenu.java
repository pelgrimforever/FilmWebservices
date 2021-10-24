/*
 * JSONMainmenu.java
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
import film.entity.pk.MainmenuPK;
import film.interfaces.entity.pk.IMainmenuPK;
import film.interfaces.logicentity.IMainmenu;
import film.logicentity.Mainmenu;
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
public class JSONMainmenu {
    
    public static JSONArray toJSONArray(ArrayList mainmenus) {
        JSONArray jsonmainmenus = new JSONArray();
        Iterator mainmenusI = mainmenus.iterator();
        while(mainmenusI.hasNext()) {
            jsonmainmenus.add(toJSON((Mainmenu)mainmenusI.next()));
        }
        return jsonmainmenus;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IMainmenuPK mainmenuPK) {
        JSONObject json = null;
        if(mainmenuPK!=null) {
            json = new JSONObject();
            json.put("mainmenu", mainmenuPK.getMainmenu());
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IMainmenu mainmenu) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(mainmenu.getPrimaryKey()));
        json.put("popuplabel", mainmenu.getPopuplabel());
        json.put("icon", mainmenu.getIcon());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Mainmenusearch mainmenusearch) {
        JSONObject json = new JSONObject();
        if(mainmenusearch.used()) {
            byte andoroperator = mainmenusearch.getAndoroperator();
            int maxresults = mainmenusearch.getMaxresults();
            boolean docount = mainmenusearch.getDocount();
            Iterator<EntityPK> primarykeysI = mainmenusearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = mainmenusearch.getFieldsearchers().iterator();
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
            if(mainmenusearch.getMenusearch()!=null && mainmenusearch.getMenusearch().used()) {
                kss.put("menusearcher", JSONMenu.toJSON((Menusearch)mainmenusearch.getMenusearch()));
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
    public static Mainmenusearch toMainmenusearch(JSONObject json) {
        Mainmenusearch mainmenusearch = new Mainmenusearch();
        mainmenusearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        mainmenusearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        mainmenusearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            mainmenusearch.addPrimarykey(MainmenuPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("mainmenu");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            mainmenusearch.mainmenu(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("popuplabel");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            mainmenusearch.popuplabel(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("icon");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            mainmenusearch.icon(valuearray, compareoperator, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("menusearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Menusearch menusearch = JSONMenu.toMenusearch((JSONObject)keysearch.get(i));
                mainmenusearch.menu(menusearch);
            }
        }
        return mainmenusearch;
    }
    
    public static MainmenuPK toMainmenuPK(JSONObject json) {
        MainmenuPK mainmenuPK = null;
        if(json!=null) {
            mainmenuPK = new MainmenuPK(JSONConversion.getString(json, "mainmenu"));
        }
        return mainmenuPK;
    }

    public static Mainmenu toMainmenu(JSONObject json) {
        Mainmenu mainmenu = new Mainmenu(toMainmenuPK((JSONObject)json.get("PK")));
        updateMainmenu(mainmenu, json);
        return mainmenu;
    }

    public static void updateMainmenu(IMainmenu mainmenu, JSONObject json) {
        mainmenu.setPopuplabel(JSONConversion.getString(json, "popuplabel"));
        mainmenu.setIcon(JSONConversion.getString(json, "icon"));
    }

    public static Mainmenu initMainmenu(JSONObject json) {
        Mainmenu mainmenu = new Mainmenu(toMainmenuPK((JSONObject)json.get("PK")));
        mainmenu.initPopuplabel(JSONConversion.getString(json, "popuplabel"));
        mainmenu.initIcon(JSONConversion.getString(json, "icon"));
        return mainmenu;
    }
}

