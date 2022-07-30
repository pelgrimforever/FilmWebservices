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
import film.entity.pk.Arealevel1PK;
import film.interfaces.entity.pk.IArealevel1PK;
import film.interfaces.logicentity.IArealevel1;
import film.logicentity.Arealevel1;
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
public class JSONArealevel1 {
    
    public static JSONArray toJSONArray(ArrayList arealevel1s) {
        JSONArray jsonarealevel1s = new JSONArray();
        Iterator arealevel1sI = arealevel1s.iterator();
        while(arealevel1sI.hasNext()) {
            jsonarealevel1s.add(toJSON((Arealevel1)arealevel1sI.next()));
        }
        return jsonarealevel1s;
    }

    public static JSONObject toJSON(IArealevel1PK arealevel1PK) {
        JSONObject json = null;
        if(arealevel1PK!=null) {
            json = new JSONObject();
            json.put("countrycode", arealevel1PK.getCountrycode());
            json.put("al1code", arealevel1PK.getAl1code());
        }
        return json;
    }

    public static JSONObject toJSON(IArealevel1 arealevel1) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(arealevel1.getPrimaryKey()));
        json.put("name", arealevel1.getName());
        if(arealevel1.getLocation()!=null) {
            json.put("location", GISConversion.toJSON(arealevel1.getLocation()));
        }
        if(arealevel1.getBounds()!=null) {
            json.put("bounds", GISConversion.toJSON(arealevel1.getBounds()));
        }
        if(arealevel1.getViewport()!=null) {
            json.put("viewport", GISConversion.toJSON(arealevel1.getViewport()));
        }
        json.put("approximate", arealevel1.getApproximate());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Arealevel1search arealevel1search) {
        JSONObject json = new JSONObject();
        if(arealevel1search.used()) {
            byte andoroperator = arealevel1search.getAndoroperator();
            int maxresults = arealevel1search.getMaxresults();
            boolean docount = arealevel1search.getDocount();
            Iterator<EntityPK> primarykeysI = arealevel1search.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = arealevel1search.getFieldsearchers().iterator();
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
            if(arealevel1search.getCountrysearch()!=null && arealevel1search.getCountrysearch().used()) {
                kss.put("countrysearcher", JSONCountry.toJSON((Countrysearch)arealevel1search.getCountrysearch()));
            }
            if(arealevel1search.getArealevel2search()!=null && arealevel1search.getArealevel2search().used()) {
                kss.put("arealevel2searcher", JSONArealevel2.toJSON((Arealevel2search)arealevel1search.getArealevel2search()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Arealevel1search toArealevel1search(JSONObject json) {
        Arealevel1search arealevel1search = new Arealevel1search();
        arealevel1search.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        arealevel1search.setMaxresults(JSONConversion.getint(json, "maxresults"));
        arealevel1search.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            arealevel1search.addPrimarykey(Arealevel1PK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("al1code");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            arealevel1search.al1code(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            arealevel1search.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("approximate");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            arealevel1search.approximate(value);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("countrysearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Countrysearch countrysearch = JSONCountry.toCountrysearch((JSONObject)keysearch.get(i));
                arealevel1search.country(countrysearch);
            }
        }
        keysearch = (JSONArray)kss.get("arealevel2searcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Arealevel2search arealevel2search = JSONArealevel2.toArealevel2search((JSONObject)keysearch.get(i));
                arealevel1search.arealevel2(arealevel2search);
            }
        }
        return arealevel1search;
    }
    
    public static Arealevel1PK toArealevel1PK(JSONObject json) {
        Arealevel1PK arealevel1PK = null;
        if(json!=null) {
            arealevel1PK = new Arealevel1PK(JSONConversion.getString(json, "countrycode"), JSONConversion.getString(json, "al1code"));
        }
        return arealevel1PK;
    }

    public static Arealevel1 toArealevel1(JSONObject json) {
        Arealevel1 arealevel1 = new Arealevel1(toArealevel1PK((JSONObject)json.get("PK")));
        updateArealevel1(arealevel1, json);
        return arealevel1;
    }

    public static void updateArealevel1(IArealevel1 arealevel1, JSONObject json) {
        arealevel1.setName(JSONConversion.getString(json, "name"));
        arealevel1.setLocation(GISConversion.topiShape((JSONObject)json.get("location")));
        arealevel1.setBounds(GISConversion.topiShape((JSONObject)json.get("bounds")));
        arealevel1.setViewport(GISConversion.topiShape((JSONObject)json.get("viewport")));
        arealevel1.setApproximate(JSONConversion.getboolean(json, "approximate"));
    }

    public static Arealevel1 initArealevel1(JSONObject json) {
        Arealevel1 arealevel1 = new Arealevel1(toArealevel1PK((JSONObject)json.get("PK")));
        arealevel1.initName(JSONConversion.getString(json, "name"));
        arealevel1.initLocation(GISConversion.topiShape((JSONObject)json.get("location")));
        arealevel1.initBounds(GISConversion.topiShape((JSONObject)json.get("bounds")));
        arealevel1.initViewport(GISConversion.topiShape((JSONObject)json.get("viewport")));
        arealevel1.initApproximate(JSONConversion.getboolean(json, "approximate"));
        return arealevel1;
    }
}

