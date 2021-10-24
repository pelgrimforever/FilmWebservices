/*
 * JSONUploadsession.java
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
import film.entity.pk.UploadsessionPK;
import film.interfaces.entity.pk.IUploadsessionPK;
import film.interfaces.logicentity.IUploadsession;
import film.logicentity.Uploadsession;
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
public class JSONUploadsession {
    
    public static JSONArray toJSONArray(ArrayList uploadsessions) {
        JSONArray jsonuploadsessions = new JSONArray();
        Iterator uploadsessionsI = uploadsessions.iterator();
        while(uploadsessionsI.hasNext()) {
            jsonuploadsessions.add(toJSON((Uploadsession)uploadsessionsI.next()));
        }
        return jsonuploadsessions;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IUploadsessionPK uploadsessionPK) {
        JSONObject json = null;
        if(uploadsessionPK!=null) {
            json = new JSONObject();
            json.put("filename", uploadsessionPK.getFilename());
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IUploadsession uploadsession) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(uploadsession.getPrimaryKey()));
        json.put("creatorPK", JSONCreator.toJSON(uploadsession.getCreatorPK()));
        json.put("upload", uploadsession.getUpload());
        json.put("rotation", uploadsession.getRotation());
        json.put("filmgroupid", uploadsession.getFilmgroupid());
        json.put("photosubjects", uploadsession.getPhotosubjects());
        json.put("description", uploadsession.getDescription());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Uploadsessionsearch uploadsessionsearch) {
        JSONObject json = new JSONObject();
        if(uploadsessionsearch.used()) {
            byte andoroperator = uploadsessionsearch.getAndoroperator();
            int maxresults = uploadsessionsearch.getMaxresults();
            boolean docount = uploadsessionsearch.getDocount();
            Iterator<EntityPK> primarykeysI = uploadsessionsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = uploadsessionsearch.getFieldsearchers().iterator();
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
            if(uploadsessionsearch.getCreatorsearch()!=null && uploadsessionsearch.getCreatorsearch().used()) {
                kss.put("creatorsearcher", JSONCreator.toJSON((Creatorsearch)uploadsessionsearch.getCreatorsearch()));
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
    public static Uploadsessionsearch toUploadsessionsearch(JSONObject json) {
        Uploadsessionsearch uploadsessionsearch = new Uploadsessionsearch();
        uploadsessionsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        uploadsessionsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        uploadsessionsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            uploadsessionsearch.addPrimarykey(UploadsessionPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("filename");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            uploadsessionsearch.filename(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("upload");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            uploadsessionsearch.upload(value);
        }
        field = (JSONObject)fss.get("rotation");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            uploadsessionsearch.rotation(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("filmgroupid");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            uploadsessionsearch.filmgroupid(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("photosubjects");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            uploadsessionsearch.photosubjects(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("description");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            uploadsessionsearch.description(valuearray, compareoperator, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("creatorsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Creatorsearch creatorsearch = JSONCreator.toCreatorsearch((JSONObject)keysearch.get(i));
                uploadsessionsearch.creator(creatorsearch);
            }
        }
        return uploadsessionsearch;
    }
    
    public static UploadsessionPK toUploadsessionPK(JSONObject json) {
        UploadsessionPK uploadsessionPK = null;
        if(json!=null) {
            uploadsessionPK = new UploadsessionPK(JSONConversion.getString(json, "filename"));
        }
        return uploadsessionPK;
    }

    public static Uploadsession toUploadsession(JSONObject json) {
        Uploadsession uploadsession = new Uploadsession(toUploadsessionPK((JSONObject)json.get("PK")));
        updateUploadsession(uploadsession, json);
        return uploadsession;
    }

    public static void updateUploadsession(IUploadsession uploadsession, JSONObject json) {
        uploadsession.setCreatorPK(JSONCreator.toCreatorPK((JSONObject)json.get("creatorPK")));
        uploadsession.setUpload(JSONConversion.getboolean(json, "upload"));
        uploadsession.setRotation(JSONConversion.getfloat(json, "rotation"));
        uploadsession.setFilmgroupid(JSONConversion.getString(json, "filmgroupid"));
        uploadsession.setPhotosubjects(JSONConversion.getString(json, "photosubjects"));
        uploadsession.setDescription(JSONConversion.getString(json, "description"));
    }

    public static Uploadsession initUploadsession(JSONObject json) {
        Uploadsession uploadsession = new Uploadsession(toUploadsessionPK((JSONObject)json.get("PK")));
        uploadsession.initCreatorPK(JSONCreator.toCreatorPK((JSONObject)json.get("creatorPK")));
        uploadsession.initUpload(JSONConversion.getboolean(json, "upload"));
        uploadsession.initRotation(JSONConversion.getfloat(json, "rotation"));
        uploadsession.initFilmgroupid(JSONConversion.getString(json, "filmgroupid"));
        uploadsession.initPhotosubjects(JSONConversion.getString(json, "photosubjects"));
        uploadsession.initDescription(JSONConversion.getString(json, "description"));
        return uploadsession;
    }
}

