/*
 * JSONArt_subgroup.java
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
import film.entity.pk.Art_subgroupPK;
import film.interfaces.entity.pk.IArt_subgroupPK;
import film.interfaces.logicentity.IArt_subgroup;
import film.logicentity.Art_subgroup;
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
public class JSONArt_subgroup {
    
    public static JSONArray toJSONArray(ArrayList art_subgroups) {
        JSONArray jsonart_subgroups = new JSONArray();
        Iterator art_subgroupsI = art_subgroups.iterator();
        while(art_subgroupsI.hasNext()) {
            jsonart_subgroups.add(toJSON((Art_subgroup)art_subgroupsI.next()));
        }
        return jsonart_subgroups;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IArt_subgroupPK art_subgroupPK) {
        JSONObject json = null;
        if(art_subgroupPK!=null) {
            json = new JSONObject();
            json.put("subgroupid", art_subgroupPK.getSubgroupid());
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IArt_subgroup art_subgroup) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(art_subgroup.getPrimaryKey()));
        json.put("art_groupPK", JSONArt_group.toJSON(art_subgroup.getArt_groupPK()));
        json.put("subgroupname", art_subgroup.getSubgroupname());
        json.put("lastseqno", art_subgroup.getLastseqno());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Art_subgroupsearch art_subgroupsearch) {
        JSONObject json = new JSONObject();
        if(art_subgroupsearch.used()) {
            byte andoroperator = art_subgroupsearch.getAndoroperator();
            int maxresults = art_subgroupsearch.getMaxresults();
            boolean docount = art_subgroupsearch.getDocount();
            Iterator<EntityPK> primarykeysI = art_subgroupsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = art_subgroupsearch.getFieldsearchers().iterator();
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
            if(art_subgroupsearch.getArt_groupsearch()!=null && art_subgroupsearch.getArt_groupsearch().used()) {
                kss.put("art_groupsearcher", JSONArt_group.toJSON((Art_groupsearch)art_subgroupsearch.getArt_groupsearch()));
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
    public static Art_subgroupsearch toArt_subgroupsearch(JSONObject json) {
        Art_subgroupsearch art_subgroupsearch = new Art_subgroupsearch();
        art_subgroupsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        art_subgroupsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        art_subgroupsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            art_subgroupsearch.addPrimarykey(Art_subgroupPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("subgroupid");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            art_subgroupsearch.subgroupid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("subgroupname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            art_subgroupsearch.subgroupname(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("lastseqno");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            art_subgroupsearch.lastseqno(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("art_groupsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Art_groupsearch art_groupsearch = JSONArt_group.toArt_groupsearch((JSONObject)keysearch.get(i));
                art_subgroupsearch.art_group(art_groupsearch);
            }
        }
        return art_subgroupsearch;
    }
    
    public static Art_subgroupPK toArt_subgroupPK(JSONObject json) {
        Art_subgroupPK art_subgroupPK = null;
        if(json!=null) {
            art_subgroupPK = new Art_subgroupPK(JSONConversion.getint(json, "subgroupid"));
        }
        return art_subgroupPK;
    }

    public static Art_subgroup toArt_subgroup(JSONObject json) {
        Art_subgroup art_subgroup = new Art_subgroup(toArt_subgroupPK((JSONObject)json.get("PK")));
        updateArt_subgroup(art_subgroup, json);
        return art_subgroup;
    }

    public static void updateArt_subgroup(IArt_subgroup art_subgroup, JSONObject json) {
        art_subgroup.setArt_groupPK(JSONArt_group.toArt_groupPK((JSONObject)json.get("art_groupPK")));
        art_subgroup.setSubgroupname(JSONConversion.getString(json, "subgroupname"));
        art_subgroup.setLastseqno(JSONConversion.getint(json, "lastseqno"));
    }

    public static Art_subgroup initArt_subgroup(JSONObject json) {
        Art_subgroup art_subgroup = new Art_subgroup(toArt_subgroupPK((JSONObject)json.get("PK")));
        art_subgroup.initArt_groupPK(JSONArt_group.toArt_groupPK((JSONObject)json.get("art_groupPK")));
        art_subgroup.initSubgroupname(JSONConversion.getString(json, "subgroupname"));
        art_subgroup.initLastseqno(JSONConversion.getint(json, "lastseqno"));
        return art_subgroup;
    }
}

