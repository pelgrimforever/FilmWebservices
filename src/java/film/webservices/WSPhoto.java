/*
 * WSPhoto.java
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
import film.interfaces.webservice.WSIPhoto;
import film.logicentity.Photo;
import film.searchentity.Photosearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIPhoto")
public class WSPhoto implements WSIPhoto {

    private JSONArray toJSONArray(ArrayList photos) {
        JSONArray jsonphotos = new JSONArray();
        Iterator photosI = photos.iterator();
        while(photosI.hasNext()) {
            jsonphotos.add(JSONPhoto.toJSON((Photo)photosI.next()));
        }
        return jsonphotos;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getPhotos")
    @Override
    public String getPhotos() {
        try {
            BLphoto blphoto = new BLphoto();
            ArrayList photos = blphoto.getAll();
            JSONArray jsonphotos = toJSONArray(photos);
            return jsonphotos.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLphoto blphoto = new BLphoto();
        JSONParser parser = new JSONParser();
        String result = "";
        Photo photo;
        try {
            Photosearch photosearch = JSONPhoto.toPhotosearch((JSONObject)parser.parse(json));
            ArrayList photos = blphoto.search(photosearch);
            JSONArray jsonphotos = toJSONArray(photos);
            result = jsonphotos.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getPhoto")
    @Override
    public String getPhoto(String json) {
        BLphoto blphoto = new BLphoto();
        JSONParser parser = new JSONParser();
        String result = "";
        Photo photo;
        try {
            PhotoPK photoPK = JSONPhoto.toPhotoPK((JSONObject)parser.parse(json));
            photo = blphoto.getPhoto(photoPK);
            if(photo!=null) {
                result = JSONPhoto.toJSON(photo).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertPhoto")
    @Override
    public void insertPhoto(String json) {
        BLphoto blphoto = new BLphoto();
        JSONParser parser = new JSONParser();
        try {
            IPhoto photo = JSONPhoto.toPhoto((JSONObject)parser.parse(json));
            blphoto.insertPhoto(photo);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updatePhoto")
    @Override
    public void updatePhoto(String json) {
        BLphoto blphoto = new BLphoto();
        JSONParser parser = new JSONParser();
        try {
            IPhoto photo = JSONPhoto.toPhoto((JSONObject)parser.parse(json));
            blphoto.updatePhoto(photo);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deletePhoto")
    @Override
    public void deletePhoto(String json) {
        BLphoto blphoto = new BLphoto();
        JSONParser parser = new JSONParser();
        try {
            IPhoto photo = JSONPhoto.toPhoto((JSONObject)parser.parse(json));
            blphoto.deletePhoto(photo);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getPhotos4route")
    @Override
    public String getPhotos4route(String json) {
        BLphoto blphoto = new BLphoto();
        JSONParser parser = new JSONParser();
        Photo photo;
        try {
            IRoutePK routePK = JSONRoute.toRoutePK((JSONObject)parser.parse(json));
            ArrayList photos = blphoto.getPhotos4route(routePK);
            JSONArray jsonphotos = toJSONArray(photos);
            return jsonphotos.toJSONString();
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

    //@WebMethod(operationName = "delete4route")
    @Override
    public void delete4route(String json) {
        BLphoto blphoto = new BLphoto();
        JSONParser parser = new JSONParser();
        Photo photo;
        try {
            IRoutePK routePK = JSONRoute.toRoutePK((JSONObject)parser.parse(json));
            blphoto.delete4route(routePK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getPhotos4creator")
    @Override
    public String getPhotos4creator(String json) {
        BLphoto blphoto = new BLphoto();
        JSONParser parser = new JSONParser();
        Photo photo;
        try {
            ICreatorPK creatorPK = JSONCreator.toCreatorPK((JSONObject)parser.parse(json));
            ArrayList photos = blphoto.getPhotos4creator(creatorPK);
            JSONArray jsonphotos = toJSONArray(photos);
            return jsonphotos.toJSONString();
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

    //@WebMethod(operationName = "delete4creator")
    @Override
    public void delete4creator(String json) {
        BLphoto blphoto = new BLphoto();
        JSONParser parser = new JSONParser();
        Photo photo;
        try {
            ICreatorPK creatorPK = JSONCreator.toCreatorPK((JSONObject)parser.parse(json));
            blphoto.delete4creator(creatorPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getPhotos4film")
    @Override
    public String getPhotos4film(String json) {
        BLphoto blphoto = new BLphoto();
        JSONParser parser = new JSONParser();
        Photo photo;
        try {
            IFilmPK filmPK = JSONFilm.toFilmPK((JSONObject)parser.parse(json));
            ArrayList photos = blphoto.getPhotos4film(filmPK);
            JSONArray jsonphotos = toJSONArray(photos);
            return jsonphotos.toJSONString();
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

    //@WebMethod(operationName = "delete4film")
    @Override
    public void delete4film(String json) {
        BLphoto blphoto = new BLphoto();
        JSONParser parser = new JSONParser();
        Photo photo;
        try {
            IFilmPK filmPK = JSONFilm.toFilmPK((JSONObject)parser.parse(json));
            blphoto.delete4film(filmPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getPhotos4phototree7subject")
    @Override
    public String getPhotos4phototree7subject(String json) {
        BLphoto blphoto = new BLphoto();
        JSONParser parser = new JSONParser();
        Photo photo;
        try {
            String result = null;
            IPhototree7subjectPK phototree7subjectPK = JSONPhototree7subject.toPhototree7subjectPK((JSONObject)parser.parse(json));
            photo = (Photo)blphoto.getPhototree7subject(phototree7subjectPK);
            if(photo!=null) {
                result = JSONPhoto.toJSON(photo).toJSONString();
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

    //@WebMethod(operationName = "getPhotos4art_photo")
    @Override
    public String getPhotos4art_photo(String json) {
        BLphoto blphoto = new BLphoto();
        JSONParser parser = new JSONParser();
        Photo photo;
        try {
            String result = null;
            IArt_photoPK art_photoPK = JSONArt_photo.toArt_photoPK((JSONObject)parser.parse(json));
            photo = (Photo)blphoto.getArt_photo(art_photoPK);
            if(photo!=null) {
                result = JSONPhoto.toJSON(photo).toJSONString();
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

    //@WebMethod(operationName = "getPhotos4photosubjects")
    @Override
    public String getPhotos4photosubjects(String json) {
        BLphoto blphoto = new BLphoto();
        JSONParser parser = new JSONParser();
        Photo photo;
        try {
            String result = null;
            IPhotosubjectsPK photosubjectsPK = JSONPhotosubjects.toPhotosubjectsPK((JSONObject)parser.parse(json));
            photo = (Photo)blphoto.getPhotosubjects(photosubjectsPK);
            if(photo!=null) {
                result = JSONPhoto.toJSON(photo).toJSONString();
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

    //@WebMethod(operationName = "getPhotos4phototags")
    @Override
    public String getPhotos4phototags(String json) {
        BLphoto blphoto = new BLphoto();
        JSONParser parser = new JSONParser();
        Photo photo;
        try {
            String result = null;
            IPhototagsPK phototagsPK = JSONPhototags.toPhototagsPK((JSONObject)parser.parse(json));
            photo = (Photo)blphoto.getPhototags(phototagsPK);
            if(photo!=null) {
                result = JSONPhoto.toJSON(photo).toJSONString();
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

