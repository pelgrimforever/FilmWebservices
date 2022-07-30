/*
 * Generated on 27.6.2022 16:45
 */

package film.restservices.filmsubjects;

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
import film.interfaces.searchentity.IFilmsubjectssearch;
import film.interfaces.servlet.IFilmsubjectsOperation;
import film.logicentity.Filmsubjects;
import film.searchentity.Filmsubjectssearch;
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
@Path("rsfilmsubjects_select")
public class RSFilmsubjects_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Filmsubjects_usecases filmsubjectsusecases = new Filmsubjects_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IFilmsubjectsOperation.SELECT_COUNT:
                    result = count_records(filmsubjectsusecases);
                    break;
                case IFilmsubjectsOperation.SELECT_ALL:
                    result = get_all_filmsubjects(filmsubjectsusecases);
                    break;
                case IFilmsubjectsOperation.SELECT_FILMSUBJECTS:
                    result = get_filmsubjects_with_primarykey(filmsubjectsusecases, json);
                    break;
                case IFilmsubjectsOperation.SELECT_Subject:
                    result = get_filmsubjects_with_foreignkey_subject(filmsubjectsusecases, json);
                    break;
                case IFilmsubjectsOperation.SELECT_Film:
                    result = get_filmsubjects_with_foreignkey_film(filmsubjectsusecases, json);
                    break;
                case IFilmsubjectsOperation.SELECT_SEARCH:
                    result = search_filmsubjects(filmsubjectsusecases, json);
                    break;
                case IFilmsubjectsOperation.SELECT_SEARCHCOUNT:
                    result = search_filmsubjects_count(filmsubjectsusecases, json);
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

    private String count_records(Filmsubjects_usecases filmsubjectsusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", filmsubjectsusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_filmsubjects(Filmsubjects_usecases filmsubjectsusecases) throws ParseException, CustomException {
    	return JSONFilmsubjects.toJSONArray(filmsubjectsusecases.get_all()).toJSONString();
    }
    
    private String get_filmsubjects_with_primarykey(Filmsubjects_usecases filmsubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IFilmsubjectsPK filmsubjectsPK = (IFilmsubjectsPK)JSONFilmsubjects.toFilmsubjectsPK((JSONObject)json.get("filmsubjectspk"));
	return JSONFilmsubjects.toJSON(filmsubjectsusecases.get_filmsubjects_by_primarykey(filmsubjectsPK)).toJSONString();
    }
    
    private String get_filmsubjects_with_foreignkey_subject(Filmsubjects_usecases filmsubjectsusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectPK subjectPK = (ISubjectPK)JSONSubject.toSubjectPK((JSONObject)json.get("subjectpk"));
        return JSONFilmsubjects.toJSONArray(filmsubjectsusecases.get_filmsubjects_with_foreignkey_subject(subjectPK)).toJSONString();
    }
    
    private String get_filmsubjects_with_foreignkey_film(Filmsubjects_usecases filmsubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IFilmPK filmPK = (IFilmPK)JSONFilm.toFilmPK((JSONObject)json.get("filmpk"));
        return JSONFilmsubjects.toJSONArray(filmsubjectsusecases.get_filmsubjects_with_foreignkey_film(filmPK)).toJSONString();
    }
    
    private String search_filmsubjects(Filmsubjects_usecases filmsubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IFilmsubjectssearch search = (IFilmsubjectssearch)JSONFilmsubjects.toFilmsubjectssearch((JSONObject)json.get("search"));
        return JSONFilmsubjects.toJSONArray(filmsubjectsusecases.search_filmsubjects(search)).toJSONString();
    }
    
    private String search_filmsubjects_count(Filmsubjects_usecases filmsubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IFilmsubjectssearch filmsubjectssearch = (IFilmsubjectssearch)JSONFilmsubjects.toFilmsubjectssearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", filmsubjectsusecases.search_filmsubjects_count(filmsubjectssearch));
        return jsonsearchcount.toJSONString();
    }
}

