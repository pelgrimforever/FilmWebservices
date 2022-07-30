/*
 * WSSublocality.java
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
import film.interfaces.searchentity.ISublocalitysearch;
import film.interfaces.webservice.WSISublocality;
import film.logicentity.Sublocality;
import film.searchentity.Sublocalitysearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSISublocality")
public class WSSublocality extends RS_json_login implements WSISublocality {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList sublocalitys) {
        JSONArray jsonsublocalitys = new JSONArray();
        Iterator sublocalitysI = sublocalitys.iterator();
        while(sublocalitysI.hasNext()) {
            jsonsublocalitys.add(JSONSublocality.toJSON((Sublocality)sublocalitysI.next()));
        }
        return jsonsublocalitys;
    }

    //@WebMethod(operationName = "getSublocalitys")
    @Override
    public String getSublocalitys() {
        try {
            Sublocality_usecases sublocalityusecases = new Sublocality_usecases(loggedin);
            return get_all_sublocality(sublocalityusecases);
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
            Sublocality_usecases sublocalityusecases = new Sublocality_usecases(loggedin);
            return search_sublocality(sublocalityusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getSublocality")
    @Override
    public String getSublocality(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Sublocality_usecases sublocalityusecases = new Sublocality_usecases(loggedin);
            return get_sublocality_with_primarykey(sublocalityusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertSublocality")
    @Override
    public void insertSublocality(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Sublocality_usecases sublocalityusecases = new Sublocality_usecases(loggedin);
            insert_sublocality(sublocalityusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateSublocality")
    @Override
    public void updateSublocality(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Sublocality_usecases sublocalityusecases = new Sublocality_usecases(loggedin);
            update_sublocality(sublocalityusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteSublocality")
    @Override
    public void deleteSublocality(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Sublocality_usecases sublocalityusecases = new Sublocality_usecases(loggedin);
            delete_sublocality(sublocalityusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSublocalitys4locality")
    @Override
    public String getSublocalitys4locality(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Sublocality_usecases sublocalityusecases = new Sublocality_usecases(loggedin);
            return get_sublocality_with_foreignkey_locality(sublocalityusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4locality")
    @Override
    public void delete4locality(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Sublocality_usecases sublocalityusecases = new Sublocality_usecases(loggedin);
            delete_sublocality(sublocalityusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSublocalitys4route")
    @Override
    public String getSublocalitys4route(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Sublocality_usecases sublocalityusecases = new Sublocality_usecases(loggedin);
            return get_sublocality_with_externalforeignkey_route(sublocalityusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


    private String count_records(Sublocality_usecases sublocalityusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", sublocalityusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_sublocality(Sublocality_usecases sublocalityusecases) throws ParseException, CustomException {
    	return JSONSublocality.toJSONArray(sublocalityusecases.get_all()).toJSONString();
    }
    
    private String get_sublocality_with_primarykey(Sublocality_usecases sublocalityusecases, JSONObject json) throws ParseException, CustomException {
        ISublocalityPK sublocalityPK = (ISublocalityPK)JSONSublocality.toSublocalityPK((JSONObject)json.get("sublocalitypk"));
	return JSONSublocality.toJSON(sublocalityusecases.get_sublocality_by_primarykey(sublocalityPK)).toJSONString();
    }
    
    private String get_sublocality_with_foreignkey_locality(Sublocality_usecases sublocalityusecases, JSONObject json) throws ParseException, CustomException {
        ILocalityPK localityPK = (ILocalityPK)JSONLocality.toLocalityPK((JSONObject)json.get("localitypk"));
        return JSONSublocality.toJSONArray(sublocalityusecases.get_sublocality_with_foreignkey_locality(localityPK)).toJSONString();
    }
    
    private String get_sublocality_with_externalforeignkey_route(Sublocality_usecases sublocalityusecases, JSONObject json) throws ParseException, CustomException {
        IRoutePK routePK = (IRoutePK)JSONRoute.toRoutePK((JSONObject)json.get("routepk"));
        return JSONSublocality.toJSON(sublocalityusecases.get_sublocality_with_externalforeignkey_route(routePK)).toJSONString();
    }
    
    private String search_sublocality(Sublocality_usecases sublocalityusecases, JSONObject json) throws ParseException, CustomException {
        ISublocalitysearch search = (ISublocalitysearch)JSONSublocality.toSublocalitysearch((JSONObject)json.get("search"));
        return JSONSublocality.toJSONArray(sublocalityusecases.search_sublocality(search)).toJSONString();
    }
    
    private String search_sublocality_count(Sublocality_usecases sublocalityusecases, JSONObject json) throws ParseException, CustomException {
        ISublocalitysearch sublocalitysearch = (ISublocalitysearch)JSONSublocality.toSublocalitysearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", sublocalityusecases.search_sublocality_count(sublocalitysearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_sublocality(Sublocality_usecases sublocalityusecases, JSONObject json) throws ParseException, CustomException {
        ISublocality sublocality = (ISublocality)JSONSublocality.toSublocality((JSONObject)json.get("sublocality"));
        sublocalityusecases.insertSublocality(sublocality);
        setReturnstatus("OK");
    }

    private void update_sublocality(Sublocality_usecases sublocalityusecases, JSONObject json) throws ParseException, CustomException {
        ISublocality sublocality = (ISublocality)JSONSublocality.toSublocality((JSONObject)json.get("sublocality"));
        sublocalityusecases.updateSublocality(sublocality);
        setReturnstatus("OK");
    }

    private void delete_sublocality(Sublocality_usecases sublocalityusecases, JSONObject json) throws ParseException, CustomException {
        ISublocality sublocality = (ISublocality)JSONSublocality.toSublocality((JSONObject)json.get("sublocality"));
        sublocalityusecases.deleteSublocality(sublocality);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Locality(Sublocality_usecases sublocalityusecases, JSONObject json) throws ParseException, CustomException {
        ILocalityPK localityPK = (ILocalityPK)JSONLocality.toLocalityPK((JSONObject)json.get("localitypk"));
        sublocalityusecases.delete_all_containing_Locality(localityPK);
        setReturnstatus("OK");
    }

}

