/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.restservices.art_photo;

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
import film.interfaces.searchentity.IArt_photosearch;
import film.interfaces.servlet.IArt_photoOperation;
import film.logicentity.Art_photo;
import film.searchentity.Art_photosearch;
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

@Path("rsart_photo_select")
public class RSArt_photo_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_photo_usecases art_photousecases = new Art_photo_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IArt_photoOperation.SELECT_COUNT:
                    result = count_records(art_photousecases);
                    break;
                case IArt_photoOperation.SELECT_ALL:
                    result = get_all_art_photo(art_photousecases);
                    break;
                case IArt_photoOperation.SELECT_ART_PHOTO:
                    result = get_art_photo_with_primarykey(art_photousecases, json);
                    break;
                case IArt_photoOperation.SELECT_Photo:
                    result = get_art_photo_with_foreignkey_photo(art_photousecases, json);
                    break;
                case IArt_photoOperation.SELECT_Art_subgroup:
                    result = get_art_photo_with_foreignkey_art_subgroup(art_photousecases, json);
                    break;
                case IArt_photoOperation.SELECT_Art_academy:
                    result = get_art_photo_with_foreignkey_art_academy(art_photousecases, json);
                    break;
                case IArt_photoOperation.SELECT_Art_group:
                    result = get_art_photo_with_foreignkey_art_group(art_photousecases, json);
                    break;
                case IArt_photoOperation.SELECT_SEARCH:
                    result = search_art_photo(art_photousecases, json);
                    break;
                case IArt_photoOperation.SELECT_SEARCHCOUNT:
                    result = search_art_photo_count(art_photousecases, json);
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

    private String count_records(Art_photo_usecases art_photousecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", art_photousecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_art_photo(Art_photo_usecases art_photousecases) throws ParseException, CustomException {
    	return JSONArt_photo.toJSONArray(art_photousecases.get_all()).toJSONString();
    }
    
    private String get_art_photo_with_primarykey(Art_photo_usecases art_photousecases, JSONObject json) throws ParseException, CustomException {
        IArt_photoPK art_photoPK = (IArt_photoPK)JSONArt_photo.toArt_photoPK((JSONObject)json.get("art_photopk"));
	return JSONArt_photo.toJSON(art_photousecases.get_art_photo_by_primarykey(art_photoPK)).toJSONString();
    }
    
    private String get_art_photo_with_foreignkey_photo(Art_photo_usecases art_photousecases, JSONObject json) throws ParseException, CustomException {
        IPhotoPK photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
        return JSONArt_photo.toJSONArray(art_photousecases.get_art_photo_with_foreignkey_photo(photoPK)).toJSONString();
    }
    
    private String get_art_photo_with_foreignkey_art_subgroup(Art_photo_usecases art_photousecases, JSONObject json) throws ParseException, CustomException {
        IArt_subgroupPK art_subgroupPK = (IArt_subgroupPK)JSONArt_subgroup.toArt_subgroupPK((JSONObject)json.get("art_subgrouppk"));
        return JSONArt_photo.toJSONArray(art_photousecases.get_art_photo_with_foreignkey_art_subgroup(art_subgroupPK)).toJSONString();
    }
    
    private String get_art_photo_with_foreignkey_art_academy(Art_photo_usecases art_photousecases, JSONObject json) throws ParseException, CustomException {
        IArt_academyPK art_academyPK = (IArt_academyPK)JSONArt_academy.toArt_academyPK((JSONObject)json.get("art_academypk"));
        return JSONArt_photo.toJSONArray(art_photousecases.get_art_photo_with_foreignkey_art_academy(art_academyPK)).toJSONString();
    }
    
    private String get_art_photo_with_foreignkey_art_group(Art_photo_usecases art_photousecases, JSONObject json) throws ParseException, CustomException {
        IArt_groupPK art_groupPK = (IArt_groupPK)JSONArt_group.toArt_groupPK((JSONObject)json.get("art_grouppk"));
        return JSONArt_photo.toJSONArray(art_photousecases.get_art_photo_with_foreignkey_art_group(art_groupPK)).toJSONString();
    }
    
    private String search_art_photo(Art_photo_usecases art_photousecases, JSONObject json) throws ParseException, CustomException {
        IArt_photosearch search = (IArt_photosearch)JSONArt_photo.toArt_photosearch((JSONObject)json.get("search"));
        return JSONArt_photo.toJSONArray(art_photousecases.search_art_photo(search)).toJSONString();
    }
    
    private String search_art_photo_count(Art_photo_usecases art_photousecases, JSONObject json) throws ParseException, CustomException {
        IArt_photosearch art_photosearch = (IArt_photosearch)JSONArt_photo.toArt_photosearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", art_photousecases.search_art_photo_count(art_photosearch));
        return jsonsearchcount.toJSONString();
    }
}

