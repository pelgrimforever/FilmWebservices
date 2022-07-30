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
import film.entity.pk.Arealevel2PK;
import film.interfaces.entity.pk.IArealevel2PK;
import film.interfaces.logicentity.IArealevel2;
import film.logicentity.Arealevel2;
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
public class JSONArealevel2 {
    
    public static JSONArray toJSONArray(ArrayList arealevel2s) {
        JSONArray jsonarealevel2s = new JSONArray();
        Iterator arealevel2sI = arealevel2s.iterator();
        while(arealevel2sI.hasNext()) {
            jsonarealevel2s.add(toJSON((Arealevel2)arealevel2sI.next()));
        }
        return jsonarealevel2s;
    }

    public static JSONObject toJSON(IArealevel2PK arealevel2PK) {
        JSONObject json = null;
        if(arealevel2PK!=null) {
            json = new JSONObject();
            json.put("countrycode", arealevel2PK.getCountrycode());
            json.put("al1code", arealevel2PK.getAl1code());
            json.put("al2code", arealevel2PK.getAl2code());
        }
        return json;
    }

    public static JSONObject toJSON(IArealevel2 arealevel2) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(arealevel2.getPrimaryKey()));
        json.put("name", arealevel2.getName());
        if(arealevel2.getLocation()!=null) {
            json.put("location", GISConversion.toJSON(arealevel2.getLocation()));
        }
        if(arealevel2.getBounds()!=null) {
            json.put("bounds", GISConversion.toJSON(arealevel2.getBounds()));
        }
        if(arealevel2.getViewport()!=null) {
            json.put("viewport", GISConversion.toJSON(arealevel2.getViewport()));
        }
        json.put("approximate", arealevel2.getApproximate());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Arealevel2search arealevel2search) {
        JSONObject json = new JSONObject();
        if(arealevel2search.used()) {
            byte andoroperator = arealevel2search.getAndoroperator();
            int maxresults = arealevel2search.getMaxresults();
            boolean docount = arealevel2search.getDocount();
            Iterator<EntityPK> primarykeysI = arealevel2search.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = arealevel2search.getFieldsearchers().iterator();
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
            if(arealevel2search.getArealevel1search()!=null && arealevel2search.getArealevel1search().used()) {
                kss.put("arealevel1searcher", JSONArealevel1.toJSON((Arealevel1search)arealevel2search.getArealevel1search()));
            }
            if(arealevel2search.getArealevel3search()!=null && arealevel2search.getArealevel3search().used()) {
                kss.put("arealevel3searcher", JSONArealevel3.toJSON((Arealevel3search)arealevel2search.getArealevel3search()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Arealevel2search toArealevel2search(JSONObject json) {
        Arealevel2search arealevel2search = new Arealevel2search();
        arealevel2search.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        arealevel2search.setMaxresults(JSONConversion.getint(json, "maxresults"));
        arealevel2search.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            arealevel2search.addPrimarykey(Arealevel2PK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("al2code");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            arealevel2search.al2code(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            arealevel2search.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("approximate");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            arealevel2search.approximate(value);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("arealevel1searcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Arealevel1search arealevel1search = JSONArealevel1.toArealevel1search((JSONObject)keysearch.get(i));
                arealevel2search.arealevel1(arealevel1search);
            }
        }
        keysearch = (JSONArray)kss.get("arealevel3searcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Arealevel3search arealevel3search = JSONArealevel3.toArealevel3search((JSONObject)keysearch.get(i));
                arealevel2search.arealevel3(arealevel3search);
            }
        }
        return arealevel2search;
    }
    
    public static Arealevel2PK toArealevel2PK(JSONObject json) {
        Arealevel2PK arealevel2PK = null;
        if(json!=null) {
            arealevel2PK = new Arealevel2PK(JSONConversion.getString(json, "countrycode"), JSONConversion.getString(json, "al1code"), JSONConversion.getString(json, "al2code"));
        }
        return arealevel2PK;
    }

    public static Arealevel2 toArealevel2(JSONObject json) {
        Arealevel2 arealevel2 = new Arealevel2(toArealevel2PK((JSONObject)json.get("PK")));
        updateArealevel2(arealevel2, json);
        return arealevel2;
    }

    public static void updateArealevel2(IArealevel2 arealevel2, JSONObject json) {
        arealevel2.setName(JSONConversion.getString(json, "name"));
        arealevel2.setLocation(GISConversion.topiShape((JSONObject)json.get("location")));
        arealevel2.setBounds(GISConversion.topiShape((JSONObject)json.get("bounds")));
        arealevel2.setViewport(GISConversion.topiShape((JSONObject)json.get("viewport")));
        arealevel2.setApproximate(JSONConversion.getboolean(json, "approximate"));
    }

    public static Arealevel2 initArealevel2(JSONObject json) {
        Arealevel2 arealevel2 = new Arealevel2(toArealevel2PK((JSONObject)json.get("PK")));
        arealevel2.initName(JSONConversion.getString(json, "name"));
        arealevel2.initLocation(GISConversion.topiShape((JSONObject)json.get("location")));
        arealevel2.initBounds(GISConversion.topiShape((JSONObject)json.get("bounds")));
        arealevel2.initViewport(GISConversion.topiShape((JSONObject)json.get("viewport")));
        arealevel2.initApproximate(JSONConversion.getboolean(json, "approximate"));
        return arealevel2;
    }
}

