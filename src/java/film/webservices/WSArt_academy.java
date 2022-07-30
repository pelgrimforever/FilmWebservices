/*
 * WSArt_academy.java
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
import film.interfaces.searchentity.IArt_academysearch;
import film.interfaces.webservice.WSIArt_academy;
import film.logicentity.Art_academy;
import film.searchentity.Art_academysearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIArt_academy")
public class WSArt_academy extends RS_json_login implements WSIArt_academy {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList art_academys) {
        JSONArray jsonart_academys = new JSONArray();
        Iterator art_academysI = art_academys.iterator();
        while(art_academysI.hasNext()) {
            jsonart_academys.add(JSONArt_academy.toJSON((Art_academy)art_academysI.next()));
        }
        return jsonart_academys;
    }

    //@WebMethod(operationName = "getArt_academys")
    @Override
    public String getArt_academys() {
        try {
            Art_academy_usecases art_academyusecases = new Art_academy_usecases(loggedin);
            return get_all_art_academy(art_academyusecases);
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
            Art_academy_usecases art_academyusecases = new Art_academy_usecases(loggedin);
            return search_art_academy(art_academyusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getArt_academy")
    @Override
    public String getArt_academy(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_academy_usecases art_academyusecases = new Art_academy_usecases(loggedin);
            return get_art_academy_with_primarykey(art_academyusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertArt_academy")
    @Override
    public void insertArt_academy(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_academy_usecases art_academyusecases = new Art_academy_usecases(loggedin);
            insert_art_academy(art_academyusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateArt_academy")
    @Override
    public void updateArt_academy(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_academy_usecases art_academyusecases = new Art_academy_usecases(loggedin);
            update_art_academy(art_academyusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteArt_academy")
    @Override
    public void deleteArt_academy(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_academy_usecases art_academyusecases = new Art_academy_usecases(loggedin);
            delete_art_academy(art_academyusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Art_academy_usecases art_academyusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", art_academyusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_art_academy(Art_academy_usecases art_academyusecases) throws ParseException, CustomException {
    	return JSONArt_academy.toJSONArray(art_academyusecases.get_all()).toJSONString();
    }
    
    private String get_art_academy_with_primarykey(Art_academy_usecases art_academyusecases, JSONObject json) throws ParseException, CustomException {
        IArt_academyPK art_academyPK = (IArt_academyPK)JSONArt_academy.toArt_academyPK((JSONObject)json.get("art_academypk"));
	return JSONArt_academy.toJSON(art_academyusecases.get_art_academy_by_primarykey(art_academyPK)).toJSONString();
    }
    
    private String search_art_academy(Art_academy_usecases art_academyusecases, JSONObject json) throws ParseException, CustomException {
        IArt_academysearch search = (IArt_academysearch)JSONArt_academy.toArt_academysearch((JSONObject)json.get("search"));
        return JSONArt_academy.toJSONArray(art_academyusecases.search_art_academy(search)).toJSONString();
    }
    
    private String search_art_academy_count(Art_academy_usecases art_academyusecases, JSONObject json) throws ParseException, CustomException {
        IArt_academysearch art_academysearch = (IArt_academysearch)JSONArt_academy.toArt_academysearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", art_academyusecases.search_art_academy_count(art_academysearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_art_academy(Art_academy_usecases art_academyusecases, JSONObject json) throws ParseException, CustomException {
        IArt_academy art_academy = (IArt_academy)JSONArt_academy.toArt_academy((JSONObject)json.get("art_academy"));
        art_academyusecases.insertArt_academy(art_academy);
        setReturnstatus("OK");
    }

    private void update_art_academy(Art_academy_usecases art_academyusecases, JSONObject json) throws ParseException, CustomException {
        IArt_academy art_academy = (IArt_academy)JSONArt_academy.toArt_academy((JSONObject)json.get("art_academy"));
        art_academyusecases.updateArt_academy(art_academy);
        setReturnstatus("OK");
    }

    private void delete_art_academy(Art_academy_usecases art_academyusecases, JSONObject json) throws ParseException, CustomException {
        IArt_academy art_academy = (IArt_academy)JSONArt_academy.toArt_academy((JSONObject)json.get("art_academy"));
        art_academyusecases.deleteArt_academy(art_academy);
        setReturnstatus("OK");
    }

}

