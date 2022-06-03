/*
 * JSONPhoto.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 15.3.2022 18:7
 *
 */
 
package film.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import film.entity.pk.PhotoPK;
import film.interfaces.entity.pk.IPhotoPK;
import film.interfaces.logicentity.IPhoto;
import film.logicentity.Photo;
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
public class JSONPhoto {
    
    public static JSONArray toJSONArray(ArrayList photos) {
        JSONArray jsonphotos = new JSONArray();
        Iterator photosI = photos.iterator();
        while(photosI.hasNext()) {
            jsonphotos.add(toJSON((Photo)photosI.next()));
        }
        return jsonphotos;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IPhotoPK photoPK) {
        JSONObject json = null;
        if(photoPK!=null) {
            json = new JSONObject();
            json.put("film", photoPK.getFilm());
            json.put("id", photoPK.getId());
        }
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(IPhoto photo) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(photo.getPrimaryKey()));
        json.put("routePK", JSONRoute.toJSON(photo.getRoutePK()));
        json.put("creatorPK", JSONCreator.toJSON(photo.getCreatorPK()));
        json.put("format", photo.getFormat());
        json.put("description", photo.getDescription());
        if(photo.getPhotodate()!=null) {
	        json.put("photodate", photo.getPhotodate().getTime());
        }
        if(photo.getPhototime()!=null) {
	        json.put("phototime", photo.getPhototime().getTime());
        }
        json.put("public", photo.getPublic());
        json.put("composition", photo.getComposition());
        json.put("rotation", photo.getRotation());
        json.put("backup", photo.getBackup());
        json.put("imagebackup", photo.getImagebackup());
        if(photo.getLocation()!=null) {
            json.put("location", GISConversion.toJSON(photo.getLocation()));
        }
        json.put("exactlocation", photo.getExactlocation());
        json.put("locationradius", photo.getLocationradius());
        json.put("reversegeocode", photo.getReversegeocode());
        json.put("streetnumber", photo.getStreetnumber());
        json.put("formattedaddress", photo.getFormattedaddress());
//Custom code, do not change this line
        json.put("imagebase64", photo.getImagebase64());
//Custom code, do not change this line
        return json;
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static JSONObject toJSON(Photosearch photosearch) {
        JSONObject json = new JSONObject();
        if(photosearch.used()) {
            byte andoroperator = photosearch.getAndoroperator();
            int maxresults = photosearch.getMaxresults();
            boolean docount = photosearch.getDocount();
            Iterator<EntityPK> primarykeysI = photosearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = photosearch.getFieldsearchers().iterator();
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
            if(photosearch.getRoutesearch()!=null && photosearch.getRoutesearch().used()) {
                kss.put("routesearcher", JSONRoute.toJSON((Routesearch)photosearch.getRoutesearch()));
            }
            if(photosearch.getCreatorsearch()!=null && photosearch.getCreatorsearch().used()) {
                kss.put("creatorsearcher", JSONCreator.toJSON((Creatorsearch)photosearch.getCreatorsearch()));
            }
            if(photosearch.getFilmsearch()!=null && photosearch.getFilmsearch().used()) {
                kss.put("filmsearcher", JSONFilm.toJSON((Filmsearch)photosearch.getFilmsearch()));
            }
            if(photosearch.getPhototree7subjectsearch()!=null && photosearch.getPhototree7subjectsearch().used()) {
                kss.put("phototree7subjectsearcher", JSONPhototree7subject.toJSON((Phototree7subjectsearch)photosearch.getPhototree7subjectsearch()));
            }
            if(photosearch.getRelTree7subjectsearch()!=null && photosearch.getRelTree7subjectsearch().used()) {
                kss.put("tree7subjectsearcher", JSONPhototree7subject.toJSON((Phototree7subjectsearch)photosearch.getRelTree7subjectsearch()));
            }
            if(photosearch.getArt_photosearch()!=null && photosearch.getArt_photosearch().used()) {
                kss.put("art_photosearcher", JSONArt_photo.toJSON((Art_photosearch)photosearch.getArt_photosearch()));
            }
            if(photosearch.getPhotosubjectssearch()!=null && photosearch.getPhotosubjectssearch().used()) {
                kss.put("photosubjectssearcher", JSONPhotosubjects.toJSON((Photosubjectssearch)photosearch.getPhotosubjectssearch()));
            }
            if(photosearch.getRelSubjectsearch()!=null && photosearch.getRelSubjectsearch().used()) {
                kss.put("subjectsearcher", JSONPhotosubjects.toJSON((Photosubjectssearch)photosearch.getRelSubjectsearch()));
            }
            if(photosearch.getPhototagssearch()!=null && photosearch.getPhototagssearch().used()) {
                kss.put("phototagssearcher", JSONPhototags.toJSON((Phototagssearch)photosearch.getPhototagssearch()));
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
    public static Photosearch toPhotosearch(JSONObject json) {
        Photosearch photosearch = new Photosearch();
        photosearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        photosearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        photosearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            photosearch.addPrimarykey(PhotoPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            photosearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("format");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            photosearch.format(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("description");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            photosearch.description(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("photodate");
        if(field!=null) {
            Date[] valuearray = JSONConversion.getDatevalues(field);
            byte[] operators = JSONConversion.getDateoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            photosearch.photodate(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("phototime");
        if(field!=null) {
            Time[] valuearray = JSONConversion.getTimevalues(field);
            byte[] operators = JSONConversion.getTimeoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            photosearch.phototime(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("public");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            photosearch.publicf_(value);
        }
        field = (JSONObject)fss.get("composition");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            photosearch.composition(value);
        }
        field = (JSONObject)fss.get("rotation");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            photosearch.rotation(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("backup");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            photosearch.backup(value);
        }
        field = (JSONObject)fss.get("imagebackup");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            photosearch.imagebackup(value);
        }
        field = (JSONObject)fss.get("exactlocation");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            photosearch.exactlocation(value);
        }
        field = (JSONObject)fss.get("locationradius");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            photosearch.locationradius(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("reversegeocode");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            photosearch.reversegeocode(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("streetnumber");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            photosearch.streetnumber(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("formattedaddress");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            photosearch.formattedaddress(valuearray, compareoperator, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("routesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Routesearch routesearch = JSONRoute.toRoutesearch((JSONObject)keysearch.get(i));
                photosearch.route(routesearch);
            }
        }
        keysearch = (JSONArray)kss.get("creatorsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Creatorsearch creatorsearch = JSONCreator.toCreatorsearch((JSONObject)keysearch.get(i));
                photosearch.creator(creatorsearch);
            }
        }
        keysearch = (JSONArray)kss.get("filmsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Filmsearch filmsearch = JSONFilm.toFilmsearch((JSONObject)keysearch.get(i));
                photosearch.film(filmsearch);
            }
        }
        keysearch = (JSONArray)kss.get("phototree7subjectsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Phototree7subjectsearch phototree7subjectsearch = JSONPhototree7subject.toPhototree7subjectsearch((JSONObject)keysearch.get(i));
                photosearch.phototree7subject(phototree7subjectsearch);
            }
        }
        keysearch = (JSONArray)kss.get("tree7subjectsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Tree7subjectsearch tree7subjectsearch = JSONTree7subject.toTree7subjectsearch((JSONObject)keysearch.get(i));
                photosearch.reltree7subject(tree7subjectsearch);
            }
        }
        keysearch = (JSONArray)kss.get("art_photosearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Art_photosearch art_photosearch = JSONArt_photo.toArt_photosearch((JSONObject)keysearch.get(i));
                photosearch.art_photo(art_photosearch);
            }
        }
        keysearch = (JSONArray)kss.get("photosubjectssearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Photosubjectssearch photosubjectssearch = JSONPhotosubjects.toPhotosubjectssearch((JSONObject)keysearch.get(i));
                photosearch.photosubjects(photosubjectssearch);
            }
        }
        keysearch = (JSONArray)kss.get("subjectsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Subjectsearch subjectsearch = JSONSubject.toSubjectsearch((JSONObject)keysearch.get(i));
                photosearch.relsubject(subjectsearch);
            }
        }
        keysearch = (JSONArray)kss.get("phototagssearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Phototagssearch phototagssearch = JSONPhototags.toPhototagssearch((JSONObject)keysearch.get(i));
                photosearch.phototags(phototagssearch);
            }
        }
        return photosearch;
    }
    
    public static PhotoPK toPhotoPK(JSONObject json) {
        PhotoPK photoPK = null;
        if(json!=null) {
            photoPK = new PhotoPK(JSONConversion.getString(json, "film"), JSONConversion.getint(json, "id"));
        }
        return photoPK;
    }

    public static Photo toPhoto(JSONObject json) {
        Photo photo = new Photo(toPhotoPK((JSONObject)json.get("PK")));
        updatePhoto(photo, json);
        return photo;
    }

    public static void updatePhoto(IPhoto photo, JSONObject json) {
        photo.setRoutePK(JSONRoute.toRoutePK((JSONObject)json.get("routePK")));
        photo.setCreatorPK(JSONCreator.toCreatorPK((JSONObject)json.get("creatorPK")));
        photo.setFormat(JSONConversion.getString(json, "format"));
        photo.setDescription(JSONConversion.getString(json, "description"));
        photo.setPhotodate(JSONConversion.getDate(json, "photodate"));
        photo.setPhototime(JSONConversion.getTime(json, "phototime"));
        photo.setPublic(JSONConversion.getboolean(json, "public"));
        photo.setComposition(JSONConversion.getboolean(json, "composition"));
        photo.setRotation(JSONConversion.getfloat(json, "rotation"));
        photo.setBackup(JSONConversion.getboolean(json, "backup"));
        photo.setImagebackup(JSONConversion.getboolean(json, "imagebackup"));
        photo.setLocation(GISConversion.topiShape((JSONObject)json.get("location")));
        photo.setExactlocation(JSONConversion.getboolean(json, "exactlocation"));
        photo.setLocationradius(JSONConversion.getdouble(json, "locationradius"));
        photo.setReversegeocode(JSONConversion.getString(json, "reversegeocode"));
        photo.setStreetnumber(JSONConversion.getString(json, "streetnumber"));
        photo.setFormattedaddress(JSONConversion.getString(json, "formattedaddress"));
    }

    public static Photo initPhoto(JSONObject json) {
        Photo photo = new Photo(toPhotoPK((JSONObject)json.get("PK")));
        photo.initRoutePK(JSONRoute.toRoutePK((JSONObject)json.get("routePK")));
        photo.initCreatorPK(JSONCreator.toCreatorPK((JSONObject)json.get("creatorPK")));
        photo.initFormat(JSONConversion.getString(json, "format"));
        photo.initDescription(JSONConversion.getString(json, "description"));
        photo.initPhotodate(JSONConversion.getDate(json, "photodate"));
        photo.initPhototime(JSONConversion.getTime(json, "phototime"));
        photo.initPublic(JSONConversion.getboolean(json, "public"));
        photo.initComposition(JSONConversion.getboolean(json, "composition"));
        photo.initRotation(JSONConversion.getfloat(json, "rotation"));
        photo.initBackup(JSONConversion.getboolean(json, "backup"));
        photo.initImagebackup(JSONConversion.getboolean(json, "imagebackup"));
        photo.initLocation(GISConversion.topiShape((JSONObject)json.get("location")));
        photo.initExactlocation(JSONConversion.getboolean(json, "exactlocation"));
        photo.initLocationradius(JSONConversion.getdouble(json, "locationradius"));
        photo.initReversegeocode(JSONConversion.getString(json, "reversegeocode"));
        photo.initStreetnumber(JSONConversion.getString(json, "streetnumber"));
        photo.initFormattedaddress(JSONConversion.getString(json, "formattedaddress"));
        return photo;
    }
}

