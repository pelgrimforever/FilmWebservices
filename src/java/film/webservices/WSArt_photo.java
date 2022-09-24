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
import film.interfaces.searchentity.IArt_photosearch;
import film.interfaces.webservice.WSIArt_photo;
import film.logicentity.Art_photo;
import film.searchentity.Art_photosearch;
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

@WebService(endpointInterface = "film.interfaces.webservice.WSIArt_photo")
public class WSArt_photo extends RS_json_login implements WSIArt_photo {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList art_photos) {
        JSONArray jsonart_photos = new JSONArray();
        Iterator art_photosI = art_photos.iterator();
        while(art_photosI.hasNext()) {
            jsonart_photos.add(JSONArt_photo.toJSON((Art_photo)art_photosI.next()));
        }
        return jsonart_photos;
    }

    //@WebMethod(operationName = "getArt_photos")
    @Override
    public String getArt_photos() {
        try {
            Art_photo_usecases art_photousecases = new Art_photo_usecases(loggedin);
            return get_all_art_photo(art_photousecases);
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
            Art_photo_usecases art_photousecases = new Art_photo_usecases(loggedin);
            return search_art_photo(art_photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getArt_photo")
    @Override
    public String getArt_photo(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_photo_usecases art_photousecases = new Art_photo_usecases(loggedin);
            return get_art_photo_with_primarykey(art_photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertArt_photo")
    @Override
    public void insertArt_photo(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_photo_usecases art_photousecases = new Art_photo_usecases(loggedin);
            insert_art_photo(art_photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateArt_photo")
    @Override
    public void updateArt_photo(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_photo_usecases art_photousecases = new Art_photo_usecases(loggedin);
            update_art_photo(art_photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteArt_photo")
    @Override
    public void deleteArt_photo(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_photo_usecases art_photousecases = new Art_photo_usecases(loggedin);
            delete_art_photo(art_photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getArt_photos4photo")
    @Override
    public String getArt_photos4photo(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_photo_usecases art_photousecases = new Art_photo_usecases(loggedin);
            return get_art_photo_with_foreignkey_photo(art_photousecases, json);
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
            Art_photo_usecases art_photousecases = new Art_photo_usecases(loggedin);
            delete_art_photo(art_photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getArt_photos4art_subgroup")
    @Override
    public String getArt_photos4art_subgroup(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_photo_usecases art_photousecases = new Art_photo_usecases(loggedin);
            return get_art_photo_with_foreignkey_art_subgroup(art_photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4art_subgroup")
    @Override
    public void delete4art_subgroup(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_photo_usecases art_photousecases = new Art_photo_usecases(loggedin);
            delete_art_photo(art_photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getArt_photos4art_academy")
    @Override
    public String getArt_photos4art_academy(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_photo_usecases art_photousecases = new Art_photo_usecases(loggedin);
            return get_art_photo_with_foreignkey_art_academy(art_photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4art_academy")
    @Override
    public void delete4art_academy(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_photo_usecases art_photousecases = new Art_photo_usecases(loggedin);
            delete_art_photo(art_photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getArt_photos4art_group")
    @Override
    public String getArt_photos4art_group(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_photo_usecases art_photousecases = new Art_photo_usecases(loggedin);
            return get_art_photo_with_foreignkey_art_group(art_photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4art_group")
    @Override
    public void delete4art_group(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_photo_usecases art_photousecases = new Art_photo_usecases(loggedin);
            delete_art_photo(art_photousecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


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

    private void insert_art_photo(Art_photo_usecases art_photousecases, JSONObject json) throws ParseException, CustomException {
        IArt_photo art_photo = (IArt_photo)JSONArt_photo.toArt_photo((JSONObject)json.get("art_photo"));
        art_photousecases.insertArt_photo(art_photo);
        setReturnstatus("OK");
    }

    private void update_art_photo(Art_photo_usecases art_photousecases, JSONObject json) throws ParseException, CustomException {
        IArt_photo art_photo = (IArt_photo)JSONArt_photo.toArt_photo((JSONObject)json.get("art_photo"));
        art_photousecases.updateArt_photo(art_photo);
        setReturnstatus("OK");
    }

    private void delete_art_photo(Art_photo_usecases art_photousecases, JSONObject json) throws ParseException, CustomException {
        IArt_photo art_photo = (IArt_photo)JSONArt_photo.toArt_photo((JSONObject)json.get("art_photo"));
        art_photousecases.deleteArt_photo(art_photo);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Photo(Art_photo_usecases art_photousecases, JSONObject json) throws ParseException, CustomException {
        IPhotoPK photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
        art_photousecases.delete_all_containing_Photo(photoPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Art_subgroup(Art_photo_usecases art_photousecases, JSONObject json) throws ParseException, CustomException {
        IArt_subgroupPK art_subgroupPK = (IArt_subgroupPK)JSONArt_subgroup.toArt_subgroupPK((JSONObject)json.get("art_subgrouppk"));
        art_photousecases.delete_all_containing_Art_subgroup(art_subgroupPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Art_academy(Art_photo_usecases art_photousecases, JSONObject json) throws ParseException, CustomException {
        IArt_academyPK art_academyPK = (IArt_academyPK)JSONArt_academy.toArt_academyPK((JSONObject)json.get("art_academypk"));
        art_photousecases.delete_all_containing_Art_academy(art_academyPK);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Art_group(Art_photo_usecases art_photousecases, JSONObject json) throws ParseException, CustomException {
        IArt_groupPK art_groupPK = (IArt_groupPK)JSONArt_group.toArt_groupPK((JSONObject)json.get("art_grouppk"));
        art_photousecases.delete_all_containing_Art_group(art_groupPK);
        setReturnstatus("OK");
    }

}

