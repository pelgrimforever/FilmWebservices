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
import film.entity.pk.PhototagsPK;
import film.interfaces.entity.pk.IPhototagsPK;
import film.interfaces.logicentity.IPhototags;
import film.logicentity.Phototags;
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
public class JSONPhototags {
    
    public static JSONArray toJSONArray(ArrayList phototagss) {
        JSONArray jsonphototagss = new JSONArray();
        Iterator phototagssI = phototagss.iterator();
        while(phototagssI.hasNext()) {
            jsonphototagss.add(toJSON((Phototags)phototagssI.next()));
        }
        return jsonphototagss;
    }

    public static JSONObject toJSON(IPhototagsPK phototagsPK) {
        JSONObject json = null;
        if(phototagsPK!=null) {
            json = new JSONObject();
            json.put("film", phototagsPK.getFilm());
            json.put("id", phototagsPK.getId());
            json.put("tag", phototagsPK.getTag());
        }
        return json;
    }

    public static JSONObject toJSON(IPhototags phototags) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(phototags.getPrimaryKey()));
        json.put("tagformat", phototags.getTagformat());
        json.put("tagvalue", phototags.getTagvalue());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Phototagssearch phototagssearch) {
        JSONObject json = new JSONObject();
        if(phototagssearch.used()) {
            byte andoroperator = phototagssearch.getAndoroperator();
            int maxresults = phototagssearch.getMaxresults();
            boolean docount = phototagssearch.getDocount();
            Iterator<EntityPK> primarykeysI = phototagssearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = phototagssearch.getFieldsearchers().iterator();
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
            if(phototagssearch.getPhotosearch()!=null && phototagssearch.getPhotosearch().used()) {
                kss.put("photosearcher", JSONPhoto.toJSON((Photosearch)phototagssearch.getPhotosearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Phototagssearch toPhototagssearch(JSONObject json) {
        Phototagssearch phototagssearch = new Phototagssearch();
        phototagssearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        phototagssearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        phototagssearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            phototagssearch.addPrimarykey(PhototagsPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("tag");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            phototagssearch.tag(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("tagformat");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            phototagssearch.tagformat(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("tagvalue");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            phototagssearch.tagvalue(valuearray, compareoperator, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("photosearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Photosearch photosearch = JSONPhoto.toPhotosearch((JSONObject)keysearch.get(i));
                phototagssearch.photo(photosearch);
            }
        }
        return phototagssearch;
    }
    
    public static PhototagsPK toPhototagsPK(JSONObject json) {
        PhototagsPK phototagsPK = null;
        if(json!=null) {
            phototagsPK = new PhototagsPK(JSONConversion.getString(json, "film"), JSONConversion.getint(json, "id"), JSONConversion.getString(json, "tag"));
        }
        return phototagsPK;
    }

    public static Phototags toPhototags(JSONObject json) {
        Phototags phototags = new Phototags(toPhototagsPK((JSONObject)json.get("PK")));
        updatePhototags(phototags, json);
        return phototags;
    }

    public static void updatePhototags(IPhototags phototags, JSONObject json) {
        phototags.setTagformat(JSONConversion.getString(json, "tagformat"));
        phototags.setTagvalue(JSONConversion.getString(json, "tagvalue"));
    }

    public static Phototags initPhototags(JSONObject json) {
        Phototags phototags = new Phototags(toPhototagsPK((JSONObject)json.get("PK")));
        phototags.initTagformat(JSONConversion.getString(json, "tagformat"));
        phototags.initTagvalue(JSONConversion.getString(json, "tagvalue"));
        return phototags;
    }
}

