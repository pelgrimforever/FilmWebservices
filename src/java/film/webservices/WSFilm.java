/*
 * WSFilm.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 24.9.2021 14:50
 *
 */

package film.webservices;

import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.webservice.WSIFilm;
import film.logicentity.Film;
import film.searchentity.Filmsearch;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "film.interfaces.webservice.WSIFilm")
public class WSFilm implements WSIFilm {

    private JSONArray toJSONArray(ArrayList films) {
        JSONArray jsonfilms = new JSONArray();
        Iterator filmsI = films.iterator();
        while(filmsI.hasNext()) {
            jsonfilms.add(JSONFilm.toJSON((Film)filmsI.next()));
        }
        return jsonfilms;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getFilms")
    @Override
    public String getFilms() {
        try {
            BLfilm blfilm = new BLfilm();
            ArrayList films = blfilm.getAll();
            JSONArray jsonfilms = toJSONArray(films);
            return jsonfilms.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLfilm blfilm = new BLfilm();
        JSONParser parser = new JSONParser();
        String result = "";
        Film film;
        try {
            Filmsearch filmsearch = JSONFilm.toFilmsearch((JSONObject)parser.parse(json));
            ArrayList films = blfilm.search(filmsearch);
            JSONArray jsonfilms = toJSONArray(films);
            result = jsonfilms.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getFilm")
    @Override
    public String getFilm(String json) {
        BLfilm blfilm = new BLfilm();
        JSONParser parser = new JSONParser();
        String result = "";
        Film film;
        try {
            FilmPK filmPK = JSONFilm.toFilmPK((JSONObject)parser.parse(json));
            film = blfilm.getFilm(filmPK);
            if(film!=null) {
                result = JSONFilm.toJSON(film).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertFilm")
    @Override
    public void insertFilm(String json) {
        BLfilm blfilm = new BLfilm();
        JSONParser parser = new JSONParser();
        try {
            IFilm film = JSONFilm.toFilm((JSONObject)parser.parse(json));
            blfilm.insertFilm(film);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateFilm")
    @Override
    public void updateFilm(String json) {
        BLfilm blfilm = new BLfilm();
        JSONParser parser = new JSONParser();
        try {
            IFilm film = JSONFilm.toFilm((JSONObject)parser.parse(json));
            blfilm.updateFilm(film);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteFilm")
    @Override
    public void deleteFilm(String json) {
        BLfilm blfilm = new BLfilm();
        JSONParser parser = new JSONParser();
        try {
            IFilm film = JSONFilm.toFilm((JSONObject)parser.parse(json));
            blfilm.deleteFilm(film);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getFilms4filmtype")
    @Override
    public String getFilms4filmtype(String json) {
        BLfilm blfilm = new BLfilm();
        JSONParser parser = new JSONParser();
        Film film;
        try {
            IFilmtypePK filmtypePK = JSONFilmtype.toFilmtypePK((JSONObject)parser.parse(json));
            ArrayList films = blfilm.getFilms4filmtype(filmtypePK);
            JSONArray jsonfilms = toJSONArray(films);
            return jsonfilms.toJSONString();
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4filmtype")
    @Override
    public void delete4filmtype(String json) {
        BLfilm blfilm = new BLfilm();
        JSONParser parser = new JSONParser();
        Film film;
        try {
            IFilmtypePK filmtypePK = JSONFilmtype.toFilmtypePK((JSONObject)parser.parse(json));
            blfilm.delete4filmtype(filmtypePK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getFilms4filmsubjects")
    @Override
    public String getFilms4filmsubjects(String json) {
        BLfilm blfilm = new BLfilm();
        JSONParser parser = new JSONParser();
        Film film;
        try {
            String result = null;
            IFilmsubjectsPK filmsubjectsPK = JSONFilmsubjects.toFilmsubjectsPK((JSONObject)parser.parse(json));
            film = (Film)blfilm.getFilmsubjects(filmsubjectsPK);
            if(film!=null) {
                result = JSONFilm.toJSON(film).toJSONString();
            }
            return result;
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getFilms4photo")
    @Override
    public String getFilms4photo(String json) {
        BLfilm blfilm = new BLfilm();
        JSONParser parser = new JSONParser();
        Film film;
        try {
            String result = null;
            IPhotoPK photoPK = JSONPhoto.toPhotoPK((JSONObject)parser.parse(json));
            film = (Film)blfilm.getPhoto(photoPK);
            if(film!=null) {
                result = JSONFilm.toJSON(film).toJSONString();
            }
            return result;
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }


}

