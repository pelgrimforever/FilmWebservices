/*
 * Generated on 27.6.2022 16:45
 */

package film.restservices.film;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.conversion.json.*;
import film.entity.pk.*;
import film.usecases.*;
import film.usecases.custom.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.IFilmsearch;
import film.interfaces.servlet.IFilmOperation;
import film.logicentity.Film;
import film.searchentity.Filmsearch;
import film.servlets.DataServlet;
import film.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.sql.Time;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
@Path("rsfilm_select")
public class RSFilm_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Film_usecases filmusecases = new Film_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IFilmOperation.SELECT_COUNT:
                    result = count_records(filmusecases);
                    break;
                case IFilmOperation.SELECT_ALL:
                    result = get_all_film(filmusecases);
                    break;
                case IFilmOperation.SELECT_FILM:
                    result = get_film_with_primarykey(filmusecases, json);
                    break;
                case IFilmOperation.SELECT_Filmtype:
                    result = get_film_with_foreignkey_filmtype(filmusecases, json);
                    break;
                case IFilmOperation.SELECT_Filmsubjects:
                    result = get_film_with_externalforeignkey_filmsubjects(filmusecases, json);
                    break;
                case IFilmOperation.SELECT_Photo:
                    result = get_film_with_externalforeignkey_photo(filmusecases, json);
                    break;
                case IFilmOperation.SELECT_SEARCH:
                    result = search_film(filmusecases, json);
                    break;
                case IFilmOperation.SELECT_SEARCHCOUNT:
                    result = search_film_count(filmusecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            }
        }
        catch(ParseException | CustomException | IOException e) {
            setReturnstatus(e.getMessage());
        }
        return result;
    }

//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

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
}

