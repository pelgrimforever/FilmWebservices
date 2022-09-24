/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */
 
package film.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import film.entity.pk.Arealevel3PK;
import film.interfaces.entity.pk.IArealevel3PK;
import film.interfaces.logicentity.IArealevel3;
import film.logicentity.Arealevel3;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONArealevel3 {
    
    public static JSONArray toJSONArray(ArrayList arealevel3s) {
        JSONArray jsonarealevel3s = new JSONArray();
        Iterator arealevel3sI = arealevel3s.iterator();
        while(arealevel3sI.hasNext()) {
            jsonarealevel3s.add(toJSON((Arealevel3)arealevel3sI.next()));
        }
        return jsonarealevel3s;
    }

    public static JSONObject toJSON(IArealevel3PK arealevel3PK) {
        JSONObject json = null;
        if(arealevel3PK!=null) {
            json = new JSONObject();
            json.put("countrycode", arealevel3PK.getCountrycode());
            json.put("al1code", arealevel3PK.getAl1code());
            json.put("al2code", arealevel3PK.getAl2code());
            json.put("al3code", arealevel3PK.getAl3code());
        }
        return json;
    }

    public static JSONObject toJSON(IArealevel3 arealevel3) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(arealevel3.getPrimaryKey()));
        json.put("name", arealevel3.getName());
        if(arealevel3.getLocation()!=null) {
            json.put("location", GISConversion.toJSON(arealevel3.getLocation()));
        }
        if(arealevel3.getBounds()!=null) {
            json.put("bounds", GISConversion.toJSON(arealevel3.getBounds()));
        }
        if(arealevel3.getViewport()!=null) {
            json.put("viewport", GISConversion.toJSON(arealevel3.getViewport()));
        }
        json.put("approximate", arealevel3.getApproximate());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Arealevel3search arealevel3search) {
        JSONObject json = new JSONObject();
        if(arealevel3search.used()) {
            byte andoroperator = arealevel3search.getAndoroperator();
            int maxresults = arealevel3search.getMaxresults();
            boolean docount = arealevel3search.getDocount();
            Iterator<EntityPK> primarykeysI = arealevel3search.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = arealevel3search.getFieldsearchers().iterator();
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
            if(arealevel3search.getArealevel2search()!=null && arealevel3search.getArealevel2search().used()) {
                kss.put("arealevel2searcher", JSONArealevel2.toJSON((Arealevel2search)arealevel3search.getArealevel2search()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Arealevel3search toArealevel3search(JSONObject json) {
        Arealevel3search arealevel3search = new Arealevel3search();
        arealevel3search.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        arealevel3search.setMaxresults(JSONConversion.getint(json, "maxresults"));
        arealevel3search.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            arealevel3search.addPrimarykey(Arealevel3PK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("al3code");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            arealevel3search.al3code(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            arealevel3search.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("approximate");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            arealevel3search.approximate(value);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("arealevel2searcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Arealevel2search arealevel2search = JSONArealevel2.toArealevel2search((JSONObject)keysearch.get(i));
                arealevel3search.arealevel2(arealevel2search);
            }
        }
        return arealevel3search;
    }
    
    public static Arealevel3PK toArealevel3PK(JSONObject json) {
        Arealevel3PK arealevel3PK = null;
        if(json!=null) {
            arealevel3PK = new Arealevel3PK(JSONConversion.getString(json, "countrycode"), JSONConversion.getString(json, "al1code"), JSONConversion.getString(json, "al2code"), JSONConversion.getString(json, "al3code"));
        }
        return arealevel3PK;
    }

    public static Arealevel3 toArealevel3(JSONObject json) {
        Arealevel3 arealevel3 = new Arealevel3(toArealevel3PK((JSONObject)json.get("PK")));
        updateArealevel3(arealevel3, json);
        return arealevel3;
    }

    public static void updateArealevel3(IArealevel3 arealevel3, JSONObject json) {
        arealevel3.setName(JSONConversion.getString(json, "name"));
        arealevel3.setLocation(GISConversion.topiShape((JSONObject)json.get("location")));
        arealevel3.setBounds(GISConversion.topiShape((JSONObject)json.get("bounds")));
        arealevel3.setViewport(GISConversion.topiShape((JSONObject)json.get("viewport")));
        arealevel3.setApproximate(JSONConversion.getboolean(json, "approximate"));
    }

    public static Arealevel3 initArealevel3(JSONObject json) {
        Arealevel3 arealevel3 = new Arealevel3(toArealevel3PK((JSONObject)json.get("PK")));
        arealevel3.initName(JSONConversion.getString(json, "name"));
        arealevel3.initLocation(GISConversion.topiShape((JSONObject)json.get("location")));
        arealevel3.initBounds(GISConversion.topiShape((JSONObject)json.get("bounds")));
        arealevel3.initViewport(GISConversion.topiShape((JSONObject)json.get("viewport")));
        arealevel3.initApproximate(JSONConversion.getboolean(json, "approximate"));
        return arealevel3;
    }
}

