/*
 * WSArealevel1.java
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
import film.interfaces.webservice.WSIArealevel1;
import film.logicentity.Arealevel1;
import film.searchentity.Arealevel1search;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIArealevel1")
public class WSArealevel1 implements WSIArealevel1 {

    private JSONArray toJSONArray(ArrayList arealevel1s) {
        JSONArray jsonarealevel1s = new JSONArray();
        Iterator arealevel1sI = arealevel1s.iterator();
        while(arealevel1sI.hasNext()) {
            jsonarealevel1s.add(JSONArealevel1.toJSON((Arealevel1)arealevel1sI.next()));
        }
        return jsonarealevel1s;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getArealevel1s")
    @Override
    public String getArealevel1s() {
        try {
            BLarealevel1 blarealevel1 = new BLarealevel1();
            ArrayList arealevel1s = blarealevel1.getAll();
            JSONArray jsonarealevel1s = toJSONArray(arealevel1s);
            return jsonarealevel1s.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLarealevel1 blarealevel1 = new BLarealevel1();
        JSONParser parser = new JSONParser();
        String result = "";
        Arealevel1 arealevel1;
        try {
            Arealevel1search arealevel1search = JSONArealevel1.toArealevel1search((JSONObject)parser.parse(json));
            ArrayList arealevel1s = blarealevel1.search(arealevel1search);
            JSONArray jsonarealevel1s = toJSONArray(arealevel1s);
            result = jsonarealevel1s.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getArealevel1")
    @Override
    public String getArealevel1(String json) {
        BLarealevel1 blarealevel1 = new BLarealevel1();
        JSONParser parser = new JSONParser();
        String result = "";
        Arealevel1 arealevel1;
        try {
            Arealevel1PK arealevel1PK = JSONArealevel1.toArealevel1PK((JSONObject)parser.parse(json));
            arealevel1 = blarealevel1.getArealevel1(arealevel1PK);
            if(arealevel1!=null) {
                result = JSONArealevel1.toJSON(arealevel1).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertArealevel1")
    @Override
    public void insertArealevel1(String json) {
        BLarealevel1 blarealevel1 = new BLarealevel1();
        JSONParser parser = new JSONParser();
        try {
            IArealevel1 arealevel1 = JSONArealevel1.toArealevel1((JSONObject)parser.parse(json));
            blarealevel1.insertArealevel1(arealevel1);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateArealevel1")
    @Override
    public void updateArealevel1(String json) {
        BLarealevel1 blarealevel1 = new BLarealevel1();
        JSONParser parser = new JSONParser();
        try {
            IArealevel1 arealevel1 = JSONArealevel1.toArealevel1((JSONObject)parser.parse(json));
            blarealevel1.updateArealevel1(arealevel1);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteArealevel1")
    @Override
    public void deleteArealevel1(String json) {
        BLarealevel1 blarealevel1 = new BLarealevel1();
        JSONParser parser = new JSONParser();
        try {
            IArealevel1 arealevel1 = JSONArealevel1.toArealevel1((JSONObject)parser.parse(json));
            blarealevel1.deleteArealevel1(arealevel1);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getArealevel1s4country")
    @Override
    public String getArealevel1s4country(String json) {
        BLarealevel1 blarealevel1 = new BLarealevel1();
        JSONParser parser = new JSONParser();
        Arealevel1 arealevel1;
        try {
            ICountryPK countryPK = JSONCountry.toCountryPK((JSONObject)parser.parse(json));
            ArrayList arealevel1s = blarealevel1.getArealevel1s4country(countryPK);
            JSONArray jsonarealevel1s = toJSONArray(arealevel1s);
            return jsonarealevel1s.toJSONString();
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

    //@WebMethod(operationName = "delete4country")
    @Override
    public void delete4country(String json) {
        BLarealevel1 blarealevel1 = new BLarealevel1();
        JSONParser parser = new JSONParser();
        Arealevel1 arealevel1;
        try {
            ICountryPK countryPK = JSONCountry.toCountryPK((JSONObject)parser.parse(json));
            blarealevel1.delete4country(countryPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getArealevel1s4arealevel2")
    @Override
    public String getArealevel1s4arealevel2(String json) {
        BLarealevel1 blarealevel1 = new BLarealevel1();
        JSONParser parser = new JSONParser();
        Arealevel1 arealevel1;
        try {
            String result = null;
            IArealevel2PK arealevel2PK = JSONArealevel2.toArealevel2PK((JSONObject)parser.parse(json));
            arealevel1 = (Arealevel1)blarealevel1.getArealevel2(arealevel2PK);
            if(arealevel1!=null) {
                result = JSONArealevel1.toJSON(arealevel1).toJSONString();
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

