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
import film.entity.pk.PhotosubjectsPK;
import film.interfaces.entity.pk.IPhotosubjectsPK;
import film.interfaces.logicentity.IPhotosubjects;
import film.logicentity.Photosubjects;
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
public class JSONPhotosubjects {
    
    public static JSONArray toJSONArray(ArrayList photosubjectss) {
        JSONArray jsonphotosubjectss = new JSONArray();
        Iterator photosubjectssI = photosubjectss.iterator();
        while(photosubjectssI.hasNext()) {
            jsonphotosubjectss.add(toJSON((Photosubjects)photosubjectssI.next()));
        }
        return jsonphotosubjectss;
    }

    public static JSONObject toJSON(IPhotosubjectsPK photosubjectsPK) {
        JSONObject json = null;
        if(photosubjectsPK!=null) {
            json = new JSONObject();
            json.put("film", photosubjectsPK.getFilm());
            json.put("id", photosubjectsPK.getId());
            json.put("cat1", photosubjectsPK.getCat1());
            json.put("cat2", photosubjectsPK.getCat2());
            json.put("subject", photosubjectsPK.getSubject());
        }
        return json;
    }

    public static JSONObject toJSON(IPhotosubjects photosubjects) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(photosubjects.getPrimaryKey()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Photosubjectssearch photosubjectssearch) {
        JSONObject json = new JSONObject();
        if(photosubjectssearch.used()) {
            byte andoroperator = photosubjectssearch.getAndoroperator();
            int maxresults = photosubjectssearch.getMaxresults();
            boolean docount = photosubjectssearch.getDocount();
            Iterator<EntityPK> primarykeysI = photosubjectssearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = photosubjectssearch.getFieldsearchers().iterator();
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
            if(photosubjectssearch.getPhotosearch()!=null && photosubjectssearch.getPhotosearch().used()) {
                kss.put("photosearcher", JSONPhoto.toJSON((Photosearch)photosubjectssearch.getPhotosearch()));
            }
            if(photosubjectssearch.getSubjectsearch()!=null && photosubjectssearch.getSubjectsearch().used()) {
                kss.put("subjectsearcher", JSONSubject.toJSON((Subjectsearch)photosubjectssearch.getSubjectsearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Photosubjectssearch toPhotosubjectssearch(JSONObject json) {
        Photosubjectssearch photosubjectssearch = new Photosubjectssearch();
        photosubjectssearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        photosubjectssearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        photosubjectssearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            photosubjectssearch.addPrimarykey(PhotosubjectsPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("photosearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Photosearch photosearch = JSONPhoto.toPhotosearch((JSONObject)keysearch.get(i));
                photosubjectssearch.photo(photosearch);
            }
        }
        keysearch = (JSONArray)kss.get("subjectsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Subjectsearch subjectsearch = JSONSubject.toSubjectsearch((JSONObject)keysearch.get(i));
                photosubjectssearch.subject(subjectsearch);
            }
        }
        return photosubjectssearch;
    }
    
    public static PhotosubjectsPK toPhotosubjectsPK(JSONObject json) {
        PhotosubjectsPK photosubjectsPK = null;
        if(json!=null) {
            photosubjectsPK = new PhotosubjectsPK(JSONConversion.getString(json, "film"), JSONConversion.getint(json, "id"), JSONConversion.getString(json, "cat1"), JSONConversion.getString(json, "cat2"), JSONConversion.getint(json, "subject"));
        }
        return photosubjectsPK;
    }

    public static Photosubjects toPhotosubjects(JSONObject json) {
        Photosubjects photosubjects = new Photosubjects(toPhotosubjectsPK((JSONObject)json.get("PK")));
        updatePhotosubjects(photosubjects, json);
        return photosubjects;
    }

    public static void updatePhotosubjects(IPhotosubjects photosubjects, JSONObject json) {
    }

    public static Photosubjects initPhotosubjects(JSONObject json) {
        Photosubjects photosubjects = new Photosubjects(toPhotosubjectsPK((JSONObject)json.get("PK")));
        return photosubjects;
    }
}

