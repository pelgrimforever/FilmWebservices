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
import film.entity.pk.Art_groupPK;
import film.interfaces.entity.pk.IArt_groupPK;
import film.interfaces.logicentity.IArt_group;
import film.logicentity.Art_group;
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
public class JSONArt_group {
    
    public static JSONArray toJSONArray(ArrayList art_groups) {
        JSONArray jsonart_groups = new JSONArray();
        Iterator art_groupsI = art_groups.iterator();
        while(art_groupsI.hasNext()) {
            jsonart_groups.add(toJSON((Art_group)art_groupsI.next()));
        }
        return jsonart_groups;
    }

    public static JSONObject toJSON(IArt_groupPK art_groupPK) {
        JSONObject json = null;
        if(art_groupPK!=null) {
            json = new JSONObject();
            json.put("groupid", String.valueOf(art_groupPK.getGroupid()));
        }
        return json;
    }

    public static JSONObject toJSON(IArt_group art_group) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(art_group.getPrimaryKey()));
        json.put("groupname", art_group.getGroupname());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Art_groupsearch art_groupsearch) {
        JSONObject json = new JSONObject();
        if(art_groupsearch.used()) {
            byte andoroperator = art_groupsearch.getAndoroperator();
            int maxresults = art_groupsearch.getMaxresults();
            boolean docount = art_groupsearch.getDocount();
            Iterator<EntityPK> primarykeysI = art_groupsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = art_groupsearch.getFieldsearchers().iterator();
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

    public static Art_groupsearch toArt_groupsearch(JSONObject json) {
        Art_groupsearch art_groupsearch = new Art_groupsearch();
        art_groupsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        art_groupsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        art_groupsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            art_groupsearch.addPrimarykey(Art_groupPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("groupid");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            art_groupsearch.groupid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("groupname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            art_groupsearch.groupname(valuearray, compareoperator, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        return art_groupsearch;
    }
    
    public static Art_groupPK toArt_groupPK(JSONObject json) {
        Art_groupPK art_groupPK = null;
        if(json!=null) {
            art_groupPK = new Art_groupPK(JSONConversion.getlong(json, "groupid"));
        }
        return art_groupPK;
    }

    public static Art_group toArt_group(JSONObject json) {
        Art_group art_group = new Art_group(toArt_groupPK((JSONObject)json.get("PK")));
        updateArt_group(art_group, json);
        return art_group;
    }

    public static void updateArt_group(IArt_group art_group, JSONObject json) {
        art_group.setGroupname(JSONConversion.getString(json, "groupname"));
    }

    public static Art_group initArt_group(JSONObject json) {
        Art_group art_group = new Art_group(toArt_groupPK((JSONObject)json.get("PK")));
        art_group.initGroupname(JSONConversion.getString(json, "groupname"));
        return art_group;
    }
}

