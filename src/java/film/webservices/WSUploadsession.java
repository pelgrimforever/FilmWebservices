/*
 * WSUploadsession.java
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
import film.interfaces.searchentity.IUploadsessionsearch;
import film.interfaces.webservice.WSIUploadsession;
import film.logicentity.Uploadsession;
import film.searchentity.Uploadsessionsearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIUploadsession")
public class WSUploadsession extends RS_json_login implements WSIUploadsession {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList uploadsessions) {
        JSONArray jsonuploadsessions = new JSONArray();
        Iterator uploadsessionsI = uploadsessions.iterator();
        while(uploadsessionsI.hasNext()) {
            jsonuploadsessions.add(JSONUploadsession.toJSON((Uploadsession)uploadsessionsI.next()));
        }
        return jsonuploadsessions;
    }

    //@WebMethod(operationName = "getUploadsessions")
    @Override
    public String getUploadsessions() {
        try {
            Uploadsession_usecases uploadsessionusecases = new Uploadsession_usecases(loggedin);
            return get_all_uploadsession(uploadsessionusecases);
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
            Uploadsession_usecases uploadsessionusecases = new Uploadsession_usecases(loggedin);
            return search_uploadsession(uploadsessionusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getUploadsession")
    @Override
    public String getUploadsession(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Uploadsession_usecases uploadsessionusecases = new Uploadsession_usecases(loggedin);
            return get_uploadsession_with_primarykey(uploadsessionusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertUploadsession")
    @Override
    public void insertUploadsession(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Uploadsession_usecases uploadsessionusecases = new Uploadsession_usecases(loggedin);
            insert_uploadsession(uploadsessionusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateUploadsession")
    @Override
    public void updateUploadsession(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Uploadsession_usecases uploadsessionusecases = new Uploadsession_usecases(loggedin);
            update_uploadsession(uploadsessionusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteUploadsession")
    @Override
    public void deleteUploadsession(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Uploadsession_usecases uploadsessionusecases = new Uploadsession_usecases(loggedin);
            delete_uploadsession(uploadsessionusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getUploadsessions4creator")
    @Override
    public String getUploadsessions4creator(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Uploadsession_usecases uploadsessionusecases = new Uploadsession_usecases(loggedin);
            return get_uploadsession_with_foreignkey_creator(uploadsessionusecases, json);
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
            Uploadsession_usecases uploadsessionusecases = new Uploadsession_usecases(loggedin);
            delete_uploadsession(uploadsessionusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Uploadsession_usecases uploadsessionusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", uploadsessionusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_uploadsession(Uploadsession_usecases uploadsessionusecases) throws ParseException, CustomException {
    	return JSONUploadsession.toJSONArray(uploadsessionusecases.get_all()).toJSONString();
    }
    
    private String get_uploadsession_with_primarykey(Uploadsession_usecases uploadsessionusecases, JSONObject json) throws ParseException, CustomException {
        IUploadsessionPK uploadsessionPK = (IUploadsessionPK)JSONUploadsession.toUploadsessionPK((JSONObject)json.get("uploadsessionpk"));
	return JSONUploadsession.toJSON(uploadsessionusecases.get_uploadsession_by_primarykey(uploadsessionPK)).toJSONString();
    }
    
    private String get_uploadsession_with_foreignkey_creator(Uploadsession_usecases uploadsessionusecases, JSONObject json) throws ParseException, CustomException {
        ICreatorPK creatorPK = (ICreatorPK)JSONCreator.toCreatorPK((JSONObject)json.get("creatorpk"));
        return JSONUploadsession.toJSONArray(uploadsessionusecases.get_uploadsession_with_foreignkey_creator(creatorPK)).toJSONString();
    }
    
    private String search_uploadsession(Uploadsession_usecases uploadsessionusecases, JSONObject json) throws ParseException, CustomException {
        IUploadsessionsearch search = (IUploadsessionsearch)JSONUploadsession.toUploadsessionsearch((JSONObject)json.get("search"));
        return JSONUploadsession.toJSONArray(uploadsessionusecases.search_uploadsession(search)).toJSONString();
    }
    
    private String search_uploadsession_count(Uploadsession_usecases uploadsessionusecases, JSONObject json) throws ParseException, CustomException {
        IUploadsessionsearch uploadsessionsearch = (IUploadsessionsearch)JSONUploadsession.toUploadsessionsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", uploadsessionusecases.search_uploadsession_count(uploadsessionsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_uploadsession(Uploadsession_usecases uploadsessionusecases, JSONObject json) throws ParseException, CustomException {
        IUploadsession uploadsession = (IUploadsession)JSONUploadsession.toUploadsession((JSONObject)json.get("uploadsession"));
        uploadsessionusecases.insertUploadsession(uploadsession);
        setReturnstatus("OK");
    }

    private void update_uploadsession(Uploadsession_usecases uploadsessionusecases, JSONObject json) throws ParseException, CustomException {
        IUploadsession uploadsession = (IUploadsession)JSONUploadsession.toUploadsession((JSONObject)json.get("uploadsession"));
        uploadsessionusecases.updateUploadsession(uploadsession);
        setReturnstatus("OK");
    }

    private void delete_uploadsession(Uploadsession_usecases uploadsessionusecases, JSONObject json) throws ParseException, CustomException {
        IUploadsession uploadsession = (IUploadsession)JSONUploadsession.toUploadsession((JSONObject)json.get("uploadsession"));
        uploadsessionusecases.deleteUploadsession(uploadsession);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Creator(Uploadsession_usecases uploadsessionusecases, JSONObject json) throws ParseException, CustomException {
        ICreatorPK creatorPK = (ICreatorPK)JSONCreator.toCreatorPK((JSONObject)json.get("creatorpk"));
        uploadsessionusecases.delete_all_containing_Creator(creatorPK);
        setReturnstatus("OK");
    }

}

