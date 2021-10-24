/*
 * WSMainmenu.java
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
import film.interfaces.webservice.WSIMainmenu;
import film.logicentity.Mainmenu;
import film.searchentity.Mainmenusearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIMainmenu")
public class WSMainmenu implements WSIMainmenu {

    private JSONArray toJSONArray(ArrayList mainmenus) {
        JSONArray jsonmainmenus = new JSONArray();
        Iterator mainmenusI = mainmenus.iterator();
        while(mainmenusI.hasNext()) {
            jsonmainmenus.add(JSONMainmenu.toJSON((Mainmenu)mainmenusI.next()));
        }
        return jsonmainmenus;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getMainmenus")
    @Override
    public String getMainmenus() {
        try {
            BLmainmenu blmainmenu = new BLmainmenu();
            ArrayList mainmenus = blmainmenu.getAll();
            JSONArray jsonmainmenus = toJSONArray(mainmenus);
            return jsonmainmenus.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLmainmenu blmainmenu = new BLmainmenu();
        JSONParser parser = new JSONParser();
        String result = "";
        Mainmenu mainmenu;
        try {
            Mainmenusearch mainmenusearch = JSONMainmenu.toMainmenusearch((JSONObject)parser.parse(json));
            ArrayList mainmenus = blmainmenu.search(mainmenusearch);
            JSONArray jsonmainmenus = toJSONArray(mainmenus);
            result = jsonmainmenus.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getMainmenu")
    @Override
    public String getMainmenu(String json) {
        BLmainmenu blmainmenu = new BLmainmenu();
        JSONParser parser = new JSONParser();
        String result = "";
        Mainmenu mainmenu;
        try {
            MainmenuPK mainmenuPK = JSONMainmenu.toMainmenuPK((JSONObject)parser.parse(json));
            mainmenu = blmainmenu.getMainmenu(mainmenuPK);
            if(mainmenu!=null) {
                result = JSONMainmenu.toJSON(mainmenu).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertMainmenu")
    @Override
    public void insertMainmenu(String json) {
        BLmainmenu blmainmenu = new BLmainmenu();
        JSONParser parser = new JSONParser();
        try {
            IMainmenu mainmenu = JSONMainmenu.toMainmenu((JSONObject)parser.parse(json));
            blmainmenu.insertMainmenu(mainmenu);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateMainmenu")
    @Override
    public void updateMainmenu(String json) {
        BLmainmenu blmainmenu = new BLmainmenu();
        JSONParser parser = new JSONParser();
        try {
            IMainmenu mainmenu = JSONMainmenu.toMainmenu((JSONObject)parser.parse(json));
            blmainmenu.updateMainmenu(mainmenu);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteMainmenu")
    @Override
    public void deleteMainmenu(String json) {
        BLmainmenu blmainmenu = new BLmainmenu();
        JSONParser parser = new JSONParser();
        try {
            IMainmenu mainmenu = JSONMainmenu.toMainmenu((JSONObject)parser.parse(json));
            blmainmenu.deleteMainmenu(mainmenu);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getMainmenus4menu")
    @Override
    public String getMainmenus4menu(String json) {
        BLmainmenu blmainmenu = new BLmainmenu();
        JSONParser parser = new JSONParser();
        Mainmenu mainmenu;
        try {
            String result = null;
            IMenuPK menuPK = JSONMenu.toMenuPK((JSONObject)parser.parse(json));
            mainmenu = (Mainmenu)blmainmenu.getMenu(menuPK);
            if(mainmenu!=null) {
                result = JSONMainmenu.toJSON(mainmenu).toJSONString();
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

