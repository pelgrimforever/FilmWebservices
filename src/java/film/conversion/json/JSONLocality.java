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
import film.entity.pk.LocalityPK;
import film.interfaces.entity.pk.ILocalityPK;
import film.interfaces.logicentity.ILocality;
import film.logicentity.Locality;
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
public class JSONLocality {
    
    public static JSONArray toJSONArray(ArrayList localitys) {
        JSONArray jsonlocalitys = new JSONArray();
        Iterator localitysI = localitys.iterator();
        while(localitysI.hasNext()) {
            jsonlocalitys.add(toJSON((Locality)localitysI.next()));
        }
        return jsonlocalitys;
    }

    public static JSONObject toJSON(ILocalityPK localityPK) {
        JSONObject json = null;
        if(localityPK!=null) {
            json = new JSONObject();
            json.put("countrycode", localityPK.getCountrycode());
            json.put("postalcode", localityPK.getPostalcode());
            json.put("locality", localityPK.getLocality());
        }
        return json;
    }

    public static JSONObject toJSON(ILocality locality) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(locality.getPrimaryKey()));
        if(locality.getLocation()!=null) {
            json.put("location", GISConversion.toJSON(locality.getLocation()));
        }
        if(locality.getBounds()!=null) {
            json.put("bounds", GISConversion.toJSON(locality.getBounds()));
        }
        if(locality.getViewport()!=null) {
            json.put("viewport", GISConversion.toJSON(locality.getViewport()));
        }
        json.put("approximate", locality.getApproximate());
        json.put("hassublocality", locality.getHassublocality());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Localitysearch localitysearch) {
        JSONObject json = new JSONObject();
        if(localitysearch.used()) {
            byte andoroperator = localitysearch.getAndoroperator();
            int maxresults = localitysearch.getMaxresults();
            boolean docount = localitysearch.getDocount();
            Iterator<EntityPK> primarykeysI = localitysearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = localitysearch.getFieldsearchers().iterator();
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
            if(localitysearch.getPostalcodesearch()!=null && localitysearch.getPostalcodesearch().used()) {
                kss.put("postalcodesearcher", JSONPostalcode.toJSON((Postalcodesearch)localitysearch.getPostalcodesearch()));
            }
            if(localitysearch.getSublocalitysearch()!=null && localitysearch.getSublocalitysearch().used()) {
                kss.put("sublocalitysearcher", JSONSublocality.toJSON((Sublocalitysearch)localitysearch.getSublocalitysearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Localitysearch toLocalitysearch(JSONObject json) {
        Localitysearch localitysearch = new Localitysearch();
        localitysearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        localitysearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        localitysearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            localitysearch.addPrimarykey(LocalityPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("locality");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            localitysearch.locality(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("approximate");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            localitysearch.approximate(value);
        }
        field = (JSONObject)fss.get("hassublocality");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            localitysearch.hassublocality(value);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("postalcodesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Postalcodesearch postalcodesearch = JSONPostalcode.toPostalcodesearch((JSONObject)keysearch.get(i));
                localitysearch.postalcode(postalcodesearch);
            }
        }
        keysearch = (JSONArray)kss.get("sublocalitysearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Sublocalitysearch sublocalitysearch = JSONSublocality.toSublocalitysearch((JSONObject)keysearch.get(i));
                localitysearch.sublocality(sublocalitysearch);
            }
        }
        return localitysearch;
    }
    
    public static LocalityPK toLocalityPK(JSONObject json) {
        LocalityPK localityPK = null;
        if(json!=null) {
            localityPK = new LocalityPK(JSONConversion.getString(json, "countrycode"), JSONConversion.getString(json, "postalcode"), JSONConversion.getString(json, "locality"));
        }
        return localityPK;
    }

    public static Locality toLocality(JSONObject json) {
        Locality locality = new Locality(toLocalityPK((JSONObject)json.get("PK")));
        updateLocality(locality, json);
        return locality;
    }

    public static void updateLocality(ILocality locality, JSONObject json) {
        locality.setLocation(GISConversion.topiShape((JSONObject)json.get("location")));
        locality.setBounds(GISConversion.topiShape((JSONObject)json.get("bounds")));
        locality.setViewport(GISConversion.topiShape((JSONObject)json.get("viewport")));
        locality.setApproximate(JSONConversion.getboolean(json, "approximate"));
        locality.setHassublocality(JSONConversion.getboolean(json, "hassublocality"));
    }

    public static Locality initLocality(JSONObject json) {
        Locality locality = new Locality(toLocalityPK((JSONObject)json.get("PK")));
        locality.initLocation(GISConversion.topiShape((JSONObject)json.get("location")));
        locality.initBounds(GISConversion.topiShape((JSONObject)json.get("bounds")));
        locality.initViewport(GISConversion.topiShape((JSONObject)json.get("viewport")));
        locality.initApproximate(JSONConversion.getboolean(json, "approximate"));
        locality.initHassublocality(JSONConversion.getboolean(json, "hassublocality"));
        return locality;
    }
}

