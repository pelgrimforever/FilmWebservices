/*
 * JSONSublocality.java
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
import film.entity.pk.SublocalityPK;
import film.interfaces.entity.pk.ISublocalityPK;
import film.interfaces.logicentity.ISublocality;
import film.logicentity.Sublocality;
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
public class JSONSublocality {
    
    public static JSONArray toJSONArray(ArrayList sublocalitys) {
        JSONArray jsonsublocalitys = new JSONArray();
        Iterator sublocalitysI = sublocalitys.iterator();
        while(sublocalitysI.hasNext()) {
            jsonsublocalitys.add(toJSON((Sublocality)sublocalitysI.next()));
        }
        return jsonsublocalitys;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(ISublocalityPK sublocalityPK) {
        JSONObject json = null;
        if(sublocalityPK!=null) {
            json = new JSONObject();
            json.put("countrycode", sublocalityPK.getCountrycode());
            json.put("postalcode", sublocalityPK.getPostalcode());
            json.put("locality", sublocalityPK.getLocality());
            json.put("sublocality", sublocalityPK.getSublocality());
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(ISublocality sublocality) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(sublocality.getPrimaryKey()));
        if(sublocality.getLocation()!=null) {
            json.put("location", GISConversion.toJSON(sublocality.getLocation()));
        }
        if(sublocality.getBounds()!=null) {
            json.put("bounds", GISConversion.toJSON(sublocality.getBounds()));
        }
        if(sublocality.getViewport()!=null) {
            json.put("viewport", GISConversion.toJSON(sublocality.getViewport()));
        }
        json.put("approximate", sublocality.getApproximate());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Sublocalitysearch sublocalitysearch) {
        JSONObject json = new JSONObject();
        if(sublocalitysearch.used()) {
            byte andoroperator = sublocalitysearch.getAndoroperator();
            int maxresults = sublocalitysearch.getMaxresults();
            boolean docount = sublocalitysearch.getDocount();
            Iterator<EntityPK> primarykeysI = sublocalitysearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = sublocalitysearch.getFieldsearchers().iterator();
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
            if(sublocalitysearch.getLocalitysearch()!=null && sublocalitysearch.getLocalitysearch().used()) {
                kss.put("localitysearcher", JSONLocality.toJSON((Localitysearch)sublocalitysearch.getLocalitysearch()));
            }
            if(sublocalitysearch.getRoutesearch()!=null && sublocalitysearch.getRoutesearch().used()) {
                kss.put("routesearcher", JSONRoute.toJSON((Routesearch)sublocalitysearch.getRoutesearch()));
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
    public static Sublocalitysearch toSublocalitysearch(JSONObject json) {
        Sublocalitysearch sublocalitysearch = new Sublocalitysearch();
        sublocalitysearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        sublocalitysearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        sublocalitysearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            sublocalitysearch.addPrimarykey(SublocalityPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("sublocality");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            sublocalitysearch.sublocality(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("approximate");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            sublocalitysearch.approximate(value);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("localitysearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Localitysearch localitysearch = JSONLocality.toLocalitysearch((JSONObject)keysearch.get(i));
                sublocalitysearch.locality(localitysearch);
            }
        }
        keysearch = (JSONArray)kss.get("routesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Routesearch routesearch = JSONRoute.toRoutesearch((JSONObject)keysearch.get(i));
                sublocalitysearch.route(routesearch);
            }
        }
        return sublocalitysearch;
    }
    
    public static SublocalityPK toSublocalityPK(JSONObject json) {
        SublocalityPK sublocalityPK = null;
        if(json!=null) {
            sublocalityPK = new SublocalityPK(JSONConversion.getString(json, "countrycode"), JSONConversion.getString(json, "postalcode"), JSONConversion.getString(json, "locality"), JSONConversion.getString(json, "sublocality"));
        }
        return sublocalityPK;
    }

    public static Sublocality toSublocality(JSONObject json) {
        Sublocality sublocality = new Sublocality(toSublocalityPK((JSONObject)json.get("PK")));
        updateSublocality(sublocality, json);
        return sublocality;
    }

    public static void updateSublocality(ISublocality sublocality, JSONObject json) {
        sublocality.setLocation(GISConversion.topiShape((JSONObject)json.get("location")));
        sublocality.setBounds(GISConversion.topiShape((JSONObject)json.get("bounds")));
        sublocality.setViewport(GISConversion.topiShape((JSONObject)json.get("viewport")));
        sublocality.setApproximate(JSONConversion.getboolean(json, "approximate"));
    }

    public static Sublocality initSublocality(JSONObject json) {
        Sublocality sublocality = new Sublocality(toSublocalityPK((JSONObject)json.get("PK")));
        sublocality.initLocation(GISConversion.topiShape((JSONObject)json.get("location")));
        sublocality.initBounds(GISConversion.topiShape((JSONObject)json.get("bounds")));
        sublocality.initViewport(GISConversion.topiShape((JSONObject)json.get("viewport")));
        sublocality.initApproximate(JSONConversion.getboolean(json, "approximate"));
        return sublocality;
    }
}

