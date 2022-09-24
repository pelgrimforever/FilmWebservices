/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.webservices;

import base.restservices.RS_json_login;
import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.IFilmsearch;
import film.interfaces.webservice.WSIFilm;
import film.logicentity.Film;
import film.searchentity.Filmsearch;
import film.usecases.*;
import general.exception.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import film.usecases.custom.Security_usecases;

@WebService(endpointInterface = "film.interfaces.webservice.WSIFilm")
public class WSFilm extends RS_json_login implements WSIFilm {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList films) {
        JSONArray jsonfilms = new JSONArray();
        Iterator filmsI = films.iterator();
        while(filmsI.hasNext()) {
            jsonfilms.add(JSONFilm.toJSON((Film)filmsI.next()));
        }
        return jsonfilms;
    }

    //@WebMethod(operationName = "getFilms")
    @Override
    public String getFilms() {
        try {
            Film_usecases filmusecases = new Film_usecases(loggedin);
            return get_all_film(filmusecases);
        }
        catch(CustomException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Film_usecases filmusecases = new Film_usecases(loggedin);
            return search_film(filmusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getFilm")
    @Override
    public String getFilm(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Film_usecases filmusecases = new Film_usecases(loggedin);
            return get_film_with_primarykey(filmusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertFilm")
    @Override
    public void insertFilm(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Film_usecases filmusecases = new Film_usecases(loggedin);
            insert_film(filmusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateFilm")
    @Override
    public void updateFilm(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Film_usecases filmusecases = new Film_usecases(loggedin);
            update_film(filmusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteFilm")
    @Override
    public void deleteFilm(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Film_usecases filmusecases = new Film_usecases(loggedin);
            delete_film(filmusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getFilms4filmtype")
    @Override
    public String getFilms4filmtype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Film_usecases filmusecases = new Film_usecases(loggedin);
            return get_film_with_foreignkey_filmtype(filmusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4filmtype")
    @Override
    public void delete4filmtype(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Film_usecases filmusecases = new Film_usecases(loggedin);
            delete_film(filmusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getFilms4filmsubjects")
    @Override
    public String getFilms4filmsubjects(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Film_usecases filmusecases = new Film_usecases(loggedin);
            return get_film_with_externalforeignkey_filmsubjects(filmusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getFilms4photo")
    @Override
    public String getFilms4photo(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Film_usecases filmusecases = new Film_usecases(loggedin);
            return get_film_with_externalforeignkey_photo(filmusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


    private String count_records(Film_usecases filmusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", filmusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_film(Film_usecases filmusecases) throws ParseException, CustomException {
    	return JSONFilm.toJSONArray(filmusecases.get_all()).toJSONString();
    }
    
    private String get_film_with_primarykey(Film_usecases filmusecases, JSONObject json) throws ParseException, CustomException {
        IFilmPK filmPK = (IFilmPK)JSONFilm.toFilmPK((JSONObject)json.get("filmpk"));
	return JSONFilm.toJSON(filmusecases.get_film_by_primarykey(filmPK)).toJSONString();
    }
    
    private String get_film_with_foreignkey_filmtype(Film_usecases filmusecases, JSONObject json) throws ParseException, CustomException {
        IFilmtypePK filmtypePK = (IFilmtypePK)JSONFilmtype.toFilmtypePK((JSONObject)json.get("filmtypepk"));
        return JSONFilm.toJSONArray(filmusecases.get_film_with_foreignkey_filmtype(filmtypePK)).toJSONString();
    }
    
    private String get_film_with_externalforeignkey_filmsubjects(Film_usecases filmusecases, JSONObject json) throws ParseException, CustomException {
        IFilmsubjectsPK filmsubjectsPK = (IFilmsubjectsPK)JSONFilmsubjects.toFilmsubjectsPK((JSONObject)json.get("filmsubjectspk"));
        return JSONFilm.toJSON(filmusecases.get_film_with_externalforeignkey_filmsubjects(filmsubjectsPK)).toJSONString();
    }
    
    private String get_film_with_externalforeignkey_photo(Film_usecases filmusecases, JSONObject json) throws ParseException, CustomException {
        IPhotoPK photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
        return JSONFilm.toJSON(filmusecases.get_film_with_externalforeignkey_photo(photoPK)).toJSONString();
    }
    
    private String search_film(Film_usecases filmusecases, JSONObject json) throws ParseException, CustomException {
        IFilmsearch search = (IFilmsearch)JSONFilm.toFilmsearch((JSONObject)json.get("search"));
        return JSONFilm.toJSONArray(filmusecases.search_film(search)).toJSONString();
    }
    
    private String search_film_count(Film_usecases filmusecases, JSONObject json) throws ParseException, CustomException {
        IFilmsearch filmsearch = (IFilmsearch)JSONFilm.toFilmsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", filmusecases.search_film_count(filmsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_film(Film_usecases filmusecases, JSONObject json) throws ParseException, CustomException {
        IFilm film = (IFilm)JSONFilm.toFilm((JSONObject)json.get("film"));
        filmusecases.insertFilm(film);
        setReturnstatus("OK");
    }

    private void update_film(Film_usecases filmusecases, JSONObject json) throws ParseException, CustomException {
        IFilm film = (IFilm)JSONFilm.toFilm((JSONObject)json.get("film"));
        filmusecases.updateFilm(film);
        setReturnstatus("OK");
    }

    private void delete_film(Film_usecases filmusecases, JSONObject json) throws ParseException, CustomException {
        IFilm film = (IFilm)JSONFilm.toFilm((JSONObject)json.get("film"));
        filmusecases.deleteFilm(film);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Filmtype(Film_usecases filmusecases, JSONObject json) throws ParseException, CustomException {
        IFilmtypePK filmtypePK = (IFilmtypePK)JSONFilmtype.toFilmtypePK((JSONObject)json.get("filmtypepk"));
        filmusecases.delete_all_containing_Filmtype(filmtypePK);
        setReturnstatus("OK");
    }

}

