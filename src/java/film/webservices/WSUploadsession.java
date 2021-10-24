/*
 * WSUploadsession.java
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
import film.interfaces.webservice.WSIUploadsession;
import film.logicentity.Uploadsession;
import film.searchentity.Uploadsessionsearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIUploadsession")
public class WSUploadsession implements WSIUploadsession {

    private JSONArray toJSONArray(ArrayList uploadsessions) {
        JSONArray jsonuploadsessions = new JSONArray();
        Iterator uploadsessionsI = uploadsessions.iterator();
        while(uploadsessionsI.hasNext()) {
            jsonuploadsessions.add(JSONUploadsession.toJSON((Uploadsession)uploadsessionsI.next()));
        }
        return jsonuploadsessions;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getUploadsessions")
    @Override
    public String getUploadsessions() {
        try {
            BLuploadsession bluploadsession = new BLuploadsession();
            ArrayList uploadsessions = bluploadsession.getAll();
            JSONArray jsonuploadsessions = toJSONArray(uploadsessions);
            return jsonuploadsessions.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLuploadsession bluploadsession = new BLuploadsession();
        JSONParser parser = new JSONParser();
        String result = "";
        Uploadsession uploadsession;
        try {
            Uploadsessionsearch uploadsessionsearch = JSONUploadsession.toUploadsessionsearch((JSONObject)parser.parse(json));
            ArrayList uploadsessions = bluploadsession.search(uploadsessionsearch);
            JSONArray jsonuploadsessions = toJSONArray(uploadsessions);
            result = jsonuploadsessions.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getUploadsession")
    @Override
    public String getUploadsession(String json) {
        BLuploadsession bluploadsession = new BLuploadsession();
        JSONParser parser = new JSONParser();
        String result = "";
        Uploadsession uploadsession;
        try {
            UploadsessionPK uploadsessionPK = JSONUploadsession.toUploadsessionPK((JSONObject)parser.parse(json));
            uploadsession = bluploadsession.getUploadsession(uploadsessionPK);
            if(uploadsession!=null) {
                result = JSONUploadsession.toJSON(uploadsession).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertUploadsession")
    @Override
    public void insertUploadsession(String json) {
        BLuploadsession bluploadsession = new BLuploadsession();
        JSONParser parser = new JSONParser();
        try {
            IUploadsession uploadsession = JSONUploadsession.toUploadsession((JSONObject)parser.parse(json));
            bluploadsession.insertUploadsession(uploadsession);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateUploadsession")
    @Override
    public void updateUploadsession(String json) {
        BLuploadsession bluploadsession = new BLuploadsession();
        JSONParser parser = new JSONParser();
        try {
            IUploadsession uploadsession = JSONUploadsession.toUploadsession((JSONObject)parser.parse(json));
            bluploadsession.updateUploadsession(uploadsession);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteUploadsession")
    @Override
    public void deleteUploadsession(String json) {
        BLuploadsession bluploadsession = new BLuploadsession();
        JSONParser parser = new JSONParser();
        try {
            IUploadsession uploadsession = JSONUploadsession.toUploadsession((JSONObject)parser.parse(json));
            bluploadsession.deleteUploadsession(uploadsession);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getUploadsessions4creator")
    @Override
    public String getUploadsessions4creator(String json) {
        BLuploadsession bluploadsession = new BLuploadsession();
        JSONParser parser = new JSONParser();
        Uploadsession uploadsession;
        try {
            ICreatorPK creatorPK = JSONCreator.toCreatorPK((JSONObject)parser.parse(json));
            ArrayList uploadsessions = bluploadsession.getUploadsessions4creator(creatorPK);
            JSONArray jsonuploadsessions = toJSONArray(uploadsessions);
            return jsonuploadsessions.toJSONString();
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

    //@WebMethod(operationName = "delete4creator")
    @Override
    public void delete4creator(String json) {
        BLuploadsession bluploadsession = new BLuploadsession();
        JSONParser parser = new JSONParser();
        Uploadsession uploadsession;
        try {
            ICreatorPK creatorPK = JSONCreator.toCreatorPK((JSONObject)parser.parse(json));
            bluploadsession.delete4creator(creatorPK);
        }
        catch(ParseException e) {
        }
    }


}

