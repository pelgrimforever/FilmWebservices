/*
 * JSONPostalcode.java
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
import film.entity.pk.PostalcodePK;
import film.interfaces.entity.pk.IPostalcodePK;
import film.interfaces.logicentity.IPostalcode;
import film.logicentity.Postalcode;
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
public class JSONPostalcode {
    
    public static JSONArray toJSONArray(ArrayList postalcodes) {
        JSONArray jsonpostalcodes = new JSONArray();
        Iterator postalcodesI = postalcodes.iterator();
        while(postalcodesI.hasNext()) {
            jsonpostalcodes.add(toJSON((Postalcode)postalcodesI.next()));
        }
        return jsonpostalcodes;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IPostalcodePK postalcodePK) {
        JSONObject json = null;
        if(postalcodePK!=null) {
            json = new JSONObject();
            json.put("countrycode", postalcodePK.getCountrycode());
            json.put("postalcode", postalcodePK.getPostalcode());
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IPostalcode postalcode) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(postalcode.getPrimaryKey()));
        json.put("arealevel3PK", JSONArealevel3.toJSON(postalcode.getArealevel3PK()));
        if(postalcode.getLocation()!=null) {
            json.put("location", GISConversion.toJSON(postalcode.getLocation()));
        }
        if(postalcode.getBounds()!=null) {
            json.put("bounds", GISConversion.toJSON(postalcode.getBounds()));
        }
        if(postalcode.getViewport()!=null) {
            json.put("viewport", GISConversion.toJSON(postalcode.getViewport()));
        }
        json.put("approximate", postalcode.getApproximate());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Postalcodesearch postalcodesearch) {
        JSONObject json = new JSONObject();
        if(postalcodesearch.used()) {
            byte andoroperator = postalcodesearch.getAndoroperator();
            int maxresults = postalcodesearch.getMaxresults();
            boolean docount = postalcodesearch.getDocount();
            Iterator<EntityPK> primarykeysI = postalcodesearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = postalcodesearch.getFieldsearchers().iterator();
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
            if(postalcodesearch.getArealevel3search()!=null && postalcodesearch.getArealevel3search().used()) {
                kss.put("arealevel3searcher", JSONArealevel3.toJSON((Arealevel3search)postalcodesearch.getArealevel3search()));
            }
            if(postalcodesearch.getLocalitysearch()!=null && postalcodesearch.getLocalitysearch().used()) {
                kss.put("localitysearcher", JSONLocality.toJSON((Localitysearch)postalcodesearch.getLocalitysearch()));
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
    public static Postalcodesearch toPostalcodesearch(JSONObject json) {
        Postalcodesearch postalcodesearch = new Postalcodesearch();
        postalcodesearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        postalcodesearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        postalcodesearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            postalcodesearch.addPrimarykey(PostalcodePK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("countrycode");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            postalcodesearch.countrycode(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("postalcode");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            postalcodesearch.postalcode(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("approximate");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            postalcodesearch.approximate(value);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("arealevel3searcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Arealevel3search arealevel3search = JSONArealevel3.toArealevel3search((JSONObject)keysearch.get(i));
                postalcodesearch.arealevel3(arealevel3search);
            }
        }
        keysearch = (JSONArray)kss.get("localitysearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Localitysearch localitysearch = JSONLocality.toLocalitysearch((JSONObject)keysearch.get(i));
                postalcodesearch.locality(localitysearch);
            }
        }
        return postalcodesearch;
    }
    
    public static PostalcodePK toPostalcodePK(JSONObject json) {
        PostalcodePK postalcodePK = null;
        if(json!=null) {
            postalcodePK = new PostalcodePK(JSONConversion.getString(json, "countrycode"), JSONConversion.getString(json, "postalcode"));
        }
        return postalcodePK;
    }

    public static Postalcode toPostalcode(JSONObject json) {
        Postalcode postalcode = new Postalcode(toPostalcodePK((JSONObject)json.get("PK")));
        updatePostalcode(postalcode, json);
        return postalcode;
    }

    public static void updatePostalcode(IPostalcode postalcode, JSONObject json) {
        postalcode.setArealevel3PK(JSONArealevel3.toArealevel3PK((JSONObject)json.get("arealevel3PK")));
        postalcode.setLocation(GISConversion.topiShape((JSONObject)json.get("location")));
        postalcode.setBounds(GISConversion.topiShape((JSONObject)json.get("bounds")));
        postalcode.setViewport(GISConversion.topiShape((JSONObject)json.get("viewport")));
        postalcode.setApproximate(JSONConversion.getboolean(json, "approximate"));
    }

    public static Postalcode initPostalcode(JSONObject json) {
        Postalcode postalcode = new Postalcode(toPostalcodePK((JSONObject)json.get("PK")));
        postalcode.initArealevel3PK(JSONArealevel3.toArealevel3PK((JSONObject)json.get("arealevel3PK")));
        postalcode.initLocation(GISConversion.topiShape((JSONObject)json.get("location")));
        postalcode.initBounds(GISConversion.topiShape((JSONObject)json.get("bounds")));
        postalcode.initViewport(GISConversion.topiShape((JSONObject)json.get("viewport")));
        postalcode.initApproximate(JSONConversion.getboolean(json, "approximate"));
        return postalcode;
    }
}

