/*
 * WSArealevel3.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 *
 */

package film.webservices;

import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.webservice.WSIArealevel3;
import film.logicentity.Arealevel3;
import film.searchentity.Arealevel3search;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIArealevel3")
public class WSArealevel3 implements WSIArealevel3 {

    private JSONArray toJSONArray(ArrayList arealevel3s) {
        JSONArray jsonarealevel3s = new JSONArray();
        Iterator arealevel3sI = arealevel3s.iterator();
        while(arealevel3sI.hasNext()) {
            jsonarealevel3s.add(JSONArealevel3.toJSON((Arealevel3)arealevel3sI.next()));
        }
        return jsonarealevel3s;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getArealevel3s")
    @Override
    public String getArealevel3s() {
        try {
            BLarealevel3 blarealevel3 = new BLarealevel3();
            ArrayList arealevel3s = blarealevel3.getAll();
            JSONArray jsonarealevel3s = toJSONArray(arealevel3s);
            return jsonarealevel3s.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLarealevel3 blarealevel3 = new BLarealevel3();
        JSONParser parser = new JSONParser();
        String result = "";
        Arealevel3 arealevel3;
        try {
            Arealevel3search arealevel3search = JSONArealevel3.toArealevel3search((JSONObject)parser.parse(json));
            ArrayList arealevel3s = blarealevel3.search(arealevel3search);
            JSONArray jsonarealevel3s = toJSONArray(arealevel3s);
            result = jsonarealevel3s.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getArealevel3")
    @Override
    public String getArealevel3(String json) {
        BLarealevel3 blarealevel3 = new BLarealevel3();
        JSONParser parser = new JSONParser();
        String result = "";
        Arealevel3 arealevel3;
        try {
            Arealevel3PK arealevel3PK = JSONArealevel3.toArealevel3PK((JSONObject)parser.parse(json));
            arealevel3 = blarealevel3.getArealevel3(arealevel3PK);
            if(arealevel3!=null) {
                result = JSONArealevel3.toJSON(arealevel3).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertArealevel3")
    @Override
    public void insertArealevel3(String json) {
        BLarealevel3 blarealevel3 = new BLarealevel3();
        JSONParser parser = new JSONParser();
        try {
            IArealevel3 arealevel3 = JSONArealevel3.toArealevel3((JSONObject)parser.parse(json));
            blarealevel3.insertArealevel3(arealevel3);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateArealevel3")
    @Override
    public void updateArealevel3(String json) {
        BLarealevel3 blarealevel3 = new BLarealevel3();
        JSONParser parser = new JSONParser();
        try {
            IArealevel3 arealevel3 = JSONArealevel3.toArealevel3((JSONObject)parser.parse(json));
            blarealevel3.updateArealevel3(arealevel3);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteArealevel3")
    @Override
    public void deleteArealevel3(String json) {
        BLarealevel3 blarealevel3 = new BLarealevel3();
        JSONParser parser = new JSONParser();
        try {
            IArealevel3 arealevel3 = JSONArealevel3.toArealevel3((JSONObject)parser.parse(json));
            blarealevel3.deleteArealevel3(arealevel3);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getArealevel3s4arealevel2")
    @Override
    public String getArealevel3s4arealevel2(String json) {
        BLarealevel3 blarealevel3 = new BLarealevel3();
        JSONParser parser = new JSONParser();
        Arealevel3 arealevel3;
        try {
            IArealevel2PK arealevel2PK = JSONArealevel2.toArealevel2PK((JSONObject)parser.parse(json));
            ArrayList arealevel3s = blarealevel3.getArealevel3s4arealevel2(arealevel2PK);
            JSONArray jsonarealevel3s = toJSONArray(arealevel3s);
            return jsonarealevel3s.toJSONString();
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

    //@WebMethod(operationName = "delete4arealevel2")
    @Override
    public void delete4arealevel2(String json) {
        BLarealevel3 blarealevel3 = new BLarealevel3();
        JSONParser parser = new JSONParser();
        Arealevel3 arealevel3;
        try {
            IArealevel2PK arealevel2PK = JSONArealevel2.toArealevel2PK((JSONObject)parser.parse(json));
            blarealevel3.delete4arealevel2(arealevel2PK);
        }
        catch(ParseException e) {
        }
    }


}

