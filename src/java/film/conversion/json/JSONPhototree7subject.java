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
import film.entity.pk.Phototree7subjectPK;
import film.interfaces.entity.pk.IPhototree7subjectPK;
import film.interfaces.logicentity.IPhototree7subject;
import film.logicentity.Phototree7subject;
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
public class JSONPhototree7subject {
    
    public static JSONArray toJSONArray(ArrayList phototree7subjects) {
        JSONArray jsonphototree7subjects = new JSONArray();
        Iterator phototree7subjectsI = phototree7subjects.iterator();
        while(phototree7subjectsI.hasNext()) {
            jsonphototree7subjects.add(toJSON((Phototree7subject)phototree7subjectsI.next()));
        }
        return jsonphototree7subjects;
    }

    public static JSONObject toJSON(IPhototree7subjectPK phototree7subjectPK) {
        JSONObject json = null;
        if(phototree7subjectPK!=null) {
            json = new JSONObject();
            json.put("film", phototree7subjectPK.getFilm());
            json.put("id", phototree7subjectPK.getId());
            json.put("subjectid", String.valueOf(phototree7subjectPK.getSubjectid()));
        }
        return json;
    }

    public static JSONObject toJSON(IPhototree7subject phototree7subject) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(phototree7subject.getPrimaryKey()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Phototree7subjectsearch phototree7subjectsearch) {
        JSONObject json = new JSONObject();
        if(phototree7subjectsearch.used()) {
            byte andoroperator = phototree7subjectsearch.getAndoroperator();
            int maxresults = phototree7subjectsearch.getMaxresults();
            boolean docount = phototree7subjectsearch.getDocount();
            Iterator<EntityPK> primarykeysI = phototree7subjectsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = phototree7subjectsearch.getFieldsearchers().iterator();
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
            if(phototree7subjectsearch.getTree7subjectsearch()!=null && phototree7subjectsearch.getTree7subjectsearch().used()) {
                kss.put("tree7subjectsearcher", JSONTree7subject.toJSON((Tree7subjectsearch)phototree7subjectsearch.getTree7subjectsearch()));
            }
            if(phototree7subjectsearch.getPhotosearch()!=null && phototree7subjectsearch.getPhotosearch().used()) {
                kss.put("photosearcher", JSONPhoto.toJSON((Photosearch)phototree7subjectsearch.getPhotosearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Phototree7subjectsearch toPhototree7subjectsearch(JSONObject json) {
        Phototree7subjectsearch phototree7subjectsearch = new Phototree7subjectsearch();
        phototree7subjectsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        phototree7subjectsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        phototree7subjectsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            phototree7subjectsearch.addPrimarykey(Phototree7subjectPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("tree7subjectsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Tree7subjectsearch tree7subjectsearch = JSONTree7subject.toTree7subjectsearch((JSONObject)keysearch.get(i));
                phototree7subjectsearch.tree7subject(tree7subjectsearch);
            }
        }
        keysearch = (JSONArray)kss.get("photosearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Photosearch photosearch = JSONPhoto.toPhotosearch((JSONObject)keysearch.get(i));
                phototree7subjectsearch.photo(photosearch);
            }
        }
        return phototree7subjectsearch;
    }
    
    public static Phototree7subjectPK toPhototree7subjectPK(JSONObject json) {
        Phototree7subjectPK phototree7subjectPK = null;
        if(json!=null) {
            phototree7subjectPK = new Phototree7subjectPK(JSONConversion.getString(json, "film"), JSONConversion.getint(json, "id"), JSONConversion.getlong(json, "subjectid"));
        }
        return phototree7subjectPK;
    }

    public static Phototree7subject toPhototree7subject(JSONObject json) {
        Phototree7subject phototree7subject = new Phototree7subject(toPhototree7subjectPK((JSONObject)json.get("PK")));
        updatePhototree7subject(phototree7subject, json);
        return phototree7subject;
    }

    public static void updatePhototree7subject(IPhototree7subject phototree7subject, JSONObject json) {
    }

    public static Phototree7subject initPhototree7subject(JSONObject json) {
        Phototree7subject phototree7subject = new Phototree7subject(toPhototree7subjectPK((JSONObject)json.get("PK")));
        return phototree7subject;
    }
}

