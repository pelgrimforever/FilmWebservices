/*
 * WSLocality.java
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
import film.interfaces.searchentity.ILocalitysearch;
import film.interfaces.webservice.WSILocality;
import film.logicentity.Locality;
import film.searchentity.Localitysearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSILocality")
public class WSLocality extends RS_json_login implements WSILocality {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList localitys) {
        JSONArray jsonlocalitys = new JSONArray();
        Iterator localitysI = localitys.iterator();
        while(localitysI.hasNext()) {
            jsonlocalitys.add(JSONLocality.toJSON((Locality)localitysI.next()));
        }
        return jsonlocalitys;
    }

    //@WebMethod(operationName = "getLocalitys")
    @Override
    public String getLocalitys() {
        try {
            Locality_usecases localityusecases = new Locality_usecases(loggedin);
            return get_all_locality(localityusecases);
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
            Locality_usecases localityusecases = new Locality_usecases(loggedin);
            return search_locality(localityusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getLocality")
    @Override
    public String getLocality(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Locality_usecases localityusecases = new Locality_usecases(loggedin);
            return get_locality_with_primarykey(localityusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertLocality")
    @Override
    public void insertLocality(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Locality_usecases localityusecases = new Locality_usecases(loggedin);
            insert_locality(localityusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateLocality")
    @Override
    public void updateLocality(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Locality_usecases localityusecases = new Locality_usecases(loggedin);
            update_locality(localityusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteLocality")
    @Override
    public void deleteLocality(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Locality_usecases localityusecases = new Locality_usecases(loggedin);
            delete_locality(localityusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getLocalitys4postalcode")
    @Override
    public String getLocalitys4postalcode(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Locality_usecases localityusecases = new Locality_usecases(loggedin);
            return get_locality_with_foreignkey_postalcode(localityusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4postalcode")
    @Override
    public void delete4postalcode(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Locality_usecases localityusecases = new Locality_usecases(loggedin);
            delete_locality(localityusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getLocalitys4sublocality")
    @Override
    public String getLocalitys4sublocality(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Locality_usecases localityusecases = new Locality_usecases(loggedin);
            return get_locality_with_externalforeignkey_sublocality(localityusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


    private String count_records(Locality_usecases localityusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", localityusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_locality(Locality_usecases localityusecases) throws ParseException, CustomException {
    	return JSONLocality.toJSONArray(localityusecases.get_all()).toJSONString();
    }
    
    private String get_locality_with_primarykey(Locality_usecases localityusecases, JSONObject json) throws ParseException, CustomException {
        ILocalityPK localityPK = (ILocalityPK)JSONLocality.toLocalityPK((JSONObject)json.get("localitypk"));
	return JSONLocality.toJSON(localityusecases.get_locality_by_primarykey(localityPK)).toJSONString();
    }
    
    private String get_locality_with_foreignkey_postalcode(Locality_usecases localityusecases, JSONObject json) throws ParseException, CustomException {
        IPostalcodePK postalcodePK = (IPostalcodePK)JSONPostalcode.toPostalcodePK((JSONObject)json.get("postalcodepk"));
        return JSONLocality.toJSONArray(localityusecases.get_locality_with_foreignkey_postalcode(postalcodePK)).toJSONString();
    }
    
    private String get_locality_with_externalforeignkey_sublocality(Locality_usecases localityusecases, JSONObject json) throws ParseException, CustomException {
        ISublocalityPK sublocalityPK = (ISublocalityPK)JSONSublocality.toSublocalityPK((JSONObject)json.get("sublocalitypk"));
        return JSONLocality.toJSON(localityusecases.get_locality_with_externalforeignkey_sublocality(sublocalityPK)).toJSONString();
    }
    
    private String search_locality(Locality_usecases localityusecases, JSONObject json) throws ParseException, CustomException {
        ILocalitysearch search = (ILocalitysearch)JSONLocality.toLocalitysearch((JSONObject)json.get("search"));
        return JSONLocality.toJSONArray(localityusecases.search_locality(search)).toJSONString();
    }
    
    private String search_locality_count(Locality_usecases localityusecases, JSONObject json) throws ParseException, CustomException {
        ILocalitysearch localitysearch = (ILocalitysearch)JSONLocality.toLocalitysearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", localityusecases.search_locality_count(localitysearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_locality(Locality_usecases localityusecases, JSONObject json) throws ParseException, CustomException {
        ILocality locality = (ILocality)JSONLocality.toLocality((JSONObject)json.get("locality"));
        localityusecases.insertLocality(locality);
        setReturnstatus("OK");
    }

    private void update_locality(Locality_usecases localityusecases, JSONObject json) throws ParseException, CustomException {
        ILocality locality = (ILocality)JSONLocality.toLocality((JSONObject)json.get("locality"));
        localityusecases.updateLocality(locality);
        setReturnstatus("OK");
    }

    private void delete_locality(Locality_usecases localityusecases, JSONObject json) throws ParseException, CustomException {
        ILocality locality = (ILocality)JSONLocality.toLocality((JSONObject)json.get("locality"));
        localityusecases.deleteLocality(locality);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Postalcode(Locality_usecases localityusecases, JSONObject json) throws ParseException, CustomException {
        IPostalcodePK postalcodePK = (IPostalcodePK)JSONPostalcode.toPostalcodePK((JSONObject)json.get("postalcodepk"));
        localityusecases.delete_all_containing_Postalcode(postalcodePK);
        setReturnstatus("OK");
    }

}

