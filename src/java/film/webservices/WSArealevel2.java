package film.webservices;

import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.webservice.WSIArealevel2;
import film.logicentity.Arealevel2;
import film.searchentity.Arealevel2search;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIArealevel2")
public class WSArealevel2 implements WSIArealevel2 {

    private JSONArray toJSONArray(ArrayList arealevel2s) {
        JSONArray jsonarealevel2s = new JSONArray();
        Iterator arealevel2sI = arealevel2s.iterator();
        while(arealevel2sI.hasNext()) {
            jsonarealevel2s.add(JSONArealevel2.toJSON((Arealevel2)arealevel2sI.next()));
        }
        return jsonarealevel2s;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getArealevel2s")
    @Override
    public String getArealevel2s() {
        try {
            BLarealevel2 blarealevel2 = new BLarealevel2();
            ArrayList arealevel2s = blarealevel2.getAll();
            JSONArray jsonarealevel2s = toJSONArray(arealevel2s);
            return jsonarealevel2s.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLarealevel2 blarealevel2 = new BLarealevel2();
        JSONParser parser = new JSONParser();
        String result = "";
        Arealevel2 arealevel2;
        try {
            Arealevel2search arealevel2search = JSONArealevel2.toArealevel2search((JSONObject)parser.parse(json));
            ArrayList arealevel2s = blarealevel2.search(arealevel2search);
            JSONArray jsonarealevel2s = toJSONArray(arealevel2s);
            result = jsonarealevel2s.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getArealevel2")
    @Override
    public String getArealevel2(String json) {
        BLarealevel2 blarealevel2 = new BLarealevel2();
        JSONParser parser = new JSONParser();
        String result = "";
        Arealevel2 arealevel2;
        try {
            Arealevel2PK arealevel2PK = JSONArealevel2.toArealevel2PK((JSONObject)parser.parse(json));
            arealevel2 = blarealevel2.getArealevel2(arealevel2PK);
            if(arealevel2!=null) {
                result = JSONArealevel2.toJSON(arealevel2).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertArealevel2")
    @Override
    public void insertArealevel2(String json) {
        BLarealevel2 blarealevel2 = new BLarealevel2();
        JSONParser parser = new JSONParser();
        try {
            IArealevel2 arealevel2 = JSONArealevel2.toArealevel2((JSONObject)parser.parse(json));
            blarealevel2.insertArealevel2(arealevel2);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateArealevel2")
    @Override
    public void updateArealevel2(String json) {
        BLarealevel2 blarealevel2 = new BLarealevel2();
        JSONParser parser = new JSONParser();
        try {
            IArealevel2 arealevel2 = JSONArealevel2.toArealevel2((JSONObject)parser.parse(json));
            blarealevel2.updateArealevel2(arealevel2);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteArealevel2")
    @Override
    public void deleteArealevel2(String json) {
        BLarealevel2 blarealevel2 = new BLarealevel2();
        JSONParser parser = new JSONParser();
        try {
            IArealevel2 arealevel2 = JSONArealevel2.toArealevel2((JSONObject)parser.parse(json));
            blarealevel2.deleteArealevel2(arealevel2);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getArealevel2s4arealevel1")
    @Override
    public String getArealevel2s4arealevel1(String json) {
        BLarealevel2 blarealevel2 = new BLarealevel2();
        JSONParser parser = new JSONParser();
        Arealevel2 arealevel2;
        try {
            IArealevel1PK arealevel1PK = JSONArealevel1.toArealevel1PK((JSONObject)parser.parse(json));
            ArrayList arealevel2s = blarealevel2.getArealevel2s4arealevel1(arealevel1PK);
            JSONArray jsonarealevel2s = toJSONArray(arealevel2s);
            return jsonarealevel2s.toJSONString();
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

    //@WebMethod(operationName = "delete4arealevel1")
    @Override
    public void delete4arealevel1(String json) {
        BLarealevel2 blarealevel2 = new BLarealevel2();
        JSONParser parser = new JSONParser();
        Arealevel2 arealevel2;
        try {
            IArealevel1PK arealevel1PK = JSONArealevel1.toArealevel1PK((JSONObject)parser.parse(json));
            blarealevel2.delete4arealevel1(this.getClass().getName(), arealevel1PK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getArealevel2s4arealevel3")
    @Override
    public String getArealevel2s4arealevel3(String json) {
        BLarealevel2 blarealevel2 = new BLarealevel2();
        JSONParser parser = new JSONParser();
        Arealevel2 arealevel2;
        try {
            String result = null;
            IArealevel3PK arealevel3PK = JSONArealevel3.toArealevel3PK((JSONObject)parser.parse(json));
            arealevel2 = (Arealevel2)blarealevel2.getArealevel3(arealevel3PK);
            if(arealevel2!=null) {
                result = JSONArealevel2.toJSON(arealevel2).toJSONString();
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

