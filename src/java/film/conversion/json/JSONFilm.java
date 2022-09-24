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
import film.entity.pk.FilmPK;
import film.interfaces.entity.pk.IFilmPK;
import film.interfaces.logicentity.IFilm;
import film.logicentity.Film;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONFilm {
    
    public static JSONArray toJSONArray(ArrayList films) {
        JSONArray jsonfilms = new JSONArray();
        Iterator filmsI = films.iterator();
        while(filmsI.hasNext()) {
            jsonfilms.add(toJSON((Film)filmsI.next()));
        }
        return jsonfilms;
    }

    public static JSONObject toJSON(IFilmPK filmPK) {
        JSONObject json = null;
        if(filmPK!=null) {
            json = new JSONObject();
            json.put("id", filmPK.getId());
        }
        return json;
    }

    public static JSONObject toJSON(IFilm film) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(film.getPrimaryKey()));
        json.put("filmtypePK", JSONFilmtype.toJSON(film.getFilmtypePK()));
        json.put("iso", film.getIso());
        if(film.getStartdate()!=null) {
	        json.put("startdate", film.getStartdate().getTime());
        }
        if(film.getEnddate()!=null) {
	        json.put("enddate", film.getEnddate().getTime());
        }
        json.put("owner", film.getOwner());
        json.put("cd", film.getCd());
        json.put("public", film.getPublic());
        json.put("backup", film.getBackup());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Filmsearch filmsearch) {
        JSONObject json = new JSONObject();
        if(filmsearch.used()) {
            byte andoroperator = filmsearch.getAndoroperator();
            int maxresults = filmsearch.getMaxresults();
            boolean docount = filmsearch.getDocount();
            Iterator<EntityPK> primarykeysI = filmsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = filmsearch.getFieldsearchers().iterator();
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
            if(filmsearch.getFilmtypesearch()!=null && filmsearch.getFilmtypesearch().used()) {
                kss.put("filmtypesearcher", JSONFilmtype.toJSON((Filmtypesearch)filmsearch.getFilmtypesearch()));
            }
            if(filmsearch.getFilmsubjectssearch()!=null && filmsearch.getFilmsubjectssearch().used()) {
                kss.put("filmsubjectssearcher", JSONFilmsubjects.toJSON((Filmsubjectssearch)filmsearch.getFilmsubjectssearch()));
            }
            if(filmsearch.getRelSubjectsearch()!=null && filmsearch.getRelSubjectsearch().used()) {
                kss.put("subjectsearcher", JSONFilmsubjects.toJSON((Filmsubjectssearch)filmsearch.getRelSubjectsearch()));
            }
            if(filmsearch.getPhotosearch()!=null && filmsearch.getPhotosearch().used()) {
                kss.put("photosearcher", JSONPhoto.toJSON((Photosearch)filmsearch.getPhotosearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Filmsearch toFilmsearch(JSONObject json) {
        Filmsearch filmsearch = new Filmsearch();
        filmsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        filmsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        filmsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            filmsearch.addPrimarykey(FilmPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            filmsearch.id(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("iso");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            filmsearch.iso(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("startdate");
        if(field!=null) {
            Date[] valuearray = JSONConversion.getDatevalues(field);
            byte[] operators = JSONConversion.getDateoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            filmsearch.startdate(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("enddate");
        if(field!=null) {
            Date[] valuearray = JSONConversion.getDatevalues(field);
            byte[] operators = JSONConversion.getDateoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            filmsearch.enddate(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("owner");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            filmsearch.owner(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("cd");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            filmsearch.cd(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("public");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            filmsearch.publicf_(value);
        }
        field = (JSONObject)fss.get("backup");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            filmsearch.backup(value);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("filmtypesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Filmtypesearch filmtypesearch = JSONFilmtype.toFilmtypesearch((JSONObject)keysearch.get(i));
                filmsearch.filmtype(filmtypesearch);
            }
        }
        keysearch = (JSONArray)kss.get("filmsubjectssearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Filmsubjectssearch filmsubjectssearch = JSONFilmsubjects.toFilmsubjectssearch((JSONObject)keysearch.get(i));
                filmsearch.filmsubjects(filmsubjectssearch);
            }
        }
        keysearch = (JSONArray)kss.get("subjectsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Subjectsearch subjectsearch = JSONSubject.toSubjectsearch((JSONObject)keysearch.get(i));
                filmsearch.relsubject(subjectsearch);
            }
        }
        keysearch = (JSONArray)kss.get("photosearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Photosearch photosearch = JSONPhoto.toPhotosearch((JSONObject)keysearch.get(i));
                filmsearch.photo(photosearch);
            }
        }
        return filmsearch;
    }
    
    public static FilmPK toFilmPK(JSONObject json) {
        FilmPK filmPK = null;
        if(json!=null) {
            filmPK = new FilmPK(JSONConversion.getString(json, "id"));
        }
        return filmPK;
    }

    public static Film toFilm(JSONObject json) {
        Film film = new Film(toFilmPK((JSONObject)json.get("PK")));
        updateFilm(film, json);
        return film;
    }

    public static void updateFilm(IFilm film, JSONObject json) {
        film.setFilmtypePK(JSONFilmtype.toFilmtypePK((JSONObject)json.get("filmtypePK")));
        film.setIso(JSONConversion.getString(json, "iso"));
        film.setStartdate(JSONConversion.getDate(json, "startdate"));
        film.setEnddate(JSONConversion.getDate(json, "enddate"));
        film.setOwner(JSONConversion.getString(json, "owner"));
        film.setCd(JSONConversion.getString(json, "cd"));
        film.setPublic(JSONConversion.getboolean(json, "public"));
        film.setBackup(JSONConversion.getboolean(json, "backup"));
    }

    public static Film initFilm(JSONObject json) {
        Film film = new Film(toFilmPK((JSONObject)json.get("PK")));
        film.initFilmtypePK(JSONFilmtype.toFilmtypePK((JSONObject)json.get("filmtypePK")));
        film.initIso(JSONConversion.getString(json, "iso"));
        film.initStartdate(JSONConversion.getDate(json, "startdate"));
        film.initEnddate(JSONConversion.getDate(json, "enddate"));
        film.initOwner(JSONConversion.getString(json, "owner"));
        film.initCd(JSONConversion.getString(json, "cd"));
        film.initPublic(JSONConversion.getboolean(json, "public"));
        film.initBackup(JSONConversion.getboolean(json, "backup"));
        return film;
    }
}

