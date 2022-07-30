/*
 * WSCreator.java
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
import film.interfaces.searchentity.ICreatorsearch;
import film.interfaces.webservice.WSICreator;
import film.logicentity.Creator;
import film.searchentity.Creatorsearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSICreator")
public class WSCreator extends RS_json_login implements WSICreator {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList creators) {
        JSONArray jsoncreators = new JSONArray();
        Iterator creatorsI = creators.iterator();
        while(creatorsI.hasNext()) {
            jsoncreators.add(JSONCreator.toJSON((Creator)creatorsI.next()));
        }
        return jsoncreators;
    }

    //@WebMethod(operationName = "getCreators")
    @Override
    public String getCreators() {
        try {
            Creator_usecases creatorusecases = new Creator_usecases(loggedin);
            return get_all_creator(creatorusecases);
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
            Creator_usecases creatorusecases = new Creator_usecases(loggedin);
            return search_creator(creatorusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getCreator")
    @Override
    public String getCreator(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Creator_usecases creatorusecases = new Creator_usecases(loggedin);
            return get_creator_with_primarykey(creatorusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertCreator")
    @Override
    public void insertCreator(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Creator_usecases creatorusecases = new Creator_usecases(loggedin);
            insert_creator(creatorusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateCreator")
    @Override
    public void updateCreator(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Creator_usecases creatorusecases = new Creator_usecases(loggedin);
            update_creator(creatorusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteCreator")
    @Override
    public void deleteCreator(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Creator_usecases creatorusecases = new Creator_usecases(loggedin);
            delete_creator(creatorusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Creator_usecases creatorusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", creatorusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_creator(Creator_usecases creatorusecases) throws ParseException, CustomException {
    	return JSONCreator.toJSONArray(creatorusecases.get_all()).toJSONString();
    }
    
    private String get_creator_with_primarykey(Creator_usecases creatorusecases, JSONObject json) throws ParseException, CustomException {
        ICreatorPK creatorPK = (ICreatorPK)JSONCreator.toCreatorPK((JSONObject)json.get("creatorpk"));
	return JSONCreator.toJSON(creatorusecases.get_creator_by_primarykey(creatorPK)).toJSONString();
    }
    
    private String search_creator(Creator_usecases creatorusecases, JSONObject json) throws ParseException, CustomException {
        ICreatorsearch search = (ICreatorsearch)JSONCreator.toCreatorsearch((JSONObject)json.get("search"));
        return JSONCreator.toJSONArray(creatorusecases.search_creator(search)).toJSONString();
    }
    
    private String search_creator_count(Creator_usecases creatorusecases, JSONObject json) throws ParseException, CustomException {
        ICreatorsearch creatorsearch = (ICreatorsearch)JSONCreator.toCreatorsearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", creatorusecases.search_creator_count(creatorsearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_creator(Creator_usecases creatorusecases, JSONObject json) throws ParseException, CustomException {
        ICreator creator = (ICreator)JSONCreator.toCreator((JSONObject)json.get("creator"));
        creatorusecases.insertCreator(creator);
        setReturnstatus("OK");
    }

    private void update_creator(Creator_usecases creatorusecases, JSONObject json) throws ParseException, CustomException {
        ICreator creator = (ICreator)JSONCreator.toCreator((JSONObject)json.get("creator"));
        creatorusecases.updateCreator(creator);
        setReturnstatus("OK");
    }

    private void delete_creator(Creator_usecases creatorusecases, JSONObject json) throws ParseException, CustomException {
        ICreator creator = (ICreator)JSONCreator.toCreator((JSONObject)json.get("creator"));
        creatorusecases.deleteCreator(creator);
        setReturnstatus("OK");
    }

}

