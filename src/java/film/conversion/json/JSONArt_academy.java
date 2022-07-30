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
import film.entity.pk.Art_academyPK;
import film.interfaces.entity.pk.IArt_academyPK;
import film.interfaces.logicentity.IArt_academy;
import film.logicentity.Art_academy;
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
public class JSONArt_academy {
    
    public static JSONArray toJSONArray(ArrayList art_academys) {
        JSONArray jsonart_academys = new JSONArray();
        Iterator art_academysI = art_academys.iterator();
        while(art_academysI.hasNext()) {
            jsonart_academys.add(toJSON((Art_academy)art_academysI.next()));
        }
        return jsonart_academys;
    }

    public static JSONObject toJSON(IArt_academyPK art_academyPK) {
        JSONObject json = null;
        if(art_academyPK!=null) {
            json = new JSONObject();
            json.put("academyid", String.valueOf(art_academyPK.getAcademyid()));
        }
        return json;
    }

    public static JSONObject toJSON(IArt_academy art_academy) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(art_academy.getPrimaryKey()));
        json.put("academy", art_academy.getAcademy());
        json.put("academylocation", art_academy.getAcademylocation());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Art_academysearch art_academysearch) {
        JSONObject json = new JSONObject();
        if(art_academysearch.used()) {
            byte andoroperator = art_academysearch.getAndoroperator();
            int maxresults = art_academysearch.getMaxresults();
            boolean docount = art_academysearch.getDocount();
            Iterator<EntityPK> primarykeysI = art_academysearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = art_academysearch.getFieldsearchers().iterator();
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

    public static Art_academysearch toArt_academysearch(JSONObject json) {
        Art_academysearch art_academysearch = new Art_academysearch();
        art_academysearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        art_academysearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        art_academysearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            art_academysearch.addPrimarykey(Art_academyPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("academyid");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            art_academysearch.academyid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("academy");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            art_academysearch.academy(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("academylocation");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            art_academysearch.academylocation(valuearray, compareoperator, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        return art_academysearch;
    }
    
    public static Art_academyPK toArt_academyPK(JSONObject json) {
        Art_academyPK art_academyPK = null;
        if(json!=null) {
            art_academyPK = new Art_academyPK(JSONConversion.getlong(json, "academyid"));
        }
        return art_academyPK;
    }

    public static Art_academy toArt_academy(JSONObject json) {
        Art_academy art_academy = new Art_academy(toArt_academyPK((JSONObject)json.get("PK")));
        updateArt_academy(art_academy, json);
        return art_academy;
    }

    public static void updateArt_academy(IArt_academy art_academy, JSONObject json) {
        art_academy.setAcademy(JSONConversion.getString(json, "academy"));
        art_academy.setAcademylocation(JSONConversion.getString(json, "academylocation"));
    }

    public static Art_academy initArt_academy(JSONObject json) {
        Art_academy art_academy = new Art_academy(toArt_academyPK((JSONObject)json.get("PK")));
        art_academy.initAcademy(JSONConversion.getString(json, "academy"));
        art_academy.initAcademylocation(JSONConversion.getString(json, "academylocation"));
        return art_academy;
    }
}

