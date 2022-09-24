/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.restservices.photosubjects;

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
import film.interfaces.searchentity.IPhotosubjectssearch;
import film.interfaces.servlet.IPhotosubjectsOperation;
import film.logicentity.Photosubjects;
import film.searchentity.Photosubjectssearch;
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

@Path("rsphotosubjects_select")
public class RSPhotosubjects_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photosubjects_usecases photosubjectsusecases = new Photosubjects_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IPhotosubjectsOperation.SELECT_COUNT:
                    result = count_records(photosubjectsusecases);
                    break;
                case IPhotosubjectsOperation.SELECT_ALL:
                    result = get_all_photosubjects(photosubjectsusecases);
                    break;
                case IPhotosubjectsOperation.SELECT_PHOTOSUBJECTS:
                    result = get_photosubjects_with_primarykey(photosubjectsusecases, json);
                    break;
                case IPhotosubjectsOperation.SELECT_Photo:
                    result = get_photosubjects_with_foreignkey_photo(photosubjectsusecases, json);
                    break;
                case IPhotosubjectsOperation.SELECT_Subject:
                    result = get_photosubjects_with_foreignkey_subject(photosubjectsusecases, json);
                    break;
                case IPhotosubjectsOperation.SELECT_SEARCH:
                    result = search_photosubjects(photosubjectsusecases, json);
                    break;
                case IPhotosubjectsOperation.SELECT_SEARCHCOUNT:
                    result = search_photosubjects_count(photosubjectsusecases, json);
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

    private String count_records(Photosubjects_usecases photosubjectsusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", photosubjectsusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_photosubjects(Photosubjects_usecases photosubjectsusecases) throws ParseException, CustomException {
    	return JSONPhotosubjects.toJSONArray(photosubjectsusecases.get_all()).toJSONString();
    }
    
    private String get_photosubjects_with_primarykey(Photosubjects_usecases photosubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IPhotosubjectsPK photosubjectsPK = (IPhotosubjectsPK)JSONPhotosubjects.toPhotosubjectsPK((JSONObject)json.get("photosubjectspk"));
	return JSONPhotosubjects.toJSON(photosubjectsusecases.get_photosubjects_by_primarykey(photosubjectsPK)).toJSONString();
    }
    
    private String get_photosubjects_with_foreignkey_photo(Photosubjects_usecases photosubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IPhotoPK photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
        return JSONPhotosubjects.toJSONArray(photosubjectsusecases.get_photosubjects_with_foreignkey_photo(photoPK)).toJSONString();
    }
    
    private String get_photosubjects_with_foreignkey_subject(Photosubjects_usecases photosubjectsusecases, JSONObject json) throws ParseException, CustomException {
        ISubjectPK subjectPK = (ISubjectPK)JSONSubject.toSubjectPK((JSONObject)json.get("subjectpk"));
        return JSONPhotosubjects.toJSONArray(photosubjectsusecases.get_photosubjects_with_foreignkey_subject(subjectPK)).toJSONString();
    }
    
    private String search_photosubjects(Photosubjects_usecases photosubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IPhotosubjectssearch search = (IPhotosubjectssearch)JSONPhotosubjects.toPhotosubjectssearch((JSONObject)json.get("search"));
        return JSONPhotosubjects.toJSONArray(photosubjectsusecases.search_photosubjects(search)).toJSONString();
    }
    
    private String search_photosubjects_count(Photosubjects_usecases photosubjectsusecases, JSONObject json) throws ParseException, CustomException {
        IPhotosubjectssearch photosubjectssearch = (IPhotosubjectssearch)JSONPhotosubjects.toPhotosubjectssearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", photosubjectsusecases.search_photosubjects_count(photosubjectssearch));
        return jsonsearchcount.toJSONString();
    }
}

