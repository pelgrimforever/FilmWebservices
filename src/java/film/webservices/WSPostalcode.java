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
import film.interfaces.searchentity.IPostalcodesearch;
import film.interfaces.webservice.WSIPostalcode;
import film.logicentity.Postalcode;
import film.searchentity.Postalcodesearch;
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

@WebService(endpointInterface = "film.interfaces.webservice.WSIPostalcode")
public class WSPostalcode extends RS_json_login implements WSIPostalcode {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList postalcodes) {
        JSONArray jsonpostalcodes = new JSONArray();
        Iterator postalcodesI = postalcodes.iterator();
        while(postalcodesI.hasNext()) {
            jsonpostalcodes.add(JSONPostalcode.toJSON((Postalcode)postalcodesI.next()));
        }
        return jsonpostalcodes;
    }

    //@WebMethod(operationName = "getPostalcodes")
    @Override
    public String getPostalcodes() {
        try {
            Postalcode_usecases postalcodeusecases = new Postalcode_usecases(loggedin);
            return get_all_postalcode(postalcodeusecases);
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
            Postalcode_usecases postalcodeusecases = new Postalcode_usecases(loggedin);
            return search_postalcode(postalcodeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getPostalcode")
    @Override
    public String getPostalcode(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Postalcode_usecases postalcodeusecases = new Postalcode_usecases(loggedin);
            return get_postalcode_with_primarykey(postalcodeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertPostalcode")
    @Override
    public void insertPostalcode(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Postalcode_usecases postalcodeusecases = new Postalcode_usecases(loggedin);
            insert_postalcode(postalcodeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updatePostalcode")
    @Override
    public void updatePostalcode(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Postalcode_usecases postalcodeusecases = new Postalcode_usecases(loggedin);
            update_postalcode(postalcodeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deletePostalcode")
    @Override
    public void deletePostalcode(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Postalcode_usecases postalcodeusecases = new Postalcode_usecases(loggedin);
            delete_postalcode(postalcodeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getPostalcodes4arealevel3")
    @Override
    public String getPostalcodes4arealevel3(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Postalcode_usecases postalcodeusecases = new Postalcode_usecases(loggedin);
            return get_postalcode_with_foreignkey_arealevel3(postalcodeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4arealevel3")
    @Override
    public void delete4arealevel3(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Postalcode_usecases postalcodeusecases = new Postalcode_usecases(loggedin);
            delete_postalcode(postalcodeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getPostalcodes4locality")
    @Override
    public String getPostalcodes4locality(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Postalcode_usecases postalcodeusecases = new Postalcode_usecases(loggedin);
            return get_postalcode_with_externalforeignkey_locality(postalcodeusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


    private String count_records(Postalcode_usecases postalcodeusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", postalcodeusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_postalcode(Postalcode_usecases postalcodeusecases) throws ParseException, CustomException {
    	return JSONPostalcode.toJSONArray(postalcodeusecases.get_all()).toJSONString();
    }
    
    private String get_postalcode_with_primarykey(Postalcode_usecases postalcodeusecases, JSONObject json) throws ParseException, CustomException {
        IPostalcodePK postalcodePK = (IPostalcodePK)JSONPostalcode.toPostalcodePK((JSONObject)json.get("postalcodepk"));
	return JSONPostalcode.toJSON(postalcodeusecases.get_postalcode_by_primarykey(postalcodePK)).toJSONString();
    }
    
    private String get_postalcode_with_foreignkey_arealevel3(Postalcode_usecases postalcodeusecases, JSONObject json) throws ParseException, CustomException {
        IArealevel3PK arealevel3PK = (IArealevel3PK)JSONArealevel3.toArealevel3PK((JSONObject)json.get("arealevel3pk"));
        return JSONPostalcode.toJSONArray(postalcodeusecases.get_postalcode_with_foreignkey_arealevel3(arealevel3PK)).toJSONString();
    }
    
    private String get_postalcode_with_externalforeignkey_locality(Postalcode_usecases postalcodeusecases, JSONObject json) throws ParseException, CustomException {
        ILocalityPK localityPK = (ILocalityPK)JSONLocality.toLocalityPK((JSONObject)json.get("localitypk"));
        return JSONPostalcode.toJSON(postalcodeusecases.get_postalcode_with_externalforeignkey_locality(localityPK)).toJSONString();
    }
    
    private String search_postalcode(Postalcode_usecases postalcodeusecases, JSONObject json) throws ParseException, CustomException {
        IPostalcodesearch search = (IPostalcodesearch)JSONPostalcode.toPostalcodesearch((JSONObject)json.get("search"));
        return JSONPostalcode.toJSONArray(postalcodeusecases.search_postalcode(search)).toJSONString();
    }
    
    private String search_postalcode_count(Postalcode_usecases postalcodeusecases, JSONObject json) throws ParseException, CustomException {
        IPostalcodesearch postalcodesearch = (IPostalcodesearch)JSONPostalcode.toPostalcodesearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", postalcodeusecases.search_postalcode_count(postalcodesearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_postalcode(Postalcode_usecases postalcodeusecases, JSONObject json) throws ParseException, CustomException {
        IPostalcode postalcode = (IPostalcode)JSONPostalcode.toPostalcode((JSONObject)json.get("postalcode"));
        postalcodeusecases.insertPostalcode(postalcode);
        setReturnstatus("OK");
    }

    private void update_postalcode(Postalcode_usecases postalcodeusecases, JSONObject json) throws ParseException, CustomException {
        IPostalcode postalcode = (IPostalcode)JSONPostalcode.toPostalcode((JSONObject)json.get("postalcode"));
        postalcodeusecases.updatePostalcode(postalcode);
        setReturnstatus("OK");
    }

    private void delete_postalcode(Postalcode_usecases postalcodeusecases, JSONObject json) throws ParseException, CustomException {
        IPostalcode postalcode = (IPostalcode)JSONPostalcode.toPostalcode((JSONObject)json.get("postalcode"));
        postalcodeusecases.deletePostalcode(postalcode);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Arealevel3(Postalcode_usecases postalcodeusecases, JSONObject json) throws ParseException, CustomException {
        IArealevel3PK arealevel3PK = (IArealevel3PK)JSONArealevel3.toArealevel3PK((JSONObject)json.get("arealevel3pk"));
        postalcodeusecases.delete_all_containing_Arealevel3(arealevel3PK);
        setReturnstatus("OK");
    }

}

