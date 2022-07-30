/*
 * WSArealevel1.java
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
import film.interfaces.searchentity.IArealevel1search;
import film.interfaces.webservice.WSIArealevel1;
import film.logicentity.Arealevel1;
import film.searchentity.Arealevel1search;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIArealevel1")
public class WSArealevel1 extends RS_json_login implements WSIArealevel1 {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList arealevel1s) {
        JSONArray jsonarealevel1s = new JSONArray();
        Iterator arealevel1sI = arealevel1s.iterator();
        while(arealevel1sI.hasNext()) {
            jsonarealevel1s.add(JSONArealevel1.toJSON((Arealevel1)arealevel1sI.next()));
        }
        return jsonarealevel1s;
    }

    //@WebMethod(operationName = "getArealevel1s")
    @Override
    public String getArealevel1s() {
        try {
            Arealevel1_usecases arealevel1usecases = new Arealevel1_usecases(loggedin);
            return get_all_arealevel1(arealevel1usecases);
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
            Arealevel1_usecases arealevel1usecases = new Arealevel1_usecases(loggedin);
            return search_arealevel1(arealevel1usecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getArealevel1")
    @Override
    public String getArealevel1(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Arealevel1_usecases arealevel1usecases = new Arealevel1_usecases(loggedin);
            return get_arealevel1_with_primarykey(arealevel1usecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertArealevel1")
    @Override
    public void insertArealevel1(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Arealevel1_usecases arealevel1usecases = new Arealevel1_usecases(loggedin);
            insert_arealevel1(arealevel1usecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateArealevel1")
    @Override
    public void updateArealevel1(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Arealevel1_usecases arealevel1usecases = new Arealevel1_usecases(loggedin);
            update_arealevel1(arealevel1usecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteArealevel1")
    @Override
    public void deleteArealevel1(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Arealevel1_usecases arealevel1usecases = new Arealevel1_usecases(loggedin);
            delete_arealevel1(arealevel1usecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getArealevel1s4country")
    @Override
    public String getArealevel1s4country(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Arealevel1_usecases arealevel1usecases = new Arealevel1_usecases(loggedin);
            return get_arealevel1_with_foreignkey_country(arealevel1usecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4country")
    @Override
    public void delete4country(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Arealevel1_usecases arealevel1usecases = new Arealevel1_usecases(loggedin);
            delete_arealevel1(arealevel1usecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getArealevel1s4arealevel2")
    @Override
    public String getArealevel1s4arealevel2(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Arealevel1_usecases arealevel1usecases = new Arealevel1_usecases(loggedin);
            return get_arealevel1_with_externalforeignkey_arealevel2(arealevel1usecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


    private String count_records(Arealevel1_usecases arealevel1usecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", arealevel1usecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_arealevel1(Arealevel1_usecases arealevel1usecases) throws ParseException, CustomException {
    	return JSONArealevel1.toJSONArray(arealevel1usecases.get_all()).toJSONString();
    }
    
    private String get_arealevel1_with_primarykey(Arealevel1_usecases arealevel1usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel1PK arealevel1PK = (IArealevel1PK)JSONArealevel1.toArealevel1PK((JSONObject)json.get("arealevel1pk"));
	return JSONArealevel1.toJSON(arealevel1usecases.get_arealevel1_by_primarykey(arealevel1PK)).toJSONString();
    }
    
    private String get_arealevel1_with_foreignkey_country(Arealevel1_usecases arealevel1usecases, JSONObject json) throws ParseException, CustomException {
        ICountryPK countryPK = (ICountryPK)JSONCountry.toCountryPK((JSONObject)json.get("countrypk"));
        return JSONArealevel1.toJSONArray(arealevel1usecases.get_arealevel1_with_foreignkey_country(countryPK)).toJSONString();
    }
    
    private String get_arealevel1_with_externalforeignkey_arealevel2(Arealevel1_usecases arealevel1usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel2PK arealevel2PK = (IArealevel2PK)JSONArealevel2.toArealevel2PK((JSONObject)json.get("arealevel2pk"));
        return JSONArealevel1.toJSON(arealevel1usecases.get_arealevel1_with_externalforeignkey_arealevel2(arealevel2PK)).toJSONString();
    }
    
    private String search_arealevel1(Arealevel1_usecases arealevel1usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel1search search = (IArealevel1search)JSONArealevel1.toArealevel1search((JSONObject)json.get("search"));
        return JSONArealevel1.toJSONArray(arealevel1usecases.search_arealevel1(search)).toJSONString();
    }
    
    private String search_arealevel1_count(Arealevel1_usecases arealevel1usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel1search arealevel1search = (IArealevel1search)JSONArealevel1.toArealevel1search((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", arealevel1usecases.search_arealevel1_count(arealevel1search));
        return jsonsearchcount.toJSONString();
    }

    private void insert_arealevel1(Arealevel1_usecases arealevel1usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel1 arealevel1 = (IArealevel1)JSONArealevel1.toArealevel1((JSONObject)json.get("arealevel1"));
        arealevel1usecases.insertArealevel1(arealevel1);
        setReturnstatus("OK");
    }

    private void update_arealevel1(Arealevel1_usecases arealevel1usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel1 arealevel1 = (IArealevel1)JSONArealevel1.toArealevel1((JSONObject)json.get("arealevel1"));
        arealevel1usecases.updateArealevel1(arealevel1);
        setReturnstatus("OK");
    }

    private void delete_arealevel1(Arealevel1_usecases arealevel1usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel1 arealevel1 = (IArealevel1)JSONArealevel1.toArealevel1((JSONObject)json.get("arealevel1"));
        arealevel1usecases.deleteArealevel1(arealevel1);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Country(Arealevel1_usecases arealevel1usecases, JSONObject json) throws ParseException, CustomException {
        ICountryPK countryPK = (ICountryPK)JSONCountry.toCountryPK((JSONObject)json.get("countrypk"));
        arealevel1usecases.delete_all_containing_Country(countryPK);
        setReturnstatus("OK");
    }

}

