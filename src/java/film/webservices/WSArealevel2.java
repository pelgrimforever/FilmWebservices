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
import film.interfaces.searchentity.IArealevel2search;
import film.interfaces.webservice.WSIArealevel2;
import film.logicentity.Arealevel2;
import film.searchentity.Arealevel2search;
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

@WebService(endpointInterface = "film.interfaces.webservice.WSIArealevel2")
public class WSArealevel2 extends RS_json_login implements WSIArealevel2 {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList arealevel2s) {
        JSONArray jsonarealevel2s = new JSONArray();
        Iterator arealevel2sI = arealevel2s.iterator();
        while(arealevel2sI.hasNext()) {
            jsonarealevel2s.add(JSONArealevel2.toJSON((Arealevel2)arealevel2sI.next()));
        }
        return jsonarealevel2s;
    }

    //@WebMethod(operationName = "getArealevel2s")
    @Override
    public String getArealevel2s() {
        try {
            Arealevel2_usecases arealevel2usecases = new Arealevel2_usecases(loggedin);
            return get_all_arealevel2(arealevel2usecases);
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
            Arealevel2_usecases arealevel2usecases = new Arealevel2_usecases(loggedin);
            return search_arealevel2(arealevel2usecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getArealevel2")
    @Override
    public String getArealevel2(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Arealevel2_usecases arealevel2usecases = new Arealevel2_usecases(loggedin);
            return get_arealevel2_with_primarykey(arealevel2usecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertArealevel2")
    @Override
    public void insertArealevel2(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Arealevel2_usecases arealevel2usecases = new Arealevel2_usecases(loggedin);
            insert_arealevel2(arealevel2usecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateArealevel2")
    @Override
    public void updateArealevel2(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Arealevel2_usecases arealevel2usecases = new Arealevel2_usecases(loggedin);
            update_arealevel2(arealevel2usecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteArealevel2")
    @Override
    public void deleteArealevel2(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Arealevel2_usecases arealevel2usecases = new Arealevel2_usecases(loggedin);
            delete_arealevel2(arealevel2usecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getArealevel2s4arealevel1")
    @Override
    public String getArealevel2s4arealevel1(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Arealevel2_usecases arealevel2usecases = new Arealevel2_usecases(loggedin);
            return get_arealevel2_with_foreignkey_arealevel1(arealevel2usecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4arealevel1")
    @Override
    public void delete4arealevel1(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Arealevel2_usecases arealevel2usecases = new Arealevel2_usecases(loggedin);
            delete_arealevel2(arealevel2usecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getArealevel2s4arealevel3")
    @Override
    public String getArealevel2s4arealevel3(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Arealevel2_usecases arealevel2usecases = new Arealevel2_usecases(loggedin);
            return get_arealevel2_with_externalforeignkey_arealevel3(arealevel2usecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


    private String count_records(Arealevel2_usecases arealevel2usecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", arealevel2usecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_arealevel2(Arealevel2_usecases arealevel2usecases) throws ParseException, CustomException {
    	return JSONArealevel2.toJSONArray(arealevel2usecases.get_all()).toJSONString();
    }
    
    private String get_arealevel2_with_primarykey(Arealevel2_usecases arealevel2usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel2PK arealevel2PK = (IArealevel2PK)JSONArealevel2.toArealevel2PK((JSONObject)json.get("arealevel2pk"));
	return JSONArealevel2.toJSON(arealevel2usecases.get_arealevel2_by_primarykey(arealevel2PK)).toJSONString();
    }
    
    private String get_arealevel2_with_foreignkey_arealevel1(Arealevel2_usecases arealevel2usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel1PK arealevel1PK = (IArealevel1PK)JSONArealevel1.toArealevel1PK((JSONObject)json.get("arealevel1pk"));
        return JSONArealevel2.toJSONArray(arealevel2usecases.get_arealevel2_with_foreignkey_arealevel1(arealevel1PK)).toJSONString();
    }
    
    private String get_arealevel2_with_externalforeignkey_arealevel3(Arealevel2_usecases arealevel2usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel3PK arealevel3PK = (IArealevel3PK)JSONArealevel3.toArealevel3PK((JSONObject)json.get("arealevel3pk"));
        return JSONArealevel2.toJSON(arealevel2usecases.get_arealevel2_with_externalforeignkey_arealevel3(arealevel3PK)).toJSONString();
    }
    
    private String search_arealevel2(Arealevel2_usecases arealevel2usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel2search search = (IArealevel2search)JSONArealevel2.toArealevel2search((JSONObject)json.get("search"));
        return JSONArealevel2.toJSONArray(arealevel2usecases.search_arealevel2(search)).toJSONString();
    }
    
    private String search_arealevel2_count(Arealevel2_usecases arealevel2usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel2search arealevel2search = (IArealevel2search)JSONArealevel2.toArealevel2search((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", arealevel2usecases.search_arealevel2_count(arealevel2search));
        return jsonsearchcount.toJSONString();
    }

    private void insert_arealevel2(Arealevel2_usecases arealevel2usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel2 arealevel2 = (IArealevel2)JSONArealevel2.toArealevel2((JSONObject)json.get("arealevel2"));
        arealevel2usecases.insertArealevel2(arealevel2);
        setReturnstatus("OK");
    }

    private void update_arealevel2(Arealevel2_usecases arealevel2usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel2 arealevel2 = (IArealevel2)JSONArealevel2.toArealevel2((JSONObject)json.get("arealevel2"));
        arealevel2usecases.updateArealevel2(arealevel2);
        setReturnstatus("OK");
    }

    private void delete_arealevel2(Arealevel2_usecases arealevel2usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel2 arealevel2 = (IArealevel2)JSONArealevel2.toArealevel2((JSONObject)json.get("arealevel2"));
        arealevel2usecases.deleteArealevel2(arealevel2);
        setReturnstatus("OK");
    }

    private void delete_all_containing_Arealevel1(Arealevel2_usecases arealevel2usecases, JSONObject json) throws ParseException, CustomException {
        IArealevel1PK arealevel1PK = (IArealevel1PK)JSONArealevel1.toArealevel1PK((JSONObject)json.get("arealevel1pk"));
        arealevel2usecases.delete_all_containing_Arealevel1(arealevel1PK);
        setReturnstatus("OK");
    }

}

