/*
 * WSPhototags.java
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
import film.interfaces.webservice.WSIPhototags;
import film.logicentity.Phototags;
import film.searchentity.Phototagssearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIPhototags")
public class WSPhototags implements WSIPhototags {

    private JSONArray toJSONArray(ArrayList phototagss) {
        JSONArray jsonphototagss = new JSONArray();
        Iterator phototagssI = phototagss.iterator();
        while(phototagssI.hasNext()) {
            jsonphototagss.add(JSONPhototags.toJSON((Phototags)phototagssI.next()));
        }
        return jsonphototagss;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getPhototagss")
    @Override
    public String getPhototagss() {
        try {
            BLphototags blphototags = new BLphototags();
            ArrayList phototagss = blphototags.getAll();
            JSONArray jsonphototagss = toJSONArray(phototagss);
            return jsonphototagss.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLphototags blphototags = new BLphototags();
        JSONParser parser = new JSONParser();
        String result = "";
        Phototags phototags;
        try {
            Phototagssearch phototagssearch = JSONPhototags.toPhototagssearch((JSONObject)parser.parse(json));
            ArrayList phototagss = blphototags.search(phototagssearch);
            JSONArray jsonphototagss = toJSONArray(phototagss);
            result = jsonphototagss.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getPhototags")
    @Override
    public String getPhototags(String json) {
        BLphototags blphototags = new BLphototags();
        JSONParser parser = new JSONParser();
        String result = "";
        Phototags phototags;
        try {
            PhototagsPK phototagsPK = JSONPhototags.toPhototagsPK((JSONObject)parser.parse(json));
            phototags = blphototags.getPhototags(phototagsPK);
            if(phototags!=null) {
                result = JSONPhototags.toJSON(phototags).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertPhototags")
    @Override
    public void insertPhototags(String json) {
        BLphototags blphototags = new BLphototags();
        JSONParser parser = new JSONParser();
        try {
            IPhototags phototags = JSONPhototags.toPhototags((JSONObject)parser.parse(json));
            blphototags.insertPhototags(phototags);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updatePhototags")
    @Override
    public void updatePhototags(String json) {
        BLphototags blphototags = new BLphototags();
        JSONParser parser = new JSONParser();
        try {
            IPhototags phototags = JSONPhototags.toPhototags((JSONObject)parser.parse(json));
            blphototags.updatePhototags(phototags);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deletePhototags")
    @Override
    public void deletePhototags(String json) {
        BLphototags blphototags = new BLphototags();
        JSONParser parser = new JSONParser();
        try {
            IPhototags phototags = JSONPhototags.toPhototags((JSONObject)parser.parse(json));
            blphototags.deletePhototags(phototags);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getPhototagss4photo")
    @Override
    public String getPhototagss4photo(String json) {
        BLphototags blphototags = new BLphototags();
        JSONParser parser = new JSONParser();
        Phototags phototags;
        try {
            IPhotoPK photoPK = JSONPhoto.toPhotoPK((JSONObject)parser.parse(json));
            ArrayList phototagss = blphototags.getPhototagss4photo(photoPK);
            JSONArray jsonphototagss = toJSONArray(phototagss);
            return jsonphototagss.toJSONString();
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
        BLphototags blphototags = new BLphototags();
        JSONParser parser = new JSONParser();
        Phototags phototags;
        try {
            IPhotoPK photoPK = JSONPhoto.toPhotoPK((JSONObject)parser.parse(json));
            blphototags.delete4photo(photoPK);
        }
        catch(ParseException e) {
        }
    }


}

