/*
 * WSCountry.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 24.9.2021 14:50
 *
 */

package film.webservices;

import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.webservice.WSICountry;
import film.logicentity.Country;
import film.searchentity.Countrysearch;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "film.interfaces.webservice.WSICountry")
public class WSCountry implements WSICountry {

    private JSONArray toJSONArray(ArrayList countrys) {
        JSONArray jsoncountrys = new JSONArray();
        Iterator countrysI = countrys.iterator();
        while(countrysI.hasNext()) {
            jsoncountrys.add(JSONCountry.toJSON((Country)countrysI.next()));
        }
        return jsoncountrys;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getCountrys")
    @Override
    public String getCountrys() {
        try {
            BLcountry blcountry = new BLcountry();
            ArrayList countrys = blcountry.getAll();
            JSONArray jsoncountrys = toJSONArray(countrys);
            return jsoncountrys.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLcountry blcountry = new BLcountry();
        JSONParser parser = new JSONParser();
        String result = "";
        Country country;
        try {
            Countrysearch countrysearch = JSONCountry.toCountrysearch((JSONObject)parser.parse(json));
            ArrayList countrys = blcountry.search(countrysearch);
            JSONArray jsoncountrys = toJSONArray(countrys);
            result = jsoncountrys.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getCountry")
    @Override
    public String getCountry(String json) {
        BLcountry blcountry = new BLcountry();
        JSONParser parser = new JSONParser();
        String result = "";
        Country country;
        try {
            CountryPK countryPK = JSONCountry.toCountryPK((JSONObject)parser.parse(json));
            country = blcountry.getCountry(countryPK);
            if(country!=null) {
                result = JSONCountry.toJSON(country).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertCountry")
    @Override
    public void insertCountry(String json) {
        BLcountry blcountry = new BLcountry();
        JSONParser parser = new JSONParser();
        try {
            ICountry country = JSONCountry.toCountry((JSONObject)parser.parse(json));
            blcountry.insertCountry(country);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateCountry")
    @Override
    public void updateCountry(String json) {
        BLcountry blcountry = new BLcountry();
        JSONParser parser = new JSONParser();
        try {
            ICountry country = JSONCountry.toCountry((JSONObject)parser.parse(json));
            blcountry.updateCountry(country);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteCountry")
    @Override
    public void deleteCountry(String json) {
        BLcountry blcountry = new BLcountry();
        JSONParser parser = new JSONParser();
        try {
            ICountry country = JSONCountry.toCountry((JSONObject)parser.parse(json));
            blcountry.deleteCountry(country);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getCountrys4arealevel1")
    @Override
    public String getCountrys4arealevel1(String json) {
        BLcountry blcountry = new BLcountry();
        JSONParser parser = new JSONParser();
        Country country;
        try {
            String result = null;
            IArealevel1PK arealevel1PK = JSONArealevel1.toArealevel1PK((JSONObject)parser.parse(json));
            country = (Country)blcountry.getArealevel1(arealevel1PK);
            if(country!=null) {
                result = JSONCountry.toJSON(country).toJSONString();
            }
            return result;
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }


}

