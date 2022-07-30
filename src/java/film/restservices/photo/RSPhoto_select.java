/*
 * Generated on 27.6.2022 16:45
 */

package film.restservices.photo;

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
import film.interfaces.searchentity.IPhotosearch;
import film.interfaces.servlet.IPhotoOperation;
import film.logicentity.Photo;
import film.searchentity.Photosearch;
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
@Path("rsphoto_select")
public class RSPhoto_select extends RS_json_login {

    private Security_usecases security_usecases = new Security_usecases();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photo_usecases photousecases = new Photo_usecases(loggedin);
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   
            switch(operation) {
                case IPhotoOperation.SELECT_COUNT:
                    result = count_records(photousecases);
                    break;
                case IPhotoOperation.SELECT_ALL:
                    result = get_all_photo(photousecases);
                    break;
                case IPhotoOperation.SELECT_PHOTO:
                    result = get_photo_with_primarykey(photousecases, json);
                    break;
                case IPhotoOperation.SELECT_Route:
                    result = get_photo_with_foreignkey_route(photousecases, json);
                    break;
                case IPhotoOperation.SELECT_Creator:
                    result = get_photo_with_foreignkey_creator(photousecases, json);
                    break;
                case IPhotoOperation.SELECT_Film:
                    result = get_photo_with_foreignkey_film(photousecases, json);
                    break;
                case IPhotoOperation.SELECT_Phototree7subject:
                    result = get_photo_with_externalforeignkey_phototree7subject(photousecases, json);
                    break;
                case IPhotoOperation.SELECT_Art_photo:
                    result = get_photo_with_externalforeignkey_art_photo(photousecases, json);
                    break;
                case IPhotoOperation.SELECT_Photosubjects:
                    result = get_photo_with_externalforeignkey_photosubjects(photousecases, json);
                    break;
                case IPhotoOperation.SELECT_Phototags:
                    result = get_photo_with_externalforeignkey_phototags(photousecases, json);
                    break;
                case IPhotoOperation.SELECT_SEARCH:
                    result = search_photo(photousecases, json);
                    break;
                case IPhotoOperation.SELECT_SEARCHCOUNT:
                    result = search_photo_count(photousecases, json);
                    break;
//Custom code, do not change this line
//add here custom operations
                case IPhotoOperation.SELECT_FilmWITHIMAGESBASE64:
                    result = get_photos_from_film_with_Thumbnails(photousecases, json);
                    break;
                case IPhotoOperation.SECURESELECT_COUNT:
                    result = count_records_public_and_private(photousecases);
                    break;
                case IPhotoOperation.SELECT_LOCATION:
                    result = get_photos_from_location_with_Thumbnails(photousecases, json);
                    break;
                case IPhotoOperation.SELECT_LOCATIONS:
                    result = get_photos_from_locations_with_Thumbnails(photousecases, json);
                    break;
                case IPhotoOperation.SECURESELECT_DATE:
                    result = get_photos_from_date(photousecases, json);
                    break;
                case IPhotoOperation.SELECT_SEARCHWITHIMAGESBASE64:
                    result = search_photos_with_Thumbnails(photousecases, json);
                    break;
                case IPhotoOperation.SECURESELECT_SEARCHCOUNT:
                    result = search_photos_count_public_and_private(photousecases, json);
                    break;
                case IPhotoOperation.SECURESELECT_DESCRIPTIONS:
                    result = search_text_in_description(photousecases, json);
                    break;
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
    private String get_photos_from_film_with_Thumbnails(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        IFilmPK filmPK = (IFilmPK)JSONFilm.toFilmPK((JSONObject)json.get("filmpk"));
        ArrayList<Photo> photos = photousecases.get_photos_from_film_with_Thumbnails(filmPK);
        return JSONPhoto.toJSONArray(photos).toJSONString();
    }
    
    private String count_records_public_and_private(Photo_usecases photousecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        long count = photousecases.count_records_public_and_private(loggedin);
        jsoncount.put("recordcount", count);
        return jsoncount.toJSONString();
    }

    private String get_photos_from_location_with_Thumbnails(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        piPoint location = GISConversion.topiPoint((JSONObject)json.get("location"));
        ArrayList<Photo> photos = photousecases.get_photos_from_location_with_Thumbnails(location);
        return JSONPhoto.toJSONArray(photos).toJSONString();
    }
    
    private String get_photos_from_locations_with_Thumbnails(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        JSONArray jsonlocations = (JSONArray)json.get("locations");
        Iterator<JSONObject> jsonlocationsI = jsonlocations.iterator();
        ArrayList<piPoint> locations = new ArrayList<>();
        while(jsonlocationsI.hasNext())
            convert_and_add_next_location_to_locationsarray(jsonlocationsI.next(), locations);
        ArrayList<Photo> photos = photousecases.get_photos_from_locations_with_Thumbnails(locations);
        return JSONPhoto.toJSONArray(photos).toJSONString();
    }

    private void convert_and_add_next_location_to_locationsarray(JSONObject jsonlocation, ArrayList<piPoint> locations) {
        piPoint location = GISConversion.topiPoint(jsonlocation);
        locations.add(location);
    }
    
    private String get_photos_from_date(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        Date date = JSONConversion.getDate(json, "date");
        ArrayList<Photo> photos = photousecases.get_photos_from_date(date);
        return JSONPhoto.toJSONArray(photos).toJSONString();
    }

    private String search_photos_with_Thumbnails(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        IPhotosearch searchparameters = (IPhotosearch)JSONPhoto.toPhotosearch((JSONObject)json.get("search"));
        ArrayList secphotos = photousecases.search_photos_with_Thumbnails(searchparameters);
        return JSONPhoto.toJSONArray(secphotos).toJSONString();
    }

    private String search_photos_count_public_and_private(Photo_usecases searchparameters, JSONObject json) throws ParseException, CustomException {
        IPhotosearch secphotosearch = (IPhotosearch)JSONPhoto.toPhotosearch((JSONObject)json.get("search"));
        long count = searchparameters.search_photos_count_public_and_private(secphotosearch);
        JSONObject jsonsecsearchcount = new JSONObject();
        jsonsecsearchcount.put("recordcount", count);
        return jsonsecsearchcount.toJSONString();
    }

    private String search_text_in_description(Photo_usecases searchparameters, JSONObject json) throws ParseException, CustomException {
        String searchtext = (String)json.get("searchtext");
        ArrayList<String> descriptions = searchparameters.search_text_in_description(searchtext);
        JSONArray jsondescriptions = new JSONArray();
        for(String description: descriptions)
            add_description_to_descriptionsarray(description, jsondescriptions);
        return jsondescriptions.toJSONString();
    }

    private void add_description_to_descriptionsarray(String description, JSONArray jsondescriptions) {
        JSONObject jsonitem = new JSONObject();
        jsonitem.put("description", description);
        jsondescriptions.add(jsonitem);
    }
//Custom code, do not change this line   

    private String count_records(Photo_usecases photousecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", photousecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_photo(Photo_usecases photousecases) throws ParseException, CustomException {
    	return JSONPhoto.toJSONArray(photousecases.get_all()).toJSONString();
    }
    
    private String get_photo_with_primarykey(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        IPhotoPK photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
	return JSONPhoto.toJSON(photousecases.get_photo_by_primarykey(photoPK)).toJSONString();
    }
    
    private String get_photo_with_foreignkey_route(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        IRoutePK routePK = (IRoutePK)JSONRoute.toRoutePK((JSONObject)json.get("routepk"));
        return JSONPhoto.toJSONArray(photousecases.get_photo_with_foreignkey_route(routePK)).toJSONString();
    }
    
    private String get_photo_with_foreignkey_creator(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        ICreatorPK creatorPK = (ICreatorPK)JSONCreator.toCreatorPK((JSONObject)json.get("creatorpk"));
        return JSONPhoto.toJSONArray(photousecases.get_photo_with_foreignkey_creator(creatorPK)).toJSONString();
    }
    
    private String get_photo_with_foreignkey_film(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        IFilmPK filmPK = (IFilmPK)JSONFilm.toFilmPK((JSONObject)json.get("filmpk"));
        return JSONPhoto.toJSONArray(photousecases.get_photo_with_foreignkey_film(filmPK)).toJSONString();
    }
    
    private String get_photo_with_externalforeignkey_phototree7subject(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        IPhototree7subjectPK phototree7subjectPK = (IPhototree7subjectPK)JSONPhototree7subject.toPhototree7subjectPK((JSONObject)json.get("phototree7subjectpk"));
        return JSONPhoto.toJSON(photousecases.get_photo_with_externalforeignkey_phototree7subject(phototree7subjectPK)).toJSONString();
    }
    
    private String get_photo_with_externalforeignkey_art_photo(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        IArt_photoPK art_photoPK = (IArt_photoPK)JSONArt_photo.toArt_photoPK((JSONObject)json.get("art_photopk"));
        return JSONPhoto.toJSON(photousecases.get_photo_with_externalforeignkey_art_photo(art_photoPK)).toJSONString();
    }
    
    private String get_photo_with_externalforeignkey_photosubjects(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        IPhotosubjectsPK photosubjectsPK = (IPhotosubjectsPK)JSONPhotosubjects.toPhotosubjectsPK((JSONObject)json.get("photosubjectspk"));
        return JSONPhoto.toJSON(photousecases.get_photo_with_externalforeignkey_photosubjects(photosubjectsPK)).toJSONString();
    }
    
    private String get_photo_with_externalforeignkey_phototags(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        IPhototagsPK phototagsPK = (IPhototagsPK)JSONPhototags.toPhototagsPK((JSONObject)json.get("phototagspk"));
        return JSONPhoto.toJSON(photousecases.get_photo_with_externalforeignkey_phototags(phototagsPK)).toJSONString();
    }
    
    private String search_photo(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        IPhotosearch search = (IPhotosearch)JSONPhoto.toPhotosearch((JSONObject)json.get("search"));
        return JSONPhoto.toJSONArray(photousecases.search_photo(search)).toJSONString();
    }
    
    private String search_photo_count(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        IPhotosearch photosearch = (IPhotosearch)JSONPhoto.toPhotosearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", photousecases.search_photo_count(photosearch));
        return jsonsearchcount.toJSONString();
    }
}

