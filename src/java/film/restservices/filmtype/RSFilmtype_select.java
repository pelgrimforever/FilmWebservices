/*
 * Generated on 1.5.2022 20:24
 */

package film.restservices.filmtype;

import base.restservices.RS_json_login;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.gis.shape.piPoint;
import film.conversion.json.*;
import film.entity.pk.*;
import film.usecases.Filmtype_usecases;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.IFilmtypesearch;
import film.interfaces.servlet.IFilmtypeOperation;
import film.logicentity.Filmtype;
import film.searchentity.Filmtypesearch;
import film.servlets.DataServlet;
import film.usecases.Security_usecases;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
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
@Path("rsfilmtype_select")
public class RSFilmtype_select extends RS_json_login {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(Security_usecases.check_authorization(authorisationstring));
            IFilmtypePK filmtypePK;
            IFilmtype filmtype;
            Filmtype_usecases filmtypeusecases = new Filmtype_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IFilmtypeOperation.SELECT_COUNT:
                    result = count_records(filmtypeusecases);
                    break;
                case IFilmtypeOperation.SELECT_ALL:
                    result = get_all_filmtype(filmtypeusecases);
                    break;
                case IFilmtypeOperation.SELECT_FILMTYPE:
                    result = get_filmtype_with_primarykey(filmtypeusecases, json);
                    break;
                case IFilmtypeOperation.SELECT_SEARCH:
                    result = search_filmtype(filmtypeusecases, json);
                    break;
                case IFilmtypeOperation.SELECT_SEARCHCOUNT:
                    result = search_filmtype_count(filmtypeusecases, json);
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

    private String count_records(Filmtype_usecases filmtypeusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", filmtypeusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_filmtype(Filmtype_usecases filmtypeusecases) throws ParseException, CustomException {
    	return JSONFilmtype.toJSONArray(filmtypeusecases.get_all()).toJSONString();
    }
    
    private String get_filmtype_with_primarykey(Filmtype_usecases filmtypeusecases, JSONObject json) throws ParseException, CustomException {
        IFilmtypePK filmtypePK = (IFilmtypePK)JSONFilmtype.toFilmtypePK((JSONObject)json.get("filmtypepk"));
	return JSONFilmtype.toJSON(filmtypeusecases.get_filmtype_by_primarykey(filmtypePK)).toJSONString();
    }
    
    private String search_filmtype(Filmtype_usecases filmtypeusecases, JSONObject json) throws ParseException, CustomException {
        IFilmtypesearch search = (IFilmtypesearch)JSONFilmtype.toFilmtypesearch((JSONObject)json.get("search"));
        return JSONFilmtype.toJSONArray(filmtypeusecases.search_filmtype(search)).toJSONString();
    }
    
    private String search_filmtype_count(Filmtype_usecases filmtypeusecases, JSONObject json) throws ParseException, CustomException {
        IFilmtypesearch filmtypesearch = (IFilmtypesearch)JSONFilmtype.toFilmtypesearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", filmtypeusecases.search_filmtype_count(filmtypesearch));
        return jsonsearchcount.toJSONString();
    }
}

