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
import film.entity.pk.FilmsubjectsPK;
import film.interfaces.entity.pk.IFilmsubjectsPK;
import film.interfaces.logicentity.IFilmsubjects;
import film.logicentity.Filmsubjects;
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
public class JSONFilmsubjects {
    
    public static JSONArray toJSONArray(ArrayList filmsubjectss) {
        JSONArray jsonfilmsubjectss = new JSONArray();
        Iterator filmsubjectssI = filmsubjectss.iterator();
        while(filmsubjectssI.hasNext()) {
            jsonfilmsubjectss.add(toJSON((Filmsubjects)filmsubjectssI.next()));
        }
        return jsonfilmsubjectss;
    }

    public static JSONObject toJSON(IFilmsubjectsPK filmsubjectsPK) {
        JSONObject json = null;
        if(filmsubjectsPK!=null) {
            json = new JSONObject();
            json.put("film", filmsubjectsPK.getFilm());
            json.put("cat1", filmsubjectsPK.getCat1());
            json.put("cat2", filmsubjectsPK.getCat2());
            json.put("subject", filmsubjectsPK.getSubject());
        }
        return json;
    }

    public static JSONObject toJSON(IFilmsubjects filmsubjects) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(filmsubjects.getPrimaryKey()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Filmsubjectssearch filmsubjectssearch) {
        JSONObject json = new JSONObject();
        if(filmsubjectssearch.used()) {
            byte andoroperator = filmsubjectssearch.getAndoroperator();
            int maxresults = filmsubjectssearch.getMaxresults();
            boolean docount = filmsubjectssearch.getDocount();
            Iterator<EntityPK> primarykeysI = filmsubjectssearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = filmsubjectssearch.getFieldsearchers().iterator();
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
            if(filmsubjectssearch.getSubjectsearch()!=null && filmsubjectssearch.getSubjectsearch().used()) {
                kss.put("subjectsearcher", JSONSubject.toJSON((Subjectsearch)filmsubjectssearch.getSubjectsearch()));
            }
            if(filmsubjectssearch.getFilmsearch()!=null && filmsubjectssearch.getFilmsearch().used()) {
                kss.put("filmsearcher", JSONFilm.toJSON((Filmsearch)filmsubjectssearch.getFilmsearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Filmsubjectssearch toFilmsubjectssearch(JSONObject json) {
        Filmsubjectssearch filmsubjectssearch = new Filmsubjectssearch();
        filmsubjectssearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        filmsubjectssearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        filmsubjectssearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            filmsubjectssearch.addPrimarykey(FilmsubjectsPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("subjectsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Subjectsearch subjectsearch = JSONSubject.toSubjectsearch((JSONObject)keysearch.get(i));
                filmsubjectssearch.subject(subjectsearch);
            }
        }
        keysearch = (JSONArray)kss.get("filmsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Filmsearch filmsearch = JSONFilm.toFilmsearch((JSONObject)keysearch.get(i));
                filmsubjectssearch.film(filmsearch);
            }
        }
        return filmsubjectssearch;
    }
    
    public static FilmsubjectsPK toFilmsubjectsPK(JSONObject json) {
        FilmsubjectsPK filmsubjectsPK = null;
        if(json!=null) {
            filmsubjectsPK = new FilmsubjectsPK(JSONConversion.getString(json, "film"), JSONConversion.getString(json, "cat1"), JSONConversion.getString(json, "cat2"), JSONConversion.getint(json, "subject"));
        }
        return filmsubjectsPK;
    }

    public static Filmsubjects toFilmsubjects(JSONObject json) {
        Filmsubjects filmsubjects = new Filmsubjects(toFilmsubjectsPK((JSONObject)json.get("PK")));
        updateFilmsubjects(filmsubjects, json);
        return filmsubjects;
    }

    public static void updateFilmsubjects(IFilmsubjects filmsubjects, JSONObject json) {
    }

    public static Filmsubjects initFilmsubjects(JSONObject json) {
        Filmsubjects filmsubjects = new Filmsubjects(toFilmsubjectsPK((JSONObject)json.get("PK")));
        return filmsubjects;
    }
}

