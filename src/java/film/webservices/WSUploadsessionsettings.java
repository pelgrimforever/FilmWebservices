/*
 * WSUploadsessionsettings.java
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
import film.interfaces.searchentity.IUploadsessionsettingssearch;
import film.interfaces.webservice.WSIUploadsessionsettings;
import film.logicentity.Uploadsessionsettings;
import film.searchentity.Uploadsessionsettingssearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIUploadsessionsettings")
public class WSUploadsessionsettings extends RS_json_login implements WSIUploadsessionsettings {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList uploadsessionsettingss) {
        JSONArray jsonuploadsessionsettingss = new JSONArray();
        Iterator uploadsessionsettingssI = uploadsessionsettingss.iterator();
        while(uploadsessionsettingssI.hasNext()) {
            jsonuploadsessionsettingss.add(JSONUploadsessionsettings.toJSON((Uploadsessionsettings)uploadsessionsettingssI.next()));
        }
        return jsonuploadsessionsettingss;
    }

    //@WebMethod(operationName = "getUploadsessionsettingss")
    @Override
    public String getUploadsessionsettingss() {
        try {
            Uploadsessionsettings_usecases uploadsessionsettingsusecases = new Uploadsessionsettings_usecases(loggedin);
            return get_all_uploadsessionsettings(uploadsessionsettingsusecases);
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
            Uploadsessionsettings_usecases uploadsessionsettingsusecases = new Uploadsessionsettings_usecases(loggedin);
            return search_uploadsessionsettings(uploadsessionsettingsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getUploadsessionsettings")
    @Override
    public String getUploadsessionsettings(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Uploadsessionsettings_usecases uploadsessionsettingsusecases = new Uploadsessionsettings_usecases(loggedin);
            return get_uploadsessionsettings_with_primarykey(uploadsessionsettingsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertUploadsessionsettings")
    @Override
    public void insertUploadsessionsettings(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Uploadsessionsettings_usecases uploadsessionsettingsusecases = new Uploadsessionsettings_usecases(loggedin);
            insert_uploadsessionsettings(uploadsessionsettingsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateUploadsessionsettings")
    @Override
    public void updateUploadsessionsettings(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Uploadsessionsettings_usecases uploadsessionsettingsusecases = new Uploadsessionsettings_usecases(loggedin);
            update_uploadsessionsettings(uploadsessionsettingsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteUploadsessionsettings")
    @Override
    public void deleteUploadsessionsettings(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Uploadsessionsettings_usecases uploadsessionsettingsusecases = new Uploadsessionsettings_usecases(loggedin);
            delete_uploadsessionsettings(uploadsessionsettingsusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Uploadsessionsettings_usecases uploadsessionsettingsusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", uploadsessionsettingsusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_uploadsessionsettings(Uploadsessionsettings_usecases uploadsessionsettingsusecases) throws ParseException, CustomException {
    	return JSONUploadsessionsettings.toJSONArray(uploadsessionsettingsusecases.get_all()).toJSONString();
    }
    
    private String get_uploadsessionsettings_with_primarykey(Uploadsessionsettings_usecases uploadsessionsettingsusecases, JSONObject json) throws ParseException, CustomException {
        IUploadsessionsettingsPK uploadsessionsettingsPK = (IUploadsessionsettingsPK)JSONUploadsessionsettings.toUploadsessionsettingsPK((JSONObject)json.get("uploadsessionsettingspk"));
	return JSONUploadsessionsettings.toJSON(uploadsessionsettingsusecases.get_uploadsessionsettings_by_primarykey(uploadsessionsettingsPK)).toJSONString();
    }
    
    private String search_uploadsessionsettings(Uploadsessionsettings_usecases uploadsessionsettingsusecases, JSONObject json) throws ParseException, CustomException {
        IUploadsessionsettingssearch search = (IUploadsessionsettingssearch)JSONUploadsessionsettings.toUploadsessionsettingssearch((JSONObject)json.get("search"));
        return JSONUploadsessionsettings.toJSONArray(uploadsessionsettingsusecases.search_uploadsessionsettings(search)).toJSONString();
    }
    
    private String search_uploadsessionsettings_count(Uploadsessionsettings_usecases uploadsessionsettingsusecases, JSONObject json) throws ParseException, CustomException {
        IUploadsessionsettingssearch uploadsessionsettingssearch = (IUploadsessionsettingssearch)JSONUploadsessionsettings.toUploadsessionsettingssearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", uploadsessionsettingsusecases.search_uploadsessionsettings_count(uploadsessionsettingssearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_uploadsessionsettings(Uploadsessionsettings_usecases uploadsessionsettingsusecases, JSONObject json) throws ParseException, CustomException {
        IUploadsessionsettings uploadsessionsettings = (IUploadsessionsettings)JSONUploadsessionsettings.toUploadsessionsettings((JSONObject)json.get("uploadsessionsettings"));
        uploadsessionsettingsusecases.insertUploadsessionsettings(uploadsessionsettings);
        setReturnstatus("OK");
    }

    private void update_uploadsessionsettings(Uploadsessionsettings_usecases uploadsessionsettingsusecases, JSONObject json) throws ParseException, CustomException {
        IUploadsessionsettings uploadsessionsettings = (IUploadsessionsettings)JSONUploadsessionsettings.toUploadsessionsettings((JSONObject)json.get("uploadsessionsettings"));
        uploadsessionsettingsusecases.updateUploadsessionsettings(uploadsessionsettings);
        setReturnstatus("OK");
    }

    private void delete_uploadsessionsettings(Uploadsessionsettings_usecases uploadsessionsettingsusecases, JSONObject json) throws ParseException, CustomException {
        IUploadsessionsettings uploadsessionsettings = (IUploadsessionsettings)JSONUploadsessionsettings.toUploadsessionsettings((JSONObject)json.get("uploadsessionsettings"));
        uploadsessionsettingsusecases.deleteUploadsessionsettings(uploadsessionsettings);
        setReturnstatus("OK");
    }

}

