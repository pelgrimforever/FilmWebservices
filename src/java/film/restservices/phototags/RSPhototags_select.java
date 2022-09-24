/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.restservices.phototags;

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
import film.interfaces.searchentity.IPhototagssearch;
import film.interfaces.servlet.IPhototagsOperation;
import film.logicentity.Phototags;
import film.searchentity.Phototagssearch;
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

@Path("rsphototags_select")
public class RSPhototags_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Phototags_usecases phototagsusecases = new Phototags_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IPhototagsOperation.SELECT_COUNT:
                    result = count_records(phototagsusecases);
                    break;
                case IPhototagsOperation.SELECT_ALL:
                    result = get_all_phototags(phototagsusecases);
                    break;
                case IPhototagsOperation.SELECT_PHOTOTAGS:
                    result = get_phototags_with_primarykey(phototagsusecases, json);
                    break;
                case IPhototagsOperation.SELECT_Photo:
                    result = get_phototags_with_foreignkey_photo(phototagsusecases, json);
                    break;
                case IPhototagsOperation.SELECT_SEARCH:
                    result = search_phototags(phototagsusecases, json);
                    break;
                case IPhototagsOperation.SELECT_SEARCHCOUNT:
                    result = search_phototags_count(phototagsusecases, json);
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

    private String count_records(Phototags_usecases phototagsusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", phototagsusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_phototags(Phototags_usecases phototagsusecases) throws ParseException, CustomException {
    	return JSONPhototags.toJSONArray(phototagsusecases.get_all()).toJSONString();
    }
    
    private String get_phototags_with_primarykey(Phototags_usecases phototagsusecases, JSONObject json) throws ParseException, CustomException {
        IPhototagsPK phototagsPK = (IPhototagsPK)JSONPhototags.toPhototagsPK((JSONObject)json.get("phototagspk"));
	return JSONPhototags.toJSON(phototagsusecases.get_phototags_by_primarykey(phototagsPK)).toJSONString();
    }
    
    private String get_phototags_with_foreignkey_photo(Phototags_usecases phototagsusecases, JSONObject json) throws ParseException, CustomException {
        IPhotoPK photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
        return JSONPhototags.toJSONArray(phototagsusecases.get_phototags_with_foreignkey_photo(photoPK)).toJSONString();
    }
    
    private String search_phototags(Phototags_usecases phototagsusecases, JSONObject json) throws ParseException, CustomException {
        IPhototagssearch search = (IPhototagssearch)JSONPhototags.toPhototagssearch((JSONObject)json.get("search"));
        return JSONPhototags.toJSONArray(phototagsusecases.search_phototags(search)).toJSONString();
    }
    
    private String search_phototags_count(Phototags_usecases phototagsusecases, JSONObject json) throws ParseException, CustomException {
        IPhototagssearch phototagssearch = (IPhototagssearch)JSONPhototags.toPhototagssearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", phototagsusecases.search_phototags_count(phototagssearch));
        return jsonsearchcount.toJSONString();
    }
}

