/*
 * JSONSpatial_ref_sys.java
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
import film.entity.pk.Spatial_ref_sysPK;
import film.interfaces.entity.pk.ISpatial_ref_sysPK;
import film.interfaces.logicentity.ISpatial_ref_sys;
import film.logicentity.Spatial_ref_sys;
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
public class JSONSpatial_ref_sys {
    
    public static JSONArray toJSONArray(ArrayList spatial_ref_syss) {
        JSONArray jsonspatial_ref_syss = new JSONArray();
        Iterator spatial_ref_syssI = spatial_ref_syss.iterator();
        while(spatial_ref_syssI.hasNext()) {
            jsonspatial_ref_syss.add(toJSON((Spatial_ref_sys)spatial_ref_syssI.next()));
        }
        return jsonspatial_ref_syss;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(ISpatial_ref_sysPK spatial_ref_sysPK) {
        JSONObject json = null;
        if(spatial_ref_sysPK!=null) {
            json = new JSONObject();
            json.put("srid", spatial_ref_sysPK.getSrid());
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(ISpatial_ref_sys spatial_ref_sys) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(spatial_ref_sys.getPrimaryKey()));
        json.put("auth_name", spatial_ref_sys.getAuth_name());
        json.put("auth_srid", spatial_ref_sys.getAuth_srid());
        json.put("srtext", spatial_ref_sys.getSrtext());
        json.put("proj4text", spatial_ref_sys.getProj4text());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Spatial_ref_syssearch spatial_ref_syssearch) {
        JSONObject json = new JSONObject();
        if(spatial_ref_syssearch.used()) {
            byte andoroperator = spatial_ref_syssearch.getAndoroperator();
            int maxresults = spatial_ref_syssearch.getMaxresults();
            boolean docount = spatial_ref_syssearch.getDocount();
            Iterator<EntityPK> primarykeysI = spatial_ref_syssearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = spatial_ref_syssearch.getFieldsearchers().iterator();
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
            json.put("keysearch", kss);
        }
        return json;
    }

    /**
     * 
     * @param json: JSONObject with the Filmsearch parameters
     * @return 
     */
    public static Spatial_ref_syssearch toSpatial_ref_syssearch(JSONObject json) {
        Spatial_ref_syssearch spatial_ref_syssearch = new Spatial_ref_syssearch();
        spatial_ref_syssearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        spatial_ref_syssearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        spatial_ref_syssearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            spatial_ref_syssearch.addPrimarykey(Spatial_ref_sysPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("srid");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            spatial_ref_syssearch.srid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("auth_name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            spatial_ref_syssearch.auth_name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("auth_srid");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            spatial_ref_syssearch.auth_srid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("srtext");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            spatial_ref_syssearch.srtext(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("proj4text");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            spatial_ref_syssearch.proj4text(valuearray, compareoperator, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        return spatial_ref_syssearch;
    }
    
    public static Spatial_ref_sysPK toSpatial_ref_sysPK(JSONObject json) {
        Spatial_ref_sysPK spatial_ref_sysPK = null;
        if(json!=null) {
            spatial_ref_sysPK = new Spatial_ref_sysPK(JSONConversion.getint(json, "srid"));
        }
        return spatial_ref_sysPK;
    }

    public static Spatial_ref_sys toSpatial_ref_sys(JSONObject json) {
        Spatial_ref_sys spatial_ref_sys = new Spatial_ref_sys(toSpatial_ref_sysPK((JSONObject)json.get("PK")));
        updateSpatial_ref_sys(spatial_ref_sys, json);
        return spatial_ref_sys;
    }

    public static void updateSpatial_ref_sys(ISpatial_ref_sys spatial_ref_sys, JSONObject json) {
        spatial_ref_sys.setAuth_name(JSONConversion.getString(json, "auth_name"));
        spatial_ref_sys.setAuth_srid(JSONConversion.getint(json, "auth_srid"));
        spatial_ref_sys.setSrtext(JSONConversion.getString(json, "srtext"));
        spatial_ref_sys.setProj4text(JSONConversion.getString(json, "proj4text"));
    }

    public static Spatial_ref_sys initSpatial_ref_sys(JSONObject json) {
        Spatial_ref_sys spatial_ref_sys = new Spatial_ref_sys(toSpatial_ref_sysPK((JSONObject)json.get("PK")));
        spatial_ref_sys.initAuth_name(JSONConversion.getString(json, "auth_name"));
        spatial_ref_sys.initAuth_srid(JSONConversion.getint(json, "auth_srid"));
        spatial_ref_sys.initSrtext(JSONConversion.getString(json, "srtext"));
        spatial_ref_sys.initProj4text(JSONConversion.getString(json, "proj4text"));
        return spatial_ref_sys;
    }
}

