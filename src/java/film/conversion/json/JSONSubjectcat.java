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
import film.entity.pk.SubjectcatPK;
import film.interfaces.entity.pk.ISubjectcatPK;
import film.interfaces.logicentity.ISubjectcat;
import film.logicentity.Subjectcat;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONSubjectcat {
    
    public static JSONArray toJSONArray(ArrayList subjectcats) {
        JSONArray jsonsubjectcats = new JSONArray();
        Iterator subjectcatsI = subjectcats.iterator();
        while(subjectcatsI.hasNext()) {
            jsonsubjectcats.add(toJSON((Subjectcat)subjectcatsI.next()));
        }
        return jsonsubjectcats;
    }

    public static JSONObject toJSON(ISubjectcatPK subjectcatPK) {
        JSONObject json = null;
        if(subjectcatPK!=null) {
            json = new JSONObject();
            json.put("cat", subjectcatPK.getCat());
        }
        return json;
    }

    public static JSONObject toJSON(ISubjectcat subjectcat) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(subjectcat.getPrimaryKey()));
        json.put("catno", subjectcat.getCatno());
        json.put("description", subjectcat.getDescription());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Subjectcatsearch subjectcatsearch) {
        JSONObject json = new JSONObject();
        if(subjectcatsearch.used()) {
            byte andoroperator = subjectcatsearch.getAndoroperator();
            int maxresults = subjectcatsearch.getMaxresults();
            boolean docount = subjectcatsearch.getDocount();
            Iterator<EntityPK> primarykeysI = subjectcatsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = subjectcatsearch.getFieldsearchers().iterator();
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
            if(subjectcatsearch.getSubjectcat1search()!=null && subjectcatsearch.getSubjectcat1search().used()) {
                kss.put("subjectCat1searcher", JSONSubject.toJSON((Subjectsearch)subjectcatsearch.getSubjectcat1search()));
            }
            if(subjectcatsearch.getSubjectcat2search()!=null && subjectcatsearch.getSubjectcat2search().used()) {
                kss.put("subjectCat2searcher", JSONSubject.toJSON((Subjectsearch)subjectcatsearch.getSubjectcat2search()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Subjectcatsearch toSubjectcatsearch(JSONObject json) {
        Subjectcatsearch subjectcatsearch = new Subjectcatsearch();
        subjectcatsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        subjectcatsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        subjectcatsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            subjectcatsearch.addPrimarykey(SubjectcatPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("cat");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            subjectcatsearch.cat(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("catno");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            subjectcatsearch.catno(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("description");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            subjectcatsearch.description(valuearray, compareoperator, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("subjectCat1searcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Subjectsearch subjectCat1search = JSONSubject.toSubjectsearch((JSONObject)keysearch.get(i));
                subjectcatsearch.subjectCat1(subjectCat1search);
            }
        }
        keysearch = (JSONArray)kss.get("subjectCat2searcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Subjectsearch subjectCat2search = JSONSubject.toSubjectsearch((JSONObject)keysearch.get(i));
                subjectcatsearch.subjectCat2(subjectCat2search);
            }
        }
        return subjectcatsearch;
    }
    
    public static SubjectcatPK toSubjectcatPK(JSONObject json) {
        SubjectcatPK subjectcatPK = null;
        if(json!=null) {
            subjectcatPK = new SubjectcatPK(JSONConversion.getString(json, "cat"));
        }
        return subjectcatPK;
    }

    public static Subjectcat toSubjectcat(JSONObject json) {
        Subjectcat subjectcat = new Subjectcat(toSubjectcatPK((JSONObject)json.get("PK")));
        updateSubjectcat(subjectcat, json);
        return subjectcat;
    }

    public static void updateSubjectcat(ISubjectcat subjectcat, JSONObject json) {
        subjectcat.setCatno(JSONConversion.getint(json, "catno"));
        subjectcat.setDescription(JSONConversion.getString(json, "description"));
    }

    public static Subjectcat initSubjectcat(JSONObject json) {
        Subjectcat subjectcat = new Subjectcat(toSubjectcatPK((JSONObject)json.get("PK")));
        subjectcat.initCatno(JSONConversion.getint(json, "catno"));
        subjectcat.initDescription(JSONConversion.getString(json, "description"));
        return subjectcat;
    }
}

