/*
 * WSArt_group.java
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
import film.interfaces.searchentity.IArt_groupsearch;
import film.interfaces.webservice.WSIArt_group;
import film.logicentity.Art_group;
import film.searchentity.Art_groupsearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIArt_group")
public class WSArt_group extends RS_json_login implements WSIArt_group {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList art_groups) {
        JSONArray jsonart_groups = new JSONArray();
        Iterator art_groupsI = art_groups.iterator();
        while(art_groupsI.hasNext()) {
            jsonart_groups.add(JSONArt_group.toJSON((Art_group)art_groupsI.next()));
        }
        return jsonart_groups;
    }

    //@WebMethod(operationName = "getArt_groups")
    @Override
    public String getArt_groups() {
        try {
            Art_group_usecases art_groupusecases = new Art_group_usecases(loggedin);
            return get_all_art_group(art_groupusecases);
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
            Art_group_usecases art_groupusecases = new Art_group_usecases(loggedin);
            return search_art_group(art_groupusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getArt_group")
    @Override
    public String getArt_group(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_group_usecases art_groupusecases = new Art_group_usecases(loggedin);
            return get_art_group_with_primarykey(art_groupusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertArt_group")
    @Override
    public void insertArt_group(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_group_usecases art_groupusecases = new Art_group_usecases(loggedin);
            insert_art_group(art_groupusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateArt_group")
    @Override
    public void updateArt_group(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_group_usecases art_groupusecases = new Art_group_usecases(loggedin);
            update_art_group(art_groupusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteArt_group")
    @Override
    public void deleteArt_group(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_group_usecases art_groupusecases = new Art_group_usecases(loggedin);
            delete_art_group(art_groupusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Art_group_usecases art_groupusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", art_groupusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_art_group(Art_group_usecases art_groupusecases) throws ParseException, CustomException {
    	return JSONArt_group.toJSONArray(art_groupusecases.get_all()).toJSONString();
    }
    
    private String get_art_group_with_primarykey(Art_group_usecases art_groupusecases, JSONObject json) throws ParseException, CustomException {
        IArt_groupPK art_groupPK = (IArt_groupPK)JSONArt_group.toArt_groupPK((JSONObject)json.get("art_grouppk"));
	return JSONArt_group.toJSON(art_groupusecases.get_art_group_by_primarykey(art_groupPK)).toJSONString();
    }
    
    private String search_art_group(Art_group_usecases art_groupusecases, JSONObject json) throws ParseException, CustomException {
        IArt_groupsearch search = (IArt_groupsearch)JSONArt_group.toArt_groupsearch((JSONObject)json.get("search"));
        return JSONArt_group.toJSONArray(art_groupusecases.search_art_group(search)).toJSONString();
    }
    
    private String search_art_group_count(Art_group_usecases art_groupusecases, JSONObject json) throws ParseException, CustomException {
        IArt_groupsearch art_groupsearch = (IArt_groupsearch)JSONArt_group.toArt_groupsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", art_groupusecases.search_art_group_count(art_groupsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_art_group(Art_group_usecases art_groupusecases, JSONObject json) throws ParseException, CustomException {
        IArt_group art_group = (IArt_group)JSONArt_group.toArt_group((JSONObject)json.get("art_group"));
        art_groupusecases.insertArt_group(art_group);
        setReturnstatus("OK");
    }

    private void update_art_group(Art_group_usecases art_groupusecases, JSONObject json) throws ParseException, CustomException {
        IArt_group art_group = (IArt_group)JSONArt_group.toArt_group((JSONObject)json.get("art_group"));
        art_groupusecases.updateArt_group(art_group);
        setReturnstatus("OK");
    }

    private void delete_art_group(Art_group_usecases art_groupusecases, JSONObject json) throws ParseException, CustomException {
        IArt_group art_group = (IArt_group)JSONArt_group.toArt_group((JSONObject)json.get("art_group"));
        art_groupusecases.deleteArt_group(art_group);
        setReturnstatus("OK");
    }

}

