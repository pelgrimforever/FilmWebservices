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
import film.entity.pk.Art_photoPK;
import film.interfaces.entity.pk.IArt_photoPK;
import film.interfaces.logicentity.IArt_photo;
import film.logicentity.Art_photo;
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
public class JSONArt_photo {
    
    public static JSONArray toJSONArray(ArrayList art_photos) {
        JSONArray jsonart_photos = new JSONArray();
        Iterator art_photosI = art_photos.iterator();
        while(art_photosI.hasNext()) {
            jsonart_photos.add(toJSON((Art_photo)art_photosI.next()));
        }
        return jsonart_photos;
    }

    public static JSONObject toJSON(IArt_photoPK art_photoPK) {
        JSONObject json = null;
        if(art_photoPK!=null) {
            json = new JSONObject();
            json.put("film", art_photoPK.getFilm());
            json.put("photo", art_photoPK.getPhoto());
        }
        return json;
    }

    public static JSONObject toJSON(IArt_photo art_photo) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(art_photo.getPrimaryKey()));
        json.put("art_subgroupPK", JSONArt_subgroup.toJSON(art_photo.getArt_subgroupPK()));
        json.put("art_academyPK", JSONArt_academy.toJSON(art_photo.getArt_academyPK()));
        json.put("art_groupPK", JSONArt_group.toJSON(art_photo.getArt_groupPK()));
        json.put("selection", art_photo.getSelection());
        json.put("width", art_photo.getWidth());
        json.put("height", art_photo.getHeight());
        json.put("comment", art_photo.getComment());
        json.put("seqno", art_photo.getSeqno());
        json.put("archive", art_photo.getArchive());
        json.put("surround", art_photo.getSurround());
        json.put("surrounddir", art_photo.getSurrounddir());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Art_photosearch art_photosearch) {
        JSONObject json = new JSONObject();
        if(art_photosearch.used()) {
            byte andoroperator = art_photosearch.getAndoroperator();
            int maxresults = art_photosearch.getMaxresults();
            boolean docount = art_photosearch.getDocount();
            Iterator<EntityPK> primarykeysI = art_photosearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = art_photosearch.getFieldsearchers().iterator();
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
            if(art_photosearch.getPhotosearch()!=null && art_photosearch.getPhotosearch().used()) {
                kss.put("photosearcher", JSONPhoto.toJSON((Photosearch)art_photosearch.getPhotosearch()));
            }
            if(art_photosearch.getArt_subgroupsearch()!=null && art_photosearch.getArt_subgroupsearch().used()) {
                kss.put("art_subgroupsearcher", JSONArt_subgroup.toJSON((Art_subgroupsearch)art_photosearch.getArt_subgroupsearch()));
            }
            if(art_photosearch.getArt_academysearch()!=null && art_photosearch.getArt_academysearch().used()) {
                kss.put("art_academysearcher", JSONArt_academy.toJSON((Art_academysearch)art_photosearch.getArt_academysearch()));
            }
            if(art_photosearch.getArt_groupsearch()!=null && art_photosearch.getArt_groupsearch().used()) {
                kss.put("art_groupsearcher", JSONArt_group.toJSON((Art_groupsearch)art_photosearch.getArt_groupsearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Art_photosearch toArt_photosearch(JSONObject json) {
        Art_photosearch art_photosearch = new Art_photosearch();
        art_photosearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        art_photosearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        art_photosearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            art_photosearch.addPrimarykey(Art_photoPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("selection");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            art_photosearch.selection(value);
        }
        field = (JSONObject)fss.get("width");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            art_photosearch.width(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("height");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            art_photosearch.height(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("comment");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            art_photosearch.comment(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("seqno");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            art_photosearch.seqno(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("archive");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            art_photosearch.archive(value);
        }
        field = (JSONObject)fss.get("surround");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            art_photosearch.surround(value);
        }
        field = (JSONObject)fss.get("surrounddir");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            art_photosearch.surrounddir(valuearray, compareoperator, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("photosearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Photosearch photosearch = JSONPhoto.toPhotosearch((JSONObject)keysearch.get(i));
                art_photosearch.photo(photosearch);
            }
        }
        keysearch = (JSONArray)kss.get("art_subgroupsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Art_subgroupsearch art_subgroupsearch = JSONArt_subgroup.toArt_subgroupsearch((JSONObject)keysearch.get(i));
                art_photosearch.art_subgroup(art_subgroupsearch);
            }
        }
        keysearch = (JSONArray)kss.get("art_academysearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Art_academysearch art_academysearch = JSONArt_academy.toArt_academysearch((JSONObject)keysearch.get(i));
                art_photosearch.art_academy(art_academysearch);
            }
        }
        keysearch = (JSONArray)kss.get("art_groupsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Art_groupsearch art_groupsearch = JSONArt_group.toArt_groupsearch((JSONObject)keysearch.get(i));
                art_photosearch.art_group(art_groupsearch);
            }
        }
        return art_photosearch;
    }
    
    public static Art_photoPK toArt_photoPK(JSONObject json) {
        Art_photoPK art_photoPK = null;
        if(json!=null) {
            art_photoPK = new Art_photoPK(JSONConversion.getString(json, "film"), JSONConversion.getint(json, "photo"));
        }
        return art_photoPK;
    }

    public static Art_photo toArt_photo(JSONObject json) {
        Art_photo art_photo = new Art_photo(toArt_photoPK((JSONObject)json.get("PK")));
        updateArt_photo(art_photo, json);
        return art_photo;
    }

    public static void updateArt_photo(IArt_photo art_photo, JSONObject json) {
        art_photo.setArt_subgroupPK(JSONArt_subgroup.toArt_subgroupPK((JSONObject)json.get("art_subgroupPK")));
        art_photo.setArt_academyPK(JSONArt_academy.toArt_academyPK((JSONObject)json.get("art_academyPK")));
        art_photo.setArt_groupPK(JSONArt_group.toArt_groupPK((JSONObject)json.get("art_groupPK")));
        art_photo.setSelection(JSONConversion.getboolean(json, "selection"));
        art_photo.setWidth(JSONConversion.getint(json, "width"));
        art_photo.setHeight(JSONConversion.getint(json, "height"));
        art_photo.setComment(JSONConversion.getString(json, "comment"));
        art_photo.setSeqno(JSONConversion.getint(json, "seqno"));
        art_photo.setArchive(JSONConversion.getboolean(json, "archive"));
        art_photo.setSurround(JSONConversion.getboolean(json, "surround"));
        art_photo.setSurrounddir(JSONConversion.getString(json, "surrounddir"));
    }

    public static Art_photo initArt_photo(JSONObject json) {
        Art_photo art_photo = new Art_photo(toArt_photoPK((JSONObject)json.get("PK")));
        art_photo.initArt_subgroupPK(JSONArt_subgroup.toArt_subgroupPK((JSONObject)json.get("art_subgroupPK")));
        art_photo.initArt_academyPK(JSONArt_academy.toArt_academyPK((JSONObject)json.get("art_academyPK")));
        art_photo.initArt_groupPK(JSONArt_group.toArt_groupPK((JSONObject)json.get("art_groupPK")));
        art_photo.initSelection(JSONConversion.getboolean(json, "selection"));
        art_photo.initWidth(JSONConversion.getint(json, "width"));
        art_photo.initHeight(JSONConversion.getint(json, "height"));
        art_photo.initComment(JSONConversion.getString(json, "comment"));
        art_photo.initSeqno(JSONConversion.getint(json, "seqno"));
        art_photo.initArchive(JSONConversion.getboolean(json, "archive"));
        art_photo.initSurround(JSONConversion.getboolean(json, "surround"));
        art_photo.initSurrounddir(JSONConversion.getString(json, "surrounddir"));
        return art_photo;
    }
}

