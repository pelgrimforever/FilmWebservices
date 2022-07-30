/*
 * WSMainmenu.java
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
import film.interfaces.searchentity.IMainmenusearch;
import film.interfaces.webservice.WSIMainmenu;
import film.logicentity.Mainmenu;
import film.searchentity.Mainmenusearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIMainmenu")
public class WSMainmenu extends RS_json_login implements WSIMainmenu {

    private Security_usecases security_usecases = new Security_usecases();
    
    private JSONArray toJSONArray(ArrayList mainmenus) {
        JSONArray jsonmainmenus = new JSONArray();
        Iterator mainmenusI = mainmenus.iterator();
        while(mainmenusI.hasNext()) {
            jsonmainmenus.add(JSONMainmenu.toJSON((Mainmenu)mainmenusI.next()));
        }
        return jsonmainmenus;
    }

    //@WebMethod(operationName = "getMainmenus")
    @Override
    public String getMainmenus() {
        try {
            Mainmenu_usecases mainmenuusecases = new Mainmenu_usecases(loggedin);
            return get_all_mainmenu(mainmenuusecases);
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
            Mainmenu_usecases mainmenuusecases = new Mainmenu_usecases(loggedin);
            return search_mainmenu(mainmenuusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getMainmenu")
    @Override
    public String getMainmenu(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Mainmenu_usecases mainmenuusecases = new Mainmenu_usecases(loggedin);
            return get_mainmenu_with_primarykey(mainmenuusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "insertMainmenu")
    @Override
    public void insertMainmenu(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Mainmenu_usecases mainmenuusecases = new Mainmenu_usecases(loggedin);
            insert_mainmenu(mainmenuusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "updateMainmenu")
    @Override
    public void updateMainmenu(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Mainmenu_usecases mainmenuusecases = new Mainmenu_usecases(loggedin);
            update_mainmenu(mainmenuusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "deleteMainmenu")
    @Override
    public void deleteMainmenu(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Mainmenu_usecases mainmenuusecases = new Mainmenu_usecases(loggedin);
            delete_mainmenu(mainmenuusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
        }
    }

    //@WebMethod(operationName = "getMainmenus4menu")
    @Override
    public String getMainmenus4menu(String jsonstring) {
        try {
            Consume_jsonstring(jsonstring);
            setLoggedin(security_usecases.check_authorization(authorisationstring));
            Mainmenu_usecases mainmenuusecases = new Mainmenu_usecases(loggedin);
            return get_mainmenu_with_externalforeignkey_menu(mainmenuusecases, json);
        }
        catch(CustomException | IOException | ParseException e) {
            return null;
        }
    }


    private String count_records(Mainmenu_usecases mainmenuusecases) throws ParseException, CustomException {
        JSONObject jsoncount = new JSONObject();
        jsoncount.put("recordcount", mainmenuusecases.count());
        return jsoncount.toJSONString();
    }
    
    private String get_all_mainmenu(Mainmenu_usecases mainmenuusecases) throws ParseException, CustomException {
    	return JSONMainmenu.toJSONArray(mainmenuusecases.get_all()).toJSONString();
    }
    
    private String get_mainmenu_with_primarykey(Mainmenu_usecases mainmenuusecases, JSONObject json) throws ParseException, CustomException {
        IMainmenuPK mainmenuPK = (IMainmenuPK)JSONMainmenu.toMainmenuPK((JSONObject)json.get("mainmenupk"));
	return JSONMainmenu.toJSON(mainmenuusecases.get_mainmenu_by_primarykey(mainmenuPK)).toJSONString();
    }
    
    private String get_mainmenu_with_externalforeignkey_menu(Mainmenu_usecases mainmenuusecases, JSONObject json) throws ParseException, CustomException {
        IMenuPK menuPK = (IMenuPK)JSONMenu.toMenuPK((JSONObject)json.get("menupk"));
        return JSONMainmenu.toJSON(mainmenuusecases.get_mainmenu_with_externalforeignkey_menu(menuPK)).toJSONString();
    }
    
    private String search_mainmenu(Mainmenu_usecases mainmenuusecases, JSONObject json) throws ParseException, CustomException {
        IMainmenusearch search = (IMainmenusearch)JSONMainmenu.toMainmenusearch((JSONObject)json.get("search"));
        return JSONMainmenu.toJSONArray(mainmenuusecases.search_mainmenu(search)).toJSONString();
    }
    
    private String search_mainmenu_count(Mainmenu_usecases mainmenuusecases, JSONObject json) throws ParseException, CustomException {
        IMainmenusearch mainmenusearch = (IMainmenusearch)JSONMainmenu.toMainmenusearch((JSONObject)json.get("search"));
        JSONObject jsonsearchcount = new JSONObject();
        jsonsearchcount.put("recordcount", mainmenuusecases.search_mainmenu_count(mainmenusearch));
        return jsonsearchcount.toJSONString();
    }

    private void insert_mainmenu(Mainmenu_usecases mainmenuusecases, JSONObject json) throws ParseException, CustomException {
        IMainmenu mainmenu = (IMainmenu)JSONMainmenu.toMainmenu((JSONObject)json.get("mainmenu"));
        mainmenuusecases.insertMainmenu(mainmenu);
        setReturnstatus("OK");
    }

    private void update_mainmenu(Mainmenu_usecases mainmenuusecases, JSONObject json) throws ParseException, CustomException {
        IMainmenu mainmenu = (IMainmenu)JSONMainmenu.toMainmenu((JSONObject)json.get("mainmenu"));
        mainmenuusecases.updateMainmenu(mainmenu);
        setReturnstatus("OK");
    }

    private void delete_mainmenu(Mainmenu_usecases mainmenuusecases, JSONObject json) throws ParseException, CustomException {
        IMainmenu mainmenu = (IMainmenu)JSONMainmenu.toMainmenu((JSONObject)json.get("mainmenu"));
        mainmenuusecases.deleteMainmenu(mainmenu);
        setReturnstatus("OK");
    }

}

