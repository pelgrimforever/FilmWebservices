/*
 * WSCountry.java
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
import film.interfaces.searchentity.ICountrysearch;
import film.interfaces.webservice.WSICountry;
import film.logicentity.Country;
import film.searchentity.Countrysearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSICountry")
public class WSCountry extends RS_json_login implements WSICountry {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList countrys) {
        JSONArray jsoncountrys = new JSONArray();
        Iterator countrysI = countrys.iterator();
        while(countrysI.hasNext()) {
            jsoncountrys.add(JSONCountry.toJSON((Country)countrysI.next()));
        }
        return jsoncountrys;
    }

    //@WebMethod(operationName = "getCountrys")
    @Override
    public String getCountrys() {
        try {
            Country_usecases countryusecases = new Country_usecases(loggedin);
            return get_all_country(countryusecases);
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
            Country_usecases countryusecases = new Country_usecases(loggedin);
            return search_country(countryusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getCountry")
    @Override
    public String getCountry(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Country_usecases countryusecases = new Country_usecases(loggedin);
            return get_country_with_primarykey(countryusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertCountry")
    @Override
    public void insertCountry(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Country_usecases countryusecases = new Country_usecases(loggedin);
            insert_country(countryusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateCountry")
    @Override
    public void updateCountry(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Country_usecases countryusecases = new Country_usecases(loggedin);
            update_country(countryusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteCountry")
    @Override
    public void deleteCountry(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Country_usecases countryusecases = new Country_usecases(loggedin);
            delete_country(countryusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getCountrys4arealevel1")
    @Override
    public String getCountrys4arealevel1(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Country_usecases countryusecases = new Country_usecases(loggedin);
            return get_country_with_externalforeignkey_arealevel1(countryusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


    private String count_records(Country_usecases countryusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", countryusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_country(Country_usecases countryusecases) throws ParseException, CustomException {
    	return JSONCountry.toJSONArray(countryusecases.get_all()).toJSONString();
    }
    
    private String get_country_with_primarykey(Country_usecases countryusecases, JSONObject json) throws ParseException, CustomException {
        ICountryPK countryPK = (ICountryPK)JSONCountry.toCountryPK((JSONObject)json.get("countrypk"));
	return JSONCountry.toJSON(countryusecases.get_country_by_primarykey(countryPK)).toJSONString();
    }
    
    private String get_country_with_externalforeignkey_arealevel1(Country_usecases countryusecases, JSONObject json) throws ParseException, CustomException {
        IArealevel1PK arealevel1PK = (IArealevel1PK)JSONArealevel1.toArealevel1PK((JSONObject)json.get("arealevel1pk"));
        return JSONCountry.toJSON(countryusecases.get_country_with_externalforeignkey_arealevel1(arealevel1PK)).toJSONString();
    }
    
    private String search_country(Country_usecases countryusecases, JSONObject json) throws ParseException, CustomException {
        ICountrysearch search = (ICountrysearch)JSONCountry.toCountrysearch((JSONObject)json.get("search"));
        return JSONCountry.toJSONArray(countryusecases.search_country(search)).toJSONString();
    }
    
    private String search_country_count(Country_usecases countryusecases, JSONObject json) throws ParseException, CustomException {
        ICountrysearch countrysearch = (ICountrysearch)JSONCountry.toCountrysearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", countryusecases.search_country_count(countrysearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_country(Country_usecases countryusecases, JSONObject json) throws ParseException, CustomException {
        ICountry country = (ICountry)JSONCountry.toCountry((JSONObject)json.get("country"));
        countryusecases.insertCountry(country);
        setReturnstatus("OK");
    }

    private void update_country(Country_usecases countryusecases, JSONObject json) throws ParseException, CustomException {
        ICountry country = (ICountry)JSONCountry.toCountry((JSONObject)json.get("country"));
        countryusecases.updateCountry(country);
        setReturnstatus("OK");
    }

    private void delete_country(Country_usecases countryusecases, JSONObject json) throws ParseException, CustomException {
        ICountry country = (ICountry)JSONCountry.toCountry((JSONObject)json.get("country"));
        countryusecases.deleteCountry(country);
        setReturnstatus("OK");
    }

}

