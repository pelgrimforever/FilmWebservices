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
import film.interfaces.searchentity.IArt_subgroupsearch;
import film.interfaces.webservice.WSIArt_subgroup;
import film.logicentity.Art_subgroup;
import film.searchentity.Art_subgroupsearch;
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

@WebService(endpointInterface = "film.interfaces.webservice.WSIArt_subgroup")
public class WSArt_subgroup extends RS_json_login implements WSIArt_subgroup {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList art_subgroups) {
        JSONArray jsonart_subgroups = new JSONArray();
        Iterator art_subgroupsI = art_subgroups.iterator();
        while(art_subgroupsI.hasNext()) {
            jsonart_subgroups.add(JSONArt_subgroup.toJSON((Art_subgroup)art_subgroupsI.next()));
        }
        return jsonart_subgroups;
    }

    //@WebMethod(operationName = "getArt_subgroups")
    @Override
    public String getArt_subgroups() {
        try {
            Art_subgroup_usecases art_subgroupusecases = new Art_subgroup_usecases(loggedin);
            return get_all_art_subgroup(art_subgroupusecases);
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
            Art_subgroup_usecases art_subgroupusecases = new Art_subgroup_usecases(loggedin);
            return search_art_subgroup(art_subgroupusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getArt_subgroup")
    @Override
    public String getArt_subgroup(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_subgroup_usecases art_subgroupusecases = new Art_subgroup_usecases(loggedin);
            return get_art_subgroup_with_primarykey(art_subgroupusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertArt_subgroup")
    @Override
    public void insertArt_subgroup(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_subgroup_usecases art_subgroupusecases = new Art_subgroup_usecases(loggedin);
            insert_art_subgroup(art_subgroupusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateArt_subgroup")
    @Override
    public void updateArt_subgroup(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_subgroup_usecases art_subgroupusecases = new Art_subgroup_usecases(loggedin);
            update_art_subgroup(art_subgroupusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteArt_subgroup")
    @Override
    public void deleteArt_subgroup(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_subgroup_usecases art_subgroupusecases = new Art_subgroup_usecases(loggedin);
            delete_art_subgroup(art_subgroupusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getArt_subgroups4art_group")
    @Override
    public String getArt_subgroups4art_group(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Art_subgroup_usecases art_subgroupusecases = new Art_subgroup_usecases(loggedin);
            return get_art_subgroup_with_foreignkey_art_group(art_subgroupusecases, json);
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
            Art_subgroup_usecases art_subgroupusecases = new Art_subgroup_usecases(loggedin);
            delete_art_subgroup(art_subgroupusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Art_subgroup_usecases art_subgroupusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", art_subgroupusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_art_subgroup(Art_subgroup_usecases art_subgroupusecases) throws ParseException, CustomException {
    	return JSONArt_subgroup.toJSONArray(art_subgroupusecases.get_all()).toJSONString();
    }
    
    private String get_art_subgroup_with_primarykey(Art_subgroup_usecases art_subgroupusecases, JSONObject json) throws ParseException, CustomException {
        IArt_subgroupPK art_subgroupPK = (IArt_subgroupPK)JSONArt_subgroup.toArt_subgroupPK((JSONObject)json.get("art_subgrouppk"));
	return JSONArt_subgroup.toJSON(art_subgroupusecases.get_art_subgroup_by_primarykey(art_subgroupPK)).toJSONString();
    }
    
    private String get_art_subgroup_with_foreignkey_art_group(Art_subgroup_usecases art_subgroupusecases, JSONObject json) throws ParseException, CustomException {
        IArt_groupPK art_groupPK = (IArt_groupPK)JSONArt_group.toArt_groupPK((JSONObject)json.get("art_grouppk"));
        return JSONArt_subgroup.toJSONArray(art_subgroupusecases.get_art_subgroup_with_foreignkey_art_group(art_groupPK)).toJSONString();
    }
    
    private String search_art_subgroup(Art_subgroup_usecases art_subgroupusecases, JSONObject json) throws ParseException, CustomException {
        IArt_subgroupsearch search = (IArt_subgroupsearch)JSONArt_subgroup.toArt_subgroupsearch((JSONObject)json.get("search"));
        return JSONArt_subgroup.toJSONArray(art_subgroupusecases.search_art_subgroup(search)).toJSONString();
    }
    
    private String search_art_subgroup_count(Art_subgroup_usecases art_subgroupusecases, JSONObject json) throws ParseException, CustomException {
        IArt_subgroupsearch art_subgroupsearch = (IArt_subgroupsearch)JSONArt_subgroup.toArt_subgroupsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", art_subgroupusecases.search_art_subgroup_count(art_subgroupsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_art_subgroup(Art_subgroup_usecases art_subgroupusecases, JSONObject json) throws ParseException, CustomException {
        IArt_subgroup art_subgroup = (IArt_subgroup)JSONArt_subgroup.toArt_subgroup((JSONObject)json.get("art_subgroup"));
        art_subgroupusecases.insertArt_subgroup(art_subgroup);
        setReturnstatus("OK");
    }

    private void update_art_subgroup(Art_subgroup_usecases art_subgroupusecases, JSONObject json) throws ParseException, CustomException {
        IArt_subgroup art_subgroup = (IArt_subgroup)JSONArt_subgroup.toArt_subgroup((JSONObject)json.get("art_subgroup"));
        art_subgroupusecases.updateArt_subgroup(art_subgroup);
        setReturnstatus("OK");
    }

    private void delete_art_subgroup(Art_subgroup_usecases art_subgroupusecases, JSONObject json) throws ParseException, CustomException {
        IArt_subgroup art_subgroup = (IArt_subgroup)JSONArt_subgroup.toArt_subgroup((JSONObject)json.get("art_subgroup"));
        art_subgroupusecases.deleteArt_subgroup(art_subgroup);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Art_group(Art_subgroup_usecases art_subgroupusecases, JSONObject json) throws ParseException, CustomException {
        IArt_groupPK art_groupPK = (IArt_groupPK)JSONArt_group.toArt_groupPK((JSONObject)json.get("art_grouppk"));
        art_subgroupusecases.delete_all_containing_Art_group(art_groupPK);
        setReturnstatus("OK");
    }

}

