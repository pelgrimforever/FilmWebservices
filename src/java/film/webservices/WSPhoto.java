/*
 * WSPhoto.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 27.6.2022 16:45
 *
 */

package film.webservices;

import base.restservices.RS_json_login;
import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.IPhotosearch;
import film.interfaces.webservice.WSIPhoto;
import film.logicentity.Photo;
import film.searchentity.Photosearch;
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

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "film.interfaces.webservice.WSIPhoto")
public class WSPhoto extends RS_json_login implements WSIPhoto {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList photos) {
        JSONArray jsonphotos = new JSONArray();
        Iterator photosI = photos.iterator();
        while(photosI.hasNext()) {
            jsonphotos.add(JSONPhoto.toJSON((Photo)photosI.next()));
        }
        return jsonphotos;
    }

    //@WebMethod(operationName = "getPhotos")
    @Override
    public String getPhotos() {
        try {
            Photo_usecases photousecases = new Photo_usecases(loggedin);
            return get_all_photo(photousecases);
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
            Photo_usecases photousecases = new Photo_usecases(loggedin);
            return search_photo(photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getPhoto")
    @Override
    public String getPhoto(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photo_usecases photousecases = new Photo_usecases(loggedin);
            return get_photo_with_primarykey(photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertPhoto")
    @Override
    public void insertPhoto(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photo_usecases photousecases = new Photo_usecases(loggedin);
            insert_photo(photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updatePhoto")
    @Override
    public void updatePhoto(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photo_usecases photousecases = new Photo_usecases(loggedin);
            update_photo(photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deletePhoto")
    @Override
    public void deletePhoto(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photo_usecases photousecases = new Photo_usecases(loggedin);
            delete_photo(photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getPhotos4route")
    @Override
    public String getPhotos4route(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photo_usecases photousecases = new Photo_usecases(loggedin);
            return get_photo_with_foreignkey_route(photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4route")
    @Override
    public void delete4route(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photo_usecases photousecases = new Photo_usecases(loggedin);
            delete_photo(photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getPhotos4creator")
    @Override
    public String getPhotos4creator(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photo_usecases photousecases = new Photo_usecases(loggedin);
            return get_photo_with_foreignkey_creator(photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4creator")
    @Override
    public void delete4creator(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photo_usecases photousecases = new Photo_usecases(loggedin);
            delete_photo(photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getPhotos4film")
    @Override
    public String getPhotos4film(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photo_usecases photousecases = new Photo_usecases(loggedin);
            return get_photo_with_foreignkey_film(photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4film")
    @Override
    public void delete4film(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photo_usecases photousecases = new Photo_usecases(loggedin);
            delete_photo(photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getPhotos4phototree7subject")
    @Override
    public String getPhotos4phototree7subject(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photo_usecases photousecases = new Photo_usecases(loggedin);
            return get_photo_with_externalforeignkey_phototree7subject(photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getPhotos4art_photo")
    @Override
    public String getPhotos4art_photo(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photo_usecases photousecases = new Photo_usecases(loggedin);
            return get_photo_with_externalforeignkey_art_photo(photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getPhotos4photosubjects")
    @Override
    public String getPhotos4photosubjects(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photo_usecases photousecases = new Photo_usecases(loggedin);
            return get_photo_with_externalforeignkey_photosubjects(photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getPhotos4phototags")
    @Override
    public String getPhotos4phototags(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Photo_usecases photousecases = new Photo_usecases(loggedin);
            return get_photo_with_externalforeignkey_phototags(photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


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

    private void insert_photo(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        IPhoto photo = (IPhoto)JSONPhoto.toPhoto((JSONObject)json.get("photo"));
        photousecases.insertPhoto(photo);
        setReturnstatus("OK");
    }

    private void update_photo(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        IPhoto photo = (IPhoto)JSONPhoto.toPhoto((JSONObject)json.get("photo"));
        photousecases.updatePhoto(photo);
        setReturnstatus("OK");
    }

    private void delete_photo(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        IPhoto photo = (IPhoto)JSONPhoto.toPhoto((JSONObject)json.get("photo"));
        photousecases.deletePhoto(photo);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Route(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        IRoutePK routePK = (IRoutePK)JSONRoute.toRoutePK((JSONObject)json.get("routepk"));
        photousecases.delete_all_containing_Route(routePK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Creator(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        ICreatorPK creatorPK = (ICreatorPK)JSONCreator.toCreatorPK((JSONObject)json.get("creatorpk"));
        photousecases.delete_all_containing_Creator(creatorPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Film(Photo_usecases photousecases, JSONObject json) throws ParseException, CustomException {
        IFilmPK filmPK = (IFilmPK)JSONFilm.toFilmPK((JSONObject)json.get("filmpk"));
        photousecases.delete_all_containing_Film(filmPK);
        setReturnstatus("OK");
    }

}

