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
import film.entity.pk.UploadsessionsettingsPK;
import film.interfaces.entity.pk.IUploadsessionsettingsPK;
import film.interfaces.logicentity.IUploadsessionsettings;
import film.logicentity.Uploadsessionsettings;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONUploadsessionsettings {
    
    public static JSONArray toJSONArray(ArrayList uploadsessionsettingss) {
        JSONArray jsonuploadsessionsettingss = new JSONArray();
        Iterator uploadsessionsettingssI = uploadsessionsettingss.iterator();
        while(uploadsessionsettingssI.hasNext()) {
            jsonuploadsessionsettingss.add(toJSON((Uploadsessionsettings)uploadsessionsettingssI.next()));
        }
        return jsonuploadsessionsettingss;
    }

    public static JSONObject toJSON(IUploadsessionsettingsPK uploadsessionsettingsPK) {
        JSONObject json = null;
        if(uploadsessionsettingsPK!=null) {
            json = new JSONObject();
            json.put("directory", uploadsessionsettingsPK.getDirectory());
        }
        return json;
    }

    public static JSONObject toJSON(IUploadsessionsettings uploadsessionsettings) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(uploadsessionsettings.getPrimaryKey()));
        json.put("uploadtype", uploadsessionsettings.getUploadtype());
        json.put("filmgroups", uploadsessionsettings.getFilmgroups());
        json.put("lastposition", uploadsessionsettings.getLastposition());
        json.put("copymode", uploadsessionsettings.getCopymode());
        json.put("uploadingposition", uploadsessionsettings.getUploadingposition());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Uploadsessionsettingssearch uploadsessionsettingssearch) {
        JSONObject json = new JSONObject();
        if(uploadsessionsettingssearch.used()) {
            byte andoroperator = uploadsessionsettingssearch.getAndoroperator();
            int maxresults = uploadsessionsettingssearch.getMaxresults();
            boolean docount = uploadsessionsettingssearch.getDocount();
            Iterator<EntityPK> primarykeysI = uploadsessionsettingssearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = uploadsessionsettingssearch.getFieldsearchers().iterator();
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

    public static Uploadsessionsettingssearch toUploadsessionsettingssearch(JSONObject json) {
        Uploadsessionsettingssearch uploadsessionsettingssearch = new Uploadsessionsettingssearch();
        uploadsessionsettingssearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        uploadsessionsettingssearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        uploadsessionsettingssearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            uploadsessionsettingssearch.addPrimarykey(UploadsessionsettingsPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("directory");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            uploadsessionsettingssearch.directory(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("uploadtype");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            uploadsessionsettingssearch.uploadtype(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("filmgroups");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            uploadsessionsettingssearch.filmgroups(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("lastposition");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            uploadsessionsettingssearch.lastposition(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("copymode");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            uploadsessionsettingssearch.copymode(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("uploadingposition");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            uploadsessionsettingssearch.uploadingposition(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        return uploadsessionsettingssearch;
    }
    
    public static UploadsessionsettingsPK toUploadsessionsettingsPK(JSONObject json) {
        UploadsessionsettingsPK uploadsessionsettingsPK = null;
        if(json!=null) {
            uploadsessionsettingsPK = new UploadsessionsettingsPK(JSONConversion.getString(json, "directory"));
        }
        return uploadsessionsettingsPK;
    }

    public static Uploadsessionsettings toUploadsessionsettings(JSONObject json) {
        Uploadsessionsettings uploadsessionsettings = new Uploadsessionsettings(toUploadsessionsettingsPK((JSONObject)json.get("PK")));
        updateUploadsessionsettings(uploadsessionsettings, json);
        return uploadsessionsettings;
    }

    public static void updateUploadsessionsettings(IUploadsessionsettings uploadsessionsettings, JSONObject json) {
        uploadsessionsettings.setUploadtype(JSONConversion.getString(json, "uploadtype"));
        uploadsessionsettings.setFilmgroups(JSONConversion.getString(json, "filmgroups"));
        uploadsessionsettings.setLastposition(JSONConversion.getint(json, "lastposition"));
        uploadsessionsettings.setCopymode(JSONConversion.getString(json, "copymode"));
        uploadsessionsettings.setUploadingposition(JSONConversion.getint(json, "uploadingposition"));
    }

    public static Uploadsessionsettings initUploadsessionsettings(JSONObject json) {
        Uploadsessionsettings uploadsessionsettings = new Uploadsessionsettings(toUploadsessionsettingsPK((JSONObject)json.get("PK")));
        uploadsessionsettings.initUploadtype(JSONConversion.getString(json, "uploadtype"));
        uploadsessionsettings.initFilmgroups(JSONConversion.getString(json, "filmgroups"));
        uploadsessionsettings.initLastposition(JSONConversion.getint(json, "lastposition"));
        uploadsessionsettings.initCopymode(JSONConversion.getString(json, "copymode"));
        uploadsessionsettings.initUploadingposition(JSONConversion.getint(json, "uploadingposition"));
        return uploadsessionsettings;
    }
}

