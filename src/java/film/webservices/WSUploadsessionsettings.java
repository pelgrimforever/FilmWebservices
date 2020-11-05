package film.webservices;

import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.webservice.WSIUploadsessionsettings;
import film.logicentity.Uploadsessionsettings;
import film.searchentity.Uploadsessionsettingssearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIUploadsessionsettings")
public class WSUploadsessionsettings implements WSIUploadsessionsettings {

    private JSONArray toJSONArray(ArrayList uploadsessionsettingss) {
        JSONArray jsonuploadsessionsettingss = new JSONArray();
        Iterator uploadsessionsettingssI = uploadsessionsettingss.iterator();
        while(uploadsessionsettingssI.hasNext()) {
            jsonuploadsessionsettingss.add(JSONUploadsessionsettings.toJSON((Uploadsessionsettings)uploadsessionsettingssI.next()));
        }
        return jsonuploadsessionsettingss;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getUploadsessionsettingss")
    @Override
    public String getUploadsessionsettingss() {
        try {
            BLuploadsessionsettings bluploadsessionsettings = new BLuploadsessionsettings();
            ArrayList uploadsessionsettingss = bluploadsessionsettings.getAll();
            JSONArray jsonuploadsessionsettingss = toJSONArray(uploadsessionsettingss);
            return jsonuploadsessionsettingss.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLuploadsessionsettings bluploadsessionsettings = new BLuploadsessionsettings();
        JSONParser parser = new JSONParser();
        String result = "";
        Uploadsessionsettings uploadsessionsettings;
        try {
            Uploadsessionsettingssearch uploadsessionsettingssearch = JSONUploadsessionsettings.toUploadsessionsettingssearch((JSONObject)parser.parse(json));
            ArrayList uploadsessionsettingss = bluploadsessionsettings.search(uploadsessionsettingssearch);
            JSONArray jsonuploadsessionsettingss = toJSONArray(uploadsessionsettingss);
            result = jsonuploadsessionsettingss.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getUploadsessionsettings")
    @Override
    public String getUploadsessionsettings(String json) {
        BLuploadsessionsettings bluploadsessionsettings = new BLuploadsessionsettings();
        JSONParser parser = new JSONParser();
        String result = "";
        Uploadsessionsettings uploadsessionsettings;
        try {
            UploadsessionsettingsPK uploadsessionsettingsPK = JSONUploadsessionsettings.toUploadsessionsettingsPK((JSONObject)parser.parse(json));
            uploadsessionsettings = bluploadsessionsettings.getUploadsessionsettings(uploadsessionsettingsPK);
            if(uploadsessionsettings!=null) {
                result = JSONUploadsessionsettings.toJSON(uploadsessionsettings).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertUploadsessionsettings")
    @Override
    public void insertUploadsessionsettings(String json) {
        BLuploadsessionsettings bluploadsessionsettings = new BLuploadsessionsettings();
        JSONParser parser = new JSONParser();
        try {
            IUploadsessionsettings uploadsessionsettings = JSONUploadsessionsettings.toUploadsessionsettings((JSONObject)parser.parse(json));
            bluploadsessionsettings.insertUploadsessionsettings(uploadsessionsettings);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateUploadsessionsettings")
    @Override
    public void updateUploadsessionsettings(String json) {
        BLuploadsessionsettings bluploadsessionsettings = new BLuploadsessionsettings();
        JSONParser parser = new JSONParser();
        try {
            IUploadsessionsettings uploadsessionsettings = JSONUploadsessionsettings.toUploadsessionsettings((JSONObject)parser.parse(json));
            bluploadsessionsettings.updateUploadsessionsettings(uploadsessionsettings);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteUploadsessionsettings")
    @Override
    public void deleteUploadsessionsettings(String json) {
        BLuploadsessionsettings bluploadsessionsettings = new BLuploadsessionsettings();
        JSONParser parser = new JSONParser();
        try {
            IUploadsessionsettings uploadsessionsettings = JSONUploadsessionsettings.toUploadsessionsettings((JSONObject)parser.parse(json));
            bluploadsessionsettings.deleteUploadsessionsettings(uploadsessionsettings);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }


}

