/*
 * WSArt_photo.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 *
 */

package film.webservices;

import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.webservice.WSIArt_photo;
import film.logicentity.Art_photo;
import film.searchentity.Art_photosearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIArt_photo")
public class WSArt_photo implements WSIArt_photo {

    private JSONArray toJSONArray(ArrayList art_photos) {
        JSONArray jsonart_photos = new JSONArray();
        Iterator art_photosI = art_photos.iterator();
        while(art_photosI.hasNext()) {
            jsonart_photos.add(JSONArt_photo.toJSON((Art_photo)art_photosI.next()));
        }
        return jsonart_photos;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getArt_photos")
    @Override
    public String getArt_photos() {
        try {
            BLart_photo blart_photo = new BLart_photo();
            ArrayList art_photos = blart_photo.getAll();
            JSONArray jsonart_photos = toJSONArray(art_photos);
            return jsonart_photos.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLart_photo blart_photo = new BLart_photo();
        JSONParser parser = new JSONParser();
        String result = "";
        Art_photo art_photo;
        try {
            Art_photosearch art_photosearch = JSONArt_photo.toArt_photosearch((JSONObject)parser.parse(json));
            ArrayList art_photos = blart_photo.search(art_photosearch);
            JSONArray jsonart_photos = toJSONArray(art_photos);
            result = jsonart_photos.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getArt_photo")
    @Override
    public String getArt_photo(String json) {
        BLart_photo blart_photo = new BLart_photo();
        JSONParser parser = new JSONParser();
        String result = "";
        Art_photo art_photo;
        try {
            Art_photoPK art_photoPK = JSONArt_photo.toArt_photoPK((JSONObject)parser.parse(json));
            art_photo = blart_photo.getArt_photo(art_photoPK);
            if(art_photo!=null) {
                result = JSONArt_photo.toJSON(art_photo).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertArt_photo")
    @Override
    public void insertArt_photo(String json) {
        BLart_photo blart_photo = new BLart_photo();
        JSONParser parser = new JSONParser();
        try {
            IArt_photo art_photo = JSONArt_photo.toArt_photo((JSONObject)parser.parse(json));
            blart_photo.insertArt_photo(art_photo);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateArt_photo")
    @Override
    public void updateArt_photo(String json) {
        BLart_photo blart_photo = new BLart_photo();
        JSONParser parser = new JSONParser();
        try {
            IArt_photo art_photo = JSONArt_photo.toArt_photo((JSONObject)parser.parse(json));
            blart_photo.updateArt_photo(art_photo);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteArt_photo")
    @Override
    public void deleteArt_photo(String json) {
        BLart_photo blart_photo = new BLart_photo();
        JSONParser parser = new JSONParser();
        try {
            IArt_photo art_photo = JSONArt_photo.toArt_photo((JSONObject)parser.parse(json));
            blart_photo.deleteArt_photo(art_photo);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getArt_photos4photo")
    @Override
    public String getArt_photos4photo(String json) {
        BLart_photo blart_photo = new BLart_photo();
        JSONParser parser = new JSONParser();
        Art_photo art_photo;
        try {
            IPhotoPK photoPK = JSONPhoto.toPhotoPK((JSONObject)parser.parse(json));
            ArrayList art_photos = blart_photo.getArt_photos4photo(photoPK);
            JSONArray jsonart_photos = toJSONArray(art_photos);
            return jsonart_photos.toJSONString();
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

    //@WebMethod(operationName = "delete4photo")
    @Override
    public void delete4photo(String json) {
        BLart_photo blart_photo = new BLart_photo();
        JSONParser parser = new JSONParser();
        Art_photo art_photo;
        try {
            IPhotoPK photoPK = JSONPhoto.toPhotoPK((JSONObject)parser.parse(json));
            blart_photo.delete4photo(photoPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getArt_photos4art_subgroup")
    @Override
    public String getArt_photos4art_subgroup(String json) {
        BLart_photo blart_photo = new BLart_photo();
        JSONParser parser = new JSONParser();
        Art_photo art_photo;
        try {
            IArt_subgroupPK art_subgroupPK = JSONArt_subgroup.toArt_subgroupPK((JSONObject)parser.parse(json));
            ArrayList art_photos = blart_photo.getArt_photos4art_subgroup(art_subgroupPK);
            JSONArray jsonart_photos = toJSONArray(art_photos);
            return jsonart_photos.toJSONString();
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

    //@WebMethod(operationName = "delete4art_subgroup")
    @Override
    public void delete4art_subgroup(String json) {
        BLart_photo blart_photo = new BLart_photo();
        JSONParser parser = new JSONParser();
        Art_photo art_photo;
        try {
            IArt_subgroupPK art_subgroupPK = JSONArt_subgroup.toArt_subgroupPK((JSONObject)parser.parse(json));
            blart_photo.delete4art_subgroup(art_subgroupPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getArt_photos4art_academy")
    @Override
    public String getArt_photos4art_academy(String json) {
        BLart_photo blart_photo = new BLart_photo();
        JSONParser parser = new JSONParser();
        Art_photo art_photo;
        try {
            IArt_academyPK art_academyPK = JSONArt_academy.toArt_academyPK((JSONObject)parser.parse(json));
            ArrayList art_photos = blart_photo.getArt_photos4art_academy(art_academyPK);
            JSONArray jsonart_photos = toJSONArray(art_photos);
            return jsonart_photos.toJSONString();
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

    //@WebMethod(operationName = "delete4art_academy")
    @Override
    public void delete4art_academy(String json) {
        BLart_photo blart_photo = new BLart_photo();
        JSONParser parser = new JSONParser();
        Art_photo art_photo;
        try {
            IArt_academyPK art_academyPK = JSONArt_academy.toArt_academyPK((JSONObject)parser.parse(json));
            blart_photo.delete4art_academy(art_academyPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getArt_photos4art_group")
    @Override
    public String getArt_photos4art_group(String json) {
        BLart_photo blart_photo = new BLart_photo();
        JSONParser parser = new JSONParser();
        Art_photo art_photo;
        try {
            IArt_groupPK art_groupPK = JSONArt_group.toArt_groupPK((JSONObject)parser.parse(json));
            ArrayList art_photos = blart_photo.getArt_photos4art_group(art_groupPK);
            JSONArray jsonart_photos = toJSONArray(art_photos);
            return jsonart_photos.toJSONString();
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

    //@WebMethod(operationName = "delete4art_group")
    @Override
    public void delete4art_group(String json) {
        BLart_photo blart_photo = new BLart_photo();
        JSONParser parser = new JSONParser();
        Art_photo art_photo;
        try {
            IArt_groupPK art_groupPK = JSONArt_group.toArt_groupPK((JSONObject)parser.parse(json));
            blart_photo.delete4art_group(art_groupPK);
        }
        catch(ParseException e) {
        }
    }


}

