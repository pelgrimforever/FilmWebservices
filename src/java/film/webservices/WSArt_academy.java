/*
 * WSArt_academy.java
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
import film.interfaces.webservice.WSIArt_academy;
import film.logicentity.Art_academy;
import film.searchentity.Art_academysearch;
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
@WebService(endpointInterface = "film.interfaces.webservice.WSIArt_academy")
public class WSArt_academy implements WSIArt_academy {

    private JSONArray toJSONArray(ArrayList art_academys) {
        JSONArray jsonart_academys = new JSONArray();
        Iterator art_academysI = art_academys.iterator();
        while(art_academysI.hasNext()) {
            jsonart_academys.add(JSONArt_academy.toJSON((Art_academy)art_academysI.next()));
        }
        return jsonart_academys;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getArt_academys")
    @Override
    public String getArt_academys() {
        try {
            BLart_academy blart_academy = new BLart_academy();
            ArrayList art_academys = blart_academy.getAll();
            JSONArray jsonart_academys = toJSONArray(art_academys);
            return jsonart_academys.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLart_academy blart_academy = new BLart_academy();
        JSONParser parser = new JSONParser();
        String result = "";
        Art_academy art_academy;
        try {
            Art_academysearch art_academysearch = JSONArt_academy.toArt_academysearch((JSONObject)parser.parse(json));
            ArrayList art_academys = blart_academy.search(art_academysearch);
            JSONArray jsonart_academys = toJSONArray(art_academys);
            result = jsonart_academys.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getArt_academy")
    @Override
    public String getArt_academy(String json) {
        BLart_academy blart_academy = new BLart_academy();
        JSONParser parser = new JSONParser();
        String result = "";
        Art_academy art_academy;
        try {
            Art_academyPK art_academyPK = JSONArt_academy.toArt_academyPK((JSONObject)parser.parse(json));
            art_academy = blart_academy.getArt_academy(art_academyPK);
            if(art_academy!=null) {
                result = JSONArt_academy.toJSON(art_academy).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertArt_academy")
    @Override
    public void insertArt_academy(String json) {
        BLart_academy blart_academy = new BLart_academy();
        JSONParser parser = new JSONParser();
        try {
            IArt_academy art_academy = JSONArt_academy.toArt_academy((JSONObject)parser.parse(json));
            blart_academy.insertArt_academy(art_academy);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateArt_academy")
    @Override
    public void updateArt_academy(String json) {
        BLart_academy blart_academy = new BLart_academy();
        JSONParser parser = new JSONParser();
        try {
            IArt_academy art_academy = JSONArt_academy.toArt_academy((JSONObject)parser.parse(json));
            blart_academy.updateArt_academy(art_academy);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteArt_academy")
    @Override
    public void deleteArt_academy(String json) {
        BLart_academy blart_academy = new BLart_academy();
        JSONParser parser = new JSONParser();
        try {
            IArt_academy art_academy = JSONArt_academy.toArt_academy((JSONObject)parser.parse(json));
            blart_academy.deleteArt_academy(art_academy);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }


}

