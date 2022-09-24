/*
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.webservices;

import base.restservices.RS_json_login;
import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.IPhototagssearch;
import film.interfaces.webservice.WSIPhototags;
import film.logicentity.Phototags;
import film.searchentity.Phototagssearch;
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

@WebService(endpointInterface = "film.interfaces.webservice.WSIPhototags")
public class WSPhototags extends RS_json_login implements WSIPhototags {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList phototagss) {
        JSONArray jsonphototagss = new JSONArray();
        Iterator phototagssI = phototagss.iterator();
        while(phototagssI.hasNext()) {
            jsonphototagss.add(JSONPhototags.toJSON((Phototags)phototagssI.next()));
        }
        return jsonphototagss;
    }

    //@WebMethod(operationName = "getPhototagss")
    @Override
    public String getPhototagss() {
        try {
            Phototags_usecases phototagsusecases = new Phototags_usecases(loggedin);
            return get_all_phototags(phototagsusecases);
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
            Phototags_usecases phototagsusecases = new Phototags_usecases(loggedin);
            return search_phototags(phototagsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getPhototags")
    @Override
    public String getPhototags(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Phototags_usecases phototagsusecases = new Phototags_usecases(loggedin);
            return get_phototags_with_primarykey(phototagsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertPhototags")
    @Override
    public void insertPhototags(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Phototags_usecases phototagsusecases = new Phototags_usecases(loggedin);
            insert_phototags(phototagsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updatePhototags")
    @Override
    public void updatePhototags(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Phototags_usecases phototagsusecases = new Phototags_usecases(loggedin);
            update_phototags(phototagsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deletePhototags")
    @Override
    public void deletePhototags(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Phototags_usecases phototagsusecases = new Phototags_usecases(loggedin);
            delete_phototags(phototagsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getPhototagss4photo")
    @Override
    public String getPhototagss4photo(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Phototags_usecases phototagsusecases = new Phototags_usecases(loggedin);
            return get_phototags_with_foreignkey_photo(phototagsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4photo")
    @Override
    public void delete4photo(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Phototags_usecases phototagsusecases = new Phototags_usecases(loggedin);
            delete_phototags(phototagsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


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

    private void insert_phototags(Phototags_usecases phototagsusecases, JSONObject json) throws ParseException, CustomException {
        IPhototags phototags = (IPhototags)JSONPhototags.toPhototags((JSONObject)json.get("phototags"));
        phototagsusecases.insertPhototags(phototags);
        setReturnstatus("OK");
    }

    private void update_phototags(Phototags_usecases phototagsusecases, JSONObject json) throws ParseException, CustomException {
        IPhototags phototags = (IPhototags)JSONPhototags.toPhototags((JSONObject)json.get("phototags"));
        phototagsusecases.updatePhototags(phototags);
        setReturnstatus("OK");
    }

    private void delete_phototags(Phototags_usecases phototagsusecases, JSONObject json) throws ParseException, CustomException {
        IPhototags phototags = (IPhototags)JSONPhototags.toPhototags((JSONObject)json.get("phototags"));
        phototagsusecases.deletePhototags(phototags);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Photo(Phototags_usecases phototagsusecases, JSONObject json) throws ParseException, CustomException {
        IPhotoPK photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
        phototagsusecases.delete_all_containing_Photo(photoPK);
        setReturnstatus("OK");
    }

}

