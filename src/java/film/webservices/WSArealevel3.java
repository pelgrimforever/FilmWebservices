/*
 * WSArealevel3.java
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
import film.interfaces.searchentity.IArealevel3search;
import film.interfaces.webservice.WSIArealevel3;
import film.logicentity.Arealevel3;
import film.searchentity.Arealevel3search;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIArealevel3")
public class WSArealevel3 extends RS_json_login implements WSIArealevel3 {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList arealevel3s) {
        JSONArray jsonarealevel3s = new JSONArray();
        Iterator arealevel3sI = arealevel3s.iterator();
        while(arealevel3sI.hasNext()) {
            jsonarealevel3s.add(JSONArealevel3.toJSON((Arealevel3)arealevel3sI.next()));
        }
        return jsonarealevel3s;
    }

    //@WebMethod(operationName = "getArealevel3s")
    @Override
    public String getArealevel3s() {
        try {
            Arealevel3_usecases arealevel3usecases = new Arealevel3_usecases(loggedin);
            return get_all_arealevel3(arealevel3usecases);
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
            Arealevel3_usecases arealevel3usecases = new Arealevel3_usecases(loggedin);
            return search_arealevel3(arealevel3usecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getArealevel3")
    @Override
    public String getArealevel3(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Arealevel3_usecases arealevel3usecases = new Arealevel3_usecases(loggedin);
            return get_arealevel3_with_primarykey(arealevel3usecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertArealevel3")
    @Override
    public void insertArealevel3(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Arealevel3_usecases arealevel3usecases = new Arealevel3_usecases(loggedin);
            insert_arealevel3(arealevel3usecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateArealevel3")
    @Override
    public void updateArealevel3(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Arealevel3_usecases arealevel3usecases = new Arealevel3_usecases(loggedin);
            update_arealevel3(arealevel3usecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteArealevel3")
    @Override
    public void deleteArealevel3(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Arealevel3_usecases arealevel3usecases = new Arealevel3_usecases(loggedin);
            delete_arealevel3(arealevel3usecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getArealevel3s4arealevel2")
    @Override
    public String getArealevel3s4arealevel2(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Arealevel3_usecases arealevel3usecases = new Arealevel3_usecases(loggedin);
            return get_arealevel3_with_foreignkey_arealevel2(arealevel3usecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4arealevel2")
    @Override
    public void delete4arealevel2(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Arealevel3_usecases arealevel3usecases = new Arealevel3_usecases(loggedin);
            delete_arealevel3(arealevel3usecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }


    private String count_records(Arealevel3_usecases arealevel3usecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", arealevel3usecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_arealevel3(Arealevel3_usecases arealevel3usecases) throws ParseException, CustomException {
    	return JSONArealevel3.toJSONArray(arealevel3usecases.get_all()).toJSONString();
    }
    
    private String get_arealevel3_with_primarykey(Arealevel3_usecases arealevel3usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel3PK arealevel3PK = (IArealevel3PK)JSONArealevel3.toArealevel3PK((JSONObject)json.get("arealevel3pk"));
	return JSONArealevel3.toJSON(arealevel3usecases.get_arealevel3_by_primarykey(arealevel3PK)).toJSONString();
    }
    
    private String get_arealevel3_with_foreignkey_arealevel2(Arealevel3_usecases arealevel3usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel2PK arealevel2PK = (IArealevel2PK)JSONArealevel2.toArealevel2PK((JSONObject)json.get("arealevel2pk"));
        return JSONArealevel3.toJSONArray(arealevel3usecases.get_arealevel3_with_foreignkey_arealevel2(arealevel2PK)).toJSONString();
    }
    
    private String search_arealevel3(Arealevel3_usecases arealevel3usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel3search search = (IArealevel3search)JSONArealevel3.toArealevel3search((JSONObject)json.get("search"));
        return JSONArealevel3.toJSONArray(arealevel3usecases.search_arealevel3(search)).toJSONString();
    }
    
    private String search_arealevel3_count(Arealevel3_usecases arealevel3usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel3search arealevel3search = (IArealevel3search)JSONArealevel3.toArealevel3search((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", arealevel3usecases.search_arealevel3_count(arealevel3search));
        return jsonsearchcount.toJSONString();
    }

    private void insert_arealevel3(Arealevel3_usecases arealevel3usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel3 arealevel3 = (IArealevel3)JSONArealevel3.toArealevel3((JSONObject)json.get("arealevel3"));
        arealevel3usecases.insertArealevel3(arealevel3);
        setReturnstatus("OK");
    }

    private void update_arealevel3(Arealevel3_usecases arealevel3usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel3 arealevel3 = (IArealevel3)JSONArealevel3.toArealevel3((JSONObject)json.get("arealevel3"));
        arealevel3usecases.updateArealevel3(arealevel3);
        setReturnstatus("OK");
    }

    private void delete_arealevel3(Arealevel3_usecases arealevel3usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel3 arealevel3 = (IArealevel3)JSONArealevel3.toArealevel3((JSONObject)json.get("arealevel3"));
        arealevel3usecases.deleteArealevel3(arealevel3);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Arealevel2(Arealevel3_usecases arealevel3usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel2PK arealevel2PK = (IArealevel2PK)JSONArealevel2.toArealevel2PK((JSONObject)json.get("arealevel2pk"));
        arealevel3usecases.delete_all_containing_Arealevel2(arealevel2PK);
        setReturnstatus("OK");
    }

}

